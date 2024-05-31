package Manel.c4backend.t22.ej1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		lId.setBounds(30, 250, 20, 20);
		jp.add(lId);

		// Combo Box
		final JComboBox<Integer> selectId = new JComboBox<Integer>();
		for (int i = 1; i <= clientes.size(); i++) {
			selectId.addItem(i);

		}
		selectId.setBounds(50, 250, 50, 20);
		jp.add(selectId);

		// Label
		JLabel lAtributo = new JLabel("Atributo");
		lAtributo.setBounds(130, 250, 50, 20);
		jp.add(lAtributo);

		// Combo Box
		final JComboBox<String> selectAtributo = new JComboBox<String>();
		for (int i = 1; i < columnas.length; i++) {
			selectAtributo.addItem(columnas[i]);

		}
		selectAtributo.setBounds(190, 250, 100, 20);
		jp.add(selectAtributo);

		// Label
		JLabel lNuevoValor = new JLabel("Nuevo valor");
		lNuevoValor.setBounds(320, 250, 70, 20);
		jp.add(lNuevoValor);
		
		// Text Field
		final JTextField tfNuevoValor = new JTextField();
		tfNuevoValor.setBounds(400, 250, 150, 20);
		jp.add(tfNuevoValor);
		
		// Button
		JButton actualizar = new JButton("Actualizar");
		actualizar.setBounds(230, 300, 100, 30);
		jp.add(actualizar);
		
		// Action Listener
		ActionListener alActualizar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Listeners.updateRegistro(selectId, selectAtributo, tfNuevoValor, c, clientes, model);
			}
			
		};
		
		actualizar.addActionListener(alActualizar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				c.closeConnection();
			}
		});
	}
}
