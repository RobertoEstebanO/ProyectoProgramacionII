package proyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.*;

class empresa {

	private String CIF;
	private static Clientes[] cliente;
	private static vehiculos[] vehiculo;

	private static int contador_clientes = 0;
	private static int contador_vehiculos = 0;

	private static solicitud[] solicitudhecha = new solicitud[10];
	private static int contador_solicitudes = 0;

	public static void main(String[] args) throws IOException, DNIException {
		Scanner leer = new Scanner(System.in);
		boolean salir = false;
		int numero;
		empresa agencia = new empresa("FernanRober's Vehículos");
		lecturaVehiculos();
		lecturaClientes();
		do {

			System.out.println("---------------FernanRober'S Vehiculos--------------------------");
			System.out.println("| 1.Conultar Vehiculos disponibles                 			   |");
			System.out.println("| 2.Realizar solicitud de alquiler       			           |");
			System.out.println("| 3.Consultar solicitudes del cliente     			           |");
			System.out.println("| 4.Consultar clientes Vip                   			       |");
			System.out.println("| 5.Consultar descuento cliente          		               |");
			System.out.println("| 6.Consultar número de solicitudes de alquiler de un vehiculo |");
			System.out.println("| 7.Salir                                  			           |");
			System.out.println("----------------------------------------------------------------");

			System.out.println("Introduce el numero del menu: ");
			try {

				numero = leer.nextInt();

				switch (numero) {

				case 1:
					System.out.println("Has seleccionado ver los vehiculos disponibles");

					vehiculosDisponibles();

					break;
				case 2:
					System.out.println("Has seleccionado realizar solicitudes de alquiler:");

					String dni;
					String matricula;
					int tiempo_solicitado;
					boolean auxiliar = true;
					do {
						System.out.println("Por favor, introduzca su Dni:");
						dni = leer.next();
						auxiliar = true;
						try {
							if ((dni.length() < 9 || dni.length() > 9)) {
								throw new DNIException(
										"Error. La longitud del DNI debe ser de 9 caracteres, incluyendo la letra.");

							}

							String parte_numerica = dni.substring(0, dni.length() - 1);

							int numeroDNI = 0;

							numeroDNI = Integer.parseInt(parte_numerica);

						} catch (DNIException dnie) {
							System.out.println(dnie.toString());

							auxiliar = false;

						} catch (NumberFormatException e) {
							System.out.println(e.toString());
							System.out.println("Error. DNI no valido.");
							auxiliar = false;
						}
					} while (auxiliar == false);

					System.out.println("Por favor, introduzca la matricula del vehículo a alquilar:");
					matricula = leer.next();

					System.out.println("Por favor, introduzca el tiempo alquiler (en meses):");
					tiempo_solicitado = leer.nextInt();

					solAlquiler(dni, matricula, tiempo_solicitado);

					break;

				case 3:
					System.out.println("Has seleccionado consultar las solicitudes de un cliente");
					consultaSolicitudesCliente();

					break;
				case 4:
					System.out.println("Has seleccionado consultar si un cliente es VIP");
					consultaClienteConsideradoVip();
					break;
				case 5:
					System.out.println("Has seleccionado consultar si un cliente tiene opcion de descuento");

					consultaDescuentoAlquiler();

					break;
				case 6:
					System.out
							.println("Has seleccionado consultar el numero de solicitudes de alquiler de un vehículo");
					System.out.println("Por favor, ingrese la matrícula del vehículo:");

					String matricula1 = leer.next();

					numeroSolicitudesVehiculo(matricula1);
					break;
				case 7:
					System.out.println("Has salido del programa ");
					salir = true;
					escrituraClientes();
					escrituraVehiculos();

					break;

				}
				if (numero < 1 || numero > 7)
					throw new OpcionNoValidaException("Error. Opcion no valida.");

			} catch (OpcionNoValidaException e) {
				System.out.println(e.toString());

			}

			catch (InputMismatchException ime) {
				System.out.println("Error. El formato de entrada debe ser numérico.");
				leer.next();

			}
		} while (!salir);
	}

