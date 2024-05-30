package Manel.c4backend.t22.ej1.view;

import java.awt.event.WindowAdapter;

import javax.swing.*;

import Manel.c4backend.t22.ej1.controller.*;

public class SelectView extends JFrame {

	private JPanel jp;

	public SelectView(final Conexiones c) {
		setTitle("Select");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				c.closeConnection();
			}
		});
	}
}
