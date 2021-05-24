<template>
<h1>这是比赛详情页面</h1>
</template>


<script lang="ts">

import { defineComponent, onMounted, ref, createVNode } from 'vue';
import axios from 'axios';
import {message, Modal} from 'ant-design-vue';
// import {Tool} from "@/util/tool";
import {useRoute} from "vue-router";
import ExclamationCircleOutlined from "@ant-design/icons-vue/ExclamationCircleOutlined";
// import E from 'wangeditor'

export default defineComponent({
  name: 'AdminContestDetail',
  setup() {
    const route = useRoute();
    console.log("路由：", route);
    console.log("route.path：", route.path);
    console.log("route.query：", route.query);
    console.log("route.param：", route.params);
    console.log("route.fullPath：", route.fullPath);
    console.log("route.name：", route.name);
    console.log("route.meta：", route.meta);
    const param = ref();
    param.value = {};
    const docs = ref();
    const loading = ref(false);


    /**
     * 数据查询
     **/



    onMounted(() => {
      console.log("contest-detail" );

    });

    return {
      param,
      // docs,

    }
  }
});
</script>


<style>

</style>