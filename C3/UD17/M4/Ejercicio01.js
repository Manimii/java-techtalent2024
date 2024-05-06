use tienda_informatica;

db.createCollection("fabricantes");

// Insertar 10 documentos en la colección de fabricantes con nombres reales
db.fabricantes.insertMany([
  {_id: 1, nombre: "Sony" },
  {_id: 2, nombre: "Samsung" },
  {_id: 3, nombre: "Apple" },
  {_id: 4, nombre: "Microsoft" },
  {_id: 5, nombre: "Nike" },
  {_id: 6, nombre: "Adidas" },
  {_id: 7, nombre: "LG" },
  {_id: 8, nombre: "Panasonic" },
  {_id: 9, nombre: "Canon" },
  {_id: 10, nombre: "HP" }
]);

db.createCollection("articulos");

db.articulos.insertMany([
  { _id: 1, nombre: "Televisor LED 4K 55 pulgadas", precio: 799, fabricante: 1 },
  { _id: 2, nombre: "Smartphone Galaxy S21 Ultra", precio: 1199, fabricante: 2 },
  { _id: 3, nombre: "MacBook Pro 13 pulgadas", precio: 1499, fabricante: 3 },
  { _id: 4, nombre: "Surface Laptop 4", precio: 1099, fabricante: 4 },
  { _id: 5, nombre: "Zapatillas Air Max 270", precio: 150, fabricante: 5 },
  { _id: 6, nombre: "Chaqueta cortavientos Essentials", precio: 80, fabricante: 6 },
  { _id: 7, nombre: "Lavadora de carga frontal 10 kg", precio: 699, fabricante: 7 },
  { _id: 8, nombre: "Cámara EOS Rebel T7i", precio: 649, fabricante: 8 },
  { _id: 9, nombre: "Impresora multifunción OfficeJet Pro 9025", precio: 249, fabricante: 9 },
  { _id: 10, nombre: "Monitor 27 pulgadas 4K", precio: 399, fabricante: 10 }
]);