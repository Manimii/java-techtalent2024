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


-- Volcando estructura de base de datos para directores_despachos
CREATE DATABASE IF NOT EXISTS `directores_despachos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `directores_despachos`;

-- Volcando estructura para tabla directores_despachos.despachos
CREATE TABLE IF NOT EXISTS `despachos` (
  `numero` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla directores_despachos.despachos: ~10 rows (aproximadamente)
INSERT INTO `despachos` (`numero`, `capacidad`) VALUES
	(1, 10),
	(2, 20),
	(3, 30),
	(4, 40),
	(5, 50),
	(6, 60),
	(7, 70),
	(8, 80),
	(9, 90),
	(10, 100);

-- Volcando estructura para tabla directores_despachos.directores
CREATE TABLE IF NOT EXISTS `directores` (
  `dni` varchar(8) NOT NULL,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dni_jefe` varchar(8) DEFAULT NULL,
  `despacho` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_despachos_directores` (`despacho`),
  KEY `fk_directores_directores` (`dni_jefe`),
  CONSTRAINT `fk_despachos_directores` FOREIGN KEY (`despacho`) REFERENCES `despachos` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_directores_directores` FOREIGN KEY (`dni_jefe`) REFERENCES `directores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla directores_despachos.directores: ~10 rows (aproximadamente)
INSERT INTO `directores` (`dni`, `nom_apels`, `dni_jefe`, `despacho`) VALUES
	('0672523P', 'francisco', NULL, 9),
	('0827137K', 'pedro', NULL, 2),
	('3287390R', 'maria', NULL, 1),
	('3374683Z', 'javier', NULL, 6),
	('5478699Y', 'carlos', NULL, 4),
	('7305597S', 'montse', NULL, 5),
	('7357072Y', 'rosa', '5478699Y', 4),
	('7845859G', 'cristina', '7869261K', 3),
	('7869261K', 'juan', NULL, 3),
	('9861511N', 'ana', '0672523P', 9);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
