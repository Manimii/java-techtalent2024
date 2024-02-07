package t05;

import java.util.Scanner;

public class Ejercicio5App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número");
		int num = sc.nextInt();
		if (num % 2 == 0) {
			System.out.println(num + " es par");
		} else {
			System.out.println(num + " es impar");
		}
		
	}

}