	public static void lecturaClientes() {
		File archivo = null;

		try {

			archivo = new File(
					"/Users/fernando/Desktop/RobertoEstebanOlivares-FernandoGuerreroCano-ProyectoProgramacionII/src/proyecto/Clientes.txt");

			Scanner lecturaFichero = new Scanner(archivo);
			String leer;
			String[] palabra;

			while (lecturaFichero.hasNextLine()) {
				leer = lecturaFichero.nextLine();

				palabra = leer.split(" ");
				if (Boolean.parseBoolean(palabra[4]) == true) {

					addClienteVip(palabra[0], palabra[1], Long.parseLong(palabra[2]), Integer.parseInt(palabra[3]),
							Boolean.parseBoolean(palabra[4]), Integer.parseInt(palabra[5]));

				} else {

					addCliente(palabra[0], palabra[1], Long.parseLong(palabra[2]), Integer.parseInt(palabra[3]),
							Boolean.parseBoolean(palabra[4]));

				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Fichero erroneo");
		}

	}

	public static void lecturaVehiculos() {
		File archivo = null;

		try {

			archivo = new File(
					"/Users/fernando/Desktop/RobertoEstebanOlivares-FernandoGuerreroCano-ProyectoProgramacionII/src/proyecto/Vehiculos.txt");

			Scanner lecturaFichero = new Scanner(archivo);
			String leer;
			String[] palabra;

			while (lecturaFichero.hasNextLine()) {
				leer = lecturaFichero.nextLine();

				palabra = leer.split(" ");
				if (palabra[0].equalsIgnoreCase("b")) {

					addAutobus(palabra[0], palabra[1], Integer.parseInt(palabra[2]), Double.parseDouble(palabra[3]),
							palabra[4], Integer.parseInt(palabra[5]), Boolean.parseBoolean(palabra[6]));

				} else if (palabra[0].equalsIgnoreCase("c")) {

					addOtroVehiculo(palabra[0], palabra[1], Integer.parseInt(palabra[2]),
							Double.parseDouble(palabra[3]), palabra[4], Boolean.parseBoolean(palabra[5]));

				}

				else if (palabra[0].equalsIgnoreCase("d")) {

					addOtroVehiculo(palabra[0], palabra[1], Integer.parseInt(palabra[2]),
							Double.parseDouble(palabra[3]), palabra[4], Boolean.parseBoolean(palabra[5]));

				}

				else if (palabra[0].equalsIgnoreCase("m")) {

					addOtroVehiculo(palabra[0], palabra[1], Integer.parseInt(palabra[2]),
							Double.parseDouble(palabra[3]), palabra[4], Boolean.parseBoolean(palabra[5]));

				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Fichero erroneo");
		}
	}

	public static void escrituraClientes() {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(
					"/Users/fernando/Desktop/RobertoEstebanOlivares-FernandoGuerreroCano-ProyectoProgramacionII/src/proyecto/Clientes.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < cliente.length; i++) {
				pw.println(cliente[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void escrituraVehiculos() {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(
					"/Users/fernando/Desktop/RobertoEstebanOlivares-FernandoGuerreroCano-ProyectoProgramacionII/src/proyecto/Vehiculos.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < vehiculo.length; i++) {
				pw.println(vehiculo[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public empresa(String CIF) {
		this.CIF = CIF;
		vehiculo = new vehiculos[20];
		cliente = new Clientes[20];

	}

	public String getCIF() {
		return CIF;
	}

	public static void addVehiculo(String tipo, String matricula, int km, double precio, String modelo) {

		vehiculos ejVehiculo = new vehiculos(tipo, matricula, km, precio, modelo);

		introVehiculo(ejVehiculo, contador_vehiculos);
		contador_vehiculos++;
	}

	public static void addAutobus(String tipo, String matricula, int km, double precio, String modelo, int asientos,
			boolean discapacitados) {

		vehiculos ejAutobus = new autobuses(tipo, matricula, km, precio, modelo, asientos, discapacitados);

		introVehiculo(ejAutobus, contador_vehiculos);
		contador_vehiculos++;
	}

	public static void addOtroVehiculo(String tipo, String matricula, int km, double precio, String modelo,
			boolean aireAcondicionado) {

		vehiculos ejOtroVehiculo = new OtrosVehiculos(tipo, matricula, km, precio, modelo, aireAcondicionado);

		introVehiculo(ejOtroVehiculo, contador_vehiculos);
		contador_vehiculos++;
	}

	public static void introVehiculo(vehiculos ejvehiculo, int posicion) {

		vehiculo[posicion] = ejvehiculo;

	}

	public static void addCliente(String nombre, String dni, long tarjetadecredito, int obtenciondecarnet,
			boolean esVip) {

		Clientes ejCliente = new Clientes(nombre, dni, tarjetadecredito, obtenciondecarnet, esVip);

		introCliente(ejCliente, contador_clientes);
		contador_clientes++;
	}

	public static void addClienteVip(String nombre, String dni, long tarjetadecredito, int obtenciondecarnet,
			boolean esVip, int carnetVip) {

		Clientes ejClienteVip = new vip(nombre, dni, tarjetadecredito, obtenciondecarnet, esVip, carnetVip);

		introCliente(ejClienteVip, contador_clientes);
		contador_clientes++;
	}

	public static void introCliente(Clientes ejcliente, int posicion) {

		cliente[posicion] = ejcliente;
	}

	public static void addSolicitud(Clientes cliente, vehiculos vehiculo, int id_solicitud, int tiemposolicitado,
			String estado) {

		solicitud sol = new solicitud(cliente, vehiculo, id_solicitud, tiemposolicitado, estado);

		introSolicitud(sol, contador_solicitudes);
		contador_solicitudes++;
	}

	public static void introSolicitud(solicitud sol, int posicion) {

		solicitudhecha[posicion] = sol;
	}

	public static void solAlquiler(String dni, String matricula, int tiempo_solicitado) {

		Clientes auxCliente = null;
		vehiculos auxVehiculo = null;
		Scanner leer = new Scanner(System.in);

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i] != null && cliente[i].getDni().equalsIgnoreCase(dni)) {
				auxCliente = cliente[i];

			}

		}
		for (int i = 0; i < vehiculo.length; i++) {
			if (vehiculo[i] != null && vehiculo[i].getMatricula().equalsIgnoreCase(matricula)) {
				auxVehiculo = vehiculo[i];
			}

		}

		if (auxVehiculo == null) {
			System.out.println("El vehículo introducido no se encuentra en nuestra base de datos");
			return;
		}
		Random r = new Random(3999);
		int id = r.nextInt(3999) + 1;

		String estado = "Abierto";
		addSolicitud(auxCliente, auxVehiculo, id, tiempo_solicitado, estado);

		if (auxCliente == null) {
			System.out.println("El cliente introducido no se encuentra en nuestra base de datos");
			System.out.println("Por favor, introduzca los siguientes datos para comenzar a la creación del cliente");

			System.out.println("Nombre:");
			String nombre = leer.next();

			System.out.println("Tarjeta de crédito:");
			long tarjetadecredito = leer.nextLong();

			System.out.println("Año en el que se obtuvo el carnet de conducir:");
			int obtenciondecarnet = leer.nextInt();

			System.out.println("¿Es cliente Vip?, Introduzca (Si/No)");

			boolean esVip = false;
			if (leer.next().equalsIgnoreCase("Si")) {
				esVip = true;
			} else if (leer.next().equalsIgnoreCase("No")) {
				esVip = false;
			} else {
				System.out.println("Por favor, introduzca bien los caracteres pedidos.");
				return;
			}
			if (esVip) {

				Random rd = new Random(3999);
				int carnetVip = rd.nextInt(9);

				addClienteVip(nombre, dni, tarjetadecredito, obtenciondecarnet, esVip, carnetVip);

				for (int i = 0; i < cliente.length; i++) {
					if (cliente[i] != null && cliente[i].getDni().equalsIgnoreCase(dni)) {
						auxCliente = cliente[i];
					}
				}
			} else {
				addCliente(nombre, dni, tarjetadecredito, obtenciondecarnet, esVip);
				for (int i = 0; i < cliente.length; i++) {
					if (cliente[i] != null && cliente[i].getDni().equalsIgnoreCase(dni)) {
						auxCliente = cliente[i];
					}
				}

			}

			for (int i = 0; i < vehiculo.length; i++) {
				if (vehiculo[i] != null && vehiculo[i].getMatricula().equalsIgnoreCase(matricula)) {
					auxVehiculo = vehiculo[i];
				}

			}

			if (auxVehiculo == null) {
				System.out.println("El vehículo introducido no se encuentra en nuestra base de datos");
				return;
			}

			Random rdm = new Random(3999);
			int idd = rdm.nextInt(3999) + 1;

			String estado2 = "Abierto";
			addSolicitud(auxCliente, auxVehiculo, idd, tiempo_solicitado, estado2);

		}

	}

	public int getNumeroSolicitudes() {
		return contador_solicitudes;

	}

	public static void consultaClienteConsideradoVip() {
		Scanner leer = new Scanner(System.in);
		String dni;
		boolean auxiliar = true;
		do {
			System.out.println("Por favor, introduzca su Dni:");
			dni = leer.next();
			auxiliar = true;
			try {
				if ((dni.length() < 9 || dni.length() > 9)) {
					throw new DNIException("Error. La longitud del DNI debe ser de 9 caracteres, incluyendo la letra.");

				}

				String parte_numerica = dni.substring(0, dni.length() - 1);

				int numeroDNI = 0;

				numeroDNI = Integer.parseInt(parte_numerica);

			} catch (DNIException dnie) {
				System.out.println(dnie.toString());

				auxiliar = false;

			} catch (NumberFormatException e) {
				System.out.println(e.toString());
				System.out.println("Error. DNI no valido.");
				auxiliar = false;
			}
		} while (auxiliar == false);

		Clientes auxCliente = null;
		int contadorSolicitudes = 0;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i] != null && cliente[i].getDni().equalsIgnoreCase(dni)) {
				auxCliente = cliente[i];
			}
		}
		if (auxCliente != null && auxCliente.getvip()) {
			System.out.println("Usted es un cliente Vip.\n");
			return;
		} else {
			System.out.println("Usted no es un cliente Vip.\n");
		}

		for (int i = 0; i < solicitudhecha.length; i++) {
			if (solicitudhecha[i] != null && solicitudhecha[i].getCliente() == auxCliente) {
				contadorSolicitudes++;
			}
		}

		if (contadorSolicitudes >= 10) {
			System.out.println("Usted es un cliente Vip.\n");

		}

		if (auxCliente != null && auxCliente.getObtenciondecarnet() >= 10) {

			System.out.println("Usted es un cliente Vip.\n");
		}
	}

	public static void consultaDescuentoAlquiler() {

		Scanner leer = new Scanner(System.in);
		String dni;
		boolean auxiliar = true;
		do {
			System.out.println("Por favor, introduzca su Dni:");
			dni = leer.next();
			auxiliar = true;
			try {
				if ((dni.length() < 9 || dni.length() > 9)) {
					throw new DNIException("Error. La longitud del DNI debe ser de 9 caracteres, incluyendo la letra.");

				}

				String parte_numerica = dni.substring(0, dni.length() - 1);

				int numeroDNI = 0;

				numeroDNI = Integer.parseInt(parte_numerica);

			} catch (DNIException dnie) {
				System.out.println(dnie.toString());

				auxiliar = false;

			} catch (NumberFormatException e) {
				System.out.println(e.toString());
				System.out.println("Error. DNI no valido.");
				auxiliar = false;
			}
		} while (auxiliar == false);
		Clientes ejCliente = null;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i] != null && cliente[i].getDni().equalsIgnoreCase(dni)) {
				ejCliente = cliente[i];
			}
		}
		if (ejCliente != null && ejCliente.getvip() == true) {
			System.out.println("Usted tiene un 20% de descuento.\n");

		}

		else if (ejCliente != null && ejCliente.getvip() == true && ejCliente.getObtenciondecarnet() >= 10) {
			System.out.println("Usted tiene un 25% de descuento.\n");

		}

		else if (ejCliente != null && ejCliente.getObtenciondecarnet() >= 10) {
			System.out.println("Usted tiene un 5% de descuento.\n");

		} else {
			System.out.println("El cliente introducido no tiene ningun tipo de descuento.\n");
		}
	}

	public static void consultaSolicitudesCliente() {

		Scanner leer = new Scanner(System.in);
		String auxdni;
		boolean auxiliar = true;
		do {
			System.out.println("Por favor, introduzca su Dni:");
			auxdni = leer.next();
			auxiliar = true;
			try {
				if ((auxdni.length() < 9 || auxdni.length() > 9)) {
					throw new DNIException("Error. La longitud del DNI debe ser de 9 caracteres, incluyendo la letra.");

				}

				String parte_numerica = auxdni.substring(0, auxdni.length() - 1);

				int numeroDNI = 0;

				numeroDNI = Integer.parseInt(parte_numerica);

			} catch (DNIException dnie) {
				System.out.println(dnie.toString());

				auxiliar = false;

			} catch (NumberFormatException e) {
				System.out.println(e.toString());
				System.out.println("Error. DNI no valido.");
				auxiliar = false;
			}
		} while (auxiliar == false);

		Clientes auxCliente = null;
		int auxCont = 0;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i] != null && cliente[i].getDni().equalsIgnoreCase(auxdni)) {
				auxCliente = cliente[i];
			}
		}

		for (int i = 0; i < solicitudhecha.length; i++) {
			if (solicitudhecha[i] != null && solicitudhecha[i].getCliente() == auxCliente) {
				System.out.println(solicitudhecha[i]);
				auxCont++;
			}
		}
		System.out.println("El cliente introducido tiene " + auxCont + " solicitudes.\n");
	}

