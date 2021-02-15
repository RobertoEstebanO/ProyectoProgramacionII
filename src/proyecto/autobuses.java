package proyecto;

public class autobuses extends vehiculos {
	private int asientos;
	private boolean discapacitados;

	public autobuses(String tipo, String matricula, int km, double precio, String modelo, int asientos,
			boolean discapacitados) {
		super(tipo, matricula, km, precio, modelo);
		this.asientos = asientos;
		this.discapacitados = discapacitados;

	}

	public int getAsientos() {
		return asientos;
	}

	public boolean getDiscapacitados() {
		return discapacitados;
	}

	@Override
	public String toString() {
		return "Autobus [Asientos=" + asientos + ", Discapacitados=" + discapacitados + ", Matricula=" + matricula
				+ ", Km=" + km + ", Precio=" + precio + ", Modelo=" + modelo +"]";
	}

}
