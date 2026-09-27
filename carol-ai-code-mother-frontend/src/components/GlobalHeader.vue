<script setup lang="ts">
import { computed, h } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { HomeOutlined, UserOutlined } from '@ant-design/icons-vue'
import logo from '@/assets/logo.png'
import { useLoginUserStore } from '@/stores/loginUser.ts'
import { LogoutOutlined } from '@ant-design/icons-vue'
import { userLogout } from '@/api/userController'
import { message, type MenuProps } from 'ant-design-vue'


// 用户注销
const doLogout = async () => {
  const res = await userLogout()
  if (res.data.code === 0) {
    loginUserStore.setLoginUser({
      userName: '未登录',
    })
    message.success('退出登录成功')
    await router.push('/user/login')
  } else {
    message.error('退出登录失败，' + res.data.message)
  }
}

//获取用户登录状态
const loginUserStore = useLoginUserStore();

// 网站标题：可在此集中配置
const siteTitle = '开罗'

// 菜单项配置：后续新增或调整菜单时，只需修改此数组即可
// interface MenuItemConfig {
//   label: string
//   path: string
// }

const originItems: MenuProps['items'] = [
  {
    key: '/',
    icon: () => h(HomeOutlined),
    label: '主页',
    title: '主页',
  },
  {
    key: '/admin/userManage',
    label: '用户管理',
    title: '用户管理',
  },
  {
    key: 'others',
    label: h('a', { href: 'https://www.github.com/carolxiba', target: '_blank' }, '关于开发者'),
    title: '关于开发者',
  },
]

// 过滤菜单项
const filterMenus = (menus: MenuProps['items'] = []) => {
  return menus.filter((menu) => {
    const menuKey = menu?.key as string
    if (menuKey?.startsWith('/admin')) {
      const loginUser = loginUserStore.loginUser
      if (!loginUser || loginUser.userRole !== 'admin') {
        return false
      }
    }
    return true
  })
}

// ✅ 合并为一个 computed，同时修复字段名和响应式问题
const menuOptions = computed(() =>
  filterMenus(originItems).map((item) => ({
    key: item.key,       // ← 修正：originItems 用的是 key，不是 path
    label: item.label,
  }))
)
const route = useRoute()
const router = useRouter()
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
      <div v-if="loginUserStore.loginUser.id">
        <a-dropdown>
          <a-space>
            <a-avatar :src="loginUserStore.loginUser.userAvatar" />
            {{ loginUserStore.loginUser.userName ?? '无名' }}
          </a-space>
          <template #overlay>
            <a-menu>
              <a-menu-item @click="doLogout">
                <LogoutOutlined />
                退出登录
              </a-menu-item>
            </a-menu>
          </template>
        </a-dropdown>
      </div>

      <div v-else>
        <a-button type="primary" @click="router.push('/user/login')">
          <template #icon>
            <UserOutlined />
          </template>
          登录
        </a-button>
      </div>
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
