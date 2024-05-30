package Manel.c4backend.t22.ej1.view;

import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import Manel.c4backend.t22.ej1.controller.*;
import Manel.c4backend.t22.ej1.model.*;

public class UpdateView extends JFrame {

	private JPanel jp;
	private String[] columnas = { "id", "nombre", "apellido", "direccion", "dni", "fecha" };
	private ArrayList<Cliente> clientes;

	public UpdateView(final Conexiones c) {
		setTitle("Update");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

		// Table
		JTable tClientes = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnas);
		
		tClientes.setModel(model);
		tClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tClientes.setFillsViewportHeight(true);
		
		clientes = c.selectData("clientes", "*", "cliente", "", "", "", "");
		
		for (int i = 0; i < clientes.size(); i++) {
			Object[] o = new Object[6];
			o[0] = clientes.get(i).getId();
			o[1] = clientes.get(i).getNombre();
			o[2] = clientes.get(i).getApellido();
			o[3] = clientes.get(i).getDireccion();
			o[4] = clientes.get(i).getDni();
			o[5] = clientes.get(i).getFecha();
			model.addRow(o);
		}

		// Scroll
		JScrollPane scroll = new JScrollPane(tClientes);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(20, 10, 550, 200);
		jp.add(scroll);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				c.closeConnection();
			}
		});
	}
}
