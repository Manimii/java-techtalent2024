package Manel.c4backend.t22.ej1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.model.Cliente;
import Manel.c4backend.t22.ej1.model.Methods;
import Manel.c4backend.t22.ej1.view.*;

public class Listeners {

	public static void selectMenu(JComboBox<String> selectMenu, JFrame frame, Conexiones c) {
		String s = "";
		s = selectMenu.getSelectedItem().toString();
		frame.dispose();

		if (s.equals("Insertar datos")) {
			InsertView iv = new InsertView(c);

		} else if (s.equals("Hacer consultas")) {
			SelectView sv = new SelectView(c);

		} else if (s.equals("Actualizar datos")) {
			UpdateView uv = new UpdateView(c);

		} else if (s.equals("Borrar datos")) {
			DeleteView dv = new DeleteView(c);

		}
	}

	public static void addRegistro(JTextField tfNombre, JTextField tfApellido, JTextField tfDireccion, JTextField tfDni,
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

	public static void updateRegistro(JComboBox<Integer> selectId, JComboBox<String> selectAtributo,
			JTextField tfNuevoValor, Conexiones c, ArrayList<Cliente> clientes, DefaultTableModel model) {
		int id = (int) selectId.getSelectedItem();
		String atributo = selectAtributo.getSelectedItem().toString();
		String nuevoValor = tfNuevoValor.getText();

		String db = "clientes", tabla = "cliente";
		String set = atributo + " = '" + nuevoValor + "'";
		String where = "id = " + id;

		List<String> select = new ArrayList<>();
		select.add("*");

		c.updateData(db, tabla, set, where);

		clientes = c.selectData("clientes", select, "cliente", "", "", "", "id");
		Methods.generateClientRows(clientes, model);
	}

	public static void deleteRegistro(JComboBox<Integer> selectId, Conexiones c, ArrayList<Cliente> clientes,
			DefaultTableModel model) {
		String id = selectId.getSelectedItem().toString();
		String db = "clientes", tabla = "cliente";

		List<String> select = new ArrayList<>();
		select.add("*");

		c.deleteData(db, tabla, id);

		clientes = c.selectData("clientes", select, "cliente", "", "", "", "id");
		Methods.generateClientRows(clientes, model);
	}

	public static void selectQuery(JTextField tfSelect, JTextField tfFrom, JTextField tfWhere, JTextField tfGroupBy,
			JTextField tfHaving, JTextField tfOrderBy, Conexiones c, ArrayList<Cliente> clientes,
			DefaultTableModel model) {
		String db = "clientes";
		String selectString = tfSelect.getText();
		List<String> select = Arrays.asList(selectString.split(", "));
		String from = tfFrom.getText();
		String where = tfWhere.getText();
		String groupBy = tfGroupBy.getText();
		String having = tfHaving.getText();
		String orderBy = tfOrderBy.getText();

		clientes = c.selectData(db, select, from, where, groupBy, having, orderBy);

		Methods.generateClientRows(clientes, model);
	}

}
