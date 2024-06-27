<template>
    <div class="login">
        <el-form :model="form" :rules="rules" ref="formRef" label-width="120px" label-position="top" size="large">
            <h2>医仁匠心
                <el-text @click="$router.push({ name: 'text' })" :loading="isLoading">
                    <el-icon>
                        <QuestionFilled />
                    </el-icon></el-text>
            </h2>
            <el-form-item label="手机号" prop="phoneProp">
                <el-input v-model="form[phoneProp]" />
            </el-form-item>
            <el-form-item label="密码" prop="passwordProp">
                <el-input v-model="form[passwordProp]" type="password" show-password>
                </el-input>
            </el-form-item>
            <el-form-item prop="role">
                <el-radio-group v-model="form.role">
                    <el-radio label="admin">管理员</el-radio>
                    <el-radio label="buyer">采购人</el-radio>
                    <el-radio label="operator">经办人</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit" :loading="isLoading">登 录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script setup lang="ts">
import { ElMessage, type FormInstance, type FormRules } from 'element-plus';
import { computed, reactive, ref } from 'vue';
import { login, buyerlogin, operatorlogin } from "@/api/index"
import { useTokenStore } from "@/stores/Token"
import { useRouter, useRoute } from "vue-router"
import { onMounted } from 'vue'

//监听回车事件
onMounted(() => {
    document.addEventListener('keyup', (e) => {
        if (e.key === 'Enter') {
            onSubmit();
        }
    })
})
const phoneProp = computed(() => {
    if (form.role === 'buyer') {
        return 'buyerPhone'
    } else if (form.role === 'operator') {
        return 'operatorPhone'
    } else {
        return 'administratorPhone'
    }
})

const passwordProp = computed(() => {
    if (form.role === 'buyer') {
        return 'buyerPassword'
    } else if (form.role === 'operator') {
        return 'operatorPassword'
    } else {
        return 'administratorPassword'
    }
})


const store = useTokenStore()
const router = useRouter()
const route = useRoute()
//创建响应式数据
const form = reactive({
    administratorPhone: "",
    administratorPassword: "",

    buyerPhone: "",
    buyerPassword: "",

    operatorPhone: "",
    operatorPassword: "",
    role: "admin"
})
const onSubmit = async () => {
    isLoading.value = true
    await formRef.value?.validate().catch((err) => {
        ElMessage.error("表单校验失败")
        isLoading.value = false
        return new Promise(() => { })
    })

    let loginApi
    if (form.role === "buyer") {
        loginApi = buyerlogin
    } else if (form.role === "operator") {
        loginApi = operatorlogin
    } else {
        loginApi = login
    }
    const data = await loginApi(form).then((res) => {
        if (!res.data.data) {
            ElMessage.error("手机号或者密码错误")
            isLoading.value = false
            throw new Error("登录信息有误")
        }
        return res.data
    }).catch((err) => {
        console.log(err)
    })

    store.saveToken(data.data)
    isLoading.value = false
    ElMessage.success("登录成功")

    if (form.role === "buyer") {
        router.push((route.query.redirect as string) || "/buyerindex")
    } else if (form.role === "operator") {
        router.push((route.query.redirect as string) || "/operatorindex")
    } else {
        router.push((route.query.redirect as string) || "/")
    }

}
//表单校验
const rules = reactive<FormRules>({
    administratorPhone:
        [{
            required: true, message: "请输入电话", trigger: "blur"
        }],
    administratorPassword:
        [{
            required: true, message: "请输入密码", trigger: "blur"
        },
        {
            min: 5, max: 11, message: "密码必须是6~11位", trigger: "blur"
        }],
    buyerPhone:
        [{
            required: true, message: "请输入电话", trigger: "blur"
        }],
    buyerPassword:
        [
            { required: true, message: "请输入密码", trigger: "blur" },
            { min: 5, max: 11, message: "密码必须是6~11位", trigger: "blur" }
        ],
    operatorPhone: [{ required: true, message: "请输入电话", trigger: "blur" }],
    operatorPassword: [
        { required: true, message: "请输入密码", trigger: "blur" },
        { min: 5, max: 11, message: "密码必须是6~11位", trigger: "blur" }
    ]
})

//定义是否正在登录
const isLoading = ref(false)

//表单实例验证表单
const formRef = ref<FormInstance>()
</script>

<style>
.login {
    background-image: url("@/assets/4.jpg");
    background-position: center;
    background-size: cover;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;

    .el-text {
        float: right;
        color: red;
        size: 100px;
    }

    .el-form {
        width: 300px;
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;

        .el-form-item {
            margin-top: 10px;
        }

        .el-button {
            width: 100%;
            margin-top: 10px;
        }
    }
}
</style>
