<template>
  <div style="background-color: #ececec; padding: 20px">
    <a-row :gutter="22">
      <a-col :span="7">
        <a-card :title="`你好,${participant.name}`" :bordered="false">
          <p>{{participant.university}}-{{participant.college}}-{{participant.major}}</p>
        </a-card>
      </a-col>
      <a-col :span="4">
        <a-card title="共参加比赛" :bordered="false">
          <p>16场</p>
        </a-card>
      </a-col>
      <a-col :span="4">
        <a-card title="待参加比赛" :bordered="false">
          <p>5场</p>
        </a-card>
      </a-col>
      <a-col :span="4">
        <a-card title="大赛证书" :bordered="false">
          <p>8项</p>
        </a-card>
      </a-col>
      <a-col :span="4">
        <a-card title="比赛通过率" :bordered="false">
          <p>80%</p>
        </a-card>
      </a-col>
    </a-row>
  </div>

  <div :style="{ width: '1500px', border: '1px solid #d9d9d9', borderRadius: '4px',background: '#ececec'}">
    <a-calendar v-model:value="value" :fullscreen="false">
      <template #dateCellRender="{ current: value }">
        <ul class="events">
          <li v-for="item in getListData(value)" :key="item.content">
            <a-badge :status="item.type" :text="item.content" />
          </li>
        </ul>
      </template>
      <template #monthCellRender="{ current: value }">
        <div v-if="getMonthData(value)" class="notes-month">
          <section>{{ getMonthData(value) }}</section>
          <span>Backlog number</span>
        </div>
      </template>
    </a-calendar>
  </div>
  <a-steps :current="1" size="small">
    <a-step title="Finished" />
    <a-step title="In Progress" />
    <a-step title="Waiting" />
  </a-steps>

</template>
<script lang="ts">
  import {defineComponent, onMounted, ref} from 'vue';
  import { Moment } from 'moment';
  import axios from "axios";

  import {useRoute} from "vue-router";
  export default defineComponent({
    name:'UserDate',
    setup() {
      const value = ref<Moment>();
      const getListData = (value: Moment) => {
        let listData;
        switch (value.date()) {
          case beginDate.getDate():
            if(value.month()==beginDate.getMonth()&&value.year()==beginDate.getFullYear()){
              if(nowDate<beginDate){
                listData = [
                  { type: 'warning', content: '未开始' },
                ];
              }else if(nowDate>=beginDate&&nowDate<=endDate){
                listData = [
                  { type: 'error', content: '进行中' },
                ];
              }else {
                listData = [
                  { type: 'success', content: '已结束' },
                ];
              }

            }
            break;
          default:
        }
        return listData || [];
      };

      const getMonthData = (value: Moment) => {
        if (value.month() === 8) {
          return 1394;
        }
      };

      const route = useRoute();
      const participant = ref();
      participant.value = {};
      const contestDetail = ref();
      contestDetail.value = {};
      //用来得到传入此页面的用户id
      //由于现在无数据，先写死
      //const participantId = route.query.pid;

      let nowDate = new Date();
      let beginDate = new Date();
      let endDate = new Date();
      /**
       * 数据查询
       **/
      const handleQuery = (params: any) => {
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        axios.get("/participant/pdetail", {
                  params:{
                    pid: params.pid
                  }
                }
        ).then((response) => {
          const data = response.data;
          console.log(data);
          participant.value = data.content;
          console.log("个人信息：", participant);
        });
      };
      //查询所有比赛
      const handleQuery1 = (params: any) => {
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        axios.get("/contest/detail", {
                  params:{
                    cid: params.cid
                  }
                }
        ).then((response) => {
          const data = response.data;
          console.log(data);
          contestDetail.value = data.content;

          beginDate = new Date(contestDetail.value.competeStartTime);
          endDate = new Date(contestDetail.value.competeEndTime);
        });
      };


      onMounted(()=> {

        //console.log("比赛id：", contestId);

        handleQuery({
          pid: 1,
        });
        handleQuery1({
          cid: 1,
        })

      });


      return {
        value,
        getListData,
        getMonthData,
        participant,
        contestDetail,
        nowDate,
        beginDate,
        endDate,
      };
    },
  });
</script>
<style scoped>
  img {
    width: 50px;
    height: 50px;
  }
</style>