	public static void vehiculosDisponibles() {

		vehiculos auxVehiculo = null;
		System.out.println("Vehículos disponibles:\n");

		for (int i = 0; i < vehiculo.length; i++) {

			for (int j = 0; j < solicitudhecha.length; j++) {
				if (solicitudhecha[j] != null && solicitudhecha[j].getVehiculo() == vehiculo[i]) {
					auxVehiculo = vehiculo[i];
				}
			}
			if (vehiculo[i] != null && vehiculo[i] != auxVehiculo) {
				System.out.println(vehiculo[i] + "\n");
			}

		}
	}

	public static void numeroSolicitudesVehiculo(String matricula) {

		vehiculos auxVehiculo = null;
		int contador = 0;

		for (int i = 0; i < vehiculo.length; i++) {
			if (vehiculo[i] != null && vehiculo[i].getMatricula().equalsIgnoreCase(matricula)) {
				auxVehiculo = vehiculo[i];
			}
		}

		for (int j = 0; j < solicitudhecha.length; j++) {
			if (solicitudhecha[j] != null && solicitudhecha[j].getVehiculo() == auxVehiculo) {
				contador++;
				System.out.println(solicitudhecha[j]);

			}

		}
		System.out.println("El vehículo buscado tiene " + contador + " solicitudes activas.\n");
	}

	public static class DNIException extends Exception {

		public DNIException(String mensaje) {
			super(mensaje);
		}
	}

	public static class OpcionNoValidaException extends Exception {

		OpcionNoValidaException(String mensaje) {
			super(mensaje);
		}
	}

}
