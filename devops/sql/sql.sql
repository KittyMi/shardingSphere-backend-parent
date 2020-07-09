CREATE TABLE `t_order_1` (
  `id` bigint NOT NULL COMMENT '主键',
  `price` float(10,3) DEFAULT NULL COMMENT '价格',
  `user_id` int DEFAULT NULL COMMENT '用户',
  `status` int DEFAULT '1' COMMENT '状态 1正常 -1无效',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `gmt_updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';

CREATE TABLE `t_order_2` (
  `id` bigint NOT NULL COMMENT '主键',
  `price` float(10,3) DEFAULT NULL COMMENT '价格',
  `user_id` int DEFAULT NULL COMMENT '用户',
  `status` int DEFAULT '1' COMMENT '状态 1正常 -1无效',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `gmt_updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';

