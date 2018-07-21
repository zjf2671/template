/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2018-04-15 09:03:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
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
-- Table structure for qrtz_calendars
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
-- Table structure for qrtz_cron_triggers
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
INSERT INTO `qrtz_cron_triggers` VALUES ('TemplateScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('TemplateScheduler', 'TASK_2', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
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
-- Table structure for qrtz_job_details
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
INSERT INTO `qrtz_job_details` VALUES ('TemplateScheduler', 'TASK_1', 'DEFAULT', null, 'com.ddc.template.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720035636F6D2E6464632E74656D706C6174652E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000874656D706C61746574000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_job_details` VALUES ('TemplateScheduler', 'TASK_2', 'DEFAULT', null, 'com.ddc.template.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720035636F6D2E6464632E74656D706C6174652E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for qrtz_locks
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
INSERT INTO `qrtz_locks` VALUES ('TemplateScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('TemplateScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
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
-- Table structure for qrtz_scheduler_state
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
INSERT INTO `qrtz_scheduler_state` VALUES ('TemplateScheduler', 'DESKTOP-0O1SSKN1523162684242', '1523162903660', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
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
-- Table structure for qrtz_simprop_triggers
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
-- Table structure for qrtz_triggers
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
INSERT INTO `qrtz_triggers` VALUES ('TemplateScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1523163600000', '-1', '5', 'WAITING', 'CRON', '1521972670000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720035636F6D2E6464632E74656D706C6174652E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000874656D706C61746574000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_triggers` VALUES ('TemplateScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', null, '1521973800000', '-1', '5', 'PAUSED', 'CRON', '1521972670000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720035636F6D2E6464632E74656D706C6174652E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for schedule_job
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
INSERT INTO `schedule_job` VALUES ('1', 'testTask', 'test', 'template', '0 0/30 * * * ?', '0', '有参数测试', '2016-12-01 23:16:46');
INSERT INTO `schedule_job` VALUES ('2', 'testTask', 'test2', null, '0 0/30 * * * ?', '1', '无参数测试', '2016-12-03 14:55:56');

-- ----------------------------
-- Table structure for schedule_job_log
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('1', '1', 'testTask', 'test', 'template', '0', null, '1025', '2018-03-25 18:13:09');
INSERT INTO `schedule_job_log` VALUES ('2', '1', 'testTask', 'test', 'template', '0', null, '1024', '2018-03-25 18:30:00');
INSERT INTO `schedule_job_log` VALUES ('3', '1', 'testTask', 'test', 'template', '0', null, '1028', '2018-03-25 19:00:00');
INSERT INTO `schedule_job_log` VALUES ('4', '1', 'testTask', 'test', 'template', '0', null, '1036', '2018-03-25 20:54:00');
INSERT INTO `schedule_job_log` VALUES ('5', '1', 'testTask', 'test', 'template', '0', null, '1027', '2018-03-25 20:56:00');
INSERT INTO `schedule_job_log` VALUES ('6', '1', 'testTask', 'test', 'template', '0', null, '1032', '2018-03-25 20:58:00');
INSERT INTO `schedule_job_log` VALUES ('7', '1', 'testTask', 'test', 'template', '0', null, '1020', '2018-03-25 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('8', '1', 'testTask', 'test', 'template', '0', null, '1024', '2018-03-25 21:02:00');
INSERT INTO `schedule_job_log` VALUES ('9', '1', 'testTask', 'test', 'template', '0', null, '1018', '2018-03-25 21:30:00');
INSERT INTO `schedule_job_log` VALUES ('10', '1', 'testTask', 'test', 'template', '0', null, '1028', '2018-03-25 22:00:00');
INSERT INTO `schedule_job_log` VALUES ('11', '1', 'testTask', 'test', 'template', '0', null, '1036', '2018-03-25 22:30:00');
INSERT INTO `schedule_job_log` VALUES ('12', '1', 'testTask', 'test', 'template', '0', null, '5115', '2018-03-26 10:30:09');
INSERT INTO `schedule_job_log` VALUES ('13', '1', 'testTask', 'test', 'template', '0', null, '1104', '2018-03-26 11:30:00');
INSERT INTO `schedule_job_log` VALUES ('14', '1', 'testTask', 'test', 'template', '0', null, '1040', '2018-03-26 12:00:00');
INSERT INTO `schedule_job_log` VALUES ('15', '1', 'testTask', 'test', 'template', '0', null, '1028', '2018-03-26 12:30:00');
INSERT INTO `schedule_job_log` VALUES ('16', '1', 'testTask', 'test', 'template', '0', null, '1074', '2018-03-26 13:00:00');
INSERT INTO `schedule_job_log` VALUES ('17', '1', 'testTask', 'test', 'template', '0', null, '1026', '2018-03-26 13:30:00');
INSERT INTO `schedule_job_log` VALUES ('18', '1', 'testTask', 'test', 'template', '0', null, '1037', '2018-03-26 14:00:00');
INSERT INTO `schedule_job_log` VALUES ('19', '1', 'testTask', 'test', 'template', '0', null, '1166', '2018-03-26 14:30:00');
INSERT INTO `schedule_job_log` VALUES ('20', '1', 'testTask', 'test', 'template', '0', null, '1032', '2018-03-26 15:00:00');
INSERT INTO `schedule_job_log` VALUES ('21', '1', 'testTask', 'test', 'template', '0', null, '1052', '2018-03-26 16:00:00');
INSERT INTO `schedule_job_log` VALUES ('22', '1', 'testTask', 'test', 'template', '0', null, '1016', '2018-03-26 16:30:00');
INSERT INTO `schedule_job_log` VALUES ('23', '1', 'testTask', 'test', 'template', '0', null, '1038', '2018-03-26 17:00:00');
INSERT INTO `schedule_job_log` VALUES ('24', '1', 'testTask', 'test', 'template', '0', null, '1027', '2018-03-26 17:30:00');
INSERT INTO `schedule_job_log` VALUES ('25', '1', 'testTask', 'test', 'template', '0', null, '1037', '2018-03-26 18:30:00');
INSERT INTO `schedule_job_log` VALUES ('26', '1', 'testTask', 'test', 'template', '0', null, '1118', '2018-03-27 10:00:00');
INSERT INTO `schedule_job_log` VALUES ('27', '1', 'testTask', 'test', 'template', '0', null, '1030', '2018-03-27 10:30:00');
INSERT INTO `schedule_job_log` VALUES ('28', '1', 'testTask', 'test', 'template', '0', null, '1053', '2018-03-31 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('29', '1', 'testTask', 'test', 'template', '0', null, '1093', '2018-03-31 21:30:00');
INSERT INTO `schedule_job_log` VALUES ('30', '1', 'testTask', 'test', 'template', '0', null, '1085', '2018-03-31 22:00:00');
INSERT INTO `schedule_job_log` VALUES ('31', '1', 'testTask', 'test', 'template', '0', null, '1044', '2018-03-31 23:00:00');
INSERT INTO `schedule_job_log` VALUES ('32', '1', 'testTask', 'test', 'template', '0', null, '1071', '2018-04-01 12:30:00');
INSERT INTO `schedule_job_log` VALUES ('33', '1', 'testTask', 'test', 'template', '0', null, '110266', '2018-04-02 13:30:00');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha` (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统验证码';

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('0a25446c-c1b7-44bd-8d7d-0af19b17ca6c', 'b6ewa', '2018-03-30 11:04:58');
INSERT INTO `sys_captcha` VALUES ('0bce44d9-ff87-4759-80ff-6212824e48e2', '482eg', '2018-03-28 11:34:57');
INSERT INTO `sys_captcha` VALUES ('0c620467-5b16-4a13-85fa-9336d03dffaf', 'p2g32', '2018-03-26 17:29:22');
INSERT INTO `sys_captcha` VALUES ('141459ad-8657-44db-83bf-38e723953727', 'pan8d', '2018-03-27 14:39:35');
INSERT INTO `sys_captcha` VALUES ('1762abce-66e3-4ef8-896c-bf40282e6e0f', 'bb5dx', '2018-03-26 17:40:34');
INSERT INTO `sys_captcha` VALUES ('2b411e6f-3c25-4968-8178-2cf166f76d99', 'fbyfy', '2018-03-26 12:46:53');
INSERT INTO `sys_captcha` VALUES ('3254bbbf-6252-4a2a-8bff-ac8aa3ba6df0', 'gynnp', '2018-03-27 14:36:44');
INSERT INTO `sys_captcha` VALUES ('34a0d192-d474-462d-841a-4b45db33d942', '3xnxn', '2018-03-27 14:01:54');
INSERT INTO `sys_captcha` VALUES ('3790b961-ef0f-41b7-9666-a11021096b75', '8a8nm', '2018-04-01 12:32:46');
INSERT INTO `sys_captcha` VALUES ('42', '4bc45', '2018-04-01 11:35:50');
INSERT INTO `sys_captcha` VALUES ('43963322-1a75-41d9-86c6-eaf44b332dad', 'fxgp7', '2018-03-26 17:19:17');
INSERT INTO `sys_captcha` VALUES ('45a95bf5-6c32-4d17-90df-b716ac8495e5', 'g4c33', '2018-03-25 21:17:46');
INSERT INTO `sys_captcha` VALUES ('4d179dbb-170e-400b-9471-710846949793', 'f5gw8', '2018-03-30 15:53:40');
INSERT INTO `sys_captcha` VALUES ('51f03c19-a74c-4c0f-8875-e3a8929c53c8', 'pg8wa', '2018-03-26 11:55:15');
INSERT INTO `sys_captcha` VALUES ('5353535333533', 'accp8', '2018-03-31 21:41:36');
INSERT INTO `sys_captcha` VALUES ('5d631bb5-71c6-4ef1-8c65-93e00b102063', 'mnf3w', '2018-03-31 22:13:07');
INSERT INTO `sys_captcha` VALUES ('60f386cb-853e-431c-8df5-1891da9738a6', 'n3n5m', '2018-03-27 14:01:50');
INSERT INTO `sys_captcha` VALUES ('63e6ddee-ae1d-45d7-836a-9734496446c3', 'w2dpp', '2018-03-28 11:35:25');
INSERT INTO `sys_captcha` VALUES ('67dbbdfc-f439-47a7-b9f6-866ed9426a1b', 'x86aa', '2018-03-27 14:36:44');
INSERT INTO `sys_captcha` VALUES ('74b41691-d542-4bea-84bf-cec2a8c334f9', 'ncd4x', '2018-03-27 14:45:46');
INSERT INTO `sys_captcha` VALUES ('7679166a-2d8c-4cc6-87ee-288632622ba5', 'cww6n', '2018-03-26 12:01:13');
INSERT INTO `sys_captcha` VALUES ('7e3299e2-a5bb-4cc4-9a91-24c0b85266a7', 'm56af', '2018-03-28 11:35:15');
INSERT INTO `sys_captcha` VALUES ('827e8787-51d5-4b03-87d2-0ddebf68eac9', 'w7wf3', '2018-03-25 21:17:50');
INSERT INTO `sys_captcha` VALUES ('83cca379-a578-4786-bce0-59b91a0b24fc', 'nyb35', '2018-03-27 14:39:38');
INSERT INTO `sys_captcha` VALUES ('87f93bff-d2fb-4195-82cf-09a5627cce47', 'wd68n', '2018-03-26 17:00:28');
INSERT INTO `sys_captcha` VALUES ('8f8ae251-5984-425b-8ee4-a871cb163917', '6635a', '2018-03-26 17:35:55');
INSERT INTO `sys_captcha` VALUES ('93f6d84b-0d8f-4857-8e78-33d96b0fd179', 'w2nn3', '2018-03-26 11:57:57');
INSERT INTO `sys_captcha` VALUES ('949caaf8-9beb-41f9-891c-90145af56279', 'wen6c', '2018-03-26 17:35:16');
INSERT INTO `sys_captcha` VALUES ('9c5d47ad-5b04-4490-83c3-9042bf6c142c', '2w3em', '2018-03-26 12:01:07');
INSERT INTO `sys_captcha` VALUES ('a10cbda9-36c9-45c8-8b9d-5c9f18c6f656', '25m83', '2018-04-08 12:53:06');
INSERT INTO `sys_captcha` VALUES ('a204a3ab-88e5-4b37-926e-abe099ee350b', 'fpn6c', '2018-04-01 12:34:08');
INSERT INTO `sys_captcha` VALUES ('ac1171cb-2cff-404d-884b-41575a4c9973', '43p2d', '2018-03-27 15:35:32');
INSERT INTO `sys_captcha` VALUES ('b18d2d07-1f2d-44db-85f7-7c6076436d15', 'bn58y', '2018-03-27 13:26:59');
INSERT INTO `sys_captcha` VALUES ('b37d4092-c6d5-47d8-90d8-78258fe019d4', 'fa67e', '2018-03-26 12:01:18');
INSERT INTO `sys_captcha` VALUES ('b906a7a9-7030-419d-8817-46919af6c373', 'a82ba', '2018-04-01 12:34:02');
INSERT INTO `sys_captcha` VALUES ('cef04b26-9e95-4b7a-8a04-fc44dd9faea1', '2nfm2', '2018-03-27 14:25:05');
INSERT INTO `sys_captcha` VALUES ('e399d531-5867-4bd1-9a72-8cc22ef82bcc', '7wwe3', '2018-03-28 11:35:11');
INSERT INTO `sys_captcha` VALUES ('e45e9eb6-e82a-4bb3-87f3-cf2feade47e1', 'emmex', '2018-03-26 17:13:03');
INSERT INTO `sys_captcha` VALUES ('e88ca033-a2f7-4e99-a233-eaec90085c44', '8dpbm', '2018-03-30 12:43:11');
INSERT INTO `sys_captcha` VALUES ('eerer', 'w2w4c', '2018-03-31 22:37:26');
INSERT INTO `sys_captcha` VALUES ('f97056d0-318d-4aac-a32d-e2d70ec5e1f3', '6gp6y', '2018-03-27 12:34:25');
INSERT INTO `sys_captcha` VALUES ('fe702042-03c3-4a1a-93a3-09e3283a744e', 'eg25d', '2018-03-26 11:55:11');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) DEFAULT NULL COMMENT 'param_key',
  `param_value` varchar(2000) DEFAULT NULL COMMENT 'param_value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');
INSERT INTO `sys_config` VALUES ('2', 'aaa', 'dd', '1', 'd');
INSERT INTO `sys_config` VALUES ('3', '44', '5453', '1', '2');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `type` varchar(100) NOT NULL COMMENT '字典类型',
  `code` varchar(100) NOT NULL COMMENT '字典码',
  `value` varchar(1000) NOT NULL COMMENT '字典值',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '性别', 'sex', '0', '女', '0', null, '0');
INSERT INTO `sys_dict` VALUES ('2', '性别', 'sex', '1', '男', '1', null, '0');
INSERT INTO `sys_dict` VALUES ('3', '性别', 'sex', '2', '未知', '3', null, '0');

-- ----------------------------
-- Table structure for sys_log
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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '立即执行任务', 'com.ddc.template.modules.job.controller.ScheduleJobController.run()', '[1]', '51', '0:0:0:0:0:0:0:1', '2018-03-25 18:13:08');
INSERT INTO `sys_log` VALUES ('2', 'admin', '修改定时任务', 'com.ddc.template.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":1,\"beanName\":\"testTask\",\"methodName\":\"test\",\"params\":\"template\",\"cronExpression\":\"0 0/2 * * * ?\",\"status\":0,\"remark\":\"有参数测试\"}', '170', '127.0.0.1', '2018-03-25 20:52:38');
INSERT INTO `sys_log` VALUES ('3', 'admin', '修改定时任务', 'com.ddc.template.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":1,\"beanName\":\"testTask\",\"methodName\":\"test\",\"params\":\"template\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"remark\":\"有参数测试\"}', '32', '127.0.0.1', '2018-03-25 21:02:43');
INSERT INTO `sys_log` VALUES ('4', 'admin', '保存用户', 'com.ddc.template.modules.sys.controller.SysUserController.save()', '{\"userId\":2,\"username\":\"harry\",\"password\":\"fc0b353f5b1048b9cc6fbe4197a83fafc3ceca9b068c642c643beb99ba8b618b\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"status\":1,\"roleIdList\":[],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '202', '0:0:0:0:0:0:0:1', '2018-03-26 15:38:40');
INSERT INTO `sys_log` VALUES ('5', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '38', '0:0:0:0:0:0:0:1', '2018-03-26 15:38:58');
INSERT INTO `sys_log` VALUES ('6', 'admin', '保存角色', 'com.ddc.template.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"测试角色\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18],\"createTime\":\"Mar 26, 2018 5:51:46 PM\"}', '276', '0:0:0:0:0:0:0:1', '2018-03-26 17:51:46');
INSERT INTO `sys_log` VALUES ('7', 'admin', '修改角色', 'com.ddc.template.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"测试角色\",\"remark\":\"测试\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18],\"createTime\":\"Mar 26, 2018 5:51:46 PM\"}', '25', '0:0:0:0:0:0:0:1', '2018-03-26 17:52:01');
INSERT INTO `sys_log` VALUES ('8', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '58', '0:0:0:0:0:0:0:1', '2018-03-26 17:54:01');
INSERT INTO `sys_log` VALUES ('9', 'admin', '保存菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.save()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"product-hunt\",\"orderNum\":1}', '17', '0:0:0:0:0:0:0:1', '2018-03-26 18:27:54');
INSERT INTO `sys_log` VALUES ('10', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fab fa-product-hunt\",\"orderNum\":1}', '10', '0:0:0:0:0:0:0:1', '2018-03-26 18:30:41');
INSERT INTO `sys_log` VALUES ('11', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-product-hunt\",\"orderNum\":1}', '6', '0:0:0:0:0:0:0:1', '2018-03-26 18:30:57');
INSERT INTO `sys_log` VALUES ('12', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fas fa-folder\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-26 18:33:04');
INSERT INTO `sys_log` VALUES ('13', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-user-secret\",\"orderNum\":1}', '27', '0:0:0:0:0:0:0:1', '2018-03-26 18:33:23');
INSERT INTO `sys_log` VALUES ('14', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":36,\"parentName\":\"门店商品管理\",\"name\":\"商品管理\",\"url\":\"modules/sys/goods.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '21', '0:0:0:0:0:0:0:1', '2018-03-26 18:34:23');
INSERT INTO `sys_log` VALUES ('15', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fas fa-cog\",\"orderNum\":1}', '6', '0:0:0:0:0:0:0:1', '2018-03-26 18:39:44');
INSERT INTO `sys_log` VALUES ('16', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-trash-alt\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-26 18:40:21');
INSERT INTO `sys_log` VALUES ('17', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fab fa-accusoft\",\"orderNum\":1}', '22', '0:0:0:0:0:0:0:1', '2018-03-26 18:50:13');
INSERT INTO `sys_log` VALUES ('18', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fab fa-algolia\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-26 18:51:02');
INSERT INTO `sys_log` VALUES ('19', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\" fa-server\",\"orderNum\":1}', '7', '0:0:0:0:0:0:0:1', '2018-03-26 18:58:55');
INSERT INTO `sys_log` VALUES ('20', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-mouse-pointer\",\"orderNum\":1}', '21', '0:0:0:0:0:0:0:1', '2018-03-26 18:59:19');
INSERT INTO `sys_log` VALUES ('21', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-archive\",\"orderNum\":1}', '27', '0:0:0:0:0:0:0:1', '2018-03-27 10:40:03');
INSERT INTO `sys_log` VALUES ('22', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-cog\",\"orderNum\":1}', '20', '0:0:0:0:0:0:0:1', '2018-03-27 10:40:21');
INSERT INTO `sys_log` VALUES ('23', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-coa\",\"orderNum\":1}', '21', '0:0:0:0:0:0:0:1', '2018-03-27 10:40:30');
INSERT INTO `sys_log` VALUES ('24', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-asterisk\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-27 10:42:02');
INSERT INTO `sys_log` VALUES ('25', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-500px\",\"orderNum\":1}', '4', '0:0:0:0:0:0:0:1', '2018-03-27 10:42:51');
INSERT INTO `sys_log` VALUES ('26', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fab fa-accessible-icon\",\"orderNum\":1}', '34', '0:0:0:0:0:0:0:1', '2018-03-27 11:15:30');
INSERT INTO `sys_log` VALUES ('27', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-accessible\",\"orderNum\":1}', '10', '0:0:0:0:0:0:0:1', '2018-03-27 11:15:38');
INSERT INTO `sys_log` VALUES ('28', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-product-hunt\",\"orderNum\":1}', '23', '0:0:0:0:0:0:0:1', '2018-03-27 11:17:24');
INSERT INTO `sys_log` VALUES ('29', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fas fa-camera-retro\",\"orderNum\":1}', '7', '0:0:0:0:0:0:0:1', '2018-03-27 11:21:09');
INSERT INTO `sys_log` VALUES ('30', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"icon-shangpin\",\"orderNum\":1}', '29', '127.0.0.1', '2018-03-27 12:29:43');
INSERT INTO `sys_log` VALUES ('31', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"icon-shangpin\",\"orderNum\":1}', '27', '127.0.0.1', '2018-03-27 13:25:13');
INSERT INTO `sys_log` VALUES ('32', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fab fa-product-hunt\",\"orderNum\":1}', '31', '0:0:0:0:0:0:0:1', '2018-03-27 14:10:04');
INSERT INTO `sys_log` VALUES ('33', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-product-hunt\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-27 14:12:19');
INSERT INTO `sys_log` VALUES ('34', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa-product-hunt\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-27 14:13:15');
INSERT INTO `sys_log` VALUES ('35', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-product-hunt\",\"orderNum\":1}', '28', '0:0:0:0:0:0:0:1', '2018-03-27 14:13:28');
INSERT INTO `sys_log` VALUES ('36', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fas fa-suitcase\",\"orderNum\":1}', '8', '0:0:0:0:0:0:0:1', '2018-03-27 14:16:11');
INSERT INTO `sys_log` VALUES ('37', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"门店商品管理\",\"type\":0,\"icon\":\"fa fa-suitcase\",\"orderNum\":1}', '6', '0:0:0:0:0:0:0:1', '2018-03-27 14:16:17');
INSERT INTO `sys_log` VALUES ('38', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":36,\"parentName\":\"门店商品管理\",\"name\":\"商品管理\",\"url\":\"modules/sys/goods.html\",\"type\":1,\"icon\":\"fa fa-file-code\",\"orderNum\":6}', '24', '0:0:0:0:0:0:0:1', '2018-03-27 14:16:34');
INSERT INTO `sys_log` VALUES ('39', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":36,\"parentName\":\"门店商品管理\",\"name\":\"商品管理\",\"url\":\"modules/sys/goods.html\",\"type\":1,\"icon\":\"fa fa-file-code-0\",\"orderNum\":6}', '8', '0:0:0:0:0:0:0:1', '2018-03-27 14:16:45');
INSERT INTO `sys_log` VALUES ('40', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":36,\"parentName\":\"门店商品管理\",\"name\":\"商品管理\",\"url\":\"modules/sys/goods.html\",\"type\":1,\"icon\":\"fa fa-product-hunt\",\"orderNum\":6}', '8', '0:0:0:0:0:0:0:1', '2018-03-27 14:26:51');
INSERT INTO `sys_log` VALUES ('41', 'admin', '修改角色', 'com.ddc.template.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"测试角色\",\"remark\":\"测试\",\"createUserId\":1,\"menuIdList\":[36,31,32,33,34,35],\"createTime\":\"Mar 26, 2018 5:51:46 PM\"}', '287', '0:0:0:0:0:0:0:1', '2018-03-27 14:31:13');
INSERT INTO `sys_log` VALUES ('42', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '239', '0:0:0:0:0:0:0:1', '2018-03-27 18:05:10');
INSERT INTO `sys_log` VALUES ('43', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '252', '0:0:0:0:0:0:0:1', '2018-03-27 18:30:17');
INSERT INTO `sys_log` VALUES ('44', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@ddc.com\",\"mobile\":\"15921430685\",\"status\":1,\"roleIdList\":[],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 11:11:11 AM\"}', '189', '0:0:0:0:0:0:0:1', '2018-03-28 11:18:55');
INSERT INTO `sys_log` VALUES ('45', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '217', '0:0:0:0:0:0:0:1', '2018-03-30 12:39:40');
INSERT INTO `sys_log` VALUES ('46', 'admin', '修改角色', 'com.ddc.template.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"测试角色\",\"remark\":\"测试\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,30,36,31,32,33,34,35],\"createTime\":\"Mar 26, 2018 5:51:46 PM\"}', '70', '0:0:0:0:0:0:0:1', '2018-03-30 12:41:22');
INSERT INTO `sys_log` VALUES ('47', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '27', '0:0:0:0:0:0:0:1', '2018-03-30 12:41:27');
INSERT INTO `sys_log` VALUES ('48', 'admin', '修改菜单', 'com.ddc.template.modules.sys.controller.SysMenuController.update()', '{\"menuId\":37,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"数据字典表\",\"url\":\"modules/sys/sysdict.html\",\"type\":1,\"icon\":\"fa fa-bookmark-o\",\"orderNum\":6}', '28', '0:0:0:0:0:0:0:1', '2018-03-31 20:55:55');
INSERT INTO `sys_log` VALUES ('49', 'admin', '保存配置', 'com.ddc.template.modules.sys.controller.SysConfigController.save()', '{\"id\":2,\"key\":\"aaa\",\"value\":\"dd\",\"remark\":\"d\"}', '143', '0:0:0:0:0:0:0:1', '2018-04-02 13:21:03');
INSERT INTO `sys_log` VALUES ('50', 'admin', '修改配置', 'com.ddc.template.modules.sys.controller.SysConfigController.update()', '{\"id\":2,\"key\":\"aaa\",\"value\":\"dd\",\"remark\":\"d\"}', '3995', '0:0:0:0:0:0:0:1', '2018-04-02 13:25:53');
INSERT INTO `sys_log` VALUES ('51', 'admin', '保存配置', 'com.ddc.template.modules.sys.controller.SysConfigController.save()', '{\"id\":3,\"key\":\"44\",\"value\":\"5453\",\"remark\":\"2\"}', '18264', '0:0:0:0:0:0:0:1', '2018-04-02 13:27:13');
INSERT INTO `sys_log` VALUES ('52', 'admin', '修改配置', 'com.ddc.template.modules.sys.controller.SysConfigController.update()', '{\"id\":3,\"key\":\"44\",\"value\":\"5453\",\"remark\":\"2\"}', '170184', '0:0:0:0:0:0:0:1', '2018-04-02 13:31:47');
INSERT INTO `sys_log` VALUES ('53', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":0,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '147', '0:0:0:0:0:0:0:1', '2018-04-03 09:47:33');
INSERT INTO `sys_log` VALUES ('54', 'admin', '修改用户', 'com.ddc.template.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"harry\",\"salt\":\"fm9nWQNtMQvXXYuDjZnD\",\"email\":\"harry.zhang@daydaycook.com\",\"mobile\":\"110\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Mar 26, 2018 3:38:40 PM\"}', '39', '0:0:0:0:0:0:0:1', '2018-04-03 09:49:26');

-- ----------------------------
-- Table structure for sys_menu
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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

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
INSERT INTO `sys_menu` VALUES ('31', '36', '商品管理', 'modules/sys/goods.html', null, '1', 'fa fa-product-hunt', '6');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'sys:goods:list,sys:goods:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'sys:goods:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'sys:goods:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'sys:goods:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('36', '0', '门店商品管理', null, null, '0', 'fa fa-suitcase', '1');
INSERT INTO `sys_menu` VALUES ('37', '1', '数据字典表', 'modules/sys/sysdict.html', null, '1', 'fa fa-bookmark-o', '6');
INSERT INTO `sys_menu` VALUES ('38', '37', '查看', null, 'sys:sysdict:list,sys:sysdict:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '37', '新增', null, 'sys:sysdict:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '37', '修改', null, 'sys:sysdict:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('41', '37', '删除', null, 'sys:sysdict:delete', '2', null, '6');

-- ----------------------------
-- Table structure for sys_oss
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
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '测试角色', '测试', '1', '2018-03-26 17:51:46');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('19', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('20', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('21', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('22', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('23', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('24', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('25', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('26', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('27', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('28', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('29', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('30', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('31', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('32', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('33', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('34', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('35', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('36', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('37', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('38', '1', '8');
INSERT INTO `sys_role_menu` VALUES ('39', '1', '9');
INSERT INTO `sys_role_menu` VALUES ('40', '1', '10');
INSERT INTO `sys_role_menu` VALUES ('41', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('42', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('43', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('44', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('45', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('46', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('47', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('48', '1', '36');
INSERT INTO `sys_role_menu` VALUES ('49', '1', '31');
INSERT INTO `sys_role_menu` VALUES ('50', '1', '32');
INSERT INTO `sys_role_menu` VALUES ('51', '1', '33');
INSERT INTO `sys_role_menu` VALUES ('52', '1', '34');
INSERT INTO `sys_role_menu` VALUES ('53', '1', '35');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@ddc.com', '15921430685', '1', '1', '2018-03-26 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'harry', 'fc0b353f5b1048b9cc6fbe4197a83fafc3ceca9b068c642c643beb99ba8b618b', 'fm9nWQNtMQvXXYuDjZnD', 'harry.zhang@daydaycook.com', '110', '1', '1', '2018-03-26 15:38:40');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('6', '2', '1');

-- ----------------------------
-- Table structure for sys_user_token
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
INSERT INTO `sys_user_token` VALUES ('1', 'f056aa88971c6ca74b16f571af62b76c', '2018-04-09 00:45:05', '2018-04-08 12:45:05');
INSERT INTO `sys_user_token` VALUES ('2', '1f9544f6cef782b20250555d8ecd01f8', '2018-03-31 00:41:40', '2018-03-30 12:41:40');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '商品名',
  `intro` varchar(500) DEFAULT NULL COMMENT '介绍',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品管理';

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('3', '444', '44', '44.00', '44');

-- ----------------------------
-- Table structure for tb_user
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('2', '15921430685', '15921430685', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2018-03-27 14:54:23');
INSERT INTO `tb_user` VALUES ('5', 'amt', 'amt', '473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8', '2018-03-30 18:16:13');
