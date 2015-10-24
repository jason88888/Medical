/*
Navicat MySQL Data Transfer

Source Server         : medical
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-10-23 16:21:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '代理商代码',
  `name` varchar(50) DEFAULT '' COMMENT '代理商名称',
  `level` varchar(3) DEFAULT '2' COMMENT '代理级别',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  `descript` varchar(200) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商表';

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '单据编号',
  `date` varchar(50) NOT NULL DEFAULT '' COMMENT '开票日期',
  `month` varchar(50) NOT NULL DEFAULT '' COMMENT '单据月份',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `client_code` varchar(11) NOT NULL COMMENT '客户编码',
  `client_name` varchar(100) DEFAULT '' COMMENT '客户名称',
  `two_level_code` varchar(20) DEFAULT NULL COMMENT '二级代码',
  `two_level_name` varchar(100) DEFAULT '' COMMENT '二级姓名',
  `three_level_code` varchar(20) DEFAULT '' COMMENT '三级代码',
  `three_level_name` varchar(100) DEFAULT '' COMMENT '三级姓名',
  `user_code` varchar(11) NOT NULL COMMENT '业务员编码',
  `user_name` varchar(60) NOT NULL COMMENT '用户名',
  `medicine_code` varchar(20) NOT NULL COMMENT '药品编码',
  `medicine_name` varchar(100) NOT NULL COMMENT '药品名称',
  `regional` varchar(100) DEFAULT '' COMMENT '区域',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  `descript` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据表';

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(11) NOT NULL COMMENT '客户编码',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `regional` varchar(100) DEFAULT '' COMMENT '区域代码',
  `business_type` varchar(10) DEFAULT '' COMMENT '商业类型,1纯销，2商业分销，3第三方终端',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  `descript` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Table structure for commercial_company
-- ----------------------------
DROP TABLE IF EXISTS `commercial_company`;
CREATE TABLE `commercial_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '代理商代码',
  `name` varchar(100) NOT NULL COMMENT '代理商名称',
  `eng_name` varchar(20) DEFAULT NULL COMMENT '英文名',
  `attribution` varchar(20) DEFAULT NULL COMMENT '账款归属',
  `area_name` varchar(20) DEFAULT NULL COMMENT '地区',
  `chief_name` varchar(20) DEFAULT NULL COMMENT '负责人',
  `fax_no` varchar(20) DEFAULT NULL COMMENT '传真',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `sale_area` varchar(20) DEFAULT NULL COMMENT '采购销售区域',
  `descript` varchar(20) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '药品编码',
  `name` varchar(100) NOT NULL COMMENT '药品名称',
  `specification` varchar(100) DEFAULT NULL COMMENT '药品规格',
  `manufacturer_name` varchar(100) DEFAULT NULL COMMENT '生产厂商名称',
  `units` varchar(10) DEFAULT NULL COMMENT '单位',
  `price` float(10,3) DEFAULT NULL COMMENT '单价',
  `lot_number` varchar(50) DEFAULT NULL COMMENT '药品批号',
  `validity_period` varchar(50) DEFAULT NULL COMMENT '有效期',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  `package_number` int(11) NOT NULL DEFAULT '0' COMMENT '装箱数',
  `purchase_number` int(11) NOT NULL DEFAULT '0' COMMENT '购进数',
  `unique_code` varchar(20) NOT NULL COMMENT '药品代码（药品的唯一性）',
  `descript` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  `shelf_life` varchar(100) DEFAULT '-1' COMMENT '保质期',
  `bid_price` float(10,3) DEFAULT NULL,
  `sales_range` varchar(100) DEFAULT '' COMMENT '销售区域（可做范围）',
  PRIMARY KEY (`id`,`descript`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for medicine_policy
-- ----------------------------
DROP TABLE IF EXISTS `medicine_policy`;
CREATE TABLE `medicine_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `regional` varchar(100) DEFAULT '' COMMENT '所属区域',
  `month` varchar(10) NOT NULL COMMENT '月份',
  `medicine_code` varchar(20) NOT NULL COMMENT '药品编号',
  `client_code` varchar(11) NOT NULL COMMENT '客户代码',
  `salesman_policy` float(10,3) DEFAULT NULL COMMENT '业务员政策',
  `clinical_policy` float(10,3) DEFAULT NULL COMMENT '临床政策',
  `manufacturer_policy` float(10,3) DEFAULT NULL COMMENT '厂家政策',
  `two_level_policy` float(10,3) DEFAULT NULL COMMENT '二级政策',
  `three_level_policy` float(10,3) DEFAULT NULL COMMENT '三级政策',
  `add_policy1` float(10,3) DEFAULT NULL COMMENT '附加政策1',
  `add_policy2` float(10,3) DEFAULT NULL COMMENT '附加政策2',
  `add_policy3` float(10,3) DEFAULT NULL COMMENT '附加政策3',
  `price` float(10,3) DEFAULT NULL COMMENT '单价',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  `descript` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '供应商编号',
  `name` varchar(20) NOT NULL COMMENT '供应商名称',
  `eng_name` varchar(20) DEFAULT NULL COMMENT '英文名',
  `attribution` varchar(20) DEFAULT NULL COMMENT '账款归属',
  `area_name` varchar(20) DEFAULT NULL COMMENT '地区',
  `chief_name` varchar(20) DEFAULT NULL COMMENT '负责人',
  `fax_no` varchar(20) DEFAULT NULL COMMENT '传真',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `descript` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rk_order
-- ----------------------------
DROP TABLE IF EXISTS `rk_order`;
CREATE TABLE `rk_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '入库单编号',
  `bill_date` varchar(50) DEFAULT NULL COMMENT '单据日期',
  `warehouse_id` int(11) NOT NULL COMMENT '仓库id',
  `medicine_id` int(11) NOT NULL COMMENT '药品id',
  `sys_user_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `commercial_company_id` int(11) NOT NULL,
  `agent_id` int(11) NOT NULL COMMENT '代理商id',
  `provider_id` int(11) DEFAULT NULL COMMENT '配送商id',
  `unit_price` decimal(10,0) DEFAULT NULL COMMENT '实际单价',
  `high_unit_price` decimal(10,0) DEFAULT NULL COMMENT '高开单价',
  `pay_date` varchar(50) DEFAULT NULL COMMENT '采购付款日期',
  `store_date` varchar(50) DEFAULT NULL COMMENT '采购入库日期',
  `order_code` varchar(50) DEFAULT NULL COMMENT '采购申请单号',
  `purchase_price` varchar(255) DEFAULT NULL COMMENT '采购单价',
  `purchase_money` varchar(255) DEFAULT NULL COMMENT '付款金额',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '入库数量',
  `sale_price` varchar(255) DEFAULT NULL COMMENT '进项单价(卖给代理商的单价)',
  `units` varchar(50) NOT NULL DEFAULT '' COMMENT '单位',
  `sale_money` varchar(255) DEFAULT NULL COMMENT '进项金额(卖给代理商的金额)',
  `tax` varchar(255) DEFAULT NULL COMMENT '应付税',
  `taxpay_mode` varchar(255) DEFAULT NULL COMMENT '付税方式',
  `taxpay_date` varchar(255) DEFAULT NULL COMMENT '付税日期',
  `invoice_number` int(11) DEFAULT NULL COMMENT '发票号码',
  `invoice_date` varchar(50) DEFAULT NULL COMMENT '开票日期',
  `descript` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关联表id',
  `medicine_id` int(11) NOT NULL COMMENT '药品id',
  `warehouse_id` int(11) NOT NULL COMMENT '仓库id',
  `start_quantity` varchar(50) DEFAULT NULL COMMENT '开始数量',
  `now_quantity` varchar(50) DEFAULT NULL COMMENT '现有数量',
  `fax_no` varchar(20) DEFAULT NULL,
  `descript` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `code` varchar(11) NOT NULL COMMENT '用户编号（业务员编号）',
  `username` varchar(60) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `role` tinyint(2) NOT NULL DEFAULT '1' COMMENT '角色 1管理员，2业务员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  `descript` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库id',
  `code` varchar(20) DEFAULT NULL COMMENT '仓库code',
  `name` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `link_man` varchar(20) DEFAULT NULL COMMENT '联系人员',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `descript` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `sys_user` VALUES ('1', 'A000001', 'admin', '111111', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00', b'0', '');