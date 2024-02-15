package t06;

public class Ejercicio05App {

	public static void main(String[] args) {

		System.out.println(toBinary(4));
	}

	public static String toBinary(int n) {
		if (n == 0) {
			return "0";
		}
		
		String binario = "";

		while (n > 0) {
			binario += n % 2;
			n = n / 2;

		}

		binario = reverseString(binario);

		return binario;
	}

	public static String reverseString(String s) {
		String aux = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			aux += s.charAt(i);
		}

		return aux;
	}
}
