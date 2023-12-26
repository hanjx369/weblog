import { createRouter, createWebHashHistory } from 'vue-router'

const Index = () => import('@/pages/frontend/index.vue')
const Login = () => import('@/pages/admin/login.vue')
// 统一在这里声明所有路由
const routes = [
  {
    path: '/', // 路由地址
    component: Index, // 对应组件
    meta: {
      // meta 信息
      title: 'Weblog 首页'
    }
  },
  {
    path: '/login',
    component: Login,
    meta: {
      title: 'Weblog 登录'
    }
  },
  {
    path: '/admin',
    component: () => import('@/layouts/admin/admin.vue'),
    redirect: '/admin/index',
    children: [
      {
        path: '/admin/index',
        component: () => import('@/pages/admin/index.vue'),
        meta: {
          title: '仪表盘'
        }
      },
      {
        path: '/admin/article/list',
        component: () => import('@/pages/admin/article-list.vue'),
        meta: {
          title: '文章管理'
        }
      },
      {
        path: '/admin/category/list',
        component: () => import('@/pages/admin/category-list.vue'),
        meta: {
          title: '分类管理'
        }
      },
      {
        path: '/admin/tag/list',
        component: () => import('@/pages/admin/tag-list.vue'),
        meta: {
          title: '标签管理'
        }
      },
      {
        path: '/admin/blog/setting',
        component: () => import('@/pages/admin/blog-setting.vue'),
        meta: {
          title: '博客设置'
        }
      }
    ]
  },
  {
    path: '/archive/list', // 归档页
    component: () => import('@/pages/frontend/archive-list.vue'),
    meta: {
      // meta 信息
      title: 'Weblog 归档页'
    }
  },
  {
    path: '/category/list', // 分类页
    component: () => import('@/pages/frontend/category-list.vue'),
    meta: {
      // meta 信息
      title: 'Weblog 分类页'
    }
  },
  {
    path: '/category/article/list', // 分类文章页
    component: () => import('@/pages/frontend/category-article-list.vue'),
    meta: {
      // meta 信息
      title: 'Weblog 分类文章页'
    }
  }
]

// 创建路由
const router = createRouter({
  // 指定路由的历史管理方式，hash 模式指的是 URL 的路径是通过 hash 符号（#）进行标识
  history: createWebHashHistory(),
  // routes: routes 的缩写
  routes
})

// ES6 模块导出语句，它用于将 router 对象导出，以便其他文件可以导入和使用这个对象
export default router
