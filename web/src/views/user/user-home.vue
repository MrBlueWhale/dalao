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
          <router-link to="/user/home"></router-link>
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

        <div style="position: center;">
<!--          <a-carousel autoplay autospeed="3000" arrows draggable variableHeight="true" style="width: 1080px; margin-left: 13%;" >-->
          <a-carousel autoplay autospeed="3000" arrows draggable variableHeight="true" style="-moz-background-size:100% 100%; background-size:100% 100%;" >
<!--          <a-carousel autoplay autospeed="3000" arrows draggable  style=" margin-left: 13%;" >-->

            <template #prevArrow>
              <div class="custom-slick-arrow" style="left: 10px; zindex: 1">
                <left-circle-outlined />
              </div>
            </template>
            <template #nextArrow>
              <div class="custom-slick-arrow" style="right: 10px">
                <right-circle-outlined />
              </div>
            </template>

            <div><img class="slide-img" src="/image/contest-poster/ia_100000001.png"/></div>
            <div><img class="slide-img" src="/image/contest-poster/ia_100000002.png"/></div>
            <div><img src="/image/contest-poster/ia_100000003.png"/></div>
            <div><img src="/image/contest-poster/ia_100000004.jpg"/></div>
            <div><img src="/image/contest-poster/ia_100000005.png"/></div>
            <div><img src="/image/contest-poster/ia_100000006.png"/></div>
            <div><img src="/image/contest-poster/ia_100000007.png"/></div>
            <div><img src="/image/contest-poster/ia_100000008.png"/></div>
            <div><img class="slide-img" src="/image/contest-poster/ia_100000011.jpg"/></div>

          </a-carousel>
        </div>

        <br><br>
        <div class="components-page-header-demo-content">
          <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="contests">
          <template #renderItem="{ item }">
          <a-page-header
                  :title="item.contestName"
                  class="site-page-header"
                  sub-title="This is a subtitle"
                  :avatar="{ src: 'https://avatars1.githubusercontent.com/u/8186664?s=460&v=4' }"

          >
            <!--<template v-slot:action="{ text, record }">-->
            <template v-slot:tags>
              <a-tag color="blue">正在报名...</a-tag>
            </template>
            <template v-slot:extra>
              <a-button key="3">Operation</a-button>
              <a-button key="2" @click="viewDetail(item)">竞赛详情</a-button>

              <a-button key="1" @click="joinGame(item)" type="primary">加入意向比赛</a-button>
              <a-dropdown key="more">
                <a-button :style="{ border: 'none', padding: 0 }">
                  <EllipsisOutlined :style="{ fontSize: '20px', verticalAlign: 'top' }" />
                </a-button>
                <template v-slot:overlay>
                  <a-menu>
                    <a-menu-item>
                      <a target="_blank" rel="noopener noreferrer" href="http://www.alipay.com/">
                        1st menu item
                      </a>
                    </a-menu-item>
                    <a-menu-item>
                      <a target="_blank" rel="noopener noreferrer" href="http://www.taobao.com/">
                        2nd menu item
                      </a>
                    </a-menu-item>
                    <a-menu-item>
                      <a target="_blank" rel="noopener noreferrer" href="http://www.tmall.com/">
                        3rd menu item
                      </a>
                    </a-menu-item>
                  </a-menu>
                </template>
              </a-dropdown>
            </template>
            <a-row class="content">
              <div style="flex: 1">
                <p>
                  {{item.contestName}}
                </p>
                <p>
                  经研究决定&#x27;，河北省现场统计学会、四川省现场统计学会等联合发起“全国大学生数据统计与分析竞赛”（以下简称“竞赛”），
                  为我国数据统计与分析行业提供人才支持，夯实人才队伍基础。
                </p>
                <div>
                  <template v-for="item in iconLinks" :key="item.src">
                    <a class="example-link">
                      <img class="example-link-icon" :src="item.src" :alt="item.text" />
                      {{item.text }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </a>
                  </template>
                </div>
              </div>
              <div class="image">
                <img
                        src="https://gw.alipayobjects.com/zos/antfincdn/K%24NnlsB%26hz/pageHeader.svg"
                        alt="content"
                        style="width: 100%"
                />
              </div>
            </a-row>
          </a-page-header>
          </template>
          </a-list>
        </div>





        <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="contests">
          <template #footer>
            <div>
              <b>ant design vue</b>
              footer part
            </div>
          </template>
          <template #renderItem="{ item }">
            <a-list-item key="item.contestName">
              <template #actions>
          <!--<span v-for="{ type, text } in actions" :key="type">-->
            <!--<component v-bind:is="type" style="margin-right: 8px" />-->
            <!--{{ text }}-->
          <!--</span>-->
              </template>
              <template #extra>
                <img
                        width="272"
                        alt="logo"
                        src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
                />
              </template>
              <a-list-item-meta :description="item.contestIntro">
                <template #title>
                  <a :href="item.href">{{ item.contestName }}</a>
                </template>
                <template #avatar><a-avatar :src="item.avatar" /></template>
              </a-list-item-meta>
              {{ item.contestName }}
            </a-list-item>
          </template>
        </a-list>

        通过ref():
        <pre>{{ demos }}</pre>
        <br/>
      </a-layout-content>

    </a-layout>

    <a-modal
            title="比赛详细"
            width="1000px"
            v-model:visible="modalVisible"
            :confirm-loading="modalLoading"
            @ok="handleModalOk"
    >
      <a-descriptions size="small" title="比赛详情" bordered>
        <a-descriptions-item label="比赛名称"><h3>{{contestDetail.contestName}}</h3></a-descriptions-item>
        <a-descriptions-item label="规模"><h3>{{contestDetail.rank}}</h3></a-descriptions-item>
        <a-descriptions-item label="参赛者范围"><h3>{{contestDetail.audience}}</h3></a-descriptions-item>
        <a-descriptions-item label="报名开始时间"><h3>{{contestDetail.registrationStartTime}}</h3></a-descriptions-item>
        <a-descriptions-item label="报名结束时间" :span="2"><h3>{{contestDetail.registrationEndTime}}</h3></a-descriptions-item>
        <a-descriptions-item label="比赛开始时间"><h3>{{contestDetail.competeStartTime}}</h3></a-descriptions-item>
        <a-descriptions-item label="比赛结束时间" :span="2"><h3>{{contestDetail.competeEndTime}}</h3></a-descriptions-item>
        <a-descriptions-item label="Status" :span="3">
          <a-badge status="processing" text="Running" />
        </a-descriptions-item>
        <a-descriptions-item label="报名费"><h3>{{contestDetail.entryFee}}</h3></a-descriptions-item>
        <a-descriptions-item label="参赛方式"><h3>{{contestDetail.type}}</h3></a-descriptions-item>
        <a-descriptions-item label="类别"><h3>{{contestDetail.category}}</h3></a-descriptions-item>
        <a-descriptions-item label="比赛介绍">
          <h3>{{contestDetail.contestIntro}}</h3>
        </a-descriptions-item>
      </a-descriptions>
    </a-modal>


  </a-layout>
    <a-modal
            title="参加比赛"
            width="600px"
            v-model:visible="joinModalVisible"
            :confirm-loading="joinModalLoading"
            @ok="handleJoinGameModalOk"
            okText="确认"
    >
        <template #footer>
            <a-button key="resetThisForm" @click="ResetBanForm">重置</a-button>
            <a-button key="submit" type="primary" :loading="loading" @click="handleJoinGameModalOk">提交</a-button>
        </template>

        <div style="text-align: center;">
            <p>意向比赛：{{ contestDetail.contestName }}</p>
        </div>

<!--        <a-descriptions-item label="比赛名称"><h3>{{contestDetail.contestName}}</h3></a-descriptions-item>-->
        <a-form ref="formRef"
                :model="formState"
                :rules="rules"
                :label-col="labelCol"
                :wrapper-col="wrapperCol">
            <a-form-item label="队伍名称" name="teamName">
                <a-input v-model:value="formState.teamName"/>
            </a-form-item>
            <a-form-item label="学校名称">
                <p>{{participant.university}}</p>
            </a-form-item>
            <a-form-item label="学校地址" name="uniAddr">
                <a-input v-model:value="formState.uniAddr"/>
            </a-form-item>
            <a-form-item label="赛区" name="zone">
                <a-input v-model:value="formState.zone"/>
            </a-form-item>
            <a-form-item label="指导老师" name="instructorName">
                <a-input v-model:value="formState.instructorName"/>
            </a-form-item>
            <a-form-item label="指导老师联系电话" name="instructorTel">
                <a-input v-model:value="formState.instructorTel"/>
            </a-form-item>
            <a-form-item label="指导老师邮箱" name="instructorEmail">
                <a-input v-model:value="formState.instructorEmail"/>
            </a-form-item>
            <a-form-item label="指导老师职务" name="instructorProf">
                <a-input v-model:value="formState.instructorProf"/>
            </a-form-item>
            <a-form-item label="队长电话" name="leaderTel">
                <a-input v-model:value="formState.leaderTel"/>
                <p>本账户你的电话：{{participant.telNum}}</p>
            </a-form-item>
            <a-form-item label="队员一电话" name="member1Tel">
                <a-input v-model:value="formState.member1Tel"/>
            </a-form-item>
            <a-form-item label="队员二电话" name="member2Tel">
                <a-input v-model:value="formState.member2Tel"/>
            </a-form-item>
            <a-form-item label="队员三电话" name="member3Tel">
                <a-input v-model:value="formState.member3Tel"/>
            </a-form-item>



        </a-form>

    </a-modal>

</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef, toRaw, UnwrapRef} from 'vue'

