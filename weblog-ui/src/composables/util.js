import 'element-plus/es/components/message/style/css'
import nprogress from 'nprogress'
import { ElMessage } from 'element-plus'

export function showMessage(message = '提示内容', type = 'success', customClass = '') {
  return ElMessage({
    type: type,
    message,
    customClass
  })
}

// 显示页面加载 Loading
export function showPageLoading() {
  nprogress.start()
}

// 隐藏页面加载 Loading
export function hidePageLoading() {
  nprogress.done()
}
