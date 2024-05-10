package t10.ejercicio02;

public class App {

	public static void main(String[] args) {
		System.out.println("Mensaje mostrado por pantalla");
		try {
			throw new customExpection();
		} catch (customExpection e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Programa terminado.");
	}

}
