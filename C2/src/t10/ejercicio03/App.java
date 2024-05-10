package t10.ejercicio03;

public class App {

	public static void main(String[] args) {
		System.out.println("Generando número aleatorio...");
		try {
			int random = getRandom();
			System.out.println("El número generado es: " + random);
			throw new exceptionParImpar(random);
		} catch (exceptionParImpar e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int getRandom() {
		int n = 0;
		n = (int) (Math.random() * 1000);
		return n;
	}

}
