/*
 Navicat MySQL Data Transfer

 Source Server         : localDB
 Source Server Version : 50542
 Source Host           : localhost
 Source Database       : medical

 Target Server Version : 50542
 File Encoding         : utf-8

 Date: 09/05/2015 07:13:23 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `agent_medicine_policy`
-- ----------------------------
DROP TABLE IF EXISTS `agent_medicine_policy`;
CREATE TABLE `agent_medicine_policy` (
  `id` int(11) NOT NULL,
  `agent_code` varchar(50) NOT NULL DEFAULT '' COMMENT '代理商编号',
  `client_code` varchar(50) NOT NULL DEFAULT '' COMMENT '客户编号',
  `medicine_code` varchar(50) NOT NULL DEFAULT '' COMMENT '药品编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
