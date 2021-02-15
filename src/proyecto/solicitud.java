package proyecto;

/*
 * Esta clase sirve para organizar las solicitudes
 * @author: Roberto Esteban Olivares y Fernando Guerro Cano.
 * @version:10/03/2020
 * @see: Clientes#
 */
public class solicitud {
	private Clientes cliente;
	private vehiculos vehiculo;
	private int id_solicitud;
	private int tiempo_solicitado;
	private String estado;

	public solicitud(Clientes cliente, vehiculos vehiculo, int id_solicitud, int tiempoSolicitado, String estado) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.id_solicitud = id_solicitud;
		this.tiempo_solicitado = tiempoSolicitado;
		this.estado = estado;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public vehiculos getVehiculo() {
		return vehiculo;
	}

	public int getId_Solicitud() {
		return id_solicitud;
	}

	public int getTiempoSolicitado() {
		return tiempo_solicitado;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Solicitud [Vehiculo=" + vehiculo + ", Id Solicitud=" + id_solicitud + ", Tiempo Solicitado="
				+ tiempo_solicitado + ", Estado=" + estado + "]";
	}

}
