<template>
  <a-layout>

    <h1 class="h1">这是竞赛管理模块的页面22</h1>

    <!--    <div>-->
    <!--      <a-image-preview-group>-->
    <!--        <a-image :width="200" src="/image/certification-imgs/test1.jpg"/>-->
    <!--        <a-image :width="200" src="/image/certification-imgs/test2.jpg"/>-->
    <!--      </a-image-preview-group>-->
    <!--    </div>-->

    <a-layout>

      <a-layout-sider width="200" style="background: #fff">
        <a-menu
            mode="inline"
            v-model:selectedKeys="selectedKeys2"
            v-model:openKeys="openKeys"
            :style="{ height: '100%', borderRight: 0 }"
            @click="handleClick"
        >

          <a-menu-item key="welcome">
            <MailOutlined/>
            <span>欢迎</span>
          </a-menu-item>

          <a-menu-item key="toAudit">
            <!--            <icon-font class="icons-bar" type="icon-weirenzheng" style="font-size:24px"/>-->
            <icon-font class="icons-bar" type="icon-weirenzheng"/>
            <span>待审核</span>
          </a-menu-item>
          <a-menu-item key="published">
            <icon-font class="icons-bar" type="icon-shenhezhong1"/>
            <span>已发布</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="padding: 0 24px 24px">
        <!--      <h1 class="h1">这是主办方管理模块的页面</h1>-->

        <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >

          <div class="welcome about" v-show="isShowWelcome">
            <h1>Welcome Admin</h1>
            <h1>欢迎使用管理比赛功能</h1>
          </div>


          <layout v-show="!isShowWelcome">

            <div class="about">
              <h1>竞赛管理</h1>
            </div>

            <p>
              <a-form layout="inline" :model="param">
                <a-form-item>
                  <a-input v-model:value="param.name" placeholder="名称">
                  </a-input>
                </a-form-item>
                <a-form-item>
                  <a-button type="primary" @click="handleQueryContest({page: 1, size: pagination.pageSize})">
                    查询
                  </a-button>
                </a-form-item>
              </a-form>

            </p>

            <a-table
                :columns="columns"
                :row-key="record => record.cid"
                :data-source="contests"
                :pagination="pagination"
                :loading="loading"
                @change="handleTableChange"
            >
              <!--          定义对封面的渲染-->
              <!--              <template #avatar="{ text: avatar }">-->
              <!--                &lt;!&ndash;            <img v-if="avatar" :src="avatar" alt="avatar"/>&ndash;&gt;-->
              <!--                <a-avatar size="large" v-if="avatar" :src="avatar" alt="avatar"/>-->
              <!--              </template>-->

              <!--              <template #contestStatus="{ text: contestStatus }">-->


              <!--                <a-tag color="warning" :contest_status="contestStatus" v-if="contestStatus == '未认证'">-->
              <!--                  <template #icon>-->
              <!--                    <exclamation-circle-outlined/>-->
              <!--                  </template>-->
              <!--                  {{ contestStatus }}-->
              <!--                </a-tag>-->
              <!--                <a-tag color="processing" :contest_status="contestStatus" v-else-if="contestStatus == '审核中'">-->
              <!--                  <template #icon>-->
              <!--                    <sync-outlined :spin="true"/>-->
              <!--                  </template>-->
              <!--                  {{ contestStatus }}-->
              <!--                </a-tag>-->
              <!--                <a-tag color="success" :contest_status="contestStatus" v-else>-->
              <!--                  <template #icon>-->
              <!--                    <check-circle-outlined/>-->
              <!--                  </template>-->
              <!--                  {{ contestStatus }}-->
              <!--                </a-tag>-->

              <!--              </template>-->


                            <template v-slot:action="{ text, record }">
                              <!--            空格组件：两个按钮之间的空格-->
                              <a-space size="small">
                                <router-link :to="'/admin/contest-detail?contestId=' + record.cid">
                                  <a-button type="primary">
                                    查看详情
                                  </a-button>
                                </router-link>

<!--                                <a-button type="primary" @click="viewDetails(record)">-->
<!--                                  &lt;!&ndash;              <a-button type="primary" @click="resetPassword">&ndash;&gt;-->
<!--                                  查看详情-->
<!--                                </a-button>-->

<!--                                <a-button type="primary" v-if="record.contestStatus=='未认证'" @click="notify(record)">-->
<!--                                  &lt;!&ndash;              <a-button type="primary" @click="resetPassword">&ndash;&gt;-->
<!--                                  通知认证-->
<!--                                </a-button>-->
<!--                                <a-button type="primary" v-if="record.contestStatus=='审核中'" @click="verify(record)">-->
<!--                                  &lt;!&ndash;              <a-button type="primary" @click="resetPassword">&ndash;&gt;-->
<!--                                  开始认证-->
<!--                                </a-button>-->

<!--                                <a-popconfirm-->
<!--                                    title="封禁后该账号功能受限，确认封禁?"-->
<!--                                    ok-text="是"-->
<!--                                    cancel-text="否"-->
<!--                                    @confirm="handleBanContest(record)"-->
<!--                                >-->
<!--                                  <a-button type="danger" shape="round">-->
<!--                                    封禁比赛-->
<!--                                  </a-button>-->
<!--                                </a-popconfirm>-->
<!--                                <a-button type="primary" shape="round" @click="handleReleaseContest(record)">-->
<!--                                  解除封禁-->
<!--                                </a-button>-->
                              </a-space>
                            </template>
            </a-table>
          </layout>


          通过ref():
          <pre>{{ demos }}</pre>
          <br/>
        </a-layout-content>
      </a-layout>


    </a-layout>

    <div id="components-back-top-demo-custom">
      <a-back-top/>
      Scroll down to see the bottom-right
      <strong style="color: rgba(64, 64, 64, 0.6)"> gray </strong>
      button.
    </div>


  </a-layout>
