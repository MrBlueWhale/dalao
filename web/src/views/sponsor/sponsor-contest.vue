<template>
  <a-layout>
    <h1 class="h1">这是竞赛管理模块的页面</h1>
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
            <icon-font class="icons-bar" type="icon-shijian" style="font-size: 30px;"/>
            <span>待审核</span>
          </a-menu-item>
          <a-menu-item key="failAudit">
            <icon-font class="icons-bar" type="icon-liwu" style="font-size: 30px;"/>
            <span>已打回</span>
          </a-menu-item>
          <a-menu-item key="published">
            <icon-font class="icons-bar" type="icon-jiangpai" style="font-size: 30px;"/>
            <span>已发布</span>
          </a-menu-item>

        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >

          <!--          <div class="welcome about" v-show="isShowWelcome">-->
          <div class="cell-box" v-show="isShowWelcome">
            <!--            <span>Welcome Admin</span>-->
            <span>欢迎使用管理比赛功能</span>

            <a-button type="primary" shape="round" @click="createContest">点击创建比赛</a-button>
            <!--            <a-button type="primary" @click="createContest">-->
            <!--              点击创建比赛-->
            <!--            </a-button>-->
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
                  <router-link :to="'/sponsor/contest-detail?contestId=' + record.cid">
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


                </a-space>
              </template>
            </a-table>
          </layout>

        </a-layout-content>
      </a-layout>
    </a-layout>

    <div id="components-back-top-demo-custom">
      <a-back-top/>
      <!--      Scroll down to see the bottom-right-->
      <!--      <strong style="color: rgba(64, 64, 64, 0.6)"> gray </strong>-->
      <!--      button.-->
    </div>

  </a-layout>

  <a-modal
      title="创建比赛"
      width="600px"
      v-model:visible="createContestModalVisible"
      :confirm-loading="createContestModalLoading"
      @ok="handleCreateContestModalOk"
      okText="确认"
  >
    <template #footer>
      <a-button key="resetThisForm" @click="ResetBanForm">重置</a-button>
      <a-button key="submit" type="primary" :loading="loading" @click="handleCreateContestModalOk">提交</a-button>
    </template>


    <a-form
        ref="formRef"
        :model="formState"
        :rules="rules"
        :label-col="labelCol"
        :wrapper-col="wrapperCol"
    >

      <!--      <a-form-item label="封禁原因" name="reason">-->
      <!--        <a-select v-model:value="formState.reason" placeholder="请选择封禁原因">-->
      <!--          <a-select-option v-for="item in banReasons" :key="item" :value="item">{{ item }}</a-select-option>-->
      <!--          &lt;!&ndash;          <a-select-option value="beijing">Zone two</a-select-option>&ndash;&gt;-->
      <!--        </a-select>-->
      <!--      </a-form-item>-->
      <!--      <a-form-item label="解禁时间" required name="releasetime">-->
      <!--        <a-date-picker-->
      <!--            v-model:value="formState.releasetime"-->
      <!--            show-time-->
      <!--            type="date"-->
      <!--            placeholder="选择解禁时间"-->
      <!--            style="width: 100%"-->
      <!--        />-->
      <!--      </a-form-item>      -->

      <a-form-item label="竞赛名称" name="contestName">
        <a-input v-model:value="formState.contestName" placeholder="xxx 大赛"/>
      </a-form-item>

      <a-form-item label="竞赛形式" name="contest_type">
        <a-radio-group name="contest_type" v-model:value="formState.type">
          <a-radio value="个人赛">个人赛</a-radio>
          <a-radio value="组队赛">组队赛</a-radio>
        </a-radio-group>
      </a-form-item>

      <a-form-item label="竞赛级别" name="contest_rank">
        <a-radio-group name="contest_rank" v-model:value="formState.rank">
          <a-radio value="校级">校级</a-radio>
          <a-radio value="省级">省级</a-radio>
          <a-radio value="国家级">国家级</a-radio>
        </a-radio-group>
      </a-form-item>

      <a-form-item label="竞赛对象" name="contest_audience">
        <a-radio-group name="contest_audience" v-model:value="formState.audience">
          <a-checkbox-group v-model:value="audienceList" :options="audienceOptions" />
        </a-radio-group>
      </a-form-item>



      <a-form-item label="竞赛分类" name="contest_type">
        <a-cascader
            v-model:value="contestCategorys"
            style="margin-top: 1rem"
            :options="contestCategorysOptions"
            placeholder="请选择竞赛分类"
        >
          <template #suffixIcon><smile-outlined class="test" /></template>
        </a-cascader>
      </a-form-item>


      <a-form-item label="报名起止时间" name="registration_start&end_time">

        <a-range-picker v-model:value="registrationTimes" show-time type="date" placeholder="选择报名起止时间"
                        style="width: 100%"/>

      </a-form-item>
      <a-form-item label="竞赛起止时间" name="compete_start&end_time">

        <a-range-picker v-model:value="competeTimes" show-time type="date" placeholder="选择竞赛起止时间" style="width: 100%"/>

      </a-form-item>
      <!--      <a-form-item label="发送通知" name="delivery">-->
      <!--        <a-switch v-model:checked="formState.delivery"/>-->
      <!--      </a-form-item>-->
      <!--      <a-form-item label="限制功能" name="banType">-->
      <!--        <a-checkbox-group v-model:value="formState.banType">-->
      <!--          <a-checkbox value="1" name="type">发布评论</a-checkbox>-->
      <!--          <a-checkbox value="2" name="type">发布比赛</a-checkbox>-->
      <!--          <a-checkbox value="3" name="type">发布通知</a-checkbox>-->
      <!--          <a-checkbox value="4" name="type">删除比赛</a-checkbox>-->
      <!--          <a-checkbox value="5" name="type">删除通知</a-checkbox>-->
      <!--        </a-checkbox-group>-->
      <!--      </a-form-item>-->

      <a-form-item label="报名费" name="entryFee">
        <a-input prefix="￥" suffix="RMB" v-model:value="formState.entryFee"/>
      </a-form-item>

      <a-form-item label="竞赛简介" name="contestIntro">
        <a-textarea v-model:value="formState.contestIntro" placeholder="为了培养学生的创新意识及运用..." :rows="4"/>
        <!--        <a-textarea v-model:value="formState.contestIntro"/>-->
      </a-form-item>

      <a-form-item label="竞赛宣传图片" name="contest_imgs">
        <a-upload
            action="/image/contest-poster/"
            list-type="picture"
            v-model:file-list="fileList1"
            class="upload-list-inline"
        >
          <a-button>
            <upload-outlined></upload-outlined>
            upload
          </a-button>
        </a-upload>
      </a-form-item>

      <a-form-item label="备注" name="note">
        <a-textarea v-model:value="formState.note" allow-clear showCount :maxlength="100"/>
      </a-form-item>

    </a-form>
  </a-modal>


