package t08;

public class Password {

	private int longitud;
	private String pass;

	public Password() {
		this.longitud = 8;
		this.pass = generarPassword(this.longitud);
	}

	public Password(int longitud) {
		this.longitud = longitud;
		this.pass = generarPassword(this.longitud);
	}

	private static String generarPassword(int l) {
		String pw = "";
		for (int i = 0; i < l; i++) {
			pw += (char) numRandom();
		}
		return pw;
	}

	// 32-126 
	private static int numRandom() {
		int n = (int) (32 + (Math.random() * (126 + 1 - 32)));
		return n;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
