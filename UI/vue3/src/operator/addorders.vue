<template>
    <el-button type="primary" @click="router.push('/orders/index')">返回</el-button>
    <el-form :model="form" label-width="120px">
        <el-form-item label="顾客编号">
            <el-input v-model="form.clientNo" />
        </el-form-item>
        <el-form-item label="经办人编号">
            <el-input v-model="form.operatorNo" />
        </el-form-item>
        <el-form-item label="总价格">
            <el-input v-model="form.totalPrice" />
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
import { addorders } from "@/api/order"
import type { addMenu } from "@/api/order"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = ref({} as addMenu)

//提交表单事件
const onSubmit = async () => {
    const data = await addorders(form.value)
    if (data.data.code === 1) {
        ElMessage.success("添加成功")
    } else {
        ElMessage.error("添加订单失败")
        throw new Error('添加订单失败')
    }
}

</script>