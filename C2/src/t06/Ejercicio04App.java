package t06;

import javax.swing.JOptionPane;

public class Ejercicio04App {

	public static void main(String[] args) {

		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		JOptionPane.showMessageDialog(null, "Facorial de " + num + " = " + factorial(num));
	}

	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
}
