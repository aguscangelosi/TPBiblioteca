package Package;

import java.util.Objects;



public class Libro {

	private String nombre;
	private Integer numPags;
	private Integer idLibro;
	private Integer stock;
	private Autor autor;
	private Categoria categoria;
	public Libro(String nombre, Integer numPags, Integer idLibro, Integer stock, Autor autor, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.numPags = numPags;
		this.idLibro = idLibro;
		this.stock = stock;
		this.autor = autor;
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNumPags() {
		return numPags;
	}
	public void setNumPags(Integer numPags) {
		this.numPags = numPags;
	}
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(autor, categoria, idLibro, nombre, numPags, stock);
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
		return Objects.equals(autor, other.autor) && categoria == other.categoria && Objects.equals(idLibro, other.idLibro)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numPags, other.numPags)
				&& Objects.equals(stock, other.stock);
	}

	
	
	
}
