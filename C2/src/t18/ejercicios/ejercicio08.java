package t18.ejercicios;

import t18.conexiones.Conexion;

public class ejercicio08 {

	public static void main(String[] args) {
		Conexion c = new Conexion();
		String db = "`Los Grandes Almacenes`";
		String tabla1 = "cajeros", tabla2 = "productos", tabla3 = "maquinas_registradoras", tabla4 = "venta";
		String atributos1 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `nom_apels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  PRIMARY KEY (`codigo`)" + ")";
		String atributos2 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  `precio` int(11) DEFAULT NULL," + "  PRIMARY KEY (`codigo`)" + ")";
		String atributos3 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT," + "  `piso` int(11) DEFAULT NULL,"
				+ "  PRIMARY KEY (`codigo`)" + ")";
		String atributos4 = "(" + "  `cajero` int(11) NOT NULL," + "  `maquina` int(11) NOT NULL,"
				+ "  `producto` int(11) NOT NULL," + "  PRIMARY KEY (`cajero`,`maquina`,`producto`),"
				+ "  KEY `fk_maquina_venta` (`maquina`)," + "  KEY `fk_producto_venta` (`producto`),"
				+ "  CONSTRAINT `fk_cajero_venta` FOREIGN KEY (`cajero`) REFERENCES `cajeros` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  CONSTRAINT `fk_maquina_venta` FOREIGN KEY (`maquina`) REFERENCES `maquinas_registradoras` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  CONSTRAINT `fk_producto_venta` FOREIGN KEY (`producto`) REFERENCES `productos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		String values1 = "(`codigo`, `nom_apels`) VALUES" + "	(1, 'c1')," + "	(2, 'c2')," + "	(3, 'c3'),"
				+ "	(4, 'c4')," + "	(5, 'c5')," + "	(6, 'c6')," + "	(7, 'c7')," + "	(8, 'c8')," + "	(9, 'c9'),"
				+ "	(10, 'c10');";
		String values2 = "(`codigo`, `nombre`, `precio`) VALUES" + "	(1, 'p1', 10)," + "	(2, 'p2', 20),"
				+ "	(3, 'p3', 30)," + "	(4, 'p4', 40)," + "	(5, 'p5', 50)," + "	(6, 'p6', 60)," + "	(7, 'p7', 70),"
				+ "	(8, 'p8', 80)," + "	(9, 'p9', 90)," + "	(10, 'p10', 100);";
		String values3 = "(`codigo`, `piso`) VALUES" + "	(1, 1)," + "	(2, 2)," + "	(3, 3)," + "	(4, 4),"
				+ "	(5, 5)," + "	(6, 6)," + "	(7, 7)," + "	(8, 8)," + "	(9, 9)," + "	(10, 10);";
		String values4 = "(`cajero`, `maquina`, `producto`) VALUES" + "	(1, 1, 1)," + "	(2, 2, 2)," + "	(3, 3, 3),"
				+ "	(4, 4, 4)," + "	(5, 5, 5)," + "	(6, 6, 6)," + "	(7, 7, 7)," + "	(8, 8, 8)," + "	(9, 9, 9),"
				+ "	(10, 10, 10);";

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
