<template>
  <a-back-top />
  <strong style="color: rgba(64, 64, 64, 0.6)"></strong>
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
          <span>个人资料</span>
          <router-link to="/user/profile"></router-link>
        </a-menu-item>
        <a-sub-menu key="sub2">
          <template #title>
              <span>
                <desktop-outlined />
                安全中心
              </span>
          </template>
          <a-menu-item key="6"><FormOutlined />修改密码<router-link to="/user/safety"></router-link></a-menu-item>

          <a-menu-item key="7"><ScheduleOutlined />安全防护<router-link to="/user/date"></router-link></a-menu-item>
        </a-sub-menu>
        <a-menu-item key="8">
          <notification-outlined />
          <span>关于我们</span>
          <router-link to="/user/about"></router-link>
        </a-menu-item>

      </a-menu>
    </a-layout-sider>
    <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
    >
      <a-form
              :model="participant"
              :label-col="labelCol"
              :wrapper-col="wrapperCol"
              :data-source="participant">

        <a-form-item label="头像">
          <a-avatar :size="50" v-model:src="participant.avatar" />
        </a-form-item>

        <a-form-item label="用户名">
          <a-input v-model:value="participant.nickname" />
        </a-form-item>

        <a-form-item label="真实姓名">
          <a-input v-model:value="participant.name" type="textarea" />
        </a-form-item>

        <a-form-item label="就读学校">
          <a-input v-model:value="participant.university"  type="textarea" />
        </a-form-item>

        <a-form-item label="学院">
          <a-input v-model:value="participant.college" />
        </a-form-item>

        <a-form-item label="专业">
          <a-input v-model:value="participant.major" />
        </a-form-item>

        <a-form-item label="年级">
          <a-select v-model:value="participant.grade" placeholder="请选择你的年级">
            <a-select-option value="本科一年级">本科一年级</a-select-option>
            <a-select-option value="本科二年级">本科二年级</a-select-option>
          </a-select>
        </a-form-item>

        <a-form-item label="认证学号">
          <a-input v-model:value="participant.studentId" />
        </a-form-item>

        <a-form-item label="手机号码">
          <a-input v-model:value="participant.telNum" />
        </a-form-item>

        <a-form-item label="电子邮箱">
          <a-input v-model:value="participant.email" />
        </a-form-item>

        <a-form-item label="身份证号">
          <a-input v-model:value="participant.idNumber" />
        </a-form-item>

        <a-form-item label="注册时间">
          <a-date-picker
                  v-model:value="participant.joinDate"
                  show-time
                  type="date"
                  placeholder="选择日期"
                  style="width: 100%"
          />
        </a-form-item>
        <!--<a-form-item label="Instant delivery">-->
          <!--<a-switch v-model:checked="formState.delivery" />-->
        <!--</a-form-item>-->
        <!--<a-form-item label="Activity type">-->
          <!--<a-checkbox-group v-model:value="formState.type">-->
            <!--<a-checkbox value="1" name="type">Online</a-checkbox>-->
            <!--<a-checkbox value="2" name="type">Promotion</a-checkbox>-->
            <!--<a-checkbox value="3" name="type">Offline</a-checkbox>-->
          <!--</a-checkbox-group>-->
        <!--</a-form-item>-->
        <!--<a-form-item label="Resources">-->
          <!--<a-radio-group v-model:value="formState.resource">-->
            <!--<a-radio value="1">Sponsor</a-radio>-->
            <!--<a-radio value="2">Venue</a-radio>-->
          <!--</a-radio-group>-->
        <!--</a-form-item>-->

        <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
          <a-button type="primary" @click="handleModalEdit">确认修改</a-button>
          <!--<a-button style="margin-left: 10px">Cancel</a-button>-->
        </a-form-item>
      </a-form>

      <!--<a-table-->
              <!--:columns="columns"-->
              <!--:row-key="record => record.cid"-->
              <!--:data-source="contests"-->
              <!--:pagination="pagination"-->
              <!--:loading="loading"-->
              <!--@change="handleTableChange"-->
      <!--&gt;-->
        <!--<template v-slot:action="{ text, record }">-->
          <!--<a-space size="small">-->
            <!--<router-link :to="'/user/details?cid=' + record.cid">-->
              <!--<a-button type="primary">-->
                <!--详情-->
              <!--</a-button>-->
            <!--</router-link>-->
          <!--</a-space>-->
        <!--</template>-->
      <!--</a-table>-->
    </a-layout-content>
  </a-layout>

  <a-modal
          title="个人资料表单"
          v-model:visible="modalVisible"
          :confirm-loading="modalLoading"
          @ok="handleModalEdit"
  >
    <p>test</p>
  </a-modal>

