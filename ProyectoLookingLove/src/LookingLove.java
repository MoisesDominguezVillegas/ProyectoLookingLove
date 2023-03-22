import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LookingLove {
	Persona[] miembros = new Persona[1000];
	private int cantidad;

	public LookingLove() {
		cantidad = 0;
	}

	public LookingLove(Persona[] miembro) {
		this.miembros = miembro;
		this.cantidad = miembro.length;
	}

	public Persona recogeDatosPersona() {
		// ATRIBUTOS DE PERSONA
		String nombre = "";
		String apellidos = "";
		int edad = 18;
		Enum<Sexo> sexo = Sexo.HOMBRE;
		String ciudad = "";
		Enum<Complexion> complexion = Complexion.ATLETA;
		Enum<ColorPelo> colorPelo = ColorPelo.CASTANIO;
		double altura = 1.5;
		Enum<Orientacion> orientacion = Orientacion.AMBOS;
		Enum<Aficiones> aficiones[] = new Aficiones[Aficiones.values().length];

		boolean correcto = true;

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("REGISTRANDO DATOS DE UNA PERSONA");
			do {
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
			} while (nombre.equals(""));

			sc = new Scanner(System.in);
			do {
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
			} while (apellidos.equals(""));

			sc = new Scanner(System.in);
			do {
				System.out.println("Introduce edad (desde 18 hasta 100 anios)");
				edad = sc.nextInt();
			} while (edad < 18 || edad > 100);

			sc = new Scanner(System.in);
			String sexoStr = "";
			do {
				System.out.println("Introduce sexo (h/m)");
				sexoStr = sc.nextLine();
			} while (!sexoStr.equalsIgnoreCase("h") && !sexoStr.equalsIgnoreCase("m"));
			if (sexoStr.equalsIgnoreCase("h")) {
				sexo = Sexo.HOMBRE;
			} else {
				sexo = Sexo.MUJER;
			}

			sc = new Scanner(System.in);
			do {
				System.out.println("Introduce ciudad");
				ciudad = sc.nextLine();
			} while (ciudad.equals(""));

			sc = new Scanner(System.in);
			String complexionStr = "";
			do {
				System.out.println("Complexion (delgado, grande, fuerte, atleta)");
				complexionStr = sc.nextLine();
			} while (!complexionStr.equalsIgnoreCase("delgado") && !complexionStr.equalsIgnoreCase("grande")
					&& !complexionStr.equalsIgnoreCase("fuerte") && !complexionStr.equalsIgnoreCase("atleta"));
			if (complexionStr.equalsIgnoreCase("delgado")) {
				complexion = Complexion.DELGADO;
			} else if (complexionStr.equalsIgnoreCase("grande")) {
				complexion = Complexion.GRANDE;
			} else if (complexionStr.equalsIgnoreCase("fuerte")) {
				complexion = Complexion.FUERTE;
			} else {
				complexion = Complexion.ATLETA;
			}

			sc = new Scanner(System.in);
			String colorStr = "";
			do {
				System.out.println("Color de pelo (rubio, moreno, pelirrojo, castanio, varios)");
				colorStr = sc.nextLine();
			} while (!colorStr.equalsIgnoreCase("rubio") && !colorStr.equalsIgnoreCase("moreno")
					&& !colorStr.equalsIgnoreCase("pelirrojo") && !colorStr.equalsIgnoreCase("castaño")
					&& !colorStr.equalsIgnoreCase("varios"));
			if (colorStr.equalsIgnoreCase("rubio")) {
				colorPelo = ColorPelo.RUBIO;
			} else if (colorStr.equalsIgnoreCase("moreno")) {
				colorPelo = ColorPelo.MORENO;
			} else if (colorStr.equalsIgnoreCase("pelirrojo")) {
				colorPelo = ColorPelo.PELIRROJO;
			} else if (colorStr.equalsIgnoreCase("castanio")) {
				colorPelo = ColorPelo.CASTANIO;
			} else {
				colorPelo = ColorPelo.VARIOS;
			}

			sc = new Scanner(System.in);
			boolean error = false;
			do {
				error = false;
				try {
					System.out.println("Introduce altura (desde 1m hasta 2,20m)");
					altura = sc.nextDouble();
				} catch (Exception e) {
					error = true;
					System.out.println("Error Introduzca un numero con coma");
					sc.next();
				}
			} while (altura < 1 || altura > 2.20 || error == true);

			sc = new Scanner(System.in);
			String orientacionStr = "";
			do {
				System.out.println("Que sexo quieres encontrar? (hombre/mujer/ambos)");
				orientacionStr = sc.nextLine();
			} while (!orientacionStr.equalsIgnoreCase("hombre") && !orientacionStr.equalsIgnoreCase("mujer")
					&& !orientacionStr.equalsIgnoreCase("ambos"));

			if (orientacionStr.equalsIgnoreCase("hombre")) {
				orientacion = Orientacion.HOMBRE;
			} else if (orientacionStr.equalsIgnoreCase("mujer")) {
				orientacion = Orientacion.MUJER;
			} else {
				orientacion = Orientacion.AMBOS;
			}

			int i = 0;
			for (Aficiones aficion : Aficiones.values()) {
				String leGusta = "";
				do {
					System.out.println("Te gusta la aficion (si/no): " + aficion);
					leGusta = sc.nextLine();
				} while (!leGusta.equalsIgnoreCase("si") && !leGusta.equalsIgnoreCase("no"));

				if (leGusta.equalsIgnoreCase("si")) {
					aficiones[i] = aficion;
				}
				i++;
			}

		} catch (Exception e) {
			System.out.println("Error al introducir el dato");
			sc.next();
		}

		Persona personaResultado = new Persona(nombre, apellidos, edad, sexo, ciudad, complexion, colorPelo, altura,
				orientacion, aficiones);
		return personaResultado;
	}

	// recibe una persona y lo añade al array miembros
	public boolean registrarMiembro(Persona p) {
		boolean res = true;
		// Hay sitio libre?
		if (cantidad < miembros.length) {
			// Está ya registrado?
			for (int i = 0; i < cantidad; i++) {
				if (miembros[i].equals(p)) {
					res = false;
				}
			}

			if (res == true) {
				// hay posiciones libres y no se ha registrado anteriormente
				// Introducimos en el array de miembros en la posición siguiente vacía
				miembros[cantidad] = p;
				// Actualizamos la cantidad actual almacenada en miembros
				cantidad++;
				System.out.println("Aniadido! Somos: " + cantidad + " miembros de " + miembros.length);
			}
		} else {
			// no hay sitio en la comunidad de miembros
			res = false;
		}
		return res;
	}

	public int buscarPosicionPersona(Persona p) {
		int res = -1;

		for (int i = 0; i < cantidad; i++) {
			if (miembros[i].equals(p)) {
				res = i;
			}
		}

		return res;
	}

	public boolean eliminarMiembro(int x) {
		boolean res = false;

		// Hay miembros?
		if (cantidad > 0) {
			// La posicion a eliminar X pertenece al array con miembros
			if (x >= cantidad || x < 0) {
				System.out.println("La posicion a eliminar esta fuera del array");
			} else {
				// para eliminar a la persona...
				// tengo que adelantar a todos los demas una casilla
				for (int i = x; i < cantidad - 1; i++) {
					miembros[i] = miembros[i + 1];
					cantidad--;
					res = true;
				}
			}
		} else {
			System.out.println("No hay miembros en la comunidad");
		}

		return res;
	}

	// Recibo una persona y busco una posicion de persona aleatoria
	public int busquedaAleatoria(Persona p, int posicion) {
		int resultado = -1;
		int intentos = 0;
		System.out.println("... Buscando tu media naranja ...");

		if (p.getOrientacion().equals(Orientacion.AMBOS)) {

			// Si a p le gustan ambos sexos le pasamos uno cualquiera
			do {
				resultado = (int) (Math.random() * (cantidad - 1 - 0 + 1) + 0);
				intentos++;
			} while (resultado == posicion && intentos < cantidad); // No puede emparejar con si mismo

		} else {

			// CREO UN ARRAY DE POSICIONES QUE HAY QUE COMPROBAR
			int[] aleatoriosGenerados = new int[cantidad];
			// relleno array A 0 SIGNIFICA QUE AUN NO SE HA COMPROBADO
			for (int i = 0; i < aleatoriosGenerados.length; i++) {
				aleatoriosGenerados[i] = 0;
			}

			do {
				// busqueda aleatoria de un sexo acorde con la orientación sexual
				int aleatorio = (int) (Math.random() * (cantidad - 1 - 0 + 1) + 0);
				if (aleatoriosGenerados[aleatorio] == 0) {
					if (p.getOrientacion().toString().equals(miembros[aleatorio].getSexo().toString())) {
						resultado = aleatorio;
					}
					// me valga o no... ya he comprobado esa persona
					aleatoriosGenerados[aleatorio] = 1;
					intentos++;
				}
			} while (resultado == -1 && intentos < cantidad);

		}

		return resultado;
	}

	public int menu() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Elige Opcion:\n" + "1.\tAnadir nueva Persona\n" + "2.\tBuscar emparejamientos\n"
					+ "3.\tSalir del programa");
			opcionElegida = sc.nextInt();

			if (opcionElegida < 1 || opcionElegida > 3) {
				System.out.println("Error: Opcion no disponible (introduce 1, 2 o 3)");
			}

		} while (opcionElegida < 1 || opcionElegida > 3);
		return opcionElegida;
	}

	public int menuBuscarEmparejamiento() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println(
					"Como desea buscar emparejamiento?:\n" + "1.\tFiltrando\n" + "2.\tPersona con mas datos en comun\n"
							+ "3.\tPersonas con aficiones opuestas\n" + "4.\tBusqueda aleatoria");
			opcionElegida = sc.nextInt();

			if (opcionElegida < 1 || opcionElegida > 4) {
				System.out.println("Error: Opcion no disponible (introduce 1, 2, 3 o 4)");
			}

		} while (opcionElegida < 1 || opcionElegida > 4);
		return opcionElegida;

	}

	public int elegirPersona() {
		int posicion = 0;
		Scanner sc = new Scanner(System.in);

		// Mostrar listado de personas
		for (int i = 0; i < cantidad; i++) {
			System.out.println(i + ": " + miembros[i].toString());
		}

		do {
			// Elegir entre las mostradas
			System.out.println("Que persona busca pareja?");
			posicion = sc.nextInt();
		} while (posicion < 0 || posicion >= cantidad);

		return posicion;
	}

	public int busquedaFiltrada(Persona persona, int personaElegida) {
		int posicion = -1;

		Scanner sc = new Scanner(System.in);
		int menuFiltro;

		// MENU DE FILTROS
		do {
			System.out.println("Menú Filtros\n" + "1. Por Ciudad\n" + "2. Por edad");
			menuFiltro = sc.nextInt();
			if (menuFiltro < 1 || menuFiltro > 2) {
				System.out.println("Error: Opcion no disponible (introduce 1 o 2)");
			}
		} while (menuFiltro < 1 || menuFiltro > 2);

		int[] posicionesComprobadas = new int[cantidad];
		int cont = 0;

		switch (menuFiltro) {
		case 1: // filtro por ciudad

			String ciudadFiltrada = "";
			do {
				sc = new Scanner(System.in);
				System.out.println("Introduce ciudad:");
				ciudadFiltrada = sc.nextLine();
			} while (ciudadFiltrada == "");

			for (int i = 0; i < posicionesComprobadas.length; i++) {
				posicionesComprobadas[i] = 0; // NO COMPROBADAS
			}

			cont = 0; // limita el bucle infinito
			do {
				int aleatorio = (int) (Math.random() * (cantidad - 1 - 0 + 1) + 0);
				if (posicionesComprobadas[aleatorio] == 0) {
					if (ciudadFiltrada.equalsIgnoreCase(miembros[aleatorio].getCiudad())
							&& persona.getOrientacion().toString().equals(miembros[aleatorio].getSexo().toString())) {
						posicion = aleatorio; // persona encontrada
					}
					posicionesComprobadas[aleatorio] = 1;
					cont++;
				}
			} while (cont < cantidad && posicion == -1);

			break;

		default: // filtro por edad
			int edadFiltrada = 0;
			do {
				sc = new Scanner(System.in);
				try {
					System.out.println("Introduce edad:");
					edadFiltrada = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Error: debe introducir un número");
				}
			} while (edadFiltrada == 0);

			for (int i = 0; i < posicionesComprobadas.length; i++) {
				posicionesComprobadas[i] = 0; // NO COMPROBADAS
			}

			cont = 0; // limita el bucle infinito
			do {
				int aleatorio = (int) (Math.random() * (cantidad - 1 - 0 + 1) + 0);
				if (posicionesComprobadas[aleatorio] == 0) {
					if (edadFiltrada == miembros[aleatorio].getEdad()
							&& persona.getOrientacion().toString().equals(miembros[aleatorio].getSexo().toString())) {
						posicion = aleatorio; // persona encontrada
					}
					posicionesComprobadas[aleatorio] = 1;
					cont++;
				}
			} while (cont < cantidad && posicion == -1);
			break;
		}

		return posicion;
	}

	public int busquedaAficionesComun(Persona p, int personaElegida) {
		int posicion = -1;

		// almacenamos la cantidad de aficiones en comun con persona
		int[] posicionesComprobadas = new int[cantidad];

		// comprobamos cada miembro
		for (int i = 0; i < cantidad; i++) {
			int cantidadAficiones = 0;

			// contabilizar aficiones en comun
			cantidadAficiones = contarAficiones(p.getAficiones(), i);

			posicionesComprobadas[i] = cantidadAficiones;
		}

		// Seleccionamos el miembro con mayor numero de aficiones en comun sin elegir el
		// propio miembro
		int cantidadAficionesComun = 0;
		for (int i = 0; i < posicionesComprobadas.length; i++) {
			if (i != personaElegida && posicionesComprobadas[i] > cantidadAficionesComun) {
				cantidadAficionesComun = posicionesComprobadas[i];
				posicion = i;
			}
		}

		return posicion;
	}

	public int busquedaAficionesOpuestas(Persona p, int personaElegida) {
		int posicion = -1;

		// almacenamos la cantidad de aficiones en comun con persona
		int[] posicionesComprobadas = new int[cantidad];

		// comprobamos cada miembro
		for (int i = 0; i < cantidad; i++) {
			int cantidadAficiones = 0;

			// contabilizar aficiones en comun
			cantidadAficiones = contarAficiones(p.getAficiones(), i);

			posicionesComprobadas[i] = cantidadAficiones;
		}

		// Seleccionamos el miembro con menor numero de aficiones en comun sin elegir el
		// propio miembro
		int cantidadAficionesOpuestas = 1000;
		for (int i = 0; i < posicionesComprobadas.length; i++) {
			if (i != personaElegida && posicionesComprobadas[i] < cantidadAficionesOpuestas) {
				cantidadAficionesOpuestas = posicionesComprobadas[i];
				posicion = i;
			}
		}

		return posicion;
	}

	// Cuenta la cantidad de aficiones en común que tiene el miembro i con un array
	// de aficiones
	private int contarAficiones(Enum<Aficiones>[] aficiones, int i) {
		int total = 0;

		// convierto el array de enum a array String y luego a List		
		List<String> lista=new ArrayList<String>();
		for (Enum<Aficiones> a : aficiones ) {
			lista.add( a.toString() );
		}
		System.out.println(lista);

		// recorro el array de aficion del miembro i
		for (Enum<Aficiones> aficion : miembros[i].getAficiones()) {
			if (lista.contains(aficion)) {
				total++;
			}
		}

		return total;
	}

}
