/*
Navicat MySQL Data Transfer

Source Server         : GreenPlatform
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : greenplatform

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-12 16:32:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for plate_code_dmlb
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmlb`;
CREATE TABLE `plate_code_dmlb` (
  `c_dmlb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_dmlbmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_dmlb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台基础代码表';

-- ----------------------------
-- Records of plate_code_dmlb
-- ----------------------------
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_SF', '是否', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_YWZT', '业务状态', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_ZT', '状态', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_JSYY', '能量减少原因', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_ZJYY', '能量增加原因', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_RWLB', '任务类别', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_YWZT', '业务状态', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYDJ', '人员等级', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYLB', '人员类别', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYZT', '人员状态', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_SEX', '性别', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_ZCFS', '注册方式', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_ZJLX', '证件类型', null, null, null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZZ_ZJYY', '增加种子原因', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for plate_code_dmz
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmz`;
CREATE TABLE `plate_code_dmz` (
  `c_dmlb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_dm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_dmmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `c_sort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_dm`,`c_dmlb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台基础代码对应的代码值表';

-- ----------------------------
-- Records of plate_code_dmz
-- ----------------------------
INSERT INTO `plate_code_dmz` VALUES ('C_JC_SF', '0', '否', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_YWZT', '0', '未完成', '1', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-01 14:31:03');
INSERT INTO `plate_code_dmz` VALUES ('C_JC_ZT', '0', '无效', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '0', '未完成', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '0', '零级', '1', '', '1', '', '2019-07-02 10:21:50', '', '2019-07-02 10:22:02');
INSERT INTO `plate_code_dmz` VALUES ('C_JC_SF', '1', '是', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_YWZT', '1', '已完成', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_ZT', '1', '有效', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', '1', '兑换商品', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '1', '注册赠送', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '1', '施肥', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '1', '已完成', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '1', '一级', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '1', '系统用户', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '1', '正常', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '1', '男', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '1', '手机号码', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZJLX', '1', '身份证', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZZ_ZJYY', '1', '能量兑换（商品兑换）', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', '2', '提现', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '2', '完成一个月任务', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '2', '浇水', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '2', '二级', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '2', '前端用户', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '2', '违规', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '2', '女', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '2', '微信号', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZZ_ZJYY', '2', '注册赠送', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '3', '收徒完成', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '3', '沐浴阳光', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '3', '三级', '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '3', 'QQ号', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '4', '捐赠奖励', '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '4', '四级', '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '5', '充值', '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '6', '账户等级奖励', '6', null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_log
-- ----------------------------
DROP TABLE IF EXISTS `plate_log`;
CREATE TABLE `plate_log` (
  `c_czrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `c_czr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `c_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用服务名',
  `c_params` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Records of plate_log
-- ----------------------------
INSERT INTO `plate_log` VALUES ('df20f22cc9ab4df29ead4f494ee586e1', '179956ccbc0745c6ba9d79bef0b0b174', '2019-07-12 16:08:57', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', '127.0.0.1', '179956ccbc0745c6ba9d79bef0b0b174', '2019-07-12 16:08:57', null, null);

-- ----------------------------
-- Table structure for plate_user
-- ----------------------------
DROP TABLE IF EXISTS `plate_user`;
CREATE TABLE `plate_user` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `c_password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `c_loginname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆名称',
  `c_username` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `c_sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别（C_USER_SEX）',
  `c_smz` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否实名制',
  `c_userid_smz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '实名制用户id',
  `c_rydj` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员等级（c_user_rydj)）',
  `c_rylb` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员类别（code=''C_RYLB）',
  `c_ryzt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员状态(code=‘C_RYZT’,激活/未激活)',
  `c_ryxz` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员性质(C_USER_RYXZ,1正常/-1黑名单)',
  `c_zcfs` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员注册方式（C_ZCFS）',
  `c_zjlx` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型（code=‘zjlx’）',
  `c_zjhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `c_jtzz` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `c_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `c_wxhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `c_qq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `c_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='平台用户表';

-- ----------------------------
-- Records of plate_user
-- ----------------------------
INSERT INTO `plate_user` VALUES ('179956ccbc0745c6ba9d79bef0b0b174', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhangsan', 'XhCmcH', null, null, null, '0', '2', '1', '1', null, null, null, null, null, null, null, '123@qq.com', null, '1', '179956ccbc0745c6ba9d79bef0b0b174', '2019-07-12 16:04:37', null, null);
INSERT INTO `plate_user` VALUES ('318eb9ef076446ea8b85cb8d2559fb55', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'lisi', '李四', '2', null, null, null, '1', '1', '1', null, '1', '2', '四川省成都市', '13255555555', null, null, '123@qq.com', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-02 15:00:32', '3309b23c28584179b9d69e226e3eeeee', '2019-07-02 15:01:29');
INSERT INTO `plate_user` VALUES ('3309b23c28584179b9d69e226e3eeeee', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'admin', '系统管理员', '1', null, null, null, '1', '1', '1', '1', '1', '1212', '121212', '18328023251', '18328023251', '1271826981', '1213@qq.com', '测试测试', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-06-25 14:49:27', '3309b23c28584179b9d69e226e3eeeee', '2019-07-02 14:59:59');

-- ----------------------------
-- Table structure for plate_user_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_blacklist`;
CREATE TABLE `plate_user_blacklist` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='黑名单用户';

-- ----------------------------
-- Records of plate_user_blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for plate_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_permission`;
CREATE TABLE `plate_user_permission` (
  `c_role` varchar(255) NOT NULL COMMENT '角色编码',
  `c_ywlxdm` varchar(255) NOT NULL,
  `c_menudm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能代码（plate_yw_lx_menu）',
  `c_zt` varchar(1) DEFAULT NULL COMMENT '有效标志（0无效1有效）',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_role`,`c_ywlxdm`,`c_menudm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色所具备的业务功能权限表(角色与功能的中间表)';

-- ----------------------------
-- Records of plate_user_permission
-- ----------------------------
INSERT INTO `plate_user_permission` VALUES ('c_htAdmin', 'C_YWGN', 'C_YWGN_NLGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:31:32', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_htAdmin', 'C_YWGN', 'C_YWGN_RWGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:31:32', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_htAdmin', 'C_YWGN', 'C_YWGN_SPGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:31:32', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_htAdmin', 'C_YWGN', 'C_YWGN_STGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:31:32', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_htAdmin', 'C_YWGN', 'C_YWGN_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:31:32', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_htAdmin', 'C_YWGN', 'C_YWGN_ZHDJGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:31:32', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_CSSZ', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_QXGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YWJCDM', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YYPZ', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_NLGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_RWGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_SPGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_STGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_ZHDJGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 11:32:16', null, null);

-- ----------------------------
-- Table structure for plate_user_role
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_role`;
CREATE TABLE `plate_user_role` (
  `c_role` varchar(255) NOT NULL COMMENT '角色编码',
  `c_rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有效标志',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of plate_user_role
-- ----------------------------
INSERT INTO `plate_user_role` VALUES ('c_htAdmin', '后台管理员', '1', null, null, null, null);
INSERT INTO `plate_user_role` VALUES ('c_sysAdmin', '系统管理员', '1', null, null, null, null);
INSERT INTO `plate_user_role` VALUES ('c_webUser', '前端用户', '0', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-05 10:54:13');

-- ----------------------------
-- Table structure for plate_user_role_mid
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_role_mid`;
CREATE TABLE `plate_user_role_mid` (
  `c_userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `c_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有效标志',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`,`c_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of plate_user_role_mid
-- ----------------------------
INSERT INTO `plate_user_role_mid` VALUES ('318eb9ef076446ea8b85cb8d2559fb55', 'c_htAdmin', '1', '318eb9ef076446ea8b85cb8d2559fb55', '2019-07-10 15:42:19', null, null);
INSERT INTO `plate_user_role_mid` VALUES ('3309b23c28584179b9d69e226e3eeeee', 'c_sysAdmin', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 15:42:58', null, null);
INSERT INTO `plate_user_role_mid` VALUES ('63fd87e30142449f88f04aa6677423ad', 'c_webUser', '1', null, null, null, null);

-- ----------------------------
-- Table structure for plate_user_smz
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_smz`;
CREATE TABLE `plate_user_smz` (
  `c_userid_smz` varchar(255) NOT NULL COMMENT '用户id（实名制后）',
  `c_userid` int(11) DEFAULT NULL COMMENT '用户id（plate_user表中）',
  `c_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户姓名（实名制后）',
  `c_sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别（C_USER_SEX）',
  `c_zjlx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '证件类型',
  `c_zjhm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '证件号码',
  `c_jtzz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '家庭住址',
  `c_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话号码',
  `c_wxhm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信号码',
  `c_qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'qq号码',
  `c_yhkhdm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '银行卡号代码（工商银行/建设银行等）',
  `c_yhkh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '银行卡号',
  `c_zfbzfzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '支付宝账户',
  `c_wxzfzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信支付账户',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid_smz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of plate_user_smz
-- ----------------------------

-- ----------------------------
-- Table structure for plate_yw_lx_menu
-- ----------------------------
DROP TABLE IF EXISTS `plate_yw_lx_menu`;
CREATE TABLE `plate_yw_lx_menu` (
  `c_ywlxdm` varchar(255) NOT NULL COMMENT '业务类型代码',
  `c_menudm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单代码',
  `c_menumc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `c_menujc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单功能简称',
  `c_runcommand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '打开功能的链接',
  `c_sort` varchar(11) DEFAULT NULL COMMENT '排序号',
  `c_zt` varchar(1) DEFAULT NULL,
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_menudm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能表';

-- ----------------------------
-- Records of plate_yw_lx_menu
-- ----------------------------
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_CSSZ', '系统配置_系统参数设置', '系统参数设置', '/base/xtcssz', '4', '0', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-10 15:44:58');
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_QXGL', '系统配置_权限管理', '权限管理', '/base/qxgl', '3', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YHGL', '系统配置_用户管理', '用户管理', '/base/plateYhgl', '2', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YWJCDM', '系统配置_业务基础代码管理', '业务基础代码管理', '/base/ywjcdm', '1', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YYPZ', '系统配置_应用配置', '应用配置', '/base/yypz', '5', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_NLGL', '业务功能_能量管理', '能量管理', '/base/nlgl', '2', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_RWGL', '业务功能_任务管理', '任务管理', '/base/rwgl', '3', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_SPGL', '业务功能_商品管理', '商品管理', '/base/spgl', '4', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_STGL', '业务功能_收徒管理', '收徒管理', '/base/stgl', '5', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_YHGL', '业务功能_前端用户管理', '前端用户管理', '/base/yhgl', '1', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_ZHDJGL', '业务功能_账户等级管理', '账户等级管理', '/base/zhsjgl', '6', '1', null, null, null, null);

-- ----------------------------
-- Table structure for t_green_nl_czjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_czjl`;
CREATE TABLE `t_green_nl_czjl` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '充值记录流水号',
  `n_czje` decimal(11,6) DEFAULT NULL COMMENT '充值金额',
  `n_cznl` decimal(11,4) DEFAULT NULL COMMENT '充值能量',
  `d_czsj` datetime DEFAULT NULL COMMENT '充值时间',
  `c_sfcg` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否操作成功（0否1是）',
  `c_czfs` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '充值方式(支付宝/微信）',
  `c_czzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '充值帐户',
  `c_dzzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '到账账户',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量充值记录';

-- ----------------------------
-- Records of t_green_nl_czjl
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_nl_hz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_hz`;
CREATE TABLE `t_green_nl_hz` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `n_nlhz` decimal(11,4) DEFAULT NULL COMMENT '能量总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量汇总';

-- ----------------------------
-- Records of t_green_nl_hz
-- ----------------------------
INSERT INTO `t_green_nl_hz` VALUES ('179956ccbc0745c6ba9d79bef0b0b174', '0.0000', null, '1', '179956ccbc0745c6ba9d79bef0b0b174', '2019-07-12 16:04:37', null, null);

-- ----------------------------
-- Table structure for t_green_nl_jsnlmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_jsnlmx`;
CREATE TABLE `t_green_nl_jsnlmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `n_jssl` decimal(11,4) DEFAULT NULL COMMENT '减少数量',
  `d_jssj` datetime DEFAULT NULL COMMENT 'c_jsyy)减少时间',
  `c_jsyy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '减少原因（c_jsyy）',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量减少明细';

-- ----------------------------
-- Records of t_green_nl_jsnlmx
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_nl_txjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_txjl`;
CREATE TABLE `t_green_nl_txjl` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '提现记录流水号',
  `n_txje` decimal(11,6) DEFAULT NULL COMMENT '提现金额',
  `n_txnl` decimal(11,4) DEFAULT NULL COMMENT '提现能量',
  `d_txsj` datetime DEFAULT NULL COMMENT '提现时间',
  `c_sfcg` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否成功(0否1是)',
  `c_txfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '提现方式（支付宝/微信）',
  `c_txzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '提现账户',
  `c_fkzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款账户',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量提现记录';

-- ----------------------------
-- Records of t_green_nl_txjl
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_nl_zjnlmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_zjnlmx`;
CREATE TABLE `t_green_nl_zjnlmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID(system_user)',
  `n_zjnl` decimal(11,4) DEFAULT NULL COMMENT '增加数量',
  `d_zjsj` datetime DEFAULT NULL COMMENT '增加时间',
  `c_zjyy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加原因（c_zjyy)',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量增加明细';

-- ----------------------------
-- Records of t_green_nl_zjnlmx
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_rw_rwhz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwhz`;
CREATE TABLE `t_green_rw_rwhz` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员ID',
  `c_rwlb` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务类别',
  `c_rwsj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务完成时间(格式年月日，为了查询时的日期比较)',
  `c_rwcs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务次数（一个账户同一任务一个月最多30次）',
  `c_ljwccs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '累计完成次数(三项任务加起来次数,不大于90次）',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`,`c_rwlb`,`c_rwsj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='基础任务完成汇总表（用于用户一个月完成任务次数）';

-- ----------------------------
-- Records of t_green_rw_rwhz
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_rw_rwmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwmx`;
CREATE TABLE `t_green_rw_rwmx` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID（system_user）',
  `c_rwlb` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务类别（1施肥，2浇水，3沐浴阳光）',
  `c_rwday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务日期（年月日）',
  `c_rwmouth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务完成月份（年月）',
  `d_rwsj` datetime DEFAULT NULL COMMENT '任务完成时间具体时间（年月日：时分秒）',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`,`c_rwlb`,`c_rwday`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户完成任务后保存对应记录到此表';

-- ----------------------------
-- Records of t_green_rw_rwmx
-- ----------------------------
INSERT INTO `t_green_rw_rwmx` VALUES ('179956ccbc0745c6ba9d79bef0b0b174', '1', '2019-07-12', '2019-07', '2019-07-12 16:05:02', null, '1', '179956ccbc0745c6ba9d79bef0b0b174', '2019-07-12 16:05:02', null, null);

-- ----------------------------
-- Table structure for t_green_sp_spmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_sp_spmx`;
CREATE TABLE `t_green_sp_spmx` (
  `c_spbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品编号',
  `c_spmc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `c_spms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品描述',
  `n_spjg` decimal(8,2) DEFAULT NULL COMMENT '商品价格',
  `c_spdw` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_spbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='种子商店商品明细';

-- ----------------------------
-- Records of t_green_sp_spmx
-- ----------------------------
INSERT INTO `t_green_sp_spmx` VALUES ('1', '仙人掌', '是仙人掌科缩刺仙人掌的变种。丛', '100.00', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('10', '金琥', '是仙人掌科、金琥属多年生草本多', '100000.00', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('2', '白刺', '白刺是蒺藜科白刺属的灌木，分枝', '300.00', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('3', '肉苁蓉', '1111', '500.00', '能量', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-06-28 15:27:58');
INSERT INTO `t_green_sp_spmx` VALUES ('4', '芦荟', '芦荟（学名：Aloe vera', '1000.00', '能量', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-06-28 15:24:06');
INSERT INTO `t_green_sp_spmx` VALUES ('5', '大犀角', '多年生肉质草本，茎四', '3000.00', '能量', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-06-28 15:23:27');
INSERT INTO `t_green_sp_spmx` VALUES ('6', '绿之玲', '又名翡翠珠、佛珠吊兰', '5000.00', '能量', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-05-29 11:10:27');
INSERT INTO `t_green_sp_spmx` VALUES ('7', '生石花', '生石花（学名：Lithops', '10000.00', '能量', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-06-28 15:23:36');
INSERT INTO `t_green_sp_spmx` VALUES ('8', '光棍树', '小乔木，高2~6米，直径10', '30000.00', '能量', null, '1', null, null, null, null);
INSERT INTO `t_green_sp_spmx` VALUES ('9', '巨人柱', '是巨柱仙人掌属中唯一的', '50000.00', '能量', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-05-29 11:09:36');

-- ----------------------------
-- Table structure for t_green_zz_jzjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_zz_jzjl`;
CREATE TABLE `t_green_zz_jzjl` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '捐赠记录流水号',
  `c_zzzjlsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '增加种子流水号(捐赠的是哪一颗种子）',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '捐赠人',
  `d_Jzsj` datetime DEFAULT NULL COMMENT '捐赠时间',
  `c_spbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '捐赠种子编号',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`,`c_zzzjlsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='种子捐赠记录';

-- ----------------------------
-- Records of t_green_zz_jzjl
-- ----------------------------

-- ----------------------------
-- Table structure for t_green_zz_zjzzmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_zz_zjzzmx`;
CREATE TABLE `t_green_zz_zjzzmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '增加明细流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_spbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '种子编号（对应系统中的商品编号）',
  `c_zjyy` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加种子原因（C_ZZ_ZJYY）',
  `d_zjsj` datetime DEFAULT NULL COMMENT '增加时间',
  `c_kjz` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否可捐赠（0否1是）对应任务明细表中cLjrwcs字段',
  `c_sfjz` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否捐赠（0否1是）',
  `d_jzsj` datetime DEFAULT NULL COMMENT '捐赠时间',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户种子增加明细表（兑换等原因）';

-- ----------------------------
-- Records of t_green_zz_zjzzmx
-- ----------------------------
INSERT INTO `t_green_zz_zjzzmx` VALUES ('58445c92678640e38199b8e972b6dd62', '179956ccbc0745c6ba9d79bef0b0b174', '1', '1', '2019-07-12 16:04:37', '0', '0', null, null, '1', '179956ccbc0745c6ba9d79bef0b0b174', '2019-07-12 16:04:37', null, null);
