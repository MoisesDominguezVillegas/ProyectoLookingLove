
public class main {

	public static void main(String[] args) {
		System.out.println("######## BIENVENID@ A LOOKINGLOVE ########");
				
		// Creamos la plataforma
		LookingLove plataforma = new LookingLove();
		
		
		// Crear personas de ejemplo...
		registrarDatosEjemplo(plataforma);
		
		
		int opcionElegida;
		do {
			
			opcionElegida = plataforma.menu();
			
			switch (opcionElegida) {
			case 1: //Insertar miembro
				Persona p = plataforma.recogeDatosPersona();
				plataforma.registrarMiembro(p);
				break;
				
			case 2: //Buscar emparejamiento
				int opcion = plataforma.menuBuscarEmparejamiento();
				int personaElegida = plataforma.elegirPersona();

				switch(opcion) {
				case 1: // Filtrando
					System.out.println("BUSQUEDA FILTRADA");
					int encontrado1=plataforma.busquedaFiltrada(plataforma.miembros[personaElegida], personaElegida);
						
					if(encontrado1==-1) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {
						System.out.println("¡¡¡La persona elegida es..."+encontrado1+"!!!");
						System.out.println(plataforma.miembros[encontrado1].toString());						
					}
					break;
					
				case 2: // Más datos en común
					System.out.println("BUSQUEDA CON MAS DATOS EN COMUN");
					int encontrado2=plataforma.busquedaAficionesComun(plataforma.miembros[personaElegida], personaElegida);
					
					if(encontrado2==-1) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {
						System.out.println("¡¡¡La persona elegida es..."+encontrado2+"!!!");
						System.out.println(plataforma.miembros[encontrado2].toString());						
					}
					break;
					
				case 3: // Más aficiones opuestas
					System.out.println("BUSQUEDA CON AFICIONES OPUESTAS");

					break;
					
				default: // Aleatorio
					System.out.println("BUSQUEDA ALEATORIA");
					int encontrado = plataforma.busquedaAleatoria(plataforma.miembros[personaElegida], personaElegida);
					if(encontrado == -1 || encontrado == personaElegida) {
						System.out.println("No hemos podido encontrarle pareja");
					}else {						
						System.out.println("¡¡¡La persona elegida es..."+encontrado+"!!!");
						System.out.println(plataforma.miembros[encontrado].toString());
					}
					System.out.println("\n\n\n");
				}
				break;
				
			default:// Salir
				System.out.println("Hasta pronto");
			}
			
		}while(opcionElegida !=3);

	}

	private static void registrarDatosEjemplo(LookingLove plataforma) {
		Enum<Aficiones> a[] = new Aficiones[9];
		System.out.println("Aniadiendo datos de ejemplo");
		// Ejemplo Persona1
		a = new Aficiones[9];
		a[0]=Aficiones.BICICLETA;
		a[1]=Aficiones.CONOCER;
		a[2]=Aficiones.MUSICA;
		a[3]=Aficiones.VIAJAR;
		Persona ej1= new Persona("Moises", "Garcia", 28, Sexo.HOMBRE, "Sevilla", Complexion.FUERTE, ColorPelo.CASTANIO, 1.7, Orientacion.MUJER, a);
		plataforma.registrarMiembro(ej1);
		
		//Ejemplo Persona2
		a = new Aficiones[9];
		a[0]=Aficiones.CONOCER;
		a[1]=Aficiones.MUSICA;
		Persona ej2= new Persona("Jose", "Jimenez", 19, Sexo.HOMBRE, "Sevilla", Complexion.DELGADO, ColorPelo.RUBIO, 1.65, Orientacion.AMBOS, a);
		plataforma.registrarMiembro(ej2);
		
		//Ejemplo Persona3
		a = new Aficiones[9];
		a[0]=Aficiones.CINE;
		a[1]=Aficiones.MOTOS;
		a[2]=Aficiones.TENIS;
		a[3]=Aficiones.VIAJAR;
		a[4]=Aficiones.MUSICA;
		a[5]=Aficiones.DISCO;
		Persona ej3= new Persona("Maria", "Sanchez", 23, Sexo.MUJER, "Sevilla", Complexion.DELGADO, ColorPelo.RUBIO, 1.7, Orientacion.HOMBRE, a);
		plataforma.registrarMiembro(ej3);
		
		//Ejemplo Persona4
		a = new Aficiones[9];
		a[0]=Aficiones.MUSICA;
		a[1]=Aficiones.DISCO;
		a[2]=Aficiones.TENIS;
		a[3]=Aficiones.VIAJAR;
		Persona ej4= new Persona("Laura", "Jimenez", 30, Sexo.MUJER, "Cadiz", Complexion.DELGADO, ColorPelo.RUBIO, 1.75, Orientacion.AMBOS, a);
		plataforma.registrarMiembro(ej4);
	}

}
