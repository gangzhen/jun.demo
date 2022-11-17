<template>
  <div>
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item>
        <el-select v-model="searchForm.gender" placeholder="Top排名" clearable>
          <el-option label="top10" value="top10"></el-option>
          <el-option label="top50" value="top50"></el-option>
          <el-option label="top100" value="top100"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-select v-model="searchForm.gender" placeholder="性别" clearable>
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="info" @click="resetCondition">清空 <i class="el-icon-refresh"></i></el-button>
        <el-button type="primary" @click="searchRankRecords">查询 <i class="el-icon-search"></i></el-button>
      </el-form-item>
    </el-form>

    <el-table :data="tableData" stripe border :header-cell-style="{background:'#FAFAFA'}">
      <el-table-column type="index" width="50" label="排名" align="center">
      </el-table-column>
      <el-table-column prop="studentId" label="学号" align="center">
      </el-table-column>
      <el-table-column prop="studentName" label="姓名" align="center">
      </el-table-column>
      <el-table-column prop="gender" label="性别" width="100" align="center">
      </el-table-column>
      <el-table-column prop="term" label="学年" width="150" align="center">
      </el-table-column>
      <el-table-column prop="weightPoint" label="体重指数得分" width="150" align="center">
      </el-table-column>
      <el-table-column prop="vitalCapacityPoint" label="肺活量得分" width="150" align="center">
      </el-table-column>
      <el-table-column prop="vitalCapacityPoint" label="立定跳远得分" width="150" align="center">
      </el-table-column>
      <el-table-column prop="sitForwardBendPoint" label="坐姿体前屈得分" width="150" align="center">
      </el-table-column>
      <el-table-column prop="dash50Point" label="50m跑得分" width="150" align="center">
      </el-table-column>
      <el-table-column prop="longRunPoint" label="长跑得分" width="150" align="center">
      </el-table-column>
      <el-table-column prop="points" label="总得分" width="150" align="center">
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
  </div>
</template>

<script>
export default {
  name: "ScoreRank",
  data() {
    const item = {
      studentId: '20221117',
      studentName: 'admin',
      gender: '男',
      term: '2021年',
      weightPoint: '10',
      vitalCapacityPoint: '10',
      standJumpPoint: '上海市普陀区金沙江路 1518 弄',
      sitForwardBendPoint: '10',
      dash50Point: '10',
      longRunPoint: '10',
      points: '100',
    };
    return {
      pageSize: 1,
      pageNum: 10,
      totalNum: 20,
      tableData: this.tableData = Array(20).fill(item),
      searchForm: {},
    }
  },
  created() {
    this.searchRankRecords()
  },
  methods: {
    searchRankRecords() {
      //todo 后端调用查询接口
    },
    resetCondition() {
      this.searchForm = {}
    },
    handleSizeChange(pageSize) {
      console.log(`每页 ${pageSize} 条`)
      this.pageSize = pageSize
      this.searchRankRecords()
    },
    handleCurrentChange(pageNum) {
      console.log(`当前页: ${pageNum}`)
      this.pageNum = pageNum
      this.searchRankRecords()
    },
  }
}
</script>

<style scoped>

</style>