</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef, toRaw, UnwrapRef} from 'vue';
import {createFromIconfontCN, UploadOutlined} from '@ant-design/icons-vue';
import {ValidateErrorEntity} from 'ant-design-vue/es/form/interface';
import {Moment,} from 'moment';
import moment from 'moment';

import {message, notification} from 'ant-design-vue';
import {Tool} from "@/util/tool";
import {useRoute} from "vue-router";

import axios from 'axios';

const IconFont = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/font_2575137_l9dpou9d4vg.js',
});


declare let hexMd5: any;
declare let KEY: any;

interface FormState {

  contestName: string;
  sponsorId: number;
  contestIntro: string;
  registrationStartTime: Moment | undefined;
  registrationEndTime: Moment | undefined;
  competeStartTime: Moment | undefined;
  competeEndTime: Moment | undefined;
  type: string;
  category: string;
  entryFee: number;
  rank: string;
  audience: string;
  contestStatus: number;

  note: string;
  banner: string;

}

interface ContestCategorys {
  value: string;
  label: string;
  children?: ContestCategorys[];
}

interface FileItem {
  uid: string;
  name?: string;
  status?: string;
  response?: string;
  url?: string;
  thumbUrl?: string;
}

const audienceOptions = ['全国', '大学/高校', '高中'];

const contestCategorysOptions: ContestCategorys[] = [
  {
    value: '电子&自动化',
    label: '电子&自动化',
    children: [
      {
        value: '机器人',
        label: '机器人',
      },
    ],
  },
  {
    value: '计算机&信息技术',
    label: '计算机&信息技术',
    children: [
      {
        value: '编程',
        label: '编程',
      }, {
        value: '算法',
        label: '算法',
      },
    ],
  },
  {
    value: '数学&数学建模',
    label: '数学&数学建模',
    children: [
      {
        value: '数学',
        label: '数学',
      }, {
        value: '数学建模',
        label: '数学建模',
      },
    ],
  },
];


export default defineComponent({
  name: 'SponsorContest',

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
    contestMap.set('failAudit', '已打回')
    contestMap.set('published', '已发布')
    contestMap.set('registrationNotStarted', '未开始报名')
    contestMap.set('registrating', '报名中')
    contestMap.set('registrationEnded', '结束报名')
    contestMap.set('gameNotStarted', '未开始比赛')
    contestMap.set('gaming', '比赛中')
    contestMap.set('gameEnded', '结束比赛')


    const handleQueryContest = (params: any) => {
      axios.get("/sponsor/listContest", {
        params: {
          page: params.page,
          size: params.size,
          contestStatus: contest_status,
          contestName: param.value.name,
          sponsorId: sponsorId,
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
        contest_status = contestMap.get(value.key) == "待审核" ? 0 : (contestMap.get(value.key) == "已发布" ? 1 : 9);
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

    // 创建比赛

    let sponsorId = 2;

    const formRef = ref();
    const formState: UnwrapRef<FormState> = reactive({

      note: '',
      banner: '/image/contest-poster/',

      contestName: '',
      sponsorId: sponsorId,
      contestIntro: '',
      registrationStartTime: undefined,
      registrationEndTime: undefined,
      competeStartTime: undefined,
      competeEndTime: undefined,
      type: '',
      category: '',
      entryFee: 0,
      rank: '',
      audience: '',
      contestStatus: 0,

    });
    const rules = {
      // name: [
      //   { required: true, message: 'Please input Activity name', trigger: 'blur' },
      //   { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
      // ],
      // reason: [{required: true, message: '选择封禁原因', trigger: 'change'}],
      // releasetime: [{required: true, message: '选择最晚解封时间', trigger: 'change', type: 'object'}],
      // banType: [
      //   {
      //     type: 'array',
      //     required: true,
      //     message: '至少选择一项封禁功能',
      //     trigger: 'change',
      //   },
      // ],
      // // resource: [{ required: true, message: 'Please select activity resource', trigger: 'change' }],
      // note: [{required: true, message: '填写封禁备注', trigger: 'blur'}],
      //
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


    ///////////////////////

    const fileList1 = ref<FileItem[]>([
      {
        uid: '-1',
        name: 'xxx.png',
        status: 'done',
        url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
        thumbUrl: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
      },
    ]);


    const contestCategorys = ref<string[]>([],);
    const audienceList = ref();
    const registrationTimes = ref<Moment[]>([]);
    const competeTimes = ref<Moment[]>([]);

    const createContest = () => {

      createContestModalVisible.value = true;
      // sponsor.value = record;
      formState.sponsorId = sponsorId;
      // console.log("sponsor", sponsor.value);

    };
    const createContestModalLoading = ref(false);
    const createContestModalVisible = ref(false);
    const handleCreateContestModalOk = () => {

      onSubmit();

      console.log("createForm1", formState);
      console.log("createForm2", toRaw(formState));
      // console.log("banDetails", banAccount.value);

      createContestModalLoading.value = true;

      // sponsor.value.password = hexMd5(sponsor.value.password + KEY);

      // formState.bannedtime = Moment(new Date());
      console.log("竞赛分类：", contestCategorys );

      formState.category = contestCategorys.value.join();
      formState.audience = audienceList.value.join();
      formState.registrationStartTime = registrationTimes.value[0];
      formState.registrationEndTime = registrationTimes.value[1];
      formState.competeStartTime = competeTimes.value[0];
      formState.competeEndTime = competeTimes.value[1];

      console.log("xxx", formState.registrationStartTime);
      console.log("yyy", new Date());
      console.log("zzz", moment().toDate());

      // formState.registrationStartTime = new Date();

      console.log("zzz", moment().toDate());

      axios.post("/sponsor/createContest", toRaw(formState)).then((response) => {
        createContestModalLoading.value = false;
        const data = response.data; // data = commonResp
        if (data.success) {
          createContestModalVisible.value = false;

          // 重新加载列表（？需要吗）
          handleQueryContest({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });

          //
          message.success("成功创建该比赛，快去看看吧！")


        } else {
          message.error(data.message);
        }
      });

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


      createContest,
      createContestModalLoading,
      createContestModalVisible,
      handleCreateContestModalOk,

      formRef,
      labelCol: {span: 4},
      wrapperCol: {span: 14},
      other: '',
      formState,
      rules,
      onSubmit,
      ResetBanForm,
      registrationTimes,
      competeTimes,
      contestCategorysOptions,
      contestCategorys,
      audienceOptions,
      audienceList,
      fileList1,


    }
  },


  components: {
    IconFont,
    // descriptionItem,
    UploadOutlined,
  },

});
</script>


<style scoped>

.cell-box {
  width: 400px;
  height: 200px;
  /*background-color: rgba(255, 255, 202, 10);*/
  /*background-image: url("/web/public/image/index-cover/sponsor.png");*/
  background-image: url("https://telegra.ph/file/08f817dbc6287d6b61bde.png");
  /*color: rgba(255, 255, 202, 10);*/
  text-align: center;
  position: relative;
}

.cell-box span {
  position: absolute;
  left: 50%;
  top: 50%;
  color: #1088e9;
  /*background: url("//image/index-cover/sponsor.png");*/
  font-size: 30px;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

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


.upload-list-inline :deep(.ant-upload-list-item) {
  float: left;
  width: 200px;
  margin-right: 8px;
}
.upload-list-inline :deep(.ant-upload-animate-enter) {
  animation-name: uploadAnimateInlineIn;
}
.upload-list-inline :deep(.ant-upload-animate-leave) {
  animation-name: uploadAnimateInlineOut;
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