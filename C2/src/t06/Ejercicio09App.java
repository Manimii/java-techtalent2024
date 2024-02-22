package t06;

import javax.swing.JOptionPane;

public class Ejercicio09App {

	public static void main(String[] args) {

		int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la array"));
		int array[] = new int[tamaño];
		rellenarArrayRango(array, 10, 20);
		mostrarArray(array);
	}
	//Rellenar array con enteros aleatorios de 0 a 9
//	public static void rellenarArray(int[] a) {
//		for (int i = 0; i < a.length; i++) {
//			a[i] = (int) (Math.random() * 10);
//		}
//	}

	//Rellenar array con enteros aleatorios dado un rango
	public static void rellenarArrayRango(int[] a, int min, int max) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (min + (Math.random() * (max + 1 - min)));
		}
	}

	//Muestra el contenido de una array de enteros y muestra la suma total
	public static void mostrarArray(int[] a) {
		int suma = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.println("Valor de la array en la posición " + i + ": " + a[i]);
			suma += a[i];
		}

		System.out.println("Suma de los valores de la array = " + suma);
	}
}
