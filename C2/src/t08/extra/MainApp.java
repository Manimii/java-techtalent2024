package t08.extra;

public class MainApp {
	
	public static void main(String[] args) {
		// Ejemplo de creación de objetos Empleado
		Empleado empleado1 = new Empleado("Juan", 30, 2500.0);
		Empleado empleado2 = new Empleado("María", 35, 3000.0);

		// Ejemplo de cálculo de salario anual
		System.out.println("Salario anual de " + empleado1.getNombre() + ": $" + empleado1.calcularSalarioAnual());
		System.out.println("Salario anual de " + empleado2.getNombre() + ": $" + empleado2.calcularSalarioAnual());

		// Ejemplo de creación de objeto CuentaBancaria
		CuentaBancaria cuenta1 = new CuentaBancaria("123456", 1000.0);

		// Ejemplo de operaciones en cuenta bancaria
		cuenta1.depositar(500.0);
		cuenta1.retirar(200.0);
		System.out.println("Saldo actual: $" + cuenta1.getSaldo());

		// Ejemplo de creación de objeto Libro
		Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);

		// Ejemplo de creación de objeto Coche
		Coche coche1 = new Coche("Toyota", "Corolla", 2022);

		// Mostrar información del libro y del coche
		System.out.println("Libro: " + libro1.getTitulo() + ", Autor: " + libro1.getAutor() + ", Año de Publicación: "
				+ libro1.getPublicacion());
		System.out.println("Coche: " + coche1.getMarca() + " " + coche1.getModelo() + ", Año de Fabricación: "
				+ coche1.getFabricacion());
	}
}
