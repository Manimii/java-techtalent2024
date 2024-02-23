package t06.extra;

import java.util.Arrays;

public class Ejercicio03App {

	public static void main(String[] args) {
		int[] numeros = { 10, 4, 5, 2, 10, 2, 1, 5 };
		ordenaArray(numeros);
		muestraArray(numeros);
	}

	public static void ordenaArray(int[] a) {
		Arrays.sort(a);
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
