package com.sphere.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 实体的公共的字段
 * @author fly
 * @date 2019-09-26
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    /**
     * 主键，默认自增
     */
    private Long id;
    /**
     * Insert时生成，MyMetaObjectHandler自动填充
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Timestamp gmtCreate;
    /**
     * Insert, Update时生成，MyMetaObjectHandler自动填充
     */
    @TableField(value = "gmt_updated", fill = FieldFill.INSERT_UPDATE)
    private Timestamp gmtUpdated;
}
