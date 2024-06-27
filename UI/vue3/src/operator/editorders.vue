<template>
    <el-button type="primary" @click="router.push('/orders/index')">返回</el-button>
    <el-form :model="form" label-width="120px">
        <el-form-item label="订单编号">
            <el-input v-model="form.ordersNo" />
        </el-form-item>
        <el-form-item label="顾客编号">
            <el-input v-model="form.clientNo" />
        </el-form-item>
        <el-form-item label="订单日期">
            <el-input v-model="form.ordersDate" />
        </el-form-item>
        <el-form-item label="员工编号">
            <el-input v-model="form.operatorNo" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">修改</el-button>
        </el-form-item>
    </el-form>
</template>

<style lang="scss" scoped>
.el-form {
    margin-top: 30px;
    padding: 30px;

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
import { getorders, putorders } from "@/api/order"
import type { putMenu } from "@/api/order"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = ref<putMenu>({
    ordersNo: 1,
    clientNo: 1,
    ordersDate: "",
    medicineNo: 1,
    operatorNo: 1,
})

import { useRoute } from 'vue-router'
const route = useRoute()


//根据No获取信息
const getMenuByNo = async (ordersNo: string) => {

    //通过接口获取
    const { data } = await getorders(ordersNo)
    if (data.code === 1) {
        form.value = data.data.rows[0]
    } else {
        ElMessage.error("获取失败")
        throw new Error("获取失败")
    }
}
getMenuByNo(route.params.ordersNo as string)


//提交表单事件
const onSubmit = async () => {
    const data = await putorders(form.value)
    if (data.data.code === 1) {
        ElMessage.success("修改成功")
    } else {
        ElMessage.error("修改订单失败")
        throw new Error('修改订单失败')
    }
}
</script>