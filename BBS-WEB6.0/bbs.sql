-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bbs
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_`
--

DROP TABLE IF EXISTS `order_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `onum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_`
--

LOCK TABLES `order_` WRITE;
/*!40000 ALTER TABLE `order_` DISABLE KEYS */;
INSERT INTO `order_` VALUES (3,3),(5,4),(6,6),(7,10),(8,1),(9,3),(10,1),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,9),(26,10),(27,3),(28,3),(29,5),(31,7),(32,1),(33,3),(34,10),(35,3);
/*!40000 ALTER TABLE `order_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oup`
--

DROP TABLE IF EXISTS `oup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `oup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `O-U_idx` (`uid`),
  KEY `O-P_idx` (`pid`),
  KEY `O-O_idx` (`oid`),
  CONSTRAINT `O-O` FOREIGN KEY (`oid`) REFERENCES `order_` (`id`),
  CONSTRAINT `O-P` FOREIGN KEY (`pid`) REFERENCES `product` (`id`),
  CONSTRAINT `O-U` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oup`
--

LOCK TABLES `oup` WRITE;
/*!40000 ALTER TABLE `oup` DISABLE KEYS */;
INSERT INTO `oup` VALUES (3,10,2,3),(5,10,1,5),(6,11,2,6),(8,10,3,7),(12,10,3,11),(13,10,3,12),(14,10,3,13),(15,10,3,14),(16,10,3,15),(17,10,3,10),(18,10,3,16),(19,10,3,8),(20,10,3,9),(21,24,1,17),(22,24,1,18),(23,24,1,19),(24,24,1,20),(25,24,1,21),(26,44,1,22),(27,24,1,23),(28,24,1,24),(29,24,1,25),(30,24,1,26),(31,24,1,27),(32,24,1,28),(33,24,1,29),(35,24,1,31),(36,24,3,32),(37,24,2,33),(38,24,12,34),(39,24,1,35);
/*!40000 ALTER TABLE `oup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `num` int(11) NOT NULL,
  `price` double NOT NULL,
  `img` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'杯子',45,21.9,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/2765086155/TB2e8KCvFOWBuNjy0FiXXXFxVXa_!!2765086155-0-item_pic.jpg_230x230.jpg_.webp'),(2,'被子',13,49,'https://g-search1.alicdn.com/img/bao/uploaded/i4/i2/2097385502/O1CN01ofzG1N1qVxgmQkyF3_!!0-item_pic.jpg_230x230.jpg_.webp'),(3,'辣条',7,17.9,'https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/2200070681/O1CN013DCfsf1GtwG61Og8T_!!0-item_pic.jpg_230x230.jpg_.webp'),(5,'维他奶',80,54.8,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/3261296144/O1CN01cKCjd91vFzxuFTZZh_!!0-item_pic.jpg_230x230.jpg_.webp'),(6,'维他柠檬茶',88,53.5,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/3261296144/O1CN01sx1hAM1vFzxuFP4sR_!!0-item_pic.jpg_230x230.jpg_.webp'),(7,'德芙',70,23.6,'https://g-search1.alicdn.com/img/bao/uploaded/i4/i2/2037968561/O1CN01rlnHPD2D6zFKoYNjH_!!0-item_pic.jpg_230x230.jpg_.webp'),(8,'维生素C片',68,19.8,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/692420117/O1CN01kLqo5m1CdDKff7cnN_!!103-0-lubanu.jpg_230x230.jpg_.webp'),(9,'维生素D片',98,43.9,'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/110661269/O1CN011WYSkH1LFF5IbQMuZ_!!0-saturn_solar.jpg_230x230.jpg_.webp'),(10,'牙刷',799,169,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/1714128138/O1CN01c67zo229zFikl7IVp_!!0-item_pic.jpg_230x230.jpg_.webp'),(11,'扫把',666,24,'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i4/49685223/O1CN01z8ecR81oSB9qvI0NT_!!0-saturn_solar.jpg_230x230.jpg_.webp'),(12,'键盘',1102,399,'https://g-search1.alicdn.com/img/bao/uploaded/i4/i2/133668489/O1CN01DQEQC32Ca0jzWMcno_!!0-item_pic.jpg_230x230.jpg_.webp'),(13,'鼠标',1234,89,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/2863054326/O1CN010oAH1O1hpLurki04y_!!0-item_pic.jpg_230x230.jpg_.webp'),(15,'蒙牛纯牛奶',23,29.9,'https://g-search2.alicdn.com/img/bao/uploaded/i4/i4/725677994/O1CN01E6pzOP28vIge6t01u_!!0-item_pic.jpg_230x230.jpg_.webp'),(17,'德芙红色款',877,91.8,'https://g-search2.alicdn.com/img/bao/uploaded/i4/i3/877104952/O1CN011NEmWt1mS3r53r5u2_!!0-item_pic.jpg_230x230.jpg_.webp');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'admin','$2a$10$A.8V2Wxgrvwh5ZrdhEzCRueCNrFlPrnXUbY0LYmdZ4Cj9RQ66D3j.',NULL,NULL),(11,'陈泽源','$2a$10$nbYuTXSZtzxV4mLzgZMeJeI9AvRZ8KiiJ4naxctCgQBZSr99tCpWm',NULL,NULL),(24,'gws','$2a$10$CaIObfZicc28LQTLJ05Ozu6JbtQErFKTMH5U9t6zWzSeG2lPFmh0u','高文森','男'),(28,'7','$2a$10$nVUqUnYJj4Y3bciApoalGugU3Ck6LWz4YGxN/fcFmygaJ/mmZWv7u',NULL,NULL),(29,'温武銮','$2a$10$VlA2nhjZPWeFIiIf9d4blulBzgAFOc8Tpm46R3A/IveI6ZXyh3JdC',NULL,NULL),(30,'a','$2a$10$xdBODA2xjOuBMzq3a3wjpumyj.Y4TiYYd/61ri25KH7/NABcuhQ6S',NULL,NULL),(31,'user','$2a$10$a9IKTO/A6L4nJHI3A/xH0Oi0PJ2Qk9byXFh7Vc/lGOnupNfDunLwK',NULL,NULL),(32,'1065721365','$2a$10$ZXxhQrK0QGQ.3qZUW.b8r.phz2cyx2lLrAaM/sFZu9nsBKmFzEtI6',NULL,NULL),(33,'15338256683','$2a$10$Re1F.dI2liUlAgt0YiHWaO/tVC5kxopkwxHojWnYV591NICkVDrDW',NULL,NULL),(34,'aaa','$2a$10$FDPw9hEXF3wDItjHEdxyoOWq7wQ755J0Allyf2JjMoQnP9tEp9ewW',NULL,NULL),(35,'123','$2a$10$Hl.8RNUVNunYrF9HrcX1R.R0yMjfXHVUUir8eU1nISr/GRpcCbQLa',NULL,NULL),(36,'11','$2a$10$oLL8hcdXtMuuEkXQ3BKjQuDZMC9oQWazx0bIvhEjQf8MTb48G8yfC',NULL,NULL),(37,'111','$2a$10$NC2HKVLBqqXauQdM2M1ro.jmknovHJ2FwhnDpmKVvQ21WZ3aFbF1m',NULL,NULL),(38,'1234','$2a$10$XHCLih.Q4z0ToE9y/qYZ6.SrCYGTSVTZdn0PWiJK3xRFfmrUvjDfu',NULL,NULL),(39,'11111','$2a$10$1pF0VwdLEitVfMcHx5P1FuNKzCz8GhAzqOdEDCvxnc5yIy1gHcWkC',NULL,NULL),(40,'z','$2a$10$8BZPkENOZ7EzYhDWxafmWObryOr7j3yBatrep5zwN/AlIr8/UR.76',NULL,NULL),(41,'10','$2a$10$Dw5zZ7Wdv1ClYoG2/zv/tug2H6s.2P3e0OtSQha1AtmW4I93RoT2.',NULL,NULL),(42,'c','$2a$10$9WwOsY.EOcI9H.0JHXBdeOALHp3RuarVyGhbhB673UrwIQ26ZcbRS',NULL,NULL),(43,'h','$2a$10$kN2Hilb8uj1YtMQlIJDrReQCLUL7sFarb0IPj3gf9J3k9JCG2leEm',NULL,NULL),(44,'hua','$2a$10$4WgayrrB88R8dPWxyPIoAeflHq4VX8w4kdpVZvwJs.yeVgyCnZyqi','huaqifan','male'),(45,'jj','$2a$10$6ES9O5ZU2KcS6n94DWAjT.QT.ZnB6Zh/lt9.CocNgFqNfT1rHWhJe','jjj','男'),(48,'李建辉','$2a$10$y3Tu1muaRwqrv3FEqn9uzu430aD/Ivupb6OPnW7K2y8vnJI8zwtyq',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userauthority`
--

DROP TABLE IF EXISTS `userauthority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userauthority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `authorityid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid_idx` (`userid`),
  KEY `aid_idx` (`authorityid`),
  CONSTRAINT `aid` FOREIGN KEY (`authorityid`) REFERENCES `authority` (`id`),
  CONSTRAINT `uid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userauthority`
--

LOCK TABLES `userauthority` WRITE;
/*!40000 ALTER TABLE `userauthority` DISABLE KEYS */;
INSERT INTO `userauthority` VALUES (19,24,1),(26,11,2),(29,29,1),(30,30,1),(31,31,2),(32,32,2),(33,33,2),(34,34,1),(35,35,1),(36,36,1),(38,38,1),(39,39,1),(40,40,1),(41,37,1),(42,41,1),(43,42,1),(44,43,1),(46,28,1),(49,44,2),(50,45,2),(54,24,1),(55,24,1),(56,10,1),(57,48,1),(58,24,1),(59,24,1);
/*!40000 ALTER TABLE `userauthority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bbs'
--

--
-- Dumping routines for database 'bbs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-29 20:32:56
