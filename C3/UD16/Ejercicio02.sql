-- 2.0 Inserta 10 tuplas válidas por cada tabla creada en la base de datos Empleados
INSERT INTO departamentos (nombre, presupuesto) 
VALUES 
('Ventas', 10000),
('Marketing', 15000),
('Recursos Humanos', 12000),
('Desarrollo', 20000),
('Finanzas', 18000),
('Producción', 25000),
('Logística', 17000),
('Calidad', 13000),
('Investigación', 22000),
('Administración', 19000)

INSERT INTO empleados
VALUES 
('12345678', 'Juan', 'Pérez', 1),
('23456789', 'María', 'García', 2),
('34567890', 'Carlos', 'López', 3),
('45678901', 'Laura', 'Martínez', 4),
('56789012', 'Pedro', 'Sánchez', 5),
('67890123', 'Ana', 'Rodríguez', 6),
('78901234', 'David', 'Fernández', 7),
('89012345', 'Sofía', 'Ruiz', 8),
('90123456', 'Luis', 'Gómez', 9),
('01234567', 'Elena', 'Díaz', 10)

-- 2.1 Obtener los apellidos de los empleados
SELECT apellidos 
FROM empleados

-- 2.2 Obtener los apellidos de los empleados sin repeticiones
SELECT DISTINCT apellidos 
FROM empleados

-- 2.3 Obtener todos los datos de los empleados que se apellidan ‘López’
SELECT *
FROM empleados
WHERE apellidos = 'López'

-- 2.4 Obtener todos los datos de los empleados que se apellidan ‘López’ y los que se apellidan ‘Pérez’.
SELECT *
FROM empleados
WHERE apellidos = 'López' OR apellidos = 'Pérez'

-- 2.5 Obtener todos los datos de los empleados que trabajan para el departamento 14 (4 en mi caso ya que no hay departamento 14).
SELECT *
FROM empleados
WHERE departamento = 4

-- 2.6 Obtener todos los datos de los empleados que trabajan para el departamento 37 y para el departamento 77 (3 y 7 en mi caso ya que mi Base de Datos no tiene esos departamentos)
SELECT *
FROM empleados
WHERE departamento IN (3,7)

-- 2.7 Obtener todos los datos de los empleados cuyo apellido comience por ‘P’
SELECT *
FROM empleados
WHERE apellidos LIKE 'P%'

-- 2.8 Obtener el presupuesto total de todos los departamentos
SELECT SUM(presupuesto) AS presupuestos_totales
FROM departamentos

-- 2.9 Obtener el número de empleados en cada departamento.
SELECT departamento, COUNT(dni) AS numero_empleados
FROM empleados
GROUP BY departamento

-- 2.10 Obtener un listado completo de empleados, incluyendo por cada empleado los datos del empleado y de su departamento
SELECT e.*, d.*
FROM empleados e LEFT OUTER JOIN departamentos d 
ON e.departamento = d.codigo

-- 2.11 Obtener un listado completo de empleados, incluyendo el nombre y apellidos del empleado junto al nombre y presupuesto de su departamento
SELECT e.nombre, e.apellidos, d.nombre AS "Nombre departamento", d.presupuesto AS "Presupuesto departamento"
FROM empleados e LEFT OUTER JOIN departamentos d 
ON e.departamento = d.codigo

-- 2.12 Obtener los nombres y apellidos de los empleados que trabajen en departamentos cuyo presupuesto sea mayor de 60.000€ (18.000€ en mi caso).
SELECT e.nombre, e.apellidos, d.presupuesto AS presupuesto_departamento
FROM empleados e, departamentos d
WHERE e.departamento = d.codigo AND d.presupuesto > 18000

-- 2.13 Obtener los datos de los departamentos cuyo presupuesto es superior al presupuesto medio de todos los departamentos
SELECT *
FROM departamentos
WHERE presupuesto > 
(
	SELECT AVG(presupuesto)
	FROM departamentos
)

-- 2.14 Obtener los nombres (únicamente los nombres) de los departamentos que tienen más de dos empleados. (Como en mi caso no hay ningún departamento con más de un empleado, generaré 5 empleados extra) 
INSERT INTO empleados
VALUES 
('11223344', 'Alejandro', 'Hernández', 1),
('22334455', 'Patricia', 'Santos', 2),
('33445566', 'Javier', 'Vargas', 3),
('44556677', 'Isabel', 'Fuentes', 4),
('55667788', 'Daniel', 'Moreno', 5);

SELECT d.nombre
FROM departamentos d, empleados e
WHERE d.codigo = e.departamento AND 2 <= 
(
	SELECT COUNT(em.dni)
	FROM empleados em
	WHERE em.departamento = d.codigo
	GROUP BY em.departamento
)
GROUP BY d.nombre

-- 2.15 Añadir un nuevo departamento: ‘Calidad’, con presupuesto de 40.000€ y código 11. Añadir un empleado vinculado al departamento recién creado: Esther Vázquez, DNI: 89267109
INSERT INTO departamentos (nombre, presupuesto)
VALUES ('Calidad2', 40000)

INSERT INTO empleados 
VALUES ('89267109', 'Esther', 'Vázquez', 11)

-- 2.16 Aplicar un recorte presupuestario del 10% a todos los departamentos.
UPDATE departamentos
SET presupuesto = presupuesto * 0.9

-- 2.17 Reasignar a los empleados del departamento de investigación al departamento de informática.(Como yo no tengo departamento de informática los reasignaré al de desarrollo)
UPDATE empleados
SET departamento = 4
WHERE departamento = 9

-- 2.18 Despedira todos los empleados que trabajan para el departamento de informática (Desarrollo) (Yo no los voy a borrar)
DELETE
FROM empleados
WHERE departamento = 4

-- 2.19 Despedir a todos los empleados que trabajen para departamentos cuyo presupuesto sea superior a los 60.000€ (18.000€ en mi caso)
DELETE
FROM empleados e
WHERE e.departamento = 
(
	SELECT d.codigo
	FROM departamentos d
	WHERE d.codigo = e.departamento AND d.presupuesto >= 18000
)

-- 2.20 Despedir a todos los empleados
DELETE
FROM empleados 