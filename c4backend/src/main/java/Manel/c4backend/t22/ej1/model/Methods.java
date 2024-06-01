package Manel.c4backend.t22.ej1.model;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.controller.Conexiones;

public class Methods {

	public static void crearBaseDatos(Conexiones c) {
		String db = "clientes";
		String tabla1 = "cliente";
		String atributos1 = Querys.defineClientTable();
		String tabla2 = "videos";
		String atributos2 = Querys.defineVideosTable();

		c.createDB(db);
		c.createTable(db, tabla1, atributos1);
		c.createTable(db, tabla2, atributos2);

		// String valuesClient = Querys.insertDefaultClientValues();
		// c.insertData(db, tabla, valuesClient);
		// String valuesVideos = Querys.insertDefaultVideoValues();
		// c.insertData(db, tabla2, valuesVideos);

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

	public static void generateVideosRows(ArrayList<Videos> videos, DefaultTableModel model) {

		int nColumnas = model.getRowCount();

		if (nColumnas > 0) {
			for (int i = 0; i < nColumnas; i++) {
				model.removeRow(0);
			}
		}

		for (int i = 0; i < videos.size(); i++) {
			Object[] o = new Object[6];
			if (videos.get(i).getId() != 0) {
				o[0] = videos.get(i).getId();

			} else {
				o[0] = null;

			}
			if (!videos.get(i).getTitle().equals("")) {
				o[1] = videos.get(i).getTitle();

			} else {
				o[1] = null;

			}
			if (!videos.get(i).getDirector().equals("")) {
				o[2] = videos.get(i).getDirector();

			} else {
				o[2] = null;

			}
			if (!videos.get(i).getClie_id().equals("")) {
				o[3] = videos.get(i).getClie_id();

			} else {
				o[3] = null;

			}

			model.addRow(o);
		}
	}
}
