import router from '@/router'
import { getToken } from '@/composables/cookie'
import { showMessage } from '@/composables/util'
import { showPageLoading, hidePageLoading } from '@/composables/util'

// 全局路由前置守卫
router.beforeEach((to, from, next) => {
  showPageLoading()
  const token = getToken()
  if (!token && to.path.startsWith('/admin')) {
    showMessage('请先登录', 'warning')
    next({ path: '/login' })
  } else if (token && to.path == '/login') {
    // 若用户已经登录，且重复访问登录页
    showMessage('请勿重复登录', 'warning')
    // 跳转后台首页
    next({ path: '/admin/index' })
  } else {
    next()
  }
})

// 全局路由后置守卫
router.afterEach((to) => {
  // 设置页面 title
  const title = (to.meta.title ? to.meta.title : '') + ' - Weblog'
  document.title = title

  hidePageLoading()
})
