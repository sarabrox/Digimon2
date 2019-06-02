CREATE DATABASE  IF NOT EXISTS `usuario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `usuario`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: usuario
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
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `partida` (
  `id_partida` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nivel` varchar(45) DEFAULT NULL,
  `salud` int(11) DEFAULT NULL,
  `fuerza` int(11) DEFAULT NULL,
  `defensa` int(11) DEFAULT NULL,
  `hambre` int(11) DEFAULT NULL,
  `energia` int(11) DEFAULT NULL,
  `higiene` int(11) DEFAULT NULL,
  `afinidad` int(11) DEFAULT NULL,
  `entretenimiento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_partida`),
  CONSTRAINT `fk_email` FOREIGN KEY (`id_partida`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id_usuario` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('FDSF','ADFAF','AFAF'),('fafaf','afaf','afafaf'),('sdasf','afafa','afaf'),('sadad','asada','adadad'),('sdfas','asas','asas'),('sdaadsad','asdasdasdsa','asdadadsad'),('vxdgvxg','dhdhd','dfgdgdg'),('grgyey','eyeyey','dgdfgdg'),('fafaf','fafa','afaf'),('bn ghj','fgdfg','sadff'),('nhgjt','gbdfgd',',yhjfgh'),('jgfhdf','khjukhg','ghjghjg'),('nfghjf','mfhf','jnghd'),('miguel','miguel@miguel','123'),('miguel','miguel@miguel.es','123123'),('reika','reika','reika'),('grg','retet','etete'),('sara','sara','sara'),('dsfsf','sdfsf','sfsf'),('sergio','sergio','sergio'),('dfsf','sfsf','sgsg'),('dfdg','sgsg','sgsgsg'),('fsfsf','shshs','sgssg'),('fsdfsgf','shshsh','sghsh'),('wetset','st','5645'),('rewrwrw','werwrwr','rwrwrw'),('werwer','wrwrwr','wrwrwr');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-31 16:50:42
