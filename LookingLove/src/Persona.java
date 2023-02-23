import java.util.Arrays;
import java.util.Objects;

public class Persona {

	// ATRIBUTOS DE PERSONA
	private String nombre;
	private String apellidos;
	private int edad;
	private Enum<Sexo> sexo;
	private String ciudad;
	private Enum<Complexion> complexion;
	private Enum<ColorPelo> colorPelo;
	private double altura;
	private Enum<Orientacion> orientacion;
	private Enum<Aficiones> aficiones[];

	// CONSTRUCTOR VACÍO
	public Persona() {
		this.nombre = "";
		this.apellidos = "";
		this.edad = 18;
		this.sexo = Sexo.HOMBRE;
		this.ciudad = "";
		this.complexion = Complexion.ATLETA;
		this.colorPelo = ColorPelo.CASTAÑO;
		this.altura = 1.5;
		this.orientacion = Orientacion.AMBOS;
		this.aficiones = new Aficiones[9];
	}

	// CONSTRUCTOR CON DATOS
	public Persona(String nombre, String apellidos, int edad, Enum<Sexo> sexo, String ciudad,
			Enum<Complexion> complexion, Enum<ColorPelo> colorPelo, double altura, 
			Enum<Orientacion> orientacion, Enum<Aficiones>[] aficiones) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.complexion = complexion;
		this.colorPelo = colorPelo;
		this.altura = altura;
		this.orientacion = orientacion;
		this.aficiones = aficiones;
	}
	
	// MÉTODOS GETTERS Y SETTERS
	
	public String getNombre() {
		return this.nombre;
	}	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return this.edad;
	}

	public Enum<ColorPelo> getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(Enum<ColorPelo> colorPelo) {
		this.colorPelo = colorPelo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Enum<Orientacion> getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Enum<Orientacion> orientacion) {
		this.orientacion = orientacion;
	}

	public Enum<Aficiones>[] getAficiones() {
		return aficiones;
	}

	public void setAficiones(Enum<Aficiones>[] aficiones) {
		this.aficiones = aficiones;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Enum<Sexo> getSexo() {
		return this.sexo;
	}

	public void setSexo(Enum<Sexo> sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Enum<Complexion> getComplexion() {
		return this.complexion;
	}

	public void setComplexion(Enum<Complexion> complexion) {
		this.complexion = complexion;
	}

	

	// MÉTODO TOSTRING	
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo="
				+ sexo + ", ciudad=" + ciudad + ", complexion=" + complexion + ", colorPelo=" + colorPelo + ", altura="
				+ altura + ", orientacion=" + orientacion + ", aficiones=" + Arrays.toString(aficiones) + "]";
	}

	// MÉTODO HASHCODE DE PERSONA
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(aficiones);
		result = prime * result
				+ Objects.hash(altura, apellidos, ciudad, colorPelo, complexion, edad, nombre, orientacion, sexo);
		return result;
	}

	// MÉTODO EQUALS DE PERSONA
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Arrays.equals(aficiones, other.aficiones)
				&& Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(apellidos, other.apellidos) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(colorPelo, other.colorPelo) && Objects.equals(complexion, other.complexion)
				&& edad == other.edad && Objects.equals(nombre, other.nombre)
				&& Objects.equals(orientacion, other.orientacion) && Objects.equals(sexo, other.sexo);
	}
	
	

}
