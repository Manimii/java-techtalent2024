package t09.ejercicio05;

public class MainApp {

	public static void main(String[] args) {

		generarClase();
	}

	public static void generarClase() {
		Persona prof1 = new Profesor("Juan", 35, Sexo.H, Materia.matemáticas);
		Persona prof2 = new Profesor("Cristina", 50, Sexo.M, Materia.filosofía);
		Persona prof3 = new Profesor("Luis", 45, Sexo.H, Materia.física);

		Persona alumno1 = new Alumno("Andrés", 20, Sexo.H);
		Persona alumno2 = new Alumno("Beatriz", 20, Sexo.M);
		Persona alumno3 = new Alumno("Crisian", 20, Sexo.H);
		Persona alumno4 = new Alumno("Dioinsia", 20, Sexo.M);
		Persona alumno5 = new Alumno("Eustaquio", 20, Sexo.H);
		Persona alumno6 = new Alumno("Fátima", 20, Sexo.M);
		Persona alumno7 = new Alumno("Gervasio", 20, Sexo.H);
		Persona alumno8 = new Alumno("Herminia", 20, Sexo.M);
		Persona alumno9 = new Alumno("Ismael", 20, Sexo.H);
		Persona alumno10 = new Alumno("Julia", 20, Sexo.M);

		Persona[] alumnos = { alumno1, alumno2, alumno3, alumno4, alumno5, alumno6, alumno7, alumno8, alumno9,
				alumno10 };

		Aula aula1 = new Aula(1, 10, Materia.matemáticas,(Alumno[]) alumnos, (Profesor) prof1);
		Aula aula2 = new Aula(2, 10, Materia.filosofía,(Alumno[]) alumnos, (Profesor) prof2);
		Aula aula3 = new Aula(3, 10, Materia.física,(Alumno[]) alumnos, (Profesor) prof3);
		Aula aula4 = new Aula(4, 10, Materia.física,(Alumno[]) alumnos, (Profesor) prof1);
	}

}
