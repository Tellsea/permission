/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : permission

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 26/12/2019 10:49:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录设备',
  `code` int(11) NULL DEFAULT NULL COMMENT '状态码',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 98 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (4, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-04 16:13:30', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (23, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-10 12:43:52', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (24, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-10 12:43:52', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (25, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:54:47', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (26, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:55:12', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (27, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:59:36', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (28, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 20:03:50', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (29, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 20:04:30', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (30, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 21:59:32', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (31, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:01:03', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (32, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:01:13', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (33, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:07:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (34, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:10:16', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (35, 1, '192.168.1.105', '0|0|0|内网IP|内网IP', '2019-08-11 22:23:49', 'Chrome -- Windows 10Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (36, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:52:21', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (37, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:54:29', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (38, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:56:46', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (39, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:03:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (40, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:04:17', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (41, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:06:14', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (42, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:07:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (43, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:09:27', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (44, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:09:36', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (45, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:52:16', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (46, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:52:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (47, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 09:15:00', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (48, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 10:15:50', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (49, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 11:41:18', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (50, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 11:46:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (51, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 14:57:38', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (52, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:20:53', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (53, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:24:36', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (54, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:28:56', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (55, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:32:25', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (56, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:34:15', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (57, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:42:22', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (58, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:43:47', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (59, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:46:35', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (60, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:46:55', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (61, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:50:51', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (62, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:41:23', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (63, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:43:21', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (64, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:48:21', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (65, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:50:57', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (66, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:59:09', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (67, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:01:05', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (68, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:04:37', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (69, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:07:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (70, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 22:16:33', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (71, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-07 12:14:49', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (72, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-09 15:02:57', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (73, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-09 15:05:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (74, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 15:38:54', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (75, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:04:35', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (76, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:05:29', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (77, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:21:48', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (78, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:23:53', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (79, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:39:37', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (80, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:41:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (81, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:50:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (82, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-17 21:25:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (83, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-20 20:52:51', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (84, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-23 09:35:50', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (85, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-25 09:33:43', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (86, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-25 09:58:33', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (87, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-25 10:42:36', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (88, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:16:36', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (89, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:25:49', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (90, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:29:39', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (91, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:33:57', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (92, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:40:00', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (93, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:42:57', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (94, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:45:15', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (95, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:47:40', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (96, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:56:43', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (97, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-26 09:58:47', 'Chrome -- Windows 10', 200, '登录成功');

-- ----------------------------
-- Table structure for map_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `map_role_resource`;
CREATE TABLE `map_role_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '菜单/按钮ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色资源关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of map_role_resource
-- ----------------------------
INSERT INTO `map_role_resource` VALUES (77, 1, 1);
INSERT INTO `map_role_resource` VALUES (78, 1, 4);
INSERT INTO `map_role_resource` VALUES (79, 1, 12);
INSERT INTO `map_role_resource` VALUES (80, 1, 13);
INSERT INTO `map_role_resource` VALUES (81, 1, 14);
INSERT INTO `map_role_resource` VALUES (82, 1, 15);
INSERT INTO `map_role_resource` VALUES (83, 1, 16);
INSERT INTO `map_role_resource` VALUES (84, 1, 5);
INSERT INTO `map_role_resource` VALUES (85, 1, 17);
INSERT INTO `map_role_resource` VALUES (86, 1, 18);
INSERT INTO `map_role_resource` VALUES (87, 1, 19);
INSERT INTO `map_role_resource` VALUES (88, 1, 20);
INSERT INTO `map_role_resource` VALUES (89, 1, 6);
INSERT INTO `map_role_resource` VALUES (90, 1, 21);
INSERT INTO `map_role_resource` VALUES (91, 1, 22);
INSERT INTO `map_role_resource` VALUES (92, 1, 23);
INSERT INTO `map_role_resource` VALUES (93, 1, 24);
INSERT INTO `map_role_resource` VALUES (94, 1, 2);
INSERT INTO `map_role_resource` VALUES (95, 1, 7);
INSERT INTO `map_role_resource` VALUES (96, 1, 25);
INSERT INTO `map_role_resource` VALUES (97, 1, 26);
INSERT INTO `map_role_resource` VALUES (98, 1, 8);
INSERT INTO `map_role_resource` VALUES (99, 1, 27);
INSERT INTO `map_role_resource` VALUES (100, 1, 28);
INSERT INTO `map_role_resource` VALUES (101, 1, 9);
INSERT INTO `map_role_resource` VALUES (102, 1, 3);
INSERT INTO `map_role_resource` VALUES (103, 1, 10);
INSERT INTO `map_role_resource` VALUES (104, 1, 11);
INSERT INTO `map_role_resource` VALUES (105, 2, 1);
INSERT INTO `map_role_resource` VALUES (106, 2, 4);
INSERT INTO `map_role_resource` VALUES (107, 2, 12);
INSERT INTO `map_role_resource` VALUES (108, 2, 13);
INSERT INTO `map_role_resource` VALUES (109, 2, 14);
INSERT INTO `map_role_resource` VALUES (110, 2, 15);
INSERT INTO `map_role_resource` VALUES (111, 2, 16);
INSERT INTO `map_role_resource` VALUES (112, 2, 3);
INSERT INTO `map_role_resource` VALUES (113, 2, 11);
INSERT INTO `map_role_resource` VALUES (114, 3, 2);
INSERT INTO `map_role_resource` VALUES (115, 3, 7);
INSERT INTO `map_role_resource` VALUES (116, 3, 25);
INSERT INTO `map_role_resource` VALUES (117, 3, 26);
INSERT INTO `map_role_resource` VALUES (118, 3, 8);
INSERT INTO `map_role_resource` VALUES (119, 3, 27);
INSERT INTO `map_role_resource` VALUES (120, 3, 28);
INSERT INTO `map_role_resource` VALUES (121, 3, 9);
INSERT INTO `map_role_resource` VALUES (122, 3, 3);
INSERT INTO `map_role_resource` VALUES (123, 3, 11);

-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of map_user_role
-- ----------------------------
INSERT INTO `map_user_role` VALUES (1, 1, 1);
INSERT INTO `map_user_role` VALUES (2, 2, 2);
INSERT INTO `map_user_role` VALUES (3, 3, 3);

-- ----------------------------
-- Table structure for resource_info
-- ----------------------------
DROP TABLE IF EXISTS `resource_info`;
CREATE TABLE `resource_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `pid` int(11) NULL DEFAULT 0 COMMENT '父级ID',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `perms` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '0 未使用 1 菜单 2 按钮 3 链接',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `is_leaf` tinyint(1) NULL DEFAULT 0 COMMENT '是否叶子节点，0 否，1 是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of resource_info
-- ----------------------------
INSERT INTO `resource_info` VALUES (1, '系统管理', 0, '/system', 'system', 1, 'el-icon-setting', 0, 0);
INSERT INTO `resource_info` VALUES (2, '系统监控', 0, '/log', 'log', 1, 'el-icon-odometer', 0, 0);
INSERT INTO `resource_info` VALUES (3, '项目文档', 0, '/document', 'document', 1, 'el-icon-document', 0, 0);
INSERT INTO `resource_info` VALUES (4, '用户列表', 1, '/userInfo/userInfoList', 'userInfo:list', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (5, '角色列表', 1, '/roleInfo/roleInfoList', 'roleInfo:list', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (6, '权限列表', 1, '/resourceInfo/resourceInfoList', 'resourceInfo:list', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (7, '系统日志', 2, '/systemLog/systemLogList', 'systemLog:list', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (8, '登录日志', 2, '/loginLog/loginLogList', 'loginLog:list', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (9, '数据监控', 2, '/druid', 'druid', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (10, 'Swagger API', 3, '/document/swagger', 'swagger', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (11, 'GitHub 源码', 3, '/document/github', 'github', 1, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (12, '新增用户', 4, NULL, 'userInfo:add', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (13, '更新用户', 4, NULL, 'userInfo:update', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (14, '删除用户', 4, NULL, 'userInfo:delete', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (15, '查询用户', 4, NULL, 'userInfo:select', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (16, '查看用户', 4, NULL, 'userInfo:detail', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (17, '新增角色', 5, NULL, 'roleInfo:add', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (18, '更新角色', 5, NULL, 'roleInfo:update', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (19, '删除角色', 5, NULL, 'roleInfo:delete', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (20, '查询角色', 5, NULL, 'roleInfo:select', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (21, '新增权限', 6, NULL, 'resourceInfo:add', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (22, '更新权限', 6, NULL, 'resourceInfo:update', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (23, '删除权限', 6, NULL, 'resourceInfo:delete', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (24, '查询权限', 6, NULL, 'resourceInfo:select', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (25, '删除日志', 7, NULL, 'systemLog:delete', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (26, '查询日志', 7, NULL, 'systemLog:select', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (27, '删除日志', 8, NULL, 'loginLog:delete', 2, NULL, 0, 0);
INSERT INTO `resource_info` VALUES (28, '查询日志', 8, NULL, 'loginLog:select', 2, NULL, 0, 0);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'admin', '超级管理员');
INSERT INTO `role_info` VALUES (2, 'system', '系统管理员');
INSERT INTO `role_info` VALUES (3, 'monitor', '系统监控员');

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NULL DEFAULT 0 COMMENT '操作用户id',
  `operation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `time` int(11) NULL DEFAULT 0 COMMENT '耗时(毫秒)',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES (1, 1, '新增用户', 3, 'saveUserInfo', 'UserInfo[\"userName\": \"tellsea\",\"password\":\"123456\"]', '127.0.0.1', '2019-12-21 22:25:57', '操作地点');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户，登录名，不可更改',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` int(1) NULL DEFAULT 0 COMMENT '性别 1男 2女',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_times` int(11) NULL DEFAULT 0 COMMENT '登录次数',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 正常2 锁定 3 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '超级管理员', 'a994fef0ddad5f9eed20804e7b18f559', 'VKqvum8YW0xNaTDFbrcijhTG6wUP5xAZ', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2562372298,495845374&fm=26&gp=0.jpg', '18386474459', 0, 'I am Iron Man', 1, '2019-06-21 16:16:30', 12, '2019-12-20 10:15:58', 1);
INSERT INTO `user_info` VALUES (2, 'tellsea', '系统管理员', '44eb196feb810ee770047cc34da66133', 'V1D9h266hLYqYfF5DnZCjlJKyG3Gx36c', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3041599764,2432042915&fm=26&gp=0.jpg', '15836541252', 1, '我不想打字', 1, '2019-12-24 17:07:19', 0, NULL, 1);
INSERT INTO `user_info` VALUES (3, 'monitor', '系统监控员', '221605ef8256bb0cfbbfa5fb7688eaf1', '2HI9EdHJjSYsfyqSdbWlXZRxJNXvFnrE', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=584948523,1006436504&fm=26&gp=0.jpg', '15356521441', 2, '中二病晚期', 1, '2019-12-24 17:17:17', 0, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
