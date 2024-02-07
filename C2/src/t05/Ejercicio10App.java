package t05;

import java.util.Scanner;

public class Ejercicio10App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el número de ventas que vas a añadir");
		int nventas = sc.nextInt();
		float sumaventas = 0;

		for (int i = 0; i < nventas; i++) {
			System.out.println("Introduce la venta");
			float venta = sc.nextFloat();
			sumaventas += venta;
		}

		System.out.println("Total ventas: " + sumaventas);
	}

}
