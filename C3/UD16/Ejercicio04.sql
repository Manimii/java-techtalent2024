-- 4.0 Inserta 10 tuplas válidas por cada tabla creada de la base de datos Películas y Salas.
INSERT INTO peliculas (nombre, calificacion_edad) VALUES
('El Padrino', 18),
('Titanic', 12),
('El Señor de los Anillos: La Comunidad del Anillo', 12),
('La La Land', 10),
('Parásitos', 16),
('Harry Potter y la Piedra Filosofal', 10),
('Forrest Gump', 12),
('Pulp Fiction', 18),
('Coco', 6),
('El Rey León', 6);

INSERT INTO salas (nombre, pelicula) VALUES
('Sala 1', 1),
('Sala 2', 2),
('Sala 3', 3),
('Sala 4', 4),
('Sala 5', 5),
('Sala 6', 6),
('Sala 7', 7),
('Sala 8', 8),
('Sala 9', 9),
('Sala 10', 10);

-- 4.1 Mostrar el nombre de todas las películas.
SELECT nombre
FROM peliculas

-- 4.2 Mostrar las distintas calificaciones de edad que existen.
SELECT DISTINCT calificacion_edad
FROM peliculas 

-- 4.3 Mostrar todas las películas que no han sido calificadas (Voy a añadir una película sin calificación para comprobar que funciona)
INSERT INTO peliculas (nombre, calificacion_edad) 
VALUES ('Interstellar', NULL);

SELECT *
FROM peliculas
WHERE calificacion_edad IS NULL 

-- 4.4 Mostrar todas las salas que no proyectan ninguna película (Voy a añadir una sala que no proyecte ninguna película para comprobar que funciona).
INSERT INTO salas (nombre, pelicula) 
VALUES ('Sala 11', NULL);

SELECT *
FROM salas
WHERE pelicula IS NULL

-- 4.5 Mostrar la información de todas las salas y, si se proyecta alguna película en la sala, mostrar también la información de la película.
SELECT s.*, p.*
FROM salas s
LEFT OUTER JOIN peliculas p ON p.codigo = s.pelicula

-- 4.6 Mostrar la información de todas las películas y, si se proyecta en alguna sala, mostrar también la información de la sala.
SELECT p.*, s.*
FROM peliculas p
LEFT OUTER JOIN salas s ON p.codigo = s.pelicula

-- 4.7 Mostrar los nombres de las películas que no se proyectan en ninguna sala.
SELECT p.nombre, p.codigo
FROM peliculas p 
WHERE NOT EXISTS 
(
	SELECT DISTINCT s.pelicula
	FROM salas s
	WHERE s.pelicula = p.codigo
)

-- 4.8 Añadir una nueva película ‘Uno, Dos, Tres’, para mayores de 7 años.
INSERT INTO peliculas (nombre, calificacion_edad)
VALUES ('Uno, Dos, Tres', 7)

-- 4.9 Hacer constar que todas las películas no calificadas han sido calificadas ‘no recomendables para menores de 13 años’.
UPDATE peliculas
SET calificacion_edad = 13
WHERE calificacion_edad IS NULL 

-- 4.10 Eliminar todas las salas que proyectan películas recomendadas para todos los públicos. (Yo voy a hacer un select para no eliminar salas y como no tengo peliculas para todos los públicos voy a seleccionar las películas recomendadas para los 6 años).
SELECT s.*
FROM salas s, peliculas p
WHERE s.pelicula = p.codigo AND p.calificacion_edad = 6

-- 