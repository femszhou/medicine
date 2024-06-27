<template>
    <el-card class="box-card">
        <template #header>
            <div class="card-header">
                <el-button type="primary" @click="router.push({ name: 'addoperator' })">添加经办人</el-button>
                <el-form :inline="true" :model="operatorNameinput">
                    <el-form-item>
                        <el-input v-model="operatorNameinput" placeholder="请输入姓名" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearchByName">查询</el-button>
                    </el-form-item>
                </el-form>
                <el-form :inline="true" :model="operatorNoinput">
                    <el-form-item>
                        <el-input v-model="operatorNoinput" placeholder="请输入编号" clearable />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSearch">查询</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </template>
        <el-scrollbar height="450px">
            <el-table :data="getOperatorSex" style="width: 100%">
                <el-table-column prop="operatorNo" label="编号" />
                <el-table-column prop="operatorName" label="姓名" />
                <el-table-column prop="operatorSex" label="性别" />
                <el-table-column prop="operatorPassword" label="密码" />
                <el-table-column prop="operatorPhone" label="电话" />
                <el-table-column prop="operatorClass" label="用户类型" />
                <el-table-column prop="operatorRemark" label="备注" />
                <el-table-column label="操作" v-slot="scope">
                    <el-button type="primary" size="small"
                        @click="router.push({ name: 'operatorEdit', params: { operatorNo: scope.row.operatorNo } })">修改</el-button>
                    <el-button type="danger " size="small" @click="delOperator(scope.row.operatorNo)">删除</el-button>
                </el-table-column>
            </el-table>
            <el-button @click="last">上一页</el-button>
            <el-button @click="next">下一页</el-button>
        </el-scrollbar>
    </el-card>
</template>
<script setup lang="ts">
import { getOperator, delMenu, find, getOperatorByNo, getOperatorByName } from "@/api/operator"
import { computed, ref } from 'vue'
import type { Menu } from '@/api/operator'
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
    const { data } = await getOperator(currentPage.value, pageSize.value)
    console.log(data)

    if (data.code === 1) {
        get.value = data.data.rows
        total.value = data.data.total
    } else {
        ElMessage.error('获取失败')
        throw new Error('获取失败')
    }
}
getAll()

const getOperatorSex = computed(() => {
    return get.value.map((item) => ({
        ...item,
        operatorSex: item.operatorSex === 1 ? "男" : "女",
    }))
})
const delOperator = async (operatorNo: number) => {
    await ElMessageBox.confirm("确认删除吗？", "删除提醒", {
        confirmButtonText: "确认",
        cancelButtonText: "取消"
    }).catch(() => {
        ElMessage.info("取消删除")
        return new Promise(() => { })
    })

    //调用接口
    const { data } = await delMenu(operatorNo)
    if (data.code === 1) {
        ElMessage.success("删除成功")
        getAll()
    } else {
        ElMessage.error("删除失败")
        throw new Error("删除失败")
    }
}


const operatorNoinput = ref('')
const operatorNameinput = ref('')
const onSearch = async () => {
    const inputOperatorNo = Number(operatorNoinput.value)
    const data = await getOperatorByNo(inputOperatorNo)
    console.log(data)
    if (data.data.data.total != 0) {
        get.value = data.data.data.rows
        total.value = data.data.data.total
        ElMessage.success("查找成功！")
    } else {
        ElMessage.error("查找失败！")
    }
}


const onSearchByName = async () => {
    const data = await getOperatorByName(operatorNameinput.value)
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