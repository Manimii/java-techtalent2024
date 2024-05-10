package t10.ejercicio03;

public class exceptionParImpar extends Exception {

	private int n;
	
	public exceptionParImpar(int n) {
		super();
		this.n = n;
	}
	
	public String getMessage() {
		String mensaje = "";
		if (this.n % 2 == 0) {
			mensaje = "Es par.";
		} else {
			mensaje = "Es impar.";
		}
		return mensaje;
	}
}
