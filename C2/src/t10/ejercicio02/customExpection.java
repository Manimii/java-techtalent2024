package t10.ejercicio02;

public class customExpection extends Exception{

	public customExpection() {
		super();
	}
	
	public String getMessage() {
		return "Mensaje de excepción customizada.";
	}
}
