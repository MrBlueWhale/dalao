<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', minHeight: '600px',  }"
    >
      <div style="background: #ececec; padding: 30px">
        <a-card title="帮助" :bordered="false" style="width: 1000px; marginLeft: 15%;" >
          <a-card title="用户帮助" style="width: 900px">
            <template #extra><a href="#">联系我们</a></template>
            <a-collapse v-model:activeKey="activeKey" accordion>
              <a-collapse-panel key="1" header="1、初始密码如何设置？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="2" header="2、摄像头看不见？" :disabled="false">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="3" header="3、麦克风无声或声音很小？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="4" header="4、麦克风有杂音？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="5" header="5、扬声器听不见？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="6" header="6、客户端卡顿？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="7" header="7、资料上传要注意什么问题？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="8" header="8、待参加竞赛列表没有比赛怎么办？">
                <p>{{ text }}</p>
              </a-collapse-panel>
              <a-collapse-panel key="9" header="9、手写板打开，USB也插上，但连接不到设备怎么办？">
                <p>{{ text }}</p>
              </a-collapse-panel>
            </a-collapse>
          </a-card>
        </a-card>
      </div>

    </a-layout-content>
  </a-layout>
</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';



export default defineComponent({
  name: 'SponsorHelp',

  //放一些参数定义，方法定义
  setup() {
    console.log("setup");
    const text = "请前往七舍5单元502C找本项目负责人兰鑫！！！联系电话：19981481120";
    const activeKey = ref([]);
    //html代码要拿到响应式变量 需要在setup的最后return
    return {
      activeKey,
      text,

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