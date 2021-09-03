/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : desensitization

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2020-09-02 09:43:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `plate_num` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `id_card` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1298896655281913857', 'admin', '川A12345', '15145679876', '510623199765872345', '2020-08-27 16:14:30');
INSERT INTO `t_user` VALUES ('1298897382565847041', 'spring', '川A34567', '15145675206', '510623199607112345', '2020-08-27 17:26:45');
