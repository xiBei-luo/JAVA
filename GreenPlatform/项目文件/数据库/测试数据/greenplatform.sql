/*
Navicat MySQL Data Transfer

Source Server         : GreenPlatform
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : greenplatform

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-09-02 17:26:39
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
INSERT INTO `plate_code_dmlb` VALUES ('C_NLCZ_ZFFS', '能量充值支付方式', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-13 15:43:42', null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_DZGF', '金币点赞活动根据排名瓜分能量', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_JSYY', '能量减少原因', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_NL_ZJYY', '能量增加原因', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_RWLB', '任务类别', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmlb` VALUES ('C_RW_YWZT', '业务状态', null, '1', null, null, null, null);
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
INSERT INTO `plate_code_dmz` VALUES ('C_NLCZ_ZFFS', '1', '微信支付', '', null, '1', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-13 15:43:42', null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '1', '施肥', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_YWZT', '1', '已完成', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '1', '一级', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '1', '系统用户', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '1', '正常', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '1', '男', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '1', '手机号码', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZJLX', '1', '身份证', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZZ_ZJYY', '1', '能量兑换（商品兑换）', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NLCZ_ZFFS', '2', '支付宝支付', '', null, '', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-13 15:44:08', null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', '2', '完成一个月任务', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_RW_RWLB', '2', '浇水', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYDJ', '2', '二级', null, null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYLB', '2', '前端用户', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_RYZT', '2', '违规', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_SEX', '2', '女', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_USER_ZCFS', '2', '微信号', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZZ_ZJYY', '2', '注册赠送', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NLCZ_ZFFS', '3', '银行卡支付', '', null, '3', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-13 15:45:08', null, null);
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
INSERT INTO `plate_code_dmz` VALUES ('C_GOLD_ZJYY', 'C_GOLD_ZJYY_4', '金币点赞活动奖励金币', null, '金币点赞瓜分能量_奖励金币', '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_DZGF', 'C_NL_DZGF_1', '第一名', '88', '金币点赞瓜分能量_第一名', '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_DZGF', 'C_NL_DZGF_11-50', '第11至50名', '8', '金币点赞瓜分能量_第十一至五十名', '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_DZGF', 'C_NL_DZGF_2', '第二名', '58', '金币点赞瓜分能量_第二名', '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_DZGF', 'C_NL_DZGF_3', '第三名', '38', '金币点赞瓜分能量_第三名', '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_DZGF', 'C_NL_DZGF_4-10', '第4至10名', '18', '金币点赞瓜分能量_第四至十名', '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_DZGF', 'C_NL_DZGF_51-100', '第51至100名', null, '金币点赞瓜分能量_第五十一至一百名', '6', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', 'C_NL_JSYY_1', '兑换商品', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_JSYY', 'C_NL_JSYY_2', '提现', null, null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', 'C_NL_ZJYY_1', '注册赠送', null, null, '1', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', 'C_NL_ZJYY_2', '徒弟完成捐赠任务', null, null, '7', null, null, null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_NL_ZJYY', 'C_NL_ZJYY_3', '点赞活动瓜分能量', null, null, null, null, '1', null, null, null, null);
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
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_10', '金琥', '112000', null, '10', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_2', '白刺', '336', null, '2', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_3', '肉苁蓉', '560', null, '3', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_4', '芦荟', '1120', null, '4', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_5', '大犀角', '3360', null, '5', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_6', '绿之玲', '5600', null, '6', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_7', '生石花', '11200', null, '7', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_8', '光棍树', '33600', null, '8', null, '1', null, null, null, null);
INSERT INTO `plate_code_dmz` VALUES ('C_ZWJZJL_NL', 'C_ZWJZJL_NL_9', '巨人柱', '56000', null, '9', null, '1', null, null, null, null);

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
INSERT INTO `plate_log` VALUES ('022215fea23b4ccc9d6b6824b7a53f0c', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:29:10', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063749899,\"dRwsj\":1567063749899}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:29:10', null, null);
INSERT INTO `plate_log` VALUES ('0275228efdb94afbad665c36bfa85974', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:24:44', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"aee52760658d49b0bafb298bc171eb68\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"aee52760658d49b0bafb298bc171eb68\",\"cZt\":\"1\",\"dCjsj\":1567070683509,\"dRwsj\":1567070683509}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:24:44', null, null);
INSERT INTO `plate_log` VALUES ('02b02d4194a3475c83317a9cc8f44b44', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 16:56:20', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cKjz\":\"0\",\"cLsh\":\"a974071f0ede4cab8296557fa5382804\",\"cSfjz\":\"0\",\"cSpbh\":\"1\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZjyy\":\"1\",\"cZt\":\"1\",\"dCjsj\":1567155379460,\"dZjsj\":1567155379460}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 16:56:20', null, null);
INSERT INTO `plate_log` VALUES ('02fe3476c26641318234d5659652dbe3', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:22', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"441d1b15644a42ffb6670cdf4e0abca1\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"441d1b15644a42ffb6670cdf4e0abca1\",\"cZt\":\"1\",\"dCjsj\":1566873681595,\"dRwsj\":1566873681595}]', null, null, '0:0:0:0:0:0:0:1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:22', null, null);
INSERT INTO `plate_log` VALUES ('03fcdc28552d466ba4c4f15a49516535', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:18:07', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"3\"}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:18:07', null, null);
INSERT INTO `plate_log` VALUES ('0458dc83e7b44c4e8ad86453f0691eeb', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:25:41', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"aee52760658d49b0bafb298bc171eb68\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"aee52760658d49b0bafb298bc171eb68\",\"cZt\":\"1\",\"dCjsj\":1567070740551,\"dRwsj\":1567070740551}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:25:41', null, null);
INSERT INTO `plate_log` VALUES ('06ac42877bc043ff8421505d2ecd703d', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:22:32', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063351486,\"dRwsj\":1567063351486}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:22:32', null, null);
INSERT INTO `plate_log` VALUES ('06ee1ef2c0a04517bd6c16a654bc7496', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:42', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"06d4d91d9e6047febae59a017c135b91\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"06d4d91d9e6047febae59a017c135b91\",\"cZt\":\"1\",\"dCjsj\":1567066061931,\"dRwsj\":1567066061931}]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:42', null, null);
INSERT INTO `plate_log` VALUES ('07a92e9329c944828af9c673ce8b04f9', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:03:15', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:03:15', null, null);
INSERT INTO `plate_log` VALUES ('0ed95d07ec284919a77ec4629becad8c', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:41', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567070081077,\"dRwsj\":1567070081077}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:42', null, null);
INSERT INTO `plate_log` VALUES ('0f76df51c72c4d3d94e43032580176b4', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:16:51', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063010330,\"dRwsj\":1567063010330}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:16:51', null, null);
INSERT INTO `plate_log` VALUES ('0fb1c7345ab6406686810125e79378c6', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:20:46', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"3\"}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:20:47', null, null);
INSERT INTO `plate_log` VALUES ('10c22fb7b37e43b3976f38cee360d258', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"d1c3a5e76a944392b919709509fb9cd9\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"d1c3a5e76a944392b919709509fb9cd9\",\"cZt\":\"1\",\"dCjsj\":1567048605220,\"dRwsj\":1567048605220}]', null, null, '0:0:0:0:0:0:0:1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:45', null, null);
INSERT INTO `plate_log` VALUES ('11ef1f15fa9342b0801d5ec0d63d4b3a', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);
INSERT INTO `plate_log` VALUES ('12c1804ffb5941f9b06d7abb30adb2b4', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:21:07', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"b55cbb78e1e54da7a14171c34031f692\\\",\\\"cPhone\\\":\\\"18328023251\\\",\\\"cLoginname\\\":\\\"wangwu\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"967408\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566803995162,\"id\":\"0472C865FEA835CEE4A788272BAE3C86\",\"lastAccessedTime\":1566804053011,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:21:07', null, null);
INSERT INTO `plate_log` VALUES ('155e589db872422cbd9cc662666bc0c4', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:21', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"441d1b15644a42ffb6670cdf4e0abca1\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"441d1b15644a42ffb6670cdf4e0abca1\",\"cZt\":\"1\",\"dCjsj\":1566873680939,\"dRwsj\":1566873680939}]', null, null, '0:0:0:0:0:0:0:1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:21', null, null);
INSERT INTO `plate_log` VALUES ('15a8e439a546448a9dc99acd068c3690', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:13', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:13', null, null);
INSERT INTO `plate_log` VALUES ('166265fccd9a40e79be9900d22add6fa', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:07', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1567070226949,\"dRwsj\":1567070226950}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:07', null, null);
INSERT INTO `plate_log` VALUES ('175db05428a14912aa119992da4f7d28', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:19:46', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063185847,\"dRwsj\":1567063185847}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:19:46', null, null);
INSERT INTO `plate_log` VALUES ('18da7992dea346f8b0fb5dab36ab2f09', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:36:19', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', null, null, '127.0.0.1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:36:19', null, null);
INSERT INTO `plate_log` VALUES ('1962423b497e40cf9af32aa6dc264f55', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 12:33:35', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567053214900,\"dRwsj\":1567053214900}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 12:33:35', null, null);
INSERT INTO `plate_log` VALUES ('1a4719ab8e004a49b76607d7d59d724c', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:41:08', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cPhone\\\":\\\"18328023251\\\",\\\"cLoginname\\\":\\\"luowenlv\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"110842\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566355253703,\"id\":\"A8B03600A68A45332362E1788CADC0C3\",\"lastAccessedTime\":1566355261248,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:41:09', null, null);
INSERT INTO `plate_log` VALUES ('1b32eb5e2b944cc884a72fcd4023244c', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `plate_log` VALUES ('1f67501a2cbf410e88bf2380749b805c', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:30', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"06d4d91d9e6047febae59a017c135b91\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"06d4d91d9e6047febae59a017c135b91\",\"cZt\":\"1\",\"dCjsj\":1566873689935,\"dRwsj\":1566873689935}]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:30', null, null);
INSERT INTO `plate_log` VALUES ('22707c30916c4cea98a60356943dec8e', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:07', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:07', null, null);
INSERT INTO `plate_log` VALUES ('22d3b81da3d646378b853422b1afd2e7', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:13', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567066692443,\"dRwsj\":1567066692443}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:13', null, null);
INSERT INTO `plate_log` VALUES ('28e5ffe8d3d942d9be2daec1230cf5a0', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:02', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-26\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1566786181400,\"dRwsj\":1566786181400}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:02', null, null);
INSERT INTO `plate_log` VALUES ('2e0177fd50bf46fe85154756b068e4b1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:23', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1567416143392,\"dRwsj\":1567416143392}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:23', null, null);
INSERT INTO `plate_log` VALUES ('2e5cd5f8b0924af6983625c1052ae18a', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:41', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064201150,\"dRwsj\":1567064201150}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:41', null, null);
INSERT INTO `plate_log` VALUES ('35982d09233445e8ad851b521bbd1897', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:38', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064197606,\"dRwsj\":1567064197606}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:38', null, null);
INSERT INTO `plate_log` VALUES ('3a2714de3a2c441295daba490636505f', '3309b23c28584179b9d69e226e3eeeee', '2019-08-29 14:23:51', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateUserPass', '[\"aaaaaa\"]', null, null, '0:0:0:0:0:0:0:1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-29 14:23:51', null, null);
INSERT INTO `plate_log` VALUES ('3ae3278c9aa1466484203c41ff67319c', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:21:17', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063277027,\"dRwsj\":1567063277027}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:21:17', null, null);
INSERT INTO `plate_log` VALUES ('41683fd463184333aba5aa907a3d0ad8', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"d1c3a5e76a944392b919709509fb9cd9\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"d1c3a5e76a944392b919709509fb9cd9\",\"cZt\":\"1\",\"dCjsj\":1567048604436,\"dRwsj\":1567048604436}]', null, null, '0:0:0:0:0:0:0:1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:45', null, null);
INSERT INTO `plate_log` VALUES ('43a16c050c384bf293b9efe0c1ebd7b6', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:01:13', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"563d03768ba644f2827f1afd6703ba1e\\\",\\\"cPhone\\\":\\\"13855555555\\\",\\\"cLoginname\\\":\\\"lisi\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"601171\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566543383311,\"id\":\"15A715D1103999AFD4E9E0C30506D750\",\"lastAccessedTime\":1566547266949,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:01:13', null, null);
INSERT INTO `plate_log` VALUES ('43cf862c595b4d9a8aedb625538863e4', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 14:57:03', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567407422602,\"dRwsj\":1567407422602}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 14:57:03', null, null);
INSERT INTO `plate_log` VALUES ('47609fa303d345248b8ed27c9c99526a', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:16', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064595814,\"dRwsj\":1567064595814}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:16', null, null);
INSERT INTO `plate_log` VALUES ('498994b857fa45ed9f71408cb3fd1bc4', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:08', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1567070227975,\"dRwsj\":1567070227975}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:08', null, null);
INSERT INTO `plate_log` VALUES ('4a904b29a8b6434eb0dfa0cef8227090', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:35:13', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertPlateYwLxMenu', '[{\"cCjuser\":\"3309b23c28584179b9d69e226e3eeeee\",\"cMenudm\":\"C_PLATE_ONLINE\",\"cMenujc\":\"在线用户统计\",\"cMenumc\":\"网站在线用户统计\",\"cRuncommand\":\"/base/online\",\"cSort\":\"1\",\"cYwlxdm\":\"C_PLATE\",\"cZt\":\"1\",\"dCjsj\":1566808512709}]', null, null, '0:0:0:0:0:0:0:1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:35:13', null, null);
INSERT INTO `plate_log` VALUES ('4c6cd541be5a49a1958600961503a8b9', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:13', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:13', null, null);
INSERT INTO `plate_log` VALUES ('4e886d7a4fe94e7db9752ee4e5ab2125', '3309b23c28584179b9d69e226e3eeeee', '2019-08-23 16:35:33', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertTGreenNlCzjl', '[{\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cUsername\":\"张三\",\"cZjhm\":\"500109198701012222\",\"cEmail\":\"\",\"cPhone\":\"13255555555\",\"cFkzh\":\"18328023251\",\"cFkfs\":\"1\",\"dFksj\":\"2019-08-23 16:34:55\",\"cFkyh\":\"\",\"cFkkh\":\"\",\"cFksfcg\":\"1\",\"cFkdh\":\"46546546\",\"cSkzh\":\"13255555555\",\"cSkfs\":\"1\",\"dSksj\":\"2019-08-23 16:34:59\",\"cSkyh\":\"\",\"cSkkh\":\"\",\"cSksfcg\":\"1\",\"cSkdh\":\"456464\",\"nFkje\":\"100\",\"cBz\":\"张三充值100\"}]', null, null, '127.0.0.1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-23 16:35:33', null, null);
INSERT INTO `plate_log` VALUES ('4e97dd23eee04cf9ad933c8393241507', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 16:59:10', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 16:59:10', null, null);
INSERT INTO `plate_log` VALUES ('52525b215f634cee9fd609582092b994', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:13', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567066693151,\"dRwsj\":1567066693151}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:13', null, null);
INSERT INTO `plate_log` VALUES ('532e29e2329445108e412ddf3bb7ee22', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:03', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"13922222222\\\",\\\"cLoginname\\\":\\\"chenyi\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"226717\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566805537833,\"id\":\"09F9AE1CB19C05F834BE5AE0CEFDB24F\",\"lastAccessedTime\":1566805794691,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:03', null, null);
INSERT INTO `plate_log` VALUES ('54a505fdb2684e1f9b8ceedcf1746647', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:55', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567048674990,\"dRwsj\":1567048674990}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:55', null, null);
INSERT INTO `plate_log` VALUES ('54ca63a98d514676a234ac6ffe1b361c', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:11', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1566873670965,\"dRwsj\":1566873670965}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:11', null, null);
INSERT INTO `plate_log` VALUES ('55a0e84000674051a038421c4416ba0c', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:22:57', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"aee52760658d49b0bafb298bc171eb68\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"aee52760658d49b0bafb298bc171eb68\",\"cZt\":\"1\",\"dCjsj\":1567070576559,\"dRwsj\":1567070576559}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:22:57', null, null);
INSERT INTO `plate_log` VALUES ('55be9884ceca48beb3db72a52f59e5d5', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-26\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1566804935762,\"dRwsj\":1566804935762}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:36', null, null);
INSERT INTO `plate_log` VALUES ('5866b868aa784f41bed1c6475cfa6855', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 12:23:08', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1567052587521,\"dRwsj\":1567052587521}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 12:23:08', null, null);
INSERT INTO `plate_log` VALUES ('5ac47e70e47046eda6a3f0fbf45a4268', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:04:26', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8519c2bc5da44d119bb1a05b4a344303\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:04:27', null, null);
INSERT INTO `plate_log` VALUES ('5b857d38641844ed876846327ef73577', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.saveUserRolePermission', '[{\"cRole\":\"c_sysAdmin\",\"permissionJson\":{\"C_YWGN_NLGL\":true,\"C_YWGN_RWGL\":true,\"C_YWGN_SPGL\":true,\"C_YWGN_YHGL\":true,\"C_PLATE_ONLINE\":true,\"C_PLATE_QXGL\":true,\"C_PLATE_YHGL\":true,\"C_PLATE_YWJCDM\":true,\"C_PLATE_YYPZ\":true}}]', null, null, '0:0:0:0:0:0:0:1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_log` VALUES ('5b87337fd7dd4676829dc3f00051078e', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:46:59', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"13211111111\\\",\\\"cLoginname\\\":\\\"suxi\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"895611\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566805537833,\"id\":\"09F9AE1CB19C05F834BE5AE0CEFDB24F\",\"lastAccessedTime\":1566805609299,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:46:59', null, null);
INSERT INTO `plate_log` VALUES ('5d62bf0b2aee44689a297f26ef43e965', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:15:41', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"18328023251\\\",\\\"cLoginname\\\":\\\"liming\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"116693\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1567156526269,\"id\":\"EFB7EC76DB65B112E26F67EA25855CE3\",\"lastAccessedTime\":1567156526405,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:15:41', null, null);
INSERT INTO `plate_log` VALUES ('5e5980ed66a542aabbc7b7a6cc36ea0d', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:06', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064585465,\"dRwsj\":1567064585465}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:06', null, null);
INSERT INTO `plate_log` VALUES ('5e7d359be7254a70949f55a41198fd6f', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:07:59', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567069678397,\"dRwsj\":1567069678397}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:07:59', null, null);
INSERT INTO `plate_log` VALUES ('5ee7b962ac9b4cea9a1d665bb33f04e9', '3309b23c28584179b9d69e226e3eeeee', '2019-08-30 16:15:43', 'I', 'com.greenplatform.service.plateImpl.PlateServiceImpl.insertTGreenNlCzjl', '[{\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cUsername\":\"罗文旅\",\"cZjhm\":\"512101199901012122\",\"cEmail\":\"\",\"cPhone\":\"18328023252\",\"cFkzh\":\"18328023251\",\"cFkfs\":\"1\",\"dFksj\":\"2019-08-30 16:15:24\",\"cFkyh\":\"\",\"cFkkh\":\"\",\"cFksfcg\":\"1\",\"cFkdh\":\"46546546\",\"cSkzh\":\"18328023332\",\"cSkfs\":\"1\",\"dSksj\":\"2019-08-30 16:15:28\",\"cSkyh\":\"\",\"cSkkh\":\"\",\"cSksfcg\":\"1\",\"cSkdh\":\"456464\",\"nFkje\":\"100000\",\"cBz\":\"\"}]', null, null, '0:0:0:0:0:0:0:1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-30 16:15:44', null, null);
INSERT INTO `plate_log` VALUES ('626b15ffb41a4e8d86e9d92a3bfa89d3', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:01:02', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567407661909,\"dRwsj\":1567407661909}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:01:02', null, null);
INSERT INTO `plate_log` VALUES ('6387f5bb7f7c406bacbea922c8154189', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567067048503,\"dRwsj\":1567067048503}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', null, null);
INSERT INTO `plate_log` VALUES ('69a9a4d668334f0d8704c16fe2bf7218', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:46', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567070085895,\"dRwsj\":1567070085895}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:46', null, null);
INSERT INTO `plate_log` VALUES ('6b2c00c2f2944b7f826b02d8210e3224', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:44:04', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:44:04', null, null);
INSERT INTO `plate_log` VALUES ('6e922a6d1ffa4eb784f5ceed251da9e3', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:19:37', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063176576,\"dRwsj\":1567063176576}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:19:37', null, null);
INSERT INTO `plate_log` VALUES ('6fbe3d89ee304836a9e5a7110555c3b0', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 14:44:59', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 14:45:00', null, null);
INSERT INTO `plate_log` VALUES ('7512f69bb55f4fef93b8f242e473bf10', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:50:28', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:50:28', null, null);
INSERT INTO `plate_log` VALUES ('75fc029793674794aa79472396f46bcf', '3309b23c28584179b9d69e226e3eeeee', '2019-08-29 14:23:22', 'U', 'com.greenplatform.service.plateImpl.PlateServiceImpl.updPlateUserPass', '[\"luo820\"]', null, null, '0:0:0:0:0:0:0:1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-29 14:23:22', null, null);
INSERT INTO `plate_log` VALUES ('78457745880a445792a03bee2ab30b63', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:16:33', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567062993348,\"dRwsj\":1567062993348}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:16:34', null, null);
INSERT INTO `plate_log` VALUES ('7974305e624d488197d933c0c569bbde', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:12:21', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567069941253,\"dRwsj\":1567069941253}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:12:22', null, null);
INSERT INTO `plate_log` VALUES ('7ca6decbe16446948c959e9afa350c2e', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:07:17', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:07:17', null, null);
INSERT INTO `plate_log` VALUES ('7dd287a69d1f4c5b97802ad89c7212b7', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:35', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-26\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1566804934096,\"dRwsj\":1566804934096}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:35', null, null);
INSERT INTO `plate_log` VALUES ('7eb13c90c18e45d1a381a1a436bed639', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:36:14', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"2\"}]', null, null, '127.0.0.1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:36:14', null, null);
INSERT INTO `plate_log` VALUES ('7ed4c6750692464abdbf8ba317485fb0', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:12:32', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567069952357,\"dRwsj\":1567069952357}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:12:32', null, null);
INSERT INTO `plate_log` VALUES ('7ef254a9ea8e4dc9ad42b8fc6311d74b', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:38', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:38', null, null);
INSERT INTO `plate_log` VALUES ('7f0f2670c3d8488c997241b721dc4e48', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:39:02', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064342148,\"dRwsj\":1567064342148}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:39:02', null, null);
INSERT INTO `plate_log` VALUES ('810cb63015e542bcb28c24dd43ad6cda', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:27:05', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"aee52760658d49b0bafb298bc171eb68\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"aee52760658d49b0bafb298bc171eb68\",\"cZt\":\"1\",\"dCjsj\":1567070824700,\"dRwsj\":1567070824700}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:27:05', null, null);
INSERT INTO `plate_log` VALUES ('81c5a96587f844768841038116b12dde', 'a42038e3950a441b945f46081f5e097f', '2019-08-26 11:01:21', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8e8baa920c964deeb08b535ea9f372f9\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-26 11:01:21', null, null);
INSERT INTO `plate_log` VALUES ('82599f09391545a2bea1826a754f547b', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:29', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"06d4d91d9e6047febae59a017c135b91\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"06d4d91d9e6047febae59a017c135b91\",\"cZt\":\"1\",\"dCjsj\":1566873689375,\"dRwsj\":1566873689375}]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:29', null, null);
INSERT INTO `plate_log` VALUES ('84124127e5cd4f8eb834848892f83046', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:29:02', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063742285,\"dRwsj\":1567063742286}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:29:03', null, null);
INSERT INTO `plate_log` VALUES ('89f75f8786c846eea4793b2bbab4a4d9', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:32', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:32', null, null);
INSERT INTO `plate_log` VALUES ('8a70c534ba4d4619bfa5a75b22231962', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:40', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1567065999695,\"dRwsj\":1567065999695}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:40', null, null);
INSERT INTO `plate_log` VALUES ('8b0eb91ebc6140eab2a53c8fca215bf7', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 17:02:48', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"2\"}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 17:02:48', null, null);
INSERT INTO `plate_log` VALUES ('8d7547fac8274b53bb255638a7cb0938', '06d4d91d9e6047febae59a017c135b91', '2019-08-23 15:40:44', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"b55cbb78e1e54da7a14171c34031f692\\\",\\\"cPhone\\\":\\\"18328023251\\\",\\\"cLoginname\\\":\\\"lisa\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"707676\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566543383311,\"id\":\"15A715D1103999AFD4E9E0C30506D750\",\"lastAccessedTime\":1566546023553,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '06d4d91d9e6047febae59a017c135b91', '2019-08-23 15:40:44', null, null);
INSERT INTO `plate_log` VALUES ('8d9f37f0445b48279aa72c2b321c534c', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567066691640,\"dRwsj\":1567066691640}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:12', null, null);
INSERT INTO `plate_log` VALUES ('8e5e2ac2663b43e68e90258227e06a17', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:54:29', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:54:29', null, null);
INSERT INTO `plate_log` VALUES ('8f4a126cb35f4976a08ebaded80d1460', 'a42038e3950a441b945f46081f5e097f', '2019-08-26 17:03:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8e8baa920c964deeb08b535ea9f372f9\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-26 17:03:12', null, null);
INSERT INTO `plate_log` VALUES ('8f56bd20536b42f5bc93de195366bf40', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:03:04', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567407784383,\"dRwsj\":1567407784383}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:03:04', null, null);
INSERT INTO `plate_log` VALUES ('90b3b098e2954aa29056370d899c4db7', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:11:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567408295824,\"dRwsj\":1567408295824}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:11:36', null, null);
INSERT INTO `plate_log` VALUES ('95e1588b4a7544b8877055091c62ea9a', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:22:53', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"aee52760658d49b0bafb298bc171eb68\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"aee52760658d49b0bafb298bc171eb68\",\"cZt\":\"1\",\"dCjsj\":1567070573087,\"dRwsj\":1567070573087}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:22:53', null, null);
INSERT INTO `plate_log` VALUES ('9bb3743b1bea46529acf83fe6d4fa47f', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:08:00', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567069680422,\"dRwsj\":1567069680422}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:08:00', null, null);
INSERT INTO `plate_log` VALUES ('9c8316ebc84749029a7a41c695e3879f', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:37', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:37', null, null);
INSERT INTO `plate_log` VALUES ('9e97bc310d8c4506a54dc594d2dd38ca', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:35:55', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8519c2bc5da44d119bb1a05b4a344303\",\"1\"]', null, null, '127.0.0.1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:35:55', null, null);
INSERT INTO `plate_log` VALUES ('9fc1998a58c6438496b250194c667a5e', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:21:20', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063280350,\"dRwsj\":1567063280350}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:21:20', null, null);
INSERT INTO `plate_log` VALUES ('a4bfa961ab944a088b0d3c9c159f4782', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:24', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"18922222222\\\",\\\"cLoginname\\\":\\\"zhaoyang\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"257917\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566805537833,\"id\":\"09F9AE1CB19C05F834BE5AE0CEFDB24F\",\"lastAccessedTime\":1566805936867,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:24', null, null);
INSERT INTO `plate_log` VALUES ('a51008c54ae344feaf9a239cb1c49776', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1566873671610,\"dRwsj\":1566873671610}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:12', null, null);
INSERT INTO `plate_log` VALUES ('a5119cb8c05b45b4bf2289086d62bc3a', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:11', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1566870310755,\"dRwsj\":1566870310755}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:11', null, null);
INSERT INTO `plate_log` VALUES ('a670622c4ccb4d03a3936e89e0e21336', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1566870311466,\"dRwsj\":1566870311466}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:12', null, null);
INSERT INTO `plate_log` VALUES ('a6fd7caee35f41a5a5ac3391bf4db231', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:41', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"06d4d91d9e6047febae59a017c135b91\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"06d4d91d9e6047febae59a017c135b91\",\"cZt\":\"1\",\"dCjsj\":1567066060899,\"dRwsj\":1567066060899}]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:41', null, null);
INSERT INTO `plate_log` VALUES ('a7b92de8e6504d509a90bc0f8e79b7a5', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:40', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1567066000393,\"dRwsj\":1567066000393}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:40', null, null);
INSERT INTO `plate_log` VALUES ('a8a3d67326f94441a706592ff8c0bcce', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:19:42', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063182215,\"dRwsj\":1567063182215}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:19:42', null, null);
INSERT INTO `plate_log` VALUES ('a8b74f53d486481c99a75cb53a492247', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:21:04', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063263560,\"dRwsj\":1567063263560}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:21:04', null, null);
INSERT INTO `plate_log` VALUES ('a8f1df2081104f93b5c9e2423b3e157d', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:08:34', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:08:34', null, null);
INSERT INTO `plate_log` VALUES ('a91cb669b2834fb2a1b5ef6345dec6c2', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:42:36', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"1\"}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:42:37', null, null);
INSERT INTO `plate_log` VALUES ('a91de4e05fd9460a8a793fcc4316fe19', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 11:51:44', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"3\"}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 11:51:44', null, null);
INSERT INTO `plate_log` VALUES ('aa43c8094eb744e2b1bd055cbaa8c112', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:49', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:49', null, null);
INSERT INTO `plate_log` VALUES ('ae83fbaf9d884a6184d7cf749dc11ef9', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:20:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"aee52760658d49b0bafb298bc171eb68\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"aee52760658d49b0bafb298bc171eb68\",\"cZt\":\"1\",\"dCjsj\":1567070445028,\"dRwsj\":1567070445028}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:20:45', null, null);
INSERT INTO `plate_log` VALUES ('aef2690d94684c81be8059235f6b662d', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:12', null, null);
INSERT INTO `plate_log` VALUES ('b2092f839de84965913330079614f088', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:29:07', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063746472,\"dRwsj\":1567063746472}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:29:07', null, null);
INSERT INTO `plate_log` VALUES ('b2f5b417fcd54504b7bdb3f156311033', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-22 10:33:42', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"1\"}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-22 10:33:42', null, null);
INSERT INTO `plate_log` VALUES ('b3a7ae57d53e4fa58ec59747a3f412b0', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 12:06:00', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1567051559427,\"dRwsj\":1567051559427}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 12:06:00', null, null);
INSERT INTO `plate_log` VALUES ('b4b4950ba42346439e5146de8ae397cf', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:44', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064203963,\"dRwsj\":1567064203963}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:44', null, null);
INSERT INTO `plate_log` VALUES ('b64bb3e56fbb45e49c9cda1eb02e7bb0', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:47:59', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"18329999999\\\",\\\"cLoginname\\\":\\\"sunan\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"675435\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566805537833,\"id\":\"09F9AE1CB19C05F834BE5AE0CEFDB24F\",\"lastAccessedTime\":1566805671515,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:47:59', null, null);
INSERT INTO `plate_log` VALUES ('b7b16cb66fdc47c3a7cdadb95d1958bf', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1567416147650,\"dRwsj\":1567416147650}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28', null, null);
INSERT INTO `plate_log` VALUES ('b851328d08df42d8a2e0e373cb5e2bb5', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:56', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567048675499,\"dRwsj\":1567048675499}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:56', null, null);
INSERT INTO `plate_log` VALUES ('ba9a1435e5fe4b6fa2de81e31f98bfb0', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567067049192,\"dRwsj\":1567067049192}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', null, null);
INSERT INTO `plate_log` VALUES ('bc65da423073471aa31f678403192a93', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:00:13', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"13255555555\\\",\\\"cLoginname\\\":\\\"zhangsan\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"920863\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566543383311,\"id\":\"15A715D1103999AFD4E9E0C30506D750\",\"lastAccessedTime\":1566547204958,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":3,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[],\"majorVersion\":3,\"minorVersion\":1,\"serverInfo\":\"Apache Tomcat/8.5.34\",\"servletContextName\":\"application\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Tomcat/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '127.0.0.1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:00:13', null, null);
INSERT INTO `plate_log` VALUES ('bcbd6c17f4ab4d63b07887a2c8691a95', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:22:53', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"2\"}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:22:54', null, null);
INSERT INTO `plate_log` VALUES ('bef80a7f8c8e400ca0c9ed84b7b884f6', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:08:00', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567069679511,\"dRwsj\":1567069679511}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:08:00', null, null);
INSERT INTO `plate_log` VALUES ('c0b9b85fd4cc4a308fbd75f3193ff0df', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:16:46', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"2\"}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:16:46', null, null);
INSERT INTO `plate_log` VALUES ('c0d34e06bd6e4c44ad9c535af72760f5', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567064591709,\"dRwsj\":1567064591709}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:12', null, null);
INSERT INTO `plate_log` VALUES ('c2eaceca8b914d81adb1dfe58b2a2f09', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:05:24', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"00fb897b5b624f90a6aa6223e1c28772\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:05:24', null, null);
INSERT INTO `plate_log` VALUES ('c308de217ae44b3a9a33186bbd3c69f7', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 16:14:25', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 16:14:25', null, null);
INSERT INTO `plate_log` VALUES ('c31a4ced068b441c83279ebd71cbb3da', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:16:42', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063002306,\"dRwsj\":1567063002306}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:16:42', null, null);
INSERT INTO `plate_log` VALUES ('c40309d2f0be48228f14f3d79c83de4a', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:07', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1567066086963,\"dRwsj\":1567066086963}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:07', null, null);
INSERT INTO `plate_log` VALUES ('c6a9d056c8924a7da88fc6c0c54a95bc', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:24:13', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8e8baa920c964deeb08b535ea9f372f9\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:24:13', null, null);
INSERT INTO `plate_log` VALUES ('c7ea70d34e954607a25920fd7cf419ab', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:00', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"15800000000\\\",\\\"cLoginname\\\":\\\"surui\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"760322\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566805537833,\"id\":\"09F9AE1CB19C05F834BE5AE0CEFDB24F\",\"lastAccessedTime\":1566805855080,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:00', null, null);
INSERT INTO `plate_log` VALUES ('c88eb163642c46728f44ecebdd115e3b', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:03:18', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"2\"}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:03:18', null, null);
INSERT INTO `plate_log` VALUES ('ca2c7ab6dc78408f9fd332f075f035c6', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:10', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1566873670333,\"dRwsj\":1566873670333}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:11', null, null);
INSERT INTO `plate_log` VALUES ('caa0878e8ae64ced8415de7c70267737', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 12:32:26', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8519c2bc5da44d119bb1a05b4a344303\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 12:32:26', null, null);
INSERT INTO `plate_log` VALUES ('cbd4fce078ca41bb967d771b0d862eed', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:22:35', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063355017,\"dRwsj\":1567063355017}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:22:35', null, null);
INSERT INTO `plate_log` VALUES ('cfa91673cf944d58b9f1d67dca3e0bde', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:21:14', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"a42038e3950a441b945f46081f5e097f\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"a42038e3950a441b945f46081f5e097f\",\"cZt\":\"1\",\"dCjsj\":1567416073803,\"dRwsj\":1567416073803}]', null, null, '0:0:0:0:0:0:0:1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:21:14', null, null);
INSERT INTO `plate_log` VALUES ('d487d4e928f743ebabdf7ef017b0022d', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 17:02:45', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.buySeeds', '[{\"cSpbh\":\"1\"}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 17:02:45', null, null);
INSERT INTO `plate_log` VALUES ('d4a61d014e694cbf9f2dd99998fec34b', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:35', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-26\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1566804935151,\"dRwsj\":1566804935151}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:35', null, null);
INSERT INTO `plate_log` VALUES ('dac9402751b54c73982ef0cadc6b6845', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `plate_log` VALUES ('dc162e42c1ed4fb988af1514067d210e', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:39', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1567065998533,\"dRwsj\":1567065998533}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:39', null, null);
INSERT INTO `plate_log` VALUES ('dd70f4254a2a46509cd5e291d0e0d60d', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:16:58', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1567070218144,\"dRwsj\":1567070218144}]', null, null, '0:0:0:0:0:0:0:1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:16:58', null, null);
INSERT INTO `plate_log` VALUES ('deae8f9f187d401587e988a47f645310', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:31', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"06d4d91d9e6047febae59a017c135b91\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"06d4d91d9e6047febae59a017c135b91\",\"cZt\":\"1\",\"dCjsj\":1566873690468,\"dRwsj\":1566873690468}]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:31', null, null);
INSERT INTO `plate_log` VALUES ('e302228f8578481ba391e062c7189fc2', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:36:04', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '127.0.0.1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:36:04', null, null);
INSERT INTO `plate_log` VALUES ('e40172ce7252481b8e7c5cf4f6507719', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `plate_log` VALUES ('e5c2d6ff1e9e4f71a395cfdca65f43bb', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:56', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567048676109,\"dRwsj\":1567048676109}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:56', null, null);
INSERT INTO `plate_log` VALUES ('e5f01eff6a814b029529f505671b198f', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:44', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"d1c3a5e76a944392b919709509fb9cd9\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"d1c3a5e76a944392b919709509fb9cd9\",\"cZt\":\"1\",\"dCjsj\":1567048603387,\"dRwsj\":1567048603387}]', null, null, '0:0:0:0:0:0:0:1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:44', null, null);
INSERT INTO `plate_log` VALUES ('e6818c3fa8394fb2af70561897980d20', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:20', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"441d1b15644a42ffb6670cdf4e0abca1\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"441d1b15644a42ffb6670cdf4e0abca1\",\"cZt\":\"1\",\"dCjsj\":1566873680282,\"dRwsj\":1566873680282}]', null, null, '0:0:0:0:0:0:0:1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:20', null, null);
INSERT INTO `plate_log` VALUES ('e7583ff9b233470f8e7e071e87e5f907', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567408397523,\"dRwsj\":1567408397523}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18', null, null);
INSERT INTO `plate_log` VALUES ('e98fff33e41747e9850b31ccacb2824f', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:11:17', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567062676988,\"dRwsj\":1567062676988}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:11:17', null, null);
INSERT INTO `plate_log` VALUES ('ea44058c046b40e9b200e7630f63b19e', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:10', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-27\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1566870309869,\"dRwsj\":1566870309869}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:10', null, null);
INSERT INTO `plate_log` VALUES ('ec735d29371145d6ac159c19593b3252', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:11:19', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567408278587,\"dRwsj\":1567408278587}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:11:19', null, null);
INSERT INTO `plate_log` VALUES ('f0ea602cfab34364a9b9f71c5f8b10f1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:22:39', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567063359200,\"dRwsj\":1567063359200}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:22:39', null, null);
INSERT INTO `plate_log` VALUES ('f5e2dcf0b5fe48caa74e65662b54cdcc', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:01', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-26\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1566786180625,\"dRwsj\":1566786180625}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:01', null, null);
INSERT INTO `plate_log` VALUES ('f86e9342db6d4cc38cee02409ef60c36', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:46:00', 'I', 'com.greenplatform.service.loginImpl.LoginServiceImpl.doRegister', '[\"{\\\"cYqm\\\":\\\"-1\\\",\\\"cPhone\\\":\\\"13233333333\\\",\\\"cLoginname\\\":\\\"suyi\\\",\\\"cPassword\\\":\\\"aaaaaa\\\",\\\"smsCode\\\":\\\"568627\\\",\\\"cRylb\\\":\\\"2\\\"}\",{\"attributeNames\":[\"loginUser\"],\"creationTime\":1566805537833,\"id\":\"09F9AE1CB19C05F834BE5AE0CEFDB24F\",\"lastAccessedTime\":1566805553978,\"maxInactiveInterval\":1800,\"new\":false,\"servletContext\":{\"attributeNames\":[\"javax.servlet.context.tempdir\",\"org.apache.catalina.resources\",\"org.springframework.web.context.WebApplicationContext.ROOT\",\"org.springframework.web.context.support.ServletContextScope\",\"org.apache.tomcat.InstanceManager\",\"org.apache.catalina.jsp_classpath\",\"javax.websocket.server.ServerContainer\",\"org.apache.jasper.compiler.TldCache\",\"org.apache.tomcat.JarScanner\",\"org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet\"],\"contextPath\":\"\",\"defaultSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"effectiveMajorVersion\":4,\"effectiveMinorVersion\":0,\"effectiveSessionTrackingModes\":[\"COOKIE\",\"URL\"],\"filterRegistrations\":{\"requestContextFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter\",\"initParameters\":{},\"name\":\"requestContextFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"Tomcat WebSocket (JSR356) Filter\":{\"className\":\"org.apache.tomcat.websocket.server.WsFilter\",\"initParameters\":{},\"name\":\"Tomcat WebSocket (JSR356) Filter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"errorPageFilter\":{\"className\":\"org.springframework.boot.web.servlet.support.ErrorPageFilter\",\"initParameters\":{},\"name\":\"errorPageFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"httpPutFormContentFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter\",\"initParameters\":{},\"name\":\"httpPutFormContentFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"hiddenHttpMethodFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter\",\"initParameters\":{},\"name\":\"hiddenHttpMethodFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]},\"characterEncodingFilter\":{\"className\":\"org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter\",\"initParameters\":{},\"name\":\"characterEncodingFilter\",\"servletNameMappings\":[],\"urlPatternMappings\":[\"/*\"]}},\"initParameterNames\":[\"contextConfigLocation\"],\"majorVersion\":4,\"minorVersion\":0,\"serverInfo\":\"Apache Tomcat/9.0.22\",\"servletNames\":[],\"servletRegistrations\":{\"default\":{\"className\":\"org.apache.catalina.servlets.DefaultServlet\",\"initParameters\":{\"listings\":\"false\",\"debug\":\"0\"},\"mappings\":[],\"name\":\"default\"},\"jsp\":{\"className\":\"org.apache.jasper.servlet.JspServlet\",\"initParameters\":{\"fork\":\"false\",\"classdebuginfo\":\"true\",\"xpoweredBy\":\"false\"},\"mappings\":[\"*.jspx\",\"*.jsp\"],\"name\":\"jsp\"},\"dispatcherServlet\":{\"className\":\"org.springframework.web.servlet.DispatcherServlet\",\"initParameters\":{},\"mappings\":[\"/\"],\"name\":\"dispatcherServlet\"}},\"servlets\":[],\"sessionCookieConfig\":{\"httpOnly\":false,\"maxAge\":-1,\"secure\":false},\"sessionTimeout\":30,\"virtualServerName\":\"Catalina/localhost\"},\"sessionContext\":{\"ids\":[]},\"valueNames\":[\"loginUser\"]}]', null, null, '0:0:0:0:0:0:0:1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:46:00', null, null);
INSERT INTO `plate_log` VALUES ('f8c2bbe72d9d41d99601db0a352d0722', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:00:34', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:00:34', null, null);
INSERT INTO `plate_log` VALUES ('f8f6950232c64803ae2a4ee81bdc6bd6', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:06', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567408386403,\"dRwsj\":1567408386403}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:07', null, null);
INSERT INTO `plate_log` VALUES ('f93a6ccc3159464fb5a204c8e00728e3', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:00', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"b55cbb78e1e54da7a14171c34031f692\",\"cRwday\":\"2019-08-26\",\"cRwlb\":\"3\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"b55cbb78e1e54da7a14171c34031f692\",\"cZt\":\"1\",\"dCjsj\":1566786179635,\"dRwsj\":1566786179635}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:00', null, null);
INSERT INTO `plate_log` VALUES ('fa17716b9d2e48f185bf4208980569a7', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:06:11', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.doLike', '[]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:06:11', null, null);
INSERT INTO `plate_log` VALUES ('fa6622d0c2754a78b09452af0be51348', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 12:04:40', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"06d4d91d9e6047febae59a017c135b91\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"06d4d91d9e6047febae59a017c135b91\",\"cZt\":\"1\",\"dCjsj\":1567051479926,\"dRwsj\":1567051479926}]', null, null, '0:0:0:0:0:0:0:1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 12:04:40', null, null);
INSERT INTO `plate_log` VALUES ('fbf03477918f4f039f80f57fc2ea1776', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.contributeSeed', '[\"8519c2bc5da44d119bb1a05b4a344303\",\"1\"]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26', null, null);
INSERT INTO `plate_log` VALUES ('fd25095b20af4456873f7ab284a3e92e', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 12:32:47', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567053167007,\"dRwsj\":1567053167007}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 12:32:47', null, null);
INSERT INTO `plate_log` VALUES ('fe083eb415784d75a5056baa389b57de', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:44:09', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cRwlb\":\"1\"}]', null, null, '127.0.0.1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:44:09', null, null);
INSERT INTO `plate_log` VALUES ('fe10510cfd2244e0af6aa2bffc0cb937', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:08', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cRwday\":\"2019-08-29\",\"cRwlb\":\"1\",\"cRwmouth\":\"2019-08\",\"cUserid\":\"cdc60bbeb94040e792bca23d9f9876ab\",\"cZt\":\"1\",\"dCjsj\":1567067047448,\"dRwsj\":1567067047448}]', null, null, '0:0:0:0:0:0:0:1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:08', null, null);
INSERT INTO `plate_log` VALUES ('feea4e4931b84b1c878979568d957950', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:12', 'I', 'com.greenplatform.service.webImpl.WebServiceImpl.accomplishRw', '[{\"cCjuser\":\"563d03768ba644f2827f1afd6703ba1e\",\"cRwday\":\"2019-09-02\",\"cRwlb\":\"2\",\"cRwmouth\":\"2019-09\",\"cUserid\":\"563d03768ba644f2827f1afd6703ba1e\",\"cZt\":\"1\",\"dCjsj\":1567408391643,\"dRwsj\":1567408391643}]', null, null, '0:0:0:0:0:0:0:1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:12', null, null);

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
-- Records of plate_user
-- ----------------------------
INSERT INTO `plate_user` VALUES ('06d4d91d9e6047febae59a017c135b91', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'lisa', '丽萨', '1', '1', null, '0', '2', '1', '1', '', null, '617892200112123456', null, '18329023251', null, null, null, 'b55cbb78e1e54da7a14171c34031f692', 'b55cbb78e1e54da7a14171c34031f692', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-23 15:40:43', '06d4d91d9e6047febae59a017c135b91', '2019-08-26 15:49:16');
INSERT INTO `plate_user` VALUES ('2e51d42dd4fe459590810112aa242c62', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhaoyang', '赵阳', '2', '1', null, '0', '2', '1', '1', '', null, '298718199901012189', null, '18922222222', null, null, null, null, null, null, '1', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:24', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:44');
INSERT INTO `plate_user` VALUES ('3309b23c28584179b9d69e226e3eeeee', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'admin', '系统管理员', '1', '0', null, null, '1', '1', '1', '1', '1', '1212', '121212', '18328823251', '18328023251', '1271826981', '1213@qq.com', null, null, '测试测试', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-06-25 14:49:27', '3309b23c28584179b9d69e226e3eeeee', '2019-08-29 14:23:51');
INSERT INTO `plate_user` VALUES ('34617ade93c0495dbbaf17630a724e83', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'chenyi', '陈毅', '2', '1', null, '0', '2', '1', '1', '', null, '691821200107122168', null, '13922222222', null, null, null, null, null, null, '1', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:03', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:30');
INSERT INTO `plate_user` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'suxi', '苏西', '1', '1', null, '0', '2', '1', '1', '', null, '518721199801023333', null, '13211111111', null, null, null, null, null, null, '1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:46:59', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:47:26');
INSERT INTO `plate_user` VALUES ('563d03768ba644f2827f1afd6703ba1e', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'zhangsan', '张三', '2', '1', null, '0', '2', '1', '1', '', null, '500109198701012222', null, '13255555555', null, null, null, null, null, null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:00:13', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:10:33');
INSERT INTO `plate_user` VALUES ('946e2d05f1234f37aad54651bd5bfae3', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'liming', '李明', '1', '1', null, '0', '2', '1', '1', '', null, '621789199901012211', null, '18328023251', null, null, null, null, null, null, '1', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:15:41', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:16:08');
INSERT INTO `plate_user` VALUES ('a42038e3950a441b945f46081f5e097f', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'lisi', '李四', '1', '1', null, '0', '2', '1', '1', '', null, '512389198801013333', null, '13855555555', null, null, null, '563d03768ba644f2827f1afd6703ba1e', '563d03768ba644f2827f1afd6703ba1e', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:01:13', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:39:14');
INSERT INTO `plate_user` VALUES ('aee52760658d49b0bafb298bc171eb68', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'suyi', '苏一', '1', '1', null, '0', '2', '1', '1', '', null, '518721199901015678', null, '13233333333', null, null, null, null, null, null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:45:59', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:46:32');
INSERT INTO `plate_user` VALUES ('b19afeb2118e404c9d66fa568bb5eb85', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'surui', '苏瑞', '2', '1', null, '0', '2', '1', '1', '', null, '615182200009082222', null, '15800000000', null, null, null, null, null, null, '1', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:00', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:42');
INSERT INTO `plate_user` VALUES ('b55cbb78e1e54da7a14171c34031f692', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'luowenlv', '罗文旅', '2', '1', null, '0', '2', '1', '1', '', null, '512101199901012122', null, '18328023351', null, null, null, null, null, null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:41:08', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-30 17:14:38');
INSERT INTO `plate_user` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'sunan', '苏南', '2', '1', null, '0', '2', '1', '1', '', null, '617821200001018765', null, '18329999999', null, null, null, null, null, null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:47:59', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:48:26');
INSERT INTO `plate_user` VALUES ('d1c3a5e76a944392b919709509fb9cd9', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'wangwu', '王五', '1', '1', null, '0', '2', '1', '1', '', null, '181291200001018999', null, '18328323251', null, null, null, 'b55cbb78e1e54da7a14171c34031f692', 'b55cbb78e1e54da7a14171c34031f692', null, '1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:21:07', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:57:42');

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
-- Records of plate_user_blacklist
-- ----------------------------

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
-- Records of plate_user_father
-- ----------------------------
INSERT INTO `plate_user_father` VALUES ('563d03768ba644f2827f1afd6703ba1e', 'a42038e3950a441b945f46081f5e097f', '2019-08', '2019-08-25 17:07:44', '1', null, 'a42038e3950a441b945f46081f5e097f', '2019-08-27 17:08:57', null, null);
INSERT INTO `plate_user_father` VALUES ('b55cbb78e1e54da7a14171c34031f692', '06d4d91d9e6047febae59a017c135b91', '2019-08', '2019-08-27 17:07:48', '1', '', '06d4d91d9e6047febae59a017c135b91', '2019-08-25 17:07:04', null, null);
INSERT INTO `plate_user_father` VALUES ('b55cbb78e1e54da7a14171c34031f692', '34617ade93c0495dbbaf17630a724e83', '2019-08', '2019-08-27 17:25:53', '1', null, null, null, null, null);
INSERT INTO `plate_user_father` VALUES ('b55cbb78e1e54da7a14171c34031f692', 'aee52760658d49b0bafb298bc171eb68', '2019-08', '2019-08-27 17:10:43', '1', null, null, null, null, null);
INSERT INTO `plate_user_father` VALUES ('b55cbb78e1e54da7a14171c34031f692', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08', '2019-08-27 17:10:40', '1', null, null, null, null, null);
INSERT INTO `plate_user_father` VALUES ('b55cbb78e1e54da7a14171c34031f692', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08', '2019-08-27 17:08:44', '1', null, 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-27 17:08:59', null, null);

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
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_ONLINE', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_QXGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YWJCDM', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_PLATE', 'C_PLATE_YYPZ', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_NLGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_RWGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_SPGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_sysAdmin', 'C_YWGN', 'C_YWGN_YHGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:43:13', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_ywAdmin', 'C_PLATE', 'C_PLATE_YWJCDM', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 16:43:04', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_ywAdmin', 'C_YWGN', 'C_YWGN_NLGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 16:43:04', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_ywAdmin', 'C_YWGN', 'C_YWGN_RWGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 16:43:04', null, null);
INSERT INTO `plate_user_permission` VALUES ('c_ywAdmin', 'C_YWGN', 'C_YWGN_ZHDJGL', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 16:43:04', null, null);

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
INSERT INTO `plate_user_role` VALUES ('c_ywAdmin', '业务管理员', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 16:42:53', null, null);

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
INSERT INTO `plate_user_role_mid` VALUES ('3309b23c28584179b9d69e226e3eeeee', 'c_sysAdmin', '1', null, null, null, null);

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
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_CSSZ', '系统配置_系统参数设置', '系统参数设置', '/base/xtcssz', '4', '0', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-08-14 10:34:20');
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_ONLINE', '网站在线用户统计', '在线用户统计', '/base/online', '1', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-26 16:35:13', null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_QXGL', '系统配置_权限管理', '权限管理', '/base/qxgl', '3', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YHGL', '系统配置_用户管理', '用户管理', '/base/plateYhgl', '2', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YWJCDM', '系统配置_业务基础代码管理', '业务基础代码管理', '/base/ywjcdm', '2', '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-16 14:08:24');
INSERT INTO `plate_yw_lx_menu` VALUES ('C_PLATE', 'C_PLATE_YYPZ', '系统配置_应用配置', '应用配置', '/base/yypz', '5', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_NLGL', '业务功能_能量管理', '能量管理', '/base/nlgl', '2', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_RWGL', '业务功能_任务管理', '任务管理', '/base/rwgl', '3', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_SPGL', '业务功能_商品管理', '商品管理', '/base/spgl', '4', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_STGL', '业务功能_收徒管理', '收徒管理', '/base/stgl', '5', '0', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-08-20 11:05:53');
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_YHGL', '业务功能_前端用户管理', '前端用户管理', '/base/yhgl', '1', '1', null, null, null, null);
INSERT INTO `plate_yw_lx_menu` VALUES ('C_YWGN', 'C_YWGN_ZHDJGL', '业务功能_账户等级管理', '账户等级管理', '/base/zhsjgl', '6', '0', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-08-20 11:05:17');

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
INSERT INTO `t_green_gold_dzhz` VALUES ('06d4d91d9e6047febae59a017c135b91', '0.0000', '清空点赞数，原因：金币点赞瓜分能量活动,时间：2019-08-29 16:24:13.849', '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:32', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_gold_dzhz` VALUES ('563d03768ba644f2827f1afd6703ba1e', '0.0000', '清空点赞数，原因：金币点赞瓜分能量活动,时间：2019-08-29 16:24:13.849', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:38', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_gold_dzhz` VALUES ('a42038e3950a441b945f46081f5e097f', '0.0000', '清空点赞数，原因：金币点赞瓜分能量活动,时间：2019-08-29 16:24:13.849', '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:13', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_gold_dzhz` VALUES ('b55cbb78e1e54da7a14171c34031f692', '0.0000', '清空点赞数，原因：金币点赞瓜分能量活动,时间：2019-08-29 16:24:13.849', '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:07', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_gold_dzhz` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '0.0000', '清空点赞数，原因：金币点赞瓜分能量活动,时间：2019-08-29 16:24:13.849', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:13', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');

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
INSERT INTO `t_green_gold_dzmx` VALUES ('26dc273f4dfb4e2f84699db1066a5906', 'cdc60bbeb94040e792bca23d9f9876ab', '1.0000', '2019-08-29 16:18:56', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('5115f06883e74095a2e9a3ee734d6557', '563d03768ba644f2827f1afd6703ba1e', '1.0000', '2019-08-29 15:54:29', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:54:29', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('53736112bfc94e22b14c035399c2b065', '563d03768ba644f2827f1afd6703ba1e', '1.0000', '2019-08-29 15:57:15', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('549bc857c5ec4036b7e4e28cb92fb172', '563d03768ba644f2827f1afd6703ba1e', '1.0000', '2019-08-29 16:00:34', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:00:34', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('5809d5c51c604072a199bfae2d67e793', 'cdc60bbeb94040e792bca23d9f9876ab', '1.0000', '2019-08-27 09:45:13', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:13', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('6eab581ae51047dbb51e1cb83670796b', '06d4d91d9e6047febae59a017c135b91', '1.0000', '2019-08-27 10:41:32', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:32', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('6eaececdd54941e09ec84b8a4c224989', 'a42038e3950a441b945f46081f5e097f', '1.0000', '2019-08-29 16:08:12', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:12', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('8ad1dac4159e44fb9c844c49767529a0', '06d4d91d9e6047febae59a017c135b91', '1.0000', '2019-08-29 16:07:49', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:49', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('b07039c6de344c2a867ccabdde4d4246', 'b55cbb78e1e54da7a14171c34031f692', '1.0000', '2019-08-29 16:07:17', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:07:17', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('c1ff7332f73c424890c883c95582bd1d', 'cdc60bbeb94040e792bca23d9f9876ab', '1.0000', '2019-08-29 16:08:34', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:08:34', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('c5850dd19c0e4e09a3a9d5d3cc030b2c', '563d03768ba644f2827f1afd6703ba1e', '1.0000', '2019-08-26 15:35:38', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:38', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('cbeb74ba9a86429b9c9825715ad75d50', 'b55cbb78e1e54da7a14171c34031f692', '1.0000', '2019-08-26 10:23:07', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:07', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('d8963e9e2c444208a1eff6c3c91b2d2c', 'a42038e3950a441b945f46081f5e097f', '1.0000', '2019-08-27 10:41:13', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:13', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('dec05f61c44c46d086ae3e0d43f29b71', '563d03768ba644f2827f1afd6703ba1e', '1.0000', '2019-08-29 16:06:10', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:06:10', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('df54f028193547c08bcd77436a174406', '563d03768ba644f2827f1afd6703ba1e', '1.0000', '2019-08-29 16:09:01', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `t_green_gold_dzmx` VALUES ('f4fdc1c0d8c146a88284f2a3c76ee83c', 'cdc60bbeb94040e792bca23d9f9876ab', '1.0000', '2019-08-29 16:24:14', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);

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
INSERT INTO `t_green_gold_hz` VALUES ('06d4d91d9e6047febae59a017c135b91', '0.0000', null, '1', null, '2019-08-27 10:41:29', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:49');
INSERT INTO `t_green_gold_hz` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '50.0000', null, '1', null, '2019-08-27 10:41:20', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:22');
INSERT INTO `t_green_gold_hz` VALUES ('563d03768ba644f2827f1afd6703ba1e', '1043.0000', null, '1', null, '2019-08-26 15:35:34', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18');
INSERT INTO `t_green_gold_hz` VALUES ('a42038e3950a441b945f46081f5e097f', '50.0000', null, '1', null, '2019-08-27 10:41:10', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28');
INSERT INTO `t_green_gold_hz` VALUES ('aee52760658d49b0bafb298bc171eb68', '200.0000', null, '1', null, '2019-08-29 17:20:45', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:27:05');
INSERT INTO `t_green_gold_hz` VALUES ('b55cbb78e1e54da7a14171c34031f692', '50.0000', null, '1', null, '2019-08-26 10:23:00', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:08');
INSERT INTO `t_green_gold_hz` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '404.0000', null, '1', null, '2019-08-27 09:45:10', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_gold_hz` VALUES ('d1c3a5e76a944392b919709509fb9cd9', '50.0000', null, '1', null, '2019-08-29 11:16:43', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:45');

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
INSERT INTO `t_green_gold_jsmx` VALUES ('28c117d9f718483ca8db5862b2cfba16', '06d4d91d9e6047febae59a017c135b91', '50.0000', '2019-08-29 16:07:49', '1', '点赞', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:49', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('2d1fd547f9e246c592f5d6b90eb84caa', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 15:57:15', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('2fa3dc6825034b6b9ccec277452bb3ff', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 16:00:34', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:00:34', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('34ac322b4beb457bb963475b90dcbcc5', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 15:50:28', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:50:28', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('3b50d777d1b143bfa113effa0eba3bbb', 'a42038e3950a441b945f46081f5e097f', '50.0000', '2019-08-27 10:41:13', '1', '点赞', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:13', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('4476f03fb0564501b773494514d6e63c', 'a42038e3950a441b945f46081f5e097f', '50.0000', '2019-08-29 16:08:12', '1', '点赞', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:12', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('4ec2600b01f94bc5b77cd08487dfc082', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-26 15:35:38', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:38', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('533dbd8ca812467abd691d32b53bd07e', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 16:06:10', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:06:10', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('6dd001245aac4a39b69a878b157afda8', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-29 16:24:14', '1', '点赞', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('6f89d9d4f2974ec684eda1d2f9145f8e', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-29 16:18:56', '1', '点赞', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('8ca581e62b3a44339f678fe381451476', 'b55cbb78e1e54da7a14171c34031f692', '50.0000', '2019-08-29 16:07:17', '1', '点赞', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:07:17', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('b2d45cbf499248fdaed43a97bbce0497', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-29 16:08:34', '1', '点赞', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:08:34', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('d0d57bda76a24b1f985a29d04d36135c', '06d4d91d9e6047febae59a017c135b91', '50.0000', '2019-08-27 10:41:32', '1', '点赞', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:32', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('d1e6e1e35aa143069e2ca4655a372da3', 'b55cbb78e1e54da7a14171c34031f692', '50.0000', '2019-08-26 10:23:07', '1', '点赞', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:07', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('dc5e5a4c874c47699d4866596a3b5298', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 15:54:29', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:54:29', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('e2d488f17c734e2283d522e087d4b547', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-27 09:45:13', '1', '点赞', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:13', null, null);
INSERT INTO `t_green_gold_jsmx` VALUES ('e7821cc666494458958cd42810ad8fbf', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 16:09:01', '1', '点赞', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);

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
INSERT INTO `t_green_gold_zjmx` VALUES ('0320760e2040492ca0ca8fdc51b2d4f9', '06d4d91d9e6047febae59a017c135b91', '50.0000', '2019-08-29 16:07:42', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-29 16:07:42', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('109b9e32d74242efbfe819dee5dccc98', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 15:36:44', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:36:44', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('1c7d4d16e7b049019b2165c595aa890a', '563d03768ba644f2827f1afd6703ba1e', '500.0000', '2019-08-29 15:37:26', 'C_GOLD_ZJYY_3', '完成植物捐赠', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('23df0e09517046b1a5b6cb94bef7b3c2', '441d1b15644a42ffb6670cdf4e0abca1', '50.0000', '2019-08-27 10:41:22', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:22', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('2db429c1b3a8424c9c1ace4111cbb7c3', '06d4d91d9e6047febae59a017c135b91', '50.0000', '2019-08-27 10:41:30', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:30', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('467c29a076984a48a62cddaffd5d4bb3', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-27 09:45:11', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:11', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('4f0a950d7fa14260aa0d297daa83814b', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-09-02 15:13:18', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('515121af6770447180f905a921f33fb7', 'a42038e3950a441b945f46081f5e097f', '50.0000', '2019-09-02 17:22:28', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('52b2b90c333f4f058f3064a62cfaa595', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-09-02 15:03:04', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:03:04', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('55abb96ce26c42aa8fb45e23deefc96c', 'b55cbb78e1e54da7a14171c34031f692', '50.0000', '2019-08-29 17:17:08', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:08', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('5c07ada051914b6fa4e18badcf9d657a', 'aee52760658d49b0bafb298bc171eb68', '50.0000', '2019-08-29 17:27:05', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:27:05', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('61d11f2866154ee1ab32d48b04eda79d', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-26 15:35:36', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-26 15:35:36', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('6611f3cd5ec643a5a07e3130a6385b8a', '563d03768ba644f2827f1afd6703ba1e', '393.0000', '2019-08-29 16:24:14', 'C_GOLD_ZJYY_4', '金币点赞活动奖励金币', '金币点赞活动奖励随机数量金币', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('6902ec7950e944d49eeaada782a29cf5', 'aee52760658d49b0bafb298bc171eb68', '50.0000', '2019-08-29 17:24:44', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:24:44', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('6b0e460f88884d4f88295c81c9bcf00b', 'a42038e3950a441b945f46081f5e097f', '50.0000', '2019-08-29 16:08:07', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-29 16:08:07', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('73c4cc4e91dd449c9033e62a133f10e7', 'cdc60bbeb94040e792bca23d9f9876ab', '404.0000', '2019-08-29 16:24:14', 'C_GOLD_ZJYY_4', '金币点赞活动奖励金币', '金币点赞活动奖励随机数量金币', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('76fe1072a6b7405fb7a3430d4e342683', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 15:11:17', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:11:17', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('967360e16ab8413a80de95fdb7ba283c', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 17:14:46', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:46', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('98e3fd8e6d87468bbd91548d26246b15', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-29 11:17:56', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 11:17:56', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('9d765a59d8db41b09720ab9524fac549', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-29 16:18:13', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:13', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('a4701754cf034cd3982d07752b51fa54', 'b55cbb78e1e54da7a14171c34031f692', '50.0000', '2019-08-26 10:23:01', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-26 10:23:01', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('b8d5eba4932f4ed5a2cbcfe59d912507', 'a42038e3950a441b945f46081f5e097f', '50.0000', '2019-08-27 10:41:12', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:12', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('c94d0f354a334722a157970ce0d7f737', 'aee52760658d49b0bafb298bc171eb68', '50.0000', '2019-08-29 17:22:57', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:22:57', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('c9fe437fccd04746835740d2bd7f39f1', 'cdc60bbeb94040e792bca23d9f9876ab', '50.0000', '2019-08-29 16:24:09', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('eaaa986de01d4f6f97b932b5114362bd', '563d03768ba644f2827f1afd6703ba1e', '50.0000', '2019-08-29 15:43:16', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:43:16', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('f041c371f6cc49d98852327b41bfc987', 'aee52760658d49b0bafb298bc171eb68', '50.0000', '2019-08-29 17:25:41', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:25:41', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('fb9b367c8c22499dafc16955b97b4b29', 'b55cbb78e1e54da7a14171c34031f692', '50.0000', '2019-08-29 16:06:40', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 16:06:40', null, null);
INSERT INTO `t_green_gold_zjmx` VALUES ('fd5b5f0f9d544dc5afc1d23a81c71edf', 'd1c3a5e76a944392b919709509fb9cd9', '50.0000', '2019-08-29 11:16:45', 'C_GOLD_ZJYY_1', '完成种植任务', null, '1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-29 11:16:45', null, null);

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
  `n_fkje` decimal(12,4) DEFAULT NULL COMMENT '付款金额(用多少人民币兑换能量）',
  `c_skzh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款账户',
  `d_sksj` datetime DEFAULT NULL COMMENT '收款时间',
  `c_skfs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款方式(支付宝/微信/银行卡）',
  `c_skyh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款银行（收款方式为银行卡是填写）',
  `c_skkh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款银行卡号',
  `c_sksfcg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款是否成功（0否1是）',
  `c_skdh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款单号',
  `n_sknl` decimal(8,4) DEFAULT NULL COMMENT '收款能量',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='能量充值记录';

-- ----------------------------
-- Records of t_green_nl_czjl
-- ----------------------------
INSERT INTO `t_green_nl_czjl` VALUES ('e66eca64ccc74361b70876cecc0f9dc8', '563d03768ba644f2827f1afd6703ba1e', '18328023251', '1', '2019-08-23 16:34:55', '', '', '1', '46546546', '100.0000', '13255555555', '2019-08-23 16:34:59', '1', '', '', '1', '456464', '100.0000', '1', '张三充值100', '3309b23c28584179b9d69e226e3eeeee', '2019-08-23 16:35:33', null, null);

-- ----------------------------
-- Table structure for t_green_nl_gfjl
-- ----------------------------
DROP TABLE IF EXISTS `t_green_nl_gfjl`;
CREATE TABLE `t_green_nl_gfjl` (
  `c_lsh` varchar(255) NOT NULL COMMENT '流水号',
  `d_kssj` datetime DEFAULT NULL COMMENT '本轮瓜分开始时间',
  `d_gfsj` datetime NOT NULL COMMENT '瓜分时间（本轮瓜分结束时间）',
  `n_gfzl` decimal(8,4) NOT NULL COMMENT '瓜分总量',
  `c_czr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '调用瓜分服务的操作员',
  `c_zt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='瓜分能量记录（记录历史数据）';

-- ----------------------------
-- Records of t_green_nl_gfjl
-- ----------------------------
INSERT INTO `t_green_nl_gfjl` VALUES ('67b00a87c70c4309ba4a412fefc81de9', null, '2019-08-29 16:18:56', '7.0000', 'cdc60bbeb94040e792bca23d9f9876ab', '1');
INSERT INTO `t_green_nl_gfjl` VALUES ('7f6eafea0e894f318d650ac4f7b5c0f8', null, '2019-08-29 15:57:15', '7.0000', '563d03768ba644f2827f1afd6703ba1e', '1');
INSERT INTO `t_green_nl_gfjl` VALUES ('a7121649c2af48bca1cab46c1d2cc8b5', null, '2019-08-27 11:02:09', '5.0000', '563d03768ba644f2827f1afd6703ba1e', '1');
INSERT INTO `t_green_nl_gfjl` VALUES ('b78b5d79997341709280b9d6410e4b78', null, '2019-08-29 16:24:14', '7.0000', 'cdc60bbeb94040e792bca23d9f9876ab', '1');
INSERT INTO `t_green_nl_gfjl` VALUES ('e350f996cb0440d8afbb24c6409c0014', null, '2019-08-29 16:09:01', '7.0000', '563d03768ba644f2827f1afd6703ba1e', '1');

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
INSERT INTO `t_green_nl_hz` VALUES ('06d4d91d9e6047febae59a017c135b91', '114.0000', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-23 15:40:43', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_nl_hz` VALUES ('2e51d42dd4fe459590810112aa242c62', '0.0000', null, '1', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:24', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:44');
INSERT INTO `t_green_nl_hz` VALUES ('34617ade93c0495dbbaf17630a724e83', '0.0000', null, '1', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:03', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:30');
INSERT INTO `t_green_nl_hz` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '0.0000', null, '1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:46:59', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:47:26');
INSERT INTO `t_green_nl_hz` VALUES ('563d03768ba644f2827f1afd6703ba1e', '258.0000', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:00:13', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 16:56:19');
INSERT INTO `t_green_nl_hz` VALUES ('946e2d05f1234f37aad54651bd5bfae3', '0.0000', null, '1', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:15:41', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:16:08');
INSERT INTO `t_green_nl_hz` VALUES ('a42038e3950a441b945f46081f5e097f', '144.0000', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:01:13', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_nl_hz` VALUES ('aee52760658d49b0bafb298bc171eb68', '0.0000', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:45:59', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:46:32');
INSERT INTO `t_green_nl_hz` VALUES ('b19afeb2118e404c9d66fa568bb5eb85', '0.0000', null, '1', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:00', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:42');
INSERT INTO `t_green_nl_hz` VALUES ('b55cbb78e1e54da7a14171c34031f692', '164.0000', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:41:08', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14');
INSERT INTO `t_green_nl_hz` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '56.0000', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:47:59', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56');
INSERT INTO `t_green_nl_hz` VALUES ('d1c3a5e76a944392b919709509fb9cd9', '0.0000', null, '1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:21:07', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:57:42');

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
INSERT INTO `t_green_nl_jsnlmx` VALUES ('46bd06b0816f4e9e8bf89e81b07dd9d2', '563d03768ba644f2827f1afd6703ba1e', '100.0000', '2019-08-30 16:56:19', '1', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 16:56:19', null, null);

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
-- Records of t_green_nl_zjnlmx
-- ----------------------------
INSERT INTO `t_green_nl_zjnlmx` VALUES ('04533e65d09f446c9c79e3f826b4ac53', '06d4d91d9e6047febae59a017c135b91', '38.0000', '2019-08-29 16:18:56', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('0969054de50a4910861ff13b7f4c3c0d', 'a42038e3950a441b945f46081f5e097f', '88.0000', '2019-08-29 16:24:14', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('0cfb1c30258c41d0b88d75e2904337d4', '563d03768ba644f2827f1afd6703ba1e', '88.0000', '2019-08-29 16:18:56', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('18c1045df4ef47a8afcf50f9e69130e3', '06d4d91d9e6047febae59a017c135b91', '38.0000', '2019-08-29 16:09:01', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('1d0ec6d9a39445ce8f018e618ba3de69', 'a42038e3950a441b945f46081f5e097f', '18.0000', '2019-08-27 11:02:09', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-27 11:02:09', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('237a2d1f681b446ea455f9837535d978', 'cdc60bbeb94040e792bca23d9f9876ab', '18.0000', '2019-08-29 15:57:15', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('31f46803914d4e5199a49baf429f1131', '06d4d91d9e6047febae59a017c135b91', '58.0000', '2019-08-29 15:57:15', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('38af0aeb0fe841fc8687244c30649a57', 'a42038e3950a441b945f46081f5e097f', '18.0000', '2019-08-29 16:18:56', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('4158a1b01f364c879ec9145193a139d0', 'b55cbb78e1e54da7a14171c34031f692', '18.0000', '2019-08-29 15:57:15', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('58a86a8c422d45da8edd4261177d1732', 'a42038e3950a441b945f46081f5e097f', '18.0000', '2019-08-29 16:09:01', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('62a663791203483b86aed2dafaa7e0e2', '563d03768ba644f2827f1afd6703ba1e', '112.0000', '2019-08-29 15:37:26', '4', null, null, '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('6d9221d395094c9aad2e17bff915e861', '563d03768ba644f2827f1afd6703ba1e', '88.0000', '2019-08-29 15:57:15', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('7cae5d75ff184c3e9e49efa34cada32f', 'cdc60bbeb94040e792bca23d9f9876ab', '38.0000', '2019-08-27 11:02:09', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-27 11:02:09', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('80beadb38b8e40cc966b35b1819dc279', '563d03768ba644f2827f1afd6703ba1e', '88.0000', '2019-08-29 16:09:01', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('94ab5a8e1e554b639209132e0692e3ed', '563d03768ba644f2827f1afd6703ba1e', '100.0000', '2019-08-23 16:35:33', '5', null, '1', '3309b23c28584179b9d69e226e3eeeee', '2019-08-23 16:35:33', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('97bba09dc2aa44d190433dabfd5c0ae7', 'b55cbb78e1e54da7a14171c34031f692', '58.0000', '2019-08-29 16:18:56', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('99fc925b50ef4d789224c33f67d4cdac', 'cdc60bbeb94040e792bca23d9f9876ab', '18.0000', '2019-08-29 16:09:01', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('b5c10e336d3f41aa8d45ce6870b78262', 'cdc60bbeb94040e792bca23d9f9876ab', '18.0000', '2019-08-29 16:18:56', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:18:56', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('bedc7b2fa2ec4a2ebfdc4b4d4559ed62', '563d03768ba644f2827f1afd6703ba1e', '58.0000', '2019-08-27 11:02:09', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-27 11:02:09', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('c5581b091a854a12b99eaa3e91635162', 'b55cbb78e1e54da7a14171c34031f692', '58.0000', '2019-08-29 16:24:14', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('da79e8a9869a4dc5a49e1026a79334c1', '06d4d91d9e6047febae59a017c135b91', '18.0000', '2019-08-27 11:02:09', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-27 11:02:09', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('dab182cdfc384f7097a002bc6aa5b5ff', 'a42038e3950a441b945f46081f5e097f', '38.0000', '2019-08-29 15:57:15', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:57:15', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('e328004fa38d465f8346796a5273ad9e', 'b55cbb78e1e54da7a14171c34031f692', '58.0000', '2019-08-29 16:09:01', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 16:09:01', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('e4af1802bfbc4e719fc05dd9cf21b9de', 'b55cbb78e1e54da7a14171c34031f692', '88.0000', '2019-08-27 11:02:09', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-27 11:02:09', null, null);
INSERT INTO `t_green_nl_zjnlmx` VALUES ('e9d68020ddd945d490ff984bc905cc8c', '06d4d91d9e6047febae59a017c135b91', '38.0000', '2019-08-29 16:24:14', 'C_NL_ZJYY_3', '金币点赞瓜分能量获得奖励', '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:14', null, null);

-- ----------------------------
-- Table structure for t_green_rw_rwhz
-- ----------------------------
DROP TABLE IF EXISTS `t_green_rw_rwhz`;
CREATE TABLE `t_green_rw_rwhz` (
  `c_userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员ID',
  `n_ljwccs` int(11) DEFAULT NULL COMMENT '累计完成次数(三项任务加起来次数,不大于90次）',
  `c_bz` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `c_zt` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0无效1有效)',
  `c_cjuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `d_cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `c_xguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `d_xgsj` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`c_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='基础任务完成汇总表（用于用户一个月完成任务次数）';

-- ----------------------------
-- Records of t_green_rw_rwhz
-- ----------------------------
INSERT INTO `t_green_rw_rwhz` VALUES ('06d4d91d9e6047febae59a017c135b91', '3', null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwhz` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '3', null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwhz` VALUES ('563d03768ba644f2827f1afd6703ba1e', '15', null, '1', null, null, '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18');
INSERT INTO `t_green_rw_rwhz` VALUES ('a42038e3950a441b945f46081f5e097f', '3', null, '1', null, null, 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28');
INSERT INTO `t_green_rw_rwhz` VALUES ('aee52760658d49b0bafb298bc171eb68', '6', null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwhz` VALUES ('b55cbb78e1e54da7a14171c34031f692', '3', null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwhz` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '6', null, '1', null, null, null, null);

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
INSERT INTO `t_green_rw_rwmx` VALUES ('06d4d91d9e6047febae59a017c135b91', '1', '2019-08-27', '2019-08', '2019-08-27 10:41:29', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:29', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('06d4d91d9e6047febae59a017c135b91', '2', '2019-08-27', '2019-08', '2019-08-27 10:41:30', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:30', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('06d4d91d9e6047febae59a017c135b91', '3', '2019-08-27', '2019-08', '2019-08-27 10:41:30', null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-27 10:41:30', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '1', '2019-08-27', '2019-08', '2019-08-27 10:41:20', null, '0', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:20', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '2', '2019-08-27', '2019-08', '2019-08-27 10:41:22', null, '0', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:22', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('441d1b15644a42ffb6670cdf4e0abca1', '3', '2019-08-27', '2019-08', '2019-08-27 10:41:21', null, '0', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-27 10:41:21', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '1', '2018-08-31', '2019-08', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '1', '2019-08-29', '2019-08', '2019-08-29 17:14:41', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:41', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18');
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '1', '2019-08-30', '2019-08', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '1', '2019-09-01', '2019-09', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '1', '2019-09-02', '2019-09', '2019-09-02 15:13:06', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:06', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '2', '2018-08-31', '2019-08', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '2', '2019-08-29', '2019-08', '2019-08-29 17:12:32', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:12:32', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18');
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '2', '2019-08-30', '2019-08', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '2', '2019-09-01', '2019-09', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '2', '2019-09-02', '2019-09', '2019-09-02 15:13:12', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:12', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '3', '2018-08-31', '2019-08', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '3', '2019-08-29', '2019-08', '2019-08-29 17:14:46', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 17:14:46', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18');
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '3', '2019-08-30', '2019-08', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '3', '2019-09-01', '2019-09', null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('563d03768ba644f2827f1afd6703ba1e', '3', '2019-09-02', '2019-09', '2019-09-02 15:13:18', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-09-02 15:13:18', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a42038e3950a441b945f46081f5e097f', '1', '2019-08-27', '2019-08', '2019-08-27 10:41:11', null, '0', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:11', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28');
INSERT INTO `t_green_rw_rwmx` VALUES ('a42038e3950a441b945f46081f5e097f', '1', '2019-09-02', '2019-09', '2019-09-02 17:21:14', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:21:14', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a42038e3950a441b945f46081f5e097f', '2', '2019-08-27', '2019-08', '2019-08-27 10:41:10', null, '0', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:10', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28');
INSERT INTO `t_green_rw_rwmx` VALUES ('a42038e3950a441b945f46081f5e097f', '2', '2019-09-02', '2019-09', '2019-09-02 17:22:28', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('a42038e3950a441b945f46081f5e097f', '3', '2019-08-27', '2019-08', '2019-08-27 10:41:12', null, '0', 'a42038e3950a441b945f46081f5e097f', '2019-08-27 10:41:12', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:28');
INSERT INTO `t_green_rw_rwmx` VALUES ('a42038e3950a441b945f46081f5e097f', '3', '2019-09-02', '2019-09', '2019-09-02 17:22:23', null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-09-02 17:22:23', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('aee52760658d49b0bafb298bc171eb68', '1', '2019-08-28', null, null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('aee52760658d49b0bafb298bc171eb68', '1', '2019-08-29', '2019-08', '2019-08-29 17:20:45', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:20:45', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('aee52760658d49b0bafb298bc171eb68', '2', '2019-08-28', null, null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('aee52760658d49b0bafb298bc171eb68', '2', '2019-08-29', '2019-08', '2019-08-29 17:27:05', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:27:05', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('aee52760658d49b0bafb298bc171eb68', '3', '2019-08-28', null, null, null, '1', null, null, null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('aee52760658d49b0bafb298bc171eb68', '3', '2019-08-29', '2019-08', '2019-08-29 17:25:41', null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-29 17:25:41', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('b55cbb78e1e54da7a14171c34031f692', '1', '2019-08-29', '2019-08', '2019-08-29 17:16:58', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:16:58', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('b55cbb78e1e54da7a14171c34031f692', '2', '2019-08-29', '2019-08', '2019-08-29 17:17:07', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:07', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('b55cbb78e1e54da7a14171c34031f692', '3', '2019-08-29', '2019-08', '2019-08-29 17:17:08', null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-29 17:17:08', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '1', '2019-08-27', '2019-08', '2019-08-27 09:45:10', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:10', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '1', '2019-08-29', '2019-08', '2019-08-29 16:24:07', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:07', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '2', '2019-08-27', '2019-08', '2019-08-27 09:45:11', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:11', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '2', '2019-08-29', '2019-08', '2019-08-29 16:24:09', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '3', '2019-08-27', '2019-08', '2019-08-27 09:45:11', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-27 09:45:11', null, null);
INSERT INTO `t_green_rw_rwmx` VALUES ('cdc60bbeb94040e792bca23d9f9876ab', '3', '2019-08-29', '2019-08', '2019-08-29 16:24:09', null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-29 16:24:09', null, null);

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
-- Records of t_green_sp_spmx
-- ----------------------------
INSERT INTO `t_green_sp_spmx` VALUES ('1', '仙人掌', '仙人掌是仙人掌科缩刺仙人掌的变种，仙人掌喜光、耐旱，适合在中性、微碱性土壤生长。通常栽作围篱，茎供药用，浆果酸甜可食。', '100.00', '能量', '/publicImg/system/1.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:32:52');
INSERT INTO `t_green_sp_spmx` VALUES ('10', '金琥', '金琥属多年生草本多浆植物，适生海拔高，阳光充足，冬季气候温和。金琥性喜阳光充足，多喜肥沃、透水性好的沙壤土。', '100000.00', '能量', '/publicImg/system/10.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:42:32');
INSERT INTO `t_green_sp_spmx` VALUES ('2', '白刺', '白刺是蒺藜科白刺属的灌木，分枝多而密集，呈丛生状，具有很强固沙阻沙能力，生于荒漠和半荒漠的湖盆沙地、河流阶地、山前平原积沙地、有风积沙的粘土地。', '300.00', '能量', '/publicImg/system/2.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:33:38');
INSERT INTO `t_green_sp_spmx` VALUES ('3', '肉苁蓉', '肉苁蓉是一种寄生在沙漠树木梭梭根部的寄生植物，从梭梭寄主中吸取养分及水分。素有“沙漠人参”之美誉，具有极高的药用价值，是中国传统的名贵中药材。', '500.00', '能量', '/publicImg/system/3.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:34:21');
INSERT INTO `t_green_sp_spmx` VALUES ('4', '芦荟', '是芦荟属中少数可食用的物种之一，常绿、多肉质的草本植物 ，其制品被广泛应用于食品、美容、保健、医药等领域。', '1000.00', '能量', '/publicImg/system/4.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:35:10');
INSERT INTO `t_green_sp_spmx` VALUES ('5', '大犀角', '多年生肉质草本，茎四棱，高15－20厘米，黄绿色，中心淡紫色。', '3000.00', '能量', '/publicImg/system/5.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:35:54');
INSERT INTO `t_green_sp_spmx` VALUES ('6', '绿之玲', '绿之玲又名珍珠吊兰，性喜富含有机质的、疏松肥沃的土壤。在温暖、空气湿度较大、强散射光的环境下生长最佳。', '5000.00', '能量', '/publicImg/system/6.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:37:27');
INSERT INTO `t_green_sp_spmx` VALUES ('7', '生石花', '生石花形态奇特，花色艳丽，使得许多爱好者专门收集栽培，具有很高的观赏价值。喜温暖干燥和阳光充足环境，怕低温。', '10000.00', '能量', '/publicImg/system/7.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:38:16');
INSERT INTO `t_green_sp_spmx` VALUES ('8', '光棍树', '原产非洲东部（安哥拉），广泛栽培于热带和亚热带，并有逸为野生现象，抗旱本领强。', '30000.00', '能量', '/publicImg/system/8.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:40:21');
INSERT INTO `t_green_sp_spmx` VALUES ('9', '巨人柱', '巨人柱是世界最高的仙人掌品种之一，果肉可食，素有“仙桃”之称，茎干具有极强的储水能力，能活200年。', '50000.00', '能量', '/publicImg/system/9.jpg', null, '1', null, null, '3309b23c28584179b9d69e226e3eeeee', '2019-07-30 11:41:33');

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
INSERT INTO `t_green_zz_jzjl` VALUES ('128641454ac14b92aa492a7ae3fe2290', '8519c2bc5da44d119bb1a05b4a344303', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26', '1', null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26', null, null);

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
INSERT INTO `t_green_zz_zjzzmx` VALUES ('00fb897b5b624f90a6aa6223e1c28772', 'b55cbb78e1e54da7a14171c34031f692', '1', '1', '2019-08-21 10:41:08', '0', '0', null, null, '1', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-21 10:41:08', 'b55cbb78e1e54da7a14171c34031f692', '2019-08-23 16:41:50');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('14fb839af1ad4ed3862506cd7954c5fe', '946e2d05f1234f37aad54651bd5bfae3', '1', '1', '2019-08-30 17:15:41', '0', '0', null, null, '1', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:15:41', '946e2d05f1234f37aad54651bd5bfae3', '2019-08-30 17:16:08');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('31f245259d3d4644946a9d13e1d9924c', '441d1b15644a42ffb6670cdf4e0abca1', '1', '1', '2019-08-26 15:46:59', '0', '0', null, null, '1', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:46:59', '441d1b15644a42ffb6670cdf4e0abca1', '2019-08-26 15:47:26');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('32e9865945f142f4be3d6fb473956ea1', 'd1c3a5e76a944392b919709509fb9cd9', '1', '1', '2019-08-26 15:21:07', '0', '0', null, null, '1', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:21:07', 'd1c3a5e76a944392b919709509fb9cd9', '2019-08-26 15:57:42');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('337ef0199d35439483bf4faca7273389', 'aee52760658d49b0bafb298bc171eb68', '1', '1', '2019-08-26 15:45:59', '0', '0', null, null, '1', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:45:59', 'aee52760658d49b0bafb298bc171eb68', '2019-08-26 15:46:32');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('64d4a077cf664bf0a751f59270b1084d', '06d4d91d9e6047febae59a017c135b91', '1', '1', '2019-08-23 15:40:43', '0', '0', null, null, '1', '06d4d91d9e6047febae59a017c135b91', '2019-08-23 15:40:43', '06d4d91d9e6047febae59a017c135b91', '2019-08-26 15:49:16');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('6e16d4e63c3846f596f3dd6eaaa1350f', 'b19afeb2118e404c9d66fa568bb5eb85', '1', '1', '2019-08-26 15:51:00', '0', '0', null, null, '1', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:00', 'b19afeb2118e404c9d66fa568bb5eb85', '2019-08-26 15:51:42');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('70a640af1bcc45b5954c8e411e2b707f', 'cdc60bbeb94040e792bca23d9f9876ab', '1', '1', '2019-08-26 15:47:59', '0', '0', null, null, '1', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:47:59', 'cdc60bbeb94040e792bca23d9f9876ab', '2019-08-26 15:48:26');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('8519c2bc5da44d119bb1a05b4a344303', '563d03768ba644f2827f1afd6703ba1e', '1', '1', '2019-08-23 16:00:13', '1', '1', '2019-08-29 15:37:26', null, '0', '563d03768ba644f2827f1afd6703ba1e', '2019-08-23 16:00:13', '563d03768ba644f2827f1afd6703ba1e', '2019-08-29 15:37:26');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('8e8baa920c964deeb08b535ea9f372f9', 'a42038e3950a441b945f46081f5e097f', '1', '1', '2019-08-23 16:01:13', '0', '0', null, null, '1', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:01:13', 'a42038e3950a441b945f46081f5e097f', '2019-08-23 16:39:14');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('a974071f0ede4cab8296557fa5382804', '563d03768ba644f2827f1afd6703ba1e', '1', '1', '2019-08-30 16:56:19', '0', '0', null, null, '1', '563d03768ba644f2827f1afd6703ba1e', '2019-08-30 16:56:19', null, null);
INSERT INTO `t_green_zz_zjzzmx` VALUES ('ac9863b46adf4692b099b4ffd2c09538', '2e51d42dd4fe459590810112aa242c62', '1', '1', '2019-08-26 15:52:24', '0', '0', null, null, '1', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:24', '2e51d42dd4fe459590810112aa242c62', '2019-08-26 15:52:44');
INSERT INTO `t_green_zz_zjzzmx` VALUES ('ff6822fbde214b7b9a839067cff94e4a', '34617ade93c0495dbbaf17630a724e83', '1', '1', '2019-08-26 15:50:03', '0', '0', null, null, '1', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:03', '34617ade93c0495dbbaf17630a724e83', '2019-08-26 15:50:30');
