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

        <!--<div id="lineChart" style="width: 800px; height: 700px; left: 25%"></div>-->


        <el-row style="margin-top: 10px;">
            <el-col :span=12 style="margin-top: 10px">
                <div id="lineChart1" style="width: 500px; height: 500px; left: 15%"></div>
            </el-col>
            <el-col :span=12 style="margin-top: 10px">
                <div id="lineChart2" style="width: 500px; height: 500px; left: 15%"></div>
            </el-col>
        </el-row>


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
        this.drawLineChart1();
        this.drawLineChart2();
        // 暂时隐藏饼图，方法暂不调用
        // this.drawPieChart();
    },
    methods: {
        searchChartData() {
            //todo 根据学号查询趋势图数据，格式化数据展示
        },
        drawLineChart1() {
            const colors = ['#5470c6', '#91cc75'];
            var chartDom = document.getElementById('lineChart1');
            var myChart = echarts.init(chartDom);
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                title: {
                    text: '男大学生50米跑平均值、不及格率各年份变化趋势',
                    left: 'center',
                    y: 'bottom',
                    textStyle: {
                        //文字颜色
                        color: '#000',
                        //字体风格,'normal','italic','oblique'
                        fontStyle: 'normal',
                        //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
                        fontWeight: 'bold',
                        //字体系列
                        fontFamily: 'sans-serif',
                        //字体大小
                        fontSize: 18
                    }
                },
                grid: {
                    right: '8%',
                },
                legend: {
                    top: '5%',
                    data: ['平均成绩', '不及格率']
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        // prettier-ignore
                        data: ['2013', '2014', '2015', '2016', '2017', '2018', '2019']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '平均成绩(s)',
                        position: 'left',
                        alignTicks: true,
                        min: 7.26, // y轴的最小值为0
                        max: 7.48, // y轴的最大值为500
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[1]
                            }
                        },
                        axisLabel: {
                            formatter: function (value, index) {
                                return value.toFixed(2);
                            }
                        }
                    },
                    {
                        type: 'value',
                        name: '不及格率(%)',
                        position: 'right',
                        alignTicks: true,
                        min: 0, // y轴的最小值为0
                        max: 3.5, // y轴的最大值为500
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[0]
                            }
                        },
                        axisLabel: {
                            formatter: function (value, index) {
                                return value.toFixed(2);
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '平均成绩',
                        type: 'bar',
                        yAxisIndex: 0,
                        barWidth: 30,
                        data: [7.3998,7.3816,7.3786,7.4081,7.3325,7.3741,7.4517]
                    },
                    {
                        name: '不及格率',
                        type: 'line',
                        yAxisIndex: 1,
                        barWidth: 30,
                        data: [0.8,0.7,3,0.8,0.8,0.4,0.5]
                    }
                ]
            };
            myChart.setOption(option);
        },

        drawLineChart2() {
            const colors = ['#5470c6', '#91cc75'];
            var chartDom = document.getElementById('lineChart2');
            var myChart = echarts.init(chartDom);
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                title: {
                    text: '女大学生50米跑成绩、不及格率各年份变化趋势',
                    left: 'center',
                    y: 'bottom',
                    textStyle: {
                        //文字颜色
                        color: '#000',
                        //字体风格,'normal','italic','oblique'
                        fontStyle: 'normal',
                        //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
                        fontWeight: 'bold',
                        //字体系列
                        fontFamily: 'sans-serif',
                        //字体大小
                        fontSize: 18
                    }
                },
                grid: {
                    right: '8%',
                },
                legend: {
                    top: '5%',
                    data: ['平均成绩', '不及格率']
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        // prettier-ignore
                        data: ['2013', '2014', '2015', '2016', '2017', '2018', '2019']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '平均成绩(s)',
                        position: 'left',
                        alignTicks: true,
                        min: 8.95, // y轴的最小值为0
                        max: 9.25, // y轴的最大值为500
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[1]
                            }
                        },
                        axisLabel: {
                            formatter: function (value, index) {
                                return value.toFixed(2);
                            }
                        }
                    },
                    {
                        type: 'value',
                        name: '不及格率(%)',
                        position: 'right',
                        alignTicks: true,
                        min: 0, // y轴的最小值为0
                        max: 7, // y轴的最大值为500
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[0]
                            }
                        },
                        axisLabel: {
                            formatter: function (value, index) {
                                return value.toFixed(2);
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '平均成绩',
                            type: 'bar',
                        yAxisIndex: 0,
                        barWidth: 30,
                        data: [9.0514,9.2246,9.147,9.2291,9.1043,9.1736,9.2213]
                    },
                    {
                        name: '不及格率',
                            type: 'line',
                        yAxisIndex: 1,
                        data: [2.78,5.99,3.18,6.63,2.92,4.68,5.21]
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
                title: {
                    text: '学生BMI年变化占比图',
                    left: 'center',
                    y: 'bottom',
                    textStyle: {
                        //文字颜色
                        color: '#000',
                        //字体风格,'normal','italic','oblique'
                        fontStyle: 'normal',
                        //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
                        fontWeight: 'bold',
                        //字体系列
                        fontFamily: 'sans-serif',
                        //字体大小
                        fontSize: 18
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