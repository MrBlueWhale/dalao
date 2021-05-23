<template>
  <a-layout>

    <!--    <div class="BlankBox" style="marginLeft: 25%">-->

    <!--    </div>-->

    <a-layout-content
            :style="{ background: '#fff', padding: '24px', minHeight: '600px',  }"
    >
      <div style="background: #ececec; padding: 30px">
        <a-card title="我的消息" :bordered="false" style="width: 1000px; marginLeft: 15%;" >
          <template #extra><a href="#">联系我们</a></template>
          <a-card title="比赛通知" style="width: 900px">
            <h3>&ensp;&ensp;2021年5月24日举行的“大学生数据统计与分析竞赛”由于一些不可抗拒原因暂时推迟，
              具体比赛时间后续在进行商定，请参加比赛的同学注意</h3>
          </a-card>
          <a-card title="队员消息" style="width: 900px">
            <h3>&ensp;&ensp;我们组队参加的2021年全国大学生技术竞赛获得了全国二等奖，现有奖金100万，咱们分了吧，别告诉另外的组员了</h3>
          </a-card>
          <a-card title="系统消息" style="width: 900px">
            <h3>&ensp;&ensp;亲爱的用户你好，你的账号发言由于涉及敏感词汇，现已被封禁180天，请注意关注系统消息。如有异议，请联系电话：19981481120</h3>
          </a-card>
        </a-card>
      </div>

    </a-layout-content>

    <!--    <div class="BlankBox" style="marginLeft: 25%">-->

    <!--    </div>-->


  </a-layout>
</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';

import axios from 'axios';

// import HelloWorld from "@/components/HelloWorld.vue";


export default defineComponent({
  name: 'UserHelp',

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