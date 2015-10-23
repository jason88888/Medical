/*
 Navicat MySQL Data Transfer

 Source Server         : localDB
 Source Server Version : 50542
 Source Host           : localhost
 Source Database       : medical

 Target Server Version : 50542
 File Encoding         : utf-8

 Date: 10/23/2015 12:24:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `medicine`
-- ----------------------------
BEGIN;
INSERT INTO `medicine` VALUES ('1', '310505', '阿司匹林肠溶胶囊', '0.1*30', '永信药品工业（昆山）有限公司', '盒', '6.000', 'w010', '2014-02-21', '2015-10-20 00:00:00', '2015-10-20 00:00:00', b'0', '360', '5400', 'ASPL', '', '-1.00', null, ''), ('2', '310505', '阿司匹林肠溶胶囊', '0.1*30', '永信药品工业（昆山）有限公司', '盒', '6.000', 'w012', '2014-02-28', '2015-10-20 00:00:00', '2015-10-20 00:00:00', b'0', '360', '5400', 'ASPL', '', '-1.00', null, ''), ('3', '310505', '阿司匹林肠溶胶囊', '0.1*30', '永信药品工业（昆山）有限公司', '盒', '6.000', 'w013', '2014-03-01', '2015-10-20 00:00:00', '2015-10-20 00:00:00', b'0', '360', '3600', 'ASPL', '', '-1.00', null, ''), ('4', '111', '111', '1111', '11', '盒', null, '11111', '2015-10-21', '2015-10-21 00:00:00', '2015-10-21 00:00:00', b'1', '111', '0', '111', '的地方的', '11个月', '11.000', '浙江');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
