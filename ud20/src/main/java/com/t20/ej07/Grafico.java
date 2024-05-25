package com.t20.ej07;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafico extends JFrame{

    private JPanel jp;
    
    public Grafico() {
        setTitle("Ejercicio 7");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel lCantidad = new JLabel("Cantidad a convertir ");
        lCantidad.setBounds(30, 10, 120, 20);
        jp.add(lCantidad);

        // TextField
        JTextField tCantidad = new JTextField();
        tCantidad.setBounds(150,10,60,20);
        jp.add(tCantidad);

        // Label
        JLabel lResultado = new JLabel("Resultado ");
        lResultado.setBounds(220,10,60,20);
        jp.add(lResultado);

        // TextField 
        JTextField tResultado = new JTextField();
        tResultado.setBounds(280,10,60,20);
        tResultado.setEditable(false);
        jp.add(tResultado);

        // Button
        JButton bModo = new JButton("Euros a pesetas");
        bModo.setBounds(65,40,135,30);
        jp.add(bModo);

        // Button
        JButton bCambiar = new JButton("Cambiar");
        bCambiar.setBounds(220,40,100,30);
        jp.add(bCambiar);

        // Action Listener
        ActionListener alModo = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Control.cambiarModo(bModo);
            }

        };

        bModo.addActionListener(alModo);

        // Action Listener
        ActionListener alCambiar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Control.cambiarDinero(bModo, tCantidad, tResultado);
            }

        };

        bCambiar.addActionListener(alCambiar);
    }

}
