/*
 Navicat Premium Data Transfer

 Source Server         : yang
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : studenttest

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 17/07/2022 10:40:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` int NOT NULL,
  `c_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_teacher` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '计算机网络', '金子韬');
INSERT INTO `course` VALUES (2, '软件工程', '孟璐');
INSERT INTO `course` VALUES (3, '软件测试', '汤杰宏');
INSERT INTO `course` VALUES (4, 'javaweb', '侯岚');
INSERT INTO `course` VALUES (5, 'SpringBoot', '刘詩涵');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `u_id` int NOT NULL,
  `u_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `u_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `u_isdelete` int NOT NULL,
  `u_role` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1027 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, '2258', '1234', '9999', 0, 0);
INSERT INTO `user` VALUES (2, 2, '123', '1234', '789', 0, 1);
INSERT INTO `user` VALUES (3, 3, '1234', '1234', '7890', 0, 1);
INSERT INTO `user` VALUES (1007, 810, 'Dennis Rivera', 'Ky1hYAJNdq', '74-205-6304', 0, 1);
INSERT INTO `user` VALUES (1008, 317, 'Meng Kwok Yin', '1234', '312-411-8939', 0, 1);
INSERT INTO `user` VALUES (1009, 159, 'Diana Morgan', 'ZnpXltNNWF', '(20) 3450 7128', 0, 1);
INSERT INTO `user` VALUES (1010, 52, 'Cho Kwok Wing', 'M8JmZrsxTp', '614-170-0943', 0, 1);
INSERT INTO `user` VALUES (1011, 979, 'Wong Sum Wing', 'G1LlW829eR', '66-663-6705', 0, 1);
INSERT INTO `user` VALUES (1012, 676, 'Marjorie Tucker', 'IYL0DU3nfu', '172-5791-0496', 0, 1);
INSERT INTO `user` VALUES (1013, 81, 'Loui Lai Yan', 'da9aj3gftu', '80-1647-1529', 0, 1);
INSERT INTO `user` VALUES (1014, 529, 'Song Ziyi', 'sRxEf4NNVZ', '(20) 0581 8019', 0, 1);
INSERT INTO `user` VALUES (1015, 197, 'Sheh Kwok Yin', 'FY30NLFQ1n', '7149 417198', 0, 1);
INSERT INTO `user` VALUES (1016, 189, 'Hung Kwok Kuen', 'PdWxfLXv9X', '7389 154970', 0, 1);
INSERT INTO `user` VALUES (1017, 58, 'Ota Kenta', 'djUSjY99C6', '(20) 2403 4105', 0, 1);
INSERT INTO `user` VALUES (1018, 354, 'Alan Kim', 'RO4KeqXlm3', '28-509-6534', 0, 1);
INSERT INTO `user` VALUES (1019, 262, 'Ren Zhiyuan', 'YfEA1CmbQ7', '199-7889-6639', 0, 1);
INSERT INTO `user` VALUES (1020, 813, 'Han Yuning', '7JN67yQ7HQ', '21-6267-3936', 0, 1);
INSERT INTO `user` VALUES (1021, 904, 'Kyle Myers', '6c3sbBsN3d', '213-896-4332', 0, 1);
INSERT INTO `user` VALUES (1022, 424, 'Wu Lu', 'Uryy4topVs', '172-7134-6647', 0, 1);
INSERT INTO `user` VALUES (1023, 384, 'Yeung Wing Kuen', 'zbbd7eanQX', '21-4831-3932', 0, 1);
INSERT INTO `user` VALUES (1024, 495, 'Stephanie Castillo', '4JchcRhJ7o', '330-060-1246', 0, 1);
INSERT INTO `user` VALUES (1025, 610, 'Joel Robinson', 'PQQ5I0KfUP', '11-726-7826', 0, 1);
INSERT INTO `user` VALUES (1026, 401, 'Ren Xiuying', '8gjT1JimFz', '28-097-6507', 0, 1);

-- ----------------------------
-- Table structure for userchoose
-- ----------------------------
DROP TABLE IF EXISTS `userchoose`;
CREATE TABLE `userchoose`  (
  `u_id` int NOT NULL,
  `c_id` int NOT NULL,
  `c_score` int NOT NULL,
  INDEX `u_id`(`u_id` ASC) USING BTREE,
  INDEX `c_id`(`c_id` ASC) USING BTREE,
  CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userchoose
-- ----------------------------
INSERT INTO `userchoose` VALUES (1, 1, 27);
INSERT INTO `userchoose` VALUES (1, 2, 81);
INSERT INTO `userchoose` VALUES (1, 3, 28);
INSERT INTO `userchoose` VALUES (1, 4, 26);
INSERT INTO `userchoose` VALUES (1, 5, 74);
INSERT INTO `userchoose` VALUES (2, 1, 6);
INSERT INTO `userchoose` VALUES (2, 2, 93);
INSERT INTO `userchoose` VALUES (2, 3, 65);
INSERT INTO `userchoose` VALUES (2, 4, 90);
INSERT INTO `userchoose` VALUES (2, 5, 0);
INSERT INTO `userchoose` VALUES (3, 1, 89);
INSERT INTO `userchoose` VALUES (3, 2, 23);
INSERT INTO `userchoose` VALUES (3, 3, 57);
INSERT INTO `userchoose` VALUES (3, 4, 65);
INSERT INTO `userchoose` VALUES (3, 5, 57);
INSERT INTO `userchoose` VALUES (52, 1, 54);
INSERT INTO `userchoose` VALUES (52, 2, 62);
INSERT INTO `userchoose` VALUES (52, 3, 88);
INSERT INTO `userchoose` VALUES (52, 4, 86);
INSERT INTO `userchoose` VALUES (52, 5, 5);
INSERT INTO `userchoose` VALUES (58, 1, 17);
INSERT INTO `userchoose` VALUES (58, 2, 74);
INSERT INTO `userchoose` VALUES (58, 3, 68);
INSERT INTO `userchoose` VALUES (58, 4, 64);
INSERT INTO `userchoose` VALUES (58, 5, 45);
INSERT INTO `userchoose` VALUES (81, 1, 11);
INSERT INTO `userchoose` VALUES (81, 2, 7);
INSERT INTO `userchoose` VALUES (81, 3, 47);
INSERT INTO `userchoose` VALUES (81, 4, 56);
INSERT INTO `userchoose` VALUES (81, 5, 46);
INSERT INTO `userchoose` VALUES (159, 1, 94);
INSERT INTO `userchoose` VALUES (159, 2, 31);
INSERT INTO `userchoose` VALUES (159, 3, 9);
INSERT INTO `userchoose` VALUES (159, 4, 93);
INSERT INTO `userchoose` VALUES (159, 5, 11);
INSERT INTO `userchoose` VALUES (189, 1, 84);
INSERT INTO `userchoose` VALUES (189, 2, 22);
INSERT INTO `userchoose` VALUES (189, 3, 18);
INSERT INTO `userchoose` VALUES (189, 4, 78);
INSERT INTO `userchoose` VALUES (189, 5, 94);
INSERT INTO `userchoose` VALUES (197, 1, 40);
INSERT INTO `userchoose` VALUES (197, 2, 61);
INSERT INTO `userchoose` VALUES (197, 3, 64);
INSERT INTO `userchoose` VALUES (197, 4, 22);
INSERT INTO `userchoose` VALUES (197, 5, 5);
INSERT INTO `userchoose` VALUES (262, 1, 86);
INSERT INTO `userchoose` VALUES (262, 2, 79);
INSERT INTO `userchoose` VALUES (262, 3, 19);
INSERT INTO `userchoose` VALUES (262, 4, 48);
INSERT INTO `userchoose` VALUES (262, 5, 19);
INSERT INTO `userchoose` VALUES (317, 1, 71);
INSERT INTO `userchoose` VALUES (317, 2, 86);
INSERT INTO `userchoose` VALUES (317, 3, 22);
INSERT INTO `userchoose` VALUES (317, 4, 3);
INSERT INTO `userchoose` VALUES (317, 5, 85);
INSERT INTO `userchoose` VALUES (354, 1, 11);
INSERT INTO `userchoose` VALUES (354, 2, 87);
INSERT INTO `userchoose` VALUES (354, 3, 70);
INSERT INTO `userchoose` VALUES (354, 4, 54);
INSERT INTO `userchoose` VALUES (354, 5, 86);
INSERT INTO `userchoose` VALUES (384, 1, 47);
INSERT INTO `userchoose` VALUES (384, 2, 92);
INSERT INTO `userchoose` VALUES (384, 3, 53);
INSERT INTO `userchoose` VALUES (384, 4, 34);
INSERT INTO `userchoose` VALUES (384, 5, 30);
INSERT INTO `userchoose` VALUES (401, 1, 43);
INSERT INTO `userchoose` VALUES (401, 2, 72);
INSERT INTO `userchoose` VALUES (401, 3, 47);
INSERT INTO `userchoose` VALUES (401, 4, 48);
INSERT INTO `userchoose` VALUES (401, 5, 29);
INSERT INTO `userchoose` VALUES (424, 1, 69);
INSERT INTO `userchoose` VALUES (424, 2, 15);
INSERT INTO `userchoose` VALUES (424, 3, 43);
INSERT INTO `userchoose` VALUES (424, 4, 56);
INSERT INTO `userchoose` VALUES (424, 5, 3);
INSERT INTO `userchoose` VALUES (495, 1, 74);
INSERT INTO `userchoose` VALUES (495, 2, 44);
INSERT INTO `userchoose` VALUES (495, 3, 31);
INSERT INTO `userchoose` VALUES (495, 4, 96);
INSERT INTO `userchoose` VALUES (495, 5, 57);
INSERT INTO `userchoose` VALUES (529, 1, 55);
INSERT INTO `userchoose` VALUES (529, 2, 75);
INSERT INTO `userchoose` VALUES (529, 3, 49);
INSERT INTO `userchoose` VALUES (529, 4, 70);
INSERT INTO `userchoose` VALUES (529, 5, 68);
INSERT INTO `userchoose` VALUES (610, 1, 17);
INSERT INTO `userchoose` VALUES (610, 2, 42);
INSERT INTO `userchoose` VALUES (610, 3, 63);
INSERT INTO `userchoose` VALUES (610, 4, 39);
INSERT INTO `userchoose` VALUES (610, 5, 51);
INSERT INTO `userchoose` VALUES (676, 1, 61);
INSERT INTO `userchoose` VALUES (676, 2, 15);
INSERT INTO `userchoose` VALUES (676, 3, 65);
INSERT INTO `userchoose` VALUES (676, 4, 82);
INSERT INTO `userchoose` VALUES (676, 5, 15);
INSERT INTO `userchoose` VALUES (810, 1, 61);
INSERT INTO `userchoose` VALUES (810, 2, 36);
INSERT INTO `userchoose` VALUES (810, 3, 83);
INSERT INTO `userchoose` VALUES (810, 4, 14);
INSERT INTO `userchoose` VALUES (810, 5, 83);
INSERT INTO `userchoose` VALUES (813, 1, 94);
INSERT INTO `userchoose` VALUES (813, 2, 66);
INSERT INTO `userchoose` VALUES (813, 3, 89);
INSERT INTO `userchoose` VALUES (813, 4, 65);
INSERT INTO `userchoose` VALUES (813, 5, 32);
INSERT INTO `userchoose` VALUES (904, 1, 62);
INSERT INTO `userchoose` VALUES (904, 2, 86);
INSERT INTO `userchoose` VALUES (904, 3, 82);
INSERT INTO `userchoose` VALUES (904, 4, 87);
INSERT INTO `userchoose` VALUES (904, 5, 62);
INSERT INTO `userchoose` VALUES (979, 1, 2);
INSERT INTO `userchoose` VALUES (979, 2, 11);
INSERT INTO `userchoose` VALUES (979, 3, 80);
INSERT INTO `userchoose` VALUES (979, 4, 6);
INSERT INTO `userchoose` VALUES (979, 5, 58);

SET FOREIGN_KEY_CHECKS = 1;
