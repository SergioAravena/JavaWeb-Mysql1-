/*
SQLyog - Free MySQL GUI v5.11
Host - 5.5.13 : Database - bd
*********************************************************************
Server version : 5.5.13
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `bd`;

USE `bd`;

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_nombreProducto` varchar(30) DEFAULT NULL,
  `pr_marcaProducto` varchar(30) DEFAULT NULL,
  `pr_precio` int(11) DEFAULT NULL,
  `pr_comprador` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert into `producto` (`pr_id`,`pr_nombreProducto`,`pr_marcaProducto`,`pr_precio`,`pr_comprador`) values (1,'microondas','Samsung',25000,'Pablo Vargas');
insert into `producto` (`pr_id`,`pr_nombreProducto`,`pr_marcaProducto`,`pr_precio`,`pr_comprador`) values (2,'LED 42 pulg.','LG',120000,'Pablo Vargas');
insert into `producto` (`pr_id`,`pr_nombreProducto`,`pr_marcaProducto`,`pr_precio`,`pr_comprador`) values (3,'notebook','Acer',100000,'Carol Wilson');
