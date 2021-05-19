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
        <router-link to="/user/home"></router-link>
      </a-menu-item>
      <a-sub-menu key="sub2">
        <template #title>
              <span>
                <desktop-outlined />
                我的比赛
              </span>
        </template>
        <a-menu-item key="6"><FormOutlined />比赛记录<router-link to="/user/record"></router-link></a-menu-item>

        <a-menu-item key="7"><ScheduleOutlined />我的赛程<router-link to="/user/date"></router-link></a-menu-item>
      </a-sub-menu>
      <a-menu-item key="8">
        <notification-outlined />
        <span>消息</span>
        <router-link to="/user/message"></router-link>
      </a-menu-item>
      <a-menu-item key="9">
        <QuestionCircleOutlined />
        <span>帮助</span>
        <router-link to="/user/help"></router-link>
      </a-menu-item>

      <a-sub-menu>
        <template #title>
        <span class="submenu-title-wrapper">
          <a-avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
          我的
        </span>
        </template>
        <a-menu-item key="setting:1"><UserOutlined />个人资料<router-link to="/user/profile"></router-link></a-menu-item>
        <a-menu-item key="setting:2"><VerifiedOutlined />安全中心<router-link to="/user/safety"></router-link></a-menu-item>
        <a-menu-item key="setting:2"><TeamOutlined />关于我们<router-link to="/user/about"></router-link></a-menu-item>

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
