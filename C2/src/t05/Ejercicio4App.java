package t05;

import javax.swing.JOptionPane;

public class Ejercicio4App {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Introduce el radio de la circumferencia");
		double radio = Double.parseDouble(input);
		double area = Math.PI*Math.pow(radio, 2);
		System.out.println("El area de la circumferencia es: " + area);
		
	}

}
