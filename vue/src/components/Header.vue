<template>
  <div style="line-height: 60px; display: flex">
    <div style="flex: 1;">
      <span :class="isCollapse?'el-icon-s-unfold':'el-icon-s-fold'" style="cursor: pointer; font-size: 20px;"
            @click="collapse">
      </span>
      <el-breadcrumb separator-class="el-icon-arrow-right" style="display: inline-block; margin-left: 10px">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ currentPathName }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
<!--    <el-dropdown style="width: 70px; cursor: pointer">
      <span>YaoJun</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>个人信息</el-dropdown-item>
        <el-dropdown-item>退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>-->
  </div>
</template>

<script>
export default {
  name: "Header",
  props: {
    isCollapse: Boolean,
    collapse: Function
  },
  computed: {
    currentPathName () {
      return this.$store.state.currentPathName;　　//需要监听的数据
    }
  },
  watch: {
    currentPathName (newVal, oldVal) {
      console.log(newVal)
    }
  },
}
</script>

<style scoped>

</style>