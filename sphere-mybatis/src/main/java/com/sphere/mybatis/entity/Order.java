package com.sphere.mybatis.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

    import java.math.BigDecimal;

/**
* <p>
    * 用户表
    * </p>
*
* @author Generator
* @since 2019-10-31
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_order")
public class Order extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Double price;
    private Integer userId;
    private Integer status;
}
