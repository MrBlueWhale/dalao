<template>

    <a-layout>
      <a-layout style="padding: 0 24px 24px">

        <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >
          <div class="intro-box" style="padding-left: 41%;
  padding-bottom: 30px;">
            <div class="intro" >
              <span>欢迎使用来个大佬管理员端</span>
              <span>下面是你能使用的功能哦~</span>
            </div>
          </div>

          <div style="background-color: #eaedf2; padding: 20px">

            <a-row :gutter="10">
              <a-col :span="6">
                <a-card hoverable bordered style="width: 300px; height: 200px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/admin-cards/card-1.jpg"
                        style="height: 250px;"
                    />
                  </template>
                  <template class="ant-card-actions" #actions>
                    <SmileTwoTone key="happy" />
                    <!--              <edit-outlined key="edit" />-->
                    <ellipsis-outlined key="ellipsis" />
                    <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                  </template>
                  <a-card-meta title="参赛者管理" description="管理参赛者账户及其关联信息">
                    <!--              <p>· 参赛者密码管理</p>-->
                  </a-card-meta>
<!--                  <a-row :gutter="8">-->
<!--                    <a-col :span="12">-->
<!--                      <p>· 按条件查询参赛者</p>-->
<!--                      <p>· 参赛者账户状态分类管理</p>-->
<!--                      <p>· 查看参赛者账户信息</p>-->
<!--                    </a-col>-->
<!--                    <a-col :span="12">-->
<!--                      <p>· 查看参赛者参加的比赛信息</p>-->
<!--                      <p>· 参赛者密码管理</p>-->
<!--                      <p>· 参赛者账号封禁与解封</p>-->
<!--                    </a-col>-->
<!--                  </a-row>-->
                </a-card>

              </a-col>
              <a-col :span="6">
                <a-card hoverable bordered style="width: 300px; height: 200px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/admin-cards/card-2.jpg"
                        style="height: 250px;"
                    />
                  </template>
                  <template class="ant-card-actions" #actions>
                    <SmileTwoTone key="happy" />
                    <ellipsis-outlined key="ellipsis" />
                    <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                  </template>
                  <a-card-meta title="主办方管理" description="管理主办方账户及其关联信息">
                  </a-card-meta>
                </a-card>

              </a-col>
              <a-col :span="6">
                <a-card hoverable bordered style="width: 300px; height: 200px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/admin-cards/card-3.jpg"
                        style="height: 250px;"
                    />
                  </template>
                  <template class="ant-card-actions" #actions>
                    <SmileTwoTone key="happy" />
                    <ellipsis-outlined key="ellipsis" />
                    <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                  </template>
                  <a-card-meta title="竞赛管理" description="管理及审核竞赛信息">
                  </a-card-meta>
                </a-card>

              </a-col>
              <a-col :span="6">
                <a-card hoverable bordered style="width: 300px; height: 200px">
                  <template #cover>
                    <img
                        alt="example"
                        src="/image/admin-cards/card-4.jpg"
                        style="height: 250px;"
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

          <a-row :gutter="10">
            <a-col :span="6"></a-col>

            <a-col :span="6">
              <a-card hoverable bordered style="width: 300px; height: 200px">
                <template #cover>
                  <img
                      alt="example"
                      src="/image/admin-cards/card-5.jpg"
                      style="height: 250px;"
                  />
                </template>
                <template class="ant-card-actions" #actions>
                  <SmileTwoTone key="happy" />
                  <ellipsis-outlined key="ellipsis" />
                  <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                </template>
                <a-card-meta title="通知管理" description="管理比赛通知信息">
                </a-card-meta>
              </a-card>

            </a-col>
            <a-col :span="6">
              <a-card hoverable bordered style="width: 300px; height: 200px">
                <template #cover>
                  <img
                      alt="example"
                      src="/image/admin-cards/card-6.jpg"
                      style="height: 250px;"
                  />
                </template>
                <template class="ant-card-actions" #actions>
                  <SmileTwoTone key="happy" />
                  <ellipsis-outlined key="ellipsis" />
                  <HeartTwoTone key="favour" twoToneColor="#eb2f96" />
                </template>
                <a-card-meta title="社群管理" description="管理及审核社区评论及回复等信息">
                </a-card-meta>
              </a-card>

            </a-col>
<!--            <a-col :span="6">-->
<!--              <a-card hoverable bordered style="width: 300px; height: 200px">-->
<!--                <template #cover>-->
<!--                  <img-->
<!--                      alt="example"-->
<!--                      src="/image/admin-cards/card-7.jpg"-->
<!--                      style="height: 250px;"-->
<!--                  />-->
<!--                </template>-->
<!--                <template class="ant-card-actions" #actions>-->
<!--                  <SmileTwoTone key="happy" />-->
<!--                  <ellipsis-outlined key="ellipsis" />-->
<!--                  <HeartTwoTone key="favour" twoToneColor="#eb2f96" />-->
<!--                </template>-->
<!--                <a-card-meta title="帮助与提醒" description="帮助与提醒">-->
<!--                </a-card-meta>-->
<!--              </a-card>-->

<!--            </a-col>-->

          </a-row>

          </div>


        </a-layout-content>
      </a-layout>
    </a-layout>

</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';

import { SmileTwoTone, HeartTwoTone, CheckCircleTwoTone } from '@ant-design/icons-vue';


import AdminHeader from '@/components/admin-header.vue';
import AdminFooter from '@/components/admin-footer.vue';
import axios from 'axios';

// import HelloWorld from "@/components/HelloWorld.vue";

// const cardData: Record<string, string>[] = [];
const cardData: any = [];

for (let i = 0; i < 23; i++) {
  cardData.push({
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
      cardData,
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
    AdminHeader,
    AdminFooter,

    SmileTwoTone,
    HeartTwoTone,
    CheckCircleTwoTone,
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
  background: rgb(78, 83, 255) none repeat scroll 0% 0% !important;
  background-color: rgb(78, 83, 255);
  border: 1px solid rgb(78, 83, 255) !important;
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