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

/*Table structure for table `log_book_emp` */

DROP TABLE IF EXISTS `log_book_emp`;

CREATE TABLE `log_book_emp` (
  `id` int(10) NOT NULL,
  `lend_time` datetime DEFAULT NULL COMMENT '借出时间',
  `return_time` datetime DEFAULT NULL COMMENT '归还时间',
  `book_isbn` bigint(20) NOT NULL COMMENT '“图书国际标准书号”',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `log_book_emp` */

insert  into `log_book_emp`(`id`,`lend_time`,`return_time`,`book_isbn`) values (1,'2020-11-26 10:32:12','2020-11-27 10:32:57',987654321);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
