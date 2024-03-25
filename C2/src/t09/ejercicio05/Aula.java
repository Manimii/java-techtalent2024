package t09.ejercicio05;

import java.util.Arrays;

public class Aula {

	private int id;
	private int maxEstudiantes;
	private Materia materia;
	private Alumno[] alumnos;
	private Profesor profesor;

	public Aula() {
		this.id = 0;
		this.maxEstudiantes = 10;
		this.materia = Materia.matemáticas;
		this.alumnos = new Alumno[this.maxEstudiantes];
		this.profesor = null;
	}

	public Aula(int id, int maxEstudiantes, Materia materia, Profesor profesor) {
		this.id = id;
		this.maxEstudiantes = maxEstudiantes;
		this.materia = materia;
		this.alumnos = new Alumno[maxEstudiantes];
		this.profesor = profesor;
	}

	public Aula(int id, int maxEstudiantes, Materia materia, Alumno[] alumnos, Profesor profesor) {
		this.id = id;
		this.maxEstudiantes = maxEstudiantes;
		this.materia = materia;
		this.alumnos = alumnos;
		this.profesor = profesor;
	}

	public boolean darClase() {
		return ((!this.profesor.estaAusente()) && (this.profesor.getMateria() == this.materia)
				&& (alumnosDisponibles()));
	}

	public boolean alumnosDisponibles() {
		int count = 0;
		for (int i = 0; i < this.alumnos.length; i++) {
			if (this.alumnos[i].estaAusente()) {
				count++;
			}
		}
		// System.out.println("cuenta " + count);
		return (count < (this.alumnos.length / 2));
	}

	public void entregarNotas() {
		if (darClase()) {
			int hombresAprobados = 0, mujeresAprobadas = 0;
			for (int i = 0; i < this.alumnos.length; i++) {
				if (this.alumnos[i].getSexo() == Sexo.H) {
					if (this.alumnos[i].getNota() >= 5) {
						hombresAprobados++;
					}
				} else {
					if (this.alumnos[i].getNota() >= 5) {
						mujeresAprobadas++;
					}
				}

				// System.out.println(this.alumnos[i].getNombre() + ": " +
				// this.alumnos[i].getNota());
			}
			System.out.println("Hombres aprobados: " + hombresAprobados);
			System.out.println("Mujeres aprobadas: " + mujeresAprobadas + "\n");
		} else {
			System.out.println("No se ha podido dar clase\n");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxEstudiantes() {
		return maxEstudiantes;
	}

	public void setMaxEstudiantes(int maxEstudiantes) {
		this.maxEstudiantes = maxEstudiantes;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", maxEstudiantes=" + maxEstudiantes + ", materia=" + materia + ", alumnos="
				+ Arrays.toString(alumnos) + ", profesor=" + profesor + "]";
	}

}
