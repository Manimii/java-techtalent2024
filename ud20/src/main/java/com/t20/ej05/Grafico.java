package com.t20.ej05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Grafico extends JFrame {

    private JPanel jp;

    public Grafico() {
        setTitle("Ejercicio 5");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Botón
        JButton boton = new JButton("Limpiar");
        boton.setBounds(150, 10, 80, 30);
        jp.add(boton);

        // TextArea
        JTextArea ta = new JTextArea();
        ta.setBounds(15, 50, 350, 300);
        jp.add(ta);

        // Mouse Listener
        MouseListener ml = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ta.append("Mouse Clicked\n");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ta.append("Mouse Pressed\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ta.append("Mouse Released\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ta.append("Mouse Entered\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ta.append("Mouse Exited\n");
            }

        };

        ta.addMouseListener(ml);

        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
            }

        };

        boton.addActionListener(al);
    }
}
