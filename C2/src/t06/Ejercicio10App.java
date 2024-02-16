package t06;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ejercicio10App {

	public static void main(String[] args) {
		int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la array"));
		int array[] = new int[tamaño];

		int num1 = Integer
				.parseInt(JOptionPane.showInputDialog("Introduce el primer valor para el rango de números aleatorios"));
		int num2 = Integer.parseInt(
				JOptionPane.showInputDialog("Introduce el segundo valor para el rango de números aleatorios"));

		rellenarArray(array, Math.min(num1, num2), Math.max(num1, num2));
		mostrarArray(array);
		JOptionPane.showMessageDialog(null, "El valor máximo de la array es " + maxArray(array));
	}

	// Dice si un entero es primo o no
	public static boolean esPrimo(int num) {
		if (num <= 1) {
			return false;
		}

		boolean primo = true;

		for (int i = 2; i <= (num / 2) && primo; i++) {
			if (num % i == 0) {
				primo = false;
			}
		}

		return primo;

	}

	// Genera un número primo aleatorio entre un rango dado.
	public static int nrandom(int start, int end) {
		Random r = new Random();
		int num = r.nextInt(end - start + 1) + start;
		while (!esPrimo(num)) {
			num = r.nextInt(end - start + 1) + start;
		}
		return num;

	}

	// Rellena una array con enteros primos aleatorios
	public static void rellenarArray(int[] a, int min, int max) {
		for (int i = 0; i < a.length; i++) {
			a[i] = nrandom(min, max);
		}
	}

	// recorre una array y devuelve el valor máximo de la misma.
	public static int maxArray(int[] a) {
		int max = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}

		return max;
	}

	// Imprime por consola el contenido de una array
	public static void mostrarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("Valor de la array en la posición " + i + ": " + a[i]);
		}
	}
}
