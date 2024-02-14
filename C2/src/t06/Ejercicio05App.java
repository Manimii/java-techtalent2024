package t06;

public class Ejercicio05App {

	public static void main(String[] args) {

		System.out.println(toBinary(14));
	}

	public static String toBinary(int n) {
		String binario = "";

		while (n > 0) {
			binario += n % 2;
			n = n / 2;

		}
		
		String aux = "";
		
		for (int i = binario.length() - 1; i >= 0; i--) {
			//aux += 
		}

		return binario;
	}
}
