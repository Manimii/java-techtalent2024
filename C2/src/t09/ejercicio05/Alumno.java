package t09.ejercicio05;

public class Alumno extends Persona {

	private int nota;

	public Alumno() {
		super();
		this.nota = generarNota();
	}

	public Alumno(String nombre, int edad, Sexo sexo, int nota) {
		super(nombre, edad, sexo);
		if (nota < 0) {
			this.nota = 0;
		} else if (nota > 10) {
			this.nota = 10;
		} else {
			this.nota = nota;
		}
	}

	public Alumno(String nombre, int edad, Sexo sexo) {
		super(nombre, edad, sexo);
		this.nota = generarNota();
	}

	public int generarNota() {
		return (int) (1 + Math.random() * 10);
	}

	@Override
	// 50% true 50% false
	public boolean estaAusente() {
		boolean b = false;
		int random = (int) (Math.random() * 2);
		if (random == 0) {
			b = true;
		}
		return b;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nota=" + nota + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + "]";
	}

}
