<template>
  <a-layout>
    <a-layout-content
            :style="{ background:'#fff', padding: '24px', margin: 0,
    minHeight:'600px'}">

      <h1>这里是竞赛页面</h1>
    </a-layout-content>
  </a-layout>
</template>


<script lang="ts">
  import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';

  import axios from 'axios';

  // import HelloWorld from "@/components/HelloWorld.vue";


  export default defineComponent({
    name: 'UserContest',

    //放一些参数定义，方法定义
    setup() {

      //html代码要拿到响应式变量 需要在setup的最后return
      return {

      }
    },


    components: {

    },

  });
</script>




<style scoped>
  /*img {*/
  /*  width: 50px;*/
  /*  height: 50px;*/
  /*}*/
</style>







<style>
  #components-layout-demo-top-side-2 .logo {
    float: left;
    width: 120px;
    height: 31px;
    margin: 16px 24px 16px 0;
    background: rgba(255, 255, 255, 0.3);
  }

  .ant-row-rtl #components-layout-demo-top-side-2 .logo {
    float: right;
    margin: 16px 0 16px 24px;
  }

  .site-layout-background {
    background: #fff;
  }
</style>