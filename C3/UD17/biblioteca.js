use biblioteca;
db.createCollection("libros");

db.libros.insertOne({
    "Título": "El nombre del viento",
    "Fecha de lanzamiento": ISODate("2007-03-27"),
    "Autor": "Patrick Rothfuss",
    "Categoría": "Fantasía",
    "Editorial": "DAW Books",
    "Idioma": "Español",
    "Páginas": 662,
    "Descripción": "Una novela de fantasía épica sobre el viaje del héroe Kvothe.",
    "Portada": "url_a_la_imagen.jpg"
});