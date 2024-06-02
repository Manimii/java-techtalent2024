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
	private ArrayList<Cientificos> cientificos;
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Asignado> asignados;

	public UpdateView(final Conexiones c, final String tabla, final String db) {
		setTitle("Update");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);

		switch (db) {

			case "clientes":

				switch (tabla) {

					case "Cliente":
						columnas = new String[6];
						columnas[0] = "id";
						columnas[1] = "nombre";
						columnas[2] = "apellido";
						columnas[3] = "direccion";
						columnas[4] = "dni";
						columnas[5] = "fecha";
						break;

					case "Videos":
						columnas = new String[4];
						columnas[0] = "id";
						columnas[1] = "title";
						columnas[2] = "director";
						columnas[3] = "cli_id";
						break;

					default:
						break;
				}

				break;

			case "cientificos":

				switch (tabla) {

					case "Cientificos":
						columnas = new String[2];
						columnas[0] = "dni";
						columnas[1] = "nomApels";
						break;

					case "Proyecto":
						columnas = new String[3];
						columnas[0] = "id";
						columnas[1] = "nombre";
						columnas[2] = "horas";
						break;

					case "Asignado a":
						columnas = new String[2];
						columnas[0] = "cientifico";
						columnas[1] = "proyecto";
						break;

					default:
						break;
				}

				break;
			default:
				break;
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

		switch (db) {

			case "clientes":

				switch (tabla) {

					case "Cliente":
						clientes = c.selectClienteData("clientes", select, tabla, "", "", "", "");
						Methods.generateClientRows(clientes, model);
						break;

					case "Videos":
						videos = c.selectVideosData("clientes", select, tabla, "", "", "", "");
						Methods.generateVideosRows(videos, model);
						break;

					default:
						break;
				}

				break;

			case "cientificos":

				switch (tabla) {

					case "Cientificos":
						cientificos = c.selectCientificosData(db, select, tabla, "", "", "", "");
						Methods.generateCientificosRows(cientificos, model);
						break;

					case "Proyecto":
						proyectos = c.selectProyectoData(db, select, tabla, "", "", "", "");
						Methods.generateProyectoRows(proyectos, model);
						break;

					case "Asignado a":
						asignados = c.selectAsignadoData(db, select, "asignado_a", "", "", "", "");
						Methods.generateAsignadoaRows(asignados, model);
						break;

					default:
						break;
				}

				break;
			default:
				break;
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

		final JComboBox<Integer> selectNumberId = new JComboBox<Integer>();
		final JComboBox<String> selectStringId = new JComboBox<String>();
		final JComboBox<String> selectStringId2 = new JComboBox<String>();

		switch (db) {

			case "clientes":

				switch (tabla) {

					case "Cliente":
						for (int i = 0; i < clientes.size(); i++) {
							selectNumberId.addItem(clientes.get(i).getId());
						}
						break;

					case "Videos":
						for (int i = 0; i < videos.size(); i++) {
							selectNumberId.addItem(videos.get(i).getId());
						}
						break;

					default:
						break;
				}

				selectNumberId.setBounds(50, 250, 50, 20);
				jp.add(selectNumberId);

				break;

			case "cientificos":

				boolean dobleId = false;

				switch (tabla) {

					case "Cientificos":
						for (int i = 0; i < cientificos.size(); i++) {
							selectStringId.addItem(cientificos.get(i).getDni());
						}
						break;

					case "Proyecto":
						for (int i = 0; i < proyectos.size(); i++) {
							selectStringId.addItem(proyectos.get(i).getId());
						}
						break;

					case "Asignado a":
						asignados = c.selectAsignadoData(db, select, "asignado_a", "", "cientifico", "", "");

						for (int i = 0; i < asignados.size(); i++) {
							selectStringId.addItem(asignados.get(i).getCientifico());
						}

						asignados = c.selectAsignadoData(db, select, "asignado_a", "", "proyecto", "", "");

						for (int i = 0; i < asignados.size(); i++) {
							selectStringId2.addItem(asignados.get(i).getProyecto());
						}

						dobleId = true;
						break;

					default:
						break;
				}

				selectStringId.setBounds(50, 280, 90, 20);
				jp.add(selectStringId);

				if (dobleId) {
					selectStringId2.setBounds(50, 250, 70, 20);
					jp.add(selectStringId2);
				}

				break;
			default:
				break;
		}

		// Label
		JLabel lAtributo = new JLabel("Atributo");
		lAtributo.setBounds(130, 250, 50, 20);
		jp.add(lAtributo);

		// Combo Box
		final JComboBox<String> selectAtributo = new JComboBox<String>();
		if (tabla.equals("Asignado a")) {
			for (int i = 0; i < columnas.length; i++) {
				selectAtributo.addItem(columnas[i]);

			}

		} else {
			for (int i = 1; i < columnas.length; i++) {
				selectAtributo.addItem(columnas[i]);

			}
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
				switch (db) {

					case "clientes":

						switch (tabla) {

							case "Cliente":
								Listeners.updateRegistro(selectNumberId, null, null,
										selectAtributo, tfNuevoValor, c, clientes,
										null, null, null, null, model, tabla, db);
								break;

							case "Videos":
								Listeners.updateRegistro(selectNumberId, null, null,
										selectAtributo, tfNuevoValor, c, null, videos,
										null, null, null, model, tabla, db);
								break;

							default:
								break;
						}

						break;

					case "cientificos":

						switch (tabla) {

							case "Cientificos":
								Listeners.updateRegistro(null, selectStringId, null,
										selectAtributo, tfNuevoValor, c, null, null,
										cientificos, null, null, model, tabla, db);
								break;

							case "Proyecto":
								Listeners.updateRegistro(null, selectStringId, null,
										selectAtributo, tfNuevoValor, c, null, null,
										null, proyectos, null, model, tabla, db);
								break;

							case "Asignado a":
								Listeners.updateRegistro(null, selectStringId, selectStringId2,
										selectAtributo, tfNuevoValor, c, null, null,
										null, null, asignados, model, "asignado_a", db);
								break;

							default:
								break;
						}

						break;
					default:
						break;
				}

			}

		};

		actualizar.addActionListener(alActualizar);

		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Startmenu sm = new Startmenu(c, tabla, db);
			}
		});
	}
}
