package Manel.c4backend.t22.ej1.controller;

import javax.swing.*;

import Manel.c4backend.t22.ej1.view.*;

public class Listeners {

	public static void selectMenu(JComboBox<String> selectMenu, JFrame frame, Conexiones c) {
		String s = "";
		s = selectMenu.getSelectedItem().toString();
		frame.dispose();

		if (s.equals("Insertar datos")) {
			InsertView iv = new InsertView(c);

		} else if (s.equals("Mostrar datos")) {
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
}
