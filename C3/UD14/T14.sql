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


-- Volcando estructura de base de datos para ejercicio01
CREATE DATABASE IF NOT EXISTS `ejercicio01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio01`;

-- Volcando estructura para tabla ejercicio01.estacion
CREATE TABLE IF NOT EXISTS `estacion` (
  `id` mediumint(8) unsigned NOT NULL,
  `latitud` varchar(14) NOT NULL,
  `longitud` varchar(15) NOT NULL,
  `altitud` mediumint(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio01.estacion: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio01.muestra
CREATE TABLE IF NOT EXISTS `muestra` (
  `id_estacion` mediumint(8) unsigned NOT NULL,
  `fecha` date NOT NULL,
  `temperatura_minima` tinyint(4) DEFAULT NULL,
  `temperatura_maxima` tinyint(4) DEFAULT NULL,
  `precipitaciones` smallint(5) unsigned DEFAULT NULL,
  `humedad_minima` tinyint(3) unsigned DEFAULT NULL,
  `humedad_maxima` tinyint(3) unsigned DEFAULT NULL,
  `velocidad_minima` smallint(5) unsigned DEFAULT NULL,
  `velocidad_maxima` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_estacion`),
  CONSTRAINT `muestra_ibfk_1` FOREIGN KEY (`id_estacion`) REFERENCES `estacion` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio01.muestra: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio02
CREATE DATABASE IF NOT EXISTS `ejercicio02` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio02`;

-- Volcando estructura para tabla ejercicio02.autor
CREATE TABLE IF NOT EXISTS `autor` (
  `clave_autor` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`clave_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.autor: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.editorial
CREATE TABLE IF NOT EXISTS `editorial` (
  `clave_editorial` smallint(6) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `teléfono` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`clave_editorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.editorial: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.ejemplar
CREATE TABLE IF NOT EXISTS `ejemplar` (
  `clave_ejemplar` int(11) NOT NULL,
  `clave_libro` int(11) DEFAULT NULL,
  `número_orden` smallint(6) NOT NULL,
  `edición` smallint(6) DEFAULT NULL,
  `ubicación` varchar(15) DEFAULT NULL,
  `categoría` char(1) DEFAULT NULL,
  PRIMARY KEY (`clave_ejemplar`),
  KEY `clave_libro` (`clave_libro`),
  CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`clave_libro`) REFERENCES `libro` (`clave_libro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.ejemplar: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.escrito_por
CREATE TABLE IF NOT EXISTS `escrito_por` (
  `clave_libro` int(11) DEFAULT NULL,
  `clave_autor` int(11) DEFAULT NULL,
  KEY `clave_libro` (`clave_libro`),
  KEY `clave_autor` (`clave_autor`),
  CONSTRAINT `escrito_por_ibfk_1` FOREIGN KEY (`clave_libro`) REFERENCES `libro` (`clave_libro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `escrito_por_ibfk_2` FOREIGN KEY (`clave_autor`) REFERENCES `autor` (`clave_autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.escrito_por: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `clave_libro` int(11) NOT NULL,
  `título` varchar(60) DEFAULT NULL,
  `idioma` varchar(15) DEFAULT NULL,
  `formato` varchar(15) DEFAULT NULL,
  `clave_editorial` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`clave_libro`),
  KEY `clave_editorial` (`clave_editorial`),
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`clave_editorial`) REFERENCES `editorial` (`clave_editorial`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.libro: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.préstamo
CREATE TABLE IF NOT EXISTS `préstamo` (
  `clave_socio` int(11) DEFAULT NULL,
  `clave_ejemplar` int(11) DEFAULT NULL,
  `número_orden` smallint(6) DEFAULT NULL,
  `fecha_préstamo` date DEFAULT NULL,
  `fecha_devolución` date DEFAULT NULL,
  `notas` blob DEFAULT NULL,
  KEY `clave_socio` (`clave_socio`),
  KEY `clave_ejemplar` (`clave_ejemplar`),
  CONSTRAINT `préstamo_ibfk_1` FOREIGN KEY (`clave_socio`) REFERENCES `socio` (`clave_socio`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `préstamo_ibfk_2` FOREIGN KEY (`clave_ejemplar`) REFERENCES `ejemplar` (`clave_ejemplar`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.préstamo: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.socio
CREATE TABLE IF NOT EXISTS `socio` (
  `clave_socio` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `dirección` varchar(60) DEFAULT NULL,
  `teléfono` varchar(15) DEFAULT NULL,
  `categoría` char(1) DEFAULT NULL,
  PRIMARY KEY (`clave_socio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.socio: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.tema
CREATE TABLE IF NOT EXISTS `tema` (
  `clave_tema` smallint(6) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`clave_tema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.tema: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio02.trata_sobre
CREATE TABLE IF NOT EXISTS `trata_sobre` (
  `clave_libro` int(11) DEFAULT NULL,
  `clave_tema` smallint(6) DEFAULT NULL,
  KEY `clave_libro` (`clave_libro`),
  KEY `clave_tema` (`clave_tema`),
  CONSTRAINT `trata_sobre_ibfk_1` FOREIGN KEY (`clave_libro`) REFERENCES `libro` (`clave_libro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trata_sobre_ibfk_2` FOREIGN KEY (`clave_tema`) REFERENCES `tema` (`clave_tema`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio02.trata_sobre: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio03
CREATE DATABASE IF NOT EXISTS `ejercicio03` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio03`;

-- Volcando estructura para tabla ejercicio03.articulos
CREATE TABLE IF NOT EXISTS `articulos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `fabricante` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_articulos_fabricantes` (`fabricante`),
  CONSTRAINT `FK_articulos_fabricantes` FOREIGN KEY (`fabricante`) REFERENCES `fabricantes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio03.articulos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio03.fabricantes
CREATE TABLE IF NOT EXISTS `fabricantes` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio03.fabricantes: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio04
CREATE DATABASE IF NOT EXISTS `ejercicio04` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio04`;

-- Volcando estructura para tabla ejercicio04.departamentos
CREATE TABLE IF NOT EXISTS `departamentos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `presupuesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio04.departamentos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio04.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK_empleados_departamentos` (`departamento`),
  CONSTRAINT `FK_empleados_departamentos` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio04.empleados: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio05
CREATE DATABASE IF NOT EXISTS `ejercicio05` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio05`;

-- Volcando estructura para tabla ejercicio05.almacenes
CREATE TABLE IF NOT EXISTS `almacenes` (
  `codigo` int(11) NOT NULL,
  `lugar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio05.almacenes: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio05.cajas
CREATE TABLE IF NOT EXISTS `cajas` (
  `num_referencia` char(5) NOT NULL,
  `contenido` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `almacen` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_referencia`),
  KEY `fk_cajas_almacenes` (`almacen`),
  CONSTRAINT `fk_cajas_almacenes` FOREIGN KEY (`almacen`) REFERENCES `almacenes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio05.cajas: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio06
CREATE DATABASE IF NOT EXISTS `ejercicio06` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio06`;

-- Volcando estructura para tabla ejercicio06.peliculas
CREATE TABLE IF NOT EXISTS `peliculas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `calificacion_edad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio06.peliculas: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio06.salas
CREATE TABLE IF NOT EXISTS `salas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pelicula` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_salas_peliculas` (`pelicula`),
  CONSTRAINT `fk_salas_peliculas` FOREIGN KEY (`pelicula`) REFERENCES `peliculas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio06.salas: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio07
CREATE DATABASE IF NOT EXISTS `ejercicio07` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio07`;

-- Volcando estructura para tabla ejercicio07.despachos
CREATE TABLE IF NOT EXISTS `despachos` (
  `numero` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio07.despachos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio07.directores
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

-- Volcando datos para la tabla ejercicio07.directores: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio08
CREATE DATABASE IF NOT EXISTS `ejercicio08` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio08`;

-- Volcando estructura para tabla ejercicio08.piezas
CREATE TABLE IF NOT EXISTS `piezas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio08.piezas: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio08.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `id` char(4) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio08.proveedores: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio08.suministra
CREATE TABLE IF NOT EXISTS `suministra` (
  `codigo_pieza` int(11) NOT NULL,
  `id_proveedor` char(4) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_pieza`,`id_proveedor`),
  KEY `fk_proveedores_suministra` (`id_proveedor`),
  CONSTRAINT `fk_piezas_suministra` FOREIGN KEY (`codigo_pieza`) REFERENCES `piezas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proveedores_suministra` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio08.suministra: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio09
CREATE DATABASE IF NOT EXISTS `ejercicio09` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio09`;

-- Volcando estructura para tabla ejercicio09.asignado_a
CREATE TABLE IF NOT EXISTS `asignado_a` (
  `cientifico` varchar(8) NOT NULL,
  `proyecto` char(4) NOT NULL,
  PRIMARY KEY (`cientifico`,`proyecto`),
  KEY `fk_proyecto_asignado` (`proyecto`),
  CONSTRAINT `fk_cientifico_asignado` FOREIGN KEY (`cientifico`) REFERENCES `cientificos` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proyecto_asignado` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio09.asignado_a: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio09.cientificos
CREATE TABLE IF NOT EXISTS `cientificos` (
  `dni` varchar(8) NOT NULL,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio09.cientificos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio09.proyecto
CREATE TABLE IF NOT EXISTS `proyecto` (
  `id` char(4) NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio09.proyecto: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio10
CREATE DATABASE IF NOT EXISTS `ejercicio10` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio10`;

-- Volcando estructura para tabla ejercicio10.cajeros
CREATE TABLE IF NOT EXISTS `cajeros` (
  `codigo` int(11) NOT NULL,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio10.cajeros: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio10.maquinas_registradoras
CREATE TABLE IF NOT EXISTS `maquinas_registradoras` (
  `codigo` int(11) NOT NULL,
  `piso` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio10.maquinas_registradoras: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio10.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio10.productos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio10.venta
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

-- Volcando datos para la tabla ejercicio10.venta: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio11
CREATE DATABASE IF NOT EXISTS `ejercicio11` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio11`;

-- Volcando estructura para tabla ejercicio11.equipos
CREATE TABLE IF NOT EXISTS `equipos` (
  `num_serie` char(4) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `facultad` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_serie`),
  KEY `fk_facultad_equipos` (`facultad`),
  CONSTRAINT `fk_facultad_equipos` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio11.equipos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio11.facultad
CREATE TABLE IF NOT EXISTS `facultad` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio11.facultad: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio11.investigadores
CREATE TABLE IF NOT EXISTS `investigadores` (
  `dni` varchar(8) NOT NULL,
  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `facultad` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_facultad_investigadores` (`facultad`),
  CONSTRAINT `fk_facultad_investigadores` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio11.investigadores: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio11.reserva
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

-- Volcando datos para la tabla ejercicio11.reserva: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para ejercicio12
CREATE DATABASE IF NOT EXISTS `ejercicio12` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio12`;

-- Volcando estructura para tabla ejercicio12.alumnos
CREATE TABLE IF NOT EXISTS `alumnos` (
  `nombre` varchar(40) DEFAULT NULL,
  `apellido1` varchar(40) DEFAULT NULL,
  `apellido2` varchar(40) DEFAULT NULL,
  `dni` varchar(8) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `curso` int(11) NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_curso_alumno` (`curso`),
  CONSTRAINT `fk_curso_alumno` FOREIGN KEY (`curso`) REFERENCES `cursos` (`cod_curso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sexo_check` CHECK (`sexo` = 'H' or `sexo` = 'M')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio12.alumnos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio12.cursos
CREATE TABLE IF NOT EXISTS `cursos` (
  `nombre_curso` varchar(100) DEFAULT NULL,
  `cod_curso` int(11) NOT NULL AUTO_INCREMENT,
  `dni_profesor` varchar(8) DEFAULT NULL,
  `maximo_alumnos` int(11) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `num_horas` int(11) NOT NULL,
  PRIMARY KEY (`cod_curso`),
  UNIQUE KEY `nombre_curso` (`nombre_curso`),
  KEY `fk_profesores_cursos` (`dni_profesor`),
  CONSTRAINT `fk_profesores_cursos` FOREIGN KEY (`dni_profesor`) REFERENCES `profesores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `check_fechas` CHECK (`fecha_inicio` <= `fecha_fin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio12.cursos: ~0 rows (aproximadamente)

-- Volcando estructura para tabla ejercicio12.profesores
CREATE TABLE IF NOT EXISTS `profesores` (
  `nombre` varchar(40) DEFAULT NULL,
  `apellido1` varchar(40) DEFAULT NULL,
  `apellido2` varchar(40) DEFAULT NULL,
  `dni` varchar(8) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `gana` float NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `nombre_unico` (`nombre`,`apellido1`,`apellido2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla ejercicio12.profesores: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
