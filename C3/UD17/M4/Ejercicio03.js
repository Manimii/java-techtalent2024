use almacenes;

db.createCollection("almacenes");

db.almacenes.insertMany([
  { _id: 1, lugar: "Almacén A", capacidad: 1000 },
  { _id: 2, lugar: "Almacén B", capacidad: 800 },
  { _id: 3, lugar: "Almacén C", capacidad: 1200 },
  { _id: 4, lugar: "Almacén D", capacidad: 1500 },
  { _id: 5, lugar: "Almacén E", capacidad: 900 }
]);

db.createCollection("cajas");

db.cajas.insertMany([
  { _id: 1, contenido: "Ropa", valor: 200, almacen: 1},
  { _id: 2, contenido: "Electrónicos", valor: 500, almacen: 2},
  { _id: 3, contenido: "Juguetes", valor: 100, almacen: 3},
  { _id: 4, contenido: "Herramientas", valor: 300, almacen: 4},
  { _id: 5, contenido: "Libros", valor: 150, almacen: 5},
  { _id: 6, contenido: "Accesorios", valor: 250, almacen: 1},
  { _id: 7, contenido: "Artículos de cocina", valor: 120, almacen: 2},
  { _id: 8, contenido: "Cosméticos", valor: 180, almacen: 3},
  { _id: 9, contenido: "Equipos deportivos", valor: 400, almacen: 4},
  { _id: 10, contenido: "Instrumentos musicales", valor: 350, almacen: 5}
]);