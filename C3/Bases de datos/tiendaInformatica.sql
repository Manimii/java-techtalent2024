-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tienda_informatica
CREATE DATABASE IF NOT EXISTS `tienda_informatica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `tienda_informatica`;

-- Volcando estructura para tabla tienda_informatica.articulos
CREATE TABLE IF NOT EXISTS `articulos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `fabricante` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_articulos_fabricantes` (`fabricante`),
  CONSTRAINT `FK_articulos_fabricantes` FOREIGN KEY (`fabricante`) REFERENCES `fabricantes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla tienda_informatica.articulos: ~10 rows (aproximadamente)
INSERT INTO `articulos` (`codigo`, `nombre`, `precio`, `fabricante`) VALUES
	(1, 'a1', 9, 1),
	(2, 'a2', 18, 2),
	(3, 'a3', 27, 3),
	(4, 'a4', 36, 4),
	(5, 'a5', 45, 5),
	(6, 'a6', 54, 6),
	(7, 'a7', 63, 7),
	(8, 'Impresora Laser', 72, 8),
	(9, 'a9', 81, 9),
	(10, 'a10', 90, 10),
	(11, 'a11', 170, 3),
	(12, 'Altavoz', 63, 2);

-- Volcando estructura para tabla tienda_informatica.fabricantes
CREATE TABLE IF NOT EXISTS `fabricantes` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla tienda_informatica.fabricantes: ~10 rows (aproximadamente)
INSERT INTO `fabricantes` (`codigo`, `nombre`) VALUES
	(1, 'f1'),
	(2, 'f2'),
	(3, 'f3'),
	(4, 'f4'),
	(5, 'f5'),
	(6, 'f6'),
	(7, 'f7'),
	(8, 'f8'),
	(9, 'f9'),
	(10, 'f10');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
