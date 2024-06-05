package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;



public class Biblioteca implements IBiblioteca{
	
	private String nombre;
	ArrayList<Libro>libros;
	HashSet<Usuario>usuarios;
	ArrayList<Prestamo>prestamos;
	HashSet<Libro>librosfavoritos;


	public Biblioteca(String nombre) {

		this.nombre = nombre;
		this.libros= new ArrayList<>();
		this.usuarios= new HashSet<>();
		this.prestamos= new ArrayList<>();
		this.librosfavoritos= new HashSet<>();
		
		
	}

	public Boolean agregarLibro(Libro libro) {
	Libro  libroEncontrado = buscarLibroPorCodigo(libro.getIdLibro());
	Autor autor = libro.getAutor();

	if(libroEncontrado==null) {
		libros.add(libro);
		autor.agregarLibro(libro);
		
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



	public Boolean prestarLibroAUsuario(Prestamo prestamo) throws Exception {
	    if (prestamo.getLibro().getStock() > 0 && usuarios.contains(prestamo.getUsuario())) {
	        prestamos.add(prestamo);
	        Libro libro = prestamo.getLibro();
	        Usuario usuario = prestamo.getUsuario();
	        libro.setStock(libro.getStock() - 1);
	        return true;
	    }
	    throw new Exception();
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

	
	//metodo mostrar autores favoritos de un usuario
	
	public HashSet<Autor> mostrarAutoresFavoritos(Usuario usuario){
		
		HashSet <Autor> autoresFavorito = new HashSet<>();
		for (Libro libro :usuario.getLibrosFavoritos()) {
			autoresFavorito.add(libro.getAutor());
			
		}
		
		return autoresFavorito;
	}

	public Boolean agregarLibroFavorito(Libro libro, Integer idUsuario) {
		Usuario usuario=buscarUsuarioPorDni(idUsuario);
		if(libros.contains(libro)&&usuario!=null) {
			usuario.agregarLibro(libro);
			return librosfavoritos.add(libro);
		}
		return null;
	
		
	}

	public Usuario buscarUsuarioPorDni(Integer idUsuario) {
		for (Usuario usuario : usuarios) {
			if(usuario.getDniUsuario().equals(idUsuario)) {
				return usuario;
			}
		}
		return null;
	}

	public void ordernarLibrosPorStock() {
		
		 Collections.sort(libros, new Comparator<Libro>() {
	            @Override
	            public int compare(Libro l1, Libro l2) {
	                return l1.getStock().compareTo(l2.getStock());
	            }
	        });
	}
	
public void ordenarLibrosPorNombreDelAutorQueLoEscribio() {
	Collections.sort(libros, new Comparator<Libro>() {

		@Override
		public int compare(Libro o1, Libro o2) {
			
			return o1.getAutor().getNombre().compareTo(o2.getAutor().getNombre());
		}
	});
}
	
}
