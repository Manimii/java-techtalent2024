package Manel.c4backend.t22.ej1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;

import Manel.c4backend.t22.ej1.controller.Conexiones;
import Manel.c4backend.t22.ej1.controller.Listeners;

public class SelectDbView extends JFrame {

    private JPanel jp;

    public SelectDbView(final Conexiones c) {
        setTitle("Bases de datos");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel titulo = new JLabel("Selecciona una base de datos",
                SwingConstants.CENTER);
        titulo.setBounds(0, 10, 400, 20);
        jp.add(titulo);

        // Combo Box
        final JComboBox<String> selectDb = new JComboBox<String>();
        selectDb.addItem("clientes");
        selectDb.addItem("cientificos");
        selectDb.setBounds(140, 40, 120, 20);
        jp.add(selectDb);

        // Button
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(150, 110, 100, 30);
        jp.add(confirmar);

        // Action Listener
        ActionListener alConfirmar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Listeners.selectDb(selectDb, c);
            }
        };

        confirmar.addActionListener(alConfirmar);

        // Cerrar conexión al salir del aplicativo
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                c.closeConnection();
            }
        });
    }
}
