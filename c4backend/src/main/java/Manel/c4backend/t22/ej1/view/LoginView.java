package Manel.c4backend.t22.ej1.view;

import javax.swing.*;

import java.awt.event.*;

import Manel.c4backend.t22.ej1.controller.Listeners;

public class LoginView extends JFrame {

    private JPanel jp;

    public LoginView() {
        setTitle("Login");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel lUser = new JLabel("User");
        lUser.setBounds(100, 30, 50, 20);
        jp.add(lUser);

        // Text Field
        final JTextField tfUser = new JTextField();
        tfUser.setBounds(200, 30, 100, 20);
        jp.add(tfUser);

        // Label
        JLabel lPassword = new JLabel("Password");
        lPassword.setBounds(100, 60, 60, 20);
        jp.add(lPassword);

        // Password
        final JPasswordField pPassword = new JPasswordField();
        pPassword.setBounds(200, 60, 100, 20);
        jp.add(pPassword);

        // Button
        JButton boton = new JButton("Log in");
        boton.setBounds(150, 100, 100, 30);
        jp.add(boton);

        // Action Listener
        ActionListener alBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Listeners.connectDb(tfUser, pPassword);
            }

        };

        boton.addActionListener(alBoton);
    }
}
