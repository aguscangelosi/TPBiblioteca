package Package;

import java.util.Objects;

public class Usuario extends Persona {

	private Integer dniUsuario;

	public Usuario(String nombre, Integer contrasenia, Integer dniUsuario) {
		super(nombre, contrasenia);
		this.dniUsuario = dniUsuario;
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
	
	
	@Override
	public Boolean agregarLibro(Libro libro) {
		return false;
	}
}
