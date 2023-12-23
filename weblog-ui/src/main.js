import './assets/main.css'
import 'animate.css'
import 'nprogress/nprogress.css'

import { createApp } from 'vue'
import App from '@/App.vue'
import router from '@/router'
import '@/permission'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
// 引入全局状态管理 Pinia
import pinia from '@/stores'

const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(pinia)
app.use(router)
app.mount('#app')
