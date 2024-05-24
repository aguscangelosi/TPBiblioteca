package Package;

import java.util.ArrayList;
import java.util.HashSet;



public class Biblioteca {
	
	private String nombre;
	ArrayList<Libro>libros;
	HashSet<Usuario>usuarios;
	ArrayList<Prestamo>prestamos;


	public Biblioteca(String nombre) {

		this.nombre = nombre;
		this.libros= new ArrayList<>();
		this.usuarios= new HashSet<>();
		this.prestamos= new ArrayList<>();
		
		
		
	}

	public Boolean agregarLibro(Libro libro) {
	Libro  libroEncontrado = buscarLibroPorCodigo(libro.getIdLibro());


	if(libroEncontrado==null) {
		libros.add(libro);
	return true;
	}

	//ese libro ya existe
	return null;
		
	}

	public Libro buscarLibroPorCodigo(Integer codigo) {
		for(Libro libro : libros) {
			if(libro.getIdLibro().equals(codigo)) {
				return libro;
			}
		}
		return null;
	}

	public ArrayList<Libro> obtenerLibrosEscritosPorAutorConSuCodigo(Integer idAutor) {
		ArrayList<Libro>librosDelAutor= new ArrayList<>();
		for (Libro libro : libros) {
			if(libro.getAutor().getIdAutor().equals(idAutor)) {
				librosDelAutor.add(libro);
				
			}
		}
		//no tiene libros
		return librosDelAutor;
	}

	public Boolean agregarUsuario(Usuario usuario) {
		
		return usuarios.add(usuario);
	}



	public Boolean prestarLibroAUsuario(Prestamo prestamo) {
	    if (prestamo.getLibro().getStock() > 0 && usuarios.contains(prestamo.getUsuario())) {
	        prestamos.add(prestamo);
	        Libro libro = prestamo.getLibro();
	        Usuario usuario = prestamo.getUsuario();
	        libro.setStock(libro.getStock() - 1);
	        return true;
	    }
	    return false;
	}


	public Boolean devolverLibroPrestadoAUnUsuario(Prestamo prestamo) {
		if(prestamos.contains(prestamo)) {
			prestamos.remove(prestamo);
			Libro libro = prestamo.getLibro();
			libro.setStock(libro.getStock() + 1);
			return true;
			
		}
		return null;
		
	}

	public ArrayList<Libro> obtenerLibrosPrestadosAUnUsuario(Usuario usuario) {
		ArrayList<Libro> librosPrestados = new ArrayList<>();
		for (Prestamo prestamo : prestamos) {
			if (prestamo.getUsuario().equals(usuario)) {
				librosPrestados.add(prestamo.getLibro());
			}
		}
		return librosPrestados;
	}
	
	public HashSet<Usuario> mostrarLosUsuariosQueTienenUnLibroEspecificoPrestado(Libro libro){
		HashSet<Usuario> usuarios = new HashSet<>();
		for(Prestamo prestamo : prestamos) {
			if(prestamo.getLibro().equals(libro)) {
				usuarios.add(prestamo.getUsuario());
			}
		}
		return usuarios;
	}
	
	//metodo para libros disponibles
	
	public ArrayList <Libro> obtenerLibrosDisponibles(){
		ArrayList<Libro> librosDisponibles = new ArrayList<>();
		
		for (Libro libro : libros) {
			if(libro.getStock() > 0 ) {
				librosDisponibles.add(libro);
			}
			
		}
		return librosDisponibles;
	}
	
	//metodo para ver la lista de autores , lo hicimos con hashset para que no muestre duplicados
	
	public HashSet<Autor> mostrarListaDeAutores(){
		HashSet<Autor> listaAutores = new HashSet<>();
		for (Libro libro : libros) {
			listaAutores.add(libro.getAutor());
			
		}
		
		return listaAutores;	
	}

	
	//Metodo para mostrar la lista de usuarios
	
	public HashSet<Usuario> mostrarListaDeUsuarios(){
		return usuarios;
	}


	
	
	
}
