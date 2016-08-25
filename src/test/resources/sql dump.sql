/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.6.22-log : Database - hackathon
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hackathon` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hackathon`;

/*Table structure for table `guest_profile` */

DROP TABLE IF EXISTS `guest_profile`;

CREATE TABLE `guest_profile` (
  `guest_id` int(10) NOT NULL AUTO_INCREMENT,
  `guest_name` varchar(50) DEFAULT NULL,
  `guest_address` varchar(50) DEFAULT NULL,
  `guest_email` varchar(50) DEFAULT NULL,
  `guest_phone` varchar(50) DEFAULT NULL,
  `guest_social_interest` varchar(100) DEFAULT NULL,
  `guest_prev_stay` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`guest_id`),
  UNIQUE KEY `Unique` (`guest_email`)
) ENGINE=InnoDB AUTO_INCREMENT=60004 DEFAULT CHARSET=utf8;

/*Data for the table `guest_profile` */

insert  into `guest_profile`(`guest_id`,`guest_name`,`guest_address`,`guest_email`,`guest_phone`,`guest_social_interest`,`guest_prev_stay`) values (60001,'Athreya murthy','BTM layout','test@abc.com','99999999','Photography,Movies,Music',NULL),(60002,'sameer josi','JP nagar','sameer@test.com','123424321','Movies,Music',NULL),(60003,'Saabir','Whitefield','saabir@gmail.com','4111132','Movies,Music,Travel','');

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(30) DEFAULT NULL,
  `hotel_city` varchar(30) DEFAULT NULL,
  `hotel_country` varchar(30) DEFAULT NULL,
  `hotel_short_desc` varchar(50) DEFAULT NULL,
  `hotel_price` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotel_id`,`hotel_name`,`hotel_city`,`hotel_country`,`hotel_short_desc`,`hotel_price`) values (10001,'Z hotel','New York','USA','Z hotels, times square New york!','75'),(10002,'Fortune Times Square','New York','USA','Fortune Times Square - A luxury collection','90'),(10003,'Orange Hotels','New York','USA','Orange Hotels - A Business Hotel','80');

/*Table structure for table `hotel_service_map` */

DROP TABLE IF EXISTS `hotel_service_map`;

CREATE TABLE `hotel_service_map` (
  `hservice_id` int(5) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(5) DEFAULT NULL,
  `service_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`hservice_id`),
  KEY `fk_hotel_map_id` (`hotel_id`),
  KEY `fk_service_id` (`service_id`),
  CONSTRAINT `fk_hotel_map_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`),
  CONSTRAINT `fk_service_id` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40008 DEFAULT CHARSET=utf8;

/*Data for the table `hotel_service_map` */

insert  into `hotel_service_map`(`hservice_id`,`hotel_id`,`service_id`) values (40001,10001,30001),(40002,10001,30002),(40003,10002,30002),(40004,10002,30003),(40005,10002,30004),(40006,10003,30002),(40007,10003,30005);

/*Table structure for table `res_service_map` */

DROP TABLE IF EXISTS `res_service_map`;

CREATE TABLE `res_service_map` (
  `rservice_id` int(5) NOT NULL AUTO_INCREMENT,
  `res_id` int(5) DEFAULT NULL,
  `service_id` int(5) DEFAULT NULL,
  `service_start` varchar(20) DEFAULT NULL,
  `service_end` varchar(20) DEFAULT NULL,
  `service_cost` varchar(20) DEFAULT NULL,
  `service_required_for` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`rservice_id`),
  KEY `fk_resserv_res_id` (`res_id`),
  KEY `fk_resserv_serv_id` (`service_id`),
  CONSTRAINT `fk_resserv_res_id` FOREIGN KEY (`res_id`) REFERENCES `reservation` (`res_id`),
  CONSTRAINT `fk_resserv_serv_id` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `res_service_map` */

insert  into `res_service_map`(`rservice_id`,`res_id`,`service_id`,`service_start`,`service_end`,`service_cost`,`service_required_for`) values (1,12345,30001,'8/22/2016','8/24/2016','75','1'),(2,12345,30002,'8/22/2016','8/24/2016','50','1'),(3,16883,30001,'8/22/2016','8/24/2016','75','1'),(4,16883,30001,'8/22/2016','8/24/2016','75','1');

/*Table structure for table `reservation` */

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
  `res_id` int(5) NOT NULL AUTO_INCREMENT,
  `guest_name` varchar(20) DEFAULT NULL,
  `guest_address` varchar(40) DEFAULT NULL,
  `guest_email` varchar(30) DEFAULT NULL,
  `hotel_id` int(5) DEFAULT NULL,
  `checkin_date` varchar(35) DEFAULT NULL,
  `checkout_date` varchar(35) DEFAULT NULL,
  `total_price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  KEY `fk_hotel_id` (`hotel_id`),
  CONSTRAINT `fk_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49118 DEFAULT CHARSET=utf8;

/*Data for the table `reservation` */

insert  into `reservation`(`res_id`,`guest_name`,`guest_address`,`guest_email`,`hotel_id`,`checkin_date`,`checkout_date`,`total_price`) values (12345,'Athreya murthy','BTM layout','test@abc.com',10001,'2016-08-22 15:23:23','2016-08-22 15:23:23','100'),(16883,'Sridhar Bhat','Banshankri','bhat@acc.com',10002,'8/22/2016','8/24/2016','150'),(49117,'Sridhar Bhat','Banshankri','bhat@acc.com',10002,'8/24/2016',NULL,NULL);

/*Table structure for table `services` */

DROP TABLE IF EXISTS `services`;

CREATE TABLE `services` (
  `service_id` int(5) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(20) DEFAULT NULL,
  `service_price` varchar(20) DEFAULT NULL,
  `service_description` varchar(150) DEFAULT NULL,
  `service_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30007 DEFAULT CHARSET=utf8;

/*Data for the table `services` */

insert  into `services`(`service_id`,`service_name`,`service_price`,`service_description`,`service_type`) values (30001,'Airport Transfer','75','One way airport transfer!','Transport'),(30002,'City Tour','25','Tour the City with the best Tour guide and go places.','Travel'),(30003,'Hire a Taxi','2','Avail Taxi for your local needs! ','Transport'),(30004,'Movies','2','Watch your favorite movies.','Movies'),(30005,'Welcome Meals','10','Enjoy the delicious Meal with your partner!','Food'),(30006,'Music Festival','20','Enjoy the Music of Pentagram. ','Music');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
