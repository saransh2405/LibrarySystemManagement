CREATE DATABASE  IF NOT EXISTS `Library` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Library`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: Library
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `Borrower`
--

DROP TABLE IF EXISTS `Borrower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Borrower` (
  `Card_no` int(11) NOT NULL AUTO_INCREMENT,
  `Fname` varchar(15) NOT NULL,
  `Lname` varchar(15) NOT NULL,
  `Address` varchar(60) DEFAULT NULL,
  `Phone` char(20) DEFAULT NULL,
  PRIMARY KEY (`Card_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9042 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Borrower`
--

LOCK TABLES `Borrower` WRITE;
/*!40000 ALTER TABLE `Borrower` DISABLE KEYS */;
INSERT INTO `Borrower` VALUES (9001,'Jared','James','123','Peachtree	Plano	TX'),(9002,'Jon','Jones','111 Allgood	Dallas	TX','(214) 354-6154'),(9003,'Justin','Mark','2342 May	Richardson	TX','(972) 537-6659'),(9004,'Brad','Knight','176 Main St.	Richardson	TX','(972) 440-0422'),(9005,'John','Smith','731 Fondren	Dallas	TX','(214) 328-2218'),(9006,'Evan','Wallis','134 Pelham	Dallas	TX','(214) 789-9683'),(9007,'Josh','Zell','266 McGrady	Plano	TX','(972) 718-7235'),(9008,'Andy','Vile','1967 Jordan	Dallas	TX','(214) 374-5503'),(9009,'Tom','Brand','112 Third St	Dallas	TX','(214) 897-9919'),(9010,'Jenny','Vos','263 Mayberry	Dallas	TX','(214) 611-1968'),(9011,'Chris','Carter','565 Jordan	Dallas	TX','(214) 314-8107'),(9012,'Kim','Grace','6677 Mills Ave	Richardson	TX','(972) 743-9888'),(9013,'Jeff','Chase','145 Bradbury	Dallas	TX','(214) 255-6961'),(9014,'Franklin','Wong','638 Voss	Plano	TX','(972) 321-8228'),(9015,'Alex','Freed','4333 Pillsbury	Dallas	TX','(214) 362-2794'),(9016,'Bonnie','Bays','111 Hollow	Dallas	TX','(214) 453-8639'),(9017,'Alec','Best','233 Solid	Dallas	TX','(972) 940-0022'),(9018,'Sam','Snedden','987 Windy St	Richardson	TX','(972) 684-5034'),(9019,'Joyce','English','5631 Rice	Dallas	TX','(214) 375-5925'),(9020,'John','James','7676 Bloomington	Dallas	TX','(214) 592-4524'),(9021,'John','Smith','2103 E. Brazos	Plano	TX','(972) 482-1856'),(9022,'Nandita','Ball','222 Howard	Dallas	TX','(214) 949-3746'),(9023,'Bob','Bender','8794 Garfield	Richardson	TX','(972) 223-8737'),(9024,'Jill','Jarvis','6234 Lincoln	Dallas	TX','(972) 900-1067'),(9025,'Kate','King','1976 Boone Trace	Dallas	TX','(214) 606-1839'),(9026,'Lyle','Leslie','417 Hancock Ave	Dallas	TX','(972) 211-0844'),(9027,'Billie','King','556 Washington	Plano	TX','(972) 639-4407'),(9028,'Jon','Kramer','1988 Windy Creek	Richardson	TX','(972) 698-9121'),(9029,'Ray','King','213 Delk Road	Dallas	TX','(214) 606-7831'),(9030,'Gerald','Small','122 Ball Street	Dallas	TX','(972) 217-6716'),(9031,'Arnold','Head','233 Spring St	Richardson	TX','(972) 738-0055'),(9032,'Helga','Pataki','101 Holyoke St	Dallas	TX','(214) 380-9260'),(9033,'Naveen','Drew','198 Elm St	Plano	TX','(972) 931-7427'),(9034,'Carl','Reedy','213 Ball St	Dallas	TX','(214) 757-0242'),(9035,'Sammy','Hall','433 Main Street	Dallas	TX','(214) 573-4872'),(9036,'Red','Bacher','196 Elm Street	Dallas	TX','(214) 631-2972'),(9037,'Ramesh','Narayan','971 Fire Oak	Richardson	TX','(972) 414-1503'),(9038,'James','Borg','450 Stone	Richardson	TX','(972) 213-1551'),(9039,'Jennifer','Wallace','291 Berry	Richardson	TX','(972) 486-4159'),(9040,'Ahmad','Jabbar','980 Dallas	Dallas	TX','(214) 934-7146'),(9041,'Alicia','Zelaya','3321 Castle	Dallas	TX','(214) 535-7531');
/*!40000 ALTER TABLE `Borrower` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-05 12:12:31
