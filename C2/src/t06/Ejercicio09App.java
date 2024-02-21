package t06;

import javax.swing.JOptionPane;

public class Ejercicio09App {

	public static void main(String[] args) {

		int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la array"));
		int array[] = new int[tamaño];
		rellenarArrayRango(array, 5, 15);
		mostrarArray(array);
	}

	public static void rellenarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10);
		}
	}

	public static void rellenarArrayRango(int[] a, int min, int max) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (min + (Math.random() * (max + 1 - min)));
		}
	}

	public static void mostrarArray(int[] a) {
		int suma = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.println("Valor de la array en la posición " + i + ": " + a[i]);
			suma += a[i];
		}

		System.out.println("Suma de los valores de la array = " + suma);
	}
}
