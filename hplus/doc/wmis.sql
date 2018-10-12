/*
Navicat MySQL Data Transfer

Source Server         : ldh
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : wmis

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-10-12 18:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dic_name` varchar(100) DEFAULT NULL COMMENT '字典名称',
  `dic_code` varchar(255) DEFAULT NULL COMMENT '字典值',
  `dic_type` bigint(11) NOT NULL COMMENT '字典类型',
  `dic_order` int(11) DEFAULT '1' COMMENT '顺序',
  `dic_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `dic_type_outpk` (`dic_type`),
  CONSTRAINT `dic_type_outpk` FOREIGN KEY (`dic_type`) REFERENCES `dictionary_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', '目录', '1', '1', '1', '一级菜单');
INSERT INTO `dictionary` VALUES ('2', '菜单', '2', '1', '2', '二级菜单');
INSERT INTO `dictionary` VALUES ('3', '系统角色', 'sys', '2', '1', null);
INSERT INTO `dictionary` VALUES ('4', '业务角色', 'front', '2', '2', '前台角色');

-- ----------------------------
-- Table structure for dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_type`;
CREATE TABLE `dictionary_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dic_type_name` varchar(100) DEFAULT NULL COMMENT '字典类型名称',
  `dic_type_code` varchar(100) DEFAULT NULL COMMENT '字典类型编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary_type
-- ----------------------------
INSERT INTO `dictionary_type` VALUES ('1', '菜单类型', 'menuType');
INSERT INTO `dictionary_type` VALUES ('2', '角色类型', 'roleType');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(100) NOT NULL COMMENT '菜单编码',
  `menu_type` varchar(3) DEFAULT NULL COMMENT '菜单类型。1：目录，2：菜单，9：按钮',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单样式',
  `pcode` varchar(100) DEFAULT NULL COMMENT '上级菜单',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `open_type` varchar(100) DEFAULT NULL COMMENT '打开方式',
  `menu_order` int(11) DEFAULT '1' COMMENT '菜单顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', 'sys', '1', '', 'cog', '', '系统管理', '', '1');
INSERT INTO `menu` VALUES ('2', '用户管理', 'sys_user', '2', 'sys/user/list', null, 'sys', '用户管理', null, '1');
INSERT INTO `menu` VALUES ('3', '菜单管理', 'sys_menu', '2', 'sys/menu/list', '', 'sys', '菜单', '_blank', '2');
INSERT INTO `menu` VALUES ('4', '字典管理', 'dictionary', '2', 'sys/dictionary/list', '', 'sys', '字典管理', '_blank', '3');
INSERT INTO `menu` VALUES ('5', '权限管理', 'authority', '1', '', 'eye', '', '权限管理', '_blank', '2');
INSERT INTO `menu` VALUES ('6', '个人中心', 'zone', '1', '', 'user-circle', '', '个人中心', '', '3');
INSERT INTO `menu` VALUES ('7', '角色管理', 'role', '2', 'authority/role/list', '', 'authority', '角色', '', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `role_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'root', null, '超级管理员');
INSERT INTO `role` VALUES ('2', '管理员', 'manager', 'sys', '普通管理员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `mid` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '1', '2');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('4', '1', '5');
INSERT INTO `role_menu` VALUES ('5', '1', '7');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) NOT NULL COMMENT '账号',
  `pwd` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别。1：男，2：女',
  `icon` varchar(255) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`),
  KEY `user_account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ldh', '4297f44b13955235245b2497399d7a93', '李德欢', '1', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
