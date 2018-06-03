/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hlhyl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-02 14:46:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hl_hyl_price`
-- ----------------------------
DROP TABLE IF EXISTS `hl_hyl_price`;
CREATE TABLE `hl_hyl_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '货币每日价格表',
  `price` double NOT NULL,
  `price_date` datetime NOT NULL,
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hl_hyl_price
-- ----------------------------

-- ----------------------------
-- Table structure for `hl_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `hl_purchase`;
CREATE TABLE `hl_purchase` (
  `id` int(11) NOT NULL COMMENT '货币购买明细表',
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `amount` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '购买状态： 1. 申请   2. 已购买',
  `apply_date` datetime NOT NULL,
  `purchase_date` datetime DEFAULT NULL COMMENT ' 审核日期',
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='购买货币申请';

-- ----------------------------
-- Records of hl_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for `hl_reward`
-- ----------------------------
DROP TABLE IF EXISTS `hl_reward`;
CREATE TABLE `hl_reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员奖金明细表',
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `amount` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `award_date` date DEFAULT NULL,
  `award_type` double DEFAULT NULL COMMENT '0. 锁仓奖励\n1. 直推奖励',
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hl_reward
-- ----------------------------

-- ----------------------------
-- Table structure for `hl_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `hl_transaction`;
CREATE TABLE `hl_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员交易明细表',
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `rec_user_id` int(11) NOT NULL,
  `rec_user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `type` int(11) NOT NULL COMMENT '交易类型： 1. 对私交易， 2. 对公交易',
  `amount` double NOT NULL DEFAULT '0' COMMENT '交易数量',
  `real_amount` double NOT NULL COMMENT '对公账户收取手续费',
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hl_transaction
-- ----------------------------

-- ----------------------------
-- Table structure for `hl_user`
-- ----------------------------
DROP TABLE IF EXISTS `hl_user`;
CREATE TABLE `hl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员信息表',
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `id_card` varchar(45) COLLATE utf8_bin NOT NULL,
  `tel` varchar(45) COLLATE utf8_bin NOT NULL,
  `bank_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `bank_no` varchar(45) COLLATE utf8_bin NOT NULL,
  `amount` double DEFAULT '0' COMMENT '流通货币数量',
  `lock_amount` double DEFAULT NULL COMMENT '锁仓数量',
  `rec_user` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '推荐人账号',
  `rec_name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '推荐人姓名',
  `register_date` date NOT NULL,
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tel_UNIQUE` (`tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hl_user
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', null, 'com.suke.czx.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400B57B226A6F624964223A312C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A227465737431222C22706172616D73223A2274657374222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A302C2272656D61726B223A22E69C89E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320312C20323031362031313A31363A343620504D227D7800);

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'USER-20160331BS1527921770155', '1527921955858', '15000');

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1527858000000', '-1', '5', 'PAUSED', 'CRON', '1527856608000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400B57B226A6F624964223A312C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A227465737431222C22706172616D73223A2274657374222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A312C2272656D61726B223A22E69C89E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320312C20323031362031313A31363A343620504D227D7800);

