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
import Manel.c4backend.t22.ej1.model.Videos;

public class DeleteView extends JFrame {

	private JPanel jp;
	private String[] columnas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Videos> videos;

	public DeleteView(final Conexiones c, final String tabla, final String db) {
		setTitle("Delete");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

		if (tabla.equals("Cliente")) {
			columnas = new String[6];
			columnas[0] = "id";
			columnas[1] = "nombre";
			columnas[2] = "apellido";
			columnas[3] = "direccion";
			columnas[4] = "dni";
			columnas[5] = "fecha";

		} else if (tabla.equals("Videos")) {
			columnas = new String[4];
			columnas[0] = "id";
			columnas[1] = "title";
			columnas[2] = "director";
			columnas[3] = "cli_id";
		}

		// Table
		JTable tClientes = new JTable();
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnas);

		tClientes.setModel(model);
		tClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tClientes.setFillsViewportHeight(true);

		List<String> select = new ArrayList<>();
		select.add("*");

		if (tabla.equals("Cliente")) {
			clientes = c.selectClienteData("clientes", select, tabla, "", "", "", "");
			Methods.generateClientRows(clientes, model);

		} else if (tabla.equals("Videos")) {
			videos = c.selectVideosData("clientes", select, tabla, "", "", "", "");
			Methods.generateVideosRows(videos, model);

		}

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

		if (tabla.equals("Cliente")) {
			for (int i = 1; i <= clientes.size(); i++) {
				selectId.addItem(i);
			}

		} else if (tabla.equals("Videos")) {
			for (int i = 1; i <= videos.size(); i++) {
				selectId.addItem(i);
			}
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
				Listeners.deleteRegistro(selectId, c, clientes, videos, model, tabla);
			}

		};

		eliminar.addActionListener(alEliminar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Startmenu sm = new Startmenu(c, tabla, db);
			}
		});
	}

}
