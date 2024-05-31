package Manel.c4backend.t22.ej1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.controller.*;
import Manel.c4backend.t22.ej1.model.Cliente;
import Manel.c4backend.t22.ej1.model.Methods;

public class DeleteView extends JFrame {

	private JPanel jp;
	private String[] columnas = { "id", "nombre", "apellido", "direccion", "dni", "fecha" };
	private ArrayList<Cliente> clientes;

	public DeleteView(final Conexiones c) {
		setTitle("Delete");
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
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnas);

		tClientes.setModel(model);
		tClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tClientes.setFillsViewportHeight(true);

		clientes = c.selectData("clientes", "*", "cliente", "", "", "", "");

		Methods.generateClientRows(clientes, model);

		// Scroll
		JScrollPane scroll = new JScrollPane(tClientes);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(20, 10, 550, 200);
		jp.add(scroll);

		// Label
		JLabel lId = new JLabel("ID");
		lId.setBounds(240, 250, 20, 20);
		jp.add(lId);

		// Combo Box
		final JComboBox<Integer> selectId = new JComboBox<Integer>();
		for (int i = 1; i <= clientes.size(); i++) {
			selectId.addItem(i);

		}
		selectId.setBounds(260, 250, 50, 20);
		jp.add(selectId);

		// Button
		JButton eliminar = new JButton("Eliminar");
		eliminar.setBounds(230, 300, 100, 30);
		jp.add(eliminar);

		// Action Listener
		ActionListener alEliminar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Listeners.deleteRegistro(selectId, c, clientes, model);
			}

		};

		eliminar.addActionListener(alEliminar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				c.closeConnection();
			}
		});
	}

}
