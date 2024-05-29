package Manel.c4backend.t22.ej1.controller;

import javax.swing.*;

import Manel.c4backend.t22.ej1.view.*;

public class Listeners {

	public static void selectMenu(JComboBox<String> selectMenu, JFrame frame) {
		String s = "";
		s = selectMenu.getSelectedItem().toString();
		frame.dispose();
		
		if (s.equals("Insertar datos")) {
			InsertView iv = new InsertView();
			
		} else if (s.equals("Mostrar datos")) {
			SelectView sv = new SelectView();
			
		} else if (s.equals("Actualizar datos")) {
			UpdateView uv = new UpdateView();
			
		} else if (s.equals("Borrar datos")) {
			DeleteView dv = new DeleteView();
			
		}
	}
}
