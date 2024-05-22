package Package;

import java.util.Objects;

public class Cliente extends Persona {

	private Integer dniCliente;

	public Cliente(String nombre, String apellido, Integer dniCliente) {
		super(nombre, apellido);
		this.dniCliente = dniCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dniCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dniCliente, other.dniCliente);
	}
	
	
	public Integer getDni() {
		return dniCliente;
	}
	
	
	@Override
	public Boolean agregarLibro(Libro libro) {
		return false;
	}
}
