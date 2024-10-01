package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String id; 
    private String correo;
    private String telefono;
    private ArrayList<DetallePrestamo> listaDetallesPrestamo;

    public Estudiante(String nombre, String id, String correo, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
        listaDetallesPrestamo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<DetallePrestamo> getListaDetallesPrestamo() {
        return listaDetallesPrestamo;
    }

    public void setListaDetallesPrestamo(ArrayList<DetallePrestamo> listaDetallesPrestamo) {
        this.listaDetallesPrestamo = listaDetallesPrestamo;
    }

}
