package com.demo.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.springboot.controller.request.ConditionRequest;
import com.demo.springboot.entity.BodyData;
import com.demo.springboot.service.IBodyDataService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gangzhen
 * @since 2022-11-16
 */
@RestController
@RequestMapping("/bodyData")
public class BodyDataController {

    @Resource
    private IBodyDataService bodyDataService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody BodyData bodyData) {
        if ("男".equals(bodyData.getGender())) {
            bodyData.setLong1000(bodyData.getLongRun());
        } else if ("女".equals(bodyData.getGender())) {
            bodyData.setLong800(bodyData.getLongRun());
        }
        return bodyDataService.saveOrUpdate(bodyData);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bodyDataService.removeById(id);
    }

    @DeleteMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return bodyDataService.removeByIds(ids);
    }

    @GetMapping
    public List<BodyData> findAll() {
        return bodyDataService.list();
    }

    @GetMapping("/{id}")
    public BodyData findOne(@PathVariable Integer id) {
        return bodyDataService.getById(id);
    }

    @PostMapping("/page")
    public Page<BodyData> findPage(@RequestBody ConditionRequest condition,
                                   @RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
        QueryWrapper<BodyData> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(condition.getStudentId() != null, "student_id", condition.getStudentId());
        queryWrapper.like(!StringUtils.isEmpty(condition.getStudentName()), "student_name", condition.getStudentName());
        queryWrapper.like(!StringUtils.isEmpty(condition.getGender()), "gender", condition.getGender());
        queryWrapper.orderByAsc("id");
        Page<BodyData> pageResult = bodyDataService.page(new Page<>(pageNum, pageSize), queryWrapper);
        pageResult.getRecords().forEach(record -> {
            if ("男".equals(record.getGender())) {
                record.setLongRun(record.getLong1000());
            } else if ("女".equals(record.getGender())) {
                record.setLongRun(record.getLong800());
            } else {
                record.setLongRun("性别未知");
            }
        });
        return pageResult;
    }

}

