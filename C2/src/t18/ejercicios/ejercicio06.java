package t18.ejercicios;

import t18.conexiones.Conexion;

public class ejercicio06 {

	public static void main(String[] args) {
		Conexion c = new Conexion();
		String db = "`Piezas y Proveedores`";
		String tabla1 = "piezas", tabla2 = "proveedores", tabla3 = "suministra";
		String atributos1 = "(" + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  PRIMARY KEY (`codigo`)" + ")";
		String atributos2 = "(" + "  `id` char(4) NOT NULL,"
				+ "  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,"
				+ "  PRIMARY KEY (`id`)" + ")";
		String atributos3 = "(" + "  `codigo_pieza` int(11) NOT NULL," + "  `id_proveedor` char(4) NOT NULL,"
				+ "  `precio` int(11) DEFAULT NULL," + "  PRIMARY KEY (`codigo_pieza`,`id_proveedor`),"
				+ "  KEY `fk_proveedores_suministra` (`id_proveedor`),"
				+ "  CONSTRAINT `fk_piezas_suministra` FOREIGN KEY (`codigo_pieza`) REFERENCES `piezas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  CONSTRAINT `fk_proveedores_suministra` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		String values1 = "(`codigo`, `nombre`) VALUES" + "	(1, 'pieza1')," + "	(2, 'pieza2')," + "	(3, 'pieza3'),"
				+ "	(4, 'pieza4')," + "	(5, 'pieza5')," + "	(6, 'pieza6')," + "	(7, 'pieza7')," + "	(8, 'pieza8'),"
				+ "	(9, 'pieza9')," + "	(10, 'pieza10');";
		String values2 = "(`id`, `nombre`) VALUES" + "	('AA01', 'prov1')," + "	('AA02', 'prov2'),"
				+ "	('AA03', 'prov3')," + "	('AA04', 'prov4')," + "	('AA05', 'prov5')," + "	('AA06', 'prov6'),"
				+ "	('AA07', 'prov7')," + "	('AA08', 'prov8')," + "	('AA09', 'prov9')," + "	('AA10', 'prov10');";
		String values3 = "(`codigo_pieza`, `id_proveedor`, `precio`) VALUES" + "	(1, 'AA01', 10),"
				+ "	(2, 'AA02', 20)," + "	(3, 'AA03', 30)," + "	(4, 'AA04', 40)," + "	(5, 'AA05', 50),"
				+ "	(6, 'AA06', 60)," + "	(7, 'AA07', 70)," + "	(8, 'AA08', 80)," + "	(9, 'AA09', 90),"
				+ "	(10, 'AA10', 100);";

		c.createDB(db);

		c.createTable(db, tabla1, atributos1);
		c.insertData(db, tabla1, values1);

		c.createTable(db, tabla2, atributos2);
		c.insertData(db, tabla2, values2);

		c.createTable(db, tabla3, atributos3);
		c.insertData(db, tabla3, values3);

		c.closeConnection();
	}

}
