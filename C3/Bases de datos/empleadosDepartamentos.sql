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


-- Volcando estructura de base de datos para empleados_departamentos
CREATE DATABASE IF NOT EXISTS `empleados_departamentos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `empleados_departamentos`;

-- Volcando estructura para tabla empleados_departamentos.departamentos
CREATE TABLE IF NOT EXISTS `departamentos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `presupuesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla empleados_departamentos.departamentos: ~10 rows (aproximadamente)
INSERT INTO `departamentos` (`codigo`, `nombre`, `presupuesto`) VALUES
	(1, 'Ventas', 9000),
	(2, 'Marketing', 13500),
	(3, 'Recursos Humanos', 10800),
	(4, 'Desarrollo', 18000),
	(5, 'Finanzas', 16200),
	(6, 'Producción', 22500),
	(7, 'Logística', 15300),
	(8, 'Calidad', 11700),
	(9, 'Investigación', 19800),
	(10, 'Administración', 17100),
	(11, 'Calidad2', 36000);

-- Volcando estructura para tabla empleados_departamentos.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK_empleados_departamentos` (`departamento`),
  CONSTRAINT `FK_empleados_departamentos` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla empleados_departamentos.empleados: ~15 rows (aproximadamente)
INSERT INTO `empleados` (`dni`, `nombre`, `apellidos`, `departamento`) VALUES
	('01234567', 'Elena', 'Díaz', 10),
	('11223344', 'Alejandro', 'Hernández', 1),
	('12345678', 'Juan', 'Pérez', 1),
	('22334455', 'Patricia', 'Santos', 2),
	('23456789', 'María', 'García', 2),
	('33445566', 'Javier', 'Vargas', 3),
	('34567890', 'Carlos', 'López', 3),
	('44556677', 'Isabel', 'Fuentes', 4),
	('45678901', 'Laura', 'Martínez', 4),
	('55667788', 'Daniel', 'Moreno', 5),
	('56789012', 'Pedro', 'Sánchez', 5),
	('67890123', 'Ana', 'Rodríguez', 6),
	('78901234', 'David', 'Fernández', 7),
	('89012345', 'Sofía', 'Ruiz', 8),
	('89267109', 'Esther', 'Vázquez', 11),
	('90123456', 'Luis', 'Gómez', 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
