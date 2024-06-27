<template>
    <el-button type="primary" @click="router.push({ name: 'buyerindex' })">返回</el-button>
    <el-form :model="form" label-width="120px">
        <el-form-item label="编号">
            <el-input v-model="form.medicineNo" />
        </el-form-item>
        <el-form-item label="药名">
            <el-input v-model="form.medicineName" />
        </el-form-item>
        <el-form-item label="类型">
            <el-input v-model="form.medicineMode" />
        </el-form-item>
        <el-form-item label="功效">
            <el-input v-model="form.medicineEfficacy" />
        </el-form-item>
        <el-form-item label="价格">
            <el-input v-model="form.medicinePrice" />
        </el-form-item>
        <el-form-item label="数量">
            <el-input v-model="form.medicineCount" />
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
import { getmedicine, putmedicine } from "@/api/medicine"
import type { putMenu } from "@/api/medicine"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = ref<putMenu>({
    medicineName: "",
    medicineMode: "",
    medicinePrice: 1,
    medicineNo: 1,
    medicineEfficacy: "",
    medicineCount: 1,
})

import { useRoute } from 'vue-router'
const route = useRoute()


//根据No获取信息
const getMenuByNo = async (medicineNo: string) => {

    //通过接口获取
    const { data } = await getmedicine(medicineNo)
    if (data.code === 1) {
        form.value = data.data.rows[0]
    } else {
        ElMessage.error("获取失败")
        throw new Error("获取失败")
    }
}
getMenuByNo(route.params.medicineNo as string)


//提交表单事件
const onSubmit = async () => {
    const data = await putmedicine(form.value)
    if (data.data.code === 1) {
        ElMessage.success("修改成功")
    } else {
        ElMessage.error("修改药物失败")
        throw new Error('修改药物失败')
    }
}
</script>