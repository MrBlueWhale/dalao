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
          <MailOutlined />
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
              :row-key="record => record.id"
              :data-source="sponsors"
              :pagination="pagination"
              :loading="loading"
              @change="handleTableChange"
          >
            <!--          定义对封面的渲染-->
            <template #avatar="{ text: avatar }">
              <!--            <img v-if="avatar" :src="avatar" alt="avatar"/>-->
              <a-avatar size="large" v-if="avatar" :src="avatar" alt="avatar" />
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
                <router-link :to="'/admin/contest?sponsorId=' + record.id">
                  <a-button type="primary">
                    竞赛管理
                  </a-button>
                </router-link>

                <a-button type="primary" @click="viewDetails(record)">
                  <!--              <a-button type="primary" @click="edit">-->
                  查看详情
                </a-button>

                <a-button type="primary" @click="edit(record)">
                  <!--              <a-button type="primary" @click="edit">-->
                  编辑
                </a-button>
                <a-popconfirm
                    title="删除后不可恢复，确认删除?"
                    ok-text="是"
                    cancel-text="否"
                    @confirm="handleDelete(record.id)"
                >
                  <a-button type="danger">
                    删除
                  </a-button>
                </a-popconfirm>
                <!--              <a-button type="danger" @click="handleDelete(record.id)">-->
                <!--                删除-->
                <!--              </a-button>-->
              </a-space>
            </template>
          </a-table>
        </layout>


        <!--        <a-list item-layout="vertical" size="large" :pagination="pagination" :grid="{ gutter: 20, column: 1 }"-->
        <!--                :data-source="sponsors">-->
        <!--          <template #footer>-->
        <!--            <div>-->
        <!--              <b>ant design vue</b>-->
        <!--              footer part-->
        <!--            </div>-->
        <!--          </template>-->

        <!--          <template #renderItem="{ item }">-->

        <!--            <a-list-item key="item.title">-->
        <!--              <a-tag :identity_status="item.identityStatus">{{ item.identityStatus }}</a-tag>-->
        <!--              <template #actions>-->
        <!--                  <span v-for="{ type, text } in actions" :key="type">-->
        <!--                    <component v-bind:is="type" style="margin-right: 8px"/>-->
        <!--                    {{ text }}-->
        <!--                  </span>-->
        <!--              </template>-->
        <!--              <template #extra>-->
        <!--                <img-->
        <!--                    width="272"-->
        <!--                    alt="logo"-->
        <!--                    src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"-->
        <!--                />-->
        <!--              </template>-->
        <!--              <a-list-item-meta :intro="item.intro">-->
        <!--                <template #title>-->
        <!--                  <a :href="item.href">{{ item.name }}</a>-->
        <!--                </template>-->
        <!--                <template #avatar>-->
        <!--                  <a-avatar :src="item.avatar"/>-->
        <!--                </template>-->
        <!--              </a-list-item-meta>-->
        <!--              {{ item.content }}-->
        <!--            </a-list-item>-->
        <!--          </template>-->
        <!--        </a-list>-->


        通过ref():
        <pre>{{ demos }}</pre>
        <br/>
      </a-layout-content>
    </a-layout>


  </a-layout>

  <div id="components-back-top-demo-custom">
    <a-back-top>
      <div class="ant-back-top-inner">UP</div>
    </a-back-top>
    Scroll down to see the bottom-right
    <strong style="color: #1088e9">blue</strong>
    button.
  </div>

</template>


<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRef} from 'vue';
import {createFromIconfontCN} from '@ant-design/icons-vue';
import {message} from 'ant-design-vue';


import axios from 'axios';

const IconFont = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/font_2558111_009ekmettrll3.js',
});

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
        slots: { customRender: 'address' }
      },
      {
        title: '认证状态',
        key: 'identityStatus',
        dataIndex: 'identityStatus',
        slots: { customRender: 'identityStatus' }
      },
      {
        title: '主办方简介',
        key: 'intro',
        dataIndex: 'intro'
      },
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
    identityMap.set('notCertified','未认证')
    identityMap.set('underReview','审核中')
    identityMap.set('verified','已认证')




    const handleQuerySponsor = (params: any) => {
      axios.get("/admin/listSponsor",{
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


    const handleClick = (value: any) => {
      console.log("menu click", value );
      if(value.key === 'welcome'){
        isShowWelcome.value = true;
      }else {
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


    }
  },


  components: {
    IconFont,
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
  bottom: 100px;
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