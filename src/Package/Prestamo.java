package Package;

import java.util.Date;
import java.util.Objects;

public class Prestamo {

	private Usuario usuario;
	private Libro libro;
	private Date date;

	public Prestamo(Usuario usuario, Libro libro, Date date) {
		// TODO Auto-generated constructor stub
		this.usuario = usuario;
		this.libro = libro;
		this.date = date;
		
		
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(libro, date, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(libro, other.libro) && Objects.equals(date, other.date)
				&& Objects.equals(usuario, other.usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro cienAñosDeSoledad) {
		this.libro = cienAñosDeSoledad;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
