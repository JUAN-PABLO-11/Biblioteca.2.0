package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Bibliotecario {
    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private double salario;
    private int años;
    private ArrayList<Prestamo> listaPrestamos;  

    // Constructor ajustado
    public Bibliotecario(String nombre, String id, String telefono, String correo, double salario, int años, ArrayList<Prestamo> listaPrestamos) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.años = años;
        this.listaPrestamos = listaPrestamos != null ? listaPrestamos : new ArrayList<>();
    }

    // Getters y Setters
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }
}
