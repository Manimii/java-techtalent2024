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


-- Volcando estructura de base de datos para piezas_proveedores
CREATE DATABASE IF NOT EXISTS `piezas_proveedores` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `piezas_proveedores`;

-- Volcando estructura para tabla piezas_proveedores.piezas
CREATE TABLE IF NOT EXISTS `piezas` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla piezas_proveedores.piezas: ~10 rows (aproximadamente)
INSERT INTO `piezas` (`codigo`, `nombre`) VALUES
	(1, 'pieza1'),
	(2, 'pieza2'),
	(3, 'pieza3'),
	(4, 'pieza4'),
	(5, 'pieza5'),
	(6, 'pieza6'),
	(7, 'pieza7'),
	(8, 'pieza8'),
	(9, 'pieza9'),
	(10, 'pieza10');

-- Volcando estructura para tabla piezas_proveedores.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `id` char(4) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla piezas_proveedores.proveedores: ~10 rows (aproximadamente)
INSERT INTO `proveedores` (`id`, `nombre`) VALUES
	('AA01', 'prov1'),
	('AA02', 'prov2'),
	('AA03', 'prov3'),
	('AA04', 'prov4'),
	('AA05', 'prov5'),
	('AA06', 'prov6'),
	('AA07', 'prov7'),
	('AA08', 'prov8'),
	('AA09', 'prov9'),
	('AA10', 'prov10');

-- Volcando estructura para tabla piezas_proveedores.suministra
CREATE TABLE IF NOT EXISTS `suministra` (
  `codigo_pieza` int(11) NOT NULL,
  `id_proveedor` char(4) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_pieza`,`id_proveedor`),
  KEY `fk_proveedores_suministra` (`id_proveedor`),
  CONSTRAINT `fk_piezas_suministra` FOREIGN KEY (`codigo_pieza`) REFERENCES `piezas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proveedores_suministra` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla piezas_proveedores.suministra: ~10 rows (aproximadamente)
INSERT INTO `suministra` (`codigo_pieza`, `id_proveedor`, `precio`) VALUES
	(1, 'AA01', 10),
	(2, 'AA02', 20),
	(3, 'AA03', 30),
	(4, 'AA04', 40),
	(5, 'AA05', 50),
	(6, 'AA06', 60),
	(7, 'AA07', 70),
	(8, 'AA08', 80),
	(9, 'AA09', 90),
	(10, 'AA10', 100);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
