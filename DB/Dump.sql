-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COUNTRY` varchar(45) NOT NULL,
  `REGION_ID` int(10) unsigned NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `STREET` varchar(45) NOT NULL,
  `BUILDING` varchar(45) NOT NULL,
  `ZIPCODE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ADDRESS_REGION_idx` (`REGION_ID`),
  CONSTRAINT `fk_ADDRESS_REGION` FOREIGN KEY (`REGION_ID`) REFERENCES `region` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'BELARUS',1,'MINSK','NEMIGA','27','220200'),(2,'BELARUS',1,'MINSK','ZAHAROVA','5','220320'),(3,'BELARUS',1,'MINSK','KOZLOVA','14','220220'),(4,'BELARUS',1,'MINSK','FRUNZE','2','220012'),(5,'BELARUS',1,'MINSK','NEMIGA','35','222020');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administration_employees`
--

DROP TABLE IF EXISTS `administration_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administration_employees` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EMPLOYEES_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ADMINISTRATION_EMPLOYEES_EMPLOYEES1_idx` (`EMPLOYEES_ID`),
  CONSTRAINT `fk_ADMINISTRATION_EMPLOYEES_EMPLOYEES1` FOREIGN KEY (`EMPLOYEES_ID`) REFERENCES `employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administration_employees`
--

LOCK TABLES `administration_employees` WRITE;
/*!40000 ALTER TABLE `administration_employees` DISABLE KEYS */;
INSERT INTO `administration_employees` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `administration_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `builder_workers`
--

DROP TABLE IF EXISTS `builder_workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `builder_workers` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CONSTRUCTION_EMPLOYEES_ID` int(10) unsigned NOT NULL,
  `KIND_OF_WORK` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_BUILDER_WORKERS_CONSTRUCTION_EMPLOYEES1_idx` (`CONSTRUCTION_EMPLOYEES_ID`),
  CONSTRAINT `fk_BUILDER_WORKERS_CONSTRUCTION_EMPLOYEES1` FOREIGN KEY (`CONSTRUCTION_EMPLOYEES_ID`) REFERENCES `construction_employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `builder_workers`
--

