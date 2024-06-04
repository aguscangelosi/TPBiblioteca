package Package;

import java.util.ArrayList;
import java.util.HashSet;

public interface IBiblioteca {
Boolean agregarLibro(Libro libro);
Libro buscarLibroPorCodigo(Integer codigo);
ArrayList<Libro> obtenerLibrosEscritosPorAutorConSuCodigo(Integer idAutor);
Boolean agregarUsuario(Usuario usuario);
Boolean prestarLibroAUsuario(Prestamo prestamo) throws Exception;
Boolean devolverLibroPrestadoAUnUsuario(Prestamo prestamo);
ArrayList<Libro> obtenerLibrosPrestadosAUnUsuario(Usuario usuario);
HashSet<Usuario> mostrarLosUsuariosQueTienenUnLibroEspecificoPrestado(Libro libro);
ArrayList <Libro> obtenerLibrosDisponibles();
HashSet<Autor> mostrarListaDeAutores();
HashSet<Usuario> mostrarListaDeUsuarios();
HashSet<Autor> mostrarAutoresFavoritos(Usuario usuario);
Boolean agregarLibroFavorito(Libro libro, Integer idUsuario);
Usuario buscarUsuarioPorDni(Integer idUsuario);
}
