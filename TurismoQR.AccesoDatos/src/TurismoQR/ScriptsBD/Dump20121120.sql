/*
SQLyog Ultimate v9.02 
MySQL - 5.5.27 : Database - turismoqr
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`turismoqr` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `turismoqr`;

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `idCategoria` varchar(255) NOT NULL,
  `nombreCategoria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `categoria` */

insert  into `categoria`(`idCategoria`,`nombreCategoria`) values ('1','Hotel'),('10','Universidad'),('11','Software Factory'),('12','Club'),('13','Estadio'),('2','Farmacia'),('3','Restaurant'),('4','Monumento'),('5','Plaza'),('6','Hostel'),('7','Polideportivo'),('8','Almacen'),('9','Ferreteria');

/*Table structure for table `ciclo` */

DROP TABLE IF EXISTS `ciclo`;

CREATE TABLE `ciclo` (
  `idCiclo` varchar(255) NOT NULL,
  PRIMARY KEY (`idCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ciclo` */

insert  into `ciclo`(`idCiclo`) values ('0dfd2e6b-329e-11e2-b8c7-c44619f81971'),('1'),('1ab45a04-32ac-11e2-b8c7-c44619f81971'),('2'),('32f90d4d-32aa-11e2-b8c7-c44619f81971'),('45454e3e-32b3-11e2-b8c7-c44619f81971'),('637647de-329d-11e2-b8c7-c44619f81971'),('733043d6-32ab-11e2-b8c7-c44619f81971'),('7fd9bd90-32a7-11e2-b8c7-c44619f81971'),('8cd05683-32a4-11e2-b8c7-c44619f81971'),('9e0ed290-32b5-11e2-b8c7-c44619f81971'),('a1bd1279-32b6-11e2-b8c7-c44619f81971'),('e4bc64e4-32ac-11e2-b8c7-c44619f81971');

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idCliente` varchar(255) NOT NULL,
  `cantidadDePuntosPermitidos` int(11) DEFAULT NULL,
  `ciclo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `ciclo` (`ciclo`),
  KEY `FK334B85FA7A3E6E41` (`ciclo`),
  KEY `FK334B85FA5E4C6279` (`idCliente`),
  CONSTRAINT `FK334B85FA5E4C6279` FOREIGN KEY (`idCliente`) REFERENCES `contacto` (`idContacto`),
  CONSTRAINT `FK334B85FA7A3E6E41` FOREIGN KEY (`ciclo`) REFERENCES `ciclo` (`idCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`idCliente`,`cantidadDePuntosPermitidos`,`ciclo`) values ('1',5,'2'),('a1bc0947-32b6-11e2-b8c7-c44619f81971',4,'a1bd1279-32b6-11e2-b8c7-c44619f81971');

/*Table structure for table `contacto` */

DROP TABLE IF EXISTS `contacto`;

CREATE TABLE `contacto` (
  `idContacto` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `telefonoFijo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idContacto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contacto` */

insert  into `contacto`(`idContacto`,`mail`,`celular`,`telefonoFijo`) values ('1','email@email.com','12312312','1231231'),('a1bc0947-32b6-11e2-b8c7-c44619f81971','prperez@outlook.com','0261-156529534','0261-4122956');

/*Table structure for table `contactoempresa` */

DROP TABLE IF EXISTS `contactoempresa`;

CREATE TABLE `contactoempresa` (
  `idContactoEmpresa` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idContactoEmpresa`),
  KEY `FKC6F1513A5D5940D9` (`idContactoEmpresa`),
  KEY `idEmpresa` (`empresa`),
  CONSTRAINT `idEmpresa` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`idEmpresa`),
  CONSTRAINT `FKC6F1513A5D5940D9` FOREIGN KEY (`idContactoEmpresa`) REFERENCES `contacto` (`idContacto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contactoempresa` */

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `idEmpresa` varchar(255) NOT NULL,
  `cuit` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `Rubro` varchar(255) NOT NULL,
  PRIMARY KEY (`idEmpresa`),
  UNIQUE KEY `Rubro` (`Rubro`),
  KEY `FK9F354089F5993F08` (`Rubro`),
  KEY `FK9F354089DAF185FD` (`idEmpresa`),
  CONSTRAINT `FK9F354089DAF185FD` FOREIGN KEY (`idEmpresa`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK9F354089F5993F08` FOREIGN KEY (`Rubro`) REFERENCES `rubro` (`idRubro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empresa` */

/*Table structure for table `estado` */

DROP TABLE IF EXISTS `estado`;

CREATE TABLE `estado` (
  `idEstado` varchar(255) NOT NULL,
  `nombreDeEstado` varchar(255) DEFAULT NULL,
  `fechaInicioPeriodo` datetime DEFAULT NULL,
  `fechaFinPeriodo` datetime DEFAULT NULL,
  `Ciclo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `idCiclo` (`Ciclo`),
  CONSTRAINT `idCiclo` FOREIGN KEY (`Ciclo`) REFERENCES `ciclo` (`idCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado` */

insert  into `estado`(`idEstado`,`nombreDeEstado`,`fechaInicioPeriodo`,`fechaFinPeriodo`,`Ciclo`) values ('0dfd4632-329e-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 20:08:39',NULL,'0dfd2e6b-329e-11e2-b8c7-c44619f81971'),('1','Habilitado',NULL,NULL,'1'),('1ab46b87-32ac-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 21:49:14',NULL,'1ab45a04-32ac-11e2-b8c7-c44619f81971'),('2','Habilitado',NULL,NULL,'2'),('32f9334b-32aa-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 21:35:35',NULL,'32f90d4d-32aa-11e2-b8c7-c44619f81971'),('4545cc53-32b3-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 22:40:28',NULL,'45454e3e-32b3-11e2-b8c7-c44619f81971'),('63766978-329d-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 20:03:53',NULL,'637647de-329d-11e2-b8c7-c44619f81971'),('73305e01-32ab-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 21:44:33',NULL,'733043d6-32ab-11e2-b8c7-c44619f81971'),('7fd9cf30-32a7-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 21:16:16',NULL,'7fd9bd90-32a7-11e2-b8c7-c44619f81971'),('8cd06a3f-32a4-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 20:55:09',NULL,'8cd05683-32a4-11e2-b8c7-c44619f81971'),('911c0ddb-32b7-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 23:11:11',NULL,'a1bd1279-32b6-11e2-b8c7-c44619f81971'),('9e0f9275-32b5-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 22:57:17',NULL,'9e0ed290-32b5-11e2-b8c7-c44619f81971'),('a1bfb58e-32b6-11e2-b8c7-c44619f81971','Autorizacion Pendiente','2012-11-19 23:04:35','2012-11-19 23:11:11','a1bd1279-32b6-11e2-b8c7-c44619f81971'),('e4bc7a4b-32ac-11e2-b8c7-c44619f81971','Habilitado','2012-11-19 21:54:53',NULL,'e4bc64e4-32ac-11e2-b8c7-c44619f81971');

/*Table structure for table `idioma` */

DROP TABLE IF EXISTS `idioma`;

CREATE TABLE `idioma` (
  `idIdioma` varchar(255) NOT NULL,
  `nombreIdioma` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idIdioma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `idioma` */

insert  into `idioma`(`idIdioma`,`nombreIdioma`) values ('1','espanol'),('2','ingles');

/*Table structure for table `imagen` */

DROP TABLE IF EXISTS `imagen`;

CREATE TABLE `imagen` (
  `idImagen` varchar(255) NOT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `Informacion` varchar(255) DEFAULT NULL,
  `Punto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idImagen`),
  UNIQUE KEY `Informacion` (`Informacion`),
  KEY `FKB95A8273EC58074B` (`Informacion`),
  KEY `idPuntoImagenes` (`Punto`),
  KEY `FKB95A8273659A5014` (`idImagen`),
  CONSTRAINT `FKB95A8273659A5014` FOREIGN KEY (`idImagen`) REFERENCES `recurso` (`idRecurso`),
  CONSTRAINT `FKB95A8273EC58074B` FOREIGN KEY (`Informacion`) REFERENCES `informacion` (`idInformacion`),
  CONSTRAINT `idPuntoImagenes` FOREIGN KEY (`Punto`) REFERENCES `punto` (`idPunto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `imagen` */

insert  into `imagen`(`idImagen`,`extension`,`Informacion`,`Punto`) values ('0dfd637c-329e-11e2-b8c7-c44619f81971','.jpg','0dfd7834-329e-11e2-b8c7-c44619f81971','0dfcc309-329e-11e2-b8c7-c44619f81971'),('0dfd9c93-329e-11e2-b8c7-c44619f81971','.jpg','0dfdb6cf-329e-11e2-b8c7-c44619f81971','0dfcc309-329e-11e2-b8c7-c44619f81971'),('0dfdcff0-329e-11e2-b8c7-c44619f81971','.jpg','0dfde855-329e-11e2-b8c7-c44619f81971','0dfcc309-329e-11e2-b8c7-c44619f81971'),('1','jpg','2','1'),('1ab4866d-32ac-11e2-b8c7-c44619f81971','.jpg','1ab4b76e-32ac-11e2-b8c7-c44619f81971','1ab409fb-32ac-11e2-b8c7-c44619f81971'),('1ab4d71c-32ac-11e2-b8c7-c44619f81971','.jpg','1ab4e465-32ac-11e2-b8c7-c44619f81971','1ab409fb-32ac-11e2-b8c7-c44619f81971'),('1ab4f45a-32ac-11e2-b8c7-c44619f81971','.jpg','1ab5026b-32ac-11e2-b8c7-c44619f81971','1ab409fb-32ac-11e2-b8c7-c44619f81971'),('32f95d51-32aa-11e2-b8c7-c44619f81971','.jpg','32f97db6-32aa-11e2-b8c7-c44619f81971','32f87107-32aa-11e2-b8c7-c44619f81971'),('32f9a561-32aa-11e2-b8c7-c44619f81971','.jpg','32f9cd47-32aa-11e2-b8c7-c44619f81971','32f87107-32aa-11e2-b8c7-c44619f81971'),('32f9f690-32aa-11e2-b8c7-c44619f81971','.jpg','32fa1a41-32aa-11e2-b8c7-c44619f81971','32f87107-32aa-11e2-b8c7-c44619f81971'),('454721ed-32b3-11e2-b8c7-c44619f81971','.jpg','4547c193-32b3-11e2-b8c7-c44619f81971','453c3150-32b3-11e2-b8c7-c44619f81971'),('4548895f-32b3-11e2-b8c7-c44619f81971','.jpg','45492ace-32b3-11e2-b8c7-c44619f81971','453c3150-32b3-11e2-b8c7-c44619f81971'),('637698bc-329d-11e2-b8c7-c44619f81971','.jpg','6376b5c2-329d-11e2-b8c7-c44619f81971','6375a637-329d-11e2-b8c7-c44619f81971'),('6376dd28-329d-11e2-b8c7-c44619f81971','.jpg','6376f52f-329d-11e2-b8c7-c44619f81971','6375a637-329d-11e2-b8c7-c44619f81971'),('63770cd3-329d-11e2-b8c7-c44619f81971','.jpg','63772466-329d-11e2-b8c7-c44619f81971','6375a637-329d-11e2-b8c7-c44619f81971'),('73307c94-32ab-11e2-b8c7-c44619f81971','.jpg','73308f29-32ab-11e2-b8c7-c44619f81971','732fdb02-32ab-11e2-b8c7-c44619f81971'),('7330c115-32ab-11e2-b8c7-c44619f81971','.jpg','7330da03-32ab-11e2-b8c7-c44619f81971','732fdb02-32ab-11e2-b8c7-c44619f81971'),('7330f324-32ab-11e2-b8c7-c44619f81971','.jpg','73310965-32ab-11e2-b8c7-c44619f81971','732fdb02-32ab-11e2-b8c7-c44619f81971'),('7fd9e572-32a7-11e2-b8c7-c44619f81971','.jpg','7fd9f52f-32a7-11e2-b8c7-c44619f81971','7fd9471e-32a7-11e2-b8c7-c44619f81971'),('7fda0624-32a7-11e2-b8c7-c44619f81971','.jpg','7fda1931-32a7-11e2-b8c7-c44619f81971','7fd9471e-32a7-11e2-b8c7-c44619f81971'),('8cd08375-32a4-11e2-b8c7-c44619f81971','.jpg','8cd09400-32a4-11e2-b8c7-c44619f81971','8cc52b12-32a4-11e2-b8c7-c44619f81971'),('8cd0a5a9-32a4-11e2-b8c7-c44619f81971','.jpg','8cd0b49d-32a4-11e2-b8c7-c44619f81971','8cc52b12-32a4-11e2-b8c7-c44619f81971'),('8cd0c769-32a4-11e2-b8c7-c44619f81971','.jpg','8cd0d708-32a4-11e2-b8c7-c44619f81971','8cc52b12-32a4-11e2-b8c7-c44619f81971'),('9e103b29-32b5-11e2-b8c7-c44619f81971','.jpg','9e10af67-32b5-11e2-b8c7-c44619f81971','9e0af9cb-32b5-11e2-b8c7-c44619f81971'),('9e11351a-32b5-11e2-b8c7-c44619f81971','.jpg','9e11ff01-32b5-11e2-b8c7-c44619f81971','9e0af9cb-32b5-11e2-b8c7-c44619f81971'),('9e133e1e-32b5-11e2-b8c7-c44619f81971','.jpg','9e13f00f-32b5-11e2-b8c7-c44619f81971','9e0af9cb-32b5-11e2-b8c7-c44619f81971'),('e4bc9c94-32ac-11e2-b8c7-c44619f81971','.jpg','e4bcad49-32ac-11e2-b8c7-c44619f81971','e4bc0a14-32ac-11e2-b8c7-c44619f81971'),('e4bcc0f8-32ac-11e2-b8c7-c44619f81971','.jpg','e4bcd6db-32ac-11e2-b8c7-c44619f81971','e4bc0a14-32ac-11e2-b8c7-c44619f81971'),('e4bceed1-32ac-11e2-b8c7-c44619f81971','.jpg','e4bd060a-32ac-11e2-b8c7-c44619f81971','e4bc0a14-32ac-11e2-b8c7-c44619f81971');

/*Table structure for table `informacion` */

DROP TABLE IF EXISTS `informacion`;

CREATE TABLE `informacion` (
  `idInformacion` varchar(255) NOT NULL,
  PRIMARY KEY (`idInformacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `informacion` */

insert  into `informacion`(`idInformacion`) values ('0dfcf8c5-329e-11e2-b8c7-c44619f81971'),('0dfd7834-329e-11e2-b8c7-c44619f81971'),('0dfdb6cf-329e-11e2-b8c7-c44619f81971'),('0dfde855-329e-11e2-b8c7-c44619f81971'),('1'),('1ab43126-32ac-11e2-b8c7-c44619f81971'),('1ab4b76e-32ac-11e2-b8c7-c44619f81971'),('1ab4e465-32ac-11e2-b8c7-c44619f81971'),('1ab5026b-32ac-11e2-b8c7-c44619f81971'),('2'),('32f8b1d6-32aa-11e2-b8c7-c44619f81971'),('32f97db6-32aa-11e2-b8c7-c44619f81971'),('32f9cd47-32aa-11e2-b8c7-c44619f81971'),('32fa1a41-32aa-11e2-b8c7-c44619f81971'),('4543fb3b-32b3-11e2-b8c7-c44619f81971'),('4547c193-32b3-11e2-b8c7-c44619f81971'),('45492ace-32b3-11e2-b8c7-c44619f81971'),('6375ee0f-329d-11e2-b8c7-c44619f81971'),('6376b5c2-329d-11e2-b8c7-c44619f81971'),('6376f52f-329d-11e2-b8c7-c44619f81971'),('63772466-329d-11e2-b8c7-c44619f81971'),('733012ef-32ab-11e2-b8c7-c44619f81971'),('73308f29-32ab-11e2-b8c7-c44619f81971'),('7330da03-32ab-11e2-b8c7-c44619f81971'),('73310965-32ab-11e2-b8c7-c44619f81971'),('7fd98c5f-32a7-11e2-b8c7-c44619f81971'),('7fd9f52f-32a7-11e2-b8c7-c44619f81971'),('7fda1931-32a7-11e2-b8c7-c44619f81971'),('8cd016ce-32a4-11e2-b8c7-c44619f81971'),('8cd09400-32a4-11e2-b8c7-c44619f81971'),('8cd0b49d-32a4-11e2-b8c7-c44619f81971'),('8cd0d708-32a4-11e2-b8c7-c44619f81971'),('9e0cf0e5-32b5-11e2-b8c7-c44619f81971'),('9e10af67-32b5-11e2-b8c7-c44619f81971'),('9e11ff01-32b5-11e2-b8c7-c44619f81971'),('9e13f00f-32b5-11e2-b8c7-c44619f81971'),('e4bc39c4-32ac-11e2-b8c7-c44619f81971'),('e4bcad49-32ac-11e2-b8c7-c44619f81971'),('e4bcd6db-32ac-11e2-b8c7-c44619f81971'),('e4bd060a-32ac-11e2-b8c7-c44619f81971');

/*Table structure for table `informacionenidioma` */

DROP TABLE IF EXISTS `informacionenidioma`;

CREATE TABLE `informacionenidioma` (
  `idInformacionEnIdioma` varchar(255) NOT NULL,
  `texto` longtext,
  `nombre` varchar(25598) DEFAULT NULL,
  `Idioma` varchar(255) NOT NULL,
  `Informacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idInformacionEnIdioma`),
  KEY `idInformacion` (`Informacion`),
  KEY `FK869F40BB9781D979` (`Idioma`),
  CONSTRAINT `FK869F40BB9781D979` FOREIGN KEY (`Idioma`) REFERENCES `idioma` (`idIdioma`),
  CONSTRAINT `idInformacion` FOREIGN KEY (`Informacion`) REFERENCES `informacion` (`idInformacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `informacionenidioma` */

insert  into `informacionenidioma`(`idInformacionEnIdioma`,`texto`,`nombre`,`Idioma`,`Informacion`) values ('0dfd13e3-329e-11e2-b8c7-c44619f81971','<p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\">El&nbsp;<b>Cerro de la Gloria</b>&nbsp;es un cerro cercano a la&nbsp;<a href=\"http://es.wikipedia.org/wiki/Ciudad_de_Mendoza\" title=\"Ciudad de Mendoza\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Ciudad de Mendoza</a>.</p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\">Antiguamente denominado \"Cerro del Pilar\", que por decreto del poder ejecutivo se cambiÃ³ a su denominaciÃ³n actual, el 30 de enero de 1913. (Ver secciÃ³n&nbsp;<i>El monumento</i>).</p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\">Se puede acceder a la cima por sederos peatonales (existen algunos accesos de rampas para discapacitados), o en automovil por caminos pavimentados (diferenciados de subida y bajada) con mÃºltiples miradores. A pocos metros del monumento hay un estacionamiento para unos 40 automÃ³viles (micros tambiÃ©n estan permitidos). TambiÃ©n hay un puesto policial e instalaciones sanitarias.</p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\">En una de sus laderas se encuentra el&nbsp;<b><a href=\"http://es.wikipedia.org/wiki/Zool%C3%B3gico_de_Mendoza\" title=\"ZoolÃ³gico de Mendoza\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">ZoolÃ³gico de Mendoza</a></b>. Y en sus cercanÃ­as se ubican el CRICYT, el colegio universitario Departamento de AplicaciÃ³n Docente (DAD), el&nbsp;<i>Liceo AgrÃ­cola y EnolÃ³gico Domingo Faustino Sarmiento</i>, y en sus lÃ­mites el&nbsp;<a href=\"http://es.wikipedia.org/wiki/Copa_Mundial_de_F%C3%BAtbol_de_1978\" title=\"Copa Mundial de FÃºtbol de 1978\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">mundialista</a>&nbsp;<a href=\"http://es.wikipedia.org/wiki/Estadio_Malvinas_Argentinas\" title=\"Estadio Malvinas Argentinas\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Estadio Malvinas Argentinas</a>.</p></p>','Cerro de la Gloria','1','0dfcf8c5-329e-11e2-b8c7-c44619f81971'),('1','Informacion en idioma para el punto','Punto1','1','1'),('1ab4462f-32ac-11e2-b8c7-c44619f81971','<p><p>Estadios | Stadiums</p><p>Balcarce 477<br></p><p>Ciudad de Godoy Cruz</p><p>Departamento de Godoy Cruz</p><p>Provincia de Mendoza</p><p>Tel:: (0261) 524-8096&nbsp;<br></p><p>&nbsp;(0261) 424-9159</p><p><br></p><p>http://www.clubgodoycruz.com.ar</p></p>','Estadio Feliciano Gambarte','1','1ab43126-32ac-11e2-b8c7-c44619f81971'),('2','Informacion en idioma para la imagen','Imagen1','1','2'),('3','Nuestra Historia\r\nOfrecemos servicios de desarrollo de software sin precedentes mediante la combinación de casi 20 años de experiencia, por si fuera poco talento y altamente optimizados por los procesos de desarrollo ágiles\r\nDesde 1993 Belatrix Software Factory (BSF) ha sido uno de los principales proveedores de ITO proporcionar near-shore y offshore outsourcing de servicios de nuestros centros de desarrollo en Mendoza, Argentina y Lima, Perú. Nosotros sólo trabajamos en cuidadosamente seleccionados a nivel empresarial compromisos para garantizar que podemos ofrecer nuestros servicios con la pasión y la excelencia que nos distingue. Trabajamos con clientes que van desde emocionantes nuevas compañías de Fortune 500, y de varios países, incluyendo EE.UU., Canadá, España, Alemania, Brasil, Colombia y México.','Belatrix SF','1','e4bc39c4-32ac-11e2-b8c7-c44619f81971'),('32f8db24-32aa-11e2-b8c7-c44619f81971','<p><div class=\"textPar\" style=\"font-family: Arial, Helvetica, sans-serif; margin: 0px; padding: 0px; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0); font-size: 11px; background-color: rgb(252, 251, 250);\"><p style=\"margin: 0px; padding: 0px 0px 10px; line-height: 1.3em; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0);\">DespuÃ©s de la Segunda Guerra Mundial, Pan American World Airways tuvo la visiÃ³n de ofrecer viajes aÃ©reos internacionales de negocios y placer a la poblaciÃ³n civil en forma masiva, por lo que comenzÃ³ a abrir caminos por los cielos de AmÃ©rica, Europa, Ã?frica, Asia y el Medio Oriente. AsÃ­ naciÃ³ la primera marca internacional de hoteles: InterContinental Hotels &amp; Resorts.</p></div><div class=\"textPar\" style=\"font-family: Arial, Helvetica, sans-serif; margin: 0px; padding: 0px; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0); font-size: 11px; background-color: rgb(252, 251, 250);\"><p style=\"margin: 0px; padding: 0px 0px 10px; line-height: 1.3em; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0);\">El objetivo era ayudar a los empresarios locales a diseÃ±ar, construir, administrar y operar hoteles en importantes destinos de conexiÃ³n y centros de trÃ¡fico internacionales. Como parte de la primera marca realmente internacional de hoteles en el mundo, cada hotel fue diseÃ±ado para ofrecer una experiencia Ãºnica y distintiva. La marca InterContinental se convirtiÃ³ en el sÃ­mbolo de glamour, sofisticaciÃ³n y Ã©xito que, aÃ±os mÃ¡s tarde, sigue definiendo el comercio y los viajes internacionales.</p></div><div class=\"textPar\" style=\"font-family: Arial, Helvetica, sans-serif; margin: 0px; padding: 0px; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0); font-size: 11px; background-color: rgb(252, 251, 250);\"><p style=\"margin: 0px; padding: 0px 0px 10px; line-height: 1.3em; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0);\">Desde nuestros primeros dÃ­as, hemos sido la marca de hoteles elegida por dignatarios extranjeros, jefes de estado, la realeza, estrellas de rock, celebridades y quienes buscan vivencias incomparables. Nuestra lista de huÃ©spedes incluye grandes personajes del pasado y del presente, como Jorge V y la reina MarÃ­a, el prÃ­ncipe Rainiero y la princesa Grace, Ava Gardner, Josephine Baker, Nat King Cole, Imelda Marcos, Margaret Thatcher, Louis Armstrong, el presidente y la seÃ±ora Reagan, el presidente Chirac y el prÃ­ncipe William, por nombrar sÃ³lo algunos.</p></div><div class=\"textPar\" style=\"font-family: Arial, Helvetica, sans-serif; margin: 0px; padding: 0px; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0); font-size: 11px; background-color: rgb(252, 251, 250);\"><p style=\"margin: 0px; padding: 0px 0px 10px; line-height: 1.3em; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0);\">Nuestros huÃ©spedes, entonces y ahora, han tenido una pasiÃ³n por los viajes. Nuestros hoteles siempre han acogido y celebrado la cultura local. Estos valores comunes han moldeado el espÃ­ritu de InterContinental durante aÃ±os. Hoy en dÃ­a, nuestra marca y nuestro personal dan vida a este legado.</p></div><div class=\"textPar\" style=\"font-family: Arial, Helvetica, sans-serif; margin: 0px; padding: 0px; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0); font-size: 11px; background-color: rgb(252, 251, 250);\"><p style=\"margin: 0px; padding: 0px 0px 10px; line-height: 1.3em; vertical-align: baseline; border: 0px; outline: rgb(0, 0, 0);\">Con una red mundial de mÃ¡s de 150 hoteles en 65 paÃ­ses, InterContinental Hotels &amp; Resorts ha dado la bienvenida a los viajeros frecuentes internacionales durante mÃ¡s de medio siglo. Pioneros en el desarrollo de la industria hotelera, los hoteles InterContinental combinan con gran Ã©xito normas de excelencia mundiales con las distintas culturas locales, a fin de ofrecer una experiencia autÃ©ntica y local.</p></div></p>','Hotel Intercontinental','1','32f8b1d6-32aa-11e2-b8c7-c44619f81971'),('4544b6ef-32b3-11e2-b8c7-c44619f81971','<p><span style=\"color: rgb(98, 79, 37); font-family: \'Times New Roman\', Times, serif; font-size: 11px; font-weight: bold; text-align: center;\">Ruta Panamericana 2650 (Palmares Open Mall) Godoy Cruz - Mendoza, Argentina / palmares@donmario.com.ar / +54 261 4394838</span><br style=\"color: rgb(98, 79, 37); font-family: \'Times New Roman\', Times, serif; font-size: 11px; font-weight: bold; text-align: center;\"><span style=\"color: rgb(98, 79, 37); font-family: \'Times New Roman\', Times, serif; font-size: 11px; font-weight: bold; text-align: center;\">25 de Mayo 1324 - Dorrego, GuaymallÃ©n - Mendoza, Argentina / dorrego@donmario.com.ar / +54 261 4310810</span><br></p>','Don Mario','1','4543fb3b-32b3-11e2-b8c7-c44619f81971'),('63761922-329d-11e2-b8c7-c44619f81971','<p><p style=\"margin: 10px 0px; font-family: Arial, sans-serif; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255); text-align: justify;\">La Universidad TecnolÃ³gica Nacional abriÃ³ sus puertas en 1948, en Buenos Aires y&nbsp; bajo el nombre de â??Universidad Obreraâ??. Se creÃ³ con el objetivo de formar a los trabajadores industriales como Ingenieros de FÃ¡brica.</p><p style=\"margin: 10px 0px; font-family: Arial, sans-serif; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255); text-align: justify;\">Desde entonces y hasta la actualidad, en nuestra Facultad Regional se han graduado mÃ¡s de 2.900 ingenieros en las cinco carreras de grado, y unos 5 mil estudiantes esperan graduarse no sÃ³lo como ingenieros, sino como tÃ©cnicos y licenciados en otros campos del saber: enologÃ­a, administraciÃ³n de empresas, matemÃ¡tica, turismo y hotelerÃ­a; especialidades que diversifican la oferta acadÃ©mica haciendo de nuestra facultad una de las mÃ¡s completas tanto en oferta de ingenierÃ­as, como en diversidad educativa.<br></p><p style=\"margin: 10px 0px; font-family: Arial, sans-serif; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><br></p></p>','Universidad Tecnologica Nacional - Facultad Regional Mendoza','1','6375ee0f-329d-11e2-b8c7-c44619f81971'),('73302889-32ab-11e2-b8c7-c44619f81971','<p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\"><b>Club Sportivo Independiente Rivadavia</b>&nbsp;(mostly known simply as&nbsp;<b>Independiente Rivadavia</b>) is a football club from&nbsp;<a href=\"http://en.wikipedia.org/wiki/Mendoza,_Argentina\" title=\"Mendoza, Argentina\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Mendoza</a>,&nbsp;<a href=\"http://en.wikipedia.org/wiki/Argentina\" title=\"Argentina\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Argentina</a>. The team currently plays in&nbsp;<a href=\"http://en.wikipedia.org/wiki/Primera_B_Nacional\" title=\"Primera B Nacional\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Primera B Nacional</a>, the second major league in Argentine Football league system.</p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\">Independiente Rivadavia played in the&nbsp;<a href=\"http://en.wikipedia.org/wiki/Primera_Divisi%C3%B3n_Argentina\" title=\"Primera DivisiÃ³n Argentina\" class=\"mw-redirect\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Argentine Primera</a>&nbsp;in 1968, 1973, 1977, 1979â??1980 and 1982, when the team reached the quarter-finals of the National Championship. That year Independiente was eliminated in the playoffs by the team that would later reach the Championship,&nbsp;<a href=\"http://en.wikipedia.org/wiki/Ferro_Carril_Oeste\" title=\"Ferro Carril Oeste\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Ferro Carril Oeste</a>.<br><br><br><p style=\"color: rgb(68, 68, 68); font-family: Arial, Helvetica, sans-serif; font-size: 12px; line-height: 18px; padding: 0px; margin: 0px 0px 7px;\">El Club Sportivo Independiente Rivadavia fue fundado el 24 de enero de 1913. El origen de la entidad es el club que naciÃ³ en el aÃ±o 1902 con el nombre de Club AtlÃ©tico Belgrano, considerado el PRIMER CLUB EN LA HISTORIA DEL FÃ?TBOL MENDOCINO.</p><p style=\"color: rgb(68, 68, 68); font-family: Arial, Helvetica, sans-serif; font-size: 12px; line-height: 18px; padding: 0px; margin: 0px 0px 7px;\"><img src=\"http://www.independientemza.com.ar/uploads/Luis_Burotto.jpg\" alt=\"\" width=\"187\" height=\"263\">&nbsp;<img src=\"http://www.independientemza.com.ar/uploads/Campeon_1913.jpg\" alt=\"\" width=\"350\" height=\"263\"></p><p style=\"color: rgb(68, 68, 68); font-family: Arial, Helvetica, sans-serif; font-size: 12px; line-height: 18px; padding: 0px; margin: 0px 0px 7px;\"><strong style=\"font-size: 14px;\">Luis Burotto - Fundador y Primer Presidente del Club AtlÃ©tico Belgrano. CampeÃ³n 1913.</strong></p><p style=\"color: rgb(68, 68, 68); font-family: Arial, Helvetica, sans-serif; font-size: 12px; line-height: 18px; padding: 0px; margin: 0px 0px 7px;\">Ante la imposibilidad de esta entidad, de seguir disputando los torneos de entonces (por divergencias con la liga local y clubes varios) los dirigentes tomaron la decisiÃ³n de crear una nueva instituciÃ³n, la que tomÃ³ el nombre de Club AtlÃ©tico Independiente, en alusiÃ³n a la independencia que pretendÃ­an de la anterior entidad.</p><p style=\"color: rgb(68, 68, 68); font-family: Arial, Helvetica, sans-serif; font-size: 12px; line-height: 18px; padding: 0px; margin: 0px 0px 7px;\">En 1919 se habÃ­a convertido en el equipo mÃ¡s ganador de Mendoza, con 7 tÃ­tulos consecutivos, y lograrÃ­a el octavo, al aÃ±o siguiente, fijando un record no batido a la fecha. Ese aÃ±o se fusionÃ³ con el Club Sportivo Rivadavia, naciendo el que lleva la actual denominaciÃ³n, bajo la presidencia de Bautista Gargantini. A partir de ese momento, se transformÃ³ en el club mÃ¡s popular de Mendoza, llegando a tener en las dÃ©cadas del Â´60 y Â´70, mÃ¡s de 20.000 socios activos, con sus cuotas al dÃ­a.</p><p style=\"color: rgb(68, 68, 68); font-family: Arial, Helvetica, sans-serif; font-size: 12px; line-height: 18px; padding: 0px; margin: 0px 0px 7px;\">El color de la camiseta del Club AtlÃ©tico Belgrano fue el verde musgo. Los del Club AtlÃ©tico Independiente fueron el rojo, blanco y verde a bastones verticales, con pantalÃ³n blanco. A partir de la fusiÃ³n de 1919 se adopta el color azul, en homenaje a la SelecciÃ³n Azurra de Italia, de donde provenÃ­a la familia del presidente. Se verÃ¡ pues, que el nombre oficial contemplaba a ambos clubes: Sportivo Rivadavia e Independiente.</p></p></p>','Club Sportivo Independiente Rivadavia','1','733012ef-32ab-11e2-b8c7-c44619f81971'),('7fd9a8f6-32a7-11e2-b8c7-c44619f81971','<p>Polideportivo numero 1 de capital.&nbsp;</p>','Polideportivo Numero 1','1','7fd98c5f-32a7-11e2-b8c7-c44619f81971'),('8cd03680-32a4-11e2-b8c7-c44619f81971','<p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\"><b>Mendoza</b>&nbsp;(<small>Spanish pronunciation:&nbsp;</small><span title=\"Representation in the International Phonetic Alphabet (IPA)\" class=\"IPA\"><a href=\"http://en.wikipedia.org/wiki/Help:IPA_for_Spanish\" title=\"Help:IPA for Spanish\" style=\"text-decoration: initial !important; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">[menË?dosa]</a></span>) is the capital city of&nbsp;<a href=\"http://en.wikipedia.org/wiki/Mendoza_Province\" title=\"Mendoza Province\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Mendoza Province</a>, in&nbsp;<a href=\"http://en.wikipedia.org/wiki/Argentina\" title=\"Argentina\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Argentina</a>. It is located in the northern-central part of the province, in a region of foothills and high plains, on the eastern side of the&nbsp;<a href=\"http://en.wikipedia.org/wiki/Andes\" title=\"Andes\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Andes</a>. As of the 2001&nbsp;<a href=\"http://en.wikipedia.org/wiki/Census\" title=\"Census\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">census</a>&nbsp;<small>[<a href=\"http://en.wikipedia.org/wiki/National_Institute_of_Statistics_and_Census_of_Argentina\" title=\"National Institute of Statistics and Census of Argentina\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">INDEC</a>]</small>, Mendoza\'s population was 110,993. The metropolitan population was 848,660 in 2001, making&nbsp;<a href=\"http://en.wikipedia.org/wiki/Greater_Mendoza\" title=\"Greater Mendoza\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Greater Mendoza</a>&nbsp;the fourth largest census metropolitan area in the country.</p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\"><a href=\"http://en.wikipedia.org/wiki/National_Route_7_(Argentina)\" title=\"National Route 7 (Argentina)\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Ruta Nacional 7</a>, the major road running between&nbsp;<a href=\"http://en.wikipedia.org/wiki/Buenos_Aires\" title=\"Buenos Aires\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Buenos Aires</a>&nbsp;and&nbsp;<a href=\"http://en.wikipedia.org/wiki/Santiago,_Chile\" title=\"Santiago, Chile\" class=\"mw-redirect\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Santiago</a>, runs through Mendoza. The city is a frequent stopover for climbers on their way to&nbsp;<a href=\"http://en.wikipedia.org/wiki/Aconcagua\" title=\"Aconcagua\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Aconcagua</a>&nbsp;(the highest mountain in the Western and Southern Hemispheres) and for&nbsp;<a href=\"http://en.wikipedia.org/wiki/Adventure_travel\" title=\"Adventure travel\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">adventure travelers</a>&nbsp;interested in<a href=\"http://en.wikipedia.org/wiki/Mountaineering\" title=\"Mountaineering\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">mountaineering</a>,&nbsp;<a href=\"http://en.wikipedia.org/wiki/Hiking\" title=\"Hiking\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">hiking</a>,&nbsp;<a href=\"http://en.wikipedia.org/wiki/Horseback_riding\" title=\"Horseback riding\" class=\"mw-redirect\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">horseback riding</a>,&nbsp;<a href=\"http://en.wikipedia.org/wiki/Rafting\" title=\"Rafting\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">rafting</a>, and other sports. In the winter,&nbsp;<a href=\"http://en.wikipedia.org/wiki/Ski\" title=\"Ski\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">skiers</a>&nbsp;come to the city for its easy access to the&nbsp;<a href=\"http://en.wikipedia.org/wiki/Andes\" title=\"Andes\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Andes</a>.</p><p style=\"margin: 0.4em 0px 0.5em; line-height: 19.200000762939453px; font-family: sans-serif; font-size: 13px; background-color: rgb(255, 255, 255);\">Two of the main industries of Mendoza area are&nbsp;<a href=\"http://en.wikipedia.org/wiki/Olive_oil\" title=\"Olive oil\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">olive oil</a>&nbsp;production and&nbsp;<a href=\"http://en.wikipedia.org/wiki/Argentine_wine\" title=\"Argentine wine\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">wine</a>&nbsp;making. The region around Greater Mendoza is the largest wine producing area in&nbsp;<a href=\"http://en.wikipedia.org/wiki/Latin_America\" title=\"Latin America\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">Latin America</a>. As such, Mendoza is one of nine cities worldwide in the network of Great Capitals of Wine, and the city is an emerging&nbsp;<a href=\"http://en.wikipedia.org/wiki/Enotourism\" title=\"Enotourism\" style=\"text-decoration: initial; color: rgb(11, 0, 128); background-image: none; background-position: initial initial; background-repeat: initial initial;\">enotourism</a>&nbsp;(Wine tourism) destination and base for exploring the hundreds of wineries in the region.</p></p>','Plaza Independencia','2','8cd016ce-32a4-11e2-b8c7-c44619f81971'),('9e0dedf6-32b5-11e2-b8c7-c44619f81971','<p><div id=\"contenido\" style=\"position: relative; width: 470px; text-align: -webkit-center;\"><h4 align=\"CENTER\">Mercados y FrigorÃ­ficos Mendoza S.A.</h4><p>El MERCADO CENTRAL es el Centro Comercial mÃ¡s antiguo de la Provincia de Mendoza, que desde fines del siglo XIX ofrece sus productos de primera calidad y gran variedad en cada uno de sus mÃ¡s de cien puestos ordenados, dentro de esa gran estructura, en forma artesanal.</p><img alt=\"Puesto de Golosinas\" src=\"http://www.mercadoc.com.ar/images/golosinas_chica.jpg\"></div><div id=\"pie\" style=\"text-align: -webkit-center;\"><br><hr id=\"linea_pie\" style=\"width: 329px;\"><font size=\"2\"><p>TelÃ©fono: (+54 0261) 425 6904</p><p>General Paz 262 - Ciudad de Mendoza - Mendoza - CP:5500</p></font></div></p>','Mercado Central','1','9e0cf0e5-32b5-11e2-b8c7-c44619f81971'),('9e1298e7-32b5-11e2-b8c7-c44619f81971','Pescaderia','Pescaderia','1','9e11ff01-32b5-11e2-b8c7-c44619f81971'),('e4bc51b9-32ac-11e2-b8c7-c44619f81971','<p><p>Our History</p><p>We provide unparalleled software development services by combining nearly 20 years of experience, top IT talent, and highly-tuned agile development processes</p><p>Since 1993 Belatrix Software Factory (BSF) has been a leading ITO vendor providing near-shore and offshore outsourcing services from our Development Centers in Mendoza, Argentina and Lima, PerÃº. We only work on carefully selected enterprise-level engagements to ensure we can provide our services with the passion and excellence that set us apart. We work with clients ranging from exciting startup companies to Fortune 500 corporations, and from multiple countries including USA, Canada, Spain, Germany, Brazil, Colombia, and Mexico.</p></p>','Belatrix SF','2','e4bc39c4-32ac-11e2-b8c7-c44619f81971');

/*Table structure for table `link` */

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `idLink` varchar(255) NOT NULL,
  `Punto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idLink`),
  KEY `FK32AFFA1FD5F85B` (`idLink`),
  KEY `idPuntoLinks` (`Punto`),
  CONSTRAINT `idPuntoLinks` FOREIGN KEY (`Punto`) REFERENCES `punto` (`idPunto`),
  CONSTRAINT `FK32AFFA1FD5F85B` FOREIGN KEY (`idLink`) REFERENCES `recurso` (`idRecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `link` */

insert  into `link`(`idLink`,`Punto`) values ('2','1');

/*Table structure for table `localizacion` */

DROP TABLE IF EXISTS `localizacion`;

CREATE TABLE `localizacion` (
  `idLocalizacion` varchar(255) NOT NULL,
  `latitud` varchar(255) DEFAULT NULL,
  `longitud` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idLocalizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `localizacion` */

insert  into `localizacion`(`idLocalizacion`,`latitud`,`longitud`) values ('0dfce129-329e-11e2-b8c7-c44619f81971','-32.88886835271703','-68.891199528833'),('1','0','0'),('1ab41dbb-32ac-11e2-b8c7-c44619f81971','-32.91989086529937','-68.84025901522216'),('32f89005-32aa-11e2-b8c7-c44619f81971','-32.90072376653235','-68.80000442232665'),('453cf6ce-32b3-11e2-b8c7-c44619f81971','-32.8984807','-68.82113240000001'),('6375c8cd-329d-11e2-b8c7-c44619f81971','-32.8966154575496','-68.85313091849366'),('732ff2e7-32ab-11e2-b8c7-c44619f81971','-32.890850371251084','-68.86334747042235'),('7fd9586d-32a7-11e2-b8c7-c44619f81971','-32.896237633928386','-68.85839074816283'),('8cc7ab2a-32a4-11e2-b8c7-c44619f81971','-32.889661165451265','-68.84463638033446'),('9e0c27f6-32b5-11e2-b8c7-c44619f81971','-32.88519249189536','-68.84158939089355'),('e4bc20ab-32ac-11e2-b8c7-c44619f81971','-32.8925311','-68.83991129999998');

/*Table structure for table `periodo` */

DROP TABLE IF EXISTS `periodo`;

CREATE TABLE `periodo` (
  `idPeriodo` varchar(255) NOT NULL,
  `fechaInicioPeriodo` datetime DEFAULT NULL,
  `fechaFinPeriodo` datetime DEFAULT NULL,
  PRIMARY KEY (`idPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `periodo` */

/*Table structure for table `permiso` */

DROP TABLE IF EXISTS `permiso`;

CREATE TABLE `permiso` (
  `idPermiso` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `permiso` */

insert  into `permiso`(`idPermiso`,`nombre`,`descripcion`) values ('1','PERMISO_ADMINISTRADOR','Permiso de administrador'),('2','PERMISO_CLIENTE','Permiso de Cliente');

/*Table structure for table `permisorol` */

DROP TABLE IF EXISTS `permisorol`;

CREATE TABLE `permisorol` (
  `idPermisoRol` varchar(255) NOT NULL,
  `permisosRol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPermisoRol`),
  KEY `idPermisoRol` (`permisosRol`),
  CONSTRAINT `idPermisoRol` FOREIGN KEY (`permisosRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `permisorol` */

/*Table structure for table `permisousuario` */

DROP TABLE IF EXISTS `permisousuario`;

CREATE TABLE `permisousuario` (
  `idPermisoUsuario` varchar(255) NOT NULL,
  `permiso` varchar(255) DEFAULT NULL,
  `Usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPermisoUsuario`),
  KEY `idPermisoUsuario` (`Usuario`),
  KEY `idPermiso` (`permiso`),
  CONSTRAINT `idPermiso` FOREIGN KEY (`permiso`) REFERENCES `permiso` (`idPermiso`),
  CONSTRAINT `idPermisoUsuario` FOREIGN KEY (`Usuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `permisousuario` */

insert  into `permisousuario`(`idPermisoUsuario`,`permiso`,`Usuario`) values ('1','1','1'),('2','1','2'),('3','2','1'),('911a11a8-32b7-11e2-b8c7-c44619f81971','2','911a11a8-32b7-11e2-b8c7-c44619f81971');

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `idPersona` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `FKD78FCFAC134C1520` (`idPersona`),
  CONSTRAINT `FKD78FCFAC134C1520` FOREIGN KEY (`idPersona`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`idPersona`,`apellido`,`nombre`,`sexo`,`dni`,`fechaDeNacimiento`) values ('1','Juan','Perez','Masculino','34123456','2012-11-19'),('a1bc0947-32b6-11e2-b8c7-c44619f81971','Pérez','Pablo ','M','33953934','1989-02-24');

/*Table structure for table `punto` */

DROP TABLE IF EXISTS `punto`;

CREATE TABLE `punto` (
  `idPunto` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `Localizacion` varchar(255) NOT NULL,
  `Informacion` varchar(255) DEFAULT NULL,
  `categoriaPunto` varchar(255) DEFAULT NULL,
  `ciclo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPunto`),
  UNIQUE KEY `Localizacion` (`Localizacion`),
  UNIQUE KEY `Informacion` (`Informacion`),
  UNIQUE KEY `ciclo` (`ciclo`),
  KEY `FK6612344EC58074B` (`Informacion`),
  KEY `FK6612344F143869C` (`Localizacion`),
  KEY `FK66123447A3E6E41` (`ciclo`),
  KEY `FK66123446B4AD834` (`categoriaPunto`),
  CONSTRAINT `FK66123446B4AD834` FOREIGN KEY (`categoriaPunto`) REFERENCES `categoria` (`idCategoria`),
  CONSTRAINT `FK66123447A3E6E41` FOREIGN KEY (`ciclo`) REFERENCES `ciclo` (`idCiclo`),
  CONSTRAINT `FK6612344EC58074B` FOREIGN KEY (`Informacion`) REFERENCES `informacion` (`idInformacion`),
  CONSTRAINT `FK6612344F143869C` FOREIGN KEY (`Localizacion`) REFERENCES `localizacion` (`idLocalizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `punto` */

insert  into `punto`(`idPunto`,`nombre`,`Localizacion`,`Informacion`,`categoriaPunto`,`ciclo`) values ('0dfcc309-329e-11e2-b8c7-c44619f81971','Cerro de la Gloria','0dfce129-329e-11e2-b8c7-c44619f81971','0dfcf8c5-329e-11e2-b8c7-c44619f81971','4','0dfd2e6b-329e-11e2-b8c7-c44619f81971'),('1','Punto de Interes','1','1','1','1'),('1ab409fb-32ac-11e2-b8c7-c44619f81971','Estadio Feliciano Gambarte','1ab41dbb-32ac-11e2-b8c7-c44619f81971','1ab43126-32ac-11e2-b8c7-c44619f81971','13','1ab45a04-32ac-11e2-b8c7-c44619f81971'),('32f87107-32aa-11e2-b8c7-c44619f81971','Hotel Intercontinental','32f89005-32aa-11e2-b8c7-c44619f81971','32f8b1d6-32aa-11e2-b8c7-c44619f81971','1','32f90d4d-32aa-11e2-b8c7-c44619f81971'),('453c3150-32b3-11e2-b8c7-c44619f81971','Don Mario','453cf6ce-32b3-11e2-b8c7-c44619f81971','4543fb3b-32b3-11e2-b8c7-c44619f81971','3','45454e3e-32b3-11e2-b8c7-c44619f81971'),('6375a637-329d-11e2-b8c7-c44619f81971','Universidad Tecnologica Nacional - Facultad Regional Mendoza','6375c8cd-329d-11e2-b8c7-c44619f81971','6375ee0f-329d-11e2-b8c7-c44619f81971','10','637647de-329d-11e2-b8c7-c44619f81971'),('732fdb02-32ab-11e2-b8c7-c44619f81971','Club Sportivo Independiente Rivadavia','732ff2e7-32ab-11e2-b8c7-c44619f81971','733012ef-32ab-11e2-b8c7-c44619f81971','12','733043d6-32ab-11e2-b8c7-c44619f81971'),('7fd9471e-32a7-11e2-b8c7-c44619f81971','Polideportivo Numero 1','7fd9586d-32a7-11e2-b8c7-c44619f81971','7fd98c5f-32a7-11e2-b8c7-c44619f81971','7','7fd9bd90-32a7-11e2-b8c7-c44619f81971'),('8cc52b12-32a4-11e2-b8c7-c44619f81971','Plaza Independencia','8cc7ab2a-32a4-11e2-b8c7-c44619f81971','8cd016ce-32a4-11e2-b8c7-c44619f81971','5','8cd05683-32a4-11e2-b8c7-c44619f81971'),('9e0af9cb-32b5-11e2-b8c7-c44619f81971','Mercado Central','9e0c27f6-32b5-11e2-b8c7-c44619f81971','9e0cf0e5-32b5-11e2-b8c7-c44619f81971','8','9e0ed290-32b5-11e2-b8c7-c44619f81971'),('e4bc0a14-32ac-11e2-b8c7-c44619f81971','Belatrix SF','e4bc20ab-32ac-11e2-b8c7-c44619f81971','e4bc39c4-32ac-11e2-b8c7-c44619f81971','11','e4bc64e4-32ac-11e2-b8c7-c44619f81971');

/*Table structure for table `puntocomercial` */

DROP TABLE IF EXISTS `puntocomercial`;

CREATE TABLE `puntocomercial` (
  `idpuntoComercial` varchar(255) NOT NULL,
  `cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpuntoComercial`),
  KEY `idCliente` (`cliente`),
  KEY `FK96198B1BBF7EDB52` (`idpuntoComercial`),
  CONSTRAINT `FK96198B1BBF7EDB52` FOREIGN KEY (`idpuntoComercial`) REFERENCES `punto` (`idPunto`),
  CONSTRAINT `idCliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `puntocomercial` */

insert  into `puntocomercial`(`idpuntoComercial`,`cliente`) values ('1','1');

/*Table structure for table `recurso` */

DROP TABLE IF EXISTS `recurso`;

CREATE TABLE `recurso` (
  `idRecurso` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `recurso` */

insert  into `recurso`(`idRecurso`,`url`) values ('0dfd637c-329e-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/cerro_gloria1.jpg'),('0dfd9c93-329e-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/cerro_gloria2.jpg'),('0dfdcff0-329e-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/cerro_gloria.jpg'),('1','imagen'),('1ab4866d-32ac-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/estadio_feli1.jpg'),('1ab4d71c-32ac-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/estadio_feli2.jpg'),('1ab4f45a-32ac-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/estadio_feli.jpg'),('2','link'),('32f95d51-32aa-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/hotel_inter2.jpg'),('32f9a561-32aa-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/hotel_inter.jpg'),('32f9f690-32aa-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/hotel_inter1.jpg'),('454721ed-32b3-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/don_mario1.jpg'),('4548895f-32b3-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/don_mario.jpg'),('637698bc-329d-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/entrada_interna_utn.jpg'),('6376dd28-329d-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/utn_isi.jpg'),('63770cd3-329d-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/web_utn.jpg'),('73307c94-32ab-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/indepen.jpg'),('7330c115-32ab-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/indepen3.jpg'),('7330f324-32ab-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/indepen2.jpg'),('7fd9e572-32a7-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/poli_1.jpg'),('7fda0624-32a7-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/poli_2.jpg'),('8cd08375-32a4-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/plaza_inde.jpg'),('8cd0a5a9-32a4-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/plaza_inde3.jpg'),('8cd0c769-32a4-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/plaza_inde2.jpg'),('9e103b29-32b5-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/museo_funda.jpg'),('9e11351a-32b5-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/mercado_central1.jpg'),('9e133e1e-32b5-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/mercado_central.jpg'),('e4bc9c94-32ac-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/belatrix2.jpg'),('e4bcc0f8-32ac-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/belatrix1.jpg'),('e4bceed1-32ac-11e2-b8c7-c44619f81971','C:\\Users\\Rodrius/belatriz.jpg');

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `idRol` varchar(255) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

/*Table structure for table `rubro` */

DROP TABLE IF EXISTS `rubro`;

CREATE TABLE `rubro` (
  `idRubro` varchar(255) NOT NULL,
  `categoriaRubro` varchar(255) DEFAULT NULL,
  `nombreRubro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRubro`),
  UNIQUE KEY `categoriaRubro` (`categoriaRubro`),
  KEY `FK67D24FC6B66D9EC` (`categoriaRubro`),
  CONSTRAINT `FK67D24FC6B66D9EC` FOREIGN KEY (`categoriaRubro`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rubro` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` varchar(255) NOT NULL,
  `nombreUsuario` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`idUsuario`,`nombreUsuario`,`contrasenia`) values ('1','admin','admin'),('2','cliente','cliente'),('911a11a8-32b7-11e2-b8c7-c44619f81971','PérezPablo ','FSF4BCGYN7EU');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