LOCK TABLES `builder_workers` WRITE;
/*!40000 ALTER TABLE `builder_workers` DISABLE KEYS */;
INSERT INTO `builder_workers` VALUES (1,1,'CIVIL ENGINEERING'),(2,2,'CIVIL ENGINEERING'),(3,3,'CIVIL ENGINEERING'),(4,4,'CIVIL ENGINEERING'),(5,5,'CIVIL ENGINEERING');
/*!40000 ALTER TABLE `builder_workers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `construction_employees`
--

DROP TABLE IF EXISTS `construction_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `construction_employees` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EMPLOYEES_ID` int(10) unsigned NOT NULL,
  `COLOUR_OF_HARDHAT` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_CONSTRUCTION_EMPLOYEES_EMPLOYEES1_idx` (`EMPLOYEES_ID`),
  CONSTRAINT `fk_CONSTRUCTION_EMPLOYEES_EMPLOYEES1` FOREIGN KEY (`EMPLOYEES_ID`) REFERENCES `employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `construction_employees`
--

LOCK TABLES `construction_employees` WRITE;
/*!40000 ALTER TABLE `construction_employees` DISABLE KEYS */;
INSERT INTO `construction_employees` VALUES (1,11,'ORANGE'),(2,12,'ORANGE'),(3,13,'ORANGE'),(4,14,'ORANGE'),(5,15,'ORANGE'),(6,16,'ORANGE'),(7,17,'ORANGE'),(8,18,'ORANGE'),(9,19,'ORANGE'),(10,20,'ORANGE');
/*!40000 ALTER TABLE `construction_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `economists`
--

DROP TABLE IF EXISTS `economists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `economists` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ADMINISTRATION_EMPLOYEES_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ECONNOMISTS_ADMINISTRATION_EMPLOYEES1_idx` (`ADMINISTRATION_EMPLOYEES_ID`),
  CONSTRAINT `fk_ECONNOMISTS_ADMINISTRATION_EMPLOYEES1` FOREIGN KEY (`ADMINISTRATION_EMPLOYEES_ID`) REFERENCES `administration_employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `economists`
--

LOCK TABLES `economists` WRITE;
/*!40000 ALTER TABLE `economists` DISABLE KEYS */;
INSERT INTO `economists` VALUES (1,6),(2,7),(3,8),(4,9),(5,10);
/*!40000 ALTER TABLE `economists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `SURNAME` varchar(45) NOT NULL,
  `JOB_TITLE` varchar(45) NOT NULL,
  `DATE_OF_BIRTH` date NOT NULL,
  `ADDRESS_ID` int(10) unsigned NOT NULL,
  `SALARY_ID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_EMPLOYEES_ADDRESS1_idx` (`ADDRESS_ID`),
  KEY `fk_EMPLOYEES_SALARY1_idx` (`SALARY_ID`),
  CONSTRAINT `fk_EMPLOYEES_ADDRESS1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'ALEX','BLACK','CEO','1965-12-12',1,0),(2,'MAX','DAVIDOV','COO','1977-10-24',2,0),(3,'EGOR','PETROV','DIRECTOR','1986-05-14',3,0),(4,'IGOR','MENDELEEV','SENIOR MANAGER','1984-03-01',4,0),(5,'ALEX','FOX','MANAGER','1981-10-09',5,0),(6,'OLGA','WHITE','ACCOUNTANT','1986-10-07',1,0),(7,'KATE','DERVOED','ACCOUNTANT','1988-01-19',2,0),(8,'ANNA','KURG','ACCOUNTANT','1989-10-22',3,0),(9,'JULIA','SWERG','ACCOUNTANT','1992-05-12',4,0),(10,'MILA','MILAYA','ACCOUNTANT','1981-12-30',5,0),(11,'OLEG','IVANOV','BRICKLAYER','1988-11-01',1,0),(12,'DIMA','VOLKOV','PAINTER','1983-03-24',2,0),(13,'ANTON','MEDVEDEV','PAINTER','1989-11-22',3,0),(14,'DENIS','KURLY','BRICKLAYER','1992-07-12',4,0),(15,'VLAD','MILOV','BRICKLAYER','1981-10-30',5,0),(16,'ALEX','VOLOSACH','JUNIOR MASHINIST','1991-09-01',1,0),(17,'BERG','MENKOV','JUNIOR MASHINIST','1983-07-29',2,0),(18,'JORJ','MORJ','SENIOR MASHINIST','1984-10-25',3,0),(19,'DENIS','HIGH','JUNIOR MASHINIST','1989-02-14',4,0),(20,'VLAD','KOLOBOV','SENIOR MASHINIST','1981-10-30',5,0),(21,'FRANK','MERILOV','JUNIOR ENGINEER','1992-04-06',1,0),(22,'BOB','KUHAREV','SENIOR ENGINEER','1985-01-09',2,0),(23,'ANNA','MORS','MIDDLE ENGINEER','1990-02-28',3,0),(24,'ZHANNA','NIKOLAEV','MIDDLE ENGINEER','1987-12-25',4,0),(25,'ALEX','MELNIK','JUNIOR ENGINEER','1992-09-11',5,0),(26,'ALEX','MULUKINA','DESIGN MANAGER PROJECT','1982-03-16',1,0),(27,'MAX','FURS','CONSTRUCTION MANAGER PROJECT','1989-01-09',2,0),(28,'KATE','COOK','DESIGN MANAGER PROJECT','1980-06-24',3,0),(29,'NINA','RICHI','ELECTRICITY MANAGER PROJECT','1987-10-25',4,0),(30,'ALEX','MILK','ELECTRICITY MANAGER PROJECT','1982-07-15',5,0);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `engineers`
--

DROP TABLE IF EXISTS `engineers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `engineers` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PROJECT_EMPLOYEES_ID` int(10) unsigned NOT NULL,
  `SPECIALIZATION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ENGINEERS_PROJECT_EMPLOYEES1_idx` (`PROJECT_EMPLOYEES_ID`),
  CONSTRAINT `fk_ENGINEERS_PROJECT_EMPLOYEES1` FOREIGN KEY (`PROJECT_EMPLOYEES_ID`) REFERENCES `project_employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `engineers`
--

LOCK TABLES `engineers` WRITE;
/*!40000 ALTER TABLE `engineers` DISABLE KEYS */;
INSERT INTO `engineers` VALUES (3,1,'ELECTRICITY'),(4,2,'CIVIL ENGINEERING'),(5,3,'DESIGN'),(6,4,'ELECTRICITY'),(7,5,'DESIGN');
/*!40000 ALTER TABLE `engineers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machine_operators`
--

DROP TABLE IF EXISTS `machine_operators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machine_operators` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CONSTRUCTION_EMPLOYEES_ID` int(10) unsigned NOT NULL,
  `KIND_OF_MACHINE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_MACHINE_OPERATORS_CONSTRUCTION_EMPLOYEES1_idx` (`CONSTRUCTION_EMPLOYEES_ID`),
  CONSTRAINT `fk_MACHINE_OPERATORS_CONSTRUCTION_EMPLOYEES1` FOREIGN KEY (`CONSTRUCTION_EMPLOYEES_ID`) REFERENCES `construction_employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machine_operators`
--

LOCK TABLES `machine_operators` WRITE;
/*!40000 ALTER TABLE `machine_operators` DISABLE KEYS */;
INSERT INTO `machine_operators` VALUES (1,6,'PILLAR CRANE'),(2,7,'BULLDOZER'),(3,8,'EXCAVATOR'),(4,9,'PILLAR CRANE'),(5,10,'BULLDOZER');
/*!40000 ALTER TABLE `machine_operators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `management`
--

DROP TABLE IF EXISTS `management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `management` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ADMINISTRATION_EMPLOYEES_ID` int(10) unsigned NOT NULL,
  `WORK_AUTO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_MANAGEMENT_ADMINISTRATION_EMPLOYEES1_idx` (`ADMINISTRATION_EMPLOYEES_ID`),
  CONSTRAINT `fk_MANAGEMENT_ADMINISTRATION_EMPLOYEES1` FOREIGN KEY (`ADMINISTRATION_EMPLOYEES_ID`) REFERENCES `administration_employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `management`
--

LOCK TABLES `management` WRITE;
/*!40000 ALTER TABLE `management` DISABLE KEYS */;
INSERT INTO `management` VALUES (1,1,'PORSHE 1111 AV-7'),(2,2,'BMW 2222 AB-7'),(3,3,'AUDI 3333 AB-7'),(4,4,'SUZUKI 4444 AB-7'),(5,5,'LADA 5555 AB-7');
/*!40000 ALTER TABLE `management` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers_project`
--

DROP TABLE IF EXISTS `managers_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managers_project` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PROJECT_EMPLOYEES_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_MANAGERS_PROJECT_PROJECT_EMPLOYEES1_idx` (`PROJECT_EMPLOYEES_ID`),
  CONSTRAINT `fk_MANAGERS_PROJECT_PROJECT_EMPLOYEES1` FOREIGN KEY (`PROJECT_EMPLOYEES_ID`) REFERENCES `project_employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers_project`
--

LOCK TABLES `managers_project` WRITE;
/*!40000 ALTER TABLE `managers_project` DISABLE KEYS */;
INSERT INTO `managers_project` VALUES (1,6),(2,7),(3,8),(4,9),(5,10);
/*!40000 ALTER TABLE `managers_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_employees`
--

DROP TABLE IF EXISTS `project_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_employees` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EMPLOYEES_ID` int(10) unsigned NOT NULL,
  `OFFICE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_PROJECT_EMPLOYEES_EMPLOYEES1_idx` (`EMPLOYEES_ID`),
  CONSTRAINT `fk_PROJECT_EMPLOYEES_EMPLOYEES1` FOREIGN KEY (`EMPLOYEES_ID`) REFERENCES `employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_employees`
--

LOCK TABLES `project_employees` WRITE;
/*!40000 ALTER TABLE `project_employees` DISABLE KEYS */;
INSERT INTO `project_employees` VALUES (1,21,'101'),(2,22,'215'),(3,23,'303'),(4,24,'125'),(5,25,'113'),(6,26,'256'),(7,27,'245'),(8,28,'206'),(9,29,'309'),(10,30,'305');
/*!40000 ALTER TABLE `project_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'MINSK_REGION'),(2,'VITEBSK_REGION'),(3,'GOMEL_REGION'),(4,'GRODNO_REGION'),(5,'MOGILEV_REGION'),(6,'BREST_REGION');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `JUNUARY` int(11) NOT NULL,
  `FEBRUARY` int(11) NOT NULL,
  `MARCH` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,300,400,500),(2,1200,900,800),(3,800,500,700),(4,900,500,1200),(5,1500,1400,1200);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-22 15:05:06
