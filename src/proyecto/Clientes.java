package proyecto;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Clientes {

	protected String nombre;
	protected String dni;
	protected long tarjetadecredito;
	protected boolean esVip;
	protected int obtenciondecarnet;

	public Clientes(String nombre, String dni, long tarjetadecredito, int obtenciondecarnet, boolean esVip) {
		this.nombre = nombre;
		this.dni = dni;
		this.tarjetadecredito = tarjetadecredito;
		this.obtenciondecarnet = obtenciondecarnet;
		this.esVip = esVip;
	}

	public String getnombre() {
		return nombre;
	}

	public boolean getvip() {
		return esVip;
	}

	public String getDni() {
		return dni;
	}

	public long getTarjetadecredito() {
		return tarjetadecredito;
	}

	public int getObtenciondecarnet() {
		return obtenciondecarnet;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Dni=" + dni + ", Tarjeta de credito=" + tarjetadecredito + ", ¿es Vip? =" + esVip
				+ ", Obtencion de carnet=" + obtenciondecarnet;
	}

}
