
public class main {

	public static void main(String[] args) {
		System.out.println("######## BIENVENID@ A LOOKINGLOVE ########");
		
		// Creamos la plataforma
		LookingLove plataforma = new LookingLove();
		
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
				switch(opcion) {
				case 1: //Filtrando
					
					break;
				case 2: // Más datos en común
					
					break;
				case 3: // Más aficiones opuestas
					
					break;
				default: // Aleatorio
					
				}
				break;
				
			default:// Salir
				System.out.println("Hasta pronto");
			}
			
		}while(opcionElegida !=3);

	}

}
