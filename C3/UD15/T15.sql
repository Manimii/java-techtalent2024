-- Ejercicio 01

USE directores_despachos;

INSERT INTO despachos VALUES 
(1,10),(2,20),(3,30),(4,40),(5,50),(6,60),(7,70),(8,80),(9,90),(10,100);

INSERT INTO directores VALUES 
('7869261K', 'juan', NULL, 3),
('3287390R', 'maria', NULL, 1),
('0827137K', 'pedro', NULL, 2),
('7845859G', 'cristina', '7869261K', 3),
('0672523P', 'francisco', NULL, 9),
('9861511N', 'ana', '0672523P', 9),
('5478699Y', 'carlos', NULL, 4),
('7357072Y', 'rosa', '5478699Y', 4),
('3374683Z', 'javier', NULL, 6),
('7305597S', 'montse', NULL, 5);

-- Ejercicio 02

USE piezas_proveedores;

INSERT INTO piezas (nombre) VALUES
('pieza1'), ('pieza2'), ('pieza3'), ('pieza4'), ('pieza5'), ('pieza6'), ('pieza7'), ('pieza8'), ('pieza9'), ('pieza10');

INSERT INTO proveedores VALUES
('AA01','prov1'), ('AA02','prov2'), ('AA03','prov3'), ('AA04','prov4'), ('AA05','prov5'), ('AA06','prov6'), ('AA07','prov7'), ('AA08','prov8'), ('AA09','prov9'), ('AA10','prov10alumnos');

INSERT INTO suministra VALUES 
(1,'AA01', 10),
(2,'AA02', 20),
(3,'AA03', 30),
(4,'AA04', 40),
(5,'AA05', 50),
(6,'AA06', 60),
(7,'AA07', 70),
(8,'AA08', 80),
(9,'AA09', 90),
(10,'AA10', 100);

-- Ejercicio 03

USE cientificos;

INSERT INTO cientificos VALUES 
('7869261K', 'juan'),
('3287390R', 'maria'),
('0827137K', 'pedro'),
('7845859G', 'cristina'),
('0672523P', 'francisco'),
('9861511N', 'ana'),
('5478699Y', 'carlos'),
('7357072Y', 'rosa'),
('3374683Z', 'javier'),
('7305597S', 'montse');

INSERT INTO proyecto VALUES 
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

INSERT INTO asignado_a VALUES 
('7869261K', 'P001'),
('3287390R', 'P002'),
('0827137K', 'P003'),
('7845859G', 'P004'),
('0672523P', 'P005'),
('9861511N', 'P006'),
('5478699Y', 'P007'),
('7357072Y', 'P008'),
('3374683Z', 'P009'),
('7305597S', 'P010');

-- Ejercicio 04

USE grandes_almacenes;

INSERT INTO cajeros (nom_apels) VALUES
('c1'),('c2'),('c3'),('c4'),('c5'),('c6'),('c7'),('c8'),('c9'),('c10');

INSERT INTO maquinas_registradoras (piso) VALUES
(1),(2),(3),(4),(5),(6),(7),(8),(9),(10);

INSERT INTO productos (nombre, precio) VALUES
('p1',10),('p2',20),('p3',30),('p4',40),('p5',50),('p6',60),('p7',70),('p8',80),('p9',90),('p10',100);

INSERT INTO venta VALUES                                                           
(1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);

-- Ejercicio 05

USE investigadores;

INSERT INTO facultad (nombre) VALUES
('f1'),('f2'),('f3'),('f4'),('f5'),('f6'),('f7'),('f8'),('f9'),('f10');

INSERT INTO investigadores VALUES
('7869261K', 'juan', 1),
('3287390R', 'maria', 2),
('0827137K', 'pedro', 3),
('7845859G', 'cristina', 4),
('0672523P', 'francisco', 5),
('9861511N', 'ana', 6),
('5478699Y', 'carlos', 7),
('7357072Y', 'rosa', 8),
('3374683Z', 'javier', 9),
('7305597S', 'montse', 10);

INSERT INTO equipos VALUES 
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

INSERT INTO reserva VALUES 
('7869261K', 'E001', CURDATE(), CURDATE() + 10),
('3287390R', 'E002', CURDATE(), CURDATE() + 10),
('0827137K', 'E003', CURDATE(), CURDATE() + 10),
('7845859G', 'E004', CURDATE(), CURDATE() + 10),
('0672523P', 'E005', CURDATE(), CURDATE() + 10),
('9861511N', 'E006', CURDATE(), CURDATE() + 10),
('5478699Y', 'E007', CURDATE(), CURDATE() + 10),
('7357072Y', 'E008', CURDATE(), CURDATE() + 10),
('3374683Z', 'E009', CURDATE(), CURDATE() + 10),
('7305597S', 'E010', CURDATE(), CURDATE() + 10);