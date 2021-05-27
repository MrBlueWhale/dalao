<template>
  <h3>这是比赛详情页面</h3>

  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: '5%',  }"
    >

      <div class="contest-detail-description" >
        <a-descriptions title="比赛详情" bordered size="small">
          <a-descriptions-item label="比赛名称"><h3>{{ contestDetail.contestName }}</h3></a-descriptions-item>
          <a-descriptions-item label="规模"><h3>{{ contestDetail.rank }}</h3></a-descriptions-item>
          <a-descriptions-item label="参赛者范围"><h3>{{ contestDetail.audience }}</h3></a-descriptions-item>

          <a-descriptions-item label="报名费"><h3>{{ contestDetail.entryFee }}元</h3></a-descriptions-item>
          <a-descriptions-item label="参赛方式"><h3>{{ contestDetail.type }}</h3></a-descriptions-item>
          <a-descriptions-item label="类别"><h3>{{ contestDetail.category }}</h3></a-descriptions-item>

          <a-descriptions-item label="报名开始时间"><h3>{{ contestDetail.registrationStartTime }}</h3></a-descriptions-item>
          <a-descriptions-item label="报名结束时间" :span="2"><h3>{{ contestDetail.registrationEndTime }}</h3>
          </a-descriptions-item>

          <a-descriptions-item label="比赛开始时间"><h3>{{ contestDetail.competeStartTime }}</h3></a-descriptions-item>
          <a-descriptions-item label="比赛结束时间" :span="2"><h3>{{ contestDetail.competeEndTime }}</h3></a-descriptions-item>

          <a-descriptions-item label="审核状态" :span="1">
            <a-badge v-if="contestDetail.contestStatus == 0" status="processing" text="待审核"/>
            <a-badge v-if="contestDetail.contestStatus == 1" status="success" text="已发布"/>
            <a-badge v-if="contestDetail.contestStatus == 8" status="error" text="已紧急撤销"/>
            <a-badge v-if="contestDetail.contestStatus == 9" status="error" text="已打回"/>

          </a-descriptions-item>

          <a-descriptions-item label="主办方名称" :span="1">
            <h3>{{ contestDetail.sponsorName }}</h3>
          </a-descriptions-item>

          <a-descriptions-item label="主办方头像" :span="1">
            <a-avatar size="large"  :src="contestDetail.sponsorAvatar" alt="avatar"/>
          </a-descriptions-item>


          <a-descriptions-item label="比赛介绍" :span="3">
            <h3>{{ contestDetail.contestIntro }}</h3>
          </a-descriptions-item>



        </a-descriptions>
      </div>

      <a-divider />

      <div class="note">
        <span>打回原因：太长了</span>
      </div>

      <a-divider />


      <div class="manage-buttons" style="text-align: center; margin-top: 30px">


          <a-button type="danger" shape="round" :disabled="contestDetail.contestStatus !== 9" @click="modifyContest(contestDetail.cid)" style="margin-left: 20%;" >
            修改
          </a-button>


      </div>

    </a-layout-content>
  </a-layout>

  <a-modal
      title="修改比赛"
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
// import E from 'wangeditor'


