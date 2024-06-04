package Manel.c4backend.t22.ej1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Manel.c4backend.t22.ej1.controller.*;
import Manel.c4backend.t22.ej1.model.Asignado;
import Manel.c4backend.t22.ej1.model.Cientificos;
import Manel.c4backend.t22.ej1.model.Cliente;
import Manel.c4backend.t22.ej1.model.Methods;
import Manel.c4backend.t22.ej1.model.Proyecto;
import Manel.c4backend.t22.ej1.model.Videos;

public class DeleteView extends JFrame {

	private JPanel jp;
	private String[] columnas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Videos> videos;
	private ArrayList<Cientificos> cientificos;
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Asignado> asignados;

	public DeleteView(final Conexiones c, final String tabla, final String db) {
		setTitle("Delete");
		setSize(600, 450);
		setLocationRelativeTo(null);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

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

		// Table
		JTable tClientes = new JTable();
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnas);

		tClientes.setModel(model);
		tClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tClientes.setFillsViewportHeight(true);

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
		final JComboBox<Integer> selectNumberId = new JComboBox<Integer>();
		final JComboBox<String> selectStringId = new JComboBox<String>();
		final JComboBox<String> selectStringId2 = new JComboBox<String>();

		Methods.generateIdComboBox(selectNumberId, selectStringId, selectStringId2, clientes, videos, cientificos,
				proyectos, asignados, db, tabla, c, jp, 260);

		// Button
		JButton eliminar = new JButton("Eliminar");
		eliminar.setBounds(230, 330, 100, 30);
		jp.add(eliminar);

		// Action Listener
		ActionListener alEliminar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (db) {

				case "clientes":

					switch (tabla) {

					case "Cliente":
						Listeners.deleteRegistro(selectNumberId, null, null, c, clientes, null, null, null, null, model,
								tabla, db);
						break;

					case "Videos":
						Listeners.deleteRegistro(selectNumberId, null, null, c, null, videos, null, null, null, model,
								tabla, db);
						break;

					default:
						break;
					}

					break;

				case "cientificos":

					switch (tabla) {

					case "Cientificos":
						Listeners.deleteRegistro(null, selectStringId, null, c, null, null, cientificos, null, null,
								model, tabla, db);
						break;

					case "Proyecto":
						Listeners.deleteRegistro(null, selectStringId, null, c, null, null, null, proyectos, null,
								model, tabla, db);
						break;

					case "Asignado a":
						Listeners.deleteRegistro(null, selectStringId, selectStringId2, c, null, null, null, null,
								asignados, model, tabla, db);
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
