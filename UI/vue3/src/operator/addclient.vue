<template>
    <el-button type="primary" @click="router.push('/client/index')">返回</el-button>
    <el-form :model="form" label-width="120px">
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
        <el-form-item label="备注">
            <el-input v-model="form.clientRemark" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">添加</el-button>
        </el-form-item>
    </el-form>
</template>

<style lang="scss" scoped>
.el-form {
    margin-top: 20px;
    padding: 10px;

    .el-form-item {
        .el-input {
            height: 40px;
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
import { addclient } from "@/api/client"
import type { addMenu } from "@/api/client"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = ref({} as addMenu)

//提交表单事件
const onSubmit = async () => {
    const data = await addclient(form.value)
    if (data.data.code === 1) {
        ElMessage.success("添加成功")
    } else {
        ElMessage.error("添加药物失败")
        throw new Error('添加药物失败')
    }
}

</script>