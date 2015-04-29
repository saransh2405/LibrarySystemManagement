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
-- Table structure for table `Book_Authors`
--

DROP TABLE IF EXISTS `Book_Authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book_Authors` (
  `Book_id` varchar(15) NOT NULL,
  `Author_name` char(60) NOT NULL,
  `Type` char(5) NOT NULL,
  PRIMARY KEY (`Book_id`,`Author_name`),
  CONSTRAINT `book_authors_ibfk_1` FOREIGN KEY (`Book_id`) REFERENCES `Book` (`Book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book_Authors`
--

LOCK TABLES `Book_Authors` WRITE;
/*!40000 ALTER TABLE `Book_Authors` DISABLE KEYS */;
INSERT INTO `Book_Authors` VALUES ('0030059380','Douglas A. Skooq','1'),('0030303370','William Rife','1'),('0030615372','Colin M. Turnbull','1'),('0060287659','Geraldine McCaughrean','1'),('0060393645','Lorin Henner','1'),('0060393645','Marilu Henner','1'),('0060930497','Kenneth R. Miller','1'),('0060959290','Colin Thubron','1'),('0070121430','Charles E. Leiserson','1'),('0070121430','Ronald L. Rivest','1'),('0070121430','Thomas H. Cormen','1'),('0070349096','Henry Z. Kister','1'),('0070498415','Robert H. Perry','1'),('0070571864','Gershon J. Shugar','1'),('0071354190','Peter Lane Taylor','1'),('0072127317','Blake Schwendiman','1'),('0072127481','Joel Scambray','1'),('0078823927','Herb Schildt','1'),('0078823978','Thomas Powell','1'),('0120594757','Neal G. Anderson','1'),('0120848104','Les Beletsky','1'),('0125535600','G. M. Phillips','1'),('0125535600','P.J. Taylor','1'),('0130264857','Jan Fair','1'),('0130264857','Sadie Bragg','1'),('0130273635','Bruce Eckel','1'),('0130819735','Jame Laudon','1'),('0134897250','Alan H. Dutoit','1'),('0134897250','Bernd Bruegge','1'),('0136603904','Kip R. Irvine','1'),('0137566107','Peter Abel','1'),('0138613370','Jeffrey D. Ullman','1'),('014051452X','Richard Cook','1'),('0151004714','Claire Messud','1'),('0156007088','John Lewis','1'),('0156007754','Giovanni Pontiero','1'),('0156007754','Jose Saramago','1'),('0192860925','Richard Dawkins','1'),('0195148665','Andy Clark','1'),('0198503652','Susan J. Blackmore','1'),('0199291144','Richard Dawkins','1'),('0201379260','Nicolai M. Josuttis','1'),('0201612585','Rajshekhar Sunderraman','1'),('0201615622','Herb Sutter','1'),('0201615711','Lincoln D. Stein','1'),('020163371X','Scott Meyers','1'),('0201634422','S. Keshav','1'),('020165783X','Kendall Scott','1'),('020165783X','Martin Fowler','1'),('0201700735','Bjarne Stroustrup','1'),('0201709287','C. J. Date','1'),('0201709287','Hugh Darwen','1'),('0256228779','Gilbert Churchill','1'),('0256228779','Paul Petter','1'),('0262041642','Marco Colombetti','1'),('0262041642','Marco Dorigo','1'),('0262133822','Faith D. Aluisio','1'),('0262181916','Santiago Ramon y Cajal','1'),('0312135033','Carolly Erickson','1'),('0312965095','Kathleen Kane','1'),('0314129499','Welch Gruhlt','1'),('0316154075','Michael Connelly','1'),('0316695262','George P. Pelecanos','1'),('0316769487','J.D. Salinger','1'),('0345298063','Robert K. Massie','1'),('0345313860','Anne Rice','1'),('0345337662','Anne Rice','1'),('0345350499','Marion Zimmer Bradley','1'),('0345370775','Michael Crichton','1'),('0345377648','Anne Rice','1'),('0345384466','Anne Rice','1'),('034538475X','Anne Rice','1'),('0345417623','Michael Crichton','1'),('0345419758','Mass Market','1'),('0345438310','Robert K. Massie','1'),('0374141231','Colin Tudge','1'),('0374141231','Ian Wilmut','1'),('0374141231','Keith Campbell','1'),('0375400818','Robert Kimball','1'),('037541164X','Gurcharan Das','1'),('0375502025','Tom Brokaw','1'),('0375810609','Jean De Brunhoff','1'),('038071115X','Tracy Kidder','1'),('0385326653','David Almond','1'),('0385479565','Richard Preston','1'),('0387987010','Peter Douglas Ward','1'),('0393314251','Stephen Jay Gould','1'),('0393316009','Andrea Barrett','1'),('0395851580','James Marshall','1'),('039914563X','Tom Clancy','1'),('0399146652','Lilian Jackson Braun','1'),('0399147020','Nevada Barr','1'),('0399501487','William Gerald Golding','1'),('042510107X','Tom Clancy','1'),('0425133540','Tom Clancy','1'),('0425143325','Tom Clancy','1'),('0425147584','Tom Clancy','1'),('0439064864','J. K. Rowling','1'),('0439136350','J. K. Rowling','1'),('0439139597','J. K. Rowling','1'),('0440413729','Ruth White','1'),('0446310783','Harper Lee','1'),('0449202496','Erich Maria Remarque','1'),('0449911942','John Updike','1'),('0452272971','Linda Coverdale','1'),('0452272971','Sebastien Japrisot','1'),('0465041752','Frans de Waal','1'),('0471105597','David Halliday','1'),('0471105597','Jearl Walker','1'),('0471105597','Robert Resnick','1'),('0471135615','Robert Zubrin','1'),('0471169196','Kimmel Weygandt','1'),('0471534781','Richard M. Felder','1'),('0471587192','Einar Hille','1'),('0471587192','Garret J. Etgen','1'),('0471587192','Saturnino L. Salas','1'),('0471597619','Gary D. Christian','1'),('0505523078','Ann Lawrence','1'),('0517707950','Laura Esquivel','1'),('0528838180','Ran McNally','1'),('0531164497','Ann O. Squire','1'),('0534368018','Gary J. Bronson','1'),('0534944469','Susanna S. Epp','1'),('0553102370','Michael Crichton','1'),('0553283936','Frederick Forsyth','1'),('0553575538','Kay Hooper','1'),('0553577476','Leslie Lafoy','1'),('0590262540','K. A. Applegate','1'),('0590494368','K. A. Applegate','1'),('0590494414','K. A. Applegate','1'),('0590496379','K. A. Applegate','1'),('0590956159','K. A. Applegate','1'),('0596000278','Jon Orwant','1'),('0596000278','Larry Wall','1'),('0596000278','Tom Christiansen','1'),('0609607995','Edwin Black','1'),('0618056777','Jane Goodall','1'),('062593460X','Greta Podleski','1'),('062593460X','Janet Podleski','1'),('062593460X','Ted Martin','1'),('0669076791','James Wilson','1'),('067100767X','V. C. Andrews','1'),('0671032658','Stephen King','1'),('0671047310','Vince Flynn','1'),('0671880756','Thomas Hoving','1'),('0672314800','Dave Taylor','1'),('0672314800','James C. Armstrong','1'),('0672319241','Andrei Zmievski','1'),('0672319241','Sterling Hughes','1'),('0674003306','Robert Service','1'),('067944551X','Geoffrey C. Ward','1'),('067976674X','Alice Munro','1'),('0684801523','F. Scott Fitzgerald','1'),('0684818701','Maria D. Guarnaschelli','1'),('0684856093','Stephen Covey','1'),('0684869519','Wendy Orange','1'),('0688069711','Gary Selden','1'),('0688127371','James A. Peterson','1'),('0688160999','Janine M. Benyus','1'),('0688161995','Chris Schlesinger','1'),('0688163165','Dennis Lehane','1'),('0689813813','Patricia Mullins','1'),('0689829418','Preiss-Glasser','1'),('0689829531','Ian Falconer','1'),('0689836015','E. L. Konigsburg','1'),('0716736381','Niles Eldredge','1'),('0737800033','John H. Johnson','1'),('0738201960','Christopher Wills','1'),('0738204374','Steven M. Wise','1'),('0743202104','Ethan Becker','1'),('0743202104','Irma S. Rombauer','1'),('0743202104','Marion Becker','1'),('0743215052','John Le Carre','1'),('0750650869','David Howe','1'),('0760049254','Philip Pratt','1'),('0761117199','Ann Byin','1'),('0761117199','Anthony Loew','1'),('076454621X','Kelly L. Murdock','1'),('0764547161','Joyce Park','1'),('0764547161','Tim Converse','1'),('0767903854','Bill Bryson','1'),('0789305003','Los Angeles County Museum of Art','1'),('0789404257','Various','2'),('0792393651','Jonalthan H. Connell','1'),('0792393651','Sridhar Mahadevan (Editor)','1'),('0805057579','Thomas A. Bass','1'),('0805317554','Ramez Elmasri','1'),('0805317554','Shamkant Navathe','1'),('0807825859','Ann Hawthorne','1'),('0809299674','Adrian Wood','1'),('0810936852','Peter H. Hassrick','1'),('0810961695','Edward Steichen','1'),('0811213668','Michael Hulse','1'),('0811213668','W. G. Sebald','1'),('0811716937','Jerry Predika','1'),('0811826848','The Beatles','2'),('0812093119','Martin Sternstein','1'),('0812520610','Brian Lumley','1'),('0812520629','Brian Lumley','1'),('0813527406','Iris Fry','1'),('0821762559','Quinn Taylor Evans','1'),('083512035x','Liu Zongen','1'),('0838479022','Elizabeth Byleen','1'),('0849323754','Hooman H. Rashidi','1'),('0850668093','Mansour Rahimi (Editor)','1'),('0850668093','Waldemar Karwowski (Editor)','1'),('0864426429','Kim Grant','1'),('0870212850','Tom Clancy','1'),('0874779758','Robert Zubrin','1'),('0882664778','Charles G. Reavis','1'),('0887251714','Jim Cottrell','1'),('0910146691','Allen De Hart','1'),('0911625291','Steve Eckols','1'),('0911625453','Doug Lowe','1'),('0911625593','Steve Eckols','1'),('0911625607','Doug Lowe','1'),('0911625852','Doug Lowe','1'),('0932813739','David Hatcher Childress','1'),('0935039031','Michael Brown','1'),('0935112510','Greg Clarke','1'),('093570261x','Roger L. Dekock','1'),('0936184388','Carl Tremblay','1'),('0961470151','Mark Levine','1'),('0961549890','Lenore W. Horowitz','1'),('0962477060','Bill Edwards','1'),('0966625307','Toni Polancy','1'),('0967174805','Carl R. Sam','1'),('0967174805','Jean Stoick','1'),('0967697603','Mercedes Lee','1'),('1552047210','James Herriot','1'),('1557044287','Ridley Scott','1'),('1565922840','Larry Wall','1'),('1565922840','Randal Schwartz','1'),('1565922840','Tom Christiansen','1'),('1565926099','David Blank-Edelman','1'),('1565926269','Steven Roman','1'),('1565927699','Rasmus Lerdorf','1'),('1566912296','Rick Steves','1'),('1573225312','Chang-Rae Lee','1'),('1576572862','Nancy Parent','1'),('1576573842','Nancy Parent','1'),('1581950098','Kurt Johnson','1'),('1581950098','Steven L. Coates','1'),('1584500492','DeLoura','1'),('1584500492','Mark','1'),('1586480103','Andy Rooney','1'),('1586480103','Tom Brokaw','1'),('1861003730','Allan Kent','1'),('1861003730','Chris Lea','1'),('1861003730','Chris Ullman','1'),('1861003730','Ganesh Prasad','1'),('1861003730','Wankyu Choi','1'),('1864364432','John Ashton','1'),('1878529234','Craig Clunas','1'),('1884133258','Jamsa Klander','1'),('1902618351','Mei Lim (Illustrator)','1'),('1930110006','David Cross','1'),('962593460X','Ryuichi Yoshii','1');
/*!40000 ALTER TABLE `Book_Authors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-03  3:01:33
