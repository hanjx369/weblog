<script setup>
import { useBlogSettingsStore } from '@/stores/blogsettings'
import { getOneWord } from '@/api/frontend/one'
import { ref } from 'vue'

const blogSettingsStore = useBlogSettingsStore()

const oneWord = ref('')
getOneWord().then((res) => {
  oneWord.value = res.data
})
</script>

<template>
  <footer class="bg-white mt-5 dark:bg-gray-800">
    <div
      class="flex justify-center flex-col items-center w-full top-0 left-0 right-0 bottom-0 mx-auto max-w-screen-xl py-6 md:flex md:items-center md:justify-center md:flex-col"
    >
      <span v-if="oneWord" class="text-sm text-blue-500 font-bold">{{ oneWord }}</span>
      <span v-if="blogSettingsStore.blogSettings.icp" class="text-sm text-gray-500 font-bold">
        备案号:
        <a
          v-if="blogSettingsStore.blogSettings.icp"
          href="https://beian.miit.gov.cn/"
          target="_blank"
          class="text-gray-500 text-sm hover:underline"
          >{{ blogSettingsStore.blogSettings.icp }}</a
        ></span
      >
    </div>
  </footer>
</template>
