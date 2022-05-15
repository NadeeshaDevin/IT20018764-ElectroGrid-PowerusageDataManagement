-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: electrogrid
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pwrusagedata`
--

DROP TABLE IF EXISTS `pwrusagedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pwrusagedata` (
  `recordID` int NOT NULL AUTO_INCREMENT,
  `pwrusagedataID` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `useraddress` varchar(45) DEFAULT NULL,
  `noofpwrunits` varchar(45) DEFAULT NULL,
  `unitprice` varchar(45) DEFAULT NULL,
  `totalprice` varchar(45) DEFAULT NULL,
  `payedmonth` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`recordID`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pwrusagedata`
--

LOCK TABLES `pwrusagedata` WRITE;
/*!40000 ALTER TABLE `pwrusagedata` DISABLE KEYS */;
INSERT INTO `pwrusagedata` VALUES (30,'PWR01','NadeeshanDevinda','gff','2000','222','22','january'),(37,'PWR001','NadeeshanDevinda','132/1,Polhena, Madapatha.','22','10','200','jan'),(44,'PWR001','NadeeshanDevinda','132/1,Polhena, Madapatha.','22','10','200','january'),(45,'PWR004','NadeeshanDevinda','132/1,Polhena, Madapatha.','22','20','222','january'),(46,'PWR001','NadeeshanDevinda','132/1,Polhena, Madapatha.','20','10','200','january 2021'),(49,'PWR008','NadeeshanDevinda','132/1,Polhena, Madapatha.','20','10','200','january 2021'),(50,'PWR01','NadeeshanDevinda','klmp','2000','222','22','january'),(51,'PWR008','NadeeshanDevinda','132/1,Polhena, Madapatha.','20','222','200','january'),(52,'PWR008','NadeeshanDevinda','132/1,Polhena, Madapatha.','20','222','200','january 2021'),(53,'PWR200','NadeeshanDevinda','dddd','20','222','200','january'),(54,'PWR018','dilanka','piliyandala','200','10','2000','january'),(55,'PWR01','NadeeshanDevinda','gff','2000','222','22','january2'),(56,'PWR01','NadeeshanDevinda','gff','2000','222','22','january'),(57,'PWR01','NadeeshanDevinda','gff','2000','222','22','january 2000');
/*!40000 ALTER TABLE `pwrusagedata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 21:30:36
