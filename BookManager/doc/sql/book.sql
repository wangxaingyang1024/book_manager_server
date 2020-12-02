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

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(25) NOT NULL AUTO_INCREMENT,
  `isbn` bigint(20) NOT NULL COMMENT '“国际标准书号”',
  `name` varchar(30) NOT NULL COMMENT '“图书名称”',
  `author` varchar(12) NOT NULL COMMENT '“作者”',
  `type` varchar(30) NOT NULL COMMENT '“类型“',
  `emp_number` bigint(20) DEFAULT NULL COMMENT '外键，employee的  工号',
  `status` tinyint(1) NOT NULL COMMENT '当前书的状态  ‘0’借出，‘1’归还',
  `synopsis` text COMMENT '“图书的简介”',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `book` */

insert  into `book`(`id`,`isbn`,`name`,`author`,`type`,`emp_number`,`status`,`synopsis`) values (1,987654321,'围棋决战','聂卫平','策略',NULL,1,'讲述了聂卫平一生传奇的精彩围棋对决。');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
