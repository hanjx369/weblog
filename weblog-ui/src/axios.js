import axios from 'axios'
import { getToken, removeToken } from '@/composables/cookie'
import { showMessage } from '@/composables/util'

// 创建 Axios 实例
const instance = axios.create({
  // API URL
  baseURL: '/api',
  // 请求超时时间
  timeout: 7000
})

// 添加请求拦截器
instance.interceptors.request.use(
  (config) => {
    // 在发送请求之前做些什么
    const token = getToken()
    if (token) {
      config.headers['Authorization'] = 'Bearer ' + token
    }
    return config
  },
  (error) => {
    // 对请求错误做些什么
    return Promise.reject(error)
  }
)

// 添加响应拦截器
instance.interceptors.response.use(
  (response) => {
    const res = response.data
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    if (!res.success) {
      showMessage(res.message, 'error')
    }
    return res
  },
  (error) => {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    const errorMessage = error.response.data.message || '请求失败'
    showMessage(errorMessage, 'error')

    const status = error.response.status
    // 状态码 401
    if (status === 401) {
      // 删除 cookie 中的令牌
      removeToken()
      // 刷新页面
      location.reload()
    }

    return Promise.reject(error)
  }
)

export default instance
