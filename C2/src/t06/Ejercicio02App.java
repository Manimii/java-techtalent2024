package t06;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ejercicio02App {

	public static void main(String[] args) {
		int n = Integer
				.parseInt(JOptionPane.showInputDialog("Introduce el número de números aleatorios que quieres generar"));

		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Rango mínimo de la generación aleatoria"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Rango máximo de la generación aleatoria"));

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + ": " + nrandom(n1, n2));
		}
	}

	public static int nrandom(int start, int end) {
		Random r = new Random();
		return r.nextInt(end - start + 1) + start;
	}
}
