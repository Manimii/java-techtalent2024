package t18.ejercicios;

import t18.conexiones.Conexion;

public class ejercicio09 {

	public static void main(String[] args) {
		Conexion c = new Conexion();
		String db = "`Los Investigadores`";
		String tabla1 = "facultad", tabla2 = "investigadores", tabla3 = "equipos", tabla4 = "reserva";
		String atributos1 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  PRIMARY KEY (`codigo`)" + ")";
		String atributos2 = "(" + "  `dni` varchar(8) NOT NULL,"
				+ "  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  `facultad` int(11) DEFAULT NULL," + "  PRIMARY KEY (`dni`),"
				+ "  KEY `fk_facultad_investigadores` (`facultad`),"
				+ "  CONSTRAINT `fk_facultad_investigadores` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		String atributos3 = "(" + "  `num_serie` char(4) NOT NULL,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  `facultad` int(11) DEFAULT NULL," + "  PRIMARY KEY (`num_serie`),"
				+ "  KEY `fk_facultad_equipos` (`facultad`),"
				+ "  CONSTRAINT `fk_facultad_equipos` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		String atributos4 = "(" + "  `dni` varchar(8) NOT NULL," + "  `num_serie` char(4) NOT NULL,"
				+ "  `comienzo` datetime DEFAULT NULL," + "  `fin` datetime DEFAULT NULL,"
				+ "  PRIMARY KEY (`dni`,`num_serie`)," + "  KEY `fk_equipos_reserva` (`num_serie`),"
				+ "  CONSTRAINT `fk_equipos_reserva` FOREIGN KEY (`num_serie`) REFERENCES `equipos` (`num_serie`) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  CONSTRAINT `fk_investigadores_reserva` FOREIGN KEY (`dni`) REFERENCES `investigadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		String values1 = "(`codigo`, `nombre`) VALUES" + "	(1, 'f1')," + "	(2, 'f2')," + "	(3, 'f3')," + "	(4, 'f4'),"
				+ "	(5, 'f5')," + "	(6, 'f6')," + "	(7, 'f7')," + "	(8, 'f8')," + "	(9, 'f9')," + "	(10, 'f10');";
		String values2 = "(`dni`, `nom_apels`, `facultad`) VALUES" + "	('0672523P', 'francisco', 5),"
				+ "	('0827137K', 'pedro', 3)," + "	('3287390R', 'maria', 2)," + "	('3374683Z', 'javier', 9),"
				+ "	('5478699Y', 'carlos', 7)," + "	('7305597S', 'montse', 10)," + "	('7357072Y', 'rosa', 8),"
				+ "	('7845859G', 'cristina', 4)," + "	('7869261K', 'juan', 1)," + "	('9861511N', 'ana', 6);";
		String values3 = "(`num_serie`, `nombre`, `facultad`) VALUES" + "	('E001', 'e1', 1)," + "	('E002', 'e2', 2),"
				+ "	('E003', 'e3', 3)," + "	('E004', 'e4', 4)," + "	('E005', 'e5', 5)," + "	('E006', 'e6', 6),"
				+ "	('E007', 'e7', 7)," + "	('E008', 'e8', 8)," + "	('E009', 'e9', 9)," + "	('E010', 'e10', 10);";
		String values4 = "(`dni`, `num_serie`, `comienzo`, `fin`) VALUES"
				+ "	('0672523P', 'E005', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('0827137K', 'E003', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('3287390R', 'E002', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('3374683Z', 'E009', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('5478699Y', 'E007', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('7305597S', 'E010', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('7357072Y', 'E008', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('7845859G', 'E004', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('7869261K', 'E001', '2024-04-16 00:00:00', '2024-04-26 00:00:00'),"
				+ "	('9861511N', 'E006', '2024-04-16 00:00:00', '2024-04-26 00:00:00');";

		c.createDB(db);

		c.createTable(db, tabla1, atributos1);
		c.insertData(db, tabla1, values1);

		c.createTable(db, tabla2, atributos2);
		c.insertData(db, tabla2, values2);

		c.createTable(db, tabla3, atributos3);
		c.insertData(db, tabla3, values3);

		c.createTable(db, tabla4, atributos4);
		c.insertData(db, tabla4, values4);

		c.closeConnection();
	}

}
