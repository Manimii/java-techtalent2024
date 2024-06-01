package Manel.c4backend.t22.ej1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.model.Cliente;
import Manel.c4backend.t22.ej1.model.Methods;
import Manel.c4backend.t22.ej1.model.Videos;
import Manel.c4backend.t22.ej1.view.*;

public class Listeners {

	public static void connectDb(JTextField tfUser, JPasswordField tfPassword) {
		String user = tfUser.getText();
		char[] charPw = tfPassword.getPassword();
		String password = new String(charPw);

		Conexiones c = new Conexiones(user, password);

		Methods.crearBaseDatos(c);
		SelectTableView stv = new SelectTableView(c);

	}

	public static void selectTabla(JComboBox<String> selectTabla, Conexiones c) {
		String tabla = selectTabla.getSelectedItem().toString();
		Startmenu sm = new Startmenu(c, tabla);
	}

	public static void selectMenu(JComboBox<String> selectMenu, JFrame frame, Conexiones c, String tabla) {
		String s = "";
		s = selectMenu.getSelectedItem().toString();
		frame.dispose();

		if (s.equals("Insertar datos")) {
			if (tabla.equals("Cliente")) {
				InsertClienteView icv = new InsertClienteView(c, tabla);

			} else if (tabla.equals("Videos")) {
				InsertVideosView ivv = new InsertVideosView(c, tabla);

			}

		} else if (s.equals("Hacer consultas")) {
			SelectView sv = new SelectView(c, tabla);

		} else if (s.equals("Actualizar datos")) {
			UpdateView uv = new UpdateView(c, tabla);

		} else if (s.equals("Borrar datos")) {
			DeleteView dv = new DeleteView(c, tabla);

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

	public static void updateRegistro(JComboBox<Integer> selectId, JComboBox<String> selectAtributo,
			JTextField tfNuevoValor, Conexiones c, ArrayList<Cliente> clientes,  ArrayList<Videos> videos, DefaultTableModel model, String tabla) {
		int id = (int) selectId.getSelectedItem();
		String atributo = selectAtributo.getSelectedItem().toString();
		String nuevoValor = tfNuevoValor.getText();

		String db = "clientes";
		String set = atributo + " = '" + nuevoValor + "'";
		String where = "id = " + id;

		List<String> select = new ArrayList<>();
		select.add("*");

		c.updateData(db, tabla, set, where);

		if (tabla.equals("Cliente")) {
			clientes = c.selectClienteData(db, select, tabla, "", "", "", "id");
			Methods.generateClientRows(clientes, model);

		} else if (tabla.equals("Videos")) {
			videos = c.selectVideosData(db, select, tabla, "", "", "", "id");
			Methods.generateVideosRows(videos, model);

		}
		
	}

	public static void deleteRegistro(JComboBox<Integer> selectId, Conexiones c, ArrayList<Cliente> clientes, ArrayList<Videos> videos, 
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
			JTextField tfHaving, JTextField tfOrderBy, Conexiones c, ArrayList<Cliente> clientes, ArrayList<Videos> videos,
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
