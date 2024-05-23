package Package;

public abstract class Persona {

	
	private String nombre;
	private Integer contrasenia;
	
	
	public Persona(String nombre, Integer contrasenia) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public abstract Boolean agregarLibro(Libro libro);
	
	
	
	
	
}
