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


-- Volcando estructura de base de datos para investigadores
CREATE DATABASE IF NOT EXISTS `investigadores` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `investigadores`;

-- Volcando estructura para tabla investigadores.equipos
CREATE TABLE IF NOT EXISTS `equipos` (
  `num_serie` char(4) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `facultad` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_serie`),
  KEY `fk_facultad_equipos` (`facultad`),
  CONSTRAINT `fk_facultad_equipos` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla investigadores.equipos: ~10 rows (aproximadamente)
INSERT INTO `equipos` (`num_serie`, `nombre`, `facultad`) VALUES
	('E001', 'e1', 1),
	('E002', 'e2', 2),
	('E003', 'e3', 3),
	('E004', 'e4', 4),
	('E005', 'e5', 5),
	('E006', 'e6', 6),
	('E007', 'e7', 7),
	('E008', 'e8', 8),
	('E009', 'e9', 9),
	('E010', 'e10', 10);

-- Volcando estructura para tabla investigadores.facultad
CREATE TABLE IF NOT EXISTS `facultad` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla investigadores.facultad: ~10 rows (aproximadamente)
INSERT INTO `facultad` (`codigo`, `nombre`) VALUES
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

-- Volcando estructura para tabla investigadores.investigadores
CREATE TABLE IF NOT EXISTS `investigadores` (
  `dni` varchar(8) NOT NULL,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `facultad` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_facultad_investigadores` (`facultad`),
  CONSTRAINT `fk_facultad_investigadores` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla investigadores.investigadores: ~10 rows (aproximadamente)
INSERT INTO `investigadores` (`dni`, `nom_apels`, `facultad`) VALUES
	('0672523P', 'francisco', 5),
	('0827137K', 'pedro', 3),
	('3287390R', 'maria', 2),
	('3374683Z', 'javier', 9),
	('5478699Y', 'carlos', 7),
	('7305597S', 'montse', 10),
	('7357072Y', 'rosa', 8),
	('7845859G', 'cristina', 4),
	('7869261K', 'juan', 1),
	('9861511N', 'ana', 6);

-- Volcando estructura para tabla investigadores.reserva
CREATE TABLE IF NOT EXISTS `reserva` (
  `dni` varchar(8) NOT NULL,
  `num_serie` char(4) NOT NULL,
  `comienzo` datetime DEFAULT NULL,
  `fin` datetime DEFAULT NULL,
  PRIMARY KEY (`dni`,`num_serie`),
  KEY `fk_equipos_reserva` (`num_serie`),
  CONSTRAINT `fk_equipos_reserva` FOREIGN KEY (`num_serie`) REFERENCES `equipos` (`num_serie`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_investigadores_reserva` FOREIGN KEY (`dni`) REFERENCES `investigadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla investigadores.reserva: ~10 rows (aproximadamente)
INSERT INTO `reserva` (`dni`, `num_serie`, `comienzo`, `fin`) VALUES
	('0672523P', 'E005', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('0827137K', 'E003', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('3287390R', 'E002', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('3374683Z', 'E009', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('5478699Y', 'E007', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('7305597S', 'E010', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('7357072Y', 'E008', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('7845859G', 'E004', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('7869261K', 'E001', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),
	('9861511N', 'E006', '2024-04-16 00:00:00', '2024-04-26 00:00:00');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
