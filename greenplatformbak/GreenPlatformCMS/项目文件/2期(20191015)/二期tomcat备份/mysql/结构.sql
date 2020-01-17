/*
Navicat MySQL Data Transfer

Source Server         : greenplatform
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : greenplatform

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-01-04 12:45:25
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
-- Table structure for plate_code_dmz
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_dmz`;
CREATE TABLE `plate_code_dmz` (
  `c_dmlb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_dm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_dmmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `c_dmz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '代码值',
  `c_sm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '说明',
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
-- Table structure for plate_code_xtcs
-- ----------------------------
DROP TABLE IF EXISTS `plate_code_xtcs`;
CREATE TABLE `plate_code_xtcs` (
  `c_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '参数代码',
  `c_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '参数值',
  `c_sm` varchar(255) DEFAULT NULL COMMENT '说明',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统参数表';

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
  `c_sfcg` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用是否成功（0成功1错误）',
  `c_dysc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用时长',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Table structure for plate_log_20191031
-- ----------------------------
DROP TABLE IF EXISTS `plate_log_20191031`;
CREATE TABLE `plate_log_20191031` (
  `c_czrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `c_czr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `c_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用服务名',
  `c_params` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数',
  `c_sfcg` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用是否成功（0成功1错误）',
  `c_dysc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用时长',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Table structure for plate_log_20191105
-- ----------------------------
DROP TABLE IF EXISTS `plate_log_20191105`;
CREATE TABLE `plate_log_20191105` (
  `c_czrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `c_czr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `c_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用服务名',
  `c_params` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数',
  `c_sfcg` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用是否成功（0成功1错误）',
  `c_dysc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用时长',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Table structure for plate_log_20191119
-- ----------------------------
DROP TABLE IF EXISTS `plate_log_20191119`;
CREATE TABLE `plate_log_20191119` (
  `c_czrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `c_czr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `c_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用服务名',
  `c_params` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数',
  `c_sfcg` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用是否成功（0成功1错误）',
  `c_dysc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用时长',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Table structure for plate_log_20191128
-- ----------------------------
DROP TABLE IF EXISTS `plate_log_20191128`;
CREATE TABLE `plate_log_20191128` (
  `c_czrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `c_czr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `c_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用服务名',
  `c_params` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数',
  `c_sfcg` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用是否成功（0成功1错误）',
  `c_dysc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用时长',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

-- ----------------------------
-- Table structure for plate_log_20191214
-- ----------------------------
DROP TABLE IF EXISTS `plate_log_20191214`;
CREATE TABLE `plate_log_20191214` (
  `c_czrzbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作日志记录编号',
  `c_czr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czfs` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式（I新增，U修改，D删除）',
  `c_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用服务名',
  `c_params` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数',
  `c_sfcg` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用是否成功（0成功1错误）',
  `c_dysc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用时长',
  `c_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人IP',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_czrzbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台日志表';

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
  `c_issmz` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否实名制(0否1是)',
  `c_userid_smz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '实名制用户id',
  `c_rydj` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员等级（c_user_rydj)）',
  `c_rylb` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员类别（1管理员用户2前端平台用户）',
  `c_ryzt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员状态(code=‘C_RYZT’,有效/无效)',
  `c_ryxz` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员性质(C_USER_RYXZ,1正常/-1黑名单)',
  `c_zcfs` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员注册方式（C_ZCFS）',
  `c_zjlx` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型（code=‘zjlx’）',
  `c_zjhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件号码',
  `c_jtzz` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  `c_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `c_wxhm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号码',
  `c_qq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `c_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `c_yqm` varchar(255) DEFAULT NULL COMMENT '邀请码(被邀请扫二维码注册的用户有此字段和c_fatherid)',
  `c_fatherId` varchar(255) DEFAULT NULL COMMENT '父账户主键',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='平台用户表';

-- ----------------------------
-- Table structure for plate_user_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_blacklist`;
CREATE TABLE `plate_user_blacklist` (
  `c_lsh` varchar(255) NOT NULL COMMENT '操作流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `c_czfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作方式(add/remove,add-加入黑名单，remove-移除黑名单)',
  `c_czr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作人',
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间',
  `c_czyy` varchar(255) DEFAULT NULL COMMENT '操作原因',
  `c_zt` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0无效1有效）',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='黑名单用户';

-- ----------------------------
-- Table structure for plate_user_father
-- ----------------------------
DROP TABLE IF EXISTS `plate_user_father`;
CREATE TABLE `plate_user_father` (
  `c_userid` varchar(255) NOT NULL COMMENT '父账户ID',
  `c_sonid` varchar(255) NOT NULL COMMENT '徒弟ID',
  `c_fxmouth` varchar(255) DEFAULT NULL COMMENT '收徒月份（分享月）',
  `d_fxsj` datetime DEFAULT NULL COMMENT '分享时间',
  `c_zt` varchar(1) DEFAULT NULL COMMENT '状态',
  `c_bz` varchar(255) DEFAULT NULL COMMENT '备注',
  `c_cjuser` varchar(255) DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`,`c_sonid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分享平台收徒表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户对应角色中间表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户实名制后用户正式表';

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
-- Table structure for t_green_ed_edhz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_ed_edhz`;
CREATE TABLE `t_green_ed_edhz` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `n_zed` decimal(19,4) DEFAULT NULL COMMENT '总额度',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for t_green_ed_edjsmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_ed_edjsmx`;
CREATE TABLE `t_green_ed_edjsmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '流水号主键',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `c_jsyy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '减少原因(C_ED_JSEDYY)',
  `d_jssj` datetime DEFAULT NULL COMMENT '减少时间',
  `n_jssl` decimal(19,4) DEFAULT NULL COMMENT '减少数量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for t_green_ed_edzjmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_ed_edzjmx`;
CREATE TABLE `t_green_ed_edzjmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '流水号主键',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `c_zjyy` varchar(255) DEFAULT NULL COMMENT '增加原因(C_ED_ZJEDYY)',
  `d_zjsj` datetime DEFAULT NULL COMMENT '增加时间',
  `n_zjsl` decimal(19,4) DEFAULT NULL COMMENT '增加数量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for t_green_gold_dzhz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz`;
CREATE TABLE `t_green_gold_dzhz` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(19,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Table structure for t_green_gold_dzhz_20191110
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz_20191110`;
CREATE TABLE `t_green_gold_dzhz_20191110` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(19,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Table structure for t_green_gold_dzhz_20191122
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz_20191122`;
CREATE TABLE `t_green_gold_dzhz_20191122` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(19,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Table structure for t_green_gold_dzhz_20191202
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz_20191202`;
CREATE TABLE `t_green_gold_dzhz_20191202` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(19,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Table structure for t_green_gold_dzhz_20191212
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz_20191212`;
CREATE TABLE `t_green_gold_dzhz_20191212` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(19,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Table structure for t_green_gold_dzhz_20191230
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz_20191230`;
CREATE TABLE `t_green_gold_dzhz_20191230` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(19,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Table structure for t_green_gold_dzmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzmx`;
CREATE TABLE `t_green_gold_dzmx` (
  `c_lsh` varchar(255) NOT NULL,
  `c_userid` varchar(255) NOT NULL,
  `n_dzsl` decimal(19,4) DEFAULT NULL COMMENT '点赞数量',
  `d_dzsj` datetime DEFAULT NULL COMMENT '点赞时间',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户点赞明细';

-- ----------------------------
-- Table structure for t_green_gold_hz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_hz`;
CREATE TABLE `t_green_gold_hz` (
  `c_userid` varchar(255) NOT NULL,
  `n_jbzl` decimal(19,4) DEFAULT NULL COMMENT '金币总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币汇总';

-- ----------------------------
-- Table structure for t_green_gold_jsmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_jsmx`;
CREATE TABLE `t_green_gold_jsmx` (
  `c_lsh` varchar(255) NOT NULL,
  `c_userid` varchar(255) NOT NULL,
  `n_jssl` decimal(19,4) DEFAULT NULL COMMENT '减少数量',
  `d_jssj` datetime DEFAULT NULL COMMENT '减少时间',
  `c_jsyy` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加原因',
  `c_jsyysm` varchar(255) DEFAULT NULL COMMENT '减少原因说明',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币减少明细';

-- ----------------------------
-- Table structure for t_green_gold_zjmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_zjmx`;
CREATE TABLE `t_green_gold_zjmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `c_userid` varchar(255) NOT NULL,
  `n_zjsl` decimal(19,4) DEFAULT NULL COMMENT '增加数量',
  `d_zjsj` datetime DEFAULT NULL COMMENT '增加时间',
  `c_zjyy` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加原因',
  `c_zjyysm` varchar(255) DEFAULT NULL COMMENT '增加原因说明',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`,`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币增加明细';

-- ----------------------------
-- Table structure for t_green_nl_czjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_czjl`;
CREATE TABLE `t_green_nl_czjl` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '充值记录流水号',
  `c_userid` varchar(255) NOT NULL COMMENT '充值账户',
  `c_fkzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款账户',
  `c_fkfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_fksj` datetime DEFAULT NULL COMMENT '付款时间',
  `c_fkyh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款银行（付款方式为银行卡时填写）',
  `c_fkkh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款卡号',
  `c_fksfcg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款是否成功(0失败1成功）',
  `c_fkdh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款单号',
  `n_fkje` decimal(19,4) DEFAULT NULL COMMENT '付款金额(用多少人民币兑换能量）',
  `c_skzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款账户',
  `d_sksj` datetime DEFAULT NULL COMMENT '收款时间',
  `c_skfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款方式(支付宝/微信/银行卡）',
  `c_skyh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款银行（收款方式为银行卡是填写）',
  `c_skkh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款银行卡号',
  `c_sksfcg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款是否成功（0否1是）',
  `c_skdh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款单号',
  `n_sknl` decimal(19,4) DEFAULT NULL COMMENT '收款能量',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量充值记录';

-- ----------------------------
-- Table structure for t_green_nl_gfjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_gfjl`;
CREATE TABLE `t_green_nl_gfjl` (
  `c_lsh` varchar(255) NOT NULL COMMENT '流水号',
  `d_kssj` datetime DEFAULT NULL COMMENT '本轮瓜分开始时间',
  `d_gfsj` datetime NOT NULL COMMENT '瓜分时间（本轮瓜分结束时间）',
  `n_gfzl` decimal(19,4) NOT NULL COMMENT '瓜分总量',
  `c_czr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '调用瓜分服务的操作员',
  `c_zt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='瓜分能量记录（记录历史数据）';

-- ----------------------------
-- Table structure for t_green_nl_hz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_hz`;
CREATE TABLE `t_green_nl_hz` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `n_nlhz` decimal(19,4) DEFAULT NULL COMMENT '能量总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量汇总';

-- ----------------------------
-- Table structure for t_green_nl_jsnlmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_jsnlmx`;
CREATE TABLE `t_green_nl_jsnlmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `n_jssl` decimal(19,4) DEFAULT NULL COMMENT '减少数量',
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
-- Table structure for t_green_nl_txjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_txjl`;
CREATE TABLE `t_green_nl_txjl` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '提现记录流水号',
  `c_userid` varchar(255) NOT NULL COMMENT '提现账户',
  `c_fkzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款账户',
  `c_fkfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_fksj` datetime DEFAULT NULL COMMENT '付款时间',
  `c_fkyh` varchar(255) DEFAULT NULL COMMENT '付款银行（付款方式为银行卡时填写）',
  `c_fkkh` varchar(255) DEFAULT NULL COMMENT '付款卡号',
  `c_fksfcg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款是否成功(0失败1成功）',
  `c_fkdh` varchar(255) DEFAULT NULL COMMENT '付款单号',
  `n_fknl` decimal(8,4) DEFAULT NULL COMMENT '付款能量(用多少能量兑换）',
  `c_skzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款账户',
  `d_sksj` datetime DEFAULT NULL COMMENT '收款时间',
  `c_skfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款方式(支付宝/微信/银行卡）',
  `c_skyh` varchar(255) DEFAULT NULL COMMENT '收款银行（收款方式为银行卡是填写）',
  `c_skkh` varchar(255) DEFAULT NULL COMMENT '收款银行卡号',
  `c_sksfcg` varchar(255) DEFAULT NULL COMMENT '收款是否成功（0否1是）',
  `c_skdh` varchar(255) DEFAULT NULL COMMENT '收款单号',
  `n_skje` decimal(8,4) DEFAULT NULL COMMENT '收款金额',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量提现记录';

-- ----------------------------
-- Table structure for t_green_nl_zjnlmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_zjnlmx`;
CREATE TABLE `t_green_nl_zjnlmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID(system_user)',
  `n_zjnl` decimal(11,4) DEFAULT NULL COMMENT '增加数量',
  `d_zjsj` datetime DEFAULT NULL COMMENT '增加时间',
  `c_zjyy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加原因（c_nl_zjyy)',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量增加明细';

-- ----------------------------
-- Table structure for t_green_rw_rwhz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwhz`;
CREATE TABLE `t_green_rw_rwhz` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员ID',
  `n_ljwccs` int(11) DEFAULT NULL COMMENT '累计完成次数(三项任务加起来次数,不大于90次）',
  `d_yrw_q` datetime DEFAULT NULL COMMENT '本次30天任务开始时间(格式：年月日 时分秒）',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='基础任务完成汇总表（用于用户一个月完成任务次数）';

-- ----------------------------
-- Table structure for t_green_rw_rwmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwmx`;
CREATE TABLE `t_green_rw_rwmx` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID（system_user）',
  `c_rwlb` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务类别（1施肥，2浇水，3沐浴阳光）',
  `c_rwday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务日期（年月日）',
  `c_rwmouth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务完成月份（年月）',
  `d_rwsj` datetime NOT NULL COMMENT '任务完成时间具体时间（年月日：时分秒）',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`,`c_rwlb`,`d_rwsj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户完成任务后保存对应记录到此表';

-- ----------------------------
-- Table structure for t_green_rw_rwmx_replenish
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwmx_replenish`;
CREATE TABLE `t_green_rw_rwmx_replenish` (
  `c_userid` varchar(255) NOT NULL,
  `d_czsj` datetime DEFAULT NULL COMMENT '操作时间(补任务时间)',
  `c_bcday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '补的是哪一天的任务',
  `c_bz` varchar(255) DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) DEFAULT NULL COMMENT '数据状态（0无效1有效）',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`,`c_bcday`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='补任务明细表';

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
  `c_imgurl` varchar(255) DEFAULT NULL COMMENT '照片地址',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_spbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='种子商店商品明细';

-- ----------------------------
-- Table structure for t_green_zz_jzjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_zz_jzjl`;
CREATE TABLE `t_green_zz_jzjl` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '捐赠记录流水号',
  `c_zzzjlsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '增加种子流水号(捐赠的是哪一颗种子）',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '捐赠人',
  `d_jzsj` datetime DEFAULT NULL COMMENT '捐赠时间',
  `c_jzday` varchar(255) DEFAULT NULL COMMENT '捐赠日期（年月日）',
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
-- Table structure for t_green_zz_zjzzmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_zz_zjzzmx`;
CREATE TABLE `t_green_zz_zjzzmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '增加明细流水号',
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_spbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '种子编号（对应系统中的商品编号）',
  `c_zjyy` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '增加种子原因（C_ZZ_ZJYY）',
  `d_zjsj` datetime NOT NULL COMMENT '增加时间',
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
