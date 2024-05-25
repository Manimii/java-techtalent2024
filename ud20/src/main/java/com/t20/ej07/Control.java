package com.t20.ej07;

import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Control {

    public static void cambiarModo(JButton boton) {
        if (boton.getText().equals("Euros a pesetas")) {
            boton.setText("Pesetas a euros");

        } else if (boton.getText().equals("Pesetas a euros")) {
            boton.setText("Euros a pesetas");

        }
    }

    public static void cambiarDinero(JButton boton, JTextField tDinero, JTextField tResulado) {
        double dinero = Double.parseDouble(tDinero.getText());
        double resultado = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        if (boton.getText().equals("Euros a pesetas")) {
            resultado = dinero * 166.386;

        } else if (boton.getText().equals("Pesetas a euros")) {
            resultado = dinero / 166.386;

        }

        tResulado.setText(df.format(resultado));

    }
}
