package Package;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;







public class TestBiblioteca {
@Test
	public void queSePuedaAgregarUnLibroALaBiblioteca() {
		
		//preparacion de datos
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		
		//Parametros autor
				String nombre = "Gabriel";
				Integer idAutor = 1234;
				Autor garciaMarquez = new Autor (nombre,idAutor);
		//Parametros libro
				String titulo = "Cien años de soledad";
				Integer numPaginas = 500;
				Integer codLibro = 1234;
				Integer numCopiasDisponibles = 5;
				Autor autor = garciaMarquez;
				Categoria categoria = Categoria.LITERATURA;
				Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, autor, categoria);	
				Libro cienAñosDeSoledad2 = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, autor, categoria);	
				
		//ejecucion
				Boolean sePudo=biblioteca.agregarLibro(cienAñosDeSoledad);
				Boolean sePudo2=biblioteca.agregarLibro(cienAñosDeSoledad2);
				//agregar el 2do libro y ayudar con la verificacion
		//verificacion
				
				Integer valorEsperado=1;
				Integer valoractual= biblioteca.libros.size();
				
				assertEquals(valorEsperado, valoractual);
				
				
			
				assertTrue(sePudo);
				assertNull(sePudo2);
	}
	
	


	@Test
	public void queSePuedanObtenerLosLibrosEscritosPorUnAutor() {
		//Preparacion de datos
			Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		//Parametros autor
			String nombre = "Gabriel Marquez";
			Integer idAutor = 1234;
			Autor garciaMarquez = new Autor (nombre,idAutor);
		
			String nombre2="Luis Borges";
			Integer idAutor2=123;
			Autor luisBorges = new Autor (nombre,idAutor2);
		//Parametros libro
			String titulo = "Cien años de soledad";
			Integer numPaginas = 500;
			Integer codLibro = 1234;
			Integer numCopiasDisponibles = 5;
			
			Categoria categoria = Categoria.LITERATURA;
			Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, garciaMarquez, categoria);	
			Libro cienAñosDeSoledad2 = new Libro (titulo, numPaginas, 141, numCopiasDisponibles, garciaMarquez, categoria);
			Libro libroParaBorges= new Libro(titulo, numPaginas, 4, numCopiasDisponibles, luisBorges, categoria);
			
			biblioteca.agregarLibro(cienAñosDeSoledad);
			biblioteca.agregarLibro(cienAñosDeSoledad2);
			biblioteca.agregarLibro(libroParaBorges);
			
			
			//logica
			ArrayList<Libro>librosAutor = biblioteca.obtenerLibrosEscritosPorAutorConSuCodigo(idAutor);
			
			//verificacion
			
			int valoresperado=2;
			int valorActual = librosAutor.size();
			
			assertEquals(valoresperado, valorActual);
		
		
		
	}
	@Test
	//agus
	public void queSePuedaAgregarUnNuevoUsuarioAlaBibliotecaYqueSoloPuedeRepetirseSuContrasenia() {
		//Preparacion de datos
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		String nombreUsuario="Franco Nadal";
		Integer contrasenia=1234;
		Integer dni=4644;
		
		Usuario usuario = new Usuario(nombreUsuario,contrasenia,dni);
		Usuario usuario1 = new Usuario(nombreUsuario,124141,dni);
		//logica
		Boolean sepudo= biblioteca.agregarUsuario(usuario);
		Boolean noSePuede= biblioteca.agregarUsuario(usuario1);
		//verifiacion
		assertTrue(sepudo);
		assertFalse(noSePuede);
	}
	
	@Test
	//fran
	public void queSePuedaPrestarUnLibroAUnUsuario() {
		//Preparacion de datos
		
			//parametros usuarios
				Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
				String nombreUsuario="Franco Nadal";
				Integer contrasenia=1234;
				Integer dni=4644;
				
				Usuario usuario = new Usuario(nombreUsuario,contrasenia,dni);
			
			//Parametros autor
				String nombre = "Gabriel Marquez";
				Integer idAutor = 1234;
				Autor garciaMarquez = new Autor (nombre,idAutor);
			
				String nombre2="Luis Borges";
				Integer idAutor2=123;
				Autor luisBorges = new Autor (nombre,idAutor2);
			//Parametros libro
				String titulo = "Cien años de soledad";
				Integer numPaginas = 500;
				Integer codLibro = 1234;
				Integer numCopiasDisponibles = 5;
				
				Categoria categoria = Categoria.LITERATURA;
				Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, garciaMarquez, categoria);	
				Libro cienAñosDeSoledad2 = new Libro (titulo, numPaginas, 141, numCopiasDisponibles, garciaMarquez, categoria);
				Libro libroParaBorges= new Libro(titulo, numPaginas, 4, 5, luisBorges, categoria);
				
				biblioteca.agregarLibro(cienAñosDeSoledad);
				biblioteca.agregarLibro(cienAñosDeSoledad2);
				biblioteca.agregarLibro(libroParaBorges);
				biblioteca.agregarUsuario(usuario);
				
				
				Prestamo prestamo = new Prestamo(usuario, cienAñosDeSoledad, new Date());
				
				//logica
				Boolean sePudo= biblioteca.prestarLibroAUsuario(prestamo);
				//verificacion
				assertTrue(sePudo);
				assertEquals(4, cienAñosDeSoledad.getStock().intValue());
				
				}
	
	//fran
	@Test
	public void queSePuedaObtenerLosLibrosQueFueronPrestadosAUnUsuario() {
		
		    // Preparación de datos
		    Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		    Usuario usuario = new Usuario("Franco Nadal", 1234, 4644);
		    Usuario usuario2 = new Usuario("Ramon Sosa", 1234, 46445);
		    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
		    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);
		    Libro libro2 = new Libro("El coronel no tiene quien le escriba", 150, 1235, 5, garciaMarquez, Categoria.LITERATURA);
		    Libro libro3 = new Libro("El coronel no tiene quien le escriba", 150, 1235, 5, garciaMarquez, Categoria.LITERATURA);
		    
		    biblioteca.agregarLibro(libro1);
		    biblioteca.agregarLibro(libro2);
		    biblioteca.agregarLibro(libro3);
		    biblioteca.agregarUsuario(usuario);
		    biblioteca.agregarUsuario(usuario2);
		    
		    Prestamo prestamo1 = new Prestamo(usuario, libro1, new Date());
		    Prestamo prestamo2 = new Prestamo(usuario, libro2, new Date());
		    Prestamo prestamo3 = new Prestamo(usuario2, libro1, new Date());
		    
		    biblioteca.prestarLibroAUsuario(prestamo1);
		    biblioteca.prestarLibroAUsuario(prestamo2);
		    biblioteca.prestarLibroAUsuario(prestamo3);
		    
		    // Lógica
		    ArrayList<Libro> librosPrestados = biblioteca.obtenerLibrosPrestadosAUnUsuario(usuario);
		    
		    // Verificación
		    assertEquals(2, librosPrestados.size());
		    assertTrue(librosPrestados.contains(libro1));
		    assertTrue(librosPrestados.contains(libro2));
	}
}
