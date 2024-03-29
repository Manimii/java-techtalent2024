package t05;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio13App {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String n1 = JOptionPane.showInputDialog("Introduce un número entero");
		String n2 = JOptionPane.showInputDialog("Introduce un otro número entero");
		String signo = JOptionPane.showInputDialog("Introduce un signo aritmético (+,-,*,/,^,%)");
		
		int a = Integer.parseInt(n1);
		int b = Integer.parseInt(n2);
		
		String resultado = "";
		
		switch (signo) {
		case "+":
			resultado =  a + " + " + b + " = " + (a + b);
			break;
		case "-":
			resultado = a + " - " + b + " = " + (a - b);
			break;
		case "*":
			resultado = a + " * " + b + " = " + (a * b);
			break;
		case "/":
			while (b == 0) {
				b = Integer.parseInt(JOptionPane.showInputDialog("No se puede dividir por 0, introduce un otro número entero"));
			}
			resultado = a + " / " + b + " = " + ((double)a / (double)b);
			break;
		case "^":
			resultado = a + " ^ " + b + " = " + (Math.pow(a, b));
			break;
		case "%":
			while (b == 0) {
				b = Integer.parseInt(JOptionPane.showInputDialog("No se puede dividir por 0, introduce un otro número entero"));
			}
			resultado = a + " % " + b + " = " + (a % b);
			break;
		default:
			resultado = "Error";
			break;
		}
		JOptionPane.showMessageDialog(null,resultado);
		
	}

}
