<template>
    <el-button type="primary" @click="router.push('/buyer')">返回</el-button>
    <el-form :model="form" label-width="120px">
        <el-form-item label="姓名">
            <el-input v-model="form.buyerName" />
        </el-form-item>
        <el-form-item label="性别">
            <el-input v-model="form.buyerSex" />
        </el-form-item>
        <el-form-item label="手机号">
            <el-input v-model="form.buyerPhone" />
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="form.buyerPassword" />
        </el-form-item>
        <el-form-item label="类型">
            <el-input v-model="form.buyerClass" />
        </el-form-item>
        <el-form-item label="备注">
            <el-input v-model="form.buyerRemark" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">添加</el-button>
        </el-form-item>
    </el-form>
</template>

<style lang="scss" scoped>
.el-form {
    margin-top: 50px;
    padding: 50px;

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
import { addbuyer } from "@/api/buyer"
import type { addMenu } from "@/api/buyer"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = ref({} as addMenu)

//提交表单事件
const onSubmit = async () => {
    const data = await addbuyer(form.value)
    if (data.data.code === 1) {
        ElMessage.success("添加成功")
    } else {
        ElMessage.error("添加采购人员失败")
        throw new Error('添加采购人员失败')
    }
}

</script>