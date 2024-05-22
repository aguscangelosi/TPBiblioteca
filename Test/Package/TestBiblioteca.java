package Package;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestBiblioteca {

	@Test
	public void queSePuedaAgregarUnLibroALaBiblioteca() {
		Biblioteca biblioteca = new Biblioteca();
		
		//Parametros autor
		String nombre = "Gabriel";
		String apellido = "Garcia Marquez";
		Integer codAutor = 1234;
		
		Autor garciaMarquez = new Autor (nombre, apellido, codAutor);
		
		//Parametros libro
		String titulo = "Cien años de soledad";
		Integer numPaginas = 500;
		Integer codLibro = 1234;
		Integer numCopiasDisponibles = 5;
		Autor autor = garciaMarquez;
		Categoria categoria = Categoria.LITERATURA;
		
		Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, autor, categoria);
		
		biblioteca.agregarLibro(cienAñosDeSoledad);
		
		Libro libroEsperado = cienAñosDeSoledad;
		Libro libroEncontrado = biblioteca.getLibros().get(0);
		
		assertEquals(libroEsperado, libroEncontrado);
	}
	
	@Test
	public void queSeAgregueUnaCopiaAlAgregarUnLibro() {
		Biblioteca biblioteca = new Biblioteca();
		
		//Parametros autor
		String nombre = "Gabriel";
		String apellido = "Garcia Marquez";
		Integer codAutor = 1234;
		
		Autor garciaMarquez = new Autor (nombre, apellido, codAutor);
		
		//Parametros libro
		String titulo = "Cien años de soledad";
		Integer numPaginas = 500;
		Integer codLibro = 1234;
		Integer numCopiasDisponibles = 5;
		Autor autor = garciaMarquez;
		Categoria categoria = Categoria.LITERATURA;
		
		Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, autor, categoria);
		
		biblioteca.agregarLibro(cienAñosDeSoledad);
		
		Integer cantidadEsperada = 1;
		Integer cantidadObtenida = cienAñosDeSoledad.getNumCopiasDisponibles();
	}
	


	@Test
	public void queSePuedanObtenerLosLibrosEscritosPorUnAutorConSuCodigo(){
		
		Biblioteca biblioteca = new Biblioteca();
		
		//Parametros autor
		String nombre = "Gabriel";
		String apellido = "Garcia Marquez";
		Integer codAutor = 1234;
		
		Autor garciaMarquez = new Autor (nombre, apellido, codAutor);
		
		//Parametros libro
		String titulo = "Cien años de soledad";
		Integer numPaginas = 500;
		Integer codLibro = 1234;
		Integer numCopiasDisponibles = 5;
		Autor autor = garciaMarquez;
		Categoria categoria = Categoria.LITERATURA;
		
		Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, autor, categoria);
		
		biblioteca.agregarLibro(cienAñosDeSoledad);
		
		ArrayList<Libro>librosAutor = biblioteca.obtenerLibrosEscritosPorAutorConSuCodigo(codAutor);
		
		Libro libroEsperado = cienAñosDeSoledad;
		Libro libroEncontrado = librosAutor.get(0);
	}
	
	@Test
	public void queSePuedaRegistrarUnClienteEnLaBiblioteca() {
		Biblioteca biblioteca = new Biblioteca();
		
		String nombre = "Pedro";
		String apellido = "Gomez";
		Integer dniCliente = 1234;
		
		Cliente cliente = new Cliente(nombre, apellido, dniCliente);
		
		biblioteca.registrarCliente(cliente);
		
		Cliente clienteEsperado = cliente;
		Cliente clienteEncontrado = biblioteca.buscarClientePorDni(dniCliente);
		
		assertEquals(clienteEsperado, clienteEncontrado);
	}
	
	
	
	
	
}
