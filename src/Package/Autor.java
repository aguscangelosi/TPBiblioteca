package Package;


import java.util.ArrayList;
import java.util.Objects;



public class Autor /*extends Persona*/{

	
	private String nombre;
	private Integer idAutor;
	ArrayList<Libro>libros;
	public Autor(String nombre, Integer idAutor) {
		
		this.nombre = nombre;
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public void agregarLibro(Libro libro) {
		libros.add(libro);
	}
	@Override
	public int hashCode() {
		return Objects.hash(idAutor, libros, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(idAutor, other.idAutor) && Objects.equals(libros, other.libros)
				&& Objects.equals(nombre, other.nombre);
	}
	
}
