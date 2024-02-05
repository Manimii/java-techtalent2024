package t04;

public class Ejercicio5 {

	public static void main(String[] args) {
		int a = 1, b = 2, c = 3, d = 4, e = 5;
		System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d + " e = " + e + "\n");

		int aux = b;
		b = c;
		c = a;
		a = d;
		d = aux;

		System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d + " e = " + e);

	}

}
