package com.demo.springboot.service.impl;

import com.demo.springboot.entity.Student;
import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gangzhen
 * @since 2022-11-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
