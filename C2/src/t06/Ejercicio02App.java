package t06;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ejercicio02App {

	public static void main(String[] args) {
		int n = Integer.parseInt(
				JOptionPane.showInputDialog("Introduce la cantidad de números aleatorios que quieres generar"));

		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Rango mínimo de la generación aleatoria"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Rango máximo de la generación aleatoria"));

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + ": " + nrandom(Math.min(n1, n2), Math.max(n1, n2)));
		}
	}

	public static int nrandom(int min, int max) {
		return (int) (min + (Math.random() * (max + 1 - min)));

	}
}
