/*
Navicat MySQL Data Transfer

Source Server         : GreenPlatform
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : greenplatform

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-25 17:22:33
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
INSERT INTO `plate_code_dmlb` VALUES ('C_DZSL_ONE', '1次点赞花费金币数', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_FATHER_JL', '父账户能量奖励', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_GFNLZ', '瓜分能量值', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 14:49:54', null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_GOLD_JSYY', '减少金币原因', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_GOLD_ZJYY', '增加金币原因', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 16:34:22', null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_SF', '是否', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_YWZT', '业务状态', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_JC_ZT', '状态', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_JSYY', '能量减少原因', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_ZJYY', '能量增加原因', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_RWLB', '任务类别', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_YWZT', '业务状态', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_TEST', '测试', null, '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:02', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:45');
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYDJ', '人员等级', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYLB', '人员类别', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_RYZT', '人员状态', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_SEX', '性别', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_ZCFS', '注册方式', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_USER_ZJLX', '证件类型', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZHDJ_EXTJL', '账户等级对应的额外奖励', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZWJZJL_GOLD', '植物捐赠金币奖励', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZWJZJL_NL', '植物捐赠奖励(能量奖励)', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_ZZ_ZJYY', '增加种子原因', null, '1', null, null, null, null);

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
-- Records of plate_code_dmz
-- ----------------------------
INSERT INTO `plate_code_dmz` VALUES ('C_JC_SF', '0', '否', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_YWZT', '0', '未完成', null, null, '1', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-01 14:31:03');
INSERT INTO `plate_code_dmz` VALUES ('C_JC_ZT', '0', '无效', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '0', '未完成', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '0', '零级', null, null, '1', '', '1', '', '2019-07-02 10:21:50', '', '2019-07-02 10:22:02');
INSERT INTO `plate_code_dmz` VALUES ('C_JC_SF', '1', '是', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_YWZT', '1', '已完成', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_JC_ZT', '1', '有效', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', '1', '兑换商品', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '1', '注册赠送', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '1', '施肥', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '1', '已完成', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '1', '一级', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '1', '系统用户', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '1', '正常', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '1', '男', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '1', '手机号码', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZJLX', '1', '身份证', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZZ_ZJYY', '1', '能量兑换（商品兑换）', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', '2', '提现', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '2', '完成一个月任务', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '2', '浇水', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '2', '二级', null, null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '2', '前端用户', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '2', '违规', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '2', '女', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '2', '微信号', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZZ_ZJYY', '2', '注册赠送', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '3', '收徒完成', null, null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '3', '沐浴阳光', null, null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '3', '三级', null, null, '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '3', 'QQ号', null, null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '4', '捐赠奖励', null, null, '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '4', '四级', null, null, '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '5', '充值', null, null, '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '6', '账户等级奖励', null, null, '6', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_DZSL_ONE', 'C_DZSL_ONE_1', '1次点赞花费金币数', '50', null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_FATHER_JL', 'C_FATHER_JL_EXT', '父账户能量奖励_额外', '0.05', '父账户能量奖励_额外', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_FATHER_JL', 'C_FATHER_JL_GD', '父账户能量奖励_固定', '100', '父账户能量奖励_固定', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_GFNLZ', 'C_GFNLZ_1', '瓜分能量值', '100000', null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_GOLD_JSYY', 'C_GOLD_JSYY_1', '点赞', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_GOLD_ZJYY', 'C_GOLD_ZJYY_1', '完成种植任务', '50', '完成种植任务', '1', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 16:34:22', null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_GOLD_ZJYY', 'C_GOLD_ZJYY_2', '平台分享好友', '1000', '平台分享好友', '2', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 16:34:55', null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_GOLD_ZJYY', 'C_GOLD_ZJYY_3', '完成植物捐赠', '500', '完成植物捐赠', '3', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 16:37:26', null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZHDJ_EXTJL', 'C_ZHDJ_EXTJL_0', '零级', '0', null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZHDJ_EXTJL', 'C_ZHDJ_EXTJL_1', '一级', '0', null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZHDJ_EXTJL', 'C_ZHDJ_EXTJL_2', '二级', '0.02', null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZHDJ_EXTJL', 'C_ZHDJ_EXTJL_3', '三级', '0.03', null, '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZHDJ_EXTJL', 'C_ZHDJ_EXTJL_4', '四级', '0.05', null, '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_1', '仙人掌', '500', null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_10', '金琥', '500', '', '10', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_2', '白刺', '500', '', '2', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:30:16');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_3', '肉苁蓉', '500', '', '3', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_4', '芦荟', '500', '', '4', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_5', '大犀角', '500', '', '5', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_6', '绿之玲', '500', '', '6', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_7', '生石花', '500', '', '7', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_8', '光棍树', '500', '', '8', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_GOLD', 'C_ZWJZJL_GOLD_9', '巨人柱', '500', '', '9', '', '1', '', '2019-07-25 14:29:27', '', '2019-07-25 14:29:27');
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_1', '仙人掌', '112', null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_10', '金琥', '121', null, '10', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_2', '白刺', '113', null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_3', '肉苁蓉', '114', null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_4', '芦荟', '115', null, '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_5', '大犀角', '116', null, '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_6', '绿之玲', '117', null, '6', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_7', '生石花', '118', null, '7', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_8', '光棍树', '119', null, '8', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_9', '巨人柱', '120', null, '9', null, '1', null, null, null, null);

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
-- Records of plate_code_xtcs
-- ----------------------------
INSERT INTO `plate_code_xtcs` VALUES ('C_DZSL_ONE', '50', '1次点赞花费金币数', '1次点赞花费金币数', '1', null, null, null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_GFNLZ', '100000', '瓜分能量值', '瓜分能量值', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 10:26:00', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 10:34:39');
INSERT INTO `plate_code_xtcs` VALUES ('C_GOLD_ZJYY_1', '50', '完成种植任务', '增加金币原因_完成种植任务', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 10:38:54', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 10:39:40');
INSERT INTO `plate_code_xtcs` VALUES ('C_GOLD_ZJYY_2', '1000', '邀请用户', '增加金币原因_邀请用户', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 10:40:16', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_GOLD_ZJYY_3', '500', '完成植物捐赠', '增加金币原因_完成植物捐赠', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 10:41:38', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZHDJ_EXTJL_1', '0', null, '账户等级对应的额外奖励_一级', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:20:24', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:13');
INSERT INTO `plate_code_xtcs` VALUES ('C_ZHDJ_EXTJL_2', '0.02', null, '账户等级对应的额外奖励_二级', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:02', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:20');
INSERT INTO `plate_code_xtcs` VALUES ('C_ZHDJ_EXTJL_3', '0.03', null, '账户等级对应的额外奖励_三级', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:55', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:22:05');
INSERT INTO `plate_code_xtcs` VALUES ('C_ZHDJ_EXTJL_4', '0.05', null, '账户等级对应的额外奖励', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:22:30', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_1', '112', null, '植物捐赠奖励_仙人掌', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:23:06', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_10', '121', null, '植物捐赠奖励_金琥', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:19:09', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_2', '113', null, '植物捐赠奖励_白刺', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:25:37', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:56:10');
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_3', '114', null, '植物捐赠奖励_肉苁蓉', '0', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:15:25', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_4', '115', null, '植物捐赠奖励_芦荟', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:04', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_5', '116', null, '植物捐赠奖励_大犀角', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:03', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_6', '117', null, '植物捐赠奖励_绿之玲', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:25', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_7', '118', null, '植物捐赠奖励_生石花', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:45', null, null);
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_8', '119', null, '植物捐赠奖励_光棍树', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:02', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:40');
INSERT INTO `plate_code_xtcs` VALUES ('C_ZWJZJL_9', '120', null, '植物捐赠奖励_巨人柱', '', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:18', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:49');

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
-- Records of plate_log
-- ----------------------------
INSERT INTO `plate_log` VALUES ('01adafb25a454b5c887c6fa0dd4acdfc', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:44:39', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:44:39', null, null);
INSERT INTO `plate_log` VALUES ('02c852da6b1447c295fe278fbca0d491', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:39', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1563853119376,\"dRwsj\":1563853119376}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:39', null, null);
INSERT INTO `plate_log` VALUES ('04de41c8cd9f47698ac59a9c95a645fa', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:37', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cZt\":\"1\",\"dCjsj\":1563853416602,\"dRwsj\":1563853416602}]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:37', null, null);
INSERT INTO `plate_log` VALUES ('0752fa46f3ff4a1aaa0ae8d3baf11a4a', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:30', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_大犀角\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_GOLD_ZJYY_5\",\"cValue\":\"116\",\"cZt\":\"\",\"dCjsj\":1564020989868}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:30', null, null);
INSERT INTO `plate_log` VALUES ('0a2ae76346c8421b9b50d28c845f482e', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:31:16', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:31:16', null, null);
INSERT INTO `plate_log` VALUES ('0c8e92d90f4e456891797bd11082d45d', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:36:28', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:36:28', null, null);
INSERT INTO `plate_log` VALUES ('10e4b770f4444b6e80a845ea879e1061', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:45:20', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:45:20', null, null);
INSERT INTO `plate_log` VALUES ('1597382479eb43ba82e1389bc11b7cc0', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:02', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"光棍树\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_8\",\"cValue\":\"119\",\"cZt\":\"\",\"dCjsj\":1564021082197}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:02', null, null);
INSERT INTO `plate_log` VALUES ('1656c4b33e584367bb8b87cef3a78777', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:13', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateCodeXtcs', '[{\"cBz\":\"账户等级对应的额外奖励_一级\",\"cKey\":\"C_ZHDJ_EXTJL_1\",\"cValue\":\"0\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:13', null, null);
INSERT INTO `plate_log` VALUES ('184f9cdf860742ada2c3ff23618333f7', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:12:34', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"2\"}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:12:34', null, null);
INSERT INTO `plate_log` VALUES ('1932194490d0447c92d909cecbcc9f05', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:27:25', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-22\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563784045227,\"dRwsj\":1563784045227}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:27:25', null, null);
INSERT INTO `plate_log` VALUES ('1ad3453e2bdb490e919fddbccc8faec0', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-24 10:21:49', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"1\"]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-24 10:21:49', null, null);
INSERT INTO `plate_log` VALUES ('1b096ddd99e44aada941b56c3cf18bb1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:25:38', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_白刺\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_2\",\"cValue\":\"112\",\"cZt\":\"\",\"dCjsj\":1563949537393}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:25:38', null, null);
INSERT INTO `plate_log` VALUES ('21411366116e4ceabbb4da4b73b07b1e', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:20:24', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"账户等级对应的额外奖励\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZHDJ_EXTJL_1\",\"cValue\":\"0\",\"cZt\":\"\",\"dCjsj\":1564021223513}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:20:24', null, null);
INSERT INTO `plate_log` VALUES ('21b442923a374aff85731cb262bd3d41', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:39:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:39:45', null, null);
INSERT INTO `plate_log` VALUES ('23c3487804884cf5b397d08c82326208', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:48', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:48', null, null);
INSERT INTO `plate_log` VALUES ('243a2428c2b942199709e8501424eade', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 09:17:18', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 09:17:18', null, null);
INSERT INTO `plate_log` VALUES ('29ab26d29c1b4808bea51761da3cebf4', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:03:08', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a30984032bea48bfa780f3c90c42583d\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a30984032bea48bfa780f3c90c42583d\",\"cZt\":\"1\",\"dCjsj\":1563865387553,\"dRwsj\":1563865387553}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:03:08', null, null);
INSERT INTO `plate_log` VALUES ('29eeae95383d4eedba62ae88e08a5538', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563851084820,\"dRwsj\":1563851084820}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:45', null, null);
INSERT INTO `plate_log` VALUES ('2a50864eed8a415db3ba14ba5c811525', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:29:58', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-22\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563784197906,\"dRwsj\":1563784197906}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:29:58', null, null);
INSERT INTO `plate_log` VALUES ('2b10b78b2f9243218ff419051cf7c323', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:46', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563851086141,\"dRwsj\":1563851086141}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:46', null, null);
INSERT INTO `plate_log` VALUES ('30b93f3389f9438e8291db2691bd5618', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:55', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"账户对应的额外奖励_三级\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZHDJ_EXTJL_3\",\"cValue\":\"0.03\",\"cZt\":\"\",\"dCjsj\":1564021314903}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:55', null, null);
INSERT INTO `plate_log` VALUES ('3852476ece1d46ad80babbcc48219bbe', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:33', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cZt\":\"1\",\"dCjsj\":1563853232894,\"dRwsj\":1563853232894}]', null, null, '127.0.0.1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:33', null, null);
INSERT INTO `plate_log` VALUES ('3a8cf51132f2447aad703e11e82372a2', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 14:44:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"d1ced7a70be3489a9f6c01b2c252338d\",\"1\"]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 14:44:36', null, null);
INSERT INTO `plate_log` VALUES ('3bc68036dee04e84a158c3413be369f1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 14:40:44', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"d1ced7a70be3489a9f6c01b2c252338d\",\"1\"]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 14:40:44', null, null);
INSERT INTO `plate_log` VALUES ('3dcccd0c95e64250b4103d447a5fb892', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:43:47', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:43:47', null, null);
INSERT INTO `plate_log` VALUES ('43219275822a478889ace7b57a3fcbe1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:53', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cZt\":\"1\",\"dCjsj\":1563853012615,\"dRwsj\":1563853012615}]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:53', null, null);
INSERT INTO `plate_log` VALUES ('44b6c0a276f24d908b4e55ed3b37b8da', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:06:33', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"3\"}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:06:33', null, null);
INSERT INTO `plate_log` VALUES ('46979d2c92d74162870f227a12a9d0d9', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:49', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:49', null, null);
INSERT INTO `plate_log` VALUES ('46cfa8a92dfd4196b53a6eda8f8fc688', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 14:37:46', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"d1ced7a70be3489a9f6c01b2c252338d\",\"1\"]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 14:37:46', null, null);
INSERT INTO `plate_log` VALUES ('487a6aaee2cb4d7f841c55660207b46d', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:22:30', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"账户等级对应的额外奖励\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZHDJ_EXTJL_4\",\"cValue\":\"0.05\",\"cZt\":\"\",\"dCjsj\":1564021349657}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:22:30', null, null);
INSERT INTO `plate_log` VALUES ('4898a0fd05844453a3559f22912dae05', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:38:24', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:38:24', null, null);
INSERT INTO `plate_log` VALUES ('49560469788540868207fa5691b78513', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:08:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:08:12', null, null);
INSERT INTO `plate_log` VALUES ('4a0297051dd5476cab6748d663dc24cc', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:23:06', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_仙人掌\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_1\",\"cValue\":\"112\",\"cZt\":\"1\",\"dCjsj\":1563949386372}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:23:07', null, null);
INSERT INTO `plate_log` VALUES ('4a1c689bd1394663a5c20a14156bba87', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:00:47', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cZt\":\"1\",\"dCjsj\":1563850846646,\"dRwsj\":1563850846646}]', null, null, '127.0.0.1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:00:47', null, null);
INSERT INTO `plate_log` VALUES ('52fc31542c48464bab609cfac36ea198', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:48', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-25\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1564025988059,\"dRwsj\":1564025988059}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:48', null, null);
INSERT INTO `plate_log` VALUES ('533574f81592401fbdd46eede871ba91', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:54', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cZt\":\"1\",\"dCjsj\":1563853013603,\"dRwsj\":1563853013603}]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:54', null, null);
INSERT INTO `plate_log` VALUES ('538a01b3b5d74d93af26a5f9a51b3a70', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:02', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"账户等级对应的额外奖励——二级\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZHDJ_EXTJL_2\",\"cValue\":\"0.02\",\"cZt\":\"\",\"dCjsj\":1564021262092}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:02', null, null);
INSERT INTO `plate_log` VALUES ('5478f9286388497b8cda99b858f4135e', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34', null, null);
INSERT INTO `plate_log` VALUES ('551e655f7473416fb0891eb180e1abe7', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cZt\":\"1\",\"dCjsj\":1563853415402,\"dRwsj\":1563853415402}]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:36', null, null);
INSERT INTO `plate_log` VALUES ('56efdf44d27c46e089f2a2dd176da0ce', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:32', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cZt\":\"1\",\"dCjsj\":1563853231626,\"dRwsj\":1563853231626}]', null, null, '127.0.0.1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:32', null, null);
INSERT INTO `plate_log` VALUES ('574ecb6752a54b6095a6aa4da5b60f05', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:53', 'D', 'com.greenplatform.service.plateImpl.PlateServiceImpl.delPlateCodeDmz', '[{\"cDm\":\"c_test_1\",\"cDmlb\":\"C_TEST\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:53', null, null);
INSERT INTO `plate_log` VALUES ('59cb16c7807d4c2c9c7208fbe9923bc5', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:24:54', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cEmail\":\"123@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"zhangsan\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cUsername\":\"kAH20G\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563783894308},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563783881040,\"id\":\"E2FC94B3EE1646602716636C01460A30\",\"lastAccessedTime\":1563783887574,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:24:55', null, null);
INSERT INTO `plate_log` VALUES ('5d690895330f4c2d87b332a6b0f8cae5', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 10:45:17', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 10:45:17', null, null);
INSERT INTO `plate_log` VALUES ('5f294fade688466d8ccd0adad07c8e80', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:45', 'D', 'com.greenplatform.service.plateImpl.PlateServiceImpl.delPlateCodeXtcs', '[{\"cKey\":\"C_GOLD_ZJYY_5\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:45', null, null);
INSERT INTO `plate_log` VALUES ('6cd37784875948cdb5935eb16e0118db', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:14', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cEmail\":\"5671@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"chensan\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cUsername\":\"M704JH\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563850033454},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850023857,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:14', null, null);
INSERT INTO `plate_log` VALUES ('6e0f419698a04e60881888e3fb9ed722', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:51', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cZt\":\"1\",\"dCjsj\":1563853011387,\"dRwsj\":1563853011387}]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:51', null, null);
INSERT INTO `plate_log` VALUES ('6f664b56e59f4d30a97a8f19e73b8961', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:46', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_生石花\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_7\",\"cValue\":\"118\",\"cZt\":\"\",\"dCjsj\":1564021065411}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:46', null, null);
INSERT INTO `plate_log` VALUES ('7173a2ce1ca04b8fb2a3d421fac1c5b3', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:25', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_绿之玲\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_6\",\"cValue\":\"117\",\"cZt\":\"\",\"dCjsj\":1564021044759}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:25', null, null);
INSERT INTO `plate_log` VALUES ('73df47e2c0d847d3bb737bacb110a4e8', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-25\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1564025975719,\"dRwsj\":1564025975719}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:36', null, null);
INSERT INTO `plate_log` VALUES ('74ffd6d08cc04c28b4ce7650335dd8a2', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:22:06', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateCodeXtcs', '[{\"cBz\":\"账户等级对应的额外奖励_三级\",\"cKey\":\"C_ZHDJ_EXTJL_3\",\"cValue\":\"0.03\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:22:06', null, null);
INSERT INTO `plate_log` VALUES ('778df7765d804d3baa3e7afa5073f921', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:42', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:42', null, null);
INSERT INTO `plate_log` VALUES ('7d2a2a4d1d3c40638927abbc07f945be', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:36:25', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-25\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1564025784825,\"dRwsj\":1564025784825}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:36:25', null, null);
INSERT INTO `plate_log` VALUES ('8168c9e38f1f46c78d772fb5c38d1f39', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:31', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cEmail\":\"1271826981@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"wangqiqi\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"215f8371c18a422fbb9a94971e1b2b8a\",\"cUsername\":\"YTPo0J\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563850050840},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850037902,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:31', null, null);
INSERT INTO `plate_log` VALUES ('830d1fa3fc66462bae881a0b500bcacd', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 10:40:03', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 10:40:04', null, null);
INSERT INTO `plate_log` VALUES ('83d4c7f4bfb54d13a4d930b31a110552', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:41', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-22\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563784241068,\"dRwsj\":1563784241068}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:41', null, null);
INSERT INTO `plate_log` VALUES ('8409e177193146c7b3ee2e654f114652', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:03', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_大犀角\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_5\",\"cValue\":\"116\",\"cZt\":\"\",\"dCjsj\":1564021023107}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:17:03', null, null);
INSERT INTO `plate_log` VALUES ('841ae4afdca6447899db78878cc3e249', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:03:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:03:36', null, null);
INSERT INTO `plate_log` VALUES ('84d08f2765d44e53ab0676de03209dd6', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:46:48', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cEmail\":\"567@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"zhaoliu\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cUsername\":\"i1d0KN\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563850008090},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563849997017,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:46:48', null, null);
INSERT INTO `plate_log` VALUES ('874957476f124dbc8235305e6a1de3d0', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:45', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updYwjcdm', '[{\"cDmlb\":\"C_TEST\",\"cDmlbmc\":\"测试\",\"cZt\":\"\"},{\"cDm\":\"c_test_1\",\"cDmlb\":\"C_TEST\",\"cDmmc\":\"测试1\",\"cDmz\":\"200\",\"cSort\":\"\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:45', null, null);
INSERT INTO `plate_log` VALUES ('876fd5de1d614757bbac3ce613fc0f8e', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:15:06', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_肉苁蓉\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_2\",\"cValue\":\"114\",\"cZt\":\"0\",\"dCjsj\":1564020905779}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:15:06', null, null);
INSERT INTO `plate_log` VALUES ('9255b8b872204f1d8ce9213f5063aaeb', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:06:29', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:06:29', null, null);
INSERT INTO `plate_log` VALUES ('992ee10cac23409c9363993bba368664', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:56:37', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:56:37', null, null);
INSERT INTO `plate_log` VALUES ('9cd38dba93da4a3392f6c82cbeef66fe', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:30', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-22\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563784229916,\"dRwsj\":1563784229916}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:30', null, null);
INSERT INTO `plate_log` VALUES ('a52afd5e45bd42bb9595a6221a0316c9', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:20', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateCodeXtcs', '[{\"cBz\":\"账户等级对应的额外奖励_二级\",\"cKey\":\"C_ZHDJ_EXTJL_2\",\"cValue\":\"0.02\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:21:20', null, null);
INSERT INTO `plate_log` VALUES ('a827d2590ba046fdbfb67fbd3da0c825', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19', null, null);
INSERT INTO `plate_log` VALUES ('aba263d0094a4884a7f0709ad29ed348', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:56', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"2\"}]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:56', null, null);
INSERT INTO `plate_log` VALUES ('abbc3dad3eba4a4197c99d7d053f0130', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:47:49', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"b14accddacd944e696ab72107cd93717\",\"cEmail\":\"56711@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"zhouba\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"b14accddacd944e696ab72107cd93717\",\"cUsername\":\"CJdCYK\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563850068644},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850065486,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:47:49', null, null);
INSERT INTO `plate_log` VALUES ('abe414968c1245d1bc0b1105f52ab259', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:19:09', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_金琥\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_10\",\"cValue\":\"121\",\"cZt\":\"\",\"dCjsj\":1564021149138}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:19:09', null, null);
INSERT INTO `plate_log` VALUES ('b2a4d3094ea84b50826ad6043dd44e4a', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:59:00', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cZt\":\"1\",\"dCjsj\":1563850739690,\"dRwsj\":1563850739690}]', null, null, '127.0.0.1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:59:00', null, null);
INSERT INTO `plate_log` VALUES ('b315c2c1ae4846798e2ab2259abf9d48', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:02:52', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"1\"}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:02:52', null, null);
INSERT INTO `plate_log` VALUES ('b34e57b3e6784e8ba3231cdbfd12b855', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:57:57', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"238daa4e00cd4408b8009d38d0ee9926\",\"cZt\":\"1\",\"dCjsj\":1563850676937,\"dRwsj\":1563850676937}]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:57:57', null, null);
INSERT INTO `plate_log` VALUES ('bbd1df4bab184c8b982e91c3e9d43e79', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:45', null, null);
INSERT INTO `plate_log` VALUES ('bcd4b5565ad64abda2672bf236767e8c', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:40', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1563853120255,\"dRwsj\":1563853120255}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:40', null, null);
INSERT INTO `plate_log` VALUES ('c1855a210d404d00b5de9786748efdc0', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:26:04', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"1\"}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:26:04', null, null);
INSERT INTO `plate_log` VALUES ('c518d88afb084a26853abfbe9be5ec88', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-24 10:23:30', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"1\"]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-24 10:23:30', null, null);
INSERT INTO `plate_log` VALUES ('c70dbdaa4ee3415dbe3c0c3658901741', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:25:10', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"1\"}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:25:10', null, null);
INSERT INTO `plate_log` VALUES ('c84d5f029a154c8fbdbc0d84312bb89e', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:32', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cZt\":\"1\",\"dCjsj\":1563853232350,\"dRwsj\":1563853232350}]', null, null, '127.0.0.1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:32', null, null);
INSERT INTO `plate_log` VALUES ('c995deebc6dc4e56aa0f896911dbaeaa', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:49', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-25\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1564025989173,\"dRwsj\":1564025989173}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:49', null, null);
INSERT INTO `plate_log` VALUES ('c9b8b334837646969ca27efa325cb410', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:15:25', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_肉苁蓉\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_3\",\"cValue\":\"114\",\"cZt\":\"0\",\"dCjsj\":1564020924653}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:15:25', null, null);
INSERT INTO `plate_log` VALUES ('cb7b2220862e433489a34d5c8d6e945e', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:04', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_芦荟\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_4\",\"cValue\":\"115\",\"cZt\":\"\",\"dCjsj\":1564020963962}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:16:04', null, null);
INSERT INTO `plate_log` VALUES ('ce68d20fcbe44083b6be5188d7bd630d', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:56:10', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_白刺\",\"cKey\":\"C_ZWJZJL_2\",\"cValue\":\"113\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-24 14:56:10', null, null);
INSERT INTO `plate_log` VALUES ('cff8742651be4a3882f9592970eca267', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:45', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cEmail\":\"5671@qq.com\",\"cLoginname\":\"zhouba\",\"cPassword\":\"aaaaaa\",\"cRylb\":\"2\"},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850053080,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:45', null, null);
INSERT INTO `plate_log` VALUES ('d4db35d82a4947a285988eb130c8da21', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:45:14', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:45:14', null, null);
INSERT INTO `plate_log` VALUES ('d9e90fdc216a48f2b1baab7ac4b251ce', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:47', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"a5ec53a752bc4a25a56ae00649b6c311\",\"cZt\":\"1\",\"dCjsj\":1563851086801,\"dRwsj\":1563851086801}]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:47', null, null);
INSERT INTO `plate_log` VALUES ('db9964b9b98042709fe2225a09b3d705', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:02', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertYwjcdm', '[{\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cDmlb\":\"C_TEST\",\"cDmlbmc\":\"测试\",\"cZt\":\"\",\"dCjsj\":1564022221843},{\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cDm\":\"c_test_1\",\"cDmlb\":\"C_TEST\",\"cDmmc\":\"测试1\",\"cDmz\":\"100\",\"cSort\":\"\",\"cZt\":\"\",\"dCjsj\":1564022221849}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:37:02', null, null);
INSERT INTO `plate_log` VALUES ('dbaa8a927f894aeea9cc2491226a5883', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 12:01:11', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 12:01:11', null, null);
INSERT INTO `plate_log` VALUES ('e4420150ed5741449c0f73e1f8046337', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:07:17', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"9\"}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:07:17', null, null);
INSERT INTO `plate_log` VALUES ('e7cbeddb479c4cdbbc3ab1c027dafe39', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cZt\":\"1\",\"dCjsj\":1563851051408,\"dRwsj\":1563851051409}]', null, null, '127.0.0.1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:12', null, null);
INSERT INTO `plate_log` VALUES ('e9a5f9a5cfb34bdb8c7fcba96f5fb1e3', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:39:01', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:39:01', null, null);
INSERT INTO `plate_log` VALUES ('ea449afe5d4341029a309c3d15b4c280', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:49', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_巨人柱\",\"cKey\":\"C_ZWJZJL_9\",\"cValue\":\"120\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:49', null, null);
INSERT INTO `plate_log` VALUES ('ec54107da06d43bd86af7d553dc0eb1a', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:18', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_光棍树\",\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cKey\":\"C_ZWJZJL_9\",\"cValue\":\"120\",\"cZt\":\"\",\"dCjsj\":1564021097843}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:18', null, null);
INSERT INTO `plate_log` VALUES ('ece41abd707a4237b477bc60f8981b6f', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:12', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cEmail\":\"5167@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"zhaoritian\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"2b904bc84e6e45f98e59948708bea2c5\",\"cUsername\":\"dPt4OW\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563850092141},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850089419,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:12', null, null);
INSERT INTO `plate_log` VALUES ('edcb3b024c16464ebb5d0828628c2ad8', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-25 16:18:35', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-25 16:18:35', null, null);
INSERT INTO `plate_log` VALUES ('ee0ed0ed2ffa40b4b6574b6c85b64b3a', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:05:01', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"a30984032bea48bfa780f3c90c42583d\",\"cEmail\":\"127182681@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"zhaowu\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"a30984032bea48bfa780f3c90c42583d\",\"cUsername\":\"091vVR\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563861901267},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563861021558,\"id\":\"C17606B13D3BAE320E859F7522FB6DD6\",\"lastAccessedTime\":1563861881490,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:05:01', null, null);
INSERT INTO `plate_log` VALUES ('f1d9ebcbe9f14a9c98aca54c26b322c9', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:42:14', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:42:14', null, null);
INSERT INTO `plate_log` VALUES ('f1e3bec900c7426bbe13a1e146544631', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:48:09', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cEmail\":\"567@qq.com\",\"cLoginname\":\"zhaoritian\",\"cPassword\":\"aaaaaa\",\"cRylb\":\"2\"},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850071043,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:48:09', null, null);
INSERT INTO `plate_log` VALUES ('f456f6aeeb5f401fa40403fb7fb2f5d0', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38', null, null);
INSERT INTO `plate_log` VALUES ('f5ea46c29fa343d3b87467561635f6a9', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:40', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateCodeXtcs', '[{\"cBz\":\"植物捐赠奖励_光棍树\",\"cKey\":\"C_ZWJZJL_8\",\"cValue\":\"119\",\"cZt\":\"\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-25 10:18:40', null, null);
INSERT INTO `plate_log` VALUES ('f8837660567e47ac80311d0fe050c97c', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55', null, null);
INSERT INTO `plate_log` VALUES ('f9530c1709cf4da8924c0f5388edf6ba', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:15', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cEmail\":\"5671@qq.com\",\"cLoginname\":\"chensan\",\"cPassword\":\"aaaaaa\",\"cRylb\":\"2\"},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850033556,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:15', null, null);
INSERT INTO `plate_log` VALUES ('fad380ef8d074b82b938332d671f2c13', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:47:02', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[{\"cCjuser\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cEmail\":\"12345@qq.com\",\"cIssmz\":\"0\",\"cLoginname\":\"zhouqi\",\"cPassword\":\"0b4e7a0e5fe84ad35fb5f95b9ceeac79\",\"cRydj\":\"0\",\"cRylb\":\"2\",\"cRyxz\":\"1\",\"cRyzt\":\"1\",\"cUserid\":\"c5bfa98e53b5493e99c1ff19eb2894af\",\"cUsername\":\"lUjg4t\",\"cZcfs\":\"\",\"cZt\":\"1\",\"dCjsj\":1563850021763},{\"attributeNames\":[\"loginUser\"],\"creationTime\":1563844469180,\"id\":\"F7705229564D5311604CB4D3268A80A9\",\"lastAccessedTime\":1563850012258,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:47:02', null, null);
INSERT INTO `plate_log` VALUES ('ff52abf033c043d6a96fa0b00d4f0aae', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:39', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"1b5cc1b6fb754830ae228284217f3578\",\"cRwday\":\"2019-07-23\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-07\",\"cUserid\":\"1b5cc1b6fb754830ae228284217f3578\",\"cZt\":\"1\",\"dCjsj\":1563853118566,\"dRwsj\":1563853118566}]', null, null, '127.0.0.1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:39', null, null);

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
  `c_issmz` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否实名制',
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
-- Records of plate_user
-- ----------------------------
INSERT INTO `plate_user` VALUES ('1b5cc1b6fb754830ae228284217f3578', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'chensan', '陈山', null, '1', null, '0', '2', '1', '1', '', null, null, null, null, null, null, '5671@qq.com', null, null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:13', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:49:34');
INSERT INTO `plate_user` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'wangqiqi', '王奇奇', null, '1', null, '0', '2', '1', '1', '', null, null, null, null, null, null, '1271826981@qq.com', null, null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:31', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:49:20');
INSERT INTO `plate_user` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhaoliu', '赵六', null, '1', null, '0', '2', '1', '1', '', null, null, null, null, null, null, '567@qq.com', null, null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:46:48', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:50:00');
INSERT INTO `plate_user` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhaoritian', '赵日天', null, '1', null, '0', '2', '1', '1', '', null, null, null, null, null, null, '5167@qq.com', null, null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:12', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:53');
INSERT INTO `plate_user` VALUES ('318eb9ef076446ea8b85cb8d2559fb55', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'lisi', '李四', '2', '0', null, null, '1', '1', '1', null, '1', '2', '四川省成都市', '13255555555', null, null, '123@qq.com', null, null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-02 15:00:32', '3309b23c28584179b9d69e226e3eeeee', '2019-07-02 15:01:29');
INSERT INTO `plate_user` VALUES ('3309b23c28584179b9d69e226e3eeeee', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'admin', '系统管理员', '1', '0', null, null, '1', '1', '1', '1', '1', '1212', '121212', '18328023251', '18328023251', '1271826981', '1213@qq.com', null, '测试测试', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-06-25 14:49:27', '3309b23c28584179b9d69e226e3eeeee', '2019-07-02 14:59:59');
INSERT INTO `plate_user` VALUES ('a30984032bea48bfa780f3c90c42583d', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhaowu', '赵武', null, '1', null, '0', '2', '1', '1', '', null, '500101198707082122', null, '18777777777', null, null, '127182681@qq.com', null, null, '1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:05:01', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:02:29');
INSERT INTO `plate_user` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhangsan', '张三', null, '1', null, '0', '2', '1', '1', '', null, '567802199801012111', null, '13888888888', null, null, '123@qq.com', null, null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:24:54', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 14:59:26');
INSERT INTO `plate_user` VALUES ('b14accddacd944e696ab72107cd93717', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhouba', '周拔', null, '1', null, '0', '2', '1', '1', '', null, null, null, null, null, null, '56711@qq.com', null, null, '1', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:47:49', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:49:07');
INSERT INTO `plate_user` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhouqi', '周琦', null, '1', null, '0', '2', '1', '1', '', null, null, null, null, null, null, '12345@qq.com', null, null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:47:02', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:49:47');

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
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_CSSZ', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_QXGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YWJCDM', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YYPZ', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_NLGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_RWGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_SPGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_STGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_ZHDJGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:36:07', null, null);

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
INSERT INTO `plate_user_role` VALUES ('c_webUser', '前端用户', '0', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 11:57:57');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户实名制后用户正式表';

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
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_CSSZ', '系统配置_系统参数设置', '系统参数设置', '/base/xtcssz', '4', '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-17 09:35:48');
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_QXGL', '系统配置_权限管理', '权限管理', '/base/qxgl', '3', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YHGL', '系统配置_用户管理', '用户管理', '/base/plateYhgl', '2', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YWJCDM', '系统配置_业务基础代码管理', '业务基础代码管理', '/base/ywjcdm', '2', '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 14:08:24');
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YYPZ', '系统配置_应用配置', '应用配置', '/base/yypz', '5', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_NLGL', '业务功能_能量管理', '能量管理', '/base/nlgl', '2', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_RWGL', '业务功能_任务管理', '任务管理', '/base/rwgl', '3', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_SPGL', '业务功能_商品管理', '商品管理', '/base/spgl', '4', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_STGL', '业务功能_收徒管理', '收徒管理', '/base/stgl', '5', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_YHGL', '业务功能_前端用户管理', '前端用户管理', '/base/yhgl', '1', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_ZHDJGL', '业务功能_账户等级管理', '账户等级管理', '/base/zhsjgl', '6', '1', null, null, null, null);

-- ----------------------------
-- Table structure for t_green_gold_dzhz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzhz`;
CREATE TABLE `t_green_gold_dzhz` (
  `c_userid` varchar(255) NOT NULL,
  `n_dzzl` decimal(8,4) DEFAULT NULL COMMENT '点赞总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币点赞数汇总';

-- ----------------------------
-- Records of t_green_gold_dzhz
-- ----------------------------
INSERT INTO `t_green_gold_dzhz` VALUES ('1b5cc1b6fb754830ae228284217f3578', '2.0000', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:42', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:43:47');
INSERT INTO `t_green_gold_dzhz` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '1.0000', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55');
INSERT INTO `t_green_gold_dzhz` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '1.0000', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38');
INSERT INTO `t_green_gold_dzhz` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '1.0000', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19');
INSERT INTO `t_green_gold_dzhz` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '2.0000', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:31:16', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:49');
INSERT INTO `t_green_gold_dzhz` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '1.0000', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34');

-- ----------------------------
-- Table structure for t_green_gold_dzmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_dzmx`;
CREATE TABLE `t_green_gold_dzmx` (
  `c_lsh` varchar(255) NOT NULL,
  `c_userid` varchar(255) NOT NULL,
  `n_dzsl` decimal(8,4) DEFAULT NULL COMMENT '点赞数量',
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
-- Records of t_green_gold_dzmx
-- ----------------------------
INSERT INTO `t_green_gold_dzmx` VALUES ('3d511603c32f422382931194617815c6', '1b5cc1b6fb754830ae228284217f3578', '1.0000', '2019-07-25 11:43:47', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:43:47', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('3dba7ff925304b00b85e82b9ebad6217', '238daa4e00cd4408b8009d38d0ee9926', '1.0000', '2019-07-23 11:43:38', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('5a33c8b28f8c442c89e030dfb2bad15b', '2b904bc84e6e45f98e59948708bea2c5', '1.0000', '2019-07-23 11:04:19', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('757346df195845f6830705b4713aa416', 'a5ec53a752bc4a25a56ae00649b6c311', '1.0000', '2019-07-22 16:31:16', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:31:16', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('91309a52ea67435bb58b693d4b07db35', 'c5bfa98e53b5493e99c1ff19eb2894af', '1.0000', '2019-07-23 11:40:34', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('bf335f1e227d40498a3a8c3dd642b169', '1b5cc1b6fb754830ae228284217f3578', '1.0000', '2019-07-23 11:38:42', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:42', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('ce19d30a574a4401b19937397343bfa1', 'a5ec53a752bc4a25a56ae00649b6c311', '1.0000', '2019-07-23 11:04:49', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:49', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('cf724c707596434481c330e4b9aa6d55', '215f8371c18a422fbb9a94971e1b2b8a', '1.0000', '2019-07-23 11:36:55', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55', null, null);

-- ----------------------------
-- Table structure for t_green_gold_hz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_hz`;
CREATE TABLE `t_green_gold_hz` (
  `c_userid` varchar(255) NOT NULL,
  `n_jbzl` decimal(8,4) DEFAULT NULL COMMENT '金币总量',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户金币汇总';

-- ----------------------------
-- Records of t_green_gold_hz
-- ----------------------------
INSERT INTO `t_green_gold_hz` VALUES ('1b5cc1b6fb754830ae228284217f3578', '0.0000', null, '1', null, '2019-07-23 11:38:39', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:43:47');
INSERT INTO `t_green_gold_hz` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '0.0000', null, '1', null, '2019-07-23 11:36:51', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55');
INSERT INTO `t_green_gold_hz` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '0.0000', null, '1', null, '2019-07-23 10:57:57', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38');
INSERT INTO `t_green_gold_hz` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '0.0000', null, '1', null, '2019-07-23 10:59:00', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19');
INSERT INTO `t_green_gold_hz` VALUES ('a30984032bea48bfa780f3c90c42583d', '0.0000', null, '1', null, '2019-07-23 15:03:08', null, null);
INSERT INTO `t_green_gold_hz` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '0.0000', null, '1', null, '2019-07-22 16:29:58', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:49');
INSERT INTO `t_green_gold_hz` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '0.0000', null, '1', null, '2019-07-23 11:40:32', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34');

-- ----------------------------
-- Table structure for t_green_gold_jsmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_jsmx`;
CREATE TABLE `t_green_gold_jsmx` (
  `c_lsh` varchar(255) NOT NULL,
  `c_userid` varchar(255) NOT NULL,
  `n_jssl` decimal(8,4) DEFAULT NULL COMMENT '减少数量',
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
-- Records of t_green_gold_jsmx
-- ----------------------------
INSERT INTO `t_green_gold_jsmx` VALUES ('02020112aa1e4315923673c49656801b', '2b904bc84e6e45f98e59948708bea2c5', '50.0000', '2019-07-23 11:04:19', '1', '点赞', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:19', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('3faaa385fb0d4aa7a9a50abfbe87409e', 'a5ec53a752bc4a25a56ae00649b6c311', '50.0000', null, '1', '点赞', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:31:16', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('511e42e1daa04ffc874f80efbf2a4053', '215f8371c18a422fbb9a94971e1b2b8a', '50.0000', '2019-07-23 11:36:55', '1', '点赞', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:55', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('6a5d034fd186462ebc1f8b899eff409b', '238daa4e00cd4408b8009d38d0ee9926', '50.0000', '2019-07-23 11:43:38', '1', '点赞', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:38', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('8f778cd7836e43048615ea433a596762', 'a5ec53a752bc4a25a56ae00649b6c311', '50.0000', '2019-07-23 11:04:49', '1', '点赞', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:49', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('a0c020b3ce9742729969f411523daba6', '1b5cc1b6fb754830ae228284217f3578', '50.0000', '2019-07-25 11:43:47', '1', '点赞', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:43:47', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('bbe9dde19dab4c988433b653cb8056ed', 'c5bfa98e53b5493e99c1ff19eb2894af', '50.0000', '2019-07-23 11:40:34', '1', '点赞', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:34', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('fef6847ba6ac4c7a9c3d074f950d0ebb', '1b5cc1b6fb754830ae228284217f3578', '50.0000', '2019-07-23 11:38:42', '1', '点赞', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:42', null, null);

-- ----------------------------
-- Table structure for t_green_gold_zjmx
-- ----------------------------
DROP TABLE IF EXISTS `t_green_gold_zjmx`;
CREATE TABLE `t_green_gold_zjmx` (
  `c_lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作业务流水号',
  `c_userid` varchar(255) NOT NULL,
  `n_zjsl` decimal(8,4) DEFAULT NULL COMMENT '增加数量',
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
-- Records of t_green_gold_zjmx
-- ----------------------------
INSERT INTO `t_green_gold_zjmx` VALUES ('139a00b4589748e2b2c45a090d2c0b87', '215f8371c18a422fbb9a94971e1b2b8a', '50.0000', '2019-07-23 11:36:54', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:54', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('46f0140da5364bf6904ce03a8888cee9', '1b5cc1b6fb754830ae228284217f3578', '50.0000', '2019-07-23 11:38:40', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:40', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('4feab66c91e2401c8ae587666aa00465', '1b5cc1b6fb754830ae228284217f3578', '50.0000', '2019-07-25 11:39:49', 'C_GOLD_ZJYY_1', null, null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:49', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('7cc4c73fc07846f1ad2697c650aebb0f', 'c5bfa98e53b5493e99c1ff19eb2894af', '50.0000', '2019-07-23 11:40:33', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:33', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('a7df0c29542043a79ede9690d24cca50', '2b904bc84e6e45f98e59948708bea2c5', '50.0000', '2019-07-23 11:04:11', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:11', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('ce95470f971249c188d4a014c543e7c6', 'a5ec53a752bc4a25a56ae00649b6c311', '50.0000', '2019-07-23 11:04:47', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:47', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('d72b3228268a4ac5ad236ebcc19d2602', 'a5ec53a752bc4a25a56ae00649b6c311', '50.0000', '2019-07-22 16:30:41', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:41', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('dd5d6d710f5b448fbff27770a311b156', '238daa4e00cd4408b8009d38d0ee9926', '50.0000', '2019-07-23 11:43:37', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:37', null, null);

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
INSERT INTO `t_green_nl_hz` VALUES ('1b5cc1b6fb754830ae228284217f3578', '0.0000', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:13', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:49:34');
INSERT INTO `t_green_nl_hz` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '0.0000', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:31', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:49:20');
INSERT INTO `t_green_nl_hz` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '0.0000', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:46:48', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:50:00');
INSERT INTO `t_green_nl_hz` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '0.0000', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:12', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:53');
INSERT INTO `t_green_nl_hz` VALUES ('a30984032bea48bfa780f3c90c42583d', '0.0000', null, '1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:05:01', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:02:29');
INSERT INTO `t_green_nl_hz` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '0.0000', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:24:54', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 14:59:26');
INSERT INTO `t_green_nl_hz` VALUES ('b14accddacd944e696ab72107cd93717', '0.0000', null, '1', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:47:49', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:49:07');
INSERT INTO `t_green_nl_hz` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '0.0000', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:47:02', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:49:47');

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
  `n_rwcs` int(11) DEFAULT NULL COMMENT '任务次数（一个账户同一任务一个月最多30次）',
  `n_ljwccs` int(11) DEFAULT NULL COMMENT '累计完成次数(三项任务加起来次数,不大于90次）',
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
INSERT INTO `t_green_rw_rwmx` VALUES ('1b5cc1b6fb754830ae228284217f3578', '1', '2019-07-23', '2019-07', '2019-07-23 11:38:39', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:39', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('1b5cc1b6fb754830ae228284217f3578', '1', '2019-07-25', '2019-07', '2019-07-25 11:39:36', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:36', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('1b5cc1b6fb754830ae228284217f3578', '2', '2019-07-23', '2019-07', '2019-07-23 11:38:40', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:40', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('1b5cc1b6fb754830ae228284217f3578', '2', '2019-07-25', '2019-07', '2019-07-25 11:39:49', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:49', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('1b5cc1b6fb754830ae228284217f3578', '3', '2019-07-23', '2019-07', '2019-07-23 11:38:39', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 11:38:39', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('1b5cc1b6fb754830ae228284217f3578', '3', '2019-07-25', '2019-07', '2019-07-25 11:39:48', null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-25 11:39:48', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '1', '2019-07-23', '2019-07', '2019-07-23 11:36:54', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:54', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '2', '2019-07-23', '2019-07', '2019-07-23 11:36:53', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:53', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('215f8371c18a422fbb9a94971e1b2b8a', '3', '2019-07-23', '2019-07', '2019-07-23 11:36:51', null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 11:36:51', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '1', '2019-07-23', '2019-07', '2019-07-23 10:57:57', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:57:57', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '2', '2019-07-23', '2019-07', '2019-07-23 11:43:37', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:37', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('238daa4e00cd4408b8009d38d0ee9926', '3', '2019-07-23', '2019-07', '2019-07-23 11:43:35', null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 11:43:35', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '1', '2019-07-23', '2019-07', '2019-07-23 10:59:00', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:59:00', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '2', '2019-07-23', '2019-07', '2019-07-23 11:04:11', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:04:11', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('2b904bc84e6e45f98e59948708bea2c5', '3', '2019-07-23', '2019-07', '2019-07-23 11:00:47', null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 11:00:47', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a30984032bea48bfa780f3c90c42583d', '1', '2019-07-23', '2019-07', '2019-07-23 15:03:08', null, '1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:03:08', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '1', '2019-07-22', '2019-07', '2019-07-22 16:29:58', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:29:58', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '1', '2019-07-23', '2019-07', '2019-07-23 11:04:45', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:45', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '2', '2019-07-22', '2019-07', '2019-07-22 16:30:41', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:41', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '2', '2019-07-23', '2019-07', '2019-07-23 11:04:47', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:47', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '3', '2019-07-22', '2019-07', '2019-07-22 16:30:30', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:30:30', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a5ec53a752bc4a25a56ae00649b6c311', '3', '2019-07-23', '2019-07', '2019-07-23 11:04:46', null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 11:04:46', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '1', '2019-07-23', '2019-07', '2019-07-23 11:40:32', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:32', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '2', '2019-07-23', '2019-07', '2019-07-23 11:40:33', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:33', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('c5bfa98e53b5493e99c1ff19eb2894af', '3', '2019-07-23', '2019-07', '2019-07-23 11:40:32', null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 11:40:32', null, null);

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
INSERT INTO `t_green_zz_zjzzmx` VALUES ('45b04b09dc4949708dc9ff78567dddfc', 'a30984032bea48bfa780f3c90c42583d', '1', '1', '2019-07-23 14:05:01', '0', '0', null, null, '1', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 14:05:01', 'a30984032bea48bfa780f3c90c42583d', '2019-07-23 15:02:29');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('495329c950d74e1ea8af2b4e40d94f62', '238daa4e00cd4408b8009d38d0ee9926', '1', '1', '2019-07-23 10:46:48', '0', '0', null, null, '1', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:46:48', '238daa4e00cd4408b8009d38d0ee9926', '2019-07-23 10:50:00');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('4cd79c1575344765854b49716e2caa51', 'c5bfa98e53b5493e99c1ff19eb2894af', '1', '1', '2019-07-23 10:47:02', '0', '0', null, null, '1', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:47:02', 'c5bfa98e53b5493e99c1ff19eb2894af', '2019-07-23 10:49:47');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('97627fc5ca7d43a5bd94ca6bb9f3a450', '2b904bc84e6e45f98e59948708bea2c5', '1', '1', '2019-07-23 10:48:12', '0', '0', null, null, '1', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:12', '2b904bc84e6e45f98e59948708bea2c5', '2019-07-23 10:48:53');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('ae1448f43e4741379f8333d5cb2c1c0f', 'b14accddacd944e696ab72107cd93717', '1', '1', '2019-07-23 10:47:49', '0', '0', null, null, '1', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:47:49', 'b14accddacd944e696ab72107cd93717', '2019-07-23 10:49:07');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('d1ced7a70be3489a9f6c01b2c252338d', '1b5cc1b6fb754830ae228284217f3578', '1', '1', '2019-07-23 10:47:13', '0', '0', null, null, '1', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:47:13', '1b5cc1b6fb754830ae228284217f3578', '2019-07-23 10:49:34');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('e6579646615d43b18c825f3c83a4358e', '215f8371c18a422fbb9a94971e1b2b8a', '1', '1', '2019-07-23 10:47:31', '0', '0', null, null, '1', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:47:31', '215f8371c18a422fbb9a94971e1b2b8a', '2019-07-23 10:49:20');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('f6054bf477fb4ec892aed25639f722f2', 'a5ec53a752bc4a25a56ae00649b6c311', '1', '1', '2019-07-22 16:24:54', '0', '0', null, null, '1', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-22 16:24:54', 'a5ec53a752bc4a25a56ae00649b6c311', '2019-07-23 14:59:26');
