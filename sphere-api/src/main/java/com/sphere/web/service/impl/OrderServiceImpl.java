package com.sphere.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sphere.mybatis.entity.Order;
import com.sphere.mybatis.mapper.OrderMapper;
import com.sphere.web.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Generator
 * @since 2019-10-31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
