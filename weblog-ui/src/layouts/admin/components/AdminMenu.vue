<script setup>
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useMenuStore } from '@/stores/menu'

const route = useRoute()
const router = useRouter()
const menuStore = useMenuStore()

const menus = [
  {
    name: '仪表盘',
    icon: 'Monitor',
    path: '/admin/index'
  },
  {
    name: '文章管理',
    icon: 'Document',
    path: '/admin/article/list'
  },
  {
    name: '分类管理',
    icon: 'FolderOpened',
    path: '/admin/category/list'
  },
  {
    name: '标签管理',
    icon: 'PriceTag',
    path: '/admin/tag/list'
  },
  {
    name: '博客设置',
    icon: 'Setting',
    path: '/admin/blog/setting'
  }
]

// 根据路由地址判断哪个菜单被选中
const defaultActive = ref(route.path)
// 选则菜单
const handleSelect = (path) => {
  router.push(path)
}

// 是否折叠
const isCollapse = computed(() => !(menuStore.menuWidth === '250px'))
</script>
<template>
  <div
    class="bg-slate-800 h-screen text-white menu-contatiner transition-all"
    :style="{ width: menuStore.menuWidth }"
  >
    <!-- 顶部 Logo, 指定高度为 64px, 和右边的 Header 头保持一样高 -->
    <div class="flex items-center justify-center h-[64px]">
      <span v-if="menuStore.menuWidth == '250px'" class="font-bold text-3xl">Weblog</span>
      <span v-else class="font-bold text-xs">Weblog</span>
    </div>

    <!-- 下方菜单 -->
    <el-menu
      :default-active="defaultActive"
      class="el-menu-vertical-demo"
      @select="handleSelect"
      :collapse="isCollapse"
      :collapse-transition="false"
    >
      <template v-for="(item, index) in menus" :key="index">
        <el-menu-item :index="item.path">
          <el-icon>
            <!-- 动态图标 -->
            <component :is="item.icon"></component>
          </el-icon>
          <span>{{ item.name }}</span>
        </el-menu-item>
      </template>
    </el-menu>
  </div>
</template>
<style>
.el-menu {
  background-color: rgb(30 41 59 / 1);
  border-right: 0;
}

.el-sub-menu__title {
  color: #fff;
}

.el-sub-menu__title:hover {
  background-color: #ffffff10;
}

.el-menu-item.is-active {
  background-color: #222b3c;
  color: #5a9cf8;
}

.el-menu-item.is-active:hover {
  background-color: #273041;
}

.el-menu-item {
  color: #fff;
}

.el-menu-item:hover {
  background-color: #2e3646;
}
</style>
