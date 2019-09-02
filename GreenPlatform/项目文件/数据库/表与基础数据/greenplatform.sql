/*
Navicat MySQL Data Transfer

Source Server         : GreenPlatform
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : greenplatform

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-09-02 17:27:12
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
INSERT INTO `plate_user` VALUES ('3309b23c28584179b9d69e226e3eeeee', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', 'admin', '系统管理员', '1', '0', null, null, '1', '1', '1', '1', '1', '1212', '121212', '18328823251', '18328023251', '1271826981', '1213@qq.com', null, null, '测试测试', '1', '3309b23c28584179b9d69e226e3eeeee', '2019-06-25 14:49:27', '3309b23c28584179b9d69e226e3eeeee', '2019-08-29 14:23:51');

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