import {createFromIconfontCN, LeftCircleOutlined, RightCircleOutlined } from '@ant-design/icons-vue';

import axios from 'axios';

import {ValidateErrorEntity} from 'ant-design-vue/es/form/interface';
import {Moment,} from 'moment';
import moment from 'moment';

import {message} from 'ant-design-vue';
import {Tool} from "@/util/tool";

// import HelloWorld from "@/components/HelloWorld.vue";

// const listData: Record<string, string>[] = [];
const listData: any = [];


interface FormState {
    contestId: number;
    teamName: string;
    uniName: string;
    uniAddr: string;
    zone: string;
    instructorName: string;
    instructorTel: string;
    instructorEmail: string;
    instructorProf: string;
    leaderTel: string;
    member1Tel: string;
    member2Tel: string;
    member3Tel: string;
}

const routes = [
  {
    path: 'index',
    breadcrumbName: 'First-level Menu',
  },
  {
    path: 'first',
    breadcrumbName: 'Second-level Menu',
  },
  {
    path: 'second',
    breadcrumbName: 'Third-level Menu',
  },
];

interface IconLink {
  src: string;
  text: string;
}
const iconLinks: IconLink[] = [
  {
    src: 'https://gw.alipayobjects.com/zos/rmsportal/MjEImQtenlyueSmVEfUD.svg',
    text: '竞赛官网',
  },
  {
    src: 'https://gw.alipayobjects.com/zos/rmsportal/NbuDUAuBlIApFuDvWiND.svg',
    text: '竞赛须知',
  },
  {
    src: 'https://gw.alipayobjects.com/zos/rmsportal/ohOEPSYdDTNnyMbGuyLb.svg',
    text: '竞赛文档',
  },
];


