package Manel.c4backend.t22.ej1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.model.Asignado;
import Manel.c4backend.t22.ej1.model.Cientificos;
import Manel.c4backend.t22.ej1.model.Cliente;
import Manel.c4backend.t22.ej1.model.Methods;
import Manel.c4backend.t22.ej1.model.Proyecto;
import Manel.c4backend.t22.ej1.model.Videos;
import Manel.c4backend.t22.ej1.view.*;

public class Listeners {

	public static void connectDb(JTextField tfUser, JPasswordField tfPassword) {
		String user = tfUser.getText();
		char[] charPw = tfPassword.getPassword();
		String password = new String(charPw);

		Conexiones c = new Conexiones(user, password);

		Methods.crearBaseDatos(c);
		SelectDbView sdv = new SelectDbView(c);

	}

	public static void selectDb(JComboBox<String> selectDb, Conexiones c) {
		String db = selectDb.getSelectedItem().toString();
		SelectTableView stv = new SelectTableView(c, db);
	}

	public static void selectTabla(JComboBox<String> selectTabla, Conexiones c, String db) {
		String tabla = selectTabla.getSelectedItem().toString();
		Startmenu sm = new Startmenu(c, tabla, db);
	}

	public static void selectMenu(JComboBox<String> selectMenu, Conexiones c, String tabla, String db) {
		String s = "";
		s = selectMenu.getSelectedItem().toString();

		if (s.equals("Insertar datos")) {

			if (db.equals("clientes")) {

				if (tabla.equals("Cliente")) {
					InsertClienteView icv = new InsertClienteView(c, tabla, db);

				} else if (tabla.equals("Videos")) {
					InsertVideosView ivv = new InsertVideosView(c, tabla, db);
				}

			} else if (db.equals("cientificos")) {

				if (tabla.equals("Cientificos")) {
					InsertCientificosView icv = new InsertCientificosView(c, tabla, db);

				} else if (tabla.equals("Proyecto")) {
					InsertProyectoView ipv = new InsertProyectoView(c, tabla, db);

				} else if (tabla.equals("Asignado a")) {
					InsertAsignadoaView iav = new InsertAsignadoaView(c, tabla, db);

				}
			}

		} else if (s.equals("Hacer consultas")) {
			SelectView sv = new SelectView(c, tabla, db);

		} else if (s.equals("Actualizar datos")) {
			UpdateView uv = new UpdateView(c, tabla, db);

		} else if (s.equals("Borrar datos")) {
			DeleteView dv = new DeleteView(c, tabla, db);

		}
	}

	public static void addClienteRegistro(JTextField tfNombre, JTextField tfApellido, JTextField tfDireccion,
			JTextField tfDni,
			JTextField tfFecha, Conexiones c) {
		String nombre = tfNombre.getText();
		String apellido = tfApellido.getText();
		String direccion = tfDireccion.getText();
		String dni = tfDni.getText();
		String fecha = tfFecha.getText();
		String s = "(`nombre`, `apellido`, `direccion`, `dni`, `fecha`) VALUES";
		s += "('" + nombre + "' , '" + apellido + "' , '" + direccion + "' , '" + dni + "' , '" + fecha + "');";

		c.insertData("clientes", "cliente", s);
	}

	public static void addVideosRegistro(JTextField tfTitulo, JTextField tfDirector, JComboBox<Integer> cbClientId,
			Conexiones c) {
		String titulo = tfTitulo.getText();
		String director = tfDirector.getText();
		int clientId = (int) cbClientId.getSelectedItem();
		String s = "(`title`, `director`, `cli_id`) VALUES";
		s += "('" + titulo + "' , '" + director + "' , " + clientId + ");";

		c.insertData("clientes", "videos", s);
	}

	public static void addCientificosRegistro(JTextField tfDni, JTextField tfNomApels, Conexiones c) {
		String dni = tfDni.getText();
		String nomApels = tfNomApels.getText();
		String s = "(`dni`, `nom_apels`) VALUES";
		s += "('" + dni + "' , '" + nomApels + "');";

		c.insertData("cientificos", "cientificos", s);
	}

	public static void addProyectoRegistro(JTextField tfId, JTextField tfNombre, JTextField tfHoras, Conexiones c) {
		String id = tfId.getText();
		String nombre = tfNombre.getText();
		int horas = Integer.parseInt(tfHoras.getText());
		String s = "(`id`, `nombre`, `horas`) VALUES";
		s += "('" + id + "' , '" + nombre + "' , " + horas + ");";

		c.insertData("cientificos", "proyecto", s);
	}

