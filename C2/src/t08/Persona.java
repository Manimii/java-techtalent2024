package t08;

public class Persona {
	
	private final char sexoDefecto = 'H';

	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;
	
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.dni = "12345678Z";
		this.sexo = sexoDefecto;
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		if (sexo != 'M') {
			this.sexo = sexoDefecto;
		} else {
			this.sexo = sexo;
		}
		this.dni = "12345678Z";
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		if (sexo != 'M') {
			this.sexo = sexoDefecto;
		} else {
			this.sexo = sexo;
		}
		this.peso = peso;
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Persona [sexoDefecto=" + sexoDefecto + ", nombre=" + nombre + ", edad=" + edad + ", dni=" + dni
				+ ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}
