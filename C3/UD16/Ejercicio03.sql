-- 3.0 Inserta 10 tuplas por cada tabla creada en la base de datos de almacenes.
INSERT INTO almacenes (codigo, lugar, capacidad) VALUES
(1, 'Nueva York', 200),
(2, 'Los Ángeles', 150),
(3, 'Chicago', 180),
(4, 'Houston', 170),
(5, 'Phoenix', 160),
(6, 'Filadelfia', 190),
(7, 'San Antonio', 220),
(8, 'San Diego', 210),
(9, 'Dallas', 230),
(10, 'San José', 240);

INSERT INTO cajas (num_referencia, contenido, valor, almacen) VALUES
('A001', 'Documentos', 200, 1),
('B002', 'Electrónicos', 300, 2),
('C003', 'Ropa', 150, 3),
('D004', 'Herramientas', 250, 4),
('E005', 'Juguetes', 120, 5),
('F006', 'Libros', 180, 6),
('G007', 'Artículos de cocina', 170, 7),
('H008', 'Cosméticos', 220, 8),
('I009', 'Comestibles', 190, 9),
('J010', 'Artículos de oficina', 160, 10);

-- 3.1 Obtener todos los almacenes
SELECT * 
FROM almacenes

-- 3.2 Obtener todas las cajas cuyo contenido tenga un valor superior a 150€.
SELECT * 
FROM cajas
WHERE valor > 150

-- 3.3 Obtener los tipos de contenidos de las cajas
SELECT DISTINCT contenido
FROM cajas

-- 3.4 Obtener el valor medio de todas las cajas.
SELECT AVG(valor) AS valor_medio
FROM cajas

-- 3.5 Obtener el valor medio de las cajas de cada almacén.
INSERT INTO cajas (num_referencia, contenido, valor, almacen) VALUES
('K011', 'Equipos deportivos', 280, 1),
('L012', 'Electrodomésticos', 500, 2),
('M013', 'Instrumentos musicales', 350, 3),
('N014', 'Accesorios para el hogar', 180, 4),
('O015', 'Productos de limpieza', 200, 5);

SELECT AVG(valor) AS valor_medio, almacen
FROM cajas
GROUP BY almacen

-- 3.6 Obtener los códigos de los almacenes en los cuales el valor medio de las cajas sea superior a 150€ 
INSERT INTO cajas (num_referencia, contenido, valor, almacen) VALUES
('P016', 'Material de embalaje', 50, 6);

SELECT almacen, AVG(valor) AS valor_medio
FROM cajas 
GROUP BY almacen
HAVING AVG(valor) > 150

-- 3.7 Obtener el número de referencia de cada caja junto con el nombre de la ciudad en el que se encuentra.
SELECT c.num_referencia, a.lugar
FROM cajas c, almacenes a
WHERE c.almacen = a.codigo
ORDER BY c.num_referencia

-- 3.8 Obtener el número de cajas que hay en cada almacén.
SELECT almacen, COUNT(num_referencia) AS numero_de_cajas
FROM cajas
GROUP BY almacen

-- 3.9 Obtener los códigos de los almacenes que están saturados (los almacenes donde el número de cajas es superior a la capacidad.
SELECT a.codigo
FROM almacenes a
WHERE capacidad < 
(
	SELECT COUNT(c.num_referencia)
	FROM cajas c
	WHERE c.almacen = a.codigo
	GROUP BY c.almacen
)

-- 3.10 Obtener los números de referencia de las cajas que están en Bilbao (Chicago en mi caso)
SELECT c.num_referencia
FROM cajas c
WHERE 'Chicago' = 
(
	SELECT a.lugar
	FROM almacenes a
	WHERE c.almacen = a.codigo
)

-- 3.11 Insertar un nuevo almacén en Barcelona con capacidad para 3 cajas.
INSERT INTO almacenes (codigo, lugar, capacidad) 
VALUES (12, 'Barcelona', 3);

-- 3.12 Insertar una nueva caja, con número de referencia ‘H5RT’, con contenido ‘Papel’, valor 200, y situada en el almacén 2
INSERT INTO cajas 
VALUES ('H5RT', 'Papel', 200, 2);

-- 3.13 Rebajar el valor de todas las cajas un 15%.
UPDATE cajas
SET valor = valor * 0.85

-- 3.14 Rebajar un 20% el valor de todas las cajas cuyo valor sea superior al valor medio de todas las cajas (El valor medio es 167.9474 en mi caso).
UPDATE cajas
SET valor = valor * 0.80
WHERE valor > 
(
	SELECT AVG(valor)
	FROM cajas
)

-- 3.15 Eliminar todas las cajas cuyo valor sea inferior a 100€ (Yo haré un select para no borrarlas).
SELECT *
FROM cajas
WHERE valor < 100

-- 3.16 Vaciar el contenido de los almacenes que están saturados (Yo haré un select para no borrarlos).
SELECT a.*
FROM almacenes a
WHERE capacidad < 
(
	SELECT COUNT(c.num_referencia)
	FROM cajas c
	WHERE c.almacen = a.codigo
	GROUP BY c.almacen
)