	public static void addAsignadoARegistro(JComboBox<String> cbCientifico, JComboBox<String> cbProyecto,
			Conexiones c) {
		String cientifico = cbCientifico.getSelectedItem().toString();
		String proyecto = cbProyecto.getSelectedItem().toString();
		String s = "(`cientifico`, `proyecto`) VALUES";
		s += "('" + cientifico + "' , '" + proyecto + "');";

		c.insertData("cientificos", "asignado_a", s);
	}

	public static void updateRegistro(JComboBox<Integer> selectNumberId, JComboBox<String> selectStringId,
			JComboBox<String> selectStringId2, JComboBox<String> selectAtributo,
			JTextField tfNuevoValor, Conexiones c, ArrayList<Cliente> clientes, ArrayList<Videos> videos,
			ArrayList<Cientificos> cientificos, ArrayList<Proyecto> proyectos, ArrayList<Asignado> asignados,
			DefaultTableModel model, String tabla, String db) {
		int numberId = 0;
		String stringId = "";
		String stringId2 = "";
		String atributo = selectAtributo.getSelectedItem().toString();
		String nuevoValor = tfNuevoValor.getText();

		if (selectNumberId != null) {
			numberId = (int) selectNumberId.getSelectedItem();
		}
		if (selectStringId != null) {
			stringId = selectStringId.getSelectedItem().toString();
		}
		if (selectStringId2 != null) {
			stringId2 = selectStringId2.getSelectedItem().toString();
		}

		String set = atributo + " = '" + nuevoValor + "'";
		String where = "";
		if (db.equals("clientes")) {
			where = "id = " + numberId;

		} else if (db.equals("cientificos")) {
			switch (tabla) {
				case "Cientificos":
					where = "dni = '" + stringId + "'";
					break;

				case "Proyecto":
					where = "id = '" + stringId + "'";
					break;

				case "asignado_a":
					where = "cientifico = '" + stringId + "' AND proyecto = '" + stringId2 + "'";
					break;

				default:
					break;
			}
		}

		List<String> select = new ArrayList<>();
		select.add("*");

		c.updateData(db, tabla, set, where);

		switch (db) {

			case "clientes":

				switch (tabla) {

					case "Cliente":
						clientes = c.selectClienteData("clientes", select, tabla, "", "", "", "");
						Methods.generateClientRows(clientes, model);
						break;

					case "Videos":
						videos = c.selectVideosData("clientes", select, tabla, "", "", "", "");
						Methods.generateVideosRows(videos, model);
						break;

					default:
						break;
				}

				break;

			case "cientificos":

				switch (tabla) {

					case "Cientificos":
						cientificos = c.selectCientificosData(db, select, tabla, "", "", "", "");
						Methods.generateCientificosRows(cientificos, model);
						break;

					case "Proyecto":
						proyectos = c.selectProyectoData(db, select, tabla, "", "", "", "");
						Methods.generateProyectoRows(proyectos, model);
						break;

					case "asignado_a":
						asignados = c.selectAsignadoData(db, select, tabla, "", "", "", "");
						Methods.generateAsignadoaRows(asignados, model);
						break;

					default:
						break;
				}

				break;
			default:
				break;
		}

	}

	public static void deleteRegistro(JComboBox<Integer> selectId, Conexiones c, ArrayList<Cliente> clientes,
			ArrayList<Videos> videos,
			DefaultTableModel model, String tabla) {
		String id = selectId.getSelectedItem().toString();
		String db = "clientes";

		List<String> select = new ArrayList<>();
		select.add("*");

		c.deleteData(db, tabla, id);

		if (tabla.equals("Cliente")) {
			clientes = c.selectClienteData(db, select, tabla, "", "", "", "id");
			Methods.generateClientRows(clientes, model);

		} else if (tabla.equals("Videos")) {
			videos = c.selectVideosData(db, select, tabla, "", "", "", "id");
			Methods.generateVideosRows(videos, model);

		}
	}

	public static void selectQuery(JTextField tfSelect, JTextField tfFrom, JTextField tfWhere, JTextField tfGroupBy,
			JTextField tfHaving, JTextField tfOrderBy, Conexiones c, ArrayList<Cliente> clientes,
			ArrayList<Videos> videos,
			DefaultTableModel model, String[] columnas) {
		String db = "clientes";
		String selectString = tfSelect.getText();
		List<String> select = Arrays.asList(selectString.split(", "));
		String from = tfFrom.getText();
		String where = tfWhere.getText();
		String groupBy = tfGroupBy.getText();
		String having = tfHaving.getText();
		String orderBy = tfOrderBy.getText();

		if (from.equals("Cliente")) {
			clientes = c.selectClienteData(db, select, from, where, groupBy, having, orderBy);
			Methods.generateClientRows(clientes, model);

		} else if (from.equals("Videos")) {
			videos = c.selectVideosData(db, select, from, where, groupBy, having, orderBy);
			Methods.generateVideosRows(videos, model);
		}

	}

}
