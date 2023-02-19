/*
 Navicat MySQL Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : storage

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 15/12/2022 23:29:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL,
  `num` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weight` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `produce` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `save` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recorder` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `num_UNIQUE`(`num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '11', '1', '1', '1', '2022-12-15T13:54:28.000Z', '1', '2022-12-15T13:54:31.000Z', '1');
INSERT INTO `article` VALUES (1001, '1001', '蒙牛牛奶', '3.5', '1kg', '2021/12/4', '6个月', '2021/12/5', '张三');
INSERT INTO `article` VALUES (1002, '1002', '香肠', '2', '500g', '2021/12/5', '6个月', '2021/12/5', '李四');
INSERT INTO `article` VALUES (1003, '1003', '方便面', '51', '1.5kg', '2021/12/4', '12个月', '2021/12/6', '王五');
INSERT INTO `article` VALUES (1004, '1004', '辣条', '1', '250g', '2021/12/6', '12个月', '2021/12/9', '王五');
INSERT INTO `article` VALUES (1005, '1005', '辣条', '1', '250g', '2021/12/6', '12个月', '2021/12/9', '王五');

SET FOREIGN_KEY_CHECKS = 1;
