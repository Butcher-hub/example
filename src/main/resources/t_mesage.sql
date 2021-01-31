/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 31/01/2021 19:10:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_mesage
-- ----------------------------
DROP TABLE IF EXISTS `t_mesage`;
CREATE TABLE `t_mesage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `studentID` int(11) NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `class` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  PRIMARY KEY (`id`, `class`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 187 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mesage
-- ----------------------------
INSERT INTO `t_mesage` VALUES (1, 1800500901, '贾芸婷', '2000-12-13', '18005801');
INSERT INTO `t_mesage` VALUES (2, 1800500903, '李倩如', '2000-05-22', '18005801');
INSERT INTO `t_mesage` VALUES (3, 1800500904, '刘丹丹', '1999-10-10', '18005801');
INSERT INTO `t_mesage` VALUES (4, 1800500905, '刘思彤', '2000-04-19', '18005801');
INSERT INTO `t_mesage` VALUES (5, 1800500911, '温和燕', '2000-07-02', '18005801');
INSERT INTO `t_mesage` VALUES (6, 1800500912, '袁雪霞', '1998-02-06', '18005801');
INSERT INTO `t_mesage` VALUES (7, 1800500913, '朱梅', '2001-06-22', '18005801');
INSERT INTO `t_mesage` VALUES (9, 1800500915, '陈立鹏', '2000-07-18', '18005801');
INSERT INTO `t_mesage` VALUES (10, 1800500919, '李霖', '2000-03-31', '18005801');
INSERT INTO `t_mesage` VALUES (11, 1800500920, '梁双祥', '1999-08-21', '18005801');
INSERT INTO `t_mesage` VALUES (12, 1800500922, '莫民乾', '2000-10-12', '18005801');
INSERT INTO `t_mesage` VALUES (13, 1800500923, '牛富强', '1998-09-02', '18005801');
INSERT INTO `t_mesage` VALUES (14, 1800500924, '施彦宏', '2000-01-26', '18005801');
INSERT INTO `t_mesage` VALUES (15, 1800500925, '覃寿良', '2000-04-16', '18005801');
INSERT INTO `t_mesage` VALUES (16, 1800500926, '谭熙', '2000-02-22', '18005801');
INSERT INTO `t_mesage` VALUES (17, 1800500929, '韦明钦', '1998-08-03', '18005801');
INSERT INTO `t_mesage` VALUES (18, 1800500931, '易清宇', '2000-04-13', '18005801');
INSERT INTO `t_mesage` VALUES (19, 1800500934, '邹国龙', '2000-05-22', '18005801');
INSERT INTO `t_mesage` VALUES (20, 1800501002, '车宇航', '2000-07-01', '18005801');
INSERT INTO `t_mesage` VALUES (21, 1800501003, '邓世秀', '2000-06-14', '18005801');
INSERT INTO `t_mesage` VALUES (22, 1800501007, '林秋萍', '1999-11-13', '18005801');
INSERT INTO `t_mesage` VALUES (23, 1800501012, '郑欣婷', '2000-03-20', '18005801');
INSERT INTO `t_mesage` VALUES (24, 1800501024, '苏为仪', '1999-03-27', '18005801');
INSERT INTO `t_mesage` VALUES (25, 1800501028, '王朝阳', '2000-12-10', '18005801');
INSERT INTO `t_mesage` VALUES (26, 1800501031, '吴东旭', '2000-07-31', '18005801');
INSERT INTO `t_mesage` VALUES (27, 1800501033, '郑喆', '2000-07-23', '18005801');
INSERT INTO `t_mesage` VALUES (28, 1800501101, '陈妙玲', '2001-03-24', '18005801');
INSERT INTO `t_mesage` VALUES (29, 1800501113, '邹卫敏', '1999-12-08', '18005801');
INSERT INTO `t_mesage` VALUES (30, 1800501122, '庞金源', '2000-07-25', '18005801');
INSERT INTO `t_mesage` VALUES (31, 1800501124, '沈铁鑫', '1999-01-30', '18005801');
INSERT INTO `t_mesage` VALUES (32, 1800501128, '韦金良', '1999-10-03', '18005801');
INSERT INTO `t_mesage` VALUES (33, 1800501132, '严敬鹏', '1999-10-25', '18005801');
INSERT INTO `t_mesage` VALUES (34, 1800501204, '罗春雨', '1998-03-26', '18005801');
INSERT INTO `t_mesage` VALUES (35, 1800501206, '马琳', '2000-01-27', '18005801');
INSERT INTO `t_mesage` VALUES (36, 1800501207, '马轶菲', '1999-12-19', '18005801');
INSERT INTO `t_mesage` VALUES (37, 1800500107, '李亚婷', '2021-01-22', '19005008');
INSERT INTO `t_mesage` VALUES (39, 1800500313, '吴金玲', '2021-01-23', '19005008');
INSERT INTO `t_mesage` VALUES (43, 1800501304, '李彩白', '2021-01-25', '19005008');
INSERT INTO `t_mesage` VALUES (45, 1800501815, '韦鲜莉', '2021-01-26', '19005008');
INSERT INTO `t_mesage` VALUES (47, 1800501817, '吴莉', '2021-01-27', '19005008');
INSERT INTO `t_mesage` VALUES (48, 1700501605, '黄娟', '2021-01-28', '19005008');
INSERT INTO `t_mesage` VALUES (51, 1700500801, '陈星星', '2021-01-29', '19005008');
INSERT INTO `t_mesage` VALUES (53, 1800500128, '马炳成', '2021-01-30', '19005008');
INSERT INTO `t_mesage` VALUES (54, 1700501608, '李洁诗', '2021-01-31', '19005008');
INSERT INTO `t_mesage` VALUES (56, 1700501903, '陈赞清', '2021-02-01', '19005008');
INSERT INTO `t_mesage` VALUES (61, 1861130414, '李武源', '2021-02-03', '19005008');
INSERT INTO `t_mesage` VALUES (63, 1900501506, '王杏萍', '2021-02-04', '19005008');
INSERT INTO `t_mesage` VALUES (65, 1900501602, '邓英', '2021-02-05', '19005008');
INSERT INTO `t_mesage` VALUES (66, 1900500617, '韦柳棉', '2021-02-06', '19005008');
INSERT INTO `t_mesage` VALUES (69, 1900500217, '杨炎兰', '2021-02-07', '19005008');
INSERT INTO `t_mesage` VALUES (71, 1900501107, '韦新宁', '2021-02-08', '19005008');
INSERT INTO `t_mesage` VALUES (73, 1800301306, '杨文惠', '2021-02-09', '19005008');
INSERT INTO `t_mesage` VALUES (75, 1800301307, '钟夏雨', '2021-02-10', '19005008');
INSERT INTO `t_mesage` VALUES (77, 1800301312, '邓洋敏', '2021-02-11', '19005008');
INSERT INTO `t_mesage` VALUES (79, 1800720226, ' 李文豪', '2021-02-12', '19005008');
INSERT INTO `t_mesage` VALUES (81, 1600150216, '林超', '2021-02-13', '19005008');
INSERT INTO `t_mesage` VALUES (83, 1600200303, '黄晓婷', '2021-02-14', '19005008');
INSERT INTO `t_mesage` VALUES (85, 1701420307, '龙翠园', '2021-02-15', '19005008');
INSERT INTO `t_mesage` VALUES (87, 1700710323, '蒋伟', '2021-02-16', '19005008');
INSERT INTO `t_mesage` VALUES (89, 1600710101, '程莹', '2021-02-17', '19005008');
INSERT INTO `t_mesage` VALUES (91, 1800801725, '谢曜泽', '2021-02-18', '19005008');
INSERT INTO `t_mesage` VALUES (93, 1800301314, '黄彦鑫', '2021-02-19', '19005008');
INSERT INTO `t_mesage` VALUES (95, 1600630128, '彭博宇', '2021-02-20', '19005008');
INSERT INTO `t_mesage` VALUES (97, 1800400107, '何慧琳', '2021-02-21', '19005008');
INSERT INTO `t_mesage` VALUES (99, 1800301639, '吴俊夫', '2021-02-22', '19005008');
INSERT INTO `t_mesage` VALUES (100, 1601020218, '陆宁', '2021-02-23', '19005008');
INSERT INTO `t_mesage` VALUES (102, 1601020222, '潘勇', '2021-02-24', '19005008');
INSERT INTO `t_mesage` VALUES (104, 1800610219, '谢晓冬', '2021-02-25', '19005008');
INSERT INTO `t_mesage` VALUES (107, 1601030212, '甘浚铭', '2021-02-26', '19005008');
INSERT INTO `t_mesage` VALUES (109, 1601030115, '黄钧', '2021-02-27', '19005008');
INSERT INTO `t_mesage` VALUES (111, 1601030208, '曹显庆', '2021-02-28', '19005008');
INSERT INTO `t_mesage` VALUES (113, 1601030216, '黄永毅', '2021-03-01', '19005008');
INSERT INTO `t_mesage` VALUES (115, 1800610317, '王成璐', '2021-03-02', '19005008');
INSERT INTO `t_mesage` VALUES (117, 1700201021, '卢俊宁', '2021-03-03', '19005008');
INSERT INTO `t_mesage` VALUES (119, 1700201222, '王铎鹏', '2021-03-04', '19005008');
INSERT INTO `t_mesage` VALUES (121, 1700400411, '王雅婷', '2021-03-05', '19005008');
INSERT INTO `t_mesage` VALUES (123, 1800610215, '王燕玲', '2021-03-06', '19005008');
INSERT INTO `t_mesage` VALUES (124, 1800620101, '   何新丽', '2021-03-07', '19005008');
INSERT INTO `t_mesage` VALUES (126, 1700710326, '陆游尤', '2021-03-08', '19005008');
INSERT INTO `t_mesage` VALUES (127, 1700710335, '徐毓淋', '2021-03-09', '19005008');
INSERT INTO `t_mesage` VALUES (129, 1700720116, '习美萱', '2021-03-10', '19005008');
INSERT INTO `t_mesage` VALUES (131, 1700720202, '胡艳芳', '2021-03-11', '19005008');
INSERT INTO `t_mesage` VALUES (133, 1701000801, '陈井新', '2021-03-12', '19005008');
INSERT INTO `t_mesage` VALUES (135, 1701000213, '邓世健', '2021-03-13', '19005008');
INSERT INTO `t_mesage` VALUES (137, 1701000218, '刘荣欣', '2021-03-14', '19005008');
INSERT INTO `t_mesage` VALUES (140, 1800301031, '王湖勇', '2021-03-15', '19005008');
INSERT INTO `t_mesage` VALUES (143, 1701000707, '覃琼德', '2021-03-16', '19005008');
INSERT INTO `t_mesage` VALUES (145, 1701420114, '陈春灌', '2021-03-17', '19005008');
INSERT INTO `t_mesage` VALUES (147, 1701420117, '黄超祥', '2021-03-18', '19005008');
INSERT INTO `t_mesage` VALUES (149, 1800301029, '沈逸鸿', '2021-03-19', '19005008');
INSERT INTO `t_mesage` VALUES (151, 1801420303, '邱冬梅', '2021-03-20', '19005008');
INSERT INTO `t_mesage` VALUES (153, 1700410110, '谢丹丹', '2021-03-21', '18005802');
INSERT INTO `t_mesage` VALUES (155, 1800110533, '祝海超', '2021-03-22', '18005802');
INSERT INTO `t_mesage` VALUES (157, 1700100433, '杨柱浩', '2021-03-23', '18005802');
INSERT INTO `t_mesage` VALUES (159, 1700300208, '张慧慧', '2021-03-24', '18005802');
INSERT INTO `t_mesage` VALUES (161, 1700400302, '冯静', '2021-03-25', '18005802');
INSERT INTO `t_mesage` VALUES (163, 1700110408, '郭荣文', '2021-03-26', '18005802');
INSERT INTO `t_mesage` VALUES (165, 1800101411, '黄如毅', '2021-03-27', '18005802');
INSERT INTO `t_mesage` VALUES (166, 1801510303, '黄妍雯', '2021-03-28', '18005802');
INSERT INTO `t_mesage` VALUES (168, 1800620104, '黄秋艳', '2021-03-29', '18005802');
INSERT INTO `t_mesage` VALUES (169, 1800630115, '潘丽蓉', '2021-03-30', '18005802');
INSERT INTO `t_mesage` VALUES (171, 1701000217, '梁华辉', '2021-03-31', '18005802');
INSERT INTO `t_mesage` VALUES (173, 1701000216, '李顺', '2021-04-01', '18005802');
INSERT INTO `t_mesage` VALUES (175, 1600900303, '邓燕玲', '2021-04-02', '18005802');
INSERT INTO `t_mesage` VALUES (179, 1800100226, '宋飞洋', '2021-04-03', '18005802');

SET FOREIGN_KEY_CHECKS = 1;