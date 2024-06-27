<template>
    <el-button type="primary" @click="router.push({ name: 'buyerindex' })">返回</el-button>
    <el-form :model="form" label-width="120px">
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
        <el-form-item label="剩余数量">
            <el-input v-model="form.medicineCount" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">添加</el-button>
        </el-form-item>
    </el-form>
</template>

<style lang="scss" scoped>
.el-form {
    margin-top: 10px;
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
import { addmedicine } from "@/api/medicine"
import type { addMenu } from "@/api/medicine"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const form = ref({} as addMenu)


//提交表单事件
const onSubmit = async () => {
    const data = await addmedicine(form.value)
    if (data.data.code === 1) {
        ElMessage.success("添加成功")
    } else {
        ElMessage.error("添加药物失败")
        throw new Error('添加药物失败')
    }
}

</script>