<template>
  <h1>这是比赛详情页面</h1>

  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
    >

      <div class="contest-detail-description" style="">
        <a-descriptions title="比赛详情" bordered>
          <a-descriptions-item label="比赛名称"><h1>{{ contestDetail.contestName }}</h1></a-descriptions-item>
          <a-descriptions-item label="规模"><h1>{{ contestDetail.rank }}</h1></a-descriptions-item>
          <a-descriptions-item label="参赛者范围"><h1>{{ contestDetail.audience }}</h1></a-descriptions-item>

          <a-descriptions-item label="报名费"><h1>{{ contestDetail.entryFee }}元</h1></a-descriptions-item>
          <a-descriptions-item label="参赛方式"><h1>{{ contestDetail.type }}</h1></a-descriptions-item>
          <a-descriptions-item label="类别"><h1>{{ contestDetail.category }}</h1></a-descriptions-item>

          <a-descriptions-item label="报名开始时间"><h1>{{ contestDetail.registrationStartTime }}</h1></a-descriptions-item>
          <a-descriptions-item label="报名结束时间" :span="2"><h1>{{ contestDetail.registrationEndTime }}</h1>
          </a-descriptions-item>

          <a-descriptions-item label="比赛开始时间"><h1>{{ contestDetail.competeStartTime }}</h1></a-descriptions-item>
          <a-descriptions-item label="比赛结束时间" :span="2"><h1>{{ contestDetail.competeEndTime }}</h1></a-descriptions-item>

          <a-descriptions-item label="审核状态" :span="1">
            <a-badge v-if="contestDetail.contestStatus == 0" status="processing" text="待审核"/>
            <a-badge v-if="contestDetail.contestStatus == 1" status="success" text="已发布"/>
            <a-badge v-if="contestDetail.contestStatus == 8" status="error" text="已紧急撤销"/>
            <a-badge v-if="contestDetail.contestStatus == 9" status="error" text="已打回"/>

          </a-descriptions-item>

          <a-descriptions-item label="主办方名称" :span="1">
            <h1>{{ contestDetail.sponsorName }}</h1>
          </a-descriptions-item>

          <a-descriptions-item label="主办方头像" :span="1">
            <a-avatar size="large"  :src="contestDetail.sponsorAvatar" alt="avatar"/>
          </a-descriptions-item>


          <a-descriptions-item label="比赛介绍" :span="3">
            <h1>{{ contestDetail.contestIntro }}</h1>
          </a-descriptions-item>



        </a-descriptions>
      </div>

      <div class="manage-buttons" style="text-align: center; margin-top: 30px">

        <a-popconfirm
            title="确认发布后比赛就能被参赛者看到了，确认通过?"
            ok-text="是"
            cancel-text="否"
            @confirm="pass(contestDetail.cid)"
        >
          <a-button type="primary" shape="round" :disabled="passBtnDisabled">
            通过/发布
          </a-button>
        </a-popconfirm>

        <a-popconfirm
            title="打回后主办方需要重新提交比赛信息，确认打回?"
            ok-text="是"
            cancel-text="否"
            @confirm="notify(contestDetail.cid)"
        >
          <a-button type="danger" shape="round" :disabled="failBtnDisabled" style="margin-left: 20%;" >
            打回/提醒
          </a-button>
        </a-popconfirm>

<!--        <a-button type="primary" shape="round" :disabled="passBtnDisabled" @click="pass(contestDetail.cid)">通过/发布</a-button>-->
<!--        <a-button type="danger" shape="round" :disabled="failBtnDisabled" style="margin-left: 20%;"  @click="notify(contestDetail.cid)">打回/提醒</a-button>-->
      </div>

<!--      <div class="recall-contest" :visible="recallBtnVisible" style="text-align: center; margin-top: 30px">-->
<!--        <a-button type="danger" shape="round" :disabled="recallBtnDisabled"  style="margin-left: 20%;"  @click="recallContest(contestDetail.cid)">撤销比赛</a-button>-->
<!--      </div>-->

    </a-layout-content>
  </a-layout>

  <a-modal
      title="填写打回理由"
      width="600px"
      v-model:visible="failNotifyModalVisible"
      :confirm-loading="failNotifyModalLoading"
      @ok="handlefailNotifyModalOk"
      okText="确认"
  >
        <a-textarea v-model:value="failNotify"/>

  </a-modal>

</template>


<script lang="ts">

import {defineComponent, onMounted, ref, createVNode} from 'vue';
import axios from 'axios';

import {message, Modal, notification} from 'ant-design-vue';
import {Tool} from "@/util/tool";
import {useRoute} from "vue-router";
import ExclamationCircleOutlined from "@ant-design/icons-vue/ExclamationCircleOutlined";
import moment from "moment";
// import E from 'wangeditor'

export default defineComponent({
  name: 'AdminContestDetail',
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

    const pass = (cid: any) => {
      console.log("通过审核，比赛ID：",cid);

      loading.value = true;

      // // TODO: 后端api写完后把这个删掉---模拟请求成功后的button状态
      // passBtnDisabled.value = true;
      // failBtnDisabled.value = true;


      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      axios.get("/admin/passContestAudit/" + cid
      ).then((response) => {
        loading.value = false;
        const data = response.data;
        console.log(data);

        if (data.success) {

          //审核通过后 重新获取一下该比赛的详情
          handleQueryContestDetail(cid);
          // passBtnDisabled.value = true;

          notification['success']({
            message: '成功通知',
            description:
                '操作成功，比赛审核通过啦~',
          });


        } else {
          message.error(data.message);
        }

      });


    }

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

    const recallContest = (cid: any) => {
      console.log("紧急撤回比赛，比赛ID：",cid);

      loading.value = true;

      axios.get("/admin/recallContest/" + cid
      ).then((response) => {
        loading.value = false;
        const data = response.data;
        console.log(data);

        if (data.success) {

          //召回比赛后 重新获取一下该比赛的详情
          handleQueryContestDetail(cid);
          // failBtnDisabled.value = true;

        } else {
          message.error(data.message);
        }

      });



    }


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

      pass,
      notify,
      recallContest,

      //按钮是否可用
      passBtnDisabled,
      failBtnDisabled,
      recallBtnDisabled,
      recallBtnVisible,

      failNotifyModalLoading,
      failNotifyModalVisible,
      handlefailNotifyModalOk,
      failNotify,

      // docs,

    }
  }
});
</script>


<style>
img {
  width: 50px;
  height: 50px;
}
</style>