<template>
    <el-button type="primary" @click="router.push('/client/index')">返回</el-button>
    <el-form :model="form" label-width="120px">
        <el-form-item label="编号">
            <el-input v-model="form.clientNo" />
        </el-form-item>
        <el-form-item label="姓名">
            <el-input v-model="form.clientName" />
        </el-form-item>
        <el-form-item label="性别">
            <el-input v-model="form.clientSex" />
        </el-form-item>
        <el-form-item label="年龄">
            <el-input v-model="form.clientAge" />
        </el-form-item>
        <el-form-item label="地址">
            <el-input v-model="form.clientAddress" />
        </el-form-item>
        <el-form-item label="电话">
            <el-input v-model="form.clientPhone" />
        </el-form-item>
        <el-form-item label="症状">
            <el-input v-model="form.clientSymptom" />
        </el-form-item>
        <el-form-item label="注册日期">
            <el-input v-model="form.clientDate" />
        </el-form-item>
        <el-form-item label="备注">
            <el-input v-model="form.clientRemark" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">修改</el-button>
        </el-form-item>
    </el-form>
</template>

<style lang="scss" scoped>
.el-form {
    margin-top: 20px;
    padding: 20px;

    .el-form-item {
        .el-input {
            height: 30px;
            width: 250px;
        }

        .el-button {
            border-radius: 10px;
            width: 250px;
        }
    }
}
</style>

<script setup lang="ts">
import { getclient, putclient } from "@/api/client"
import type { putMenu } from "@/api/client"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = ref<putMenu>({
    clientNo: 1,
    clientName: "",
    clientSex: 1,
    clientAge: 1,
    clientAddress: "",
    clientPhone: "",
    clientSymptom: "",
    clientDate: "",
    clientRemark: ""
})

import { useRoute } from 'vue-router'
const route = useRoute()


//根据No获取信息
const getMenuByNo = async (clientNo: string) => {

    //通过接口获取
    const { data } = await getclient(clientNo)
    if (data.code === 1) {
        form.value = data.data.rows[0]
    } else {
        ElMessage.error("获取失败")
        throw new Error("获取失败")
    }
}
getMenuByNo(route.params.clientNo as string)


//提交表单事件
const onSubmit = async () => {
    const data = await putclient(form.value)
    if (data.data.code === 1) {
        ElMessage.success("修改成功")
    } else {
        ElMessage.error("修改药物失败")
        throw new Error('修改药物失败')
    }
}
</script>