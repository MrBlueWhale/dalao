<template>
  <a-layout>
    <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
    >
      <a-table
              :columns="columns"
              :row-key="record => record.id"
              :data-source="contest"
              :pagination="pagination"
              :loading="loading"
              @change="handleTableChange"
      >
        <template v-slot:action="{ text, record }">
          <a-space size="small">
            <a-button type="primary" @click="edit(record)">
              编辑
            </a-button>
            <a-button type="danger">
              删除
            </a-button>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import axios from 'axios';

  export default defineComponent({
    name: 'UserRecord',
    setup() {
      const contest = ref();
      const pagination = ref({
        current: 1,
        pageSize: 3,
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
          key:'action',
          slots:{customRender:'action'}
        }
      ];

      /**
       * 数据查询
       **/
      const handleQuery = (params: any) => {
        loading.value = true;
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        axios.get("/contest/list", params).then((response) => {
          loading.value = false;
          const data = response.data;
          contest.value = data.content;
            // 重置分页按钮
            pagination.value.current = params.page;
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

      onMounted(()=> {
        handleQuery({});
      });

      return {
        contest,
        pagination,
        columns,
        loading,
        handleTableChange
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
