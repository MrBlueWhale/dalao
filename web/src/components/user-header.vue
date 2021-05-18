<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        v-model:selectedKeys="selectedKeys1"
        :style="{ lineHeight: '64px' }"
    >
      <template>
        <a-page-header
                style="border: 1px solid rgb(235, 237, 240)"
                title="来个大佬一站组队平台"
                sub-title="This is a subtitle"
                @back="() => null"
        />
      </template>
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
