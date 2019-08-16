/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 5.6.43 : Database - xmmdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xmmdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

/*Table structure for table `admin_catalog` */

DROP TABLE IF EXISTS `admin_catalog`;

CREATE TABLE `admin_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalogName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '目录名',
  `sort` tinyint(5) DEFAULT NULL COMMENT '排序',
  `icon` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标编码',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态,1-正常,2-禁用',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台目录表';

/*Data for the table `admin_catalog` */

insert  into `admin_catalog`(`id`,`catalogName`,`sort`,`icon`,`state`,`createTime`,`updateTime`,`updator`) values (1,'系统管理',2,'fa-desktop',1,'2019-08-05 16:31:08','2019-08-06 11:35:45',NULL);
insert  into `admin_catalog`(`id`,`catalogName`,`sort`,`icon`,`state`,`createTime`,`updateTime`,`updator`) values (2,'人员管理',1,'fa-users',1,'2019-08-06 11:02:14','2019-08-06 11:36:07',NULL);

/*Table structure for table `admin_group` */

DROP TABLE IF EXISTS `admin_group`;

CREATE TABLE `admin_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组织名',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父级组织ID',
  `sort` tinyint(5) DEFAULT '1' COMMENT '排序',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态,1-正常,2-禁用',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台组织表';

/*Data for the table `admin_group` */

insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (1,'后台管理员组',0,1,1,'2019-08-05 15:40:20','2019-08-09 10:15:59',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (2,'平台管理组',1,1,1,'2019-08-09 10:15:41','2019-08-09 10:16:12',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (3,'平台客服组',1,3,1,'2019-08-09 10:16:44','2019-08-15 16:39:31',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (4,'平台维护组',1,2,1,'2019-08-09 10:17:38','2019-08-09 10:24:42',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (5,'商家管理组',2,1,1,'2019-08-09 10:17:50','2019-08-09 10:19:08',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (6,'用户管理组',2,2,1,'2019-08-09 10:19:34','2019-08-09 10:24:49',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (7,'平台自营商家',5,1,1,'2019-08-09 10:20:55','2019-08-09 10:20:55',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (8,'XX商家',5,2,1,'2019-08-09 10:22:33','2019-08-09 10:24:49',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (9,'AA商家',5,3,1,'2019-08-09 10:22:56','2019-08-09 10:24:51',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (10,'平台测试组',1,1,1,'2019-08-14 16:06:55','2019-08-14 16:06:55',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (14,'开发组',1,5,1,'2019-08-14 16:29:32','2019-08-15 16:39:31',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (15,'后台开发组',14,2,1,'2019-08-14 16:50:07','2019-08-15 15:30:57',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (17,'前端开发组',14,3,1,'2019-08-14 17:30:22','2019-08-15 15:30:55',NULL);
insert  into `admin_group`(`id`,`groupName`,`parentId`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (18,'API开发组',14,1,1,'2019-08-14 17:30:56','2019-08-15 15:30:57',NULL);

/*Table structure for table `admin_menu` */

DROP TABLE IF EXISTS `admin_menu`;

CREATE TABLE `admin_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalogId` bigint(20) DEFAULT NULL COMMENT '目录ID',
  `menuName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单名',
  `url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `sort` tinyint(5) DEFAULT '1' COMMENT '排序',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态,1-正常,2-禁用',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台菜单表';

/*Data for the table `admin_menu` */

insert  into `admin_menu`(`id`,`catalogId`,`menuName`,`url`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (1,2,'组织管理','group',1,1,'2019-08-05 16:32:19','2019-08-06 11:03:12',NULL);
insert  into `admin_menu`(`id`,`catalogId`,`menuName`,`url`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (2,2,'用户管理','user',3,1,'2019-08-05 16:32:43','2019-08-06 11:03:37',NULL);
insert  into `admin_menu`(`id`,`catalogId`,`menuName`,`url`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (3,1,'目录管理','catalog',1,1,'2019-08-05 16:32:56','2019-08-06 11:03:27',NULL);
insert  into `admin_menu`(`id`,`catalogId`,`menuName`,`url`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (4,1,'菜单管理','menu',2,1,'2019-08-05 16:33:36','2019-08-06 11:03:33',NULL);
insert  into `admin_menu`(`id`,`catalogId`,`menuName`,`url`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (5,2,'角色管理','role',2,1,'2019-08-05 16:38:41','2019-08-06 11:03:34',NULL);

/*Table structure for table `admin_power` */

DROP TABLE IF EXISTS `admin_power`;

CREATE TABLE `admin_power` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menuId` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `powerName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限名',
  `powerEnum` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限枚举',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态,1-正常,2-禁用',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台权限表';

/*Data for the table `admin_power` */

insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (1,1,'新增','group_add',1,'2019-08-05 16:40:36','2019-08-05 16:42:53',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (2,1,'删除','group_del',1,'2019-08-05 16:42:56','2019-08-05 16:43:41',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (3,1,'更新','group_up',1,'2019-08-05 16:42:57','2019-08-05 16:43:47',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (4,1,'查询','group_sel',1,'2019-08-05 16:42:58','2019-08-05 16:43:56',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (5,2,'新增','user_add',1,'2019-08-05 16:44:10','2019-08-05 16:44:53',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (6,2,'删除','user_del',1,'2019-08-05 16:44:11','2019-08-05 16:44:55',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (7,2,'更新','user_up',1,'2019-08-05 16:44:12','2019-08-05 16:44:57',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (8,2,'查询','user_sel',1,'2019-08-05 16:44:13','2019-08-05 16:45:03',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (9,3,'新增','catalog_add',1,'2019-08-05 16:45:07','2019-08-05 16:45:37',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (10,3,'删除','catalog_del',1,'2019-08-05 16:45:08','2019-08-05 16:45:45',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (11,3,'更新','catalog_up',1,'2019-08-05 16:45:09','2019-08-05 16:45:56',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (12,3,'查询','catalog_sel',1,'2019-08-05 16:45:12','2019-08-05 16:46:01',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (13,4,'新增','menu_add',1,'2019-08-05 16:53:52','2019-08-05 16:55:05',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (14,4,'删除','menu_del',1,'2019-08-05 16:53:55','2019-08-05 16:55:27',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (15,4,'更新','menu_up',1,'2019-08-05 16:53:57','2019-08-05 16:55:31',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (16,4,'查询','menu_sel',1,'2019-08-05 16:54:04','2019-08-05 16:55:35',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (17,5,'新增','role_add',1,'2019-08-05 16:54:06','2019-08-05 16:55:16',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (18,5,'删除','role_del',1,'2019-08-05 16:54:07','2019-08-05 16:55:39',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (19,5,'更新','role_up',1,'2019-08-05 16:54:08','2019-08-05 16:55:43',NULL);
insert  into `admin_power`(`id`,`menuId`,`powerName`,`powerEnum`,`state`,`createTime`,`updateTime`,`updator`) values (20,5,'查询','role_sel',1,'2019-08-05 16:54:15','2019-08-05 16:55:47',NULL);

/*Table structure for table `admin_role` */

DROP TABLE IF EXISTS `admin_role`;

CREATE TABLE `admin_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupId` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `roleName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名',
  `sort` tinyint(5) DEFAULT '1' COMMENT '排序',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态,1-正常,2-禁用',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台角色表';

/*Data for the table `admin_role` */

insert  into `admin_role`(`id`,`groupId`,`roleName`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (1,1,'系统管理员',1,1,'2019-08-05 16:56:59','2019-08-05 16:57:15',NULL);
insert  into `admin_role`(`id`,`groupId`,`roleName`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (2,1,'管理员',2,1,'2019-08-06 11:06:29','2019-08-06 11:06:29',NULL);
insert  into `admin_role`(`id`,`groupId`,`roleName`,`sort`,`state`,`createTime`,`updateTime`,`updator`) values (3,2,'平台管理员',1,1,'2019-08-15 11:21:42','2019-08-15 11:22:08',NULL);

/*Table structure for table `admin_role_power` */

DROP TABLE IF EXISTS `admin_role_power`;

CREATE TABLE `admin_role_power` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL COMMENT '角色ID',
  `powerId` bigint(20) NOT NULL COMMENT '权限ID',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台角色-权限中间表';

/*Data for the table `admin_role_power` */

insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (1,1,1,'2019-08-05 16:58:53','2019-08-15 14:50:21',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (2,1,2,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (3,1,3,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (4,1,4,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (5,1,5,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (6,1,6,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (7,1,7,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (8,1,8,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (9,1,9,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (10,1,10,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (11,1,11,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (12,1,12,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (13,1,13,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (14,1,14,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (15,1,15,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (16,1,16,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (17,1,17,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (18,1,18,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (19,1,19,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (20,1,20,'2019-08-05 16:58:53','2019-08-05 16:59:40',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (21,2,4,'2019-08-14 14:01:15','2019-08-14 14:10:21',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (22,2,1,'2019-08-14 14:18:26','2019-08-14 14:18:45',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (23,2,3,'2019-08-14 14:18:29','2019-08-14 14:18:47',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (24,3,1,'2019-08-15 11:22:27','2019-08-15 11:22:38',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (25,3,2,'2019-08-15 11:22:28','2019-08-15 11:22:39',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (26,3,3,'2019-08-15 11:22:30','2019-08-15 11:22:43',NULL);
insert  into `admin_role_power`(`id`,`roleId`,`powerId`,`createTime`,`updateTime`,`updator`) values (27,3,4,'2019-08-15 11:22:32','2019-08-15 11:22:45',NULL);

/*Table structure for table `admin_user` */

DROP TABLE IF EXISTS `admin_user`;

CREATE TABLE `admin_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupId` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `username` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `realName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态,1-正常,2-禁用',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台用户表';

/*Data for the table `admin_user` */

insert  into `admin_user`(`id`,`groupId`,`username`,`pwd`,`realName`,`state`,`createTime`,`updateTime`,`updator`) values (1,1,'liqinhao','liqinhao@1995','bake',1,'2019-07-18 14:53:51','2019-08-16 11:37:36',NULL);
insert  into `admin_user`(`id`,`groupId`,`username`,`pwd`,`realName`,`state`,`createTime`,`updateTime`,`updator`) values (2,2,'bake','123456',NULL,1,'2019-08-15 11:18:12','2019-08-15 11:18:12',NULL);

/*Table structure for table `admin_user_role` */

DROP TABLE IF EXISTS `admin_user_role`;

CREATE TABLE `admin_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `roleId` bigint(20) NOT NULL COMMENT '角色ID',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updator` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台用户-角色中间表';

/*Data for the table `admin_user_role` */

insert  into `admin_user_role`(`id`,`userId`,`roleId`,`createTime`,`updateTime`,`updator`) values (1,1,1,'2019-08-05 16:56:38','2019-08-16 10:11:23',NULL);
insert  into `admin_user_role`(`id`,`userId`,`roleId`,`createTime`,`updateTime`,`updator`) values (2,2,3,'2019-08-15 11:19:39','2019-08-15 11:21:32',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
