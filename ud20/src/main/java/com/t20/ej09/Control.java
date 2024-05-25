package com.t20.ej09;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Control {

    public static Color[] ordenarColores(ArrayList<Color> coloresDesordenados) {
        Color[] colores = new Color[16];
        int indexRandom = 0;
        for (int i = 0; i < colores.length; i++) {
            indexRandom = generarIndex(coloresDesordenados);
            colores[i] = coloresDesordenados.get(indexRandom);
            coloresDesordenados.remove(indexRandom);
        }
        return colores;
    }

    private static int generarIndex(ArrayList a) {
        int n = 0, size = a.size();
        n = (int) (Math.random() * size);
        return n;
    }

    public static int changeColor(ActionEvent e, JButton[] botones, int turno, JButton[] seleccionados, Color[] coloresRandom, int aciertos, int intentos) {
        String nombre1 = "", nombre2 = "";
        int index1 = 0, index2 = 0;

        if (turno == 2) {
            nombre1 = seleccionados[0].getName();
            nombre2 = seleccionados[1].getName();
            index1 = Integer.parseInt(nombre1);
            index2 = Integer.parseInt(nombre2);

            if (coloresRandom[index1].getRGB() != coloresRandom[index2].getRGB()) {
                botones[index1].setBackground(Color.CYAN);
                botones[index2].setBackground(Color.CYAN);
                botones[index1].setEnabled(true);
                botones[index2].setEnabled(true);

            } else {
                aciertos++;
                System.out.println(aciertos);
            }

            intentos++;
            Arrays.fill(seleccionados, null);

        } else {
            boolean found = false;

            for (int i = 0; i < botones.length && !found; i++) {
                if (e.getSource() == botones[i]) {
                    botones[i].setBackground(coloresRandom[i]);
                    botones[i].setEnabled(false);
                    seleccionados[turno] = botones[i];
                    found = true;
                }
            }

        }

        turno++;

        if (turno > 2) {
            turno = 0;
        }

        return turno;
    }
}
