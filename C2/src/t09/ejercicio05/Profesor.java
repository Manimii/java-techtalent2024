package t09.ejercicio05;

public class Profesor extends Persona {

	private Materia materia;

	public Profesor() {
		super();
		this.materia = Materia.matemáticas;
	}

	public Profesor(String nombre, int edad, Sexo sexo, Materia materia) {
		super(nombre, edad, sexo);
		this.materia = materia;

	}

	@Override
	// 20% true 80% false
	public boolean estaAusente() {
		boolean b = false;
		int random = (int) (Math.random() * 5);
		if (random == 0) {
			b = true;
		}
		return b;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Profesor [materia=" + materia + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + "]";
	}

	

}
