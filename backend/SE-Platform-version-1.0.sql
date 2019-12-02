/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-mw8hntaa.bj.tencentcdb.com:10027
 Source Schema         : SE-Platform

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 30/11/2019 16:23:11
*/

drop database if exists test1;
create database test1 default character set utf8mb4;
use test1;

-- ----------------------------
-- Table structure for Confirmcode
-- ----------------------------
DROP TABLE IF EXISTS `Confirmcode`;
CREATE TABLE `Confirmcode`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `addtime` datetime(0) NULL DEFAULT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Confirmcode
-- ----------------------------
INSERT INTO `Confirmcode` VALUES (1, '2019-11-30 16:05:52', '13685630512', '12345');

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `user_id` int(10) NOT NULL,
  `user_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_addtime` date NULL DEFAULT NULL,
  `user_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_phone`(`user_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES (1652514, 'student', 'tom', '123456', 'male', '15311252365', '826210195@qq.com', '2019-11-30', NULL);
INSERT INTO `User` VALUES (1752514, 'student', 'lee', '123456', 'male', '13685630512', '1752514@tongji.edu.cn', '2019-11-30', '');

-- ----------------------------
-- Table structure for Messagetype
-- ----------------------------
DROP TABLE IF EXISTS `Messagetype`;
CREATE TABLE `Messagetype`  (
  `m_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`m_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Messagetype
-- ----------------------------
INSERT INTO `Messagetype` VALUES (1, 'text');
INSERT INTO `Messagetype` VALUES (2, 'img');

-- ----------------------------
-- Table structure for Message
-- ----------------------------
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_message` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `m_time` datetime(0) NULL DEFAULT NULL,
  `m_datatype` int(11) NULL DEFAULT NULL,
  `m_fromUser` int(10) NULL DEFAULT NULL,
  `m_toUser` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE,
  INDEX `m_fromUser`(`m_fromUser`) USING BTREE,
  INDEX `m_toUser`(`m_toUser`) USING BTREE,
  INDEX `m_datatype`(`m_datatype`) USING BTREE,
  CONSTRAINT `Message_ibfk_1` FOREIGN KEY (`m_fromUser`) REFERENCES `User` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Message_ibfk_2` FOREIGN KEY (`m_toUser`) REFERENCES `User` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Message_ibfk_3` FOREIGN KEY (`m_datatype`) REFERENCES `Messagetype` (`m_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Message
-- ----------------------------
INSERT INTO `Message` VALUES (1, 'hi', '2019-11-30 16:12:45', 1, 1752514, 1652514);

-- ----------------------------
-- Table structure for Module
-- ----------------------------
DROP TABLE IF EXISTS `Module`;
CREATE TABLE `Module`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE,
  INDEX `task_type`(`task_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Module
-- ----------------------------
INSERT INTO `Module` VALUES (1, '游戏/英雄联盟');
INSERT INTO `Module` VALUES (2, '游戏/dota');
INSERT INTO `Module` VALUES (3, '游戏/王者荣耀');
INSERT INTO `Module` VALUES (4, '生活');
INSERT INTO `Module` VALUES (5, '学习');
INSERT INTO `Module` VALUES (6, '体育/篮球');
INSERT INTO `Module` VALUES (7, '体育/羽毛球');
INSERT INTO `Module` VALUES (8, '体育/足球');
INSERT INTO `Module` VALUES (9, '其他');

-- ----------------------------
-- Table structure for Task
-- ----------------------------
DROP TABLE IF EXISTS `Task`;
CREATE TABLE `Task`  (
  `task_id` int(10) NOT NULL AUTO_INCREMENT,
  `task_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `task_type` int(10) NULL DEFAULT NULL,
  `task_bonus` float(10, 0) NULL DEFAULT NULL,
  `task_begin_time` datetime(0) NULL DEFAULT NULL,
  `task_end_time` datetime(0) NULL DEFAULT NULL,
  `task_publish_time` date NULL DEFAULT NULL,
  `task_publisher_id` int(10) NOT NULL,
  `task_executor_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`task_id`) USING BTREE,
  INDEX `task_publisher_id`(`task_publisher_id`) USING BTREE,
  INDEX `task_executor_id`(`task_executor_id`) USING BTREE,
  INDEX `task_type`(`task_type`) USING BTREE,
  CONSTRAINT `Task_ibfk_1` FOREIGN KEY (`task_publisher_id`) REFERENCES `User` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Task_ibfk_2` FOREIGN KEY (`task_executor_id`) REFERENCES `User` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Task_ibfk_3` FOREIGN KEY (`task_type`) REFERENCES `Module` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Task
-- ----------------------------
INSERT INTO `Task` VALUES (1, '陪玩', 1, 50, '2019-11-30 19:00:00', '2019-11-30 21:00:00', '2019-11-30', 1752514, 1652514);

-- ----------------------------
-- Table structure for Taskdrafts
-- ----------------------------
DROP TABLE IF EXISTS `Taskdrafts`;
CREATE TABLE `Taskdrafts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_creator` int(10) NULL DEFAULT NULL,
  `task_type` int(10) NULL DEFAULT NULL,
  `task_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `task_bonus` float(10, 0) NULL DEFAULT NULL,
  `task_begin_time` datetime(0) NULL DEFAULT NULL,
  `task_end_time` datetime(0) NULL DEFAULT NULL,
  `task_addtime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_creator`(`task_creator`) USING BTREE,
  INDEX `task_type`(`task_type`) USING BTREE,
  CONSTRAINT `Taskdrafts_ibfk_1` FOREIGN KEY (`task_creator`) REFERENCES `User` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Taskdrafts_ibfk_2` FOREIGN KEY (`task_type`) REFERENCES `Module` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Taskdrafts
-- ----------------------------
INSERT INTO `Taskdrafts` VALUES (1, 1752514, 1, '陪玩', 50, '2019-11-30 16:13:50', '2019-11-30 20:13:52', '2019-11-30');

-- ----------------------------
-- Table structure for Userstatus
-- ----------------------------
DROP TABLE IF EXISTS `Userstatus`;
CREATE TABLE `Userstatus`  (
  `user_id` int(10) NOT NULL,
  `user_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `Userstatus_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Userstatus
-- ----------------------------
INSERT INTO `Userstatus` VALUES (1652514, 'online');
INSERT INTO `Userstatus` VALUES (1752514, 'outline');

SET FOREIGN_KEY_CHECKS = 1;
