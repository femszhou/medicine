<template>
    <el-card class="box-card">
        <template #header>
            <div class="card-header">
                <el-button type="primary" @click="router.push({ name: 'addorders' })">添加订单信息</el-button>
                <el-form :inline="true" :model="ordersNoinput">
                    <el-form-item>
                        <el-input v-model="ordersNoinput" placeholder="请输入编号" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearch">查询</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </template>
        <el-scrollbar height="450px">
            <el-table :data="get" style="width: 100%">
                <el-table-column prop="ordersNo" label="订单编号" />
                <el-table-column prop="clientNo" label="顾客编号" />
                <el-table-column prop="ordersDate" label="订单日期" />
                <el-table-column prop="operatorNo" label="经办人编号" />
                <el-table-column prop="totalPrice" label="总价格" />
                <el-table-column label="购物车" v-slot="scope">
                    <el-button type="success" size="small"
                        @click="router.push({ name: 'shop', params: { ordersNo: scope.row.ordersNo } })">
                        <el-icon>
                            <ShoppingCart />
                        </el-icon>
                    </el-button>
                    <el-button type="primary" size="small"
                        @click="router.push({ name: 'editshop', params: { ordersNo: scope.row.ordersNo } })">购物</el-button>
                </el-table-column>
                <el-table-column label="操作" v-slot="scope">
                    <el-button type="primary" size="small"
                        @click="router.push({ name: 'ordersEdit', params: { ordersNo: scope.row.ordersNo } })">修改</el-button>
                </el-table-column>
            </el-table>
        </el-scrollbar>
        <el-button @click="last">上一页</el-button>
        <el-button @click="next">下一页</el-button>
    </el-card>
</template>
<script setup lang="ts">
import { getOrders, find, getOrdersByNo } from "@/api/order"
import { ref } from 'vue'
import type { Menu } from '@/api/order'
import { ElMessage } from "element-plus"
import { useRouter } from "vue-router"
const router = useRouter()

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
    try {
        const { data } = await getOrders(currentPage.value, pageSize.value)
        console.log(data)

        if (data.code === 1) {
            get.value = data.data.rows
            total.value = data.data.total
            // console.log(total.value)

        } else {
            ElMessage.error('获取订单数据失败')
        }
    } catch (error) {
        console.error(error)
        ElMessage.error('获取订单数据失败')
    }
}
getAll()
const ordersNoinput = ref('')
const onSearch = async () => {
    const inputOrdersNo = Number(ordersNoinput.value)
    const data = await getOrdersByNo(inputOrdersNo)
    // console.log(data)
    if (data.data.data.total != 0) {
        get.value = data.data.data.rows
        total.value = data.data.data.total
        ElMessage.success("查找成功！")
    } else {
        ElMessage.error("查找失败！")
    }
}

</script>

<style>
.card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.text {
    font-size: 10px;
}

.item {
    margin-bottom: 18px;
}

.box-card {
    width: auto;
}
</style>