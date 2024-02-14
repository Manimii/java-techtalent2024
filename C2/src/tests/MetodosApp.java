package tests;

public class MetodosApp {

	public static void main(String[] args) {

		int num1 = 10, num2 = 5;
		int suma = sumaNumeros(num1, num2);

		if (mayorZero(suma)) {
			System.out.println("Resultado positivo");
		} else {
			System.out.println("Resultado negativo");
		}

	}

	public static int sumaNumeros(int a, int b) {
		return a + b;
	}

	public static boolean mayorZero(int a) {
		return a >= 0;
	}

}
