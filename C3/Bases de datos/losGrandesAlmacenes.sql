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


-- Volcando estructura de base de datos para grandes_almacenes
CREATE DATABASE IF NOT EXISTS `grandes_almacenes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `grandes_almacenes`;

-- Volcando estructura para tabla grandes_almacenes.cajeros
CREATE TABLE IF NOT EXISTS `cajeros` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla grandes_almacenes.cajeros: ~10 rows (aproximadamente)
INSERT INTO `cajeros` (`codigo`, `nom_apels`) VALUES
	(1, 'c1'),
	(2, 'c2'),
	(3, 'c3'),
	(4, 'c4'),
	(5, 'c5'),
	(6, 'c6'),
	(7, 'c7'),
	(8, 'c8'),
	(9, 'c9'),
	(10, 'c10');

-- Volcando estructura para tabla grandes_almacenes.maquinas_registradoras
CREATE TABLE IF NOT EXISTS `maquinas_registradoras` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `piso` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla grandes_almacenes.maquinas_registradoras: ~10 rows (aproximadamente)
INSERT INTO `maquinas_registradoras` (`codigo`, `piso`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4),
	(5, 5),
	(6, 6),
	(7, 7),
	(8, 8),
	(9, 9),
	(10, 10);

-- Volcando estructura para tabla grandes_almacenes.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla grandes_almacenes.productos: ~10 rows (aproximadamente)
INSERT INTO `productos` (`codigo`, `nombre`, `precio`) VALUES
	(1, 'p1', 10),
	(2, 'p2', 20),
	(3, 'p3', 30),
	(4, 'p4', 40),
	(5, 'p5', 50),
	(6, 'p6', 60),
	(7, 'p7', 70),
	(8, 'p8', 80),
	(9, 'p9', 90),
	(10, 'p10', 100);

-- Volcando estructura para tabla grandes_almacenes.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `cajero` int(11) NOT NULL,
  `maquina` int(11) NOT NULL,
  `producto` int(11) NOT NULL,
  PRIMARY KEY (`cajero`,`maquina`,`producto`),
  KEY `fk_maquina_venta` (`maquina`),
  KEY `fk_producto_venta` (`producto`),
  CONSTRAINT `fk_cajero_venta` FOREIGN KEY (`cajero`) REFERENCES `cajeros` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_maquina_venta` FOREIGN KEY (`maquina`) REFERENCES `maquinas_registradoras` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_venta` FOREIGN KEY (`producto`) REFERENCES `productos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla grandes_almacenes.venta: ~10 rows (aproximadamente)
INSERT INTO `venta` (`cajero`, `maquina`, `producto`) VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5),
	(6, 6, 6),
	(7, 7, 7),
	(8, 8, 8),
	(9, 9, 9),
	(10, 10, 10);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
