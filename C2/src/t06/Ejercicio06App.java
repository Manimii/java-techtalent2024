package t06;

import javax.swing.JOptionPane;

public class Ejercicio06App {

	public static void main(String[] args) {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero positivo"));
		while (numero < 0) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Error: Debes introducir un número entero positivo"));
		}

		JOptionPane.showMessageDialog(null, "El número " + numero + " tiene " + cuentaCifras(numero) + " cifra(s)");

	}

	public static int cuentaCifras(int n) {
		int count = 1;
		while (n > 9) {
			n = n / 10;
			count++;
		}
		return count;
	}
}
