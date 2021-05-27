<template>
  <a-back-top />
  <strong style="color: rgba(64, 64, 64, 0.6)"></strong>
  <a-layout>
    <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
    >
      <a-form ref="formRef"
              layout="inline"
              :model="formState"
              :rules="rules"
              @finish="handleFinish"
              @finishFailed="handleFinishFailed"
              :style="{marginLeft: '40%'}"
      >
        <a-form-item label="姓名" name="name">
          <a-input v-model:value="formState.name">
            <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item label="账号" name="telNum">
          <a-input v-model:value="formState.telNum" placeholder="Username">
            <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item label="学校" name="university">
          <a-input v-model:value="formState.university">
            <template #prefix><UserOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item label="密码" name="password">
          <a-input v-model:value="formState.password" type="password" placeholder="Password">
            <template #prefix><LockOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item label="确认密码" name="confirmPassword">
          <a-input v-model:value="formState.confirmPassword" type="password" placeholder="Password">
            <template #prefix><LockOutlined style="color: rgba(0, 0, 0, 0.25)" /></template>
          </a-input>
        </a-form-item>
        <br>
        <br>
        <a-form-item>
          <a-button
                  type="primary"
                  html-type="submit"
                  :disabled="formState.telNum === '' || formState.password === ''
                  ||formState.confirmPassword === '' || formState.name === '' || formState.university === ''"
          >注册
          </a-button>
        </a-form-item>
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
    name: string;
    university: string;
    confirmPassword: string;
  }
  export default defineComponent({
    name: 'signup',

    setup() {

      const formRef = ref();

      const formState: UnwrapRef<FormState> = reactive({
        name:'',
        university:'',
        telNum: '',
        password: '',
        confirmPassword:''
      });

      const rules = {

        telNum: [{required: true, message: '手机号不能为空', trigger: 'blur'},
          {
            pattern:/^1[34578]\d{9}$/, message: '请输入有效的手机号'
          }],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}],
        confirmPassword: [{required: true, message: '确认密码不能为空', trigger: 'blur'}],
        university: [{required: true, message: '所在学校不能为空', trigger: 'blur'}],
        name: [{required: true, message: '姓名不能为空', trigger: 'blur'}],


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

        axios.post("/participant/signup", toRaw(formState)).then((response) => {
          console.log(values, formState);
          const data = response.data;
          if(data.success){
            message.success("注册成功！");
            router.push({
              path: '/user/login',
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

