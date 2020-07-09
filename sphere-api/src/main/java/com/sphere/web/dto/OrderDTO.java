package com.sphere.web.dto;


import com.sphere.core.bean.ImABean;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author min.lai
 * @date 2020-07-09
 * dto
 */

@Data
@Builder
public class OrderDTO implements ImABean {
    private Long id;
    private Double price;
    private Integer userId;
    private Integer status;
}
