use cientificos;

db.createCollection("cientificos");

db.cientificos.insertMany([
  { DNI: "12345678A", nomApels: "Juan Martínez" },
  { DNI: "23456789B", nomApels: "María García" },
  { DNI: "34567890C", nomApels: "Pedro López" },
  { DNI: "45678901D", nomApels: "Ana Ruiz" },
  { DNI: "56789012E", nomApels: "Carlos Sánchez" }
]);

db.createCollection("proyecto");

db.proyecto.insertMany([
  { _id: "P001", nombre: "Proyecto A", horas: 120 },
  { _id: "P002", nombre: "Proyecto B", horas: 80 },
  { _id: "P003", nombre: "Proyecto C", horas: 200 },
  { _id: "P004", nombre: "Proyecto D", horas: 150 },
  { _id: "P005", nombre: "Proyecto E", horas: 100 }
]);

db.createCollection("asignado_a");

db.asignado_a.insertMany([
  { DNI: "12345678A", _idProyecto: "P001" },
  { DNI: "23456789B", _idProyecto: "P002" },
  { DNI: "34567890C", _idProyecto: "P003" },
  { DNI: "45678901D", _idProyecto: "P004" },
  { DNI: "56789012E", _idProyecto: "P005" },
  { DNI: "67890123F", _idProyecto: "P001" },
  { DNI: "78901234G", _idProyecto: "P002" },
  { DNI: "89012345H", _idProyecto: "P003" },
  { DNI: "90123456I", _idProyecto: "P004" },
  { DNI: "01234567J", _idProyecto: "P005" }
]);
