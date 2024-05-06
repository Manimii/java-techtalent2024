use empleados;

db.createCollection("departamentos");

db.departamentos.insertMany([
    { _id: 1, nombre: "Ventas", presupuesto: 100000 },
    { _id: 2, nombre: "Marketing", presupuesto: 80000 },
    { _id: 3, nombre: "Desarrollo", presupuesto: 150000 },
    { _id: 4, nombre: "Recursos Humanos", presupuesto: 75000 },
    { _id: 5, nombre: "Finanzas", presupuesto: 120000 },
  ]);

db.createCollection("empleados");

db.empleados.insertMany([
    { _id: 1, nombre: "Juan", apellidos: "González", departamento: 1},
    { _id: 2, nombre: "María", apellidos: "López", departamento: 2},
    { _id: 3, nombre: "Carlos", apellidos: "Martínez", departamento: 3},
    { _id: 4, nombre: "Laura", apellidos: "Sánchez", departamento: 4},
    { _id: 5, nombre: "Pedro", apellidos: "Díaz", departamento: 5},
    { _id: 6, nombre: "Ana", apellidos: "Fernández", departamento: 1},
    { _id: 7, nombre: "Diego", apellidos: "Rodríguez", departamento: 2},
    { _id: 8, nombre: "Elena", apellidos: "García", departamento: 3},
    { _id: 9, nombre: "Pablo", apellidos: "Romero", departamento: 4},
    { _id: 10, nombre: "Sara", apellidos: "Jiménez", departamento: 5}
]);