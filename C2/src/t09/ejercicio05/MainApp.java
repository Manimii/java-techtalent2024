package t09.ejercicio05;

public class MainApp {

	public static void main(String[] args) {

		Profesor prof1 = new Profesor("Juan", 35, Sexo.H, Materia.matemáticas);
		Profesor prof2 = new Profesor("Cristina", 50, Sexo.M, Materia.filosofía);
		Profesor prof3 = new Profesor("Luis", 45, Sexo.H, Materia.física);

		Alumno alumno1 = new Alumno("Andrés", 20, Sexo.H);
		Alumno alumno2 = new Alumno("Beatriz", 20, Sexo.M);
		Alumno alumno3 = new Alumno("Crisian", 20, Sexo.H);
		Alumno alumno4 = new Alumno("Dioinsia", 20, Sexo.M);
		Alumno alumno5 = new Alumno("Eustaquio", 20, Sexo.H);
		Alumno alumno6 = new Alumno("Fátima", 20, Sexo.M);
		Alumno alumno7 = new Alumno("Gervasio", 20, Sexo.H);
		Alumno alumno8 = new Alumno("Herminia", 20, Sexo.M);
		Alumno alumno9 = new Alumno("Ismael", 20, Sexo.H);
		Alumno alumno10 = new Alumno("Julia", 20, Sexo.M);

		Alumno[] alumnos = { alumno1, alumno2, alumno3, alumno4, alumno5, alumno6, alumno7, alumno8, alumno9,
				alumno10 };

		Aula aula1 = new Aula(1, 10, Materia.matemáticas,(Alumno[]) alumnos, (Profesor) prof1);
		Aula aula2 = new Aula(2, 10, Materia.filosofía,(Alumno[]) alumnos, (Profesor) prof2);
		Aula aula3 = new Aula(3, 10, Materia.física,(Alumno[]) alumnos, (Profesor) prof3);
		Aula aula4 = new Aula(4, 10, Materia.física,(Alumno[]) alumnos, (Profesor) prof1);
		
		aula1.entregarNotas();
		aula2.entregarNotas();
		aula3.entregarNotas();
		aula4.entregarNotas();
	}



}
