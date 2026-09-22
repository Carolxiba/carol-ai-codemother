<script setup lang="ts">
// 版权信息配置：可在此集中维护版权文案与跳转链接
const copyrightText = '编程导航原创项目 by 程序员Carol'
const copyrightLink = 'https://github.com/carolxiba'
</script>

<template>
  <div class="global-footer">
    <a :href="copyrightLink" target="_blank" rel="noopener noreferrer">
      {{ copyrightText }}
    </a>
  </div>
</template>

<style scoped>
.global-footer {
  text-align: center;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.45);
}

.global-footer a {
  color: rgba(0, 0, 0, 0.45);
  text-decoration: none;
  transition: color 0.2s;
}

.global-footer a:hover {
  color: #1677ff;
}
</style>
