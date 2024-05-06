use grandes_almacenes;

db.createCollection("cajeros");

db.cajeros.insertMany([
  { _id: 1, nomApels: "Juan Pérez" },
  { _id: 2, nomApels: "María García" },
  { _id: 3, nomApels: "Pedro López" },
  { _id: 4, nomApels: "Ana Ruiz" },
  { _id: 5, nomApels: "Carlos Sánchez" }
]);

db.createCollection("productos");

db.productos.insertMany([
  { _id: 1, nombre: "Camiseta", precio: 19.99 },
  { _id: 2, nombre: "Pantalón", precio: 29.99 },
  { _id: 3, nombre: "Zapatos", precio: 39.99 },
  { _id: 4, nombre: "Bufanda", precio: 9.99 },
  { _id: 5, nombre: "Gorra", precio: 14.99 }
]);

db.createCollection("maquinas_registradoras");

db.maquinas_registradoras.insertMany([
  { _id: 1, piso: 1 },
  { _id: 2, piso: 1 },
  { _id: 3, piso: 2 },
  { _id: 4, piso: 2 },
  { _id: 5, piso: 3 }
]);

db.createCollection("venta");

db.venta.insertMany([
  { _idCajero: 1, _idMaquina: 1, _idProducto: 1 },
  { _idCajero: 2, _idMaquina: 2, _idProducto: 2 },
  { _idCajero: 3, _idMaquina: 3, _idProducto: 3 },
  { _idCajero: 4, _idMaquina: 4, _idProducto: 4 },
  { _idCajero: 5, _idMaquina: 5, _idProducto: 5 },
  { _idCajero: 1, _idMaquina: 2, _idProducto: 3 },
  { _idCajero: 2, _idMaquina: 3, _idProducto: 4 },
  { _idCajero: 3, _idMaquina: 4, _idProducto: 5 },
  { _idCajero: 4, _idMaquina: 5, _idProducto: 1 },
  { _idCajero: 5, _idMaquina: 1, _idProducto: 2 }
]);