interface FormState {
  cid: number;

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
  name: 'SponsorContestDetail',
  setup() {
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
    const docs = ref();
    const loading = ref(false);

    const contest = ref();
    const contestDetail = ref();
    contestDetail.value = {};
    let str;

    const contestId = route.query.contestId;


    const passBtnDisabled = ref(false);
    const failBtnDisabled = ref(false);

    const recallBtnDisabled = ref(false);
    const recallBtnVisible = ref(false);

    const failNotifyModalLoading = ref(false);
    const failNotifyModalVisible = ref(false);
    const failNotify = ref();


    /**
     * 数据查询
     **/

    const handleQueryContestDetail = (cid:any) => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      axios.get("/admin/getContestDetail/" + cid
      ).then((response) => {
        loading.value = false;
        const data = response.data;
        console.log(data);

        if (data.success) {
          // for (let i = 0; i < sponsors.value.length; i++) {
          //   sponsors.value[i].joinDate = moment(sponsors.value[i].joinDate).format('YYYY-MM-DD HH:mm:ss')
          // }
          contestDetail.value = data.content;
          console.log("比赛详情：", contestDetail.value);

          // 如果比赛状态为待审核--（通过和打回两个按钮可用）
          if(contestDetail.value.contestStatus == 0){
            passBtnDisabled.value = false;
            failBtnDisabled.value = false;
          }else if(contestDetail.value.contestStatus == 1){
          //  比赛已发布----（通过和打回两个按钮不可用）
            passBtnDisabled.value = true;
            failBtnDisabled.value = true;

          }else if(contestDetail.value.contestStatus == 8){
          //  比赛已紧急撤回----（通过和打回两个按钮不可用）
            passBtnDisabled.value = false;
            failBtnDisabled.value = false;

          }else if(contestDetail.value.contestStatus == 9){
          //  比赛已打回（审核失败）----（通过和打回两个按钮不可用）
            passBtnDisabled.value = true;
            failBtnDisabled.value = true;

          }

          if (contestDetail.value.contestStatus == 1) {
            str = "running";
          } else {
            str = "end";
          }

        } else {
          message.error(data.message);
        }

      });
    };


    const openNotificationWithIcon = (type: string) => {
      notification[type]({
        message: '成功通知',
        description:
            '操作成功，比赛审核通过啦~',
      });
    };

    // TODO: 新建审核记录表--查看某比赛的审核记录--记录审核留言note--需要修改下面的前端api就扣

    const handlefailNotifyModalOk = () => {

      console.log("打回比赛，比赛ID：",contestId);

      failNotifyModalLoading.value = true;

      // // TODO: 后端api写完后把这个删掉---模拟请求成功后的button状态
      // passBtnDisabled.value = true;
      // failBtnDisabled.value = true;

      axios.get("/admin/failContestAudit/" + contestId
      ).then((response) => {
        loading.value = false;
        failNotifyModalLoading.value = false;

        const data = response.data;
        console.log(data);

        if (data.success) {
          failNotifyModalVisible.value = false;

          //审核失败后 重新获取一下该比赛的详情
          handleQueryContestDetail(contestId);
          // failBtnDisabled.value = true;

          notification['success']({
            message: '成功通知',
            description:
                '操作成功，比赛已打回，主办方收到你的消息啦~',
          });

        } else {
          message.error(data.message);
        }

      });


    }





    const notify = (cid: any) => {
      failNotifyModalVisible.value = true;

      console.log("打回比赛，比赛ID：",cid);
      // failNotifyModalLoading.value = true;

      // handlefailNotifyModalOk(cid);


    }


    let sponsorId = 2;
    let contestIdModify = -1;

    const formRef = ref();
    const formState: UnwrapRef<FormState> = reactive({

      cid: 0,

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

    const modifyContest = (cid: any) => {

      createContestModalVisible.value = true;
      // sponsor.value = record;
      formState.sponsorId = sponsorId;
      formState.cid = cid;
      contestIdModify = cid;

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

      axios.post("/sponsor/modifyContest", toRaw(formState)).then((response) => {
        createContestModalLoading.value = false;
        const data = response.data; // data = commonResp
        if (data.success) {
          createContestModalVisible.value = false;

          // 重新加载列表（？需要吗）
          handleQueryContestDetail(contestIdModify);

          //
          message.success("成功修改该比赛，快去看看吧！")


        } else {
          message.error(data.message);
        }
      });

    };



    onMounted(() => {
      console.log("contest-detail");

      console.log("比赛id：", contestId);

      handleQueryContestDetail(contestId);

    });

    return {
      param,
      contestDetail,
      loading,
      str,

      modifyContest,

      //按钮是否可用
      passBtnDisabled,
      failBtnDisabled,
      recallBtnDisabled,
      recallBtnVisible,

      failNotifyModalLoading,
      failNotifyModalVisible,
      handlefailNotifyModalOk,
      failNotify,

      // createContest,
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


      // docs,

    }
  },

  components: {
    // IconFont,
    // descriptionItem,
    UploadOutlined,
  },

});
</script>


<style>
.img {
  width: 50px;
  height: 50px;
}
</style>