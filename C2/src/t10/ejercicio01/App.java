package t10.ejercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		adivinar();
	}

	public static int getRandom() {
		int n = 0;
		n = (int) (Math.random() * 500) + 1;
		return n;
	}

	public static void adivinar() {
		Scanner sc = new Scanner(System.in);
		int intento = 0, n = getRandom(), count = 0;
		System.out.println("Adivina el número del 1 al 500");
		while (intento != n) {
			try {
				intento = sc.nextInt();
				if (intento > n) {
					System.out.println("¡MENOS!");
				} else if (intento < n) {
					System.out.println("¡MÁS!");
				}
				count++;
			} catch (InputMismatchException e) {
				System.out.println("No has introducido un valor válido y has perdido un intento.");
				sc.next();
				count++;
			}
		}
		String resultado = "¡Has adivinado el número en " + count + " intento";
		if (count > 1) {
			resultado += "s";
		}
		resultado += "!";
		System.out.println(resultado);
		sc.close();
	}

}
