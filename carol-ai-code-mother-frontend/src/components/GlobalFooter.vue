<template>
  <a-layout-footer class="footer">
    <div class="footer-content">
      <p class="copyright">
        <a
          href="https://www.github.com/carolxiba"
          target="_blank"
          rel="noopener noreferrer"
          class="author-link"
        >
          by 程序员Carolxiba
        </a>
      </p>
    </div>
  </a-layout-footer>
</template>

<script setup lang="ts">
// 无需额外的响应式数据
</script>

<style scoped>
.footer {
  background: rgba(255, 253, 246, 0.9);
  backdrop-filter: blur(10px);
  text-align: center;
  padding: 20px;
  margin-top: 40px;
  border-top: 1px solid rgba(245, 158, 11, 0.14);
}

.copyright {
  margin: 0;
  color: #8a7560;
  font-size: 14px;
}
</style>
