package com.t20.ej09;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Grafico extends JFrame {

    private JPanel jp;
    private int turno; // 0 = seleccionar primera carta; 1 = seleccionar segunda carta; 2 = comparar cartas
    private int aciertos;
    private int intentos;

    public Grafico() {
        setTitle("Memory");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(new GridLayout(4, 4));
        setContentPane(jp);
        turno = 0;
        aciertos = 0;
        intentos = 0;

        // Lista de colores
        ArrayList<Color> colores = new ArrayList<Color>(Arrays.asList(Color.BLACK, Color.BLACK, Color.BLUE, Color.BLUE,
                Color.GRAY, Color.GRAY, Color.GREEN, Color.GREEN, Color.MAGENTA, Color.MAGENTA, Color.ORANGE,
                Color.ORANGE, Color.RED, Color.RED, Color.WHITE, Color.WHITE));

        Color[] coloresRandom = Control.ordenarColores(colores); 
        JButton[] botones = new JButton[16]; // Todos los botones
        JButton[] seleccionados = new JButton[2]; // Cartas seleccionadas

        // Action Listener
        ActionListener alCambiarColor = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                turno = Control.changeColor(e, botones, turno, seleccionados, coloresRandom, aciertos, intentos);
            }
            
        };

        // Buttons
        for (int i = 0; i < botones.length; i++) {
            JButton boton = new JButton();
            boton.setBackground(Color.CYAN);
            boton.setName(String.valueOf(i));
            boton.addActionListener(alCambiarColor);
            botones[i] = boton;
            jp.add(boton);

        }
    }

}
