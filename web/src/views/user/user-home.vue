<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
              mode="inline"
              v-model:selectedKeys="selectedKeys2"
              v-model:openKeys="openKeys"
              :style="{ height: '100%', borderRight: 0 }"
      >
        <a-menu-item key="4">
          <pie-chart-outlined />
          <span>竞赛</span>
          <router-link to="/user/contest"></router-link>
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

      </a-menu>
    </a-layout-sider>
    <a-layout style="padding: 0 24px 24px">
      <a-layout-content
              :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
        Content:<br/>


        <a-list item-layout="vertical" size="large" :pagination="pagination" :grid="{ gutter: 20, column: 3 }" :data-source="listData">
          <template #footer>
            <div>
              <b>ant design vue</b>
              footer part
            </div>
          </template>
          <template #renderItem="{ item }">
            <a-list-item key="item.title">
              <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
              </template>
              <template #extra>
                <img
                        width="272"
                        alt="logo"
                        src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
                />
              </template>
              <a-list-item-meta :description="item.description">
                <template #title>
                  <a :href="item.href">{{ item.title }}</a>
                </template>
                <template #avatar><a-avatar :src="item.avatar" /></template>
              </a-list-item-meta>
              {{ item.content }}
            </a-list-item>
          </template>
        </a-list>



        通过ref():
        <pre>{{ demos }}</pre>
        <br/>
        <!--          通过reactive():<br/>-->
        <!--          <pre>-->
        <!--          {{ demos_reactive }}-->
        <!--        </pre>-->
        <!--          <br/>-->

        <!--        {{demos}}-->
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';

import axios from 'axios';

// import HelloWorld from "@/components/HelloWorld.vue";

// const listData: Record<string, string>[] = [];
const listData: any = [];

for (let i = 0; i < 23; i++) {
  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
  });
}




export default defineComponent({
  name: 'UserHome',

  //放一些参数定义，方法定义
  setup() {
    console.log("setup");
    // 使用ref()定义响应式数据
    const demos = ref();
    //reactive中放入对象 并自定义属性
    const demos2 = reactive({demos: []});

    //初始化逻辑都写到onMounted()里
    onMounted(() => {
      console.log("onMounted");
      axios.get("/demo/list").then((response) => {
        const data = response.data;
        //ref数据的赋值
        demos.value = data.content;
        demos2.demos = data.content;

        // console.log(response)
      });
    });

    //html代码要拿到响应式变量 需要在setup的最后return
    return {
      demos,
      demos_reactive: toRef(demos2, "demos"),
      listData,
      pagination : {
        onChange: (page: any) => {
          console.log(page);
        },
        pageSize: 3,
      },
      actions: [
        { type: 'StarOutlined', text: '156' },
        { type: 'LikeOutlined', text: '156' },
        { type: 'MessageOutlined', text: '2' },
      ],
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