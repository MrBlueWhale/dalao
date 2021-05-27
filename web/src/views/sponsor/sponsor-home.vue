<template>
  <a-layout>
<!--<sponsor-header></sponsor-header>-->
    <a-layout>
<!--      <a-layout-sider width="200" style="background: #fff">-->
<!--        <a-menu-->
<!--            mode="inline"-->
<!--            v-model:selectedKeys="selectedKeys2"-->
<!--            v-model:openKeys="openKeys"-->
<!--            :style="{ height: '100%', borderRight: 0 }"-->
<!--        >-->
<!--          <a-sub-menu key="sub1">-->
<!--            <template #title>-->
<!--              <span>-->
<!--                <user-outlined />-->
<!--                subnav 1-->
<!--              </span>-->
<!--            </template>-->
<!--            <a-menu-item key="1">option1</a-menu-item>-->
<!--            <a-menu-item key="2">option2</a-menu-item>-->
<!--            <a-menu-item key="3">option3</a-menu-item>-->
<!--            <a-menu-item key="4">option4</a-menu-item>-->
<!--          </a-sub-menu>-->
<!--          <a-sub-menu key="sub2">-->
<!--            <template #title>-->
<!--              <span>-->
<!--                <laptop-outlined />-->
<!--                subnav 2-->
<!--              </span>-->
<!--            </template>-->
<!--            <a-menu-item key="5">option5</a-menu-item>-->
<!--            <a-menu-item key="6">option6</a-menu-item>-->
<!--            <a-menu-item key="7">option7</a-menu-item>-->
<!--            <a-menu-item key="8">option8</a-menu-item>-->
<!--          </a-sub-menu>-->
<!--          <a-sub-menu key="sub3">-->
<!--            <template #title>-->
<!--              <span>-->
<!--                <notification-outlined />-->
<!--                subnav 3-->
<!--              </span>-->
<!--            </template>-->
<!--            <a-menu-item key="9">option9</a-menu-item>-->
<!--            <a-menu-item key="10">option10</a-menu-item>-->
<!--            <a-menu-item key="11">option11</a-menu-item>-->
<!--            <a-menu-item key="12">option12</a-menu-item>-->
<!--          </a-sub-menu>-->
<!--        </a-menu>-->
<!--      </a-layout-sider>-->
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
<!--          <a-breadcrumb-item>List</a-breadcrumb-item>-->
<!--          <a-breadcrumb-item>App</a-breadcrumb-item>-->
        </a-breadcrumb>
        <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >
          <div class="intro-box" style="padding-left: 41%;
  padding-bottom: 30px;">
            <div class="intro" >
              <span>欢迎使用来个大佬主办方端</span>
              <span>下面是你能使用的功能哦~</span>
            </div>
          </div>

          <div style="background-color: #eaedf2; padding: 20px">

            <a-row :gutter="8">

              <a-col :span="8">
                <a-card hoverable bordered style="width: 300px; height: 300px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/sponsor-cards/card-1.jpg"
                        style="height: 300px;"
                    />
                  </template>
                  <template class="ant-card-actions" #actions>
                    <SmileTwoTone key="happy" />
                    <ellipsis-outlined key="ellipsis" />
                    <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                  </template>
                  <a-card-meta title="竞赛管理" description="管理竞赛及其关联信息">
                  </a-card-meta>
                </a-card>

              </a-col>
              <a-col :span="8">
                <a-card hoverable bordered style="width: 300px; height: 300px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/sponsor-cards/card-2.jpg"
                        style="height: 300px;"
                    />
                  </template>
                  <template class="ant-card-actions" #actions>
                    <SmileTwoTone key="happy" />
                    <ellipsis-outlined key="ellipsis" />
                    <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                  </template>
                  <a-card-meta title="通知管理" description="管理比赛通知等信息">
                  </a-card-meta>
                </a-card>

              </a-col>
              <a-col :span="8">
                <a-card hoverable bordered style="width: 300px; height: 300px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/sponsor-cards/card-3.jpg"
                        style="height: 300px;"
                    />
                  </template>
                  <template class="ant-card-actions" #actions>
                    <SmileTwoTone key="happy" />
                    <ellipsis-outlined key="ellipsis" />
                    <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                  </template>
                  <a-card-meta title="组队管理" description="管理及审核队伍信息">
                  </a-card-meta>
                </a-card>

              </a-col>

            </a-row>

            <div class="divide-box" style="padding: 30px;"></div>

          </div>

        </a-layout-content>
      </a-layout>
    </a-layout>
<!--<sponsor-footer></sponsor-footer>-->
  </a-layout>
</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';
import SponsorHeader from '@/components/sponsor-header.vue';
import AdminFooter from '@/components/admin-footer.vue';
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
  name: 'AdminHome',

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
    SponsorHeader,
    AdminFooter,
  },

});
</script>




<style scoped>
/*img {*/
/*  width: 50px;*/
/*  height: 50px;*/
/*}*/

.intro{
  font-size: 25px;
  text-align: center;
  width: 320px !important;
  height: 90px !important;
  /*display: flex !important;*/
  /*justify-content: center !important;*/
  /*align-items: center !important;*/
  border-radius: 5px !important;
  /*cursor: pointer !important;*/
  outline: currentcolor none medium !important;
  /*user-select: none !important;*/
  background: rgb(222, 189, 056) none repeat scroll 0% 0% !important;
  background-color: rgb(222, 189, 056);
  border: 1px solid rgb(222, 189, 056) !important;
  color: rgb(255, 255, 255) !important;
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