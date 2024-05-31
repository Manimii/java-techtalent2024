package Manel.c4backend.t22.ej1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.controller.*;
import Manel.c4backend.t22.ej1.model.Cliente;
import Manel.c4backend.t22.ej1.model.Methods;

public class SelectView extends JFrame {

	private JPanel jp;
	private String[] columnas = { "id", "nombre", "apellido", "direccion", "dni", "fecha" };
	private ArrayList<Cliente> clientes;

	public SelectView(final Conexiones c) {
		setTitle("Select");
		setSize(600, 500);
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

		List<String> select = new ArrayList<>();
		select.add("*");

		clientes = c.selectData("clientes", select, "cliente", "", "", "", "");

		Methods.generateClientRows(clientes, model);

		// Scroll
		JScrollPane scroll = new JScrollPane(tClientes);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(20, 10, 550, 200);
		jp.add(scroll);

		// Label
		JLabel lSelect = new JLabel("SELECT");
		lSelect.setBounds(20, 230, 50, 20);
		jp.add(lSelect);

		// Text Field
		final JTextField tfSelect = new JTextField();
		tfSelect.setBounds(80, 230, 490, 20);
		jp.add(tfSelect);

		// Label
		JLabel lFrom = new JLabel("FROM");
		lFrom.setBounds(20, 260, 50, 20);
		jp.add(lFrom);

		// Text Field
		final JTextField tfFrom = new JTextField("cliente");
		tfFrom.setBounds(80, 260, 490, 20);
		tfFrom.setEnabled(false);
		jp.add(tfFrom);

		// Label
		JLabel lWhere = new JLabel("WHERE");
		lWhere.setBounds(20, 290, 50, 20);
		jp.add(lWhere);

		// Text Field
		final JTextField tfWhere = new JTextField();
		tfWhere.setBounds(80, 290, 490, 20);
		jp.add(tfWhere);

		// Label
		JLabel lGroupBy = new JLabel("GROUP BY");
		lGroupBy.setBounds(20, 320, 70, 20);
		jp.add(lGroupBy);

		// Text Field
		final JTextField tfGroupBy = new JTextField();
		tfGroupBy.setBounds(100, 320, 470, 20);
		jp.add(tfGroupBy);

		// Label
		JLabel lHaving = new JLabel("HAVING");
		lHaving.setBounds(20, 350, 50, 20);
		jp.add(lHaving);

		// Text Field
		final JTextField tfHaving = new JTextField();
		tfHaving.setBounds(80, 350, 490, 20);
		jp.add(tfHaving);

		// Label
		JLabel lOrderBy = new JLabel("ORDER BY");
		lOrderBy.setBounds(20, 380, 70, 20);
		jp.add(lOrderBy);

		// Text Field
		final JTextField tfOrderBy = new JTextField();
		tfOrderBy.setBounds(100, 380, 470, 20);
		jp.add(tfOrderBy);

		// Button
		JButton ejecutar = new JButton("Ejecutar");
		ejecutar.setBounds(230, 410, 100, 30);
		jp.add(ejecutar);

		// Action Listener
		ActionListener alEjecutar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Listeners.selectQuery(tfSelect, tfFrom, tfWhere, tfGroupBy, tfHaving, tfOrderBy, c, clientes, model);
			}

		};

		ejecutar.addActionListener(alEjecutar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				c.closeConnection();
			}
		});
	}
}
