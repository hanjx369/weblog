import { useCookies } from '@vueuse/integrations/useCookies'

// 存储在 Cookie 中的 Token key
const TOKEN_KEY = 'Authorization'
const { get, set, remove } = useCookies()

// 获取 Token
export function getToken() {
  return get(TOKEN_KEY)
}

// 添加 Token
export function setToken(token) {
  return set(TOKEN_KEY, token)
}

// 删除 Token
export function removeToken() {
  return remove(TOKEN_KEY)
}
