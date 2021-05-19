<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        v-model:selectedKeys="selectedKeys1"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="/admin-home">
        <router-link to="/admin/home">首页</router-link>
      </a-menu-item>
      <a-menu-item key="/admin-participant">
<!--        <TeamOutlined />-->
        <router-link to="/admin/participant">参赛者管理</router-link>
      </a-menu-item>
      <a-menu-item key="/admin-sponsor">
        <router-link to="/admin/sponsor">主办方管理</router-link>
      </a-menu-item>
      <a-menu-item key="/admin-contest">
        <router-link to="/admin/contest">竞赛管理</router-link>
      </a-menu-item>
      <a-menu-item key="/admin-notification">
        <router-link to="/admin/notification">通知管理</router-link>
      </a-menu-item>
      <a-menu-item key="/admin-discussion">
        <router-link to="/admin/discussion">社群管理</router-link>
      </a-menu-item>
      <a-menu-item key="/about">
        <router-link to="/about">关于我们</router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'admin-header',
  props: {
    msg: String,
  },
});
</script>

<style>

a.router-link-active{ font-weight: bold;}
a.router-link-active span::before{ content: ''; width: 100%; height: 1px; display: block; }

</style>
