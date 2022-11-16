<template>
  <div>
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item label="学号">
        <el-input v-model="searchForm.studentId" placeholder="请输入学号" clearable></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="searchForm.studentName" placeholder="请输入姓名" clearable></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="searchForm.gender" placeholder="性别" clearable>
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="info" @click="resetCondition">清空 <i class="el-icon-refresh"></i></el-button>
        <el-button type="primary" @click="searchRecord">查询 <i class="el-icon-search"></i></el-button>
        <el-button type="success" @click="addRecord">新增 <i class="el-icon-circle-plus"></i></el-button>
        <el-button type="warning" v-show="batchDeleteFlag" @click="handleBatchDelete">选择删除 <i
            class="el-icon-delete-solid"></i></el-button>
        <el-popconfirm
            class="ml-10"
            v-show="!batchDeleteFlag"
            confirm-button-text='确定'
            cancel-button-text='取消'
            icon="el-icon-info"
            icon-color="red"
            title="确定删除选中的记录吗？"
            @confirm="batchDeleteRecord"
        >
          <el-button type="danger" slot="reference">删除 <i class="el-icon-delete-solid"></i></el-button>
        </el-popconfirm>
      </el-form-item>
    </el-form>

    <el-table :data="tableData" stripe border :header-cell-style="{background:'#FAFAFA'}"
              @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="40" :selectable='checkBoxStatus'>
      </el-table-column>
      <el-table-column prop="id" label="序号" width="80" align="center">
      </el-table-column>
      <el-table-column prop="studentId" label="学号" align="center">
      </el-table-column>
      <el-table-column prop="studentName" label="姓名" align="center">
      </el-table-column>
      <el-table-column prop="gender" label="性别" width="100" align="center">
      </el-table-column>
      <el-table-column prop="term" label="学年" width="150" align="center">
      </el-table-column>
      <el-table-column prop="height" label="身高(cm)" width="150" align="center">
      </el-table-column>
      <el-table-column prop="weight" label="体重(kg)" width="150" align="center">
      </el-table-column>
      <el-table-column prop="vitalCapacity" label="肺活量()" width="150" align="center">
      </el-table-column>
      <el-table-column prop="sitForwardBend" label="坐姿体前屈()" width="150" align="center">
      </el-table-column>
      <el-table-column prop="dash50" label="50m跑成绩" width="150" align="center">
      </el-table-column>
      <el-table-column prop="longRun" label="长跑成绩(男:1000m 女:800m)" width="150" align="center">
      </el-table-column>
      <el-table-column prop="address" label="操作" width="150px" align="center">
        <template v-slot="scope">
          <el-button type="info" icon="el-icon-edit" @click="modifyRecord(scope.row)" circle></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text='确定'
              cancel-button-text='取消'
              icon="el-icon-info"
              icon-color="red"
              title="确定删除一条记录吗？"
              @confirm="deleteRecord(scope.row.id)"
          >
            <el-button type="danger" icon="el-icon-circle-close" slot="reference" circle></el-button>
          </el-popconfirm>
        </template>
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

    <el-dialog title="学生信息" :visible.sync="dialogFormVisible" width="25%">
      <el-form :model="infoForm" :rules="rules" ref="infoForm" :label-width="formLabelWidth" size="small"
               style="width:82%">
        <el-form-item label="学号:" prop="studentId">
          <el-input v-model="infoForm.studentId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学生姓名:" prop="studentName">
          <el-input v-model="infoForm.studentName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别:" prop="gender">
          <el-select v-model="infoForm.gender" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学期:" prop="term">
          <el-input v-model="infoForm.term" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="身高:">
          <el-input v-model="infoForm.height" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="体重:">
          <el-input v-model="infoForm.weight" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="肺活量:">
          <el-input v-model="infoForm.vitalCapacity" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="坐姿体前屈:">
          <el-input v-model="infoForm.sitForwardBend" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="50m短跑:">
          <el-input v-model="infoForm.dash50" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="长跑:">
          <el-input v-model="infoForm.longRun" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelHandle">取 消</el-button>
        <el-button @click="resetRecord('infoForm')">重 置</el-button>
        <el-button type="primary" @click="submitRecord('infoForm')">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "BodyData",
  data() {
    return {
      pageSize: 10,
      pageNum: 1,
      totalNum: 20,
      batchDeleteFlag: true,
      dialogFormVisible: false,
      tableData: [],
      batchRecordIds: [],
      searchForm: {
        studentId: "",
        studentName: "",
        gender: "",
      },
      infoForm: {
        id: "",
        studentId: "", //学号
        studentName: "", //姓名
        gender: "", //性别
        term: "", //学期
        height: "", //身高
        weight: "", //体重
        vitalCapacity: "", //肺活量
        sitForwardBend: "", //坐姿体前屈
        dash50: "", //50m成绩
        longRun: "" //长跑成绩
      },
      formLabelWidth: '145px',
      rules: {
        studentId: [
          {required: true, message: '请输入学号', trigger: 'blur'},
          {pattern: /^(0|[1-9][0-9]*)$/, message: "请输入数字", trigger: "blur"}
        ],
        studentName: [
          {required: true, message: '请输入学生姓名', trigger: 'blur'}
        ],
        gender: [
          {required: true, message: '请选择性别', trigger: 'change'}
        ],
        term: [
          {required: true, message: '请输入学期', trigger: 'blur'}
        ]
      }
    }
  },
  created() {
    this.searchRecord()
  },
  methods: {
    resetCondition() {
      //清空查询条件
      this.searchForm = {}
    },
    handleSelectionChange(records) {
      this.batchRecordIds = [];
      this.batchRecordIds = records.map(v => v.id)
    },
    searchRecord() {
      //分页查询
      this.$http.post("/bodyData/page", this.searchForm, {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.records
        this.totalNum = res.total
      })
    },
    deleteRecord(id) {
      //删除
      this.$http.delete("/bodyData/" + id).then(res => {
        console.log(res)
        if (res) {
          this.$message.success('删除成功')
        } else {
          this.$message.error('删除失败')
        }
        this.searchRecord()
      })
    },
    checkBoxStatus(row, rowIndex) {
      return !this.batchDeleteFlag;
    },
    handleBatchDelete() {
      this.batchDeleteFlag = !this.batchDeleteFlag
    },
    batchDeleteRecord() {
      this.batchDeleteFlag = !this.batchDeleteFlag
      if (this.batchRecordIds.length === 0) {
        this.$message.info('未选择删除的记录')
      } else {
        this.$http.delete("/bodyData/del/batch", {data: this.batchRecordIds}).then(res => {
          console.log(res)
          if (res) {
            this.$message.success('删除成功')
          } else {
            this.$message.error('删除失败')
          }
          this.searchRecord()
        })
      }
    },
    addRecord() {
      //新增
      this.infoForm = {}
      this.dialogFormVisible = true
    },
    modifyRecord(row) {
      //编辑
      console.log(row)
      this.infoForm = {
        id: row.id,
        studentId: row.studentId, //学号
        studentName: row.studentName, //姓名
        gender: row.gender, //性别
        term: row.term, //学期
        height: row.height, //身高
        weight: row.weight, //体重
        vitalCapacity: row.vitalCapacity, //肺活量
        sitForwardBend: row.sitForwardBend, //坐姿体前屈
        dash50: row.dash50, //50m成绩
        longRun: row.longRun //长跑成绩
      }
      this.dialogFormVisible = true
    },
    cancelHandle() {
      this.infoForm = {}
      this.dialogFormVisible = false
    },
    resetRecord(formName) {
      this.$refs[formName].resetFields();
    },
    submitRecord(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.dialogFormVisible = false
          this.$http.post("/bodyData", this.infoForm).then(res => {
            console.log(res)
            if (res) {
              this.$message.success('提交成功')
            } else {
              this.$message.error('提交失败')
            }
            this.searchRecord()
          })
        } else {
          console.log('error submit!!')
          return false;
        }
      });
    },
    handleSizeChange(pageSize) {
      console.log(`每页 ${pageSize} 条`)
      this.pageSize = pageSize
      this.searchRecord()
    },
    handleCurrentChange(pageNum) {
      console.log(`当前页: ${pageNum}`)
      this.pageNum = pageNum
      this.searchRecord()
    },
  }
}
</script>

<style scoped>

</style>