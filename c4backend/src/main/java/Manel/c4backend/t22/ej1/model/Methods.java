package Manel.c4backend.t22.ej1.model;

import Manel.c4backend.t22.ej1.controller.Conexiones;

public class Methods {

	public static void crearBaseDatos(Conexiones c) {
		String db = "clientes";
		String tabla = "cliente";
		String atributos = Querys.defineClientTable();
		String values = Querys.insertDefaultClientValues();

		c.createDB(db);
		c.createTable(db, tabla, atributos);
		//c.insertData(db, tabla, values);
	}
}
