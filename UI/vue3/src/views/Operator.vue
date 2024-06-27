<template>
    <div class="common-layout">
        <el-container>
            <el-header>
                <span>医仁匠心</span>
                <el-button type="primary" round class="LogOut" @click="Logout">退出登录</el-button>
            </el-header>
            <el-container>
                <el-aside>
                    <el-menu router>
                        <el-sub-menu>
                            <template #title>
                                <el-icon>
                                    <Search />
                                </el-icon><span>信息查询统计</span>
                            </template>
                            <el-menu-item index="/orders/index">查询订单信息</el-menu-item>
                            <el-menu-item index="/client/index">查询顾客信息</el-menu-item>
                        </el-sub-menu>
                    </el-menu>
                </el-aside>
                <el-main>
                    <RouterView />
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<style lang="scss">
.common-layout {
    .el-header {
        width: 100%;
        height: 50px;
        border-radius: 5px;
        border-radius: 5px;
        background-color: #a0cfff;
        text-align: center;
        font-size: 30px;
        font-weight: bold;
        color: #000000;
        font-family: 'Times New Roman', Times, serif;
        line-height: 50px;

        .LogOut {
            float: right;
            margin-top: 10px;
        }
    }

    .el-aside {
        width: 200px;
        border: 2px solid #EEEEEE;
        border-radius: 10px;
        box-shadow: 2px 2px 10px;
        height: 92vh;
        margin-left: 5px;
        margin-top: 5px;
    }

    .el-main {
        margin-left: 20px;
        margin-top: 10px;
        margin-right: 5px;
        padding-left: 20px;
        padding-top: 20px;
        border-radius: 10px;
        border: 2px solid #EEEEEE;
        box-shadow: #EEEEEE;
    }
}
</style>
<script setup lang="ts">
import { useTokenStore } from "@/stores/Token"
import { ElMessage, ElMessageBox } from "element-plus"
import { useRouter } from "vue-router";
const router = useRouter()

const Logout = async () => {
    await ElMessageBox.confirm("确认要退出吗？", "退出询问", {
        confirmButtonText: "确认退出",
        cancelButtonText: "取消",
        type: 'warning'
    }).catch(() => {
        ElMessage.info("取消退出")
        return new Promise(() => { })
    })
    ElMessage.success("已退出")
    useTokenStore().saveToken("")
    router.push({ name: 'login' })
}
</script>