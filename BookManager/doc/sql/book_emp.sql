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

/*Table structure for table `relation_book_emp` */

DROP TABLE IF EXISTS `relation_book_emp`;

CREATE TABLE `relation_book_emp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_id` bigint(10) NOT NULL,
  `book_id` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_id` (`emp_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `relation_book_emp_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `relation_book_emp_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `relation_book_emp` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
