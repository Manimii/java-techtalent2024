package Manel.c4backend.t22.ej1.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.controller.Conexiones;

public class Methods {

	public static void crearBaseDatos(Conexiones c) {
		String db = "clientes";
		String tabla = "cliente";
		String atributos = Querys.defineClientTable();
		// String values = Querys.insertDefaultClientValues();

		c.createDB(db);
		c.createTable(db, tabla, atributos);
		// c.insertData(db, tabla, values);
	}

	public static void generateClientRows(ArrayList<Cliente> clientes, DefaultTableModel model) {

		int nColumnas = model.getRowCount();
		int countElements = 0;
		boolean hasId = false, hasNombre = false, hasApellido = false, hasDireccion = false, hasDni = false,
				hasFecha = false;

		if (nColumnas > 0) {
			for (int i = 0; i < nColumnas; i++) {
				model.removeRow(0);
			}
		}

		for (int i = 0; i < clientes.size(); i++) {
			Object[] o = new Object[6];
			if (clientes.get(i).getId() != 0) {
				o[0] = clientes.get(i).getId();

			} else {
				o[0] = null;

			}
			if (!clientes.get(i).getNombre().equals("")) {
				o[1] = clientes.get(i).getNombre();

			} else {
				o[1] = null;

			}
			if (!clientes.get(i).getApellido().equals("")) {
				o[2] = clientes.get(i).getApellido();

			} else {
				o[2] = null;

			}
			if (!clientes.get(i).getDireccion().equals("")) {
				o[3] = clientes.get(i).getDireccion();

			} else {
				o[3] = null;

			}
			if (clientes.get(i).getDni() != 0) {
				o[4] = clientes.get(i).getDni();

			} else {
				o[4] = null;

			}
			if (clientes.get(i).getFecha() != null) {
				o[5] = clientes.get(i).getFecha();

			} else {
				o[5] = null;

			}

			model.addRow(o);
		}
	}
}
