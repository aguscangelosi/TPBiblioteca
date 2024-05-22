package Package;

import java.util.Objects;

public class Libro {

	private String titulo;
	private Integer numPaginas;
	private Integer codLibro;
	private Integer numCopiasDisponibles;
	private Autor autor;
	private Categoria categoria;
	
	
	public Libro(String titulo, Integer numPaginas, Integer codLibro, Integer numCopiasDisponibles, Autor autor,
			Categoria categoria) {
		this.titulo = titulo;
		this.numPaginas = numPaginas;
		this.codLibro = codLibro;
		this.numCopiasDisponibles = numCopiasDisponibles;
		this.autor = autor;
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codLibro);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(codLibro, other.codLibro);
	}

	public Integer getCodLibro() {
		return codLibro;
	}


	public String getTitulo() {
		return titulo;
	}


	public Integer getNumPaginas() {
		return numPaginas;
	}

	public Integer getNumCopiasDisponibles() {
		return numCopiasDisponibles;
	}


	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}


	public void agregarCopia() {
		this.numCopiasDisponibles+=1;
	}
	
	
	
}
