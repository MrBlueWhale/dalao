<template>
  <a-layout>

<!--    <div class="BlankBox" style="marginLeft: 25%">-->

<!--    </div>-->

    <a-layout-content
        :style="{ background: '#fff', padding: '24px', minHeight: '600px',  }"
    >
      <div style="background: #ececec; padding: 30px">
        <a-card title="关于我们" :bordered="false" style="width: 1000px; marginLeft: 20%;" >
          <a-card title="产品信息" style="width: 900px">
            <template #extra><a href="#">加入我们！</a></template>
            <h3>&ensp;&ensp;来个大佬是帮助在校大学生在本就繁忙的学习当中，快速准确的获取赛事信息，
              并使赛事信息的发布更加规范化、自动化，使参赛过程更加流程化、便利化。
              本软件包括修改学生基本信息、提供最新和历届的赛事详情，快速按需寻找比赛队友，
              以及统一的报名流程；同时也为赛事举办方提供了相应的渠道，统一集中的发布赛事详情，
              吸引更多更有能力的参赛者。
            </h3>
          </a-card>
          <br>
          <a-card title="当前版本&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;V1.0.0" style="width: 600px">
            <template #extra><a href="#">反馈问题</a></template>
            <a-timeline pending="我们的产品，未完待续..." :reverse="reverse">

              <a-timeline mode="alternate">

                <a-timeline-item>2021年3月，我们的产品立项啦！</a-timeline-item>
                <a-timeline-item color="green">兰鑫、张志成、李鑫洋、何明锦<br>这是一个可爱的四人团队</a-timeline-item>
                <a-timeline-item>
                  <template #dot><ClockCircleOutlined style="font-size: 16px" /></template>
                  2021年3月，需求分析阶段
                </a-timeline-item>
                <a-timeline-item color="red"> 2021年4月，系统设计阶段</a-timeline-item>
                <a-timeline-item>2021年5月，代码编写及测试阶段</a-timeline-item>
                <a-timeline-item>
                  <template #dot><ClockCircleOutlined style="font-size: 16px" /></template>
                  Technical testing 2015-09-01
                </a-timeline-item>
              </a-timeline>
            </a-timeline>
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
  name: 'AdminAbout',

  //放一些参数定义，方法定义
  setup() {
    const reverse = ref<boolean>(false);

    //html代码要拿到响应式变量 需要在setup的最后return
    return {
      reverse
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