package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class DetallePrestamo {
    private String subtotal;
    private String cantidad;
    private ArrayList<Libro> libroPrestamo;


    public DetallePrestamo(String subtotal, String cantidad) {
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        libroPrestamo = new ArrayList<>();

    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Libro> getLibroPrestamo() {
        return libroPrestamo;
    }

    public void setLibroPrestamo(ArrayList<Libro> libroPrestamo) {
        this.libroPrestamo = libroPrestamo;
    }
}
