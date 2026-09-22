<script setup lang="ts">
import { RouterView } from 'vue-router'
import GlobalHeader from '../components/GlobalHeader.vue'
import GlobalFooter from '../components/GlobalFooter.vue'
</script>

<template>
  <a-layout class="basic-layout">
    <a-layout-header class="basic-layout__header">
      <GlobalHeader />
    </a-layout-header>

    <a-layout-content class="basic-layout__content">
      <RouterView />
    </a-layout-content>

    <a-layout-footer class="basic-layout__footer">
      <GlobalFooter />
    </a-layout-footer>
  </a-layout>
</template>

<style scoped>
.basic-layout {
  min-height: 100vh;
}

.basic-layout__header {
  position: sticky;
  top: 0;
  z-index: 100;
  height: 64px;
  line-height: normal;
  padding: 0;
  background: #fff;
}

.basic-layout__content {
  flex: 1;
  padding: 24px;
  background: #f5f5f5;
}

.basic-layout__footer {
  padding: 16px 24px;
  background: #fff;
}

@media (max-width: 768px) {
  .basic-layout__content {
    padding: 16px;
  }
}
</style>
