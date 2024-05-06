use cine;

db.createCollection("peliculas");

db.peliculas.insertMany([
  { _id: 1, nombre: "Titanic", calificacionEdad: 13 },
  { _id: 2, nombre: "El Padrino", calificacionEdad: 18 },
  { _id: 3, nombre: "Toy Story", calificacionEdad: 0 },
  { _id: 4, nombre: "Jurassic Park", calificacionEdad: 13 },
  { _id: 5, nombre: "Harry Potter y la Piedra Filosofal", calificacionEdad: 7 }
]);

db.createCollection("salas");

db.salas.insertMany([
  { _id: 1, nombre: "Sala 1", pelicula: 1 },
  { _id: 2, nombre: "Sala 2", pelicula: 2 },
  { _id: 3, nombre: "Sala 3", pelicula: 3 },
  { _id: 4, nombre: "Sala 4", pelicula: 4 },
  { _id: 5, nombre: "Sala 5", pelicula: 5 },
  { _id: 6, nombre: "Sala 6", pelicula: 1 },
  { _id: 7, nombre: "Sala 7", pelicula: 2 },
  { _id: 8, nombre: "Sala 8", pelicula: 3 },
  { _id: 9, nombre: "Sala 9", pelicula: 4 },
  { _id: 10, nombre: "Sala 10", pelicula: 5 }
]);