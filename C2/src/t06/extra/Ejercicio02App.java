package t06.extra;

import java.util.Scanner;

public class Ejercicio02App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numeros = {1,2,3,4,5,6,7,8,9};
		
		System.out.println("Introduce un número");
		int n = sc.nextInt();
		
		buscaNumero(numeros, n);
	}
	
	public static void buscaNumero(int[] a, int n) {
		boolean found = false;
		
		for (int i = 0; i < a.length && !found; i++) {
			if (a[i] == n) {
				found = true;
				System.out.println("Posición del número " + n + " en la array: " + i);
			}
		}
		
		if (!found) {
			System.out.println("No se ha encontrado el número " + n + " en la array");
		}
	}

}
