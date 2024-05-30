CREATE TABLE IF NOT EXISTS `clientes` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(250) DEFAULT NULL,
    `apellido` varchar(250) DEFAULT NULL,
    `direccion` varchar(250) DEFAULT NULL,
    `dni` int(11) DEFAULT NULL,
    `fecha` date DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `clientes` (`nombre`, `apellido`, `direccion`, `dni`, `fecha`) VALUES
('Juan', 'Perez', 'Calle Falsa 123', 12345678, '2023-05-01'),
('Maria', 'Garcia', 'Av. Siempre Viva 456', 23456789, '2023-06-01'),
('Carlos', 'Lopez', 'Calle Luna 789', 34567890, '2023-07-01'),
('Ana', 'Martinez', 'Av. Estrella 101', 45678901, '2023-08-01'),
('Luis', 'Gomez', 'Calle Sol 202', 56789012, '2023-09-01'),
('Elena', 'Fernandez', 'Av. Mar 303', 67890123, '2023-10-01'),
('Jorge', 'Ramirez', 'Calle Tierra 404', 78901234, '2023-11-01'),
('Marta', 'Sanchez', 'Av. Cielo 505', 89012345, '2023-12-01'),
('Roberto', 'Torres', 'Calle Universo 606', 90123456, '2024-01-01'),
('Laura', 'Diaz', 'Av. Galaxia 707', 12345679, '2024-02-01');