<template>
  <a-back-top />
  <strong style="color: rgba(64, 64, 64, 0.6)"></strong>
  <a-layout>
    <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px'}"
    >
      <a-form ref="formRef"
              layout="inline"
              :model="formState"
              :rules="rules"
              @finish="handleFinish"
              @finishFailed="handleFinishFailed"
              :style="{marginLeft: '40%'}"
      >
        <a-form-item label="账号" name="telNum">
          <a-input v-model:value="formState.telNum" placeholder="Username">
            <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item label="密码" name="password">
          <a-input v-model:value="formState.password" type="password" placeholder="Password" >
            <template #prefix><LockOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item>
<!--          <router-link to="/user/home">-->
          <a-button
                  type="primary"
                  html-type="submit"
                  @click="handleFinish"
                  :disabled="formState.telNum === '' || formState.password === ''"
          >登录
          </a-button>
<!--          </router-link>-->
        </a-form-item>
        <router-link to="/user/signup"><a-button type="link">还没有账号？点击注册</a-button></router-link>
      </a-form>


    </a-layout-content>
  </a-layout>

</template>
<script lang="ts">
  import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';
  import { ValidateErrorEntity } from 'ant-design-vue/es/form/interface';
  import { defineComponent, reactive,  onMounted, ref, toRef, toRaw,UnwrapRef } from 'vue';
  import {message} from 'ant-design-vue';
  import axios from "axios";
  import router from "@/router";
  interface FormState {
    telNum: string;
    password: string;
  }
  export default defineComponent({
    name: 'login',

    setup() {

      const formRef = ref();

      const formState: UnwrapRef<FormState> = reactive({
        telNum: '',
        password: '',
      });

      const rules = {

        telNum: [{required: true, message: '手机号不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}],


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

      const handleFinish = (values: FormState) => {
        onSubmit();

        console.log("我得到的值");
        console.log(values, formState);
        console.log("我得到的值");

        axios.post("/participant/login", toRaw(formState)).then((response) => {
          const data = response.data;
          if(data.success){
            message.success("登录成功！");
            router.push({
              path: '/user/home',
              query: {
                pid: data.content.pid
              }
            })
          }else{
            message.error(data.message);
          }
        });
      };


      return {
        formState,
        handleFinish,
        onSubmit,
        formRef,
        rules,
      }
    },

  });
</script>

