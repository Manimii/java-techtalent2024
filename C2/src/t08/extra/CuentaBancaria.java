package t08.extra;

/*
 * Problema: Crea una clase llamada CuentaBancaria que tenga como atributos número de cuenta y saldo.
 *  Implementa métodos para depositar y retirar dinero de la cuenta.
 * 
 * */
public class CuentaBancaria {

	private String numeroDeCuenta;
	private double saldo;

	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public CuentaBancaria(String numeroDeCuenta, double saldo) {
		this.numeroDeCuenta = numeroDeCuenta;
		this.saldo = saldo;
	}

	public void depositar(double dinero) {
		this.saldo = saldo + dinero;
	}

	public void retirar(double dinero) {
		this.saldo = saldo - dinero;
	}
}
