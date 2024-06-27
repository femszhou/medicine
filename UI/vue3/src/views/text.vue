<template>
    <div class="my">
        <h1>有问题请联系管理员:</h1>
        <hr>
        <h2>2421255862@qq.com</h2>
        <el-button type="primary" @click="router.push({ name: 'login' })">返回</el-button>
    </div>
</template>
<style lang="scss" scoped>
.my {
    margin-top: 50px;
    justify-content: center;
    align-items: center;
    text-align: center;
}

.el-button {
    margin-top: 50px;
    ;
}
</style>
<script setup lang="ts">
import { useRouter } from 'vue-router'
const router = useRouter()
</script>