use piezas_proveedores;

db.createCollection("piezas");

db.piezas.insertMany([
  { _id: 1, nombre: "Tornillo" },
  { _id: 2, nombre: "Tuerca" },
  { _id: 3, nombre: "Arandela" },
  { _id: 4, nombre: "Remache" },
  { _id: 5, nombre: "Resorte" }
]);

db.createCollection("proveedores");

db.proveedores.insertMany([
  { _id: 1, nombre: "Proveedor A" },
  { _id: 2, nombre: "Proveedor B" },
  { _id: 3, nombre: "Proveedor C" },
  { _id: 4, nombre: "Proveedor D" },
  { _id: 5, nombre: "Proveedor E" }
]);

db.createCollection("suministra");

db.suministra.insertMany([
  { _idPieza: 1, _idProveedor: 1, precio: 10.5 },
  { _idPieza: 2, _idProveedor: 2, precio: 8.75 },
  { _idPieza: 3, _idProveedor: 3, precio: 12.0 },
  { _idPieza: 4, _idProveedor: 4, precio: 9.99 },
  { _idPieza: 5, _idProveedor: 5, precio: 11.25 },
  { _idPieza: 1, _idProveedor: 2, precio: 9.0 },
  { _idPieza: 2, _idProveedor: 3, precio: 10.25 },
  { _idPieza: 3, _idProveedor: 4, precio: 8.5 },
  { _idPieza: 4, _idProveedor: 5, precio: 12.75 },
  { _idPieza: 5, _idProveedor: 1, precio: 11.0 }
]);