package t10.ejercicio05;

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

	public boolean esFuerte() {
		int countMayus = 0, countMinus = 0, countNums = 0;
		for (int i = 0; i < pass.length(); i++) {
			char c = pass.charAt(i);
			int valorC = (int) c;
			if (valorC >= 65 && valorC <= 90) {
				countMayus++;
			} else if (valorC >= 97 && valorC <= 122) {
				countMinus++;
			} else if (valorC >= 48 && valorC <= 57) {
				countNums++;
			}
		}

		return (countMayus > 2 && countMinus > 1 && countNums > 5);
	}

	// 48-122
	private static int numRandom() {
		int n = 58;
		// Si sale algo distinto a una letra o un numero vuelve a generar un caracter
		while ((n >= 58 && n <= 64) || (n >= 91 && n <= 96)) {
			n = (int) (48 + (Math.random() * (122 + 1 - 48)));
		}
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

}