</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef, toRaw, UnwrapRef} from 'vue';
import {createFromIconfontCN} from '@ant-design/icons-vue';
import {ValidateErrorEntity} from 'ant-design-vue/es/form/interface';
import {Moment,} from 'moment';
import moment from 'moment';

import {message} from 'ant-design-vue';
import {Tool} from "@/util/tool";
import {useRoute} from "vue-router";

import axios from 'axios';

const IconFont = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/font_2558111_009ekmettrll3.js',
});


declare let hexMd5: any;
declare let KEY: any;

interface FormState {
  uid: string;
  reason: string | undefined;
  releasetime: Moment | undefined;
  bannedtime: Date | undefined;
  // bannedtime: Moment | undefined;
  delivery: boolean;
  banType: string[];
  // resource: string;
  note: string;
}


// import HelloWorld from "@/components/HelloWorld.vue";

// const listData: Record<string, string>[] = [];


export default defineComponent({
  name: 'AdminContest',

  //放一些参数定义，方法定义
  setup() {
    console.log("setup");
    // 使用ref()定义响应式数据
    const demos = ref();
    //reactive中放入对象 并自定义属性
    const demos2 = reactive({demos: []});


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
    const contests = ref();
    const pagination = ref({
      current: 1,
      pageSize: 2,
      total: 0
    });

    const loading = ref(false);
    const columns = [
      {
        title: '比赛名称',
        dataIndex: 'contestName'
      },
      {
        title: '开始时间',
        dataIndex: 'competeStartTime'
      },
      {
        title: '结束时间',
        dataIndex: 'competeEndTime'
      },
      {
        title: '类型',
        dataIndex: 'type'
      },
      {
        title: '类别',
        dataIndex: 'category'
      },
      {
        title: '报名费',
        dataIndex: 'entryFee'
      },
      {
        title: '范围',
        dataIndex: 'rank'
      },
      {
        title: 'Action',
        key: 'action',
        slots: {customRender: 'action'}
      }
    ];

    const isShowWelcome = ref(true);

    let contest_status = 0;
    let contestMap = new Map()
    contestMap.set('toAudit', '待审核')
    contestMap.set('published', '已发布')
    contestMap.set('registrationNotStarted', '未开始报名')
    contestMap.set('registrating', '报名中')
    contestMap.set('registrationEnded', '结束报名')
    contestMap.set('gameNotStarted', '未开始比赛')
    contestMap.set('gaming', '比赛中')
    contestMap.set('gameEnded', '结束比赛')


    const handleQueryContest = (params: any) => {
      axios.get("/admin/listContest", {
        params: {
          page: params.page,
          size: params.size,
          contestStatus: contest_status,
          contestName: param.value.name,
        }
      }).then((response) => {
        const data = response.data;
        //ref数据的赋值
        contests.value = data.content.list;

        if (data.success) {
          contests.value = data.content.list;

          for (let i = 0; i < contests.value.length; i++) {
            contests.value[i].competeEndTime = moment(contests.value[i].competeEndTime).format('YYYY-MM-DD HH:mm:ss')
            contests.value[i].competeStartTime = moment(contests.value[i].competeStartTime).format('YYYY-MM-DD HH:mm:ss')
            contests.value[i].registrationStartTime = moment(contests.value[i].registrationStartTime).format('YYYY-MM-DD HH:mm:ss')
            contests.value[i].registrationEndTime = moment(contests.value[i].registrationEndTime).format('YYYY-MM-DD HH:mm:ss')
          }

          // 重置分页按钮
          pagination.value.current = params.page;
          pagination.value.total = data.content.total;
        } else {
          message.error(data.message);
        }

      });

    };

    /**
     * 数据查询
     **/
    const handleQuery = (params: any) => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据

    };


    const handleClick = (value: any) => {
      console.log("menu click", value);
      if (value.key === 'welcome') {
        isShowWelcome.value = true;
      } else {
        contest_status = contestMap.get(value.key) == "待审核" ? 0 : 1;
        isShowWelcome.value = false;
        //这里本应该去查询数据库里所有的主办方数据 而我写死了只查前1000条 可以另写个all方法
        handleQueryContest({
          page: 1,
          size: 1000,
        });
      }

      // isShowWelcome.value = value.key === 'welcome';

    };

    /**
     * 表格点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数都有啥：" + pagination);
      handleQueryContest({
        page: pagination.current,
        size: pagination.pageSize
      });
    };


    const contestDetail = ref();

    const viewDetails = (record: any) => {
      console.log("拿到的数据：", record);
      console.log("该行数据的id：", record.sid);

      axios.get("/admin/getContestDetail", {
            params: {
              sid: record.sid
            }
          }
      ).then((response) => {
        const data = response.data;
        console.log(data);
        contestDetail.value = data.content;
        console.log("主办方详情：", contestDetail);

      });

    };


    // -------- 重置密码 ---------

    const contest = ref({
      // password: '',
    });


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
      // pagination: {
      //   onChange: (page: any) => {
      //     console.log(page);
      //   },
      //   pageSize: 2,
      // },
      actions: [
        {type: 'StarOutlined', text: '156'},
        {type: 'LikeOutlined', text: '156'},
        {type: 'MessageOutlined', text: '2'},
      ],

      param,

      contests,
      loading,
      columns,

      contest,

      pagination,
      handleTableChange,

      isShowWelcome,


      handleClick,
      handleQueryContest,


      //抽屉板块
      viewDetails,
      contestDetail,


    }
  },


  components: {
    IconFont,
    // descriptionItem,
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
  bottom: 150px;
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

.certify-img {
  width: 360px;
  height: 240px;
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

.about {
  font-size: larger;
}

</style>