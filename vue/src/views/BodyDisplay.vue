<template>
  <div>
    <el-form :inline="true" class="demo-form-inline" style="margin-left: 60px; margin-top: 20px;">
      <el-form-item label="学号:">
        <el-input v-model="studentId" placeholder="请输入学号" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchChartData">查询 <i class="el-icon-search"></i></el-button>
      </el-form-item>
    </el-form>

    <div id="lineChart" style="width: 800px; height: 700px; left: 25%"></div>

    <!-- 暂时隐藏饼图，故此处span按24处理-->
<!--    <el-row style="margin-top: 10px;">-->
<!--      <el-col :span=15>-->
<!--        <div id="lineChart" style="width: 800px; height: 700px"></div>-->
<!--      </el-col>-->
<!--      <el-col :span=9 style="margin-top: 100px">-->
<!--       <div id="pieChart" style="width: 600px; height: 600px"></div>-->
<!--      </el-col>-->
<!--    </el-row>-->

  </div>
</template>

<script>

import * as echarts from 'echarts'

export default {
  name: "BodyDisplay",
  data() {
    return {
      studentId: ''
    }
  },
  mounted() {
    this.drawLineChart();
    // 暂时隐藏饼图，方法暂不调用
    // this.drawPieChart();
  },
  methods: {
    searchChartData() {
      //todo 根据学号查询趋势图数据，格式化数据展示
    },
    drawLineChart() {
      const colors = ['#5470C6', '#FF0087'];
      var chartDom = document.getElementById('lineChart');
      var myChart = echarts.init(chartDom);
      var option = {
        color: colors,
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          }
        },
        title:{
          text:'学生体重身高各年份变化趋势',
          left: 'center',
          y: 'bottom',
          textStyle:{
            //文字颜色
            color:'#000',
            //字体风格,'normal','italic','oblique'
            fontStyle:'normal',
            //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
            fontWeight:'bold',
            //字体系列
            fontFamily:'sans-serif',
            //字体大小
            fontSize:18
          }
        },
        grid: {
          right: '8%',
        },
        legend: {
          top: '5%',
          data: ['体重', '身高']
        },
        xAxis: [
          {
            type: 'category',
            axisTick: {
              alignWithLabel: true
            },
            // prettier-ignore
            data: ['2019', '2020', '2021', '2022']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '体重',
            position: 'right',
            alignTicks: true,
            axisLine: {
              show: true,
              lineStyle: {
                color: colors[0]
              }
            },
            axisLabel: {
              formatter: '{value} kg'
            }
          },
          {
            type: 'value',
            name: '身高',
            position: 'left',
            alignTicks: true,
            axisLine: {
              show: true,
              lineStyle: {
                color: colors[1]
              }
            },
            axisLabel: {
              formatter: '{value} cm'
            }
          }
        ],
        series: [
          {
            name: '体重',
            type: 'bar',
            yAxisIndex: 0,
            barWidth : 50,
            data: [
              55.0, 65.2, 45.0, 80.5
            ]
          },
          {
            name: '身高',
            type: 'line',
            yAxisIndex: 1,
            data: [175.2, 169.3, 180.5, 190.6]
          }
        ]
      };
      myChart.setOption(option);
    },
    //todo 暂时隐藏饼图，方法暂留，图表隐藏
    drawPieChart() {
      const colors = ['#5470C6', '#91CC75', '#EE6666'];
      var chartDom = document.getElementById('pieChart');
      var myChart = echarts.init(chartDom);
      var option = {
        title:{
          text:'学生BMI年变化占比图',
          left: 'center',
          y: 'bottom',
          textStyle:{
            //文字颜色
            color:'#000',
            //字体风格,'normal','italic','oblique'
            fontStyle:'normal',
            //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
            fontWeight:'bold',
            //字体系列
            fontFamily:'sans-serif',
            //字体大小
            fontSize:18
          }
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            data: [
              {value: 1048, name: 'Search Engine'},
              {value: 735, name: 'Direct'},
              {value: 580, name: 'Email'},
              {value: 484, name: 'Union Ads'},
              {value: 300, name: 'Video Ads'}
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myChart.setOption(option);
    }
  },
}
</script>

<style scoped>

</style>