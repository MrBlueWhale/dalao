<template>
  <a-layout>

    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          mode="inline"
          v-model:selectedKeys="selectedKeys2"
          v-model:openKeys="openKeys"
          :style="{ height: '100%', borderRight: 0 }"
          @click="handleClick"
      >

        <a-menu-item key="notCertified">
          <!--            <icon-font class="icons-bar" type="icon-weirenzheng" style="font-size:24px"/>-->
          <icon-font class="icons-bar" type="icon-weirenzheng"/>
          <span>未认证</span>
        </a-menu-item>
        <a-menu-item key="underReview">
          <icon-font class="icons-bar" type="icon-shenhezhong1"/>
          <span>审核中</span>
        </a-menu-item>
        <a-menu-item key="verified">
          <icon-font class="icons-bar" type="icon-yirenzheng6"/>
          <span>已认证</span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>

    <a-layout style="padding: 0 24px 24px">

      <h1 class="h1">这是主办方管理模块的页面</h1>

      <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
        Content:<br/>


        <a-list item-layout="vertical" size="large" :pagination="pagination" :grid="{ gutter: 20, column: 1 }"
                :data-source="listData">
          <template #footer>
            <div>
              <b>ant design vue</b>
              footer part
            </div>
          </template>

          <template #renderItem="{ item }">

            <a-list-item key="item.title">
              <a-tag :identity_status="item.identity_status">{{ item.identity_status }}</a-tag>
              <template #actions>
                  <span v-for="{ type, text } in actions" :key="type">
                    <component v-bind:is="type" style="margin-right: 8px"/>
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
                <template #avatar>
                  <a-avatar :src="item.avatar"/>
                </template>
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

  <div id="components-back-top-demo-custom">
    <a-back-top>
      <div class="ant-back-top-inner">UP</div>
    </a-back-top>
    Scroll down to see the bottom-right
    <strong style="color: #1088e9">blue</strong>
    button.
  </div>

</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';
import {createFromIconfontCN} from '@ant-design/icons-vue';


import axios from 'axios';

const IconFont = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/font_2558111_009ekmettrll3.js',
});

// import HelloWorld from "@/components/HelloWorld.vue";

// const listData: Record<string, string>[] = [];
const listData: any = [];

let identity_status = '';

for (let i = 0; i < 23; i++) {

  identity_status = i % 3 === 0 ? '已认证' : (i % 3 === 1 ? '审核中' : '未认证');

  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
    identity_status: identity_status
  });
}


export default defineComponent({
  name: 'AdminSponsor',

  //放一些参数定义，方法定义
  setup() {
    console.log("setup");
    // 使用ref()定义响应式数据
    const demos = ref();
    //reactive中放入对象 并自定义属性
    const demos2 = reactive({demos: []});



    const handleClick = (value: any) => {
      console.log("menu click", value );
      // if(value.key === 'welcome'){
      //   isShowWelcome.value = true;
      // }else {
      //   categoryId2 = value.key;
      //   isShowWelcome.value = false;
      //   handleQueryEbook();
      // }
      // isShowWelcome.value = value.key === 'welcome';
    };



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
      pagination: {
        onChange: (page: any) => {
          console.log(page);
        },
        pageSize: 3,
      },
      actions: [
        {type: 'StarOutlined', text: '156'},
        {type: 'LikeOutlined', text: '156'},
        {type: 'MessageOutlined', text: '2'},
      ],


      handleClick,


    }
  },


  components: {
    IconFont,
  },

});
</script>


<style scoped>

.h1 {
  font-size: 25px;
}

/*img {*/
/*  width: 50px;*/
/*  height: 50px;*/
/*}*/

#components-back-top-demo-custom .ant-back-top {
  bottom: 100px;
}

#components-back-top-demo-custom .ant-back-top-inner {
  height: 40px;
  width: 40px;
  line-height: 40px;
  border-radius: 4px;
  background-color: #1088e9;
  color: #fff;
  text-align: center;
  font-size: 20px;
}

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