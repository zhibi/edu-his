/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : his

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-05-30 13:59:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `addtime` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '测试发布', '萨达萨达所吃着吃着<img src=\"/IMG/2018-05-17/fb9e45be-f02f-46ff-bd33-42cde31239df.jpg\" alt=\"\" />', '2018-05-17 17:43:29', 'notice');
INSERT INTO `article` VALUES ('2', 'sdasasas', 'dasdasdasdasda', '2018-05-18 09:55:28', 'type');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dep` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `w1` varchar(255) DEFAULT NULL,
  `w2` varchar(255) DEFAULT NULL,
  `w3` varchar(255) DEFAULT NULL,
  `w4` varchar(255) DEFAULT NULL,
  `w5` varchar(255) DEFAULT NULL,
  `w6` varchar(255) DEFAULT NULL,
  `w7` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('3', '1', '1', '1', '女', '1', '1', '1', '1', '1', '12333', '33333', '333333333', '3333333333', '3333333333333', '333333333333333', '333333333333333333');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `pulse` int(255) DEFAULT NULL,
  `blood1` int(255) DEFAULT NULL,
  `blood2` int(255) DEFAULT NULL,
  `heart` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', '2', '2018-05-18 11:19:33', '1', '1', '1', '1');
INSERT INTO `info` VALUES ('2', '2', '2018-05-18 11:19:47', '2', '2', '2', '2');
INSERT INTO `info` VALUES ('3', '2', '2018-05-18 11:19:58', '3', '3', '3', '3');
INSERT INTO `info` VALUES ('4', '2', '2018-05-18 15:02:47', '25', '56', '89', '123');
INSERT INTO `info` VALUES ('5', '2', '2018-05-18 15:14:12', '34', '58', '93', '412');
INSERT INTO `info` VALUES ('6', '2', '2018-05-18 15:24:00', '999', '999', '999', '999');
INSERT INTO `info` VALUES ('7', '2', '2018-05-18 15:26:02', '888', '888', '888', '888');
INSERT INTO `info` VALUES ('8', '2', '2018-05-18 15:27:45', '11', '11', '11', '1111');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `sendid` int(11) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `send` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('5', '蹇冪巼澶珮鎶ヨ', '2', '1', '2018-05-18 15:27:45', '1', null);
INSERT INTO `message` VALUES ('6', '浣庤鍘嬪お浣庢姤璀�', '2', '1', '2018-05-18 15:27:45', '1', null);
INSERT INTO `message` VALUES ('7', '楂樿鍘嬪お浣庢姤璀�', '2', '1', '2018-05-18 15:27:45', '1', null);
INSERT INTO `message` VALUES ('8', '鑴夋悘澶綆鎶ヨ', '2', '1', '2018-05-18 15:27:45', '1', null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctorid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `startdate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `enddate` varchar(50) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '3', '2', '2018-05-10', 'dasdasasd', '2018-05-18 14:45:46', '2018-05-18 16:13:58', '好了');

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `id` int(11) NOT NULL,
  `mask` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `btype` varchar(255) DEFAULT NULL,
  `history` varchar(255) DEFAULT NULL,
  `heighr` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `d` varchar(255) DEFAULT NULL,
  `act` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL,
  `pf` varchar(255) DEFAULT NULL,
  `xf` varchar(255) DEFAULT NULL,
  `gp` varchar(255) DEFAULT NULL,
  `fb` varchar(255) DEFAULT NULL,
  `lbj` varchar(255) DEFAULT NULL,
  `g` varchar(255) DEFAULT NULL,
  `jzx` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('2', '6', '6', '6', '6', '6', '6', '66', '6', '6', '6', '6', '6', '6', '3', '3', '3', '3', '3', '3', '3', '3');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `docid` int(11) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `data` int(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '2', '3', '2018-05-15 13:03:39', 'czxczxcz', '15', '测试1');
INSERT INTO `record` VALUES ('2', '2', '3', '2018-05-30 13:04:33', 'fff', '30', '测试1');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `sebao` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `zhiye` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `dep` varchar(255) DEFAULT NULL,
  `docid` int(11) DEFAULT NULL,
  `docname` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `cardtype` varchar(255) DEFAULT NULL,
  `no` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('1', '111', '55551', '21', '31', '男', '55551', '41', '复诊', '眼科', '3', '1', '22222221', '2018-05-23 16:33:16', '护照', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `guarder` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1234', '超级管理员', '00', '1', 'admin', null, null);
INSERT INTO `user` VALUES ('2', 'test', '1234', '测试1', 'ssssss1', '1', 'user', null, null);
INSERT INTO `user` VALUES ('3', 'ys', '1234', '医生', 'f', '1', 'doctor', null, null);
