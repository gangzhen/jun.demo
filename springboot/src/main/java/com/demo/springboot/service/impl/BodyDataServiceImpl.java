package com.demo.springboot.service.impl;

import com.demo.springboot.entity.BodyData;
import com.demo.springboot.mapper.BodyDataMapper;
import com.demo.springboot.service.IBodyDataService;
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
public class BodyDataServiceImpl extends ServiceImpl<BodyDataMapper, BodyData> implements IBodyDataService {

}
