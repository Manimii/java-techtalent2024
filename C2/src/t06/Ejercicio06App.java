package t06;

import javax.swing.JOptionPane;

public class Ejercicio06App {

	public static void main(String[] args) {
		int numero = 0;
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero positivo"));
		} while (numero < 0);

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
