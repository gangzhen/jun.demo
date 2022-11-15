package com.demo.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.springboot.entity.Student;
import com.demo.springboot.service.IStudentService;
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
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return studentService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return studentService.removeByIds(ids);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    public Student findOne(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @GetMapping("/page")
    public Page<Student> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return studentService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

