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
SELECT SUM(precio)/COUNT(precio) AS precio_medio
FROM articulos

-- 1.7 Obtener el precio medio de los artículos cuyo código de fabricante sea 2.
SELECT SUM(precio)/COUNT(precio) AS precio_medio
FROM articulos
WHERE codigo = 2;

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

SELECT fabricante, SUM(precio)/COUNT(precio) AS precio_medio
FROM articulos
GROUP BY fabricante

-- 1.13 Obtener el precio medio de los productos de cada fabricante, mostrando el nombre del fabricante
SELECT fabricante, fabricantes.nombre, SUM(precio)/COUNT(precio) AS precio_medio
FROM articulos
INNER JOIN fabricantes ON fabricante = fabricantes.codigo
GROUP BY fabricante

-- 1.14 Obtener los nombres de los fabricantes que ofrezcan productos cuyo precio medio sea mayor o igual a 80€
SELECT articulos.fabricante, fabricantes.nombre, SUM(articulos.precio)/COUNT(articulos.precio) AS precio_medio
FROM fabricantes
INNER JOIN articulos ON articulos.fabricante = fabricantes.codigo
WHERE (
	SELECT SUM(precio)/COUNT(precio)
	FROM articulos
	WHERE fabricante = fabricantes.codigo
	GROUP BY fabricante
) >= 80
GROUP BY articulos.fabricante