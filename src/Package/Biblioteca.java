package Package;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Libro>libros;
	private ArrayList<Autor>autores;
	private ArrayList<Cliente>clientes;
	
	public Biblioteca() {
		this.libros = new ArrayList<>();
		this.autores = new ArrayList<>();
		this.clientes = new ArrayList<>();
		}
	

	public void agregarLibro(Libro libro) {
		libro.agregarCopia();
		Autor autor = libro.getAutor();
		
		agregarAutor(autor);
		
		if(buscarLibroPorCodigo(libro.getCodLibro()) == null) {
			libros.add(libro);
			autor.agregarLibro(libro);
		}
	}
	
	
	
	public void agregarAutor(Autor autor) {
		if(buscarAutorPorCodigo(autor.getCodAutor()) == null) {
			autores.add(autor);
		}
	}
	
	public void registrarCliente(Cliente cliente) {
		if(buscarClientePorDni(cliente.getDni()) == null) {
			clientes.add(cliente);
		}
	}
	
	public Cliente buscarClientePorDni(Integer dni) {
		for(Cliente cliente : clientes) {
			if(cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}
	
	
	public Libro buscarLibroPorCodigo(Integer codigo) {
		for(Libro libro : libros) {
			if(libro.getCodLibro().equals(codigo)) {
				return libro;
			}
		}
		return null;
	}
	
	
	
	public Autor buscarAutorPorCodigo(Integer codigo) {
		for(Autor autor : autores) {
			if(autor.getCodAutor().equals(codigo)) {
				return autor;
			}
		}
		return null;
	}

	

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	

	public ArrayList<Libro> obtenerLibrosEscritosPorAutorConSuCodigo(Integer codAutor) {
		Autor autor = buscarAutorPorCodigo(codAutor);
		
		return autor.getLibros();
	}
	
	
}
