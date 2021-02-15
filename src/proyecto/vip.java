package proyecto;

public class vip extends Clientes {
	private int carnetVip;

	public vip(String nombre, String dni, long tarjetadecredito, int obtenciondecarnet, boolean esVip, int carnetVip) {
		super(nombre, dni, tarjetadecredito, obtenciondecarnet, esVip);
		this.carnetVip = carnetVip;

	}

	public int getNumero_carnet_vip() {
		return carnetVip;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Dni=" + dni + ", Tarjeta de credito=" + tarjetadecredito + ", ¿es Vip? =" + esVip
				+ ", Obtencion de carnet=" + obtenciondecarnet + "carnetVip=" + carnetVip;
	}

}