</template>

<script lang="ts">
  import { Moment } from 'moment';
  import { defineComponent, reactive, toRaw, UnwrapRef, onMounted, ref } from 'vue';
  import axios from 'axios';

  interface Participants {
    avatar: string;
    nickname: string;
    name: string;
    grade: string | undefined;
    university: string;
    college: string;
    major: string;
    date1: Moment | undefined;
  }
  export default defineComponent({
    name: 'UserProfile',
    setup() {
      // const participants = ref();
      //分页组件
      const pagination = ref({
        current: 1,
        pageSize: 3,
        total: 0
      });
      const loading = ref(false);
      const participant = ref({
        // nickname: '',
        // grade: undefined,
        // date: undefined,
        // name: '',
      })


      const onSubmit = () => {
        console.log('submit!', toRaw(participant));
        // participant.value = true;
      };

      // const columns = [
      //   {
      //     title: '比赛名称',
      //     dataIndex: 'contestName'
      //   },
      //   {
      //     title: '开始时间',
      //     dataIndex: 'competeStartTime'
      //   },
      //   {
      //     title: '结束时间',
      //     dataIndex: 'competeEndTime'
      //   },
      //   {
      //     title: '类型',
      //     dataIndex: 'type'
      //   },
      //   {
      //     title: '类别',
      //     dataIndex: 'category'
      //   },
      //   {
      //     title: '报名费',
      //     dataIndex: 'entryFee'
      //   },
      //   {
      //     title: '范围',
      //     dataIndex: 'rank'
      //   },
      //   {
      //     title: 'Action',
      //     key:'action',
      //     slots:{customRender:'action'}
      //   }
      // ];

      /**
       * 数据查询
       **/
      const handleQuery = (params: any) => {
        loading.value = true;
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        axios.get("/participant/detail", {
          params:{
            pid: 1
          }
        }).then((response) => {
          loading.value = false;
          const data = response.data;
          console.log(data)
          participant.value = data.content;

        });
      };


      /**
       * 表格点击页码时触发
       */
      const handleTableChange = (pagination: any) => {
        console.log("看看自带的分页参数都有啥：" + pagination);
        handleQuery({
          page: pagination.current,
          size: pagination.pageSize
        });
      };

      //表单
      const modalVisible = ref(false);
      const modalLoading = ref(false);
      const handleModalEdit = () => {
        // modalLoading.value = true;
        axios.post("/participant/save", participant.value).then((response) =>{

          const data = response.data;  //data= commonResp
          if(data.success){
            //重新加载列表
            handleQuery({});
          }
        });
      };

      //编辑
      // const edit = () => {
      //   modalVisible.value = true;
      // };
      const edit = (record: any) =>{
        modalVisible.value = true;
        participant.value = record;
      }

      //进入此页面时初始从这里运行进行查询，此时应该显示列表的第一页数据
      onMounted(()=> {
        handleQuery({
          //真正传递到后端的page和size的名字，需要与后端中pageReq中的参数值保持一致，才能完成映射
          page: 1,
          size: pagination.value.pageSize
        });
      });



      return {
        // contests,
        participant,
        pagination,
        // columns,
        loading,
        handleTableChange,
        labelCol: { span: 4 },
        wrapperCol: { span: 14 },
        onSubmit,

        edit,
        modalVisible,
        modalLoading,
        handleModalEdit
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
