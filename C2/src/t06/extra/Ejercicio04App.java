package t06.extra;

import java.util.Arrays;

public class Ejercicio04App {

	/*
	 * Eliminar Duplicados: Crea un programa que elimine los elementos duplicados de
	 * un array de números enteros, es decir, si un número aparece más de una vez en
	 * el array, debería aparecer solo una vez en el array resultante.
	 */

	public static void main(String[] args) {
		int[] numeros = { 1, 2, 3, 4, 5, 6, 1, 2, 1, 10, 11 };
		muestraArray(numeros);
		eliminaDuplicados(numeros);

	}

	
	//SIN ACABAR
	public static void eliminaDuplicados(int[] a) {
		Arrays.sort(a);
		muestraArray(a);

		int count = 0;
		int actual = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == actual) {
				count++;
			}
			actual = a[i];
		}
		actual = -1;

		int[] b = new int[a.length - 1 - count];

		int i = 0;
		while (i < b.length) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] == actual) {
					j++;
				} else {
					b[i] = a[j];
					i++;
				}
				actual = a[j];
				
			}
		}
		
		muestraArray(b);
	}

	public static void muestraArray(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				System.out.print(a[i] + ",");
			} else if (i != a.length - 1) {
				System.out.print(" " + a[i] + ",");
			} else {
				System.out.print(" " + a[i]);
			}
		}
		System.out.println("]");
	}

}
