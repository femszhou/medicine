<template>
    <div class="card-header">
        <el-button type="primary" @click="router.push({ name: 'ordersindex' })">返回</el-button>
    </div>
    <div v-if="formArray.length > 0">
        <el-scrollbar height="500px">
            <el-card v-for="(item, index) in formArray" :key="index">
                <div slot="header">序号 {{ item.medicineOrdersNo }}</div>
                <div>
                    药品编号: {{ item.medicineNo }},
                    药品名称: {{ item.medicineName }},
                    服用类型: {{ item.medicineMode }},
                    功效: {{ item.medicineEfficacy }},
                    订单编号: {{ item.ordersNo }},
                    药物数量: {{ item.medicineNumber }},
                    价格: {{ item.price }}
                </div>
            </el-card>
        </el-scrollbar>
    </div>
</template>
  
<script setup lang="ts">
import type { shoppingCart } from "@/api/order"
import { shopping } from "@/api/order"
import { ElMessage, ElCard, ElButton } from "element-plus";
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const formArray = ref<shoppingCart[]>([])

import { useRoute } from 'vue-router'
const route = useRoute()

//根据No获取信息
const getCartByNo = async (ordersNo: string) => {
    //通过接口获取
    const { data } = await shopping(ordersNo)
    // console.log(data)

    if (data.code === 1) {
        formArray.value = data.data
    } else {
        ElMessage.error("获取失败")
        throw new Error("获取失败")
    }
}
getCartByNo(route.params.ordersNo as string)
</script>
  
<style scoped>
.card-header {
    margin-bottom: 20px;
}
</style>