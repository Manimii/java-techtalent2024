package Manel.c4backend.t22.ej1.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.controller.Conexiones;

public class Methods {

	public static void crearBaseDatos(Conexiones c) {
		String db = "clientes";
		String tabla = "cliente";
		String atributos = Querys.defineClientTable();
		String values = Querys.insertDefaultClientValues();

		c.createDB(db);
		c.createTable(db, tabla, atributos);
		// c.insertData(db, tabla, values);
	}

	public static void generateClientRows(ArrayList<Cliente> clientes, DefaultTableModel model) {
		
		int nColumnas = model.getRowCount();

		if (nColumnas > 0) {
			for (int i = 0; i < nColumnas; i++) {
				model.removeRow(0);
			}
		}

		for (int i = 0; i < clientes.size(); i++) {
			Object[] o = new Object[6];
			o[0] = clientes.get(i).getId();
			o[1] = clientes.get(i).getNombre();
			o[2] = clientes.get(i).getApellido();
			o[3] = clientes.get(i).getDireccion();
			o[4] = clientes.get(i).getDni();
			o[5] = clientes.get(i).getFecha();
			model.addRow(o);
		}
	}
}
