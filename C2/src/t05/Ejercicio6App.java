package t05;

import java.util.Scanner;

public class Ejercicio6App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final double IVA = 0.21;
		
		System.out.println("Introduce el precio de un producto");
		float num = sc.nextFloat();
		
		System.out.println("El precio del producto con IVA es " + (num + (num*IVA)));
		
	}

}
