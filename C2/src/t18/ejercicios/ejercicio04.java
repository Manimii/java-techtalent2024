package t18.ejercicios;

import t18.conexiones.Conexion;

public class ejercicio04 {

	public static void main(String[] args) {
		Conexion c = new Conexion();
		String db = "`Peliculas y Salas`";
		String tabla1 = "peliculas", tabla2 = "salas";
		String atributos1 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  `calificacion_edad` int(11) DEFAULT NULL," + "  PRIMARY KEY (`codigo`)" + ")";
		String atributos2 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  `pelicula` int(11) DEFAULT NULL," + "  PRIMARY KEY (`codigo`),"
				+ "  KEY `fk_salas_peliculas` (`pelicula`),"
				+ "  CONSTRAINT `fk_salas_peliculas` FOREIGN KEY (`pelicula`) REFERENCES `peliculas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		String values1 = "(`codigo`, `nombre`, `calificacion_edad`) VALUES" + "	(1, 'El Padrino', 18),"
				+ "	(2, 'Titanic', 12)," + "	(3, 'El Señor de los Anillos: La Comunidad del Anillo', 12),"
				+ "	(4, 'La La Land', 10)," + "	(5, 'Parásitos', 16),"
				+ "	(6, 'Harry Potter y la Piedra Filosofal', 10)," + "	(7, 'Forrest Gump', 12),"
				+ "	(8, 'Pulp Fiction', 18)," + "	(9, 'Coco', 6)," + "	(10, 'El Rey León', 6),"
				+ "	(11, 'Interstellar', 13)," + "	(12, 'Uno, Dos, Tres', 7);";
		String values2 = "(`codigo`, `nombre`, `pelicula`) VALUES" + "	(1, 'Sala 1', 1)," + "	(2, 'Sala 2', 2),"
				+ "	(3, 'Sala 3', 3)," + "	(4, 'Sala 4', 4)," + "	(5, 'Sala 5', 5)," + "	(6, 'Sala 6', 6),"
				+ "	(7, 'Sala 7', 7)," + "	(8, 'Sala 8', 8)," + "	(9, 'Sala 9', 9)," + "	(10, 'Sala 10', 10),"
				+ "	(11, 'Sala 11', NULL);" + "";

		c.createDB(db);

		c.createTable(db, tabla1, atributos1);
		c.insertData(db, tabla1, values1);

		c.createTable(db, tabla2, atributos2);
		c.insertData(db, tabla2, values2);

		c.closeConnection();
	}
}
