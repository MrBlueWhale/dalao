<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        v-model:selectedKeys="selectedKeys1"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="mail">
        <HomeOutlined />
        首页
      </a-menu-item>
      <a-sub-menu>
        <template #title>
        <span class="submenu-title-wrapper">
          <UserOutlined />
          我的
        </span>
        </template>
        <a-menu-item key="setting:1">个人资料</a-menu-item>
        <a-menu-item key="setting:2">安全中心</a-menu-item>
        <a-menu-item key="setting:2">关于我们</a-menu-item>

      </a-sub-menu>
    </a-menu>

  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'user-header',
  props: {
    msg: String,
  },
});
</script>
