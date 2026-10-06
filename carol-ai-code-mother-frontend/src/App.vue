<script setup lang="ts">
import BasicLayout from './layouts/BasicLayout.vue'

// 暖色调主题：与 Logo 小太阳的金黄色系保持一致
const themeConfig = {
  token: {
    colorPrimary: '#f59e0b',
    colorInfo: '#f59e0b',
    colorLink: '#d97706',
    colorLinkHover: '#f59e0b',
    colorLinkActive: '#b45309',
    colorBgLayout: '#fdf6ec',
  },
}
</script>

<template>
  <a-config-provider :theme="themeConfig">
    <BasicLayout />
  </a-config-provider>
</template>
