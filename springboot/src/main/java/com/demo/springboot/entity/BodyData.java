package com.demo.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author gangzhen
 * @since 2022-11-16
 */
@TableName("body_data")
@ApiModel(value = "BodyData对象", description = "")
public class BodyData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("学生学号")
    private Integer studentId;

    @ApiModelProperty("学生姓名")
    private String studentName;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("学期")
    private String term;

    @ApiModelProperty("身高")
    private Object height;

    @ApiModelProperty("体重")
    private Object weight;

    @ApiModelProperty("肺活量")
    private String vitalCapacity;

    @ApiModelProperty("坐姿体前屈")
    private String sitForwardBend;

    @ApiModelProperty("50m成绩")
    private String dash50;

    @ApiModelProperty("1000m成绩")
    private String long1000;

    @ApiModelProperty("800m成绩")
    private String long800;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("长跑成绩公共变量，不进行持久化")
    @TableField(exist = false)
    private String longRun;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public String getVitalCapacity() {
        return vitalCapacity;
    }

    public void setVitalCapacity(String vitalCapacity) {
        this.vitalCapacity = vitalCapacity;
    }

    public String getSitForwardBend() {
        return sitForwardBend;
    }

    public void setSitForwardBend(String sitForwardBend) {
        this.sitForwardBend = sitForwardBend;
    }

    public String getDash50() {
        return dash50;
    }

    public void setDash50(String dash50) {
        this.dash50 = dash50;
    }

    public String getLong1000() {
        return long1000;
    }

    public void setLong1000(String long1000) {
        this.long1000 = long1000;
    }

    public String getLong800() {
        return long800;
    }

    public void setLong800(String long800) {
        this.long800 = long800;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getLongRun() {
        return longRun;
    }

    public void setLongRun(String longRun) {
        this.longRun = longRun;
    }

    @Override
    public String toString() {
        return "BodyData{" +
                "id = " + id +
                ", studentId = " + studentId +
                ", studentName = " + studentName +
                ", gender = " + gender +
                ", term = " + term +
                ", height = " + height +
                ", weight = " + weight +
                ", vitalCapacity = " + vitalCapacity +
                ", sitForwardBend = " + sitForwardBend +
                ", dash50 = " + dash50 +
                ", long1000 = " + long1000 +
                ", long800 = " + long800 +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                ", longRun = " + longRun +
                "}";
    }
}
