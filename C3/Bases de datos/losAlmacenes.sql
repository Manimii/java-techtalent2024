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


-- Volcando estructura de base de datos para almacenes
CREATE DATABASE IF NOT EXISTS `almacenes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `almacenes`;

-- Volcando estructura para tabla almacenes.almacenes
CREATE TABLE IF NOT EXISTS `almacenes` (
  `codigo` int(11) NOT NULL,
  `lugar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla almacenes.almacenes: ~10 rows (aproximadamente)
INSERT INTO `almacenes` (`codigo`, `lugar`, `capacidad`) VALUES
	(1, 'Nueva York', 200),
	(2, 'Los Ángeles', 150),
	(3, 'Chicago', 180),
	(4, 'Houston', 170),
	(5, 'Phoenix', 160),
	(6, 'Filadelfia', 190),
	(7, 'San Antonio', 220),
	(8, 'San Diego', 210),
	(9, 'Dallas', 230),
	(10, 'San José', 240),
	(11, 'Ciudad Nueva', 1),
	(12, 'Barcelona', 3);

-- Volcando estructura para tabla almacenes.cajas
CREATE TABLE IF NOT EXISTS `cajas` (
  `num_referencia` char(5) NOT NULL,
  `contenido` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `almacen` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_referencia`),
  KEY `fk_cajas_almacenes` (`almacen`),
  CONSTRAINT `fk_cajas_almacenes` FOREIGN KEY (`almacen`) REFERENCES `almacenes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla almacenes.cajas: ~18 rows (aproximadamente)
INSERT INTO `cajas` (`num_referencia`, `contenido`, `valor`, `almacen`) VALUES
	('A001', 'Documentos', 136, 1),
	('B002', 'Electrónicos', 204, 2),
	('C003', 'Ropa', 128, 3),
	('D004', 'Herramientas', 170, 4),
	('E005', 'Juguetes', 102, 5),
	('F006', 'Libros', 153, 6),
	('G007', 'Artículos de cocina', 145, 7),
	('H008', 'Cosméticos', 150, 8),
	('H5RT', 'Papel', 136, 2),
	('I009', 'Comestibles', 162, 9),
	('J010', 'Artículos de oficina', 136, 10),
	('K011', 'Equipos deportivos', 190, 1),
	('L012', 'Electrodomésticos', 340, 2),
	('M013', 'Instrumentos musicales', 238, 3),
	('N014', 'Accesorios para el hogar', 153, 4),
	('O015', 'Productos de limpieza', 136, 5),
	('P016', 'Material de embalaje', 43, 6),
	('P017', 'Artículos pequeños', 17, 11),
	('Q018', 'Objetos frágiles', 26, 11);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
