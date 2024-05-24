package com.t20.ej06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class Grafico extends JFrame {

    private JPanel jp;

    public Grafico() {
        setTitle("Ejercicio 6");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel lAltura = new JLabel("Altura (metros) ");
        lAltura.setBounds(50, 10, 90, 20);
        jp.add(lAltura);

        // TextField
        JTextField tAltura = new JTextField();
        tAltura.setBounds(140,10,60,20);
        jp.add(tAltura);

        // Label
        JLabel lPeso = new JLabel("Peso (Kg) ");
        lPeso.setBounds(210,10,60,20);
        jp.add(lPeso);

        // TextField 
        JTextField tPeso = new JTextField();
        tPeso.setBounds(270,10,60,20);
        jp.add(tPeso);

        // Button
        JButton bCalcular = new JButton("Calcular IMC");
        bCalcular.setBounds(80,40,110,25);
        jp.add(bCalcular);

        // Label
        JLabel lImc = new JLabel(" IMC ");
        lImc.setBounds(200,40,30,25);
        jp.add(lImc);

        // TextField
        JTextField tImc = new JTextField();
        tImc.setBounds(230, 40, 60, 25);
        tImc.setEditable(false);
        jp.add(tImc);

        // Action Listener
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double altura = Double.parseDouble(tAltura.getText());
                    double peso = Double.parseDouble(tPeso.getText());
                    double imc = (peso) / (altura * altura);
                    DecimalFormat df = new DecimalFormat("#.##");
                    tImc.setText(String.valueOf(df.format(imc)));
                    
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        };

        bCalcular.addActionListener(al);
    }
}
