package Manel.c4backend.t22.ej1.view;

import java.awt.event.*;

import javax.swing.*;

import Manel.c4backend.t22.ej1.controller.*;

public class InsertClienteView extends JFrame {

	private JPanel jp;

	public InsertClienteView(final Conexiones c, final String tabla, final String db) {
		setTitle("Insert");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);

		// Panel
		jp = new JPanel();
		jp.setLayout(null);
		setContentPane(jp);

		// Label
		JLabel titulo = new JLabel("Introduce los datos", SwingConstants.CENTER);
		titulo.setBounds(0, 10, 400, 20);
		jp.add(titulo);

		// Label
		JLabel lNombre = new JLabel("Nombre");
		lNombre.setBounds(100, 40, 50, 20);
		jp.add(lNombre);

		// Text Field
		final JTextField tfNombre = new JTextField();
		tfNombre.setBounds(170, 40, 100, 20);
		jp.add(tfNombre);

		// Label
		JLabel lApellido = new JLabel("Apellido");
		lApellido.setBounds(100, 70, 50, 20);
		jp.add(lApellido);

		// Text Field
		final JTextField tfApellido = new JTextField();
		tfApellido.setBounds(170, 70, 100, 20);
		jp.add(tfApellido);

		// Label
		JLabel lDireccion = new JLabel("Dirección");
		lDireccion.setBounds(100, 100, 60, 20);
		jp.add(lDireccion);

		// Text Field
		final JTextField tfDireccion = new JTextField();
		tfDireccion.setBounds(170, 100, 100, 20);
		jp.add(tfDireccion);

		// Label
		JLabel lDni = new JLabel("Dni");
		lDni.setBounds(100, 130, 50, 20);
		jp.add(lDni);

		// Text Field
		final JTextField tfDni = new JTextField();
		tfDni.setBounds(170, 130, 100, 20);
		jp.add(tfDni);

		// Label
		JLabel lFecha = new JLabel("Fecha");
		lFecha.setBounds(100, 160, 50, 20);
		jp.add(lFecha);

		// Text Field
		final JTextField tfFecha = new JTextField();
		tfFecha.setBounds(170, 160, 100, 20);
		jp.add(tfFecha);

		// Button
		JButton boton = new JButton("Añadir registro");
		boton.setBounds(140, 210, 120, 30);
		jp.add(boton);

		// ActionListener
		ActionListener alBoton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Listeners.addClienteRegistro(tfNombre, tfApellido, tfDireccion, tfDni, tfFecha, c);

			}

		};
		
		boton.addActionListener(alBoton);
		
		// Cerrar conexión al salir del aplicativo
		addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        Startmenu sm = new Startmenu(c, tabla, db);
		    }
		});

	}
}
