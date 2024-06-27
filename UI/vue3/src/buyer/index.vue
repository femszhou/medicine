<template>
    <el-card class="box-card">
        <template #header>
            <div class="card-header">
                <el-button type="primary" @click="router.push({ name: 'addmedicine' })">添加药物信息</el-button>
                <el-form :inline="true" :model="medicineNameinput">
                    <el-form-item>
                        <el-input v-model="medicineNameinput" placeholder="请输入药名" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearchByName">查询</el-button>
                    </el-form-item>
                </el-form>
                <el-form :inline="true" :model="medicineNoinput">
                    <el-form-item>
                        <el-input v-model="medicineNoinput" placeholder="请输入编号" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearch">查询</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </template>
        <el-scrollbar height="450px">
            <el-table :data="get" style="width: 100%">
                <el-table-column prop="medicineNo" label="编号" />
                <el-table-column prop="medicineName" label="药名" />
                <el-table-column prop="medicineMode" label="服用类型" />
                <el-table-column prop="medicineEfficacy" label="功效" />
                <el-table-column prop="medicinePrice" label="价格" />
                <el-table-column prop="medicineCount" label="剩余数量" />
                <el-table-column label="操作" v-slot="scope">
                    <el-button type="primary" size="small"
                        @click="router.push({ name: 'medicineEdit', params: { medicineNo: scope.row.medicineNo } })">修改</el-button>
                    <el-button type="danger " size="small" @click="delMedicine(scope.row.medicineNo)">删除</el-button>
                </el-table-column>
            </el-table>
            <el-button @click="last">上一页</el-button>
            <el-button @click="next">下一页</el-button>
        </el-scrollbar>
    </el-card>
</template>
<script setup lang="ts">
import { getMedicine, delMenu, find, getMedicineByNo, getMedicineByName } from "@/api/medicine"
import { ref } from 'vue'
import type { Menu } from '@/api/medicine'
import { ElMessage, ElMessageBox } from "element-plus";
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

//删除采购人员
const delMedicine = async (medicineNo: number) => {
    await ElMessageBox.confirm("确认删除吗？", "删除提醒", {
        confirmButtonText: "确认",
        cancelButtonText: "取消"
    }).catch(() => {
        ElMessage.info("取消删除")
        return new Promise(() => { })
    })

    //调用接口
    const { data } = await delMenu(medicineNo)
    if (data.code === 1) {
        ElMessage.success("删除成功")
        getAll()
    } else {
        ElMessage.error("删除失败")
        throw new Error("删除失败")
    }
}

const medicineNoinput = ref('')
const medicineNameinput = ref('')
const onSearch = async () => {
    const inputMedicineNo = Number(medicineNoinput.value)
    const data = await getMedicineByNo(inputMedicineNo)
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
    const data = await getMedicineByName(medicineNameinput.value)
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
