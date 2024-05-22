package Package;

import java.util.ArrayList;
import java.util.Objects;

public class Autor extends Persona{

	
	private Integer codAutor;
	private ArrayList<Libro>libros;

	public Autor(String nombre, String apellido, Integer codAutor) {
		super(nombre, apellido);
		this.codAutor = codAutor;
		this.libros = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codAutor);
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
		return Objects.equals(codAutor, other.codAutor);
	}

	
	
	
	public Integer getCodAutor() {
		return codAutor;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	@Override
	public Boolean agregarLibro(Libro libro) {
		return libros.add(libro);
	}
	
	
	
}
