package Manel.c4backend.t22.ej1.view;

import java.awt.event.*;

import javax.swing.*;


import Manel.c4backend.t22.ej1.controller.Conexiones;
import Manel.c4backend.t22.ej1.controller.Listeners;

public class InsertCientificosView extends JFrame {

    private JPanel jp;

    public InsertCientificosView(final Conexiones c, final String tabla, final String db) {
        setTitle("Insert");
		setSize(400, 230);
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
		JLabel lDni = new JLabel("DNI");
		lDni.setBounds(100, 40, 50, 20);
		jp.add(lDni);

		// Text Field
		final JTextField tfDni = new JTextField();
		tfDni.setBounds(170, 40, 100, 20);
		jp.add(tfDni);

		// Label
		JLabel lNomApels = new JLabel("Nom Apels");
		lNomApels.setBounds(100, 70, 70, 20);
		jp.add(lNomApels);

		// Text Field
		final JTextField tfNomApels = new JTextField();
		tfNomApels.setBounds(170, 70, 100, 20);
		jp.add(tfNomApels);


        // Button
        JButton boton = new JButton("Añadir registro");
        boton.setBounds(140, 120, 120, 30);
        jp.add(boton);

        // ActionListener
        ActionListener alBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Listeners.addCientificosRegistro(tfDni, tfNomApels, c);

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
