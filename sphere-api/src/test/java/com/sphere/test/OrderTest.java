package com.sphere.test;

import com.sphere.web.SphereApplication;
import com.sphere.web.controller.OrderController;
import com.sphere.web.dto.OrderDTO;
import com.sphere.web.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = SphereApplication.class)
public class OrderTest {
    @Resource
    OrderController api;

    @Test
    public void testSave(){
        for(int i=0;i<10;i++) {
            OrderDTO dto = OrderDTO.builder()
                    .price(i*50f%9+Math.random())
                    .status(1)
                    .userId(1)
                    .build();
            log.info(api.save(dto).toString());
        }
    }
    @Test
    public void testUpdate(){
        OrderDTO dto=OrderDTO.builder()
                .price(3.99d)
                .status(1)
                .userId(1)
                .id(487939378794987521L)
                .build();
        log.info(api.update(dto).toString());
    }
    @Test
    public void testGet(){
        log.info(api.get(487939378794987521L).toString());
    }
    @Test
    public void testDelete(){
        log.info(api.delete(487939378794987521L).toString());
    }
}
