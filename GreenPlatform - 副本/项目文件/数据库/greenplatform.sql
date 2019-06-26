/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : greenplatform

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-05-17 17:07:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for plate_code_dmlb
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmlb`;
CREATE TABLE `plate_code_dmlb` (
  `cDmlb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cDmlbmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cDmlb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台基础代码表';

-- ----------------------------
-- Records of plate_code_dmlb
-- ----------------------------
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_SF', '是否', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_JSYY', '能量减少原因', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_ZJYY', '能量增加原因', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_RWLB', '任务类别', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_YWZT', '业务状态', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYDJ', '人员等级', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYLB', '人员类别', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYZT', '人员状态', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_SEX', '性别', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_ZCFS', '注册方式', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_ZJLX', '证件类型', '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_code_dmz
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmz`;
CREATE TABLE `plate_code_dmz` (
  `cDmlb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cDm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cDmmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cSort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cBz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cZt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cDm`,`cDmlb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台基础代码对应的代码值表';

-- ----------------------------
-- Records of plate_code_dmz
-- ----------------------------
INSERT INTO `plate_code_dmz` VALUES ('C_JC_SF', '0', '否', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '0', '未完成', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_SF', '1', '是', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', '1', '兑换商品', '1', null, null, null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '1', '注册赠送', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '1', '施肥', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '1', '已完成', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '1', '一级', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '1', '系统用户', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '1', '正常', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '1', '男', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '1', '手机号码', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZJLX', '1', '身份证', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', '2', '提现', '2', null, null, null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '2', '完成一个月任务', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '2', '浇水', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '2', '二级', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '2', '前端用户', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '2', '违规', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '2', '女', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '2', '微信号', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '3', '收徒完成', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '3', '沐浴阳光', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '3', '三级', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '3', 'QQ号', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '4', '捐赠奖励', '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '4', '四级', '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '5', '充值', '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '6', '账户等级奖励', '6', null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_log
-- ----------------------------
DROP TABLE IF EXISTS `plate_log`;
CREATE TABLE `plate_log` (
  `cCzrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `cTable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作表名称',
  `cTablekey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作表主键',
  `cKeyvalue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作表主键值',
  `cColumn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作表字段',
  `cColumnname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作表字段名称',
  `cCzfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `cOldvalue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '变更原值',
  `cNewvalue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '变更新值',
  `cBgr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '变更人',
  `cBgrxm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '变更人姓名',
  `dBgsj` datetime DEFAULT NULL COMMENT '变更时间',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cCzrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Records of plate_log
-- ----------------------------

-- ----------------------------
-- Table structure for plate_user
-- ----------------------------
DROP TABLE IF EXISTS `plate_user`;
CREATE TABLE `plate_user` (
  `cUserid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `cLoginname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆名称',
  `cUsername` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `cSex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别（C_USER_SEX）',
  `cPassword` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `cRydj` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员等级（c_user_rydj)）',
  `cRylb` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员类别（code=''C_RYLB）',
  `cRyzt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员状态(code=‘C_RYZT’)',
  `cZcfs` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员注册方式（C_ZCFS）',
  `cZjlx` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型（code=‘zjlx’）',
  `cZjhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `cJtzz` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `cPhone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `cWxhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `cQq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `cEmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cUserid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='平台用户表';

-- ----------------------------
-- Records of plate_user
-- ----------------------------
INSERT INTO `plate_user` VALUES ('3309b23c28584179b9d69e226e3eeeee', 'admin', '系统管理员', '2', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', null, '1', null, null, null, '', null, '18328023251', '18328023251', null, '1271826981@qq.com', null, '1', null, '2019-05-17 16:37:34', null, null);

-- ----------------------------
-- Table structure for plate_user_ywqx
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_ywqx`;
CREATE TABLE `plate_user_ywqx` (
  `cUserid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `cYwlxdm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务权限代码（见表plate_yw_lx）',
  `cSquser` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '授权人',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台用户业务权限分配表';

-- ----------------------------
-- Records of plate_user_ywqx
-- ----------------------------
INSERT INTO `plate_user_ywqx` VALUES ('1', 'GROW_PLATE_STGL', '1', null, null, null, null);
INSERT INTO `plate_user_ywqx` VALUES ('1', 'GROW_PLATE_STGL', null, null, null, null, null);
INSERT INTO `plate_user_ywqx` VALUES ('1', 'GROW_PLATE_STGL', null, null, null, null, null);
INSERT INTO `plate_user_ywqx` VALUES ('1', 'GROW_PLATE_STGL', null, null, null, null, null);
INSERT INTO `plate_user_ywqx` VALUES ('1', 'GROW_PLATE_STGL', null, null, null, null, null);
INSERT INTO `plate_user_ywqx` VALUES ('1', 'GROW_PLATE_ZHSJGL', '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_yw_lx
-- ----------------------------
DROP TABLE IF EXISTS `plate_yw_lx`;
CREATE TABLE `plate_yw_lx` (
  `cYwlxdm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务分类代码',
  `cYwlxmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务分类名称',
  `cYwlxmcjc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务分类简称',
  `cBz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台业务类型表（目前只有前端与后台两个应用）';

-- ----------------------------
-- Records of plate_yw_lx
-- ----------------------------
INSERT INTO `plate_yw_lx` VALUES ('GROW_PLATE', '平台业务', '平台业务', null, '1', null, null, null, null);
INSERT INTO `plate_yw_lx` VALUES ('GROW_SYSTEM', '前端业务', '前端业务', null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_yw_lx_menu
-- ----------------------------
DROP TABLE IF EXISTS `plate_yw_lx_menu`;
CREATE TABLE `plate_yw_lx_menu` (
  `cYwlxdm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务类型代码（plate_yw_lx）',
  `cMenudm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单功能代码',
  `cMenumc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单功能名称',
  `cZt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `cBz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台业务类型对应的功能表';

-- ----------------------------
-- Records of plate_yw_lx_menu
-- ----------------------------
INSERT INTO `plate_yw_lx_menu` VALUES ('GROW_PLATE', 'GROW_PLATE_YHGL', '用户管理', '1', null, null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('GROW_PLATE', 'GROW_PLATE_RWGL', '任务管理', '1', null, null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('GROW_PLATE', 'GROW_PLATE_NLGL', '能量管理', '1', null, null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('GROW_PLATE', 'GROW_PLATE_SPGL', '商品管理', '1', null, null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('GROW_PLATE', 'GROW_PLATE_STGL', '收徒管理', '1', null, null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('GROW_PLATE', 'GROW_PLATE_ZHSJGL', '账户升级管理', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `cUserid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `cLoginname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆名称',
  `cUsername` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `cPassword` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `cRylb` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员类别（code=''C_RYLB）',
  `cRyzt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员状态(code=‘C_RYZT’)',
  `cZcfs` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员注册方式（C_ZCFS）',
  `cZjlx` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型（code=‘zjlx’）',
  `cZjhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `cSex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `cJtzz` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `cPhone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `cWxhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `cQq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `cEmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱地址',
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cUserid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前端应用用户表';

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('0d245fc528394074943ad56f0cfc4db7', '111', null, '698d51a19d8a121ce581499d7b701668', null, null, null, null, null, null, null, null, null, null, '1271826981@qq.com', null, null, null, '2019-05-17 16:30:50', null, null);
INSERT INTO `system_user` VALUES ('188cc2d40fe74ad489256f047a7e1341', 'zhangsan', null, 'aaaaaa', null, null, null, null, null, null, null, null, null, null, '123@qq.com', null, null, null, '2019-05-12 17:44:28', null, null);

-- ----------------------------
-- Table structure for t_green_nl_hz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_hz`;
CREATE TABLE `t_green_nl_hz` (
  `cUserid` varchar(255) NOT NULL,
  `cNlzl` varchar(255) DEFAULT NULL,
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cUserid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_green_nl_hz
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_nl_jsnlmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_jsnlmx`;
CREATE TABLE `t_green_nl_jsnlmx` (
  `cLsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `cUserid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `cJssl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '减少数量',
  `dJssj` datetime DEFAULT NULL COMMENT 'c_jsyy)减少时间',
  `cJsyy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '减少原因（c_jsyy）',
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cLsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_green_nl_jsnlmx
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_nl_zjnlmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_zjnlmx`;
CREATE TABLE `t_green_nl_zjnlmx` (
  `cLsh` varchar(255) NOT NULL COMMENT '操作业务流水号',
  `cUserid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID(system_user)',
  `cZjsl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加数量',
  `dZjsj` datetime DEFAULT NULL COMMENT '增加时间',
  `cZjyy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加原因（c_zjyy)',
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cLsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_green_nl_zjnlmx
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_rw_rwmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwmx`;
CREATE TABLE `t_green_rw_rwmx` (
  `cUserid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID（system_user）',
  `cRwlb` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务类别（1施肥，2浇水，3沐浴阳光）',
  `cRwsj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务发布时间',
  `cYwzt` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务完成业务状态（0未完成，1已完成）',
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cUserid`,`cRwlb`,`cRwsj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_green_rw_rwmx
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_sp_spmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_sp_spmx`;
CREATE TABLE `t_green_sp_spmx` (
  `cSpbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品编号',
  `cSpmc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `cSpms` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `cSpjg` varchar(255) DEFAULT NULL COMMENT '商品价格',
  `cSpdw` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
  `cBz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `cZt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `cCjuser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `dCjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `cXguser` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `dXgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cSpbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_green_sp_spmx
-- ----------------------------
INSERT INTO `t_green_sp_spmx` VALUES ('1', '仙人掌', '是仙人掌科缩刺仙人掌的变种。丛', '100', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('10', '金琥', '是仙人掌科、金琥属多年生草本多', '100000', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('2', '白刺', '白刺是蒺藜科白刺属的灌木，分枝', '300', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('3', '肉苁蓉', '肉苁蓉（学名：Cistanche ', '500', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('4', '芦荟', '芦荟（学名：Aloe vera', '1000', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('5', '大犀角', '多年生肉质草本，茎四', '3000', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('6', '绿之玲', '又名翡翠珠、佛珠吊兰、', '5000', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('7', '生石花', '生石花（学名：Lithops', '10000', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('8', '光棍树', '小乔木，高2~6米，直径10', '30000', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('9', '巨人柱', '是巨柱仙人掌属中唯一的物种', '50000', '能量', null, '1', null, null, null, null);
