<template>
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

        <a-menu-item key="notCertified">
          <!--            <icon-font class="icons-bar" type="icon-weirenzheng" style="font-size:24px"/>-->
          <icon-font class="icons-bar" type="icon-weirenzheng"/>
          <span>未认证</span>
        </a-menu-item>
        <a-menu-item key="underReview">
          <icon-font class="icons-bar" type="icon-shenhezhong1"/>
          <span>审核中</span>
        </a-menu-item>
        <a-menu-item key="verified">
          <icon-font class="icons-bar" type="icon-yirenzheng6"/>
          <span>已认证</span>
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
          <h1>欢迎使用管理比赛主办方功能</h1>
        </div>


        <layout v-show="!isShowWelcome">

          <div class="about">
            <h1>电子书管理</h1>
          </div>

          <p>
            <a-form layout="inline" :model="param">
              <a-form-item>
                <a-input v-model:value="param.name" placeholder="名称">
                </a-input>
              </a-form-item>
              <a-form-item>
                <a-button type="primary" @click="handleQuerySponsor({page: 1, size: pagination.pageSize})">
                  查询
                </a-button>
              </a-form-item>
              <a-form-item>
                <a-button type="primary" @click="add()">
                  新增
                </a-button>
              </a-form-item>
            </a-form>
          </p>

          <a-table
              :columns="columns"
              :row-key="record => record.sid"
              :data-source="sponsors"
              :pagination="pagination"
              :loading="loading"
              @change="handleTableChange"
          >
            <!--          定义对封面的渲染-->
            <template #avatar="{ text: avatar }">
              <!--            <img v-if="avatar" :src="avatar" alt="avatar"/>-->
              <a-avatar size="large" v-if="avatar" :src="avatar" alt="avatar"/>
            </template>

            <template #identityStatus="{ text: identityStatus }">
              <a-tag :identity_status="identityStatus">{{ identityStatus }}</a-tag>
            </template>


            <!--          &lt;!&ndash;          定义对按钮的渲染&ndash;&gt;-->
            <!--          <template v-slot:categoryT="{ text, record }">-->
            <!--            <span>{{ getCategoryName(record.category1Id) }} / {{ getCategoryName(record.category2Id) }}</span>-->
            <!--          </template>-->

            <template v-slot:action="{ text, record }">
              <!--            空格组件：两个按钮之间的空格-->
              <a-space size="small">
                <router-link :to="'/admin/contest?sponsorId=' + record.sid">
                  <a-button type="primary">
                    竞赛管理
                  </a-button>
                </router-link>

                <a-button type="primary" @click="viewDetails(record)">
                  <!--              <a-button type="primary" @click="resetPassword">-->
                  查看详情
                </a-button>

                <a-button type="primary" @click="resetPassword(record)">
                  重置密码
                </a-button>
                <a-popconfirm
                    title="封禁后该账号功能受限，确认封禁?"
                    ok-text="是"
                    cancel-text="否"
                    @confirm="banAccount(record.sid)"
                >
                  <a-button type="danger">
                    封禁账号
                  </a-button>
                </a-popconfirm>
              </a-space>
            </template>
          </a-table>
        </layout>


        通过ref():
        <pre>{{ demos }}</pre>
        <br/>
      </a-layout-content>
    </a-layout>

    <template>
      <a-drawer width="640" placement="right" :closable="false" :visible="visible" @close="onClose">
        <p :style="[pStyle, pStyle2]">主办方详情资料</p>
        <p :style="pStyle">概况</p>
        <a-row>
          <a-col :span="12">
            <!--            <description-item title="Name" content="{{ sponsorDetail.name }}"/>-->
            <a-descriptions>
              <a-descriptions-item label="机构名称">{{ sponsorDetail.name }}</a-descriptions-item>
            </a-descriptions>
          </a-col>
          <a-col :span="12">
            <!--            <description-item title="Account" content="AntDesign@example.com"/>-->
            <a-descriptions>
              <a-descriptions-item label="账号状态">{{ sponsorDetail.identityStatus }}</a-descriptions-item>
            </a-descriptions>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <!--            <description-item title="Name" content="{{ sponsorDetail.name }}"/>-->
            <a-descriptions>
              <a-descriptions-item label="机构所在地">中国 浙江 杭州</a-descriptions-item>
            </a-descriptions>
          </a-col>
          <a-col :span="12">
            <!--            <description-item title="Account" content="AntDesign@example.com"/>-->
            <a-descriptions>
              <a-descriptions-item label="入驻时间">{{ sponsorDetail.joinDate }}</a-descriptions-item>
            </a-descriptions>
          </a-col>
        </a-row>

        <a-divider/>
        <p :style="pStyle">主办方简介</p>
        <a-row>
          <a-descriptions>
            <a-descriptions-item>{{ sponsorDetail.intro }}</a-descriptions-item>
          </a-descriptions>
        </a-row>
        <a-divider/>
        <p :style="pStyle">联系方式</p>
        <a-row>
          <a-col :span="12">
            <a-descriptions>
              <a-descriptions-item label="邮件地址">{{ sponsorDetail.email }}</a-descriptions-item>
            </a-descriptions>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-descriptions>
              <a-descriptions-item label="机构电话">{{ sponsorDetail.telNum }}</a-descriptions-item>
            </a-descriptions>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-descriptions>
              <a-descriptions-item label="通信地址">{{ sponsorDetail.address }}</a-descriptions-item>
            </a-descriptions>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-descriptions>
              <a-descriptions-item label="机构代表人">兰鑫</a-descriptions-item>
            </a-descriptions>
          </a-col>
        </a-row>
        <a-divider/>
        <p :style="pStyle">机构证书</p>
        <a-row>
          <img class="certify-img" src="/image/certification-imgs/test1.jpg" alt="avatar"/>
        </a-row>
        <a-divider/>
        <div
            :style="{
        position: 'absolute',
        bottom: 0,
        width: '100%',
        borderTop: '1px solid #e8e8e8',
        padding: '10px 16px',
        textAlign: 'right',
        left: 0,
        background: '#fff',
        borderRadius: '0 0 4px 4px',
      }"
        >
          <a-button style="margin-right: 8px" @click="onClose">退出浏览</a-button>
        </div>

      </a-drawer>
    </template>

  </a-layout>


  <div id="components-back-top-demo-custom">
    <a-back-top/>
    Scroll down to see the bottom-right
    <strong style="color: rgba(64, 64, 64, 0.6)"> gray </strong>
    button.
  </div>

  <a-modal
      title="重置密码"
      v-model:visible="resetModalVisible"
      :confirm-loading="resetModalLoading"
      @ok="handleResetModalOk"
  >
    <a-form :model="sponsor" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="新密码">
        <a-input v-model:value="sponsor.password" type="password"/>
      </a-form-item>
    </a-form>
  </a-modal>



