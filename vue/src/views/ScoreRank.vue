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
      <el-table-column prop="standJumpPoint" label="立定跳远得分" width="150" align="center">
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
      standJumpPoint: '15',
      sitForwardBendPoint: '10',
      dash50Point: '10',
      longRunPoint: '10',
      points: '100',
    };
    return {
      pageSize: 20,
      pageNum: 1,
      totalNum: 20,
      tableData: [
        {
          studentId: 20190217,
          studentName: '刘*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190316,
          studentName: '李*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190407,
          studentName: '王*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190327,
          studentName: '潘*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190615,
          studentName: '张*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190923,
          studentName: '朱*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190911,
          studentName: '李*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 100
        },{
          studentId: 20190128,
          studentName: '陈*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 14,
          standJumpPoint: 15,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 9,
          points: 98
        },{
          studentId: 20191015,
          studentName: '贾*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 14,
          standJumpPoint: 15,
          sitForwardBendPoint: 9,
          dash50Point: 10,
          longRunPoint: 10,
          points: 98
        },{
          studentId: 20190514,
          studentName: '赵*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 14,
          standJumpPoint: 14,
          sitForwardBendPoint: 10,
          dash50Point: 10,
          longRunPoint: 10,
          points: 98
        },{
          studentId: 20190324,
          studentName: '张*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 15,
          standJumpPoint: 15,
          sitForwardBendPoint: 9,
          dash50Point: 9,
          longRunPoint: 9,
          points: 97
        },{
          studentId: 20190335,
          studentName: '孔*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 14,
          standJumpPoint: 14,
          sitForwardBendPoint: 9,
          dash50Point: 9,
          longRunPoint: 9,
          points: 96
        },{
          studentId: 20190429,
          studentName: '吕*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 14,
          standJumpPoint: 13,
          sitForwardBendPoint: 8,
          dash50Point: 9,
          longRunPoint: 9,
          points: 93
        },{
          studentId: 20190941,
          studentName: '华*',
          gender: '男',
          term: '2019年',
          weightPoint: 13,
          vitalCapacityPoint: 13,
          standJumpPoint: 15,
          sitForwardBendPoint: 6,
          dash50Point: 9,
          longRunPoint: 10,
          points: 91
        },{
          studentId: 20190232,
          studentName: '周*',
          gender: '男',
          term: '2019年',
          weightPoint: 11,
          vitalCapacityPoint: 15,
          standJumpPoint: 13,
          sitForwardBendPoint: 8,
          dash50Point: 9,
          longRunPoint: 9,
          points: 90
        },{
          studentId: 20190634,
          studentName: '吴*',
          gender: '男',
          term: '2019年',
          weightPoint: 14,
          vitalCapacityPoint: 14,
          standJumpPoint: 14,
          sitForwardBendPoint: 5,
          dash50Point: 9,
          longRunPoint: 9,
          points: 90
        },{
          studentId: 20190619,
          studentName: '李*',
          gender: '男',
          term: '2019年',
          weightPoint: 13,
          vitalCapacityPoint: 14,
          standJumpPoint: 14,
          sitForwardBendPoint: 9,
          dash50Point: 10,
          longRunPoint: 4,
          points: 89
        },{
          studentId: 20190929,
          studentName: '陈*',
          gender: '男',
          term: '2019年',
          weightPoint: 15,
          vitalCapacityPoint: 13,
          standJumpPoint: 13,
          sitForwardBendPoint: 6,
          dash50Point: 10,
          longRunPoint: 6,
          points: 88
        },{
          studentId: 20190921,
          studentName: '杨*',
          gender: '男',
          term: '2019年',
          weightPoint: 12,
          vitalCapacityPoint: 12,
          standJumpPoint: 12,
          sitForwardBendPoint: 10,
          dash50Point: 7,
          longRunPoint: 9,
          points: 87
        },
        {
          studentId: 20190121,
          studentName: '谢*',
          gender: '男',
          term: '2019年',
          weightPoint: 11,
          vitalCapacityPoint: 11,
          standJumpPoint: 11,
          sitForwardBendPoint: 9,
          dash50Point: 9,
          longRunPoint: 10,
          points: 86
        }

      ],
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