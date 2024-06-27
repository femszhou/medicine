/*
 Navicat Premium Data Transfer

 Source Server         : 50
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : medicinemis

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 27/06/2024 16:41:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `administrator_no` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `administrator_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `administrator_sex` int NOT NULL COMMENT '性别',
  `administrator_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `administrator_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码',
  `administrator_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型',
  `administrator_remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`administrator_no`) USING BTREE,
  UNIQUE INDEX `administrator_phone`(`administrator_phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'root', 1, '123456', 'admin', '管理员', '管理员');

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer`  (
  `buyer_no` int NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编号',
  `buyer_sex` int NOT NULL COMMENT '性别',
  `buyer_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `buyer_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码',
  `buyer_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型',
  `buyer_remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`buyer_no`) USING BTREE,
  UNIQUE INDEX `buyer_phone`(`buyer_phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES (1, 'zoro', 1, '123456', 'buyer', '管理员', '无');
INSERT INTO `buyer` VALUES (2, 'aaaa', 1, 'asfasdfasfsag', '13745274628', '无', '无');
INSERT INTO `buyer` VALUES (3, 'aaaa', 1, 'asdgkjbasgk', '17312538472', '无', '无');
INSERT INTO `buyer` VALUES (9, '2', 1, '1', '2', '1', NULL);
INSERT INTO `buyer` VALUES (10, '1', 1, '1', '1', '1', NULL);
INSERT INTO `buyer` VALUES (15, '4', 1, '4', '4', '4', '4');
INSERT INTO `buyer` VALUES (20, 'zh', 1, '123', '123', '123', '1');
INSERT INTO `buyer` VALUES (24, 'er', 1, '123', '1233', '1', '1');
INSERT INTO `buyer` VALUES (25, 'er', 1, '11', '312412', '11', NULL);
INSERT INTO `buyer` VALUES (26, '123', 123, '3123', '1231', '123', '1');
INSERT INTO `buyer` VALUES (28, '讲座', 0, '347rq', '41341', '苏北', '你好');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `client_no` int NOT NULL AUTO_INCREMENT COMMENT '顾客编号',
  `client_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `client_sex` int NOT NULL COMMENT '性别',
  `client_age` int NULL DEFAULT NULL COMMENT '年龄',
  `client_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `client_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话',
  `client_date` datetime NOT NULL COMMENT '注册日期',
  `client_symptom` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '症状',
  `client_remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`client_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (1, '吴骏', 1, 20, 'rh-2-530', '16473829472', '2023-10-02 00:00:00', 'sadfadsf', '无');
INSERT INTO `client` VALUES (2, 'wujun', 1, 20, 'rh-2-530', '16473829472', '2023-10-02 00:00:00', 'asdfadsf', '无');
INSERT INTO `client` VALUES (3, '阿斯蒂芬', 1, 20, '肇庆学院', '17283619392', '2023-10-18 21:26:45', '咳嗽', '无');
INSERT INTO `client` VALUES (4, '2', 2, 2, '2', '1', '2023-11-21 20:13:52', '2', NULL);
INSERT INTO `client` VALUES (5, '2', 2, 2, '2', '2', '2023-11-21 20:13:59', '2', NULL);
INSERT INTO `client` VALUES (6, '3', 4, 5, '2', '5', '2023-11-21 20:14:05', '1', '1');
INSERT INTO `client` VALUES (7, '2', 2, 2, '2', '2', '2023-11-21 20:14:14', '2', NULL);
INSERT INTO `client` VALUES (8, '2', 2, 2, '2', '2', '2023-11-21 20:14:26', '2', '2');
INSERT INTO `client` VALUES (9, '4', 4, 3, '3', '2', '2023-11-21 20:15:19', '3', '1');
INSERT INTO `client` VALUES (10, '2', 2, 2, '2', '2', '2023-11-21 20:15:30', '2', '2');
INSERT INTO `client` VALUES (11, '1', 2, 2, '1', '1', '2023-11-21 20:15:36', '1', NULL);
INSERT INTO `client` VALUES (12, '1', 1, 1, '1', '1', '2023-11-21 20:17:51', '1', NULL);

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `medicine_no` int NOT NULL AUTO_INCREMENT COMMENT '药品编号',
  `medicine_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品名称',
  `medicine_image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `medicine_mode` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服用方法',
  `medicine_efficacy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '功效',
  `medicine_price` int NOT NULL COMMENT '价格',
  `medicine_count` int NOT NULL COMMENT '库存',
  PRIMARY KEY (`medicine_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES (2, '夏桑菊', NULL, '口服', '清热解毒', 15, 20);
INSERT INTO `medicine` VALUES (7, '他们', NULL, '21', '1', 2, 0);
INSERT INTO `medicine` VALUES (8, '你好', NULL, '2', '1', 3, 3);
INSERT INTO `medicine` VALUES (9, '1', NULL, '2', '3', 4, 3);
INSERT INTO `medicine` VALUES (10, '3', NULL, '3', '3', 3, 0);
INSERT INTO `medicine` VALUES (11, '1', NULL, '2', '3', 4, 3);
INSERT INTO `medicine` VALUES (12, '1', NULL, '1', '2', 3, 2);
INSERT INTO `medicine` VALUES (13, '4', NULL, '3', '1', 3, 1);
INSERT INTO `medicine` VALUES (14, '6', NULL, '6', '6', 5, 5);
INSERT INTO `medicine` VALUES (15, '4', NULL, '4', '5', 4, 2);
INSERT INTO `medicine` VALUES (16, '6', NULL, '6', '6', 6, 6);
INSERT INTO `medicine` VALUES (17, '1', NULL, '1', '1', 1, 1);

-- ----------------------------
-- Table structure for medicine_orders
-- ----------------------------
DROP TABLE IF EXISTS `medicine_orders`;
CREATE TABLE `medicine_orders`  (
  `medicine_orders_no` int NOT NULL AUTO_INCREMENT COMMENT '药品订单关系编号',
  `medicine_no` int NOT NULL COMMENT '药品编号',
  `orders_no` int NOT NULL COMMENT '订单编号',
  `medicine_number` int NULL DEFAULT NULL COMMENT '购买数量',
  `price` int NOT NULL,
  PRIMARY KEY (`medicine_orders_no`) USING BTREE,
  UNIQUE INDEX `m_o_no`(`medicine_orders_no` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药物订单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine_orders
-- ----------------------------
INSERT INTO `medicine_orders` VALUES (1, 4, 29, 10, 100);
INSERT INTO `medicine_orders` VALUES (2, 4, 30, 10, 100);
INSERT INTO `medicine_orders` VALUES (3, 4, 30, 10, 100);
INSERT INTO `medicine_orders` VALUES (10, 3, 31, 17, 10);
INSERT INTO `medicine_orders` VALUES (11, 2, 31, 30, 10);
INSERT INTO `medicine_orders` VALUES (12, 3, 34, 4, 10);
INSERT INTO `medicine_orders` VALUES (13, 3, 33, 1, 10);
INSERT INTO `medicine_orders` VALUES (14, 2, 31, 2, 20);
INSERT INTO `medicine_orders` VALUES (15, 3, 31, 1, 16);
INSERT INTO `medicine_orders` VALUES (16, 2, 34, 1, 20);
INSERT INTO `medicine_orders` VALUES (17, 3, 34, 1, 16);
INSERT INTO `medicine_orders` VALUES (18, 2, 33, 1, 20);
INSERT INTO `medicine_orders` VALUES (19, 3, 33, 1, 16);
INSERT INTO `medicine_orders` VALUES (20, 1, 31, 1, 12);
INSERT INTO `medicine_orders` VALUES (21, 7, 31, 1, 2);
INSERT INTO `medicine_orders` VALUES (22, 7, 33, 1, 2);
INSERT INTO `medicine_orders` VALUES (23, 2, 33, 4, 16);
INSERT INTO `medicine_orders` VALUES (24, 7, 34, 1, 2);
INSERT INTO `medicine_orders` VALUES (25, 2, 34, 1, 16);
INSERT INTO `medicine_orders` VALUES (26, 2, 31, 1, 16);
INSERT INTO `medicine_orders` VALUES (29, 2, 35, 3, 16);
INSERT INTO `medicine_orders` VALUES (30, 2, 41, 2, 16);
INSERT INTO `medicine_orders` VALUES (31, 7, 41, 1, 2);
INSERT INTO `medicine_orders` VALUES (32, 2, 36, 1, 16);
INSERT INTO `medicine_orders` VALUES (33, 7, 36, 1, 2);
INSERT INTO `medicine_orders` VALUES (34, 8, 36, 1, 3);
INSERT INTO `medicine_orders` VALUES (35, 9, 36, 1, 4);
INSERT INTO `medicine_orders` VALUES (36, 10, 36, 2, 3);
INSERT INTO `medicine_orders` VALUES (37, 11, 36, 1, 4);
INSERT INTO `medicine_orders` VALUES (38, 12, 36, 1, 3);
INSERT INTO `medicine_orders` VALUES (40, 2, 44, 2, 15);
INSERT INTO `medicine_orders` VALUES (41, 8, 44, 1, 3);
INSERT INTO `medicine_orders` VALUES (42, 9, 44, 1, 4);
INSERT INTO `medicine_orders` VALUES (43, 10, 44, 1, 3);
INSERT INTO `medicine_orders` VALUES (44, 11, 44, 1, 4);
INSERT INTO `medicine_orders` VALUES (45, 12, 44, 1, 3);
INSERT INTO `medicine_orders` VALUES (46, 13, 44, 1, 3);
INSERT INTO `medicine_orders` VALUES (47, 14, 44, 1, 5);
INSERT INTO `medicine_orders` VALUES (48, 15, 44, 1, 4);
INSERT INTO `medicine_orders` VALUES (49, 2, 31, 2, 15);
INSERT INTO `medicine_orders` VALUES (50, 8, 31, 1, 3);
INSERT INTO `medicine_orders` VALUES (51, 2, 41, 1, 15);
INSERT INTO `medicine_orders` VALUES (52, 2, 36, 1, 15);

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator`  (
  `operator_no` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `operator_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `operator_sex` int NOT NULL COMMENT '性别',
  `operator_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `operator_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码',
  `operator_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型',
  `operator_remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`operator_no`) USING BTREE,
  UNIQUE INDEX `operator_phone`(`operator_phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES (3, 'sadfadf', 1, '123456', 'operator', '经办人', '001');
INSERT INTO `operator` VALUES (6, 'eeqwe', 1, 'qweqwe', 'qwe', 'qwe', 'q');
INSERT INTO `operator` VALUES (7, 'wqe', 1231, '123', '123', '13', NULL);
INSERT INTO `operator` VALUES (8, '12wqe', 23, '123', '21241', '131', '1');
INSERT INTO `operator` VALUES (9, '45', 12, '11', '1412312', NULL, '1');
INSERT INTO `operator` VALUES (10, '23123', 123, '312', '11', '31', '12');
INSERT INTO `operator` VALUES (11, '12', 1321, '23', '1', '231', '1');
INSERT INTO `operator` VALUES (12, '2131', 3123, '1231', '1233123', '1', NULL);
INSERT INTO `operator` VALUES (13, '3123', 1233123, '2312312', '31231231', '3123', NULL);
INSERT INTO `operator` VALUES (14, '31', 3123, '132', '123123', '13', '1');
INSERT INTO `operator` VALUES (15, '312', 31231, '312', '31231', '31', NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orders_no` int NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `client_no` int NOT NULL COMMENT '用户编号',
  `orders_date` datetime NOT NULL COMMENT '订单日期',
  `operator_no` int NOT NULL COMMENT '经办人编号',
  `total_price` int NULL DEFAULT NULL COMMENT '总价钱',
  PRIMARY KEY (`orders_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (36, 1, '2023-11-21 14:38:23', 1, 53);
INSERT INTO `orders` VALUES (37, 1, '2023-11-21 14:38:31', 1, 0);
INSERT INTO `orders` VALUES (38, 2, '2023-11-21 14:38:35', 2, 0);
INSERT INTO `orders` VALUES (39, 3, '2023-11-21 14:38:39', 3, 0);
INSERT INTO `orders` VALUES (40, 2, '2023-11-21 14:38:46', 2, 0);
INSERT INTO `orders` VALUES (41, 4, '2023-11-21 14:38:50', 4, 49);
INSERT INTO `orders` VALUES (42, 6, '2023-11-21 14:38:54', 6, 0);
INSERT INTO `orders` VALUES (43, 3, '2023-11-21 20:39:14', 3, 0);
INSERT INTO `orders` VALUES (44, 5, '2023-11-21 20:40:01', 5, 59);
INSERT INTO `orders` VALUES (45, 2, '2023-11-24 19:31:40', 1, 0);
INSERT INTO `orders` VALUES (46, 4, '2023-11-24 19:31:52', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
