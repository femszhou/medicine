<template>
    <div>
        <el-result icon="warning" title="404" sub-title="你找的页面找丢了！">
            <template #extra>
                <el-button type="primary" @click="$router.push('/login')">返回</el-button>
            </template>
        </el-result>
    </div>
</template>