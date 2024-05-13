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


-- Volcando estructura de base de datos para cientificos
CREATE DATABASE IF NOT EXISTS `cientificos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `cientificos`;

-- Volcando estructura para tabla cientificos.asignado_a
CREATE TABLE IF NOT EXISTS `asignado_a` (
  `cientifico` varchar(8) NOT NULL,
  `proyecto` char(4) NOT NULL,
  PRIMARY KEY (`cientifico`,`proyecto`),
  KEY `fk_proyecto_asignado` (`proyecto`),
  CONSTRAINT `fk_cientifico_asignado` FOREIGN KEY (`cientifico`) REFERENCES `cientificos` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proyecto_asignado` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla cientificos.asignado_a: ~10 rows (aproximadamente)
INSERT INTO `asignado_a` (`cientifico`, `proyecto`) VALUES
	('0672523P', 'P005'),
	('0827137K', 'P003'),
	('3287390R', 'P002'),
	('3374683Z', 'P009'),
	('5478699Y', 'P007'),
	('7305597S', 'P010'),
	('7357072Y', 'P008'),
	('7845859G', 'P004'),
	('7869261K', 'P001'),
	('9861511N', 'P006');

-- Volcando estructura para tabla cientificos.cientificos
CREATE TABLE IF NOT EXISTS `cientificos` (
  `dni` varchar(8) NOT NULL,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla cientificos.cientificos: ~10 rows (aproximadamente)
INSERT INTO `cientificos` (`dni`, `nom_apels`) VALUES
	('0672523P', 'francisco'),
	('0827137K', 'pedro'),
	('3287390R', 'maria'),
	('3374683Z', 'javier'),
	('5478699Y', 'carlos'),
	('7305597S', 'montse'),
	('7357072Y', 'rosa'),
	('7845859G', 'cristina'),
	('7869261K', 'juan'),
	('9861511N', 'ana');

-- Volcando estructura para tabla cientificos.proyecto
CREATE TABLE IF NOT EXISTS `proyecto` (
  `id` char(4) NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla cientificos.proyecto: ~10 rows (aproximadamente)
INSERT INTO `proyecto` (`id`, `nombre`, `horas`) VALUES
	('P001', 'p1', 10),
	('P002', 'p2', 20),
	('P003', 'p3', 30),
	('P004', 'p4', 40),
	('P005', 'p5', 50),
	('P006', 'p6', 60),
	('P007', 'p7', 70),
	('P008', 'p8', 80),
	('P009', 'p9', 90),
	('P010', 'p10', 100);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
