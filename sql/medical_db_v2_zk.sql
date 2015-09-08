/*
 Navicat MySQL Data Transfer

 Source Server         : localDB
 Source Server Version : 50542
 Source Host           : localhost
 Source Database       : medical

 Target Server Version : 50542
 File Encoding         : utf-8

 Date: 08/30/2015 07:59:35 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `agent`
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '代理商代码',
  `name` varchar(50) DEFAULT '' COMMENT '代理商名称',
  `level` varchar(3) DEFAULT NULL COMMENT '代理级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '单据编号',
  `date` varchar(50) NOT NULL DEFAULT '' COMMENT '开票日期',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `two_level_code` varchar(20) DEFAULT NULL COMMENT '二级代码',
  `three_level_code` varchar(20) DEFAULT NULL COMMENT '三级代码',
  `user_code` varchar(11) NOT NULL COMMENT '业务员编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(11) NOT NULL COMMENT '客户编码',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `regional` varchar(100) DEFAULT NULL COMMENT '区域代码',
  `business_type` varchar(10) DEFAULT NULL COMMENT '商业类型,1纯销，2商业分销，3第三方终端',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `hospital`
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hospital_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(11) NOT NULL COMMENT '客户码',
  `hospital_name` varchar(100) NOT NULL COMMENT '医院名称',
  `regional_code` varchar(11) DEFAULT NULL COMMENT '区域代码',
  `business_type` varchar(10) DEFAULT NULL COMMENT '商业类型',
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `medicine`
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
  `number` int(50) NOT NULL DEFAULT '0' COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `medicine_policy`
-- ----------------------------
DROP TABLE IF EXISTS `medicine_policy`;
CREATE TABLE `medicine_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `regional` varchar(100) DEFAULT '' COMMENT '所属区域',
  `month` varchar(10) NOT NULL COMMENT '月份',
  `medicine_code` varchar(20) NOT NULL COMMENT '药品编号',
  `client_code` varchar(11) NOT NULL COMMENT '客户代码',
  `salesman_policy` float(10,0) DEFAULT NULL COMMENT '业务员政策',
  `clinical_policy` float(10,0) DEFAULT NULL COMMENT '临床政策',
  `manufacturer_policy` float(10,0) DEFAULT NULL COMMENT '厂家政策',
  `two_level_policy` float(10,0) DEFAULT NULL COMMENT '二级政策',
  `three_level_policy` float(10,0) DEFAULT NULL COMMENT '三级政策',
  `add_policy1` float(10,0) DEFAULT NULL COMMENT '附加政策1',
  `add_policy2` float(10,0) DEFAULT NULL COMMENT '附加政策2',
  `add_policy3` float(10,0) DEFAULT NULL COMMENT '附加政策3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `code` varchar(11) NOT NULL COMMENT '用户编号（业务员编号）',
  `username` varchar(60) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `role` tinyint(2) NOT NULL DEFAULT '1' COMMENT '角色 1管理员，2业务员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'A000001', 'admin', '111111', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
