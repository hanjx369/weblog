<script setup>
import { ref, reactive, watch } from 'vue'
import { useMenuStore } from '@/stores/menu'
import { useFullscreen } from '@vueuse/core'
import { useUserStore } from '@/stores/user'
import { showMessage, showModel } from '@/composables/util'
import { useRouter } from 'vue-router'
import { updateAdminPassword } from '@/api/admin/user'

const router = useRouter()
// 引入了用户 Store
const userStore = useUserStore()

// 是否全屏，全屏事件
const { isFullscreen, toggle } = useFullscreen()
const menuStore = useMenuStore()

// 监听 Pinia store 中的某个值的变化
watch(
  () => userStore.userInfo.username,
  (newValue) => {
    // 重新将新的值，设置会 form 对象中
    form.username = newValue
  }
)

// icon点击事件
const handleMenuWidth = () => {
  menuStore.handleMenuWidth()
}

// 刷新页面
const handleRefresh = () => location.reload()

// 对话框是否显示
const dialogVisible = ref(false)

const formRef = ref(null)

// 修改用户密码表单对象
const form = reactive({
  username: userStore.userInfo.username || '',
  password: '',
  rePassword: ''
})

// 规则校验
const rules = {
  username: [
    {
      required: true,
      message: '用户名不能为空',
      trigger: 'blur'
    }
  ],
  password: [
    {
      required: true,
      message: '密码不能为空',
      trigger: 'blur'
    }
  ],
  rePassword: [
    {
      required: true,
      message: '确认密码不能为空',
      trigger: 'blur'
    }
  ]
}

// 下拉菜单事件处理
const handleCommand = (command) => {
  // 更新密码
  if (command === 'updatePassword') {
    dialogVisible.value = true
  } else if (command === 'logout') {
    // 退出登录
    logout()
  }
}

// 修改密码
const onSubmit = () => {
  // 先验证 form 表单字段
  formRef.value.validate(async (valid) => {
    if (valid) {
      if (form.password != form.rePassword) {
        showMessage('两次密码输入不一致，请检查！', 'warning')
      } else {
        // 调用修改用户密码接口
        await updateAdminPassword(form).then((res) => {
          // 判断是否成功
          if (res.success == true) {
            showMessage('密码重置成功，请重新登录！')
            // 退出登录
            userStore.logout()
            // 隐藏对话框
            dialogVisible.value = false
            // 跳转登录页
            router.push('/login')
          }
        })
      }
    }
  })
}

// 退出登录
function logout() {
  showModel('是否确认要退出登录？').then(async () => {
    await userStore.logout()
    showMessage('退出登录成功！')
    // 跳转登录页
    router.push('/login')
  })
}
</script>
<template>
  <!-- 通过 flex 指定水平布局 -->
  <div class="bg-white h-[64px] flex pr-4 border-b border-slate-100">
    <!-- 左边栏收缩、展开 -->
    <div
      class="w-[42px] h-[64px] cursor-pointer flex items-center justify-center text-gray-700 hover:bg-gray-200"
      @click="handleMenuWidth"
    >
      <el-icon>
        <Fold v-if="menuStore.menuWidth == '250px'" />
        <Expand v-else />
      </el-icon>
    </div>

    <!-- 右边容器，通过 ml-auto 让其在父容器的右边 -->
    <div class="ml-auto flex">
      <!-- 点击刷新页面 -->
      <el-tooltip class="box-item" effect="dark" content="刷新" placement="bottom">
        <div
          class="w-[42px] h-[64px] cursor-pointer flex items-center justify-center text-gray-700 hover:bg-gray-200"
          @click="handleRefresh"
        >
          <el-icon>
            <Refresh />
          </el-icon>
        </div>
      </el-tooltip>
      <!-- 点击全屏展示 -->
      <el-tooltip class="box-item" effect="dark" content="全屏" placement="bottom">
        <div
          class="w-[42px] h-[64px] cursor-pointer flex items-center justify-center text-gray-700 mr-2 hover:bg-gray-200"
          @click="toggle"
        >
          <el-icon>
            <FullScreen v-if="!isFullscreen" />
            <Aim v-else />
          </el-icon>
        </div>
      </el-tooltip>

      <!-- 登录用户头像 -->
      <el-dropdown class="flex items-center justify-center" @command="handleCommand">
        <span class="el-dropdown-link flex items-center justify-center text-gray-700 text-xs">
          <!-- 头像 Avatar -->
          <el-avatar
            class="mr-2"
            :size="25"
            src="https://p.qqan.com/up/2023-12/20231214845146705.jpg"
          />
          {{ userStore.userInfo.username }}
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="updatePassword">修改密码</el-dropdown-item>
            <el-dropdown-item command="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
  <!-- 修改密码 -->
  <el-dialog
    v-model="dialogVisible"
    title="修改密码"
    width="40%"
    :draggable="true"
    :close-on-click-modal="false"
    :close-on-press-escape="false"
  >
    <el-form ref="formRef" :rules="rules" :model="form">
      <el-form-item label="用户名" prop="username" label-width="120px">
        <!-- 输入框组件 -->
        <el-input
          size="large"
          v-model="form.username"
          placeholder="请输入用户名"
          clearable
          disabled
        />
      </el-form-item>
      <el-form-item label="密码" prop="password" label-width="120px">
        <el-input
          size="large"
          type="password"
          v-model="form.password"
          placeholder="请输入密码"
          clearable
          show-password
        />
      </el-form-item>
      <el-form-item label="确认密码" prop="rePassword" label-width="120px">
        <el-input
          size="large"
          type="password"
          v-model="form.rePassword"
          placeholder="请确认密码"
          clearable
          show-password
        />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="onSubmit"> 提交 </el-button>
      </span>
    </template>
  </el-dialog>
</template>
<style scoped></style>
