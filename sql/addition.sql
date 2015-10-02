-- 统一为每个表添加 create_date、update_date、del_flag字段

ALTER TABLE `agent`
	ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间',
	ADD COLUMN `update_date` DATETIME NULL COMMENT '更新时间' AFTER `create_date`,
	ADD COLUMN `del_flag` BIT NULL DEFAULT b'0' AFTER `update_date`;
update agent t set t.create_date = "1970-01-01 00:00:00", t.update_date = "1970-01-01 00:00:00" where 1=1;
ALTER TABLE `agent`
	ALTER `create_date` DROP DEFAULT,
	ALTER `update_date` DROP DEFAULT;
ALTER TABLE `agent`
	CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL COMMENT '创建时间',
	CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL COMMENT '更新时间' AFTER `create_date`;


ALTER TABLE `bill`
	ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间',
	ADD COLUMN `update_date` DATETIME NULL COMMENT '更新时间' AFTER `create_date`,
	ADD COLUMN `del_flag` BIT NULL DEFAULT b'0' AFTER `update_date`;
update bill t set t.create_date = "1970-01-01 00:00:00", t.update_date = "1970-01-01 00:00:00" where 1=1;
ALTER TABLE `bill`
	ALTER `create_date` DROP DEFAULT,
	ALTER `update_date` DROP DEFAULT;
ALTER TABLE `bill`
	CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL COMMENT '创建时间',
	CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL COMMENT '更新时间' AFTER `create_date`;


ALTER TABLE `client`
	ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间',
	ADD COLUMN `update_date` DATETIME NULL COMMENT '更新时间' AFTER `create_date`,
	ADD COLUMN `del_flag` BIT NULL DEFAULT b'0' AFTER `update_date`;
update client t set t.create_date = "1970-01-01 00:00:00", t.update_date = "1970-01-01 00:00:00" where 1=1;
ALTER TABLE `client`
	ALTER `create_date` DROP DEFAULT,
	ALTER `update_date` DROP DEFAULT;
ALTER TABLE `client`
	CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL COMMENT '创建时间',
	CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL COMMENT '更新时间' AFTER `create_date`;


ALTER TABLE `medicine`
	ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间',
	ADD COLUMN `update_date` DATETIME NULL COMMENT '更新时间' AFTER `create_date`,
	ADD COLUMN `del_flag` BIT NULL DEFAULT b'0' AFTER `update_date`;
update medicine t set t.create_date = "1970-01-01 00:00:00", t.update_date = "1970-01-01 00:00:00" where 1=1;
ALTER TABLE `medicine`
	ALTER `create_date` DROP DEFAULT,
	ALTER `update_date` DROP DEFAULT;
ALTER TABLE `medicine`
	CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL COMMENT '创建时间',
	CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL COMMENT '更新时间' AFTER `create_date`;


ALTER TABLE `medicine_policy`
	ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间',
	ADD COLUMN `update_date` DATETIME NULL COMMENT '更新时间' AFTER `create_date`,
	ADD COLUMN `del_flag` BIT NULL DEFAULT b'0' AFTER `update_date`;
update medicine_policy t set t.create_date = "1970-01-01 00:00:00", t.update_date = "1970-01-01 00:00:00" where 1=1;
ALTER TABLE `medicine_policy`
	ALTER `create_date` DROP DEFAULT,
	ALTER `update_date` DROP DEFAULT;
ALTER TABLE `medicine_policy`
	CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL COMMENT '创建时间',
	CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL COMMENT '更新时间' AFTER `create_date`;


ALTER TABLE `sys_user`
	ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间',
	ADD COLUMN `update_date` DATETIME NULL COMMENT '更新时间' AFTER `create_date`,
	ADD COLUMN `del_flag` BIT NULL DEFAULT b'0' AFTER `update_date`;
update sys_user t set t.create_date = "1970-01-01 00:00:00", t.update_date = "1970-01-01 00:00:00" where 1=1;
ALTER TABLE `sys_user`
	ALTER `create_date` DROP DEFAULT,
	ALTER `update_date` DROP DEFAULT;
ALTER TABLE `sys_user`
	CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL COMMENT '创建时间',
	CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL COMMENT '更新时间' AFTER `create_date`;
