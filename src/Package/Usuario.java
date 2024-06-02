package Package;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Usuario extends Persona {

	private Integer dniUsuario;
	private HashSet<Libro> librosFavoritos;

	public Usuario(String nombre, Integer contrasenia, Integer dniUsuario) {
		super(nombre, contrasenia);
		this.dniUsuario = dniUsuario;
		this.librosFavoritos = new HashSet<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dniUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dniUsuario, other.dniUsuario);
	}
	
	
	public Integer getDni() {
		return dniUsuario;
	}
	
	
	public Integer getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(Integer dniUsuario) {
		this.dniUsuario = dniUsuario;
	}


	public HashSet<Libro> getLibrosFavoritos() {
		return librosFavoritos;
	}

	public void setLibrosFavoritos(HashSet<Libro> librosFavoritos) {
		this.librosFavoritos = librosFavoritos;
	}

	@Override
	public Boolean agregarLibro(Libro libro) {
		return  librosFavoritos.add(libro);
	}
	
	
	
}
