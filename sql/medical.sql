/*
Navicat MySQL Data Transfer

Source Server         : medical
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-10-06 16:45:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '代理商代码',
  `name` varchar(50) DEFAULT '' COMMENT '代理商名称',
  `level` varchar(3) DEFAULT NULL COMMENT '代理级别',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='代理商表';

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2810 DEFAULT CHARSET=utf8 COMMENT='单据表';

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='客户表';

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
  `price` float(10,0) DEFAULT NULL COMMENT '单价',
  `lot_number` varchar(50) DEFAULT NULL COMMENT '药品批号',
  `validity_period` varchar(50) DEFAULT NULL COMMENT '有效期',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for purchasement
-- ----------------------------
DROP TABLE IF EXISTS `purchasement`;
CREATE TABLE `purchasement` (
  `id` int(11) NOT NULL,
  `purchase_sale_type` varchar(60) DEFAULT NULL COMMENT '采购销售类别',
  `purchase_pay_date` datetime DEFAULT NULL COMMENT '采购付款日期',
  `purchase_store_date` datetime DEFAULT NULL COMMENT '采购入库日期',
  `actual_store_place` varchar(255) DEFAULT NULL COMMENT '实际入库地点',
  `purchase_sale_code` varchar(255) NOT NULL COMMENT '采购申请单号',
  `medicine_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `manufacturer_name` varchar(255) DEFAULT NULL COMMENT '生产厂家',
  `specification` varchar(255) DEFAULT NULL COMMENT '规格',
  `units` varchar(255) DEFAULT NULL COMMENT '单位',
  `package_number` int(11) DEFAULT NULL COMMENT '装箱量',
  `sale_company` varchar(255) DEFAULT NULL COMMENT '我司上家销货单位',
  `buy_company` varchar(255) DEFAULT NULL COMMENT '我司或下家购货单位',
  `payment_category` varchar(255) DEFAULT NULL COMMENT '打款分类',
  `payment_mode` varchar(255) DEFAULT NULL COMMENT '付款方式',
  `purchase_number` int(11) DEFAULT NULL COMMENT '购进数量',
  `purchase_price` decimal(10,0) DEFAULT NULL COMMENT '采购单价',
  `payment_money` varchar(255) DEFAULT NULL COMMENT '付款金额',
  `work_flow` varchar(255) DEFAULT NULL COMMENT '业务流程及价',
  `client_name` varchar(255) DEFAULT NULL COMMENT '为所属客户',
  `sale_area` varchar(255) DEFAULT NULL COMMENT '采购销售区域',
  `purchase_unit_price` decimal(10,0) DEFAULT NULL COMMENT '进项单价',
  `purchase_money` varchar(255) DEFAULT NULL COMMENT '进项金额',
  `tax` varchar(255) DEFAULT NULL COMMENT '应付税',
  `tax_pay_mode` varchar(255) DEFAULT NULL COMMENT '付税方式',
  `tax_pay_date` datetime DEFAULT NULL COMMENT '付税日期',
  `invoice_number` int(11) DEFAULT NULL COMMENT '发票号码',
  `invoice_date` datetime DEFAULT NULL COMMENT '开票日期',
  `if_check` varchar(255) DEFAULT NULL COMMENT '采购条目生成是否已核对',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for purchase_client
-- ----------------------------
DROP TABLE IF EXISTS `purchase_client`;
CREATE TABLE `purchase_client` (
  `id` int(11) NOT NULL COMMENT 'id',
  `sale_company` varchar(255) DEFAULT NULL COMMENT '我司上家销货单位',
  `buy_company` varchar(255) DEFAULT NULL COMMENT '我司或下家购货单位',
  `client_name` varchar(255) DEFAULT NULL COMMENT '为所属客户',
  `sale_area` varchar(255) DEFAULT NULL COMMENT '采购销售区域',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for purchase_moneytax
-- ----------------------------
DROP TABLE IF EXISTS `purchase_moneytax`;
CREATE TABLE `purchase_moneytax` (
  `id` int(11) NOT NULL COMMENT 'id',
  `payment_category` varchar(255) DEFAULT NULL COMMENT '打款分类',
  `payment_mode` varchar(255) DEFAULT NULL COMMENT '付款方式',
  `payment_money` varchar(255) DEFAULT NULL COMMENT '付款金额',
  `work_flow` varchar(255) DEFAULT NULL COMMENT '业务流程及价',
  `purchase_unit_price` decimal(10,0) DEFAULT NULL COMMENT '进项单价',
  `purchase_money` varchar(255) DEFAULT NULL COMMENT '进项金额',
  `tax` varchar(255) DEFAULT NULL COMMENT '应付税',
  `tax_pay_mode` varchar(255) DEFAULT NULL COMMENT '付税方式',
  `tax_pay_date` datetime DEFAULT NULL COMMENT '付税日期',
  `invoice_number` int(11) DEFAULT NULL COMMENT '发票号码',
  `invoice_date` datetime DEFAULT NULL COMMENT '开票日期',
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
