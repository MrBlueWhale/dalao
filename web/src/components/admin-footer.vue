<template>
  <a-layout-footer style="text-align: center">
    ibegu-来个大佬一站式组队平台 @2021
  </a-layout-footer>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'admin-footer',
  props: {
    msg: String,
  },
});
</script>
