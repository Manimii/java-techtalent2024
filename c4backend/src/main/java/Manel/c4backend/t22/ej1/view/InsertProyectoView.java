package Manel.c4backend.t22.ej1.view;

import java.awt.event.*;

import javax.swing.*;

import Manel.c4backend.t22.ej1.controller.Conexiones;
import Manel.c4backend.t22.ej1.controller.Listeners;

public class InsertProyectoView extends JFrame {

    private JPanel jp;

    public InsertProyectoView(final Conexiones c, final String tabla, final String db) {
        setTitle("Insert");
        setSize(400, 260);
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
        JLabel lId = new JLabel("ID");
        lId.setBounds(100, 40, 50, 20);
        jp.add(lId);

        // Text Field
        final JTextField tfId = new JTextField();
        tfId.setBounds(170, 40, 100, 20);
        jp.add(tfId);

        // Label
        JLabel lNombre = new JLabel("Nombre");
        lNombre.setBounds(100, 70, 70, 20);
        jp.add(lNombre);

        // Text Field
        final JTextField tfNombre = new JTextField();
        tfNombre.setBounds(170, 70, 100, 20);
        jp.add(tfNombre);

        // Label
        JLabel lHoras = new JLabel("Horas");
        lHoras.setBounds(100, 100, 70, 20);
        jp.add(lHoras);

        // Text Field
        final JTextField tfHoras = new JTextField();
        tfHoras.setBounds(170, 100, 100, 20);
        jp.add(tfHoras);

        // Button
        JButton boton = new JButton("Añadir registro");
        boton.setBounds(140, 150, 120, 30);
        jp.add(boton);

        // ActionListener
        ActionListener alBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Listeners.addProyectoRegistro(tfId, tfNombre, tfHoras, c);

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
