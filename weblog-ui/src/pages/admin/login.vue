<script setup>
import { login } from '@/api/admin/user'
import { ref, reactive, onMounted, onBeforeUnmount } from 'vue'
import { useRouter } from 'vue-router'
import { showMessage } from '@/composables/util'
import { setToken } from '@/composables/auth'
const router = useRouter()

// 登录按钮加载
const loading = ref(false)

// 表单对象
const form = reactive({
  username: '',
  password: ''
})

// 表单对象
const formRef = ref(null)

// 表单验证规则
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
  ]
}

// 登录按钮
const onSubmit = () => {
  // 验证表单
  formRef.value.validate(async (valid) => {
    if (valid) {
      loading.value = true
      await login(form.username, form.password)
        .then((res) => {
          if (res.success) {
            showMessage('登陆成功')
            const { token } = res.data
            console.log(token)
            setToken(token)
            router.push('/admin/index')
          }
        })
        .finally(() => {
          loading.value = false
        })
    }
  })
}

// 回车登录
const onKeyUp = (e) => {
  if (e.key === 'Enter') {
    onSubmit()
  }
}

onMounted(() => {
  document.addEventListener('keyup', onKeyUp)
})

onBeforeUnmount(() => {
  document.removeEventListener('keyup', onKeyUp)
})
</script>
<template>
  <!-- 使用 grid 网格布局，并指定列数为 2，高度占满全屏 -->
  <div class="grid grid-cols-2 h-screen">
    <!-- 默认先适配移动端，占两列，order 用于指定排列顺序，md 用于适配非移动端（PC 端）；背景色为黑色 -->
    <div class="col-span-2 order-2 p-10 md:col-span-1 md:order-1 bg-black">
      <div
        class="flex justify-center items-center h-full flex-col animate__animated animate__bounceInLeft animate__fast"
      >
        <h2 class="font-bold text-4xl mb-7 text-white">Weblog 后台登录</h2>
        <img src="@/assets/developer.png" class="w-1/2" />
      </div>
    </div>
    <div class="col-span-2 order-1 md:col-span-1 md:order-2 bg-white">
      <div
        class="flex justify-center items-center h-full flex-col animate__animated animate__bounceInRight animate__fast"
      >
        <h1 class="font-bold text-4xl mb-5">欢迎回来</h1>
        <div class="flex items-center justify-center mb-7 text-gray-400 space-x-2">
          <!-- 左横线 -->
          <span class="h-[1px] w-16 bg-gray-200"></span>
          <span>账号密码登录</span>
          <!-- 右横线 -->
          <span class="h-[1px] w-16 bg-gray-200"></span>
        </div>
        <!-- 引入 Element Plus 表单组件，移动端设置宽度为 5/6，PC 端设置为 2/5 -->
        <el-form ref="formRef" :rules="rules" :model="form" class="w-5/6 md:w-2/5">
          <el-form-item prop="username">
            <!-- 输入框组件 -->
            <el-input size="large" v-model="form.username" placeholder="请输入用户名" clearable>
              <template #prefix>
                <el-icon><User /></el-icon>
              </template>
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <!-- 密码框组件 -->
            <el-input
              size="large"
              type="password"
              v-model="form.password"
              placeholder="请输入密码"
              clearable
              show-password
            >
              <template #prefix>
                <el-icon><Lock /></el-icon>
              </template>
            </el-input>
          </el-form-item>
          <el-form-item>
            <!-- 登录按钮，宽度设置为 100% -->
            <el-button
              class="w-full"
              size="large"
              type="primary"
              :loading="loading"
              @click="onSubmit"
              >登录</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
