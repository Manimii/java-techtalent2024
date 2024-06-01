package Manel.c4backend.t22.ej1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import Manel.c4backend.t22.ej1.controller.*;
import Manel.c4backend.t22.ej1.model.*;

public class UpdateView extends JFrame {

	private JPanel jp;
	private String[] columnas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Videos> videos;

	public UpdateView(final Conexiones c, final String tabla) {
		setTitle("Update");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);

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

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

		// Table
		JTable tTabla = new JTable();
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnas);

		tTabla.setModel(model);
		tTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tTabla.setFillsViewportHeight(true);

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
		JScrollPane scroll = new JScrollPane(tTabla);
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

		if (tabla.equals("Cliente")) {
			for (int i = 1; i <= clientes.size(); i++) {
				selectId.addItem(i);
			}

		} else if (tabla.equals("Videos")) {
			for (int i = 1; i <= videos.size(); i++) {
				selectId.addItem(i);
			}
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
				if (tabla.equals("Cliente")) {
					Listeners.updateRegistro(selectId, selectAtributo, tfNuevoValor, c, clientes, null, model, tabla);

				} else if (tabla.equals("Videos")) {
					Listeners.updateRegistro(selectId, selectAtributo, tfNuevoValor, c, null, videos, model, tabla);
				}

			}

		};

		actualizar.addActionListener(alActualizar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Startmenu sm = new Startmenu(c, tabla);
			}
		});
	}
}
