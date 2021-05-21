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
            layout="inline"
            :model="participant"
    >
      <a-form-item>
        <a-input v-model:value="participant.password" type="password" placeholder="请输入当前密码">
          <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input v-model:value="participant.password"  placeholder="请输入新密码">
          <template #prefix><LockOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-button
                type="primary"
                html-type="submit"
                :disabled="participant.password === '' || participant.password === ''"
                @click="handleModalEdit"
        >
          修改
        </a-button>
      </a-form-item>
    </a-form>
    </a-layout-content>
  </a-layout>
</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';

import axios from 'axios';

// import HelloWorld from "@/components/HelloWorld.vue";


export default defineComponent({
  name: 'UserSafety',

  //放一些参数定义，方法定义
  setup() {

    // const participants = ref();
    const loading = ref(false);
    const participant = ref({
      // nickname: '',
      // grade: undefined,
      // date: undefined,
      // name: '',
    })

    /**
     * 密码查询
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


    onMounted(()=> {
      handleQuery({
        //真正传递到后端的page和size的名字，需要与后端中pageReq中的参数值保持一致，才能完成映射
      });
    });
    //html代码要拿到响应式变量 需要在setup的最后return
    return {
      participant,
      // pagination,
      // columns,
      loading,
      // handleTableChange,
      // labelCol: { span: 4 },
      // wrapperCol: { span: 14 },
      // onSubmit,

      // edit,
      // modalVisible,
      // modalLoading,
      handleModalEdit
    }
  },


  components: {

  },

});
</script>




<style scoped>
/*img {*/
/*  width: 50px;*/
/*  height: 50px;*/
/*}*/
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