<template>

  <el-container style="min-height: 100vh">
    <!--    侧边栏容器   -->
    <el-aside :width="isCollapse?'64px':'200px'"
              style="background-color: rgb(238, 241, 246); box-shadow: 2px 0 6px rgb(0 21 41 / 35%);">
      <Aside :isCollapse="isCollapse"/>
    </el-aside>
    <el-container>
      <!--    顶栏容器   -->
      <el-header style="border-bottom: 1px solid #ccc;">
        <Header :isCollapse="isCollapse" :collapse="collapse"/>
      </el-header>
      <!--    主要区域容器   -->
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>

import Aside from "@/components/Aside";
import Header from "@/components/Header";

export default {
  name: "Layout",
  components: {
    Aside, Header
  },
  data() {
    return {
      isCollapse: false,
    }
  },
  methods: {
    collapse() {  // 点击收缩按钮触发
      this.isCollapse = !this.isCollapse
    },
  }
}
</script>

<style scoped>

</style>