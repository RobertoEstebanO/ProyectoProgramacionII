package proyecto;

import java.util.Scanner;

public class vehiculos {

	protected String tipo;
	protected String matricula;
	protected int km;
	protected double precio;
	protected String modelo;

	/**
	 * @param matricula
	 * @param km
	 * @param precioDia
	 * @param modelo
	 * @param id
	 */
	public vehiculos(String tipo, String matricula, int km, double precio, String modelo) {
		this.tipo = tipo;
		this.matricula = matricula;
		this.km = km;
		this.precio = precio;
		this.modelo = modelo;

	}

	public String getMatricula() {
		return matricula;
	}

	public int getKilometraje() {
		return km;
	}

	public double getPrecio() {
		return precio;
	}

	public String getModelo() {

		return modelo;

	}

	public String toString() {
		return "Vehiculos [Matricula=" + matricula + ", Km=" + km + ", Precio=" + precio + ", Modelo=" + modelo + "]";
	}

}
