<script setup>
import { useBlogSettingsStore } from '@/stores/blogsettings'

const blogSettingsStore = useBlogSettingsStore()
</script>

<template>
  <footer class="bg-white mt-5 dark:bg-gray-800">
    <div
      class="flex justify-center flex-col items-center w-full top-0 left-0 right-0 bottom-0 mx-auto max-w-screen-xl py-6 md:flex md:items-center md:justify-center md:flex-col"
    >
      <span class="text-blue-500 font-bold">一言</span>
      <span class="text-gray-500 text-sm">
        备案号:
        <a href="#" class="mr-4 hover:underline md:mr-6">{{
          blogSettingsStore.blogSettings.icp
        }}</a>
      </span>
    </div>
  </footer>
</template>
