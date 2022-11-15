package com.demo.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.springboot.entity.BodyData;
import com.demo.springboot.service.IBodyDataService;
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
        return bodyDataService.saveOrUpdate(bodyData);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bodyDataService.removeById(id);
    }

    @PostMapping("/del/batch")
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

    @GetMapping("/page")
    public Page<BodyData> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<BodyData> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return bodyDataService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