export default defineComponent({
  name: 'UserHome',

  //放一些参数定义，方法定义
  setup() {
    const loading = ref(false);
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const joinModalVisible = ref(false);
    const joinModalLoading = ref(false);

    console.log("setup");
    // 使用ref()定义响应式数据
    const demos = ref();
    //reactive中放入对象 并自定义属性
    const demos2 = reactive({demos: []});
    const contests = ref();
    const contestDetail = ref({
        // cid: 0,
    });
    contestDetail.value = {};
    var str;

    const viewDetail = (item: any) =>{
      modalVisible.value = true;
      contestDetail.value = item;
    };



      // -------- 组队参赛 ---------

//////////////// 组队参赛表单 ///////

      const formRef = ref();
      const formState: UnwrapRef<FormState> = reactive({
          contestId: 0,
          teamName: '',
          uniName: '',
          uniAddr: '',
          zone: '',
          instructorName: '',
          instructorTel: '',
          instructorEmail: '',
          instructorProf: '',
          leaderTel: '',
          member1Tel: '',
          member2Tel: '',
          member3Tel: '',
      });

      const rules = {
          teamName: [{required: true, message: '队伍名不能为空', trigger: 'blur'}],
          uniAddr: [{required: true, message: '大学地址不能为空', trigger: 'blur'}],
          zone: [{required: true, message: '赛区不能为空', trigger: 'blur'}],
          instructorName: [{required: true, message: '指导老师名字不能为空', trigger: 'blur'}],
          instructorTel: [{required: true, message: '指导老师手机号不能为空', trigger: 'blur'},
              {
                  pattern:/^1[34578]\d{9}$/, message: '请输入有效的手机号'
              }],
          instructorEmail: [{required: true, message: '邮箱不能为空', trigger: 'blur'},
              {
          pattern:/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/, message: '你的邮箱格式不正确'
              }],
          instructorProf: [{required: true, message: '指导老师职位不能为空', trigger: 'blur'}],
          leaderTel: [{required: true, message: '队长手机号不能为空', trigger: 'blur'},
              {
                  pattern:/^1[34578]\d{9}$/, message: '请输入有效的手机号'
              }],
          member1Tel: [{required: true, message: '队员手机号不能为空', trigger: 'blur'},
              {
                  pattern:/^1[34578]\d{9}$/, message: '请输入有效的手机号'
              }],
          member2Tel: [{required: true, message: '队员手机号不能为空', trigger: 'blur'},
              {
                  pattern:/^1[34578]\d{9}$/, message: '请输入有效的手机号'
              }],
          member3Tel: [{required: true, message: '队员手机号不能为空', trigger: 'blur'},
              {
                  pattern:/^1[34578]\d{9}$/, message: '请输入有效的手机号'
              }],

      };

      const onSubmit = () => {
          formRef.value
              .validate()
              .then(() => {
                  console.log('values', formState, toRaw(formState));
              })
              .catch((error: ValidateErrorEntity<FormState>) => {
                  console.log('error', error);
              });
      };
      const ResetBanForm = () => {
          formRef.value.resetFields();
      };



      const joinGame = (item: any) =>{
          joinModalVisible.value = true;
          contestDetail.value = item;
          console.log("该行数据的id：", item.cid);
          formState.contestId = item.cid;

          console.log("该行数据：", item);
          contestDetail.value = item;

      };

      const handleJoinGameModalOk = (record: any)=>{

          onSubmit();

          console.log("joinForm1", formState);
          console.log("joinForm2", toRaw(formState));

          // formState.contestId = contestDetail.value.cid;

          axios.post("/team/save", toRaw(formState)).then((response) => {
              joinModalLoading.value = false;
              const data = response.data; // data = commonResp
              if (data.success) {
                  joinModalVisible.value = false;
                  message.success("成功参赛！")


              } else {
                  message.error(data.message);
              }
          });



        console.log(record);

      };


      const participant = ref();


    //初始化逻辑都写到onMounted()里
    onMounted(() => {
      console.log("onMounted");
      axios.get("/contest/list_home", {
      }).then((response) => {
        const data = response.data;
        contests.value = data.content.list;
      });
      axios.get("/demo/list").then((response) => {
        const data = response.data;
        //ref数据的赋值
        demos.value = data.content;
        demos2.demos = data.content;

        // console.log(response)
      });

      axios.get("/contest/detail").then((response) => {
        loading.value = false;
        const data = response.data;
        console.log(data);
        contestDetail.value = data.content;
        console.log("比赛详情：", contestDetail);
      });

        axios.get("/participant/detail", {params:{
            pid: 6,
            }}).then((response) => {
            loading.value = false;
            const data = response.data;
            console.log(data);
            participant.value = data.content;
            console.log("登录者：", participant);
        });

    });

    //html代码要拿到响应式变量 需要在setup的最后return
    return {
      demos,
      contests,
      routes,
      iconLinks,
      loading,

      modalVisible,
      modalLoading,
        joinModalVisible,
        joinModalLoading,
      viewDetail,
        joinGame,
      contestDetail,
         handleJoinGameModalOk,


        formRef,
        labelCol: {span: 4},
        wrapperCol: {span: 14},
        other: '',
        formState,
        rules,
        onSubmit,
        ResetBanForm,

        participant,




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
    LeftCircleOutlined,
    RightCircleOutlined,
  },

});
</script>





<style scoped>
  /* For demo */
  .ant-carousel :deep(.slick-slide) {
    text-align: center;
    height: 250px;
    line-height: 160px;
    background: #364d79;
    overflow: hidden;
  }

  .ant-carousel :deep(.slick-arrow.custom-slick-arrow) {
    width: 25px;
    height: 25px;
    font-size: 25px;
    color: #fff;
    background-color: rgba(31, 45, 61, 0.11);
    opacity: 0.3;
  }
  .ant-carousel :deep(.custom-slick-arrow:before) {
    display: none;
  }
  .ant-carousel :deep(.custom-slick-arrow:hover) {
    opacity: 0.5;
  }

  .ant-carousel :deep(.slick-slide h3) {
    color: #fff;
  }


  #components-page-header-demo-content .image {
    margin: 0 0 0 60px;
    display: flex;
    align-items: center;
  }

  #components-page-header-demo-content .ant-page-header-rtl .image {
    margin: 0 60px 0 0;
  }

  #components-page-header-demo-content .example-link {
    line-height: 24px;
    margin-right: 16px;
  }
  [data-theme='compact'] #components-page-header-demo-content .example-link {
    line-height: 20px;
  }
  #components-page-header-demo-content .example-link-icon {
    margin-right: 8px;
  }

  [data-theme='compact'] #components-page-header-demo-content .example-link-icon {
    width: 20px;
    height: 20px;
  }

  #components-page-header-demo-content .ant-page-header-rtl .example-link {
    float: right;
    margin-right: 0;
    margin-left: 16px;
  }
  #components-page-header-demo-content .ant-page-header-rtl .example-link-icon {
    margin-right: 0;
    margin-left: 8px;
  }
  #components-page-header-demo-content .content p {
    margin-bottom: 1em;
    color: rgba(0, 0, 0, 0.85);
    overflow-wrap: break-word;
  }

  @media (max-width: 768px) {
    #components-page-header-demo-content .image {
      flex: 100%;
      margin: 24px 0 0;
    }
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