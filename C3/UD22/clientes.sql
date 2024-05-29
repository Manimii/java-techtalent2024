CREATE TABLE IF NOT EXISTS `clientes` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(250) DEFAULT NULL,
    `apellido` varchar(250) DEFAULT NULL,
    `direccion` varchar(250) DEFAULT NULL,
    `dni` int(11) DEFAULT NULL,
    `fecha` date DEFAULT NULL,
    PRIMARY KEY (`id`)
);