<template>
    <el-card class="box-card">
        <template #header>
            <div class="card-header">
                <el-button type="primary" @click="router.push({ name: 'addclient' })">添加顾客信息</el-button>
                <el-form :inline="true" :model="clientNameinput">
                    <el-form-item>
                        <el-input v-model="clientNameinput" placeholder="请输入姓名" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearchByName">查询</el-button>
                    </el-form-item>
                </el-form>
                <el-form :inline="true" :model="clientNoinput">
                    <el-form-item>
                        <el-input v-model="clientNoinput" placeholder="请输入编号" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearch">查询</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </template>
        <el-scrollbar height="450px">
            <el-table :data="getClientSex" style="width: 100%">
                <el-table-column prop="clientNo" label="编号" />
                <el-table-column prop="clientName" label="姓名" />
                <el-table-column prop="clientSex" label="性别" />
                <el-table-column prop="clientAge" label="年龄" />
                <el-table-column prop="clientAddress" label="地址" />
                <el-table-column prop="clientPhone" label="电话" />
                <el-table-column prop="clientSymptom" label="症状" />
                <el-table-column prop="clientDate" label="注册日期" />
                <el-table-column prop="clientRemark" label="备注" />
                <el-table-column label="操作" v-slot="scope">
                    <el-button type="primary" size="small"
                        @click="router.push({ name: 'clientEdit', params: { clientNo: scope.row.clientNo } })">修改</el-button>
                </el-table-column>
            </el-table>
            <el-button @click="last">上一页</el-button>
            <el-button @click="next">下一页</el-button>
        </el-scrollbar>
    </el-card>
</template>
  
<script setup lang="ts">
import { getClient, find, getClientByNo, getClientByName } from "@/api/client"
import { ref, computed } from "vue"
import type { Menu } from "@/api/client"
import { ElMessage } from "element-plus"
import { useRouter } from "vue-router"


const get = ref([] as Menu[])
const currentPage = ref(1)  // 当前页码
const pageSize = ref(10)    // 每页显示条目数
const total = ref()

const router = useRouter()

const next = () => {
    if (currentPage.value * 10 < total.value) {
        currentPage.value++
    } else {
        currentPage.value = 1
    }
    console.log(currentPage.value)

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
    const { data } = await getClient(currentPage.value, pageSize.value)
    console.log(data)

    if (data.code === 1) {
        get.value = data.data.rows
        total.value = data.data.total
    } else {
        ElMessage.error("获取失败")
        throw new Error("获取失败")
    }
}
getAll()

const getClientSex = computed(() => {
    return get.value.map((item) => ({
        ...item,
        clientSex: item.clientSex === 1 ? "男" : "女",
    }))
})
const clientNoinput = ref('')
const clientNameinput = ref('')
const onSearch = async () => {
    const inputClientNo = Number(clientNoinput.value)
    const data = await getClientByNo(inputClientNo)
    // console.log(data)
    if (data.data.data.total != 0) {
        get.value = data.data.data.rows
        total.value = data.data.data.total
        ElMessage.success("查找成功！")
    } else {
        ElMessage.error("查找失败！")
    }
}
const onSearchByName = async () => {
    const data = await getClientByName(clientNameinput.value)
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
    font-size: 14px;
}

.item {
    margin-bottom: 18px;
}

.box-card {
    width: auto;
}
</style>
  