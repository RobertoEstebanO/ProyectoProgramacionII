package proyecto;

public class OtrosVehiculos extends vehiculos {
	// c si es coche clasico. d si es deportivo, m si es monovolumen
	private boolean aireAcondicionado;// true o false

	public OtrosVehiculos(String tipo, String matricula, int km, double precio, String modelo,
			boolean aireAcondicionado) {
		super(tipo, matricula, km, precio, modelo);

		this.aireAcondicionado = aireAcondicionado;

	}

	public String getTipo() {
		return tipo;
	}

	public boolean getAireAcondicionado() {
		return aireAcondicionado;
	}

	@Override
	public String toString() {
		return "Vehiculo [Tipo=" + tipo + ", Aire Acondicionado=" + aireAcondicionado + ", Matricula=" + matricula
				+ ", Km=" + km + ", Precio=" + precio + ", Modelo=" + modelo+ "]";
	}

}
