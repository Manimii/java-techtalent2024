USE tienda_informatica;

INSERT INTO fabricantes (nombre) VALUES 
('f1'),('f2'),('f3'),('f4'),('f5'),('f6'),('f7'),('f8'),('f9'),('f10');

INSERT INTO articulos (nombre, precio, fabricante) VALUES 
('a1', 10, 1),
('a2', 10, 1),
('a3', 10, 1),
('a4', 10, 1),
('a5', 10, 1),
('a6', 10, 1),
('a7', 10, 1),
('a8', 10, 1),
('a9', 10, 1),
('a10', 10, 1);

-- 1.1 Selecciona los nombres de los productos de la tienda
SELECT nombre
FROM articulos;

-- 1.2 Obtener los nombres y los precios de los artículos de la tienda.
SELECT nombre, precio
FROM articulos;

-- 1.3 Obtener los nombres de los productos cuyo precio sea menor o igual a 50€.
SELECT nombre
FROM articulos
WHERE precio <= 50;

-- 1.4 Obtener todos los datos de los artículos cuyo precio esté enre los 60€ y los 120€ (ambas cantidades incluidas).
SELECT *
FROM articulos
WHERE precio BETWEEN 60 AND 120;

-- 1.5 Obtener el nombre y el precio en pesetas (es decir, el precio en euros multiplicado por 166,386)
SELECT nombre, (precio * 166.386) AS precio_en_pesetas
FROM articulos

-- 1.6 Seleccionar el precio medio de todos los productos
SELECT AVG(precio) AS precio_medio
FROM articulos

-- 1.7 Obtener el precio medio de los artículos cuyo código de fabricante sea 2.
SELECT AVG(precio) AS precio_medio
FROM articulos
WHERE fabricante = 2;

-- 1.8 Obtener el número de artículos cuyo precio sea mayor o igual a 80€ 
SELECT COUNT(*) AS num_articulos
FROM articulos
WHERE precio >= 80;

-- 1.9 Obtener el nombre y precio de los artículos cuyo precio sea mayor o igual a 180€ y ordenarlos descendentemente por precio, y luego ascendentemente por nombre.
SELECT nombre, precio
FROM articulos
WHERE precio >= 80
ORDER BY precio DESC, nombre;

-- 1.10 Obtener un listado completo de artículos, incluyendo por cada artículo los datos del artículo y de su fabricante.
SELECT articulos.codigo, articulos.nombre, precio, fabricante, fabricantes.nombre AS nombre_fabricante
FROM articulos
INNER JOIN fabricantes ON fabricante = fabricantes.codigo;

 -- 1.11 Obtener un listado de artículos, incluyendo el nombre del artículo, su precio, y el nombre de su fabricante
SELECT articulos.nombre, precio, fabricantes.nombre AS nombre_fabricante
FROM articulos
INNER JOIN fabricantes ON fabricante = fabricantes.codigo;

-- 1.12 Obtener el precio medio de los productos de cada fabricante, mostrando solo los códigos de fabricante.
INSERT INTO articulos (nombre, precio, fabricante) VALUES ('a11', 200, 3)

SELECT fabricante, AVG(precio) AS precio_medio
FROM articulos
GROUP BY fabricante

-- 1.13 Obtener el precio medio de los productos de cada fabricante, mostrando el nombre del fabricante
SELECT fabricante, fabricantes.nombre, AVG(precio) AS precio_medio
FROM articulos
INNER JOIN fabricantes ON fabricante = fabricantes.codigo
GROUP BY fabricante

-- 1.14 Obtener los nombres de los fabricantes que ofrezcan productos cuyo precio medio sea mayor o igual a 80€
SELECT articulos.fabricante, fabricantes.nombre, SUM(articulos.precio)/COUNT(articulos.precio) AS precio_medio
FROM fabricantes
INNER JOIN articulos ON articulos.fabricante = fabricantes.codigo
WHERE (
	SELECT AVG(precio)
	FROM articulos
	WHERE fabricante = fabricantes.codigo
	GROUP BY fabricante
) >= 80
GROUP BY articulos.fabricante

-- 1.15 Obtener el nombre y el precio del artículo más barato.
SELECT nombre, precio 
FROM articulos
ORDER BY precio 
LIMIT 1

-- 1.16 Obtener una lista con el nombre y precio de los artículos más caros de cada proveedor (incluyendo el nombre del proveedor).
SELECT a.nombre AS nombre_articulo, a.precio, f.nombre AS nombre_fabricante
FROM articulos a, fabricantes f
WHERE a.fabricante = f.codigo AND a.precio = (
	SELECT MAX(ar.precio)
	FROM articulos ar
	WHERE ar.fabricante = f.codigo
)
ORDER BY a.fabricante

-- 1.17 Añadir un nuevo producto: Altavoces de 70€ (del fabricante 2)
INSERT INTO articulos (nombre, precio, fabricante)
VALUES ('Altavoz', 70, 2)

-- 1.18 Cambiar el nombre del producto 8 a ‘Impresora Laser’
UPDATE articulos 
SET nombre = 'Impresora Laser'
WHERE codigo = 8

-- 1.19 Aplicar un descuento del 10% (multiplicar el precio por 0,9) a todos los productos
UPDATE articulos 
SET precio = precio * 0.9 

-- 1.20 Aplicar un descuento de 10€ a todos los productos cuyo precio sea mayor o igual a 120€
UPDATE articulos
SET precio = precio - 10
WHERE precio >= 120