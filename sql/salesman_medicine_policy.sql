/*
 Navicat MySQL Data Transfer

 Source Server         : localDB
 Source Server Version : 50542
 Source Host           : localhost
 Source Database       : medical

 Target Server Version : 50542
 File Encoding         : utf-8

 Date: 09/05/2015 07:14:34 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `salesman_medicine_policy`
-- ----------------------------
DROP TABLE IF EXISTS `salesman_medicine_policy`;
CREATE TABLE `salesman_medicine_policy` (
  `id` int(11) NOT NULL,
  `salesman_code` char(50) NOT NULL DEFAULT '' COMMENT '业务员编号',
  `medicine_code` char(50) NOT NULL DEFAULT '' COMMENT '药品编号',
  `client_code` char(50) NOT NULL DEFAULT '' COMMENT '客户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
