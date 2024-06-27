<template>
    <el-button type="primary" @click="$router.push({ name: 'ordersindex' })">返回</el-button>
    <el-table :data="get" style="width: 100%">
        <el-table-column prop="medicineNo" label="编号" />
        <el-table-column prop="medicineName" label="药名" />
        <el-table-column prop="medicineMode" label="服用类型" />
        <el-table-column prop="medicineEfficacy" label="功效" />
        <el-table-column prop="medicinePrice" label="价格" />
        <el-table-column prop="medicineCount" label="剩余数量" />
        <el-table-column label="操作" v-slot="scope">
            <el-button type="primary" size="small"
                @click="add($route.params.ordersNo as string, scope.row.medicineNo, scope.row.medicinePrice)"><el-icon>
                    <Plus />
                </el-icon></el-button>
            <el-button type="danger" size="small"
                @click="sub($route.params.ordersNo as string, scope.row.medicineNo, scope.row.medicinePrice)"><el-icon>
                    <Minus />
                </el-icon></el-button>
        </el-table-column>
    </el-table>
    <el-button @click="last">上一页</el-button>
    <el-button @click="next">下一页</el-button>
</template>
<script setup lang="ts">
import { getMedicine } from "@/api/medicine"
import { ref } from 'vue'

import type { Menu } from '@/api/medicine'
import { ElMessage } from "element-plus"
import { addshop, subshop } from "@/api/order"
const add = async (ordersNo: string, medicineNo: string, price: string) => {
    try {
        await addshop(ordersNo, medicineNo, price)
        ElMessage.success('添加成功')
        getAll()
    } catch (error) {
        ElMessage.error('添加失败，请重试')
        console.error(error)
    }
}

const sub = async (ordersNo: string, medicineNo: string, price: string) => {
    try {
        await subshop(ordersNo, medicineNo, price)
        ElMessage.success('删除成功')
        getAll()
    } catch (error) {
        ElMessage.error('删除失败，请重试')
        console.error(error)
    }
}


const get = ref([] as Menu[])
const currentPage = ref(1)  // 当前页码
const pageSize = ref(10)    // 每页显示条目数
const total = ref()

const next = () => {
    if (currentPage.value * 10 < total.value) {
        currentPage.value++
    } else {
        currentPage.value = 1
    }
    getAll()
}

const last = () => {
    if (currentPage.value > 1) {
        currentPage.value--
    } else {
        currentPage.value = Math.ceil(total.value / 10) || 1
    }
    getAll()
}

const getAll = async () => {
    const { data } = await getMedicine(currentPage.value, pageSize.value)
    // console.log(data)

    if (data.code === 1) {
        get.value = data.data.rows
        total.value = data.data.total
    } else {
        ElMessage.error('获取失败')
        throw new Error('获取失败')
    }
}
getAll()

</script>

<style>
.card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.text {
    font-size: 14px;
}

.item {
    margin-bottom: 18px;
}

.box-card {
    width: auto;
}
</style>