<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        v-model:selectedKeys="selectedKeys1"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="/sponsor-home">
        <icon-font class="icons-bar" type="icon-welcome" style="font-size:24px" />
        <span>首页</span>
        <router-link to="/sponsor/home"></router-link>
      </a-menu-item>
      <a-menu-item key="/sponsor-contest">
        <icon-font class="icons-bar" type="icon-jingsaiguanli" style="font-size:24px"/>
        <span>竞赛管理</span>
        <router-link to="/sponsor/contest"></router-link>
<!--        <router-link to="/sponsor/participant">参赛者管理</router-link>-->
      </a-menu-item>
      <a-menu-item key="/sponsor-notification">
        <icon-font class="icons-bar" type="icon-tongzhi" style="font-size:24px"/>
        <!--        <icon-font class="icons-bar" type="icon-duiwu" />        -->
        <span>通知管理</span>
        <router-link to="/sponsor/notification"></router-link>
      </a-menu-item>


      <a-menu-item key="/sponsor-team">
        <icon-font class="icons-bar" type="icon-duiwu" style="font-size:24px"/>
        <span>组队管理</span>
        <router-link to="/sponsor/team"></router-link>
      </a-menu-item>

<!--      <a-menu-item key="/sponsor-discussion">-->
<!--        <icon-font class="icons-bar" type="icon-shequn" style="font-size:24px"/>-->
<!--        <span>社群管理</span>-->
<!--        <router-link to="/sponsor/discussion"></router-link>-->
<!--      </a-menu-item>-->
      <a-menu-item key="/sponsor-help">
        <icon-font class="icons-bar" type="icon-bangzhu1" style="font-size:24px"/>
        <span>帮助手册</span>
        <router-link to="/sponsor/help"></router-link>
      </a-menu-item>
      <a-menu-item key="/sponsor/about">
        <icon-font class="icons-bar" type="icon-guanyu" style="font-size:24px"/>
        <span>关于我们</span>
        <router-link to="/sponsor/about"></router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { createFromIconfontCN } from '@ant-design/icons-vue';

const IconFont = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/font_2573978_h1nyze6ikll.js',
});

export default defineComponent({
  name: 'sponsor-header',
  props: {
    msg: String,
  },
  components: {
    IconFont,
  },
});
</script>

<!--<style>-->

<!--a.router-link-active{ font-weight: bold;}-->
<!--a.router-link-active span::before{ content: ''; width: 100%; height: 1px; display: block; }-->

<!--</style>-->

<style scoped>
  .icons-bar{
  color: #A6ADB4;
}

a.router-link-active{ font-weight: bold;}
a.router-link-active span::before{ content: ''; width: 100%; height: 1px; display: block; }

</style>
