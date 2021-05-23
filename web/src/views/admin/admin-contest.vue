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
                :row-key="record => record.sid"
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


              <!--              <template v-slot:action="{ text, record }">-->
              <!--                &lt;!&ndash;            空格组件：两个按钮之间的空格&ndash;&gt;-->
              <!--                <a-space size="small">-->
              <!--                  <router-link :to="'/admin/contest?sponsorId=' + record.sid">-->
              <!--                    <a-button type="primary">-->
              <!--                      竞赛管理-->
              <!--                    </a-button>-->
              <!--                  </router-link>-->

              <!--                  <a-button type="primary" @click="viewDetails(record)">-->
              <!--                    &lt;!&ndash;              <a-button type="primary" @click="resetPassword">&ndash;&gt;-->
              <!--                    查看详情-->
              <!--                  </a-button>-->

              <!--                  <a-button type="primary" v-if="record.contestStatus=='未认证'" @click="notify(record)">-->
              <!--                    &lt;!&ndash;              <a-button type="primary" @click="resetPassword">&ndash;&gt;-->
              <!--                    通知认证-->
              <!--                  </a-button>-->
              <!--                  <a-button type="primary" v-if="record.contestStatus=='审核中'" @click="verify(record)">-->
              <!--                    &lt;!&ndash;              <a-button type="primary" @click="resetPassword">&ndash;&gt;-->
              <!--                    开始认证-->
              <!--                  </a-button>-->

              <!--                  <a-button type="primary" @click="resetPassword(record)">-->
              <!--                    重置密码-->
              <!--                  </a-button>-->
              <!--                  <a-popconfirm-->
              <!--                      title="封禁后该账号功能受限，确认封禁?"-->
              <!--                      ok-text="是"-->
              <!--                      cancel-text="否"-->
              <!--                      @confirm="handleBanAccount(record)"-->
              <!--                  >-->
              <!--                    <a-button type="danger" shape="round">-->
              <!--                      封禁账号-->
              <!--                    </a-button>-->
              <!--                  </a-popconfirm>-->
              <!--                  <a-button type="primary" shape="round" @click="handleReleaseAccount(record)">-->
              <!--                    解除封禁-->
              <!--                  </a-button>-->
              <!--                </a-space>-->
              <!--              </template>-->
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

          <p :style="pStyle">主办方标识</p>
          <a-image
              :width="200"
              :height="100"
              :src="sponsorDetail.avatar"
              fallback="data:image/png;base64,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"
          />

          <a-divider/>

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
                <a-descriptions-item label="认证状态">{{ sponsorDetail.contestStatus }}</a-descriptions-item>
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
          <!--        <a-row>-->
          <!--                    <img class="certify-img" src="/image/certification-imgs/test1.jpg" alt="avatar"/>-->
          <!--        </a-row>-->
          <a-row>
            <div>
              <a-image-preview-group>
                <a-image :width="220" :height="150" src="/image/certification-imgs/test1.jpg"/>
                <a-image :width="220" :height="150" src="/image/certification-imgs/test2.jpg"/>
              </a-image-preview-group>
            </div>
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


    <a-modal
        title="封禁账户"
        width="600px"
        v-model:visible="banModalVisible"
        :confirm-loading="banModalLoading"
        @ok="handleBanAccountModalOk"
        okText="确认"
    >
      <template #footer>
        <a-button key="resetThisForm" @click="ResetBanForm">重置</a-button>
        <a-button key="submit" type="primary" :loading="loading" @click="handleBanAccountModalOk">提交</a-button>
      </template>
      <div style="text-align: center;">
        <p>待封禁账户：{{ sponsor.name }}</p>
      </div>
      <a-form
          ref="formRef"
          :model="formState"
          :rules="rules"
          :label-col="labelCol"
          :wrapper-col="wrapperCol"
      >
        <!--      <a-form-item ref="name" label="Activity name" name="name">-->
        <!--        <a-input v-model:value="formState.name" />-->
        <!--      </a-form-item>-->
        <a-form-item label="封禁原因" name="reason">
          <a-select v-model:value="formState.reason" placeholder="请选择封禁原因">
            <a-select-option v-for="item in banReasons" :key="item" :value="item">{{ item }}</a-select-option>
            <!--          <a-select-option value="beijing">Zone two</a-select-option>-->
          </a-select>
        </a-form-item>
        <a-form-item label="解禁时间" required name="releasetime">
          <a-date-picker
              v-model:value="formState.releasetime"
              show-time
              type="date"
              placeholder="选择解禁时间"
              style="width: 100%"
          />
        </a-form-item>
        <a-form-item label="发送通知" name="delivery">
          <a-switch v-model:checked="formState.delivery"/>
        </a-form-item>
        <a-form-item label="限制功能" name="banType">
          <a-checkbox-group v-model:value="formState.banType">
            <a-checkbox value="1" name="type">发布评论</a-checkbox>
            <a-checkbox value="2" name="type">发布比赛</a-checkbox>
            <a-checkbox value="3" name="type">发布通知</a-checkbox>
            <a-checkbox value="4" name="type">删除比赛</a-checkbox>
            <a-checkbox value="5" name="type">删除通知</a-checkbox>
          </a-checkbox-group>
        </a-form-item>
        <!--      <a-form-item label="Resources" name="resource">-->
        <!--        <a-radio-group v-model:value="formState.resource">-->
        <!--          <a-radio value="1">Sponsor</a-radio>-->
        <!--          <a-radio value="2">Venue</a-radio>-->
        <!--        </a-radio-group>-->
        <!--      </a-form-item>-->
        <a-form-item label="备注" name="note">
          <a-textarea v-model:value="formState.note"/>
        </a-form-item>
        <!--      <a-form-item :wrapper-col="{ span: 14, offset: 4 }">-->
        <!--        <a-button type="primary" @click="onSubmit">Create</a-button>-->
        <!--        <a-button style="margin-left: 10px" @click="resetForm">Reset</a-button>-->
        <!--      </a-form-item>-->
      </a-form>
    </a-modal>

    <a-modal
        title="解禁账户"
        width="600px"
        v-model:visible="releaseModalVisible"
        :confirm-loading="releaseModalLoading"
        @ok="handleReleaseAccountModalOk"
        okText="确认"
    >
      <div style="text-align: center;">
        <p>待解禁账户：{{ sponsor.name }}</p>
      </div>

      <a-descriptions title="封禁情况" bordered>
        <a-descriptions-item label="封禁理由" :span="3">{{ banAccount.reason }}</a-descriptions-item>
        <a-descriptions-item label="上次封禁时间" :span="3">{{ banAccount.bannedtime }}</a-descriptions-item>
        <a-descriptions-item label="预计解禁时间" :span="3">{{ banAccount.releasetime }}</a-descriptions-item>
        <a-descriptions-item label="账户状态" :span="3">
          <a-badge status="warning" text="封禁中"/>
        </a-descriptions-item>
      </a-descriptions>

      <div style="margin-top: 50px;">
        <span style="font-weight: bolder">更新解禁</span>
        <a-form
            :model="releaseAccount"
        >
          <!--      <a-form-item ref="name" label="Activity name" name="name">-->
          <!--        <a-input v-model:value="formState.name" />-->
          <!--      </a-form-item>-->
          <a-form-item label="更新解禁时间" required name="releasetime">
            <a-date-picker
                v-model:value="releaseAccount.releasetime"
                show-time
                type="date"
                placeholder="选择解禁时间"
                style="width: 100%"
            />
          </a-form-item>
          <a-form-item label="发送通知" name="delivery">
            <a-switch v-model:checked="releaseAccount.delivery"/>
          </a-form-item>
          <a-form-item label="选择解禁已限制的功能" name="banType">
            <a-checkbox-group v-model:value="releaseAccount.banType">

              <div v-for="item in banAccount.banType" :key="item">
                <a-checkbox value="1" :key="item" name="type">{{ item }}</a-checkbox>
              </div>

              <a-checkbox v-for="item in banAccount.banType" :key="item.indexOf" name="type">{{ item }}</a-checkbox>
              <!--            <a-checkbox value="1" name="type">发布评论</a-checkbox>-->
              <!--            <a-checkbox value="2" name="type">发布比赛</a-checkbox>-->
              <!--            <a-checkbox value="3" name="type">发布通知</a-checkbox>-->
              <!--            <a-checkbox value="4" name="type">删除比赛</a-checkbox>-->
              <!--            <a-checkbox value="5" name="type">删除通知</a-checkbox>-->
            </a-checkbox-group>
          </a-form-item>
          <a-form-item label="备注" name="note">
            <a-textarea v-model:value="releaseAccount.note"/>
          </a-form-item>

        </a-form>

      </div>

    </a-modal>


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
const listData: any = [];

