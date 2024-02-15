package t06;

import javax.swing.JOptionPane;

public class Ejercicio08App {

	public static void main(String[] args) {

		int array[] = new int[10];
		rellenarArray(array);
		mostrarArray(array);

	}

	public static void rellenarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor de la array en la posición " + i));
		}
	}

	public static void mostrarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("Valor de la array en la posición " + i + ": " + a[i]);
		}
	}
}
