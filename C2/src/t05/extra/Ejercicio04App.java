package t05.extra;

import javax.swing.JOptionPane;

public class Ejercicio04App {

	public static void main(String[] args) {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

		boolean endLoop = false;

		for (int i = 2; i <= (num / 2) && !endLoop; i++) {
			if (num % i == 0) {
				endLoop = true;
			}
		}

		if (endLoop) {
			System.out.println(num + " no es primo");
		} else {
			System.out.println(num + " es primo");
		}

	}

}