let contest_status_o = '';

for (let i = 0; i < 23; i++) {

  contest_status_o = i % 3 === 0 ? '已认证' : (i % 3 === 1 ? '审核中' : '未认证');

  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
    contest_status: contest_status_o
  });
}


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


    let account_status = '';
    let accountStatusMap = new Map()
    accountStatusMap.set(0, '正常')
    accountStatusMap.set(1, '禁言中')
    // accountStatusMap.set('verified', '已认证')

    let banReasons = new Set();
    banReasons.add('侮辱或攻击他人的宗教、种族或性取向');
    banReasons.add('存在主张暴力或虐待人或动物的内容');
    banReasons.add('显示有人在进行或企图进行自我伤害');
    banReasons.add('描述了毒品、枪支、管制物品的买卖');
    banReasons.add('未经授权使用，侵犯版权或商标权');

    let banTypes = new Map();
    banTypes.set("1", "发布评论");
    banTypes.set("2", "发布比赛");
    banTypes.set("3", "发布通知");
    banTypes.set("4", "删除比赛");
    banTypes.set("5", "删除通知");


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
        // ebooks2.books = data.content;

        // console.log(response)

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

      axios.get("/admin/getContestDetail", {
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


    // -------- 重置密码 ---------

    const sponsor = ref({
      password: '',
    });

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

      contests,
      loading,
      columns,
      sponsor,

      contest,

      pagination,
      handleTableChange,

      isShowWelcome,


      handleClick,
      handleQueryContest,


      //抽屉板块
      visible,
      pStyle,
      pStyle2,
      viewDetails,
      onClose,
      sponsorDetail,


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