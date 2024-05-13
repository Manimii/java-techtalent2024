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


-- Volcando estructura de base de datos para cine
CREATE DATABASE IF NOT EXISTS `cine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `cine`;

-- Volcando estructura para tabla cine.peliculas
CREATE TABLE IF NOT EXISTS `peliculas` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `calificacion_edad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla cine.peliculas: ~10 rows (aproximadamente)
INSERT INTO `peliculas` (`codigo`, `nombre`, `calificacion_edad`) VALUES
	(1, 'El Padrino', 18),
	(2, 'Titanic', 12),
	(3, 'El Señor de los Anillos: La Comunidad del Anillo', 12),
	(4, 'La La Land', 10),
	(5, 'Parásitos', 16),
	(6, 'Harry Potter y la Piedra Filosofal', 10),
	(7, 'Forrest Gump', 12),
	(8, 'Pulp Fiction', 18),
	(9, 'Coco', 6),
	(10, 'El Rey León', 6),
	(11, 'Interstellar', 13),
	(12, 'Uno, Dos, Tres', 7);

-- Volcando estructura para tabla cine.salas
CREATE TABLE IF NOT EXISTS `salas` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pelicula` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_salas_peliculas` (`pelicula`),
  CONSTRAINT `fk_salas_peliculas` FOREIGN KEY (`pelicula`) REFERENCES `peliculas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla cine.salas: ~10 rows (aproximadamente)
INSERT INTO `salas` (`codigo`, `nombre`, `pelicula`) VALUES
	(1, 'Sala 1', 1),
	(2, 'Sala 2', 2),
	(3, 'Sala 3', 3),
	(4, 'Sala 4', 4),
	(5, 'Sala 5', 5),
	(6, 'Sala 6', 6),
	(7, 'Sala 7', 7),
	(8, 'Sala 8', 8),
	(9, 'Sala 9', 9),
	(10, 'Sala 10', 10),
	(11, 'Sala 11', NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
