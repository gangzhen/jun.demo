<template>
  <el-container style="min-height: 100vh">
    <el-aside :width="isCollapse?'64px':'200px'"
              style="background-color: rgb(238, 241, 246); box-shadow: 2px 0 6px rgb(0 21 41 / 35%);">
      <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden"
               background-color="rgb(48, 65, 86)"
               text-color="#fff"
               active-text-color="#ffd04b"
               :collapse-transition="false"
               :collapse="isCollapse"
      >
        <div style="height: 60px; line-height: 60px; text-align: center">
          <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px; margin-right: 5px">
          <b style="color: white" v-show="!isCollapse">后台管理系统</b>
        </div>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>
            <span>首页</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1">学生信息列表</el-menu-item>
            <el-menu-item index="1-2">学生信息展示</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px; display: flex">
        <div style="flex: 1; font-size: 20px">
          <span :class="isCollapse?'el-icon-s-unfold':'el-icon-s-fold'" style="cursor: pointer"
                @click="collapse"></span>
        </div>
        <el-dropdown style="width: 70px; cursor: pointer">
          <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <el-main>

        <div class="mb-30">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>学生列表</el-breadcrumb-item>
          </el-breadcrumb>
        </div>


        <el-form :inline="true" :model="searchForm" class="demo-form-inline">
          <el-form-item label="学号">
            <el-input v-model="searchForm.stdId" placeholder="请输入学号"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="searchForm.stdName" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-select v-model="searchForm.stdGender" placeholder="性别">
              <el-option label="男" value="nan"></el-option>
              <el-option label="女" value="nv"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="日期">
            <el-date-picker class="ml-5"
                            v-model="searchForm.timeRange"
                            type="datetimerange"
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="info" @click="clearCondition">清空 <i class="el-icon-refresh"></i></el-button>
            <el-button type="primary" @click="searching">查询 <i class="el-icon-search"></i></el-button>
            <el-button type="success" @click="addRecord">新增 <i class="el-icon-circle-plus"></i></el-button>
            <el-button type="danger" @click="deleteRecord">批量删除 <i class="el-icon-delete-solid"></i></el-button>
          </el-form-item>
        </el-form>

        <el-table :data="tableData" :header-cell-class-name="headerBg">
          <el-table-column prop="id" label="序号" width="60">
          </el-table-column>
          <el-table-column prop="studentId" label="学号">
          </el-table-column>
          <el-table-column prop="studentName" label="姓名">
          </el-table-column>
          <el-table-column prop="term" label="学年" width="180">
          </el-table-column>
          <el-table-column prop="height" label="身高(cm)" width="150">
          </el-table-column>
          <el-table-column prop="weight" label="体重(kg)" width="150">
          </el-table-column>
          <el-table-column prop="vitalCapacity" label="肺活量()" width="150">
          </el-table-column>
          <el-table-column prop="sitForwardBend" label="坐姿体前屈()" width="150">
          </el-table-column>
          <el-table-column prop="dash50" label="50m跑成绩" width="150">
          </el-table-column>
          <el-table-column prop="long1000" label="长跑成绩(男:1000m 女:800m)" width="150">
          </el-table-column>
          <el-table-column prop="address" label="操作" width="150px">
            <el-button type="info" icon="el-icon-edit" @click="addRecord" circle></el-button>
            <el-button type="danger" icon="el-icon-circle-close" @click="deleteRecord" circle></el-button>
          </el-table-column>
        </el-table>

        <div class="pd-10">
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[5, 10, 15, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="totalNum">
          </el-pagination>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'HomeView',
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      pageSize: 10,
      pageNum: 4,
      totalNum: 20,
      isCollapse: false,
      searchForm: {
        stdId: 1111,
        stdName: "11",
        stdGender: "nv",
        timeRange: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
      },
      tableData: Array(10).fill(item),
      headerBg: 'headerBg',
    }

  },
  created() {
    this.searching()
  },
  methods: {
    clearCondition() {
      //清空查询条件
      this.searchForm = {}
    },
    searching() {
      //查询
      request.get("http://localhost:9090/bodyData/page?pageNum=1&pageSize=5").then(res => {
        console.log(res)
        this.tableData = res.records
        this.totalNum = res.total
      })
    },
    addRecord() {
      //新增
    },
    deleteRecord() {
      //删除
    },
    collapse() {  // 点击收缩按钮触发
      this.isCollapse = !this.isCollapse
    },
    handleSizeChange(pageSize) {
      console.log(`每页 ${pageSize} 条`)
      this.pageSize = pageSize;
    },
    handleCurrentChange(pageNum) {
      console.log(`当前页: ${pageNum}`)
      this.pageNum = pageNum;
    },
  }
}
</script>

<style>
.headerBg {
  background: #ccc !important;
}
</style>
