package Manel.c4backend.t22.ej1.view;

import java.awt.event.*;

import javax.swing.*;

import Manel.c4backend.t22.ej1.controller.Conexiones;
import Manel.c4backend.t22.ej1.controller.Listeners;

public class Startmenu extends JFrame{

	private JPanel jp;

	public Startmenu(final Conexiones c, final String tabla, final String db) {
		setTitle(db + " - " + tabla);
		setSize(400, 250);
		setLocationRelativeTo(null);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

		// Label
		JLabel titulo = new JLabel("Selecciona la función que quieres hacer en la tabla clientes",
				SwingConstants.CENTER);
		titulo.setBounds(0, 10, 400, 20);
		jp.add(titulo);

		// Combo Box
		final JComboBox<String> selectMenu = new JComboBox<String>();
		selectMenu.addItem("Insertar datos");
		selectMenu.addItem("Actualizar datos");
		selectMenu.addItem("Borrar datos");
		selectMenu.addItem("Hacer consultas");
		selectMenu.setBounds(140, 40, 120, 20);
		jp.add(selectMenu);

		// Button
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(150, 150, 100, 30);
		jp.add(confirmar);

		// Action Listener
		ActionListener alConfirmar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Listeners.selectMenu(selectMenu, c, tabla, db);
			}

		};

		confirmar.addActionListener(alConfirmar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				SelectTableView stv = new SelectTableView(c, db);
			
			}
		});

	}

}
