-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.86-community-nt - MySQL Community Edition (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 medical 的数据库结构
DROP DATABASE IF EXISTS `medical`;
CREATE DATABASE IF NOT EXISTS `medical` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `medical`;


-- 导出  表 medical.agent 结构
DROP TABLE IF EXISTS `agent`;
CREATE TABLE IF NOT EXISTS `agent` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(20) NOT NULL COMMENT '代理商代码',
  `name` varchar(50) default '' COMMENT '代理商名称',
  `level` varchar(3) default NULL COMMENT '代理级别',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) default b'0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商表';

-- 数据导出被取消选择。


-- 导出  表 medical.bill 结构
DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(20) NOT NULL COMMENT '单据编号',
  `date` varchar(50) NOT NULL default '' COMMENT '开票日期',
  `month` varchar(50) NOT NULL default '' COMMENT '单据月份',
  `number` int(11) default NULL COMMENT '数量',
  `client_code` varchar(11) NOT NULL COMMENT '客户编码',
  `client_name` varchar(100) default '' COMMENT '客户名称',
  `two_level_code` varchar(20) default NULL COMMENT '二级代码',
  `two_level_name` varchar(100) default '' COMMENT '二级姓名',
  `three_level_code` varchar(20) default '' COMMENT '三级代码',
  `three_level_name` varchar(100) default '' COMMENT '三级姓名',
  `user_code` varchar(11) NOT NULL COMMENT '业务员编码',
  `user_name` varchar(60) NOT NULL COMMENT '用户名',
  `medicine_code` varchar(20) NOT NULL COMMENT '药品编码',
  `medicine_name` varchar(100) NOT NULL COMMENT '药品名称',
  `regional` varchar(100) default '' COMMENT '区域',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) default b'0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据表';

-- 数据导出被取消选择。


-- 导出  表 medical.client 结构
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(11) NOT NULL COMMENT '客户编码',
  `name` varchar(100) NOT NULL default '' COMMENT '名称',
  `regional` varchar(100) default '' COMMENT '区域代码',
  `business_type` varchar(10) default '' COMMENT '商业类型,1纯销，2商业分销，3第三方终端',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) default b'0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- 数据导出被取消选择。


-- 导出  表 medical.medicine 结构
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE IF NOT EXISTS `medicine` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(20) NOT NULL COMMENT '药品编码',
  `name` varchar(100) NOT NULL COMMENT '药品名称',
  `specification` varchar(100) default NULL COMMENT '药品规格',
  `manufacturer_name` varchar(100) default NULL COMMENT '生产厂商名称',
  `units` varchar(10) default NULL COMMENT '单位',
  `price` float(10,0) default NULL COMMENT '单价',
  `lot_number` varchar(50) default NULL COMMENT '药品批号',
  `validity_period` varchar(50) default NULL COMMENT '有效期',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) default b'0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 medical.medicine_policy 结构
DROP TABLE IF EXISTS `medicine_policy`;
CREATE TABLE IF NOT EXISTS `medicine_policy` (
  `id` int(11) NOT NULL auto_increment,
  `regional` varchar(100) default '' COMMENT '所属区域',
  `month` varchar(10) NOT NULL COMMENT '月份',
  `medicine_code` varchar(20) NOT NULL COMMENT '药品编号',
  `client_code` varchar(11) NOT NULL COMMENT '客户代码',
  `salesman_policy` float(10,3) default NULL COMMENT '业务员政策',
  `clinical_policy` float(10,3) default NULL COMMENT '临床政策',
  `manufacturer_policy` float(10,3) default NULL COMMENT '厂家政策',
  `two_level_policy` float(10,3) default NULL COMMENT '二级政策',
  `three_level_policy` float(10,3) default NULL COMMENT '三级政策',
  `add_policy1` float(10,3) default NULL COMMENT '附加政策1',
  `add_policy2` float(10,3) default NULL COMMENT '附加政策2',
  `add_policy3` float(10,3) default NULL COMMENT '附加政策3',
  `price` float(10,3) default NULL COMMENT '单价',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) default b'0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 medical.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) NOT NULL auto_increment COMMENT '用户ID',
  `code` varchar(11) NOT NULL COMMENT '用户编号（业务员编号）',
  `username` varchar(60) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `role` tinyint(2) NOT NULL default '1' COMMENT '角色 1管理员，2业务员',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` bit(1) default b'0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
