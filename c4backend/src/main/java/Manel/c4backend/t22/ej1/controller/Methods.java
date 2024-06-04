package Manel.c4backend.t22.ej1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.model.*;

public class Methods {

	public static void crearBaseDatos(Conexiones c) {
		String dbClientes = "clientes";
		String tablaCliente = "cliente";
		String atributosCliente = Querys.defineClientTable();
		String tablaVideos = "videos";
		String atributosVideos = Querys.defineVideosTable();
		
		String dbCientificos = "cientificos";
		String tablaCientificos = "cientificos";
		String atributosCientificos = Querys.defineClientTable();
		String tablaProyecto = "proyecto";
		String atributosProyecto = Querys.defineVideosTable();
		String tablaAsignadoa = "asignado_a";
		String atributosAsignadoa = Querys.defineVideosTable();

		c.createDB(dbClientes);
		c.createTable(dbClientes, tablaCliente, atributosCliente);
		c.createTable(dbClientes, tablaVideos, atributosVideos);
		
		c.createDB(dbCientificos);
		c.createTable(dbCientificos, tablaCientificos, atributosCientificos);
		c.createTable(dbCientificos, tablaProyecto, atributosProyecto);
		c.createTable(dbCientificos, tablaAsignadoa, atributosAsignadoa);
		
//		 String valuesClient = Querys.insertDefaultClientValues();
//		 c.insertData(db, tabla, valuesClient);
//		 String valuesVideos = Querys.insertDefaultVideoValues();
//		 c.insertData(dbClientes, tablaVideos, valuesVideos);

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
			Object[] o = new Object[4];
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
			if (videos.get(i).getClie_id() != 0) {
				o[3] = videos.get(i).getClie_id();

			} else {
				o[3] = null;

			}

			model.addRow(o);
		}
	}

	public static void generateCientificosRows(ArrayList<Cientificos> cientificos, DefaultTableModel model) {

		int nColumnas = model.getRowCount();

		if (nColumnas > 0) {
			for (int i = 0; i < nColumnas; i++) {
				model.removeRow(0);
			}
		}

		for (int i = 0; i < cientificos.size(); i++) {
			Object[] o = new Object[2];
			if (!cientificos.get(i).getDni().equals("")) {
				o[0] = cientificos.get(i).getDni();

			} else {
				o[0] = null;

			}
			if (!cientificos.get(i).getNomApels().equals("")) {
				o[1] = cientificos.get(i).getNomApels();

			} else {
				o[1] = null;

			}

			model.addRow(o);
		}
	}

	public static void generateProyectoRows(ArrayList<Proyecto> proyecto, DefaultTableModel model) {

		int nColumnas = model.getRowCount();

		if (nColumnas > 0) {
			for (int i = 0; i < nColumnas; i++) {
				model.removeRow(0);
			}
		}

		for (int i = 0; i < proyecto.size(); i++) {
			Object[] o = new Object[3];
			if (!proyecto.get(i).getId().equals("")) {
				o[0] = proyecto.get(i).getId();

			} else {
				o[0] = null;

			}
			if (!proyecto.get(i).getNombre().equals("")) {
				o[1] = proyecto.get(i).getNombre();

			} else {
				o[1] = null;

			}
			if (proyecto.get(i).getHoras() != 0) {
				o[2] = proyecto.get(i).getHoras();

			} else {
				o[2] = null;

			}

			model.addRow(o);
		}
	}

	public static void generateAsignadoaRows(ArrayList<Asignado> asignados, DefaultTableModel model) {

		int nColumnas = model.getRowCount();

		if (nColumnas > 0) {
			for (int i = 0; i < nColumnas; i++) {
				model.removeRow(0);
			}
		}

		for (int i = 0; i < asignados.size(); i++) {
			Object[] o = new Object[2];
			if (!asignados.get(i).getCientifico().equals("")) {
				o[0] = asignados.get(i).getCientifico();

			} else {
				o[0] = null;

			}
			if (!asignados.get(i).getProyecto().equals("")) {
				o[1] = asignados.get(i).getProyecto();

			} else {
				o[1] = null;

			}

			model.addRow(o);
		}
	}

	public static void generateIdComboBox(JComboBox<Integer> selectNumberId, JComboBox<String> selectStringId,
			JComboBox<String> selectStringId2, ArrayList<Cliente> clientes, ArrayList<Videos> videos,
			ArrayList<Cientificos> cientificos, ArrayList<Proyecto> proyectos, ArrayList<Asignado> asignados, String db,
			String tabla, Conexiones c, JPanel jp, int x) {

		List<String> select = new ArrayList<>();
		select.add("*");
		
		switch (db) {

			case "clientes":

				switch (tabla) {

					case "Cliente":
						for (int i = 0; i < clientes.size(); i++) {
							selectNumberId.addItem(clientes.get(i).getId());
						}
						break;

					case "Videos":
						for (int i = 0; i < videos.size(); i++) {
							selectNumberId.addItem(videos.get(i).getId());
						}
						break;

					default:
						break;
				}

				selectNumberId.setBounds(x, 250, 50, 20);
				jp.add(selectNumberId);

				break;

			case "cientificos":

				boolean dobleId = false;

				switch (tabla) {

					case "Cientificos":
						for (int i = 0; i < cientificos.size(); i++) {
							selectStringId.addItem(cientificos.get(i).getDni());
						}
						break;

					case "Proyecto":
						for (int i = 0; i < proyectos.size(); i++) {
							selectStringId.addItem(proyectos.get(i).getId());
						}
						break;

					case "Asignado a":
						asignados = c.selectAsignadoData(db, select, "asignado_a", "", "cientifico", "", "");

						for (int i = 0; i < asignados.size(); i++) {
							selectStringId.addItem(asignados.get(i).getCientifico());
						}

						asignados = c.selectAsignadoData(db, select, "asignado_a", "", "proyecto", "", "");

						for (int i = 0; i < asignados.size(); i++) {
							selectStringId2.addItem(asignados.get(i).getProyecto());
						}

						dobleId = true;
						break;

					default:
						break;
				}

				selectStringId.setBounds(x, 250, 70, 20);
				jp.add(selectStringId);

				if (dobleId) {
					selectStringId2.setBounds(x, 250, 70, 20);
					selectStringId.setBounds(x, 280, 90, 20);
					jp.add(selectStringId2);
					dobleId = false;
				}

				break;
			default:
				break;
		}
	}
}
