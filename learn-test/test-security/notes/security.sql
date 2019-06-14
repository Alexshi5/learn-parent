/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-06-14 21:16:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for childaccountinfo
-- ----------------------------
DROP TABLE IF EXISTS `childaccountinfo`;
CREATE TABLE `childaccountinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `hostid` bigint(20) DEFAULT NULL COMMENT '发布方ID',
  `hostshopid` bigint(20) DEFAULT NULL COMMENT '店铺ID-暂用发布方ID',
  `datetime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='子账号表-用于支持多店铺';

-- ----------------------------
-- Records of childaccountinfo
-- ----------------------------
INSERT INTO `childaccountinfo` VALUES ('1', '1', '92', '2019-06-14 18:57:14');
INSERT INTO `childaccountinfo` VALUES ('2', '2', '93', '2019-06-14 18:57:22');
INSERT INTO `childaccountinfo` VALUES ('3', '3', '92', '2019-06-14 18:57:32');
INSERT INTO `childaccountinfo` VALUES ('4', '3', '93', '2019-06-14 18:57:40');

-- ----------------------------
-- Table structure for hostinfo
-- ----------------------------
DROP TABLE IF EXISTS `hostinfo`;
CREATE TABLE `hostinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `loginname` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(200) DEFAULT NULL COMMENT '登录密码',
  `datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='发布方信息';

-- ----------------------------
-- Records of hostinfo
-- ----------------------------
INSERT INTO `hostinfo` VALUES ('92', 'cap001', 'cap001', '2019-06-14 18:52:38');
INSERT INTO `hostinfo` VALUES ('93', 'cap002', 'cap002', '2019-06-14 18:53:13');

-- ----------------------------
-- Table structure for menufunctionlist
-- ----------------------------
DROP TABLE IF EXISTS `menufunctionlist`;
CREATE TABLE `menufunctionlist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `menuid` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `funcno` varchar(50) DEFAULT NULL COMMENT '功能编号',
  `funcname` varchar(100) DEFAULT NULL COMMENT '功能名称',
  `funcurl` varchar(200) DEFAULT NULL COMMENT '功能url地址',
  `datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='功能菜单操作表';

-- ----------------------------
-- Records of menufunctionlist
-- ----------------------------
INSERT INTO `menufunctionlist` VALUES ('1', '3', 'F01', '账户-更新', '/api/account/update', '2019-06-14 19:06:06');
INSERT INTO `menufunctionlist` VALUES ('2', '3', 'F02', '账户-删除', '/api/account/delete', '2019-06-14 19:06:30');
INSERT INTO `menufunctionlist` VALUES ('3', '4', 'F03', '内容-更新', '/api/content/update', '2019-06-14 19:07:12');
INSERT INTO `menufunctionlist` VALUES ('4', '4', 'F04', '内容-删除', '/api/content/delete', '2019-06-14 19:07:34');

-- ----------------------------
-- Table structure for menulist
-- ----------------------------
DROP TABLE IF EXISTS `menulist`;
CREATE TABLE `menulist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `menuno` varchar(50) DEFAULT NULL COMMENT '菜单编号',
  `menutext` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `parentno` varchar(50) DEFAULT NULL COMMENT '上级编号',
  `menuurl` varchar(200) DEFAULT NULL COMMENT 'Url地址',
  `datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='功能菜单表';

-- ----------------------------
-- Records of menulist
-- ----------------------------
INSERT INTO `menulist` VALUES ('1', 'M01', '首页', '0', '/menu/index', '2019-06-14 19:01:05');
INSERT INTO `menulist` VALUES ('2', 'M02', '店铺管理', '0', '/menu/store', '2019-06-14 19:01:36');
INSERT INTO `menulist` VALUES ('3', 'M03', '账户管理', '0', '/menu/account', '2019-06-14 19:02:03');
INSERT INTO `menulist` VALUES ('4', 'M04', '内容管理', '0', '/menu/content', '2019-06-14 19:02:36');

-- ----------------------------
-- Table structure for roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `rolename` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `desp` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES ('1', '账户管理员', '用于维护账户管理功能', '2019-06-14 18:55:03');
INSERT INTO `roleinfo` VALUES ('2', '内容管理员', '用于维护内容', '2019-06-14 18:55:25');
INSERT INTO `roleinfo` VALUES ('3', '粉丝管理员', '用于维护粉丝', '2019-06-14 18:55:46');
INSERT INTO `roleinfo` VALUES ('4', '账户和内容管理员', '用于维护账户和内容', '2019-06-14 18:56:08');

-- ----------------------------
-- Table structure for rolepriinfo
-- ----------------------------
DROP TABLE IF EXISTS `rolepriinfo`;
CREATE TABLE `rolepriinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `roleid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menuid` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `funcid` bigint(20) DEFAULT NULL COMMENT '功能ID',
  `datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色-权限表';

-- ----------------------------
-- Records of rolepriinfo
-- ----------------------------
INSERT INTO `rolepriinfo` VALUES ('1', '1', '1', '0', '2019-06-14 19:20:00');
INSERT INTO `rolepriinfo` VALUES ('2', '1', '3', '1', '2019-06-14 19:20:57');
INSERT INTO `rolepriinfo` VALUES ('4', '2', '1', '0', '2019-06-14 19:22:05');
INSERT INTO `rolepriinfo` VALUES ('5', '2', '4', '3', '2019-06-14 19:22:44');

-- ----------------------------
-- Table structure for rolestore
-- ----------------------------
DROP TABLE IF EXISTS `rolestore`;
CREATE TABLE `rolestore` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `roleid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `hostshopid` bigint(20) DEFAULT NULL COMMENT '店铺ID-暂用发布方ID',
  `datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='店铺-角色表';

-- ----------------------------
-- Records of rolestore
-- ----------------------------
INSERT INTO `rolestore` VALUES ('1', '1', '92', '2019-06-14 18:58:42');
INSERT INTO `rolestore` VALUES ('2', '2', '93', '2019-06-14 18:58:53');
INSERT INTO `rolestore` VALUES ('3', '3', '92', '2019-06-14 19:44:32');
