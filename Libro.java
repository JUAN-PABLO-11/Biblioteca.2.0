package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String estado;
    private String editorial;
    private LocalDate fecha;
    private int unidadesDisponibles;
    private ArrayList<DetallePrestamo>listaDetallePrestamo;

    public Libro(String codigo, String isbn,String estado, String autor, String titulo, String editorial, LocalDate fecha, int unidadesDisponibles){
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.estado = estado;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.unidadesDisponibles = unidadesDisponibles;
        this.listaDetallePrestamo = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public ArrayList<DetallePrestamo> getListaDetallePrestamo() {
        return listaDetallePrestamo;
    }

    public void setListaDetallePrestamo(ArrayList<DetallePrestamo> listaDetallePrestamo) {
        this.listaDetallePrestamo = listaDetallePrestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    

    

}
