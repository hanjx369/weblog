import axios from '@/axios'

// 获取one一言
export function getOneWord() {
  return axios.get('/one')
}
