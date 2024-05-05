-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: food_order
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `detail_tea`
--

DROP TABLE IF EXISTS `detail_tea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_tea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_tea` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `id_size` int DEFAULT NULL,
  `temp_total_price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_size` (`id_size`),
  CONSTRAINT `detail_tea_ibfk_1` FOREIGN KEY (`id_size`) REFERENCES `size` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_tea`
--

LOCK TABLES `detail_tea` WRITE;
/*!40000 ALTER TABLE `detail_tea` DISABLE KEYS */;
INSERT INTO `detail_tea` VALUES (1,1,'Tra mang cau xiem','desc 1',38000,1,38000),(18,1,'Tra mang cau xiem','desc 1',38000,2,69000),(19,1,'Tra mang cau xiem','desc 1',38000,2,50000),(20,1,'Tra mang cau xiem','desc 1',38000,2,69000),(21,1,'Tra mang cau xiem','desc 1',38000,2,70000),(22,1,'Tra mang cau xiem','desc 1',38000,2,69000),(23,4,'Tra nho den','desc 4',38000,2,78000),(24,1,'Tra mang cau xiem','desc 1',38000,2,61000),(25,2,'Tra mang cau dau','desc 2',38000,1,59000),(26,4,'Tra nho den','desc 4',38000,1,56000),(27,4,'Tra nho den','desc 4',38000,NULL,46000),(28,4,'Tra nho den','desc 4',38000,NULL,46000),(29,4,'Tra nho den','desc 4',38000,NULL,38000);
/*!40000 ALTER TABLE `detail_tea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-05 17:52:45
