package com.sphere.web.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.sphere.mybatis.entity.Order;
import com.sphere.web.dto.OrderDTO;
import com.sphere.web.service.OrderService;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户模块
 * @author andy_lai
 * @date 2019-11-02
 */
@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController extends ApiController {
    OrderService service;
    MapperFacade mapperFacade;
    @PostMapping
    public R save(@RequestBody OrderDTO dto){
        return success(service.save(mapperFacade.map(dto, Order.class)));
    }

    @DeleteMapping
    public R delete(Long id){
        return success(service.removeById(id));
    }

    @PutMapping
    public R update(@RequestBody OrderDTO dto){
        return success(service.updateById(mapperFacade.map(dto, Order.class)));
    }

    @GetMapping
    public R get(Long id){
        return success(service.getById(id));
    }
}
