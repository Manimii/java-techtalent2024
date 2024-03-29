package t06;

import javax.swing.JOptionPane;

public class Ejercicio03App {

	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

		if (esPrimo(n)) {
			System.out.println(n + " es primo");
		} else {
			System.out.println(n + " no es primo");
		}
	}

	public static boolean esPrimo(int num) {
		if (num <= 1) {
			return false;
		}

		boolean primo = true;

		for (int i = 2; i <= (Math.sqrt(num)) && primo; i++) {
			if (num % i == 0) {
				primo = false;
			}
		}

		return primo;

	}
}
