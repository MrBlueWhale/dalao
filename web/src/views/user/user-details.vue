<template>
  <a-layout>
    <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
    >
      <a-descriptions title="比赛详情" bordered>
        <a-descriptions-item label="比赛名称"><h1>{{contestDetail.contestName}}</h1></a-descriptions-item>
        <a-descriptions-item label="规模"><h1>{{contestDetail.rank}}</h1></a-descriptions-item>
        <a-descriptions-item label="参赛者范围"><h1>{{contestDetail.audience}}</h1></a-descriptions-item>
        <a-descriptions-item label="报名开始时间"><h1>{{contestDetail.registrationStartTime}}</h1></a-descriptions-item>
        <a-descriptions-item label="报名结束时间" :span="2"><h1>{{contestDetail.registrationEndTime}}</h1></a-descriptions-item>
        <a-descriptions-item label="比赛开始时间"><h1>{{contestDetail.competeStartTime}}</h1></a-descriptions-item>
        <a-descriptions-item label="比赛结束时间" :span="2"><h1>{{contestDetail.competeEndTime}}</h1></a-descriptions-item>
        <a-descriptions-item label="Status" :span="3">
          <a-badge status="processing" text="Running" />
        </a-descriptions-item>
        <a-descriptions-item label="报名费"><h1>{{contestDetail.entryFee}}</h1></a-descriptions-item>
        <a-descriptions-item label="参赛方式"><h1>{{contestDetail.type}}</h1></a-descriptions-item>
        <a-descriptions-item label="类别"><h1>{{contestDetail.category}}</h1></a-descriptions-item>
        <a-descriptions-item label="比赛介绍">
          <h1>{{contestDetail.contestIntro}}</h1>
        </a-descriptions-item>
      </a-descriptions>
    </a-layout-content>
  </a-layout>

</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import axios from 'axios';

  import {useRoute} from "vue-router";

  export default defineComponent({
    name: 'UserRecord',
    setup() {

      const route = useRoute();
      console.log("路由：", route);
      console.log("route.path：", route.path);
      console.log("route.query：", route.query);
      console.log("route.param：", route.params);
      console.log("route.fullPath：", route.fullPath);
      console.log("route.name：", route.name);
      console.log("route.meta：", route.meta);

      const contest = ref();
      const loading = ref(false);

      const contestDetail = ref();
      contestDetail.value = {};
      var str;

      const contestId = route.query.cid;

      /**
       * 数据查询
       **/
      const handleQuery = (params: any) => {
        loading.value = true;
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        axios.get("/contest/detail", {
          params:{
            cid: params.cid
          }
                }
        ).then((response) => {
          loading.value = false;
          const data = response.data;
          console.log(data);
          contestDetail.value = data.content;
          console.log("比赛详情：", contestDetail);
          if(contestDetail.value.contestStatus==1){
            str = "running";
          }else {
            str = "end";
          }
        });
      };


      onMounted(()=> {

        console.log("比赛id：", contestId);

        handleQuery({
          cid: contestId,
        })

      });



      return {
        contestDetail,
        loading,
        str,
      }
    }
  });

</script>

<style scoped>
  img {
    width: 50px;
    height: 50px;
  }
</style>
