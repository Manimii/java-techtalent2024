package t10.ejercicio04;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		try {
			System.out.print("Introduce 2 operadores para hacer los calculos.\na: ");
			a = sc.nextInt();
			System.out.print("\nb: ");
			b = sc.nextInt();
			calculadora c = new calculadora(a, b);
			System.out.println(a + " + " + b + " = " + c.suma() + "\n" + a + " - " + b + " = " + c.resta() + "\n" + a
					+ " * " + b + " = " + c.multiplicacion() + "\n" + a + " ^ " + b + " = " + c.potencia() + "\n"
					+ "sqrt(" + a + ") = " + c.raizCuadrada() + "\n" + "cbrt(" + a + ") = " + c.raizCubica() + "\n" + a
					+ " / " + b + " = " + c.division());
		} catch (Exception e) {
			System.out.println("Error en una operación: " + e.getMessage());
		}
	}

}