</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';
import {createFromIconfontCN} from '@ant-design/icons-vue';
import {message} from 'ant-design-vue';
import {Tool} from "@/util/tool";

import descriptionItem from './descriptionItem/index.vue';


import axios from 'axios';

const IconFont = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/font_2558111_009ekmettrll3.js',
});

declare let hexMd5: any;
declare let KEY: any;


// import HelloWorld from "@/components/HelloWorld.vue";

// const listData: Record<string, string>[] = [];
const listData: any = [];

let identity_status_o = '';

for (let i = 0; i < 23; i++) {

  identity_status_o = i % 3 === 0 ? '已认证' : (i % 3 === 1 ? '审核中' : '未认证');

  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
    identity_status: identity_status_o
  });
}


export default defineComponent({
  name: 'AdminSponsor',

  //放一些参数定义，方法定义
  setup() {
    console.log("setup");
    // 使用ref()定义响应式数据
    const demos = ref();
    //reactive中放入对象 并自定义属性
    const demos2 = reactive({demos: []});

    const param = ref();
    param.value = {};
    const sponsors = ref();
    const pagination = ref({
      current: 1,
      pageSize: 2,
      total: 0
    });

    const loading = ref(false);
    const columns = [
      {
        title: '头像',
        dataIndex: 'avatar',
        slots: {customRender: 'avatar'}
      },
      {
        title: '名称',
        dataIndex: 'name'
      },
      {
        title: '通讯地址',
        dataIndex: 'address',
        slots: {customRender: 'address'}
      },
      {
        title: '认证状态',
        key: 'identityStatus',
        dataIndex: 'identityStatus',
        slots: {customRender: 'identityStatus'}
      },
      // {
      //   title: '主办方简介',
      //   key: 'intro',
      //   dataIndex: 'intro'
      // },
      {
        title: '入驻时间',
        dataIndex: 'joinDate'
      },
      {
        title: '联系电话',
        dataIndex: 'telNum'
      },
      {
        title: '邮箱地址',
        dataIndex: 'email'
      },
      {
        title: 'Action',
        key: 'action',
        slots: {customRender: 'action'}
      }
    ];

    const isShowWelcome = ref(true);

    let identity_status = '';
    let identityMap = new Map()
    identityMap.set('notCertified', '未认证')
    identityMap.set('underReview', '审核中')
    identityMap.set('verified', '已认证')

    const handleQuerySponsor = (params: any) => {
      axios.get("/admin/listSponsor", {
        params: {
          page: params.page,
          size: params.size,
          identityStatus: identity_status,
          name: param.value.name,
        }
      }).then((response) => {
        const data = response.data;
        //ref数据的赋值
        sponsors.value = data.content.list;
        // ebooks2.books = data.content;

        // console.log(response)

        if (data.success) {
          sponsors.value = data.content.list;

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
        identity_status = identityMap.get(value.key);
        isShowWelcome.value = false;
        //这里本应该去查询数据库里所有的主办方数据 而我写死了只查前1000条 可以另写个all方法
        handleQuerySponsor({
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
      handleQuerySponsor({
        page: pagination.current,
        size: pagination.pageSize
      });
    };

    const sponsorDetail = ref({});
    const visible = ref<boolean>(false);
    const pStyle = {
      fontSize: '16px',
      color: 'rgba(0,0,0,0.85)',
      lineHeight: '24px',
      display: 'block',
      marginBottom: '16px',
    };
    const pStyle2 = {
      marginBottom: '24px',
    };

    const showDrawer = () => {
      visible.value = true;
    };

    const onClose = () => {
      visible.value = false;
    };

    const viewDetails = (record: any) => {
      console.log("拿到的数据：", record);
      console.log("该行数据的id：", record.sid);

      axios.get("/admin/getSponsorDetail", {
            params: {
              sid: record.sid
            }
          }
      ).then((response) => {
        const data = response.data;
        console.log(data);
        sponsorDetail.value = data.content;
        console.log("主办方详情：", sponsorDetail);
        // if(contestDetail.value.sponsorDetail==1){
        //   str = "running";
        // }else {
        //   str = "end";
        // }
      });


      visible.value = true;

    };

    const sponsor = ref({
      password: '',
    });

    // -------- 重置密码 ---------
    const resetModalVisible = ref(false);
    const resetModalLoading = ref(false);

    const handleResetModalOk = () => {
      resetModalLoading.value = true;

      // sponsor.value.password = hexMd5(sponsor.value.password + KEY);

      axios.post("/admin/resetSponsorPassword", sponsor.value).then((response) => {
        resetModalLoading.value = false;
        const data = response.data; // data = commonResp
        if (data.success) {
          resetModalVisible.value = false;

          // 重新加载列表（？需要吗）
          handleQuerySponsor({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });

        //
          message.success("重置成功！")


        } else {
          message.error(data.message);
        }
      });
    };


    const resetPassword = (record: any) => {
      resetModalVisible.value = true;
      console.log("拿到的数据：", record);
      console.log("该行数据的id：", record.sid);

      // resetModalVisible.value = true;
      sponsor.value = Tool.copy(record);
      sponsor.value.password = '';
      // let password = '123456';

      console.log("sponsor", sponsor.value);

      // // axios.post("/admin/resetSponsorPassword", user.value).then((response) => {
      // axios.post("/admin/resetSponsorPassword", sponsor.value
      // //     {
      // //     sid: record.sid,
      // //     password: password,
      // //
      // // // }).then((response) => {
      // // // axios.put("/admin/resetSponsorPassword", {
      // // //   sid: record.sid,
      // // //   password: sponsor.value.password,
      // // }
      // ).then((response) => {
      //   // modalLoading.value = false;
      //   const data = response.data; // data = commonResp
      //   if (data.success) {
      //     // modalVisible.value = false;
      //
      //     console.log(sponsor.value.password);
      //
      //     // 重新加载列表
      //     handleQuerySponsor({
      //       page: pagination.value.current,
      //       size: pagination.value.pageSize,
      //     });
      //   } else {
      //     message.error(data.message);
      //   }
      // });


      // axios.p
    };

    const banAccount = (sid: any) => {
      console.log("该行数据的id：", sid);
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

    //html代码要拿到响应式变量 需要在setup的最后return
    return {
      demos,
      demos_reactive: toRef(demos2, "demos"),
      listData,
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

      sponsors,
      loading,
      columns,

      pagination,
      handleTableChange,

      isShowWelcome,


      handleClick,
      handleQuerySponsor,


      //抽屉板块
      visible,
      pStyle,
      pStyle2,
      viewDetails,
      onClose,
      sponsorDetail,

      sponsor,
      resetPassword,
      resetModalVisible,
      resetModalLoading,
      handleResetModalOk,


      banAccount,


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