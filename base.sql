CREATE DATABASE  IF NOT EXISTS `Asistencia` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `Asistencia`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: Asistencia
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `Administrador`
--

DROP TABLE IF EXISTS `Administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administrador` (
  `codigo` int(11) NOT NULL,
  `nombres` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `correo_UNIQUE` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrador`
--

LOCK TABLES `Administrador` WRITE;
/*!40000 ALTER TABLE `Administrador` DISABLE KEYS */;
INSERT INTO `Administrador` VALUES (1,'JAFET ANDRES','GALVEZ QUEZADA ','jafetandres@hotmail.com','12345'),(2,'KATHERINE PATRICIA','GONZALEZ ARIAS','kattygonzalez7494@gmail.com','12345');
/*!40000 ALTER TABLE `Administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `codigo` int(11) NOT NULL,
  `nombres` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `correorepresentante` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
INSERT INTO `Alumno` VALUES (1,'JAFET ANDRES','GALVEZ QUEZADA','CUMITAEM@HOTMAIL.COM'),(2,'KATHERINE PATRICIA','GONZALEZ ','KAT@HOTMAIL.COM'),(3,'JUAN JOSE','SANANGO RAMON','JUAN@HOTMAIL.COM'),(4,'PEDRO ARTURO','LOJA CUENCA','CUEN@HOTMAIL.COM'),(5,'CAROLINA PATY','MATOVELLE ALOJA','CAROALO@HOTMAIL.COM'),(6,'MATEO DIEGO','RODRIGUEZ ALBA ','ROAL@HOTMAIL.COM'),(7,'DONAL DUCK','DISNEY MARVEL','DISDO@HOTMAIL.COM'),(8,'DONAL ALBERTO','TRUMP MALO','DOTR@HOTMAIL.COM'),(9,'ENMA CUMANDA','QUEZADA BARBAR','BAR@HOTMAIL.COM'),(10,'JONATHAN ALFREDO','UZHCA SIMBANA','JONAUZ@HOTMAIL.COM'),(11,'RICARDO ALFREDO','PERALTA GONZALEZ','jafetandres@hotmail.com'),(12,'DIEGO NICOLAS','CALLE ARGUDO','mortizo@ups.edu.ec'),(13,'ANA BARBIE','PATTYY LALANGUI','kattygonzalez7494@gmail.com');
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AlumnoMateria`
--

DROP TABLE IF EXISTS `AlumnoMateria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AlumnoMateria` (
  `codigo` int(11) NOT NULL,
  `codigoalumno` int(11) NOT NULL,
  `codigomateria` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_ALUMNO_idx` (`codigoalumno`),
  KEY `FK_MATERIA_idx` (`codigomateria`),
  CONSTRAINT `FK_ALUMNO` FOREIGN KEY (`codigoalumno`) REFERENCES `Alumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_MATERIA` FOREIGN KEY (`codigomateria`) REFERENCES `Materia` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AlumnoMateria`
--

LOCK TABLES `AlumnoMateria` WRITE;
/*!40000 ALTER TABLE `AlumnoMateria` DISABLE KEYS */;
INSERT INTO `AlumnoMateria` VALUES (1,11,2),(2,11,3),(3,12,2),(4,13,1),(5,13,2),(6,1,2),(7,3,2),(8,2,2),(9,4,2),(10,5,2),(11,1,3),(12,2,3),(13,3,3),(14,4,3),(15,5,3),(16,6,3),(17,7,3),(18,8,3),(19,9,3);
/*!40000 ALTER TABLE `AlumnoMateria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Asistencia`
--

DROP TABLE IF EXISTS `Asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Asistencia` (
  `codigo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `codigomateria` int(11) NOT NULL,
  `codigodocente` int(11) NOT NULL,
  `codigoalumno` int(11) NOT NULL,
  `estado` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_MATE_idx` (`codigomateria`),
  KEY `FK_DOC_idx` (`codigodocente`),
  KEY `FK_ALUM_idx` (`codigoalumno`),
  CONSTRAINT `FK_ALUM` FOREIGN KEY (`codigoalumno`) REFERENCES `Alumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DOC` FOREIGN KEY (`codigodocente`) REFERENCES `Docente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_MATE` FOREIGN KEY (`codigomateria`) REFERENCES `Materia` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Asistencia`
--

LOCK TABLES `Asistencia` WRITE;
/*!40000 ALTER TABLE `Asistencia` DISABLE KEYS */;
INSERT INTO `Asistencia` VALUES (1,'2019-01-21',2,1,11,'FALTA'),(2,'2019-01-21',2,1,12,'FALTA'),(3,'2019-01-21',2,1,13,'FALTA');
/*!40000 ALTER TABLE `Asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Docente`
--

DROP TABLE IF EXISTS `Docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Docente` (
  `codigo` int(11) NOT NULL,
  `nombres` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `correo_UNIQUE` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Docente`
--

LOCK TABLES `Docente` WRITE;
/*!40000 ALTER TABLE `Docente` DISABLE KEYS */;
INSERT INTO `Docente` VALUES (1,'PEDRO ARMANDO','LOJA CASTILLO','pedroloja@hotmail.com','12345'),(2,'MAURICIO SERGIO','ORTIZ OCHOA','mortizo@ups.edu.ec','12345'),(3,'PAOLA','INGAVELEZ','pao@est.ups.edu.ec','12345');
/*!40000 ALTER TABLE `Docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DocenteMateria`
--

DROP TABLE IF EXISTS `DocenteMateria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DocenteMateria` (
  `codigo` int(11) NOT NULL,
  `codigodocente` int(11) NOT NULL,
  `codigomateria` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_DOCENTE_idx` (`codigodocente`),
  KEY `FK_MATERIA_idx` (`codigomateria`),
  CONSTRAINT `FK_DOCENTE` FOREIGN KEY (`codigodocente`) REFERENCES `Docente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_MAT` FOREIGN KEY (`codigomateria`) REFERENCES `Materia` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DocenteMateria`
--

LOCK TABLES `DocenteMateria` WRITE;
/*!40000 ALTER TABLE `DocenteMateria` DISABLE KEYS */;
INSERT INTO `DocenteMateria` VALUES (1,1,1),(2,1,2),(3,1,4),(5,2,4);
/*!40000 ALTER TABLE `DocenteMateria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Materia`
--

DROP TABLE IF EXISTS `Materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Materia` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `numcreditos` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Materia`
--

LOCK TABLES `Materia` WRITE;
/*!40000 ALTER TABLE `Materia` DISABLE KEYS */;
INSERT INTO `Materia` VALUES (1,'CIENCIAS DE LA COMPUTACION',6),(2,'ESTRUCTURA DE DATOS',6),(3,'INGIENERIA DE SOFTWARE',4),(4,'MATEMATICAS AVANZADAS',2),(5,'SISTEMAS DISTRIBUIDOS',6);
/*!40000 ALTER TABLE `Materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `codigo` int(11) NOT NULL,
  `codigodocente` int(11) DEFAULT NULL,
  `codigoadministrador` int(11) DEFAULT NULL,
  `tipousuario` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_DocUsu_idx` (`codigodocente`),
  KEY `FK_AdmUsu_idx` (`codigoadministrador`),
  CONSTRAINT `FK_AdmiUsu` FOREIGN KEY (`codigoadministrador`) REFERENCES `Administrador` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DocUsu` FOREIGN KEY (`codigodocente`) REFERENCES `Docente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,NULL,1,'Administrador'),(2,NULL,2,'Administrador'),(3,1,NULL,'Docente'),(4,2,NULL,'Docente');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-21 13:49:52
