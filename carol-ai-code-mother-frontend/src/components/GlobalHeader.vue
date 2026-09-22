<script setup lang="ts">
import { computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { UserOutlined } from '@ant-design/icons-vue'
import logo from '@/assets/logo.png'

// 网站标题：可在此集中配置
const siteTitle = '编程导航'

// 菜单项配置：后续新增或调整菜单时，只需修改此数组即可
interface MenuItemConfig {
  label: string
  path: string
}

const menuItems: MenuItemConfig[] = [
  { label: '首页', path: '/' },
  { label: '关于', path: '/about' },
  { label: '编程导航', path: '/router' }
]

const route = useRoute()
const router = useRouter()

// 将菜单配置转换为 Ant Design Vue Menu 所需的 items 结构
const menuOptions = menuItems.map((item) => ({
  key: item.path,
  label: item.label,
}))

// 根据当前路由高亮对应菜单项
const selectedKeys = computed(() => [route.path])

const handleMenuClick = ({ key }: { key: string | number }) => {
  router.push(String(key))
}
</script>

<template>
  <div class="global-header">
    <div class="global-header__left">
      <img class="global-header__logo" :src="logo" alt="logo" />
      <span class="global-header__title">{{ siteTitle }}</span>
    </div>

    <a-menu class="global-header__menu" mode="horizontal" :items="menuOptions" :selected-keys="selectedKeys"
      @click="handleMenuClick" />

    <div class="global-header__right">
      <!-- 登录用户头像与昵称占位：后续接入登录态后替换为真实头像 + 昵称 -->
      <a-button type="primary">
        <template #icon>
          <UserOutlined />
        </template>
        登录
      </a-button>
    </div>
  </div>
</template>

<style scoped>
.global-header {
  display: flex;
  align-items: center;
  height: 100%;
  padding: 0 24px;
  background: #fff;
  border-bottom: 1px solid #f0f0f0;
}

.global-header__left {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-right: 24px;
  flex-shrink: 0;
}

.global-header__logo {
  width: 32px;
  height: 32px;
}

.global-header__title {
  font-size: 18px;
  font-weight: 600;
  color: rgba(0, 0, 0, 0.88);
  white-space: nowrap;
  user-select: none;
}

.global-header__menu {
  flex: 1;
  min-width: 0;
  border-bottom: none;
  user-select: none;
}

.global-header__right {
  margin-left: 24px;
  flex-shrink: 0;
}

@media (max-width: 768px) {
  .global-header {
    padding: 0 12px;
  }

  .global-header__title {
    display: none;
  }

  .global-header__left {
    margin-right: 12px;
  }

  .global-header__right {
    margin-left: 12px;
  }
}
</style>
