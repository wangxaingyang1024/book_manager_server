/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.30-log : Database - book_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book_manager`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(25) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `job_number` int(20) NOT NULL COMMENT '工号    ‘随机生成’',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `gender` int(1) NOT NULL COMMENT '男‘1’，女‘0’',
  `phone` varchar(11) NOT NULL COMMENT '联系方式',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `role` int(1) NOT NULL DEFAULT '1' COMMENT '权限 ，‘1’为普通用户，‘2’为管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `employee` */

insert  into `employee`(`id`,`job_number`,`username`,`password`,`nick_name`,`gender`,`phone`,`age`,`role`) values (1,95550001,'wxy','123456','王向阳',1,'13227730803',25,2),(2,95550002,'wqy','123','吴清源',1,'15324587985',100,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
