
drop DATABASE if EXISTS mybatis;
create database if not EXISTS mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use mybatis;
CREATE TABLE t_user
(
  user_id            BIGINT AUTO_INCREMENT
  COMMENT '用户ID'
    PRIMARY KEY,
  user_name          VARCHAR(64) NOT NULL
  COMMENT '用户名',
  mobile             VARCHAR(64) NULL
  COMMENT '手机号',
  email              VARCHAR(64) NULL
  COMMENT '邮件',
  password           VARCHAR(64) NULL
  COMMENT '密码:8-16位大小写字母+数字+特殊字符',
  cardNumber         VARCHAR(64) NULL
  COMMENT '身份证号:15位或者18位整数',
  register_ip        VARCHAR(64) NULL
  COMMENT '注册IP:例如192.168.1.97',
  register_date      DATETIME    NULL
  COMMENT '注册日期:例如2018-01-31',
  register_resources VARCHAR(32) NULL
  COMMENT '注册来源:H5,PC,Android,IOS
	',
  CONSTRAINT t_user_user_id_uindex
  UNIQUE (user_id)
)
  COMMENT '用户信息'
  ENGINE = InnoDB;
