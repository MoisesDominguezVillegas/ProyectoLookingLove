
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

	public boolean nuevoMiembro(Persona p) {
		boolean res = true;
		// Hay sitio libre?
		if (cantidad < miembros.length) {
			// Está ya registrado?
			for (int i = 0; i < cantidad; i++) {
				if (miembros[i].equals(p)) {
					res = false;
				}
			}
			
			if(res == true) {
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

	public boolean eliminarMiembro(Persona p) {
		boolean res=false;
		
		// Hay miembros?
		if(cantidad > 0) {
			// en que posición está?
			int posicion=-1;
			for(int i=0 ; i<cantidad ; i++) {
				if(miembros[i].equals(p)) {
					posicion = i;
				}
			}
	 		
			// para eliminar a la persona...
			// tengo que adelantar a todos los demas una casilla
			for(int i=posicion; i<cantidad-1;i++) {
				miembros[i]=miembros[i+1];
				cantidad--;
				res=true;
			}
		}else {
			System.out.println("No hay miembros en la comunidad");
		}
		
		return res;
	}
}
