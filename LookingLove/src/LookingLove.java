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
		String nombre="";
		String apellidos="";
		int edad=18;
		Enum<Sexo> sexo=Sexo.HOMBRE;
		String ciudad="";
		Enum<Complexion> complexion = Complexion.ATLETA;
		Enum<ColorPelo> colorPelo = ColorPelo.CASTAÑO;
		double altura = 1.5;
		Enum<Orientacion> orientacion = Orientacion.AMBOS;
		Enum<Aficiones> aficiones[] = new Aficiones[Aficiones.values().length];
		
		boolean correcto=true;
		Scanner sc=new Scanner (System.in);


		try {			
			System.out.println("REGISTRANDO DATOS DE UNA PERSONA");
			do {
				System.out.println("Introduce nombre");
			
				nombre=sc.nextLine();
			}while(nombre.equals(""));
			
			do {
				System.out.println("Introduce apellidos");
				apellidos=sc.nextLine();
			}while(apellidos.equals(""));
			
			do {
				System.out.println("Introduce edad (desde 18 hasta 100 años)");
				edad=sc.nextInt();
			}while(edad<18 || edad>100);
			
			String sexoStr="";
			do {
				System.out.println("Introduce sexo (h/m)");
				sexoStr = sc.nextLine();
			}while( sexoStr!="h" && sexoStr!="m");
			if(sexoStr.equals("h")) {
				sexo = Sexo.HOMBRE;
			}else {
				sexo = Sexo.MUJER;
			}
			
			do {
				System.out.println("Introduce ciudad");
				ciudad=sc.nextLine();
			}while (ciudad.equals(""));
			
			String complexionStr="";
			do {	
				System.out.println("Complexion (delgado, grande, fuerte, atleta)");
				complexionStr=sc.nextLine();
			} while( complexionStr!="delgado" && complexionStr!="grande" && complexionStr!="fuerte" && complexionStr!="atleta");
			if(complexionStr.equals("delgado")) {				
				complexion = Complexion.DELGADO;
			}else if(complexionStr.equals("grande")) {				
				complexion = Complexion.GRANDE;
			}else if(complexionStr.equals("fuerte")) {				
				complexion = Complexion.FUERTE;
			}else {
				complexion = Complexion.ATLETA;
			}
			
			String colorStr="";
			do {
				System.out.println("Color de pelo (rubio, moreno, pelirrojo, castaño, varios)");
				colorStr=sc.nextLine();
			}while(colorStr!="rubio" && colorStr!="moreno" && colorStr!="pelirrojo" && colorStr!="castaño" && colorStr!="varios");
			if(colorStr.equals("delgado")) {				
				complexion = Complexion.DELGADO;
			}else if(colorStr.equals("grande")) {				
				complexion = Complexion.GRANDE;
			}else if(colorStr.equals("fuerte")) {				
				complexion = Complexion.FUERTE;
			}else {
				complexion = Complexion.ATLETA;
			}
			
			do {
				System.out.println("Introduce altura (desde 1m hasta 2.20m)");
				altura=sc.nextDouble();
			}while(altura<1 || altura>1.20);
			
			String orientacionStr="";
			do {
				System.out.println("¿Qué sexo quieres encontrar? (hombre/mujer/ambos)");
				orientacionStr = sc.nextLine();
			}while( orientacionStr!="hombre" && orientacionStr!="mujer" && orientacionStr!="ambos");
			
			if(orientacionStr.equals("hombre")) {
				orientacion = Orientacion.HOMBRE;
			}else if(orientacionStr.equals("mujer")) {
				orientacion = Orientacion.MUJER;
			}else {
				orientacion = Orientacion.AMBOS;
			}

			int i=0;
			for (Aficiones aficion: Aficiones.values()) { 
			    System.out.println("Te gusta la aficion (si/no): "+aficion ); 
			    String leGusta = sc.nextLine();
			    if(leGusta.equalsIgnoreCase("si")) {
			    	aficiones[i] = aficion;
			    	i++;
			    }
			}
			
		}catch (Exception e) {
			System.out.println("Error al introducir el dato");
			sc.next();
		}
		Persona personaResultado = new Persona(nombre, apellidos, edad, sexo, ciudad, complexion, colorPelo, altura, orientacion, aficiones);
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
				miembros[cantidad + 1] = p;
				// Actualizamos la cantidad actual almacenada en miembros
				cantidad++;
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
			if ( x >= cantidad || x < 0 ) {
				System.out.println("La posicion a eliminar esta fuera del array");
			} else {
				// para eliminar a la persona...
				// tengo que adelantar a todos los demas una casilla
				for ( int i = x ; i < cantidad - 1 ; i++) {
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
	public int busquedaAleatoria(Persona p) {
		int resultado = -1;
		
		if( p.getOrientacion().equals("AMBOS") ) {
			// Si a p le gustan ambos sexos le pasamos uno cualquiera
			resultado = (int)(Math.random()*(cantidad-0+1)+0);
		}else{
			boolean encontrado = false;
			do {				
				// busqueda aleatoria de un sexo acorde con la orientación sexual
				int aleatorio = (int)(Math.random()*(cantidad-0+1)+0);
				
				if( miembros[aleatorio].getSexo().equals( p.getOrientacion() ) ) {
					resultado = aleatorio;
					encontrado = true;
				}
				
			}while(!encontrado);				
		}
		
		return resultado;
	}
	
	public int menu() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("Elige Opción:/n"+
					"1./tAñadir nueva Persona/n"+
					"2./tBuscar emparejamientos/n"+
					"3./tSalir del programa");
			opcionElegida=sc.nextInt();
			
			if(opcionElegida<1 || opcionElegida>3) {
				System.out.println("Error: Opción no disponible (introduce 1, 2 o 3)");
			}
		
		} while(opcionElegida <1 || opcionElegida>3);
		return opcionElegida;
	}
	
	public int menuBuscarEmparejamiento() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("¿Cómo desea buscar emparejamiento?:/n"+
					"1./tFiltrando/n"+
					"2./tPersona con más datos en común/n"+
					"3./tPersonas con aficiones opuestas /n"+
					"4./tBúsqueda aleatoria");
			opcionElegida=sc.nextInt();
			
			if(opcionElegida<1 || opcionElegida>4) {
				System.out.println("Error: Opción no disponible (introduce 1, 2, 3 o 4)");
			}
		
		} while(opcionElegida <1 || opcionElegida>4);
		return opcionElegida;
		
	}
	
}
