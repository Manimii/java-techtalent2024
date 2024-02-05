package t04;

public class Ejercicio5App {

	public static void main(String[] args) {
		int a = 1, b = 2, c = 3, d = 4;
		
		System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d + "\n");

		int aux = b;
		b = c;
		c = a;
		a = d;
		d = aux;

		System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);

	}

}
