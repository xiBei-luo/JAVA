/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : jzdb

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-05-09 14:18:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for plate_code_dmlb
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmlb`;
CREATE TABLE `plate_code_dmlb` (
  `C_DMLB` varchar(255) NOT NULL,
  `C_DMLBMC` varchar(255) DEFAULT NULL,
  `C_ZT` varchar(1) DEFAULT NULL,
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`C_DMLB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台基础代码表';

-- ----------------------------
-- Records of plate_code_dmlb
-- ----------------------------
INSERT INTO `plate_code_dmlb` VALUES ('C_RYLB', '人员类别', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RYZT', '人员状态', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZCFS', '注册方式', '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZJLX', '证件类型', '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_code_dmz
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmz`;
CREATE TABLE `plate_code_dmz` (
  `C_DMLB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `C_DM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `C_DMMC` varchar(255) DEFAULT NULL,
  `C_SORT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `C_BZ` varchar(255) DEFAULT NULL,
  `C_ZT` varchar(255) DEFAULT NULL,
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`C_DM`,`C_DMLB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台基础代码对应的代码值表';

-- ----------------------------
-- Records of plate_code_dmz
-- ----------------------------
INSERT INTO `plate_code_dmz` VALUES ('C_RYLB', '1', '系统用户', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RYZT', '1', '正常', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZCFS', '1', '手机号码', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZJLX', '1', '身份证', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RYLB', '2', '前端用户', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RYZT', '2', '违规', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZCFS', '2', '微信号', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZCFS', '3', 'QQ号', '3', null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_log
-- ----------------------------
DROP TABLE IF EXISTS `plate_log`;
CREATE TABLE `plate_log` (
  `C_CZRZBH` varchar(255) NOT NULL COMMENT '操作日志记录编号',
  `C_TABLE` varchar(255) DEFAULT NULL COMMENT '操作表名称',
  `C_TABLEKEY` varchar(255) DEFAULT NULL COMMENT '操作表主键',
  `C_KEYVALUE` varchar(255) DEFAULT NULL COMMENT '操作表主键值',
  `C_COLUMN` varchar(255) DEFAULT NULL COMMENT '操作表字段',
  `C_COLUMNNAME` varchar(255) DEFAULT NULL COMMENT '操作表字段名称',
  `C_CZFS` varchar(1) DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `C_OLDVALUES` varchar(255) DEFAULT NULL COMMENT '变更原值',
  `C_NEWVALUES` varchar(255) DEFAULT NULL COMMENT '变更新值',
  `C_BGR` varchar(255) DEFAULT NULL COMMENT '变更人',
  `C_BGRXM` varchar(255) DEFAULT NULL COMMENT '变更人姓名',
  `D_BGSJ` datetime DEFAULT NULL COMMENT '变更时间',
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`C_CZRZBH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Records of plate_log
-- ----------------------------

-- ----------------------------
-- Table structure for plate_user
-- ----------------------------
DROP TABLE IF EXISTS `plate_user`;
CREATE TABLE `plate_user` (
  `C_USERID` varchar(11) NOT NULL COMMENT '用户ID',
  `C_LOGINNAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆名称',
  `C_USERNAME` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `C_PASSWORD` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `C_RYLB` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员类别（code=''C_RYLB）',
  `C_RYZT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员状态(code=‘C_RYZT’)',
  `C_ZCFS` varchar(1) DEFAULT NULL COMMENT '人员注册方式（C_ZCFS）',
  `C_ZJLX` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型（code=‘zjlx’）',
  `C_ZJHM` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `C_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `C_JTZZ` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `C_PHONE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `C_WXHM` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `C_QQ` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `C_EMAIL` varchar(255) DEFAULT NULL,
  `C_BZ` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `C_ZT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `C_CJUSER` varchar(11) DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`C_USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='平台用户表';

-- ----------------------------
-- Records of plate_user
-- ----------------------------
INSERT INTO `plate_user` VALUES ('1', 'admin', '系统管理员', 'aaaaaa', '1', '1', null, null, null, null, null, null, null, null, null, null, '1', '1', '2019-05-06 00:00:00', '1', '2019-05-06 00:00:00');

-- ----------------------------
-- Table structure for plate_user_ywqx
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_ywqx`;
CREATE TABLE `plate_user_ywqx` (
  `C_USERID` varchar(11) NOT NULL COMMENT '用户ID',
  `C_YWLXDM` varchar(255) DEFAULT NULL COMMENT '业务权限代码（见表plate_yw_lx）',
  `C_SQUSERID` varchar(11) DEFAULT NULL COMMENT '授权人',
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间'
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
  `C_YWLXDM` varchar(255) DEFAULT NULL COMMENT '业务分类代码',
  `C_YWLXMC` varchar(255) DEFAULT NULL COMMENT '业务分类名称',
  `C_YWLXMCJC` varchar(255) DEFAULT NULL COMMENT '业务分类简称',
  `C_BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `C_ZT` varchar(255) DEFAULT NULL,
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间'
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
  `C_YWLXDM` varchar(255) DEFAULT NULL COMMENT '业务类型代码（plate_yw_lx）',
  `C_MENUDM` varchar(255) DEFAULT NULL COMMENT '菜单功能代码',
  `C_MENUMC` varchar(255) DEFAULT NULL COMMENT '菜单功能名称',
  `C_ZT` varchar(255) DEFAULT NULL COMMENT '状态',
  `C_BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间'
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
  `C_USERID` varchar(11) NOT NULL COMMENT '用户ID',
  `C_LOGINNAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆名称',
  `C_USERNAME` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `C_PASSWORD` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `C_RYLB` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员类别（code=''C_RYLB）',
  `C_RYZT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员状态(code=‘C_RYZT’)',
  `C_ZCFS` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员注册方式（C_ZCFS）',
  `C_ZJLX` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型（code=‘zjlx’）',
  `C_ZJHM` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `C_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `C_JTZZ` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `C_PHONE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `C_WXHM` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `C_QQ` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `C_EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `C_BZ` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `C_ZT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `C_CJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `D_CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `C_XJUSER` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `D_XGSJ` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`C_USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前端应用用户表';

-- ----------------------------
-- Records of system_user
-- ----------------------------
