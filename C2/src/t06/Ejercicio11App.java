package t06;

import javax.swing.JOptionPane;

public class Ejercicio11App {

	public static void main(String[] args) {
		int dimension = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de las arrays"));

		int[] array1 = new int[dimension];
		int[] array2 = new int[dimension];

		rellenarArray(array1);
		rellenarArray(array2);
		
		System.out.println("----ARRAY 1----");
		mostrarArray(array1);
		System.out.println("\n----ARRAY 2----");
		mostrarArray(array2);
		System.out.println("\n----ARRAY MULTIPLICACIÓN----");
		mostrarArray(multiplicarArrays(array1,array2));
	}

	// Rellena una array con enteros aleatorios entre 0 y 9
	public static void rellenarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10);
		}
	}

	// A partir de dos arrays, crea una tercera del mismo tamaño multiplicando los
	// índices
	public static int[] multiplicarArrays(int[] a1, int[] a2) {
		int[] array = new int[a1.length];
		for (int i = 0; i < a1.length; i++) {
			array[i] = a1[i] * a2[i];
		}
		return array;
	}

	// Imprime por consola el contenido de una array
	public static void mostrarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] : " + a[i]);
		}
	}
}