-- ----------------------------
-- Table structure for `schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'testTask', 'test1', 'test', '0 0/30 * * * ?', '1', '有参数测试', '2016-12-01 23:16:46');

-- ----------------------------
-- Table structure for `schedule_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('1', '1', 'testTask', 'test1', 'test', '1', 'java.lang.NoSuchMethodException: com.suke.czx.modules.job.task.TestTask.test1(java.lang.String)', '3', '2018-06-01 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('2', '1', 'testTask', 'test1', 'test', '1', 'java.lang.NoSuchMethodException: com.suke.czx.modules.job.task.TestTask.test1(java.lang.String)', '1', '2018-06-01 21:30:00');
INSERT INTO `schedule_job_log` VALUES ('3', '1', 'testTask', 'test1', 'test', '1', 'java.lang.NoSuchMethodException: com.suke.czx.modules.job.task.TestTask.test1(java.lang.String)', '1', '2018-06-01 22:30:00');
INSERT INTO `schedule_job_log` VALUES ('4', '1', 'testTask', 'test1', 'test', '1', 'java.lang.NoSuchMethodException: com.suke.czx.modules.job.task.TestTask.test1(java.lang.String)', '1', '2018-06-01 23:00:00');
INSERT INTO `schedule_job_log` VALUES ('5', '1', 'testTask', 'test1', 'test', '1', 'java.lang.NoSuchMethodException: com.suke.czx.modules.job.task.TestTask.test1(java.lang.String)', '1', '2018-06-02 11:00:00');
INSERT INTO `schedule_job_log` VALUES ('6', '1', 'testTask', 'test1', 'test', '1', 'java.lang.NoSuchMethodException: com.suke.czx.modules.job.task.TestTask.test1(java.lang.String)', '2', '2018-06-02 11:30:00');

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"个人中心\",\"type\":0,\"icon\":\"fa fa-user\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 21:30:22');
INSERT INTO `sys_log` VALUES ('2', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"资产明细\",\"url\":\"modules/hluser/index.html\",\"perms\":\"hluser:index\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-06-01 21:49:54');
INSERT INTO `sys_log` VALUES ('3', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":32,\"parentId\":31,\"parentName\":\"个人中心\",\"name\":\"资产明细\",\"url\":\"modules/hluser/index.html\",\"perms\":\"hluser:index\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}', '7', '0:0:0:0:0:0:0:1', '2018-06-01 21:50:37');
INSERT INTO `sys_log` VALUES ('4', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"主页\",\"type\":0,\"icon\":\"fa fa-user\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:03:17');
INSERT INTO `sys_log` VALUES ('5', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":32,\"parentId\":31,\"parentName\":\"主页\",\"name\":\"个人主心\",\"url\":\"modules/hluser/index.html\",\"perms\":\"hluser:index\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:03:32');
INSERT INTO `sys_log` VALUES ('6', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"主页\",\"type\":0,\"icon\":\"fa fa-home\",\"orderNum\":1}', '4', '0:0:0:0:0:0:0:1', '2018-06-01 22:05:12');
INSERT INTO `sys_log` VALUES ('7', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":32,\"parentId\":31,\"parentName\":\"主页\",\"name\":\"个人主心\",\"url\":\"modules/hluser/index.html\",\"perms\":\"hluser:index\",\"type\":1,\"icon\":\"fa fa-th-user\",\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:05:29');
INSERT INTO `sys_log` VALUES ('8', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":32,\"parentId\":31,\"parentName\":\"主页\",\"name\":\"个人中心\",\"url\":\"modules/hluser/index.html\",\"perms\":\"hluser:index\",\"type\":1,\"icon\":\"fa fa-user\",\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:05:53');
INSERT INTO `sys_log` VALUES ('9', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"主页\",\"name\":\"汉语币购买\",\"url\":\"modules/hluser/purchase.html\",\"perms\":\"hluser:purchase\",\"type\":1,\"orderNum\":1}', '7', '0:0:0:0:0:0:0:1', '2018-06-01 22:24:26');
INSERT INTO `sys_log` VALUES ('10', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"主页\",\"name\":\"货币交易\",\"url\":\"modules/hluser/transaction.html\",\"perms\":\"hluser:transaction\",\"type\":1,\"icon\":\"fa fa-user-secret\",\"orderNum\":2}', '6', '0:0:0:0:0:0:0:1', '2018-06-01 22:31:32');
INSERT INTO `sys_log` VALUES ('11', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"主页\",\"name\":\"信息修改\",\"url\":\"modules/hluser/update.html\",\"perms\":\"hluser:update\",\"type\":1,\"icon\":\"fa fa-bug\",\"orderNum\":4}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:38:32');
INSERT INTO `sys_log` VALUES ('12', 'admin', '保存角色', 'com.suke.czx.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"普通用户\",\"remark\":\"供普通会员使用\",\"createUserId\":1,\"menuIdList\":[31,32,33,34,35],\"createTime\":\"Jun 1, 2018 10:39:15 PM\"}', '87', '0:0:0:0:0:0:0:1', '2018-06-01 22:39:16');
INSERT INTO `sys_log` VALUES ('13', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"后台管理\",\"type\":0,\"icon\":\"fa fa-cog\",\"orderNum\":0}', '2', '0:0:0:0:0:0:0:1', '2018-06-01 22:40:29');
INSERT INTO `sys_log` VALUES ('14', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"货币价格\",\"url\":\"modules/hladmin/price\",\"perms\":\"hladmin:price\",\"type\":1,\"icon\":\"fa fa-user-secret\",\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-06-01 22:42:20');
INSERT INTO `sys_log` VALUES ('15', 'admin', '修改密码', 'com.suke.czx.modules.sys.controller.SysUserController.password()', '\"admin\"', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:45:19');
INSERT INTO `sys_log` VALUES ('16', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买审批\",\"url\":\"modules/hladmin/audit\",\"perms\":\"hladmin:audit\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}', '6', '0:0:0:0:0:0:0:1', '2018-06-01 22:48:55');
INSERT INTO `sys_log` VALUES ('17', 'admin', '删除定时任务', 'com.suke.czx.modules.job.controller.ScheduleJobController.delete()', '[2]', '24', '0:0:0:0:0:0:0:1', '2018-06-01 22:50:22');
INSERT INTO `sys_log` VALUES ('18', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":37,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"货币价格\",\"url\":\"modules/hladmin/price.html\",\"perms\":\"hladmin:price\",\"type\":1,\"icon\":\"fa fa-user-secret\",\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:52:29');
INSERT INTO `sys_log` VALUES ('19', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":38,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买审批\",\"url\":\"modules/hladmin/audit.html\",\"perms\":\"hladmin:audit\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:52:40');
INSERT INTO `sys_log` VALUES ('20', 'admin', '保存菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买记录\",\"url\":\"modules/hladmin/purchase/detail.html\",\"perms\":\"hladmin:purchase:detail\",\"type\":1,\"orderNum\":3}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:57:58');
INSERT INTO `sys_log` VALUES ('21', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":38,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买审批\",\"url\":\"modules/hladmin/audit.html\",\"perms\":\"hladmin:audit\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}', '4', '0:0:0:0:0:0:0:1', '2018-06-01 22:58:10');
INSERT INTO `sys_log` VALUES ('22', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买记录\",\"url\":\"modules/hladmin/purchase/detail.html\",\"perms\":\"hladmin:purchase:detail\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":3}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:58:16');
INSERT INTO `sys_log` VALUES ('23', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买记录\",\"url\":\"modules/hladmin/purchase/detail.html\",\"perms\":\"hladmin:purchase:detail\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":2}', '4', '0:0:0:0:0:0:0:1', '2018-06-01 22:58:23');
INSERT INTO `sys_log` VALUES ('24', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买记录\",\"url\":\"modules/hladmin/purchase/detail.html\",\"perms\":\"hladmin:purchase:detail\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":2}', '6', '0:0:0:0:0:0:0:1', '2018-06-01 22:58:24');
INSERT INTO `sys_log` VALUES ('25', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买记录\",\"url\":\"modules/hladmin/purchase/detail.html\",\"perms\":\"hladmin:purchase:detail\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":2}', '5', '0:0:0:0:0:0:0:1', '2018-06-01 22:58:25');
INSERT INTO `sys_log` VALUES ('26', 'admin', '修改菜单', 'com.suke.czx.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"后台管理\",\"name\":\"购买记录\",\"url\":\"modules/hladmin/purchase/detail.html\",\"perms\":\"hladmin:purchase:detail\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":2}', '4', '0:0:0:0:0:0:0:1', '2018-06-01 22:58:26');
INSERT INTO `sys_log` VALUES ('27', 'admin', '保存角色', 'com.suke.czx.modules.sys.controller.SysRoleController.save()', '{\"roleId\":2,\"roleName\":\"管理员\",\"remark\":\"供公司内部人员使用\",\"createUserId\":1,\"menuIdList\":[36,37,38,39],\"createTime\":\"Jun 1, 2018 10:59:36 PM\"}', '19', '0:0:0:0:0:0:0:1', '2018-06-01 22:59:36');
INSERT INTO `sys_log` VALUES ('28', 'admin', '保存用户', 'com.suke.czx.modules.sys.controller.SysUserController.save()', '{\"userId\":2,\"username\":\"admin1\",\"password\":\"aa2718d4132a5bf96586aefb7aaf0b94b18867e78aaa9ea57dc0fc772f1867cd\",\"salt\":\"nhmjRCT0rT1ctQep8O23\",\"email\":\"859844773@qq.com\",\"mobile\":\"15888888888\",\"status\":1,\"roleIdList\":[2],\"createUserId\":1,\"createTime\":\"Jun 1, 2018 11:06:59 PM\"}', '65', '0:0:0:0:0:0:0:1', '2018-06-01 23:06:59');
INSERT INTO `sys_log` VALUES ('29', 'admin', '修改用户', 'com.suke.czx.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"admin1\",\"name\":\"lzg\",\"password\":\"aa2718d4132a5bf96586aefb7aaf0b94b18867e78aaa9ea57dc0fc772f1867cd\",\"salt\":\"nhmjRCT0rT1ctQep8O23\",\"email\":\"859844773@qq.com\",\"mobile\":\"15888888888\",\"status\":1,\"roleIdList\":[2],\"createUserId\":1,\"createTime\":\"Jun 1, 2018 11:06:59 PM\"}', '5702', '0:0:0:0:0:0:0:1', '2018-06-02 11:53:21');
INSERT INTO `sys_log` VALUES ('30', 'admin', '暂停定时任务', 'com.suke.czx.modules.job.controller.ScheduleJobController.pause()', '[1]', '12', '0:0:0:0:0:0:0:1', '2018-06-02 11:53:43');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('31', '0', '主页', null, null, '0', 'fa fa-home', '1');
INSERT INTO `sys_menu` VALUES ('32', '31', '个人中心', 'modules/hluser/index.html', 'hluser:index', '1', 'fa fa-user', '0');
INSERT INTO `sys_menu` VALUES ('33', '31', '汉语币购买', 'modules/hluser/purchase.html', 'hluser:purchase', '1', null, '1');
INSERT INTO `sys_menu` VALUES ('34', '31', '货币交易', 'modules/hluser/transaction.html', 'hluser:transaction', '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('35', '31', '信息修改', 'modules/hluser/update.html', 'hluser:update', '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('36', '0', '后台管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('37', '36', '货币价格', 'modules/hladmin/price.html', 'hladmin:price', '1', 'fa fa-user-secret', '0');
INSERT INTO `sys_menu` VALUES ('38', '36', '购买审批', 'modules/hladmin/audit.html', 'hladmin:audit', '1', 'fa fa-th-list', '1');
INSERT INTO `sys_menu` VALUES ('39', '36', '购买记录', 'modules/hladmin/purchase/detail.html', 'hladmin:purchase:detail', '1', 'fa fa-th-list', '2');

-- ----------------------------
-- Table structure for `sys_oss`
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '普通用户', '供普通会员使用', '1', '2018-06-01 22:39:16');
INSERT INTO `sys_role` VALUES ('2', '管理员', '供公司内部人员使用', '1', '2018-06-01 22:59:36');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '31');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '32');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '33');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '34');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '35');
INSERT INTO `sys_role_menu` VALUES ('6', '2', '36');
INSERT INTO `sys_role_menu` VALUES ('7', '2', '37');
INSERT INTO `sys_role_menu` VALUES ('8', '2', '38');
INSERT INTO `sys_role_menu` VALUES ('9', '2', '39');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户登陆名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'c7e4297a09401ebdb2560aa301b2dd9d455269f57ba4203d87a2ca24a5bee90b', 'admin', 'YzcmCZNvbXocrsz9dm8e', 'yzcheng90@qq.com', '15524641188', '1', '1', '2018-01-18 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'admin1', 'aa2718d4132a5bf96586aefb7aaf0b94b18867e78aaa9ea57dc0fc772f1867cd', 'lzg', 'nhmjRCT0rT1ctQep8O23', '859844773@qq.com', '15888888888', '1', '1', '2018-06-01 23:06:59');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '2', '2');

-- ----------------------------
-- Table structure for `sys_user_token`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', '65cf6e4114284b9e5cc068f068167ae5', '2018-06-02 23:48:18', '2018-06-02 11:48:18');
INSERT INTO `sys_user_token` VALUES ('2', '7cca05d11a76715fdf91fb83bed80676', '2018-06-02 11:07:37', '2018-06-01 23:07:37');

-- ----------------------------
-- Table structure for `tb_app_update`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_update`;
CREATE TABLE `tb_app_update` (
  `appid` varchar(50) DEFAULT NULL COMMENT 'APPID ',
  `update_content` varchar(500) DEFAULT NULL COMMENT '更新内容',
  `version_code` int(20) DEFAULT NULL COMMENT '版本码',
  `version_name` varchar(50) DEFAULT NULL COMMENT '版本号',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL地址',
  `app_file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `md5` varchar(255) DEFAULT NULL COMMENT 'MD5值',
  `size` varchar(50) DEFAULT NULL COMMENT '文件大小',
  `is_force` varchar(50) DEFAULT NULL COMMENT '是否强制安装',
  `is_ignorable` varchar(50) DEFAULT NULL COMMENT '是否可忽略该版本',
  `is_silent` varchar(50) DEFAULT NULL COMMENT '是否静默下载：有新版本时不提示直接下载',
  `upload_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP版本管理';

-- ----------------------------
-- Records of tb_app_update
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');
