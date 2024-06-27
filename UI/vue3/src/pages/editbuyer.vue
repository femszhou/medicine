<template>
    <el-button type="primary" @click="router.push('/buyer')">返回</el-button>
    <el-form :model="form" label-width="120px">
        <el-form-item label="编号">
            <el-input v-model="form.buyerNo" />
        </el-form-item>
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
import { getbuyer, putbuyer } from "@/api/buyer"
import type { putMenu } from "@/api/buyer"
import { ElMessage } from "element-plus";
import { ref } from 'vue'
import { useRouter } from "vue-router"
const router = useRouter()
const form = ref<putMenu>({
    buyerClass: "",
    buyerName: "",
    buyerSex: 1,
    buyerNo: 1,
    buyerPassword: "",
    buyerPhone: "",
    buyerRemark: "",
})

import { useRoute } from 'vue-router'
const route = useRoute()


//根据No获取信息
const getMenuByNo = async (buyerNo: string) => {

    //通过接口获取
    const { data } = await getbuyer(buyerNo)
    if (data.code === 1) {
        form.value = data.data.rows[0]
    } else {
        ElMessage.error("获取失败")
        throw new Error("获取失败")
    }
}
getMenuByNo(route.params.buyerNo as string)


//提交表单事件
const onSubmit = async () => {
    const data = await putbuyer(form.value)
    if (data.data.code === 1) {
        ElMessage.success("修改成功")
    } else {
        ElMessage.error("修改采购人员失败")
        throw new Error('修改采购人员失败')
    }
}
</script>