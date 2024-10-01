package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private String codigo;
    private double total;
    private ArrayList<Libro> listaLibros;
    private ArrayList<DetallePrestamo> listaDetallesPrestamo;
    private ArrayList<Bibliotecario> bibliotecarioPrestamo;
    private ArrayList<Estudiante> estudiantePrestamo;
    private ArrayList<Prestamo> listaPrestamos;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo, double total) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.total = total;
        listaPrestamos = new ArrayList<>();
        listaLibros = new ArrayList<>();
        listaDetallesPrestamo = new ArrayList<>();
        bibliotecarioPrestamo = new ArrayList<>();
        estudiantePrestamo = new ArrayList<>();

    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaDetallesPrestamo(ArrayList<DetallePrestamo> listaDetallesPrestamo) {
        this.listaDetallesPrestamo = listaDetallesPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<DetallePrestamo> getListaDetallesPrestamo() {
        return listaDetallesPrestamo;
    }

    public void setListaDetallesPrestamos(ArrayList<DetallePrestamo> listaDetallesPrestamo) {
        this.listaDetallesPrestamo = listaDetallesPrestamo;
    }

    public ArrayList<Bibliotecario> getBibliotecarioPrestamo() {
        return bibliotecarioPrestamo;
    }

    public void setBibliotecarioPrestamo(ArrayList<Bibliotecario> bibliotecarioPrestamo) {
        this.bibliotecarioPrestamo = bibliotecarioPrestamo;
    }

    public ArrayList<Estudiante> getEstudiantePrestamo() {
        return estudiantePrestamo;
    }

    public void setEstudiantePrestamo(ArrayList<Estudiante> estudiantePrestamo) {
        this.estudiantePrestamo = estudiantePrestamo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechaPrestamo == null) ? 0 : fechaPrestamo.hashCode());
        result = prime * result + ((fechaEntrega == null) ? 0 : fechaEntrega.hashCode());
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        long temp;
        temp = Double.doubleToLongBits(total);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((listaDetallesPrestamo == null) ? 0 : listaDetallesPrestamo.hashCode());
        result = prime * result + ((bibliotecarioPrestamo == null) ? 0 : bibliotecarioPrestamo.hashCode());
        result = prime * result + ((estudiantePrestamo == null) ? 0 : estudiantePrestamo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        if (fechaPrestamo == null) {
            if (other.fechaPrestamo != null)
                return false;
        } else if (!fechaPrestamo.equals(other.fechaPrestamo))
            return false;
        if (fechaEntrega == null) {
            if (other.fechaEntrega != null)
                return false;
        } else if (!fechaEntrega.equals(other.fechaEntrega))
            return false;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
            return false;
        if (listaDetallesPrestamo == null) {
            if (other.listaDetallesPrestamo != null)
                return false;
        } else if (!listaDetallesPrestamo.equals(other.listaDetallesPrestamo))
            return false;
        if (bibliotecarioPrestamo == null) {
            if (other.bibliotecarioPrestamo != null)
                return false;
        } else if (!bibliotecarioPrestamo.equals(other.bibliotecarioPrestamo))
            return false;
        if (estudiantePrestamo == null) {
            if (other.estudiantePrestamo != null)
                return false;
        } else if (!estudiantePrestamo.equals(other.estudiantePrestamo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prestamo [fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", codigo=" + codigo
                + ", total=" + total + ", listaDetallesPrestamos=" + listaDetallesPrestamo + ", bibliotecarioPrestamo="
                + bibliotecarioPrestamo + ", estudiantePrestamo=" + estudiantePrestamo + "]";
    }

    public void addLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

}
