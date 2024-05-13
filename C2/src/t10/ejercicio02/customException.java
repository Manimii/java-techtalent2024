package t10.ejercicio02;

public class customException extends Exception{

	public customException() {
		super();
	}
	
	public String getMessage() {
		return "Mensaje de excepción customizada by Manel.";
	}
}
