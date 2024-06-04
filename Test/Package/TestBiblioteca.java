package Package;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

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
	public void queSePuedaPrestarUnLibroAUnUsuario() throws Exception {
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
	@Test (expected = Exception.class)
	public void queSiLeQuieroPrestarUnLibroAUnUsuarioYNoHayStockOcurraUnaExcepcion() throws Exception {
		//Preparacion de datos
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		//parametros usuarios
			
			String nombreUsuario="Franco Nadal";
			Integer contrasenia=1234;
			Integer dni=4644;
			
			Usuario usuario = new Usuario(nombreUsuario,contrasenia,dni);
			biblioteca.agregarUsuario(usuario);
		//Parametros autor
			String nombre = "Gabriel Marquez";
			Integer idAutor = 1234;
			Autor garciaMarquez = new Autor (nombre,idAutor);
		
			String nombre2="Luis Borges";
			Integer idAutor2=123;
			Autor luisBorges = new Autor (nombre2,idAutor2);
		//Parametros libro
			String titulo = "Cien años de soledad";
			Integer numPaginas = 500;
			Integer codLibro = 1234;
			Integer numCopiasDisponibles = 1;
			Categoria categoria = Categoria.LITERATURA;
			Libro cienAñosDeSoledad = new Libro (titulo, numPaginas, codLibro, numCopiasDisponibles, garciaMarquez, categoria);	
			biblioteca.agregarLibro(cienAñosDeSoledad);
			
		//parametros del prestamo
			Prestamo prestamo = new Prestamo(usuario, cienAñosDeSoledad, new Date());
			biblioteca.prestarLibroAUsuario(prestamo);
			biblioteca.prestarLibroAUsuario(prestamo);
			
		
	}
	
	//fran
	@Test
	public void queSePuedaObtenerLosLibrosQueFueronPrestadosAUnUsuario() throws Exception {
		
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
	
	
	@Test
	public void mostrarLaListaDeLibrosDisponiblesDeUnaBiblioteca() {
		
		 // Preparación de datos
	    Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
	  
	    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
	    
	    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);
	    Libro libro2 = new Libro("El coronel no tiene quien le escriba", 150, 1235, 5, garciaMarquez, Categoria.LITERATURA);
	   
	    
	    biblioteca.agregarLibro(libro1);
	    biblioteca.agregarLibro(libro2);
	 
	  
	    
	    ArrayList <Libro> librosDisponibles = biblioteca.obtenerLibrosDisponibles();
	    
	    //verificamos que tenga 3 libros
	    assertEquals(2,librosDisponibles.size());
	    
	    //Verificamos que los libros esten disponibles
	    
	    assertEquals(libro1,librosDisponibles.get(0));
	    assertEquals(libro2,librosDisponibles.get(1));
	   
		
		
		
		
	}
	
	@Test
	public void queSePuedaObtenerLaListaDeAutores() {
		 // Preparación de datos
	    Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
	  
	    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
	    Autor borges = new Autor ("Borges",2345);
	    
	    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);
	    Libro libro2 = new Libro("El coronel no tiene quien le escriba", 150, 2345, 5, borges, Categoria.LITERATURA);
	   
	    
	    biblioteca.agregarLibro(libro1);
	    biblioteca.agregarLibro(libro2);
		
		HashSet<Autor> autoresEsperados = new HashSet<>();
		autoresEsperados.add(libro1.getAutor());
		autoresEsperados.add(libro2.getAutor());
		
		HashSet<Autor> autoresObtenidos = biblioteca.mostrarListaDeAutores();
		
		assertEquals(autoresEsperados, autoresObtenidos);
	}
	
	@Test
	public void queSePuedaDevolverUnLibro() throws Exception {
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
			
			biblioteca.prestarLibroAUsuario(prestamo);
			
			assertTrue(biblioteca.devolverLibroPrestadoAUnUsuario(prestamo));
			assertEquals(5, cienAñosDeSoledad.getStock().intValue());
	}
	
	@Test
	public void queSePuedaMostrarLaListaDeUsuarios() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		String nombreUsuario="Franco Nadal";
		Integer contrasenia=1234;
		Integer dni=4644;
		
		Usuario usuario = new Usuario(nombreUsuario,contrasenia,dni);
		Usuario usuario1 = new Usuario("Agustín Cangelosi",124141,45128279);
		
		biblioteca.agregarUsuario(usuario);
		biblioteca.agregarUsuario(usuario1);
		
		
		HashSet<Usuario>usuarios = biblioteca.mostrarListaDeUsuarios();
		
		assertTrue(usuarios.contains(usuario));
		assertTrue(usuarios.contains(usuario1));
	}
	
	@Test
	public void queSePuedanMostrarLosUsuariosQueTienenUnLibroEspecificoPrestado() throws Exception {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
	    Usuario usuario = new Usuario("Franco Nadal", 1234, 4644);
	    Usuario usuario2 = new Usuario("Ramon Sosa", 1234, 46445);
	    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
	    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);

	    
	    biblioteca.agregarLibro(libro1);
	    biblioteca.agregarUsuario(usuario);
	    biblioteca.agregarUsuario(usuario2);
	    
	    Prestamo prestamo1 = new Prestamo(usuario, libro1, new Date());
	    Prestamo prestamo2 = new Prestamo(usuario2, libro1, new Date());
	    
	    biblioteca.prestarLibroAUsuario(prestamo1);
	    biblioteca.prestarLibroAUsuario(prestamo2);
	    
	    HashSet<Usuario> usuarios = biblioteca.mostrarLosUsuariosQueTienenUnLibroEspecificoPrestado(libro1);
	    
	    assertTrue(usuarios.contains(usuario));
	    assertTrue(usuarios.contains(usuario2));
	}
	@Test
	public void queSePuedaBuscarUsuarioPorSuDni() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		Integer dniUsuario=4644;
		Usuario usuario = new Usuario("Franco Nadal", 1234, dniUsuario);
		Usuario usuario2 = new Usuario("Franco Nadal", 1234, 567575);
		biblioteca.agregarUsuario(usuario);
		biblioteca.agregarUsuario(usuario2);
		
		Usuario encontrado= biblioteca.buscarUsuarioPorDni(dniUsuario);
		
		assertEquals(usuario, encontrado);
	}
	@Test
	public void queUnUsuarioEnBibliotecaPuedaElegirSusLibrosFavoritos() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		  
	    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
	    Autor borges = new Autor ("Borges",2345);
	    
	    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);
	    Libro libro2 = new Libro("El coronel no tiene quien le escriba", 150, 2345, 5, borges, Categoria.LITERATURA);
	    Integer idUsuario=4644;
	    Usuario usuario = new Usuario("Franco Nadal", 1234, idUsuario);
	    biblioteca.agregarUsuario(usuario);
	    biblioteca.agregarLibro(libro1);
	    biblioteca.agregarLibro(libro2);
	    
	    Boolean sePudo= biblioteca.agregarLibroFavorito(libro1,idUsuario);
	    
	    assertTrue(sePudo);
	}
	
	@Test
	public void  queSePuedaMostrarLosAutoresFavoritosDeUnUsuario() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		  
	    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
	    Autor borges = new Autor ("Borges",2345);
	    
	    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);
	    Libro libro2 = new Libro("El coronel no tiene quien le escriba", 150, 2345, 5, borges, Categoria.LITERATURA);
	    Integer idUsuario=4644;
	    Usuario usuario = new Usuario("Franco Nadal", 1234, idUsuario);
	    biblioteca.agregarUsuario(usuario);
	    biblioteca.agregarLibro(libro1);
	    biblioteca.agregarLibro(libro2);
	    
	    biblioteca.agregarLibroFavorito(libro1,idUsuario);
	    biblioteca.agregarLibroFavorito(libro2, idUsuario);
	
		    
		HashSet<Autor> autoresFavoritos = biblioteca.mostrarAutoresFavoritos(usuario);
		    
		HashSet<Autor> esperadoAutores = new HashSet<>();
		esperadoAutores.add(garciaMarquez);
		esperadoAutores.add(borges);
		    
		assertEquals(esperadoAutores,autoresFavoritos);
		
		
		
		
	}	
	
	@Test
	public void ordenarLibrosPorStock() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
		  
	    Autor garciaMarquez = new Autor("Gabriel Marquez", 1234);
	    Autor borges = new Autor ("Borges",2345); 
	    
	    Libro libro1 = new Libro("Cien años de soledad", 500, 1234, 5, garciaMarquez, Categoria.LITERATURA);
	    Libro libro2 = new Libro("El coronel no tiene quien le escriba", 150, 2345, 10, borges, Categoria.LITERATURA);
	    Libro libro3 = new Libro("En Agosto Nos vemos ", 500, 134, 7, garciaMarquez, Categoria.LITERATURA);
	    
	    biblioteca.agregarLibro(libro1);
	    biblioteca.agregarLibro(libro2);
	    biblioteca.agregarLibro(libro3);
	    
	    biblioteca.ordernarLibrosPorStock();
	    
	    
	    ArrayList<Libro> libros = biblioteca.libros;
	    
	    assertEquals(libro1 , libros.get(0));
	    assertEquals (libro3, libros.get(1));
	    assertEquals (libro2, libros.get(2));
		
		
		
	}
	
	
	
	
}
