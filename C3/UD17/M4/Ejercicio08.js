use investigadores;

db.createCollection("facultad");

db.facultad.insertMany([
  { _id: 1, nombre: "Facultad de Ciencias Naturales" },
  { _id: 2, nombre: "Facultad de Ingeniería" },
  { _id: 3, nombre: "Facultad de Ciencias Sociales" },
  { _id: 4, nombre: "Facultad de Medicina" },
  { _id: 5, nombre: "Facultad de Artes y Humanidades" }
]);

db.createCollection("investigadores");

db.investigadores.insertMany([
  { _id: 1, DNI: "12345678A", nomApels: "Juan Martínez", Facultad: 2 },
  { _id: 2, DNI: "23456789B", nomApels: "María García", Facultad: 1 },
  { _id: 3, DNI: "34567890C", nomApels: "Pedro López", Facultad: 3 },
  { _id: 4, DNI: "45678901D", nomApels: "Ana Ruiz", Facultad: 4 },
  { _id: 5, DNI: "56789012E", nomApels: "Carlos Sánchez", Facultad: 5 },
  { _id: 6, DNI: "67890123F", nomApels: "Laura Martín", Facultad: 2 },
  { _id: 7, DNI: "78901234G", nomApels: "David García", Facultad: 3 },
  { _id: 8, DNI: "89012345H", nomApels: "Elena Pérez", Facultad: 4 },
  { _id: 9, DNI: "90123456I", nomApels: "Javier Ruiz", Facultad: 1 },
  { _id: 10, DNI: "01234567J", nomApels: "Sara López", Facultad: 5 }
]);

db.createCollection("equipos");

db.equipos.insertMany([
  { _id: 1, numSerie: 1001, nombre: "Equipo 1", Facultad: 2 },
  { _id: 2, numSerie: 1002, nombre: "Equipo 2", Facultad: 1 },
  { _id: 3, numSerie: 1003, nombre: "Equipo 3", Facultad: 3 },
  { _id: 4, numSerie: 1004, nombre: "Equipo 4", Facultad: 4 },
  { _id: 5, numSerie: 1005, nombre: "Equipo 5", Facultad: 5 },
  { _id: 6, numSerie: 1006, nombre: "Equipo 6", Facultad: 2 },
  { _id: 7, numSerie: 1007, nombre: "Equipo 7", Facultad: 3 },
  { _id: 8, numSerie: 1008, nombre: "Equipo 8", Facultad: 4 },
  { _id: 9, numSerie: 1009, nombre: "Equipo 9", Facultad: 1 },
  { _id: 10, numSerie: 1010, nombre: "Equipo 10", Facultad: 5 }
]);

db.createCollection("reserva");

db.reserva.insertMany([
  { DNI: "12345678A", numSerie: 1001, comienzo: new Date("2024-05-10"), Fin: new Date("2024-05-12") },
  { DNI: "23456789B", numSerie: 1002, comienzo: new Date("2024-05-11"), Fin: new Date("2024-05-13") },
  { DNI: "34567890C", numSerie: 1003, comienzo: new Date("2024-05-12"), Fin: new Date("2024-05-14") },
  { DNI: "45678901D", numSerie: 1004, comienzo: new Date("2024-05-13"), Fin: new Date("2024-05-15") },
  { DNI: "56789012E", numSerie: 1005, comienzo: new Date("2024-05-14"), Fin: new Date("2024-05-16") },
  { DNI: "67890123F", numSerie: 1006, comienzo: new Date("2024-05-15"), Fin: new Date("2024-05-17") },
  { DNI: "78901234G", numSerie: 1007, comienzo: new Date("2024-05-16"), Fin: new Date("2024-05-18") },
  { DNI: "89012345H", numSerie: 1008, comienzo: new Date("2024-05-17"), Fin: new Date("2024-05-19") },
  { DNI: "90123456I", numSerie: 1009, comienzo: new Date("2024-05-18"), Fin: new Date("2024-05-20") },
  { DNI: "01234567J", numSerie: 1010, comienzo: new Date("2024-05-19"), Fin: new Date("2024-05-21") }
]);