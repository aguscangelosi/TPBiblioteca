package Package;

import java.util.ArrayList;
import java.util.Objects;

public class Autor extends Persona {
    
    private String nombre;
    private Integer idAutor;
    ArrayList<Libro> libros;

    public Autor(String nombre, Integer idAutor) {
        super(nombre, idAutor);
        this.nombre = nombre;
        this.idAutor = idAutor;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public Boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor, nombre);  // Libros no es necesario en hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Autor other = (Autor) obj;
        return Objects.equals(idAutor, other.idAutor) && Objects.equals(nombre, other.nombre);
    }
	
}
