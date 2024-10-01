package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private LinkedList<Libro>listaLibros;
    private ArrayList<Bibliotecario> listaBibliotecarios;
    private ArrayList<Bibliotecario> listaBibliotecario;
    private ArrayList<Estudiante> listaEstudiante;
    private ArrayList<DetallePrestamo> listaDetallesPrestamo;
    private ArrayList<Prestamo> listaPrestamo;


    public Biblioteca(String nombre, LinkedList<Libro> listaLibros) {
        this.nombre = nombre;
        this.listaLibros = listaLibros;
        listaPrestamo = new ArrayList<>();
        listaDetallesPrestamo = new ArrayList<>();
        listaEstudiante = new ArrayList<>();
        listaBibliotecario = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(ArrayList<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public ArrayList<Bibliotecario> getListaBibliotecario() {
        return listaBibliotecario;
    }

    public void setListaBibliotecario(ArrayList<Bibliotecario> listaBibliotecario) {
        this.listaBibliotecario = listaBibliotecario;
    }
    
    public ArrayList<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(ArrayList<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }
    
    public ArrayList<DetallePrestamo> getListaDetallesPrestamo() {
        return listaDetallesPrestamo;
    }

    public void setListaDetallesPrestamo(ArrayList<DetallePrestamo> listaDetallesPrestamo) {
        this.listaDetallesPrestamo = listaDetallesPrestamo;
    }

//Crear bibliotecario

public void agregarBibliotecario(String nombre, String id, String telefono, String correo, double salario, int años, ArrayList<Prestamo> listaPrestamos) {
    Bibliotecario nuevoBibliotecario = new Bibliotecario(nombre, id, telefono, correo, salario, años, listaPrestamos);
    listaBibliotecarios.add(nuevoBibliotecario);
}

//Eliminar bibliotecario

public void eliminarBibliotecario(String id) {
    listaBibliotecario.removeIf(b -> b.getId().equals(id));
}

//Buscar bibliotecario

public Bibliotecario buscarBibliotecario(String id) {
    return listaBibliotecario.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElse(null);
}

//Crear estudiante

    public void agregarEstudiante(String nombre, String id, String telefono, String correo){
        Estudiante nuevoEstudiante = new Estudiante(nombre, id, correo, telefono);
        listaEstudiante.add(nuevoEstudiante);
    }

//Eliminar estudiante

public void eliminarEstudiante(String id) {
    listaEstudiante.removeIf(b -> b.getId().equals(id));
}

//Buscar bibliotecario

public Estudiante buscarEstudiante(String id) {
    return listaEstudiante.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElse(null);
}

//Crear libro

    public void agregarLibro(String codigo, String isbn,String estado, String autor, String titulo, String editorial, LocalDate fecha, int unidadesDisponibles){
        Libro nuevoLibro = new Libro(codigo, isbn, autor, titulo, estado, editorial, fecha, unidadesDisponibles);
        listaLibros.add(nuevoLibro);
    }

//Crear prestamo   

    public void crearPrestamo(String codigo, LocalDate fechaEntrega, LocalDate fechaPrestamo, Double costo){
        Prestamo nuevoPrestamo = new Prestamo(fechaPrestamo, fechaEntrega, codigo, 0);
        listaPrestamo.add(nuevoPrestamo);

    }

//Metodo que consulta los datos de un Libro dado su código

    public Libro consultarLibroCodigo(String codigo){
        for(Libro libro : listaLibros){
            if(libro.getCodigo().equals(codigo)){
            return libro;
        }
    }
    return null;
}

//Metodo que consulta los cantidad de libros prestados dado su nombre
 
public int cantidadLibrosPrestamoNombre(String titulo){
    int contador = 0;
    for(Prestamo prestamo: listaPrestamo){
        for(DetallePrestamo detalle : prestamo.getListaDetallesPrestamo()){
            for(Libro libro: detalle.getLibroPrestamo()){
                if(libro.getTitulo().equals(titulo)){
                    contador ++;
                }
            }       
        }
    }
    return contador ;
}

//Metodo que Reemplaza un libro por otro, es decir, sobrescribir el libro por uno nuevo.

public String remplazarLibro(Libro libroAntiguo,Libro libroNuevo){
    String mensaje = "No se pudo sobreescribir el libro";
    for(int i = 0; i < listaLibros.size(); i++){
        if(listaLibros.get(i) != null && listaLibros.get(i).equals(libroAntiguo)){
            listaLibros.set(i, libroNuevo);
            mensaje = "Libro remplezado";
            break;

        }
    }
    return mensaje;
}

//Metodo que Adiciona un libro al préstamo 

public String adicionarLibroPrestamo(Libro libro, Prestamo prestamo){
    String mensaje = "El prestamo no se pudo completar";
    if(libro != null){
       prestamo.addLibro(libro);
       libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - 1);
       mensaje = "El libro" +libro.getTitulo()+ "se añadio al prestamo con codigo" +prestamo.getCodigo();
        
    }
    return mensaje;
}

//Metodo que calcula el precio a pagar del prestamo

public String entregarPrestamo(Prestamo prestamo, LocalDate fechaEntrega){
    if(prestamo == null || fechaEntrega == null){
        return "Se encontro un error sorry";
    }

    LocalDate fechaPrestamo = prestamo.getFechaPrestamo();
    long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);

    double valorDiario = 100000;
    double valorTotal = valorDiario * diasPrestamo;

    ArrayList<Libro> listaLibros = prestamo.getListaLibros();

    for(Libro libro : listaLibros){
        libro.setEstado("Disponible");
        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() + 1);
    }
    prestamo.setFechaEntrega(fechaEntrega);
    prestamo.setTotal(valorTotal);
    return "Prestamo entregado su valor fue de "+valorTotal;
}

//Metodo que consulta los datos de un préstamo dado su código.

public String datosPrestamoCodigo(Prestamo codigoSolicitado){
    String mensaje = "No se encontro el prestamo con el codigo proporcionado";
    for(int i = 0; i < listaPrestamo.size(); i++){
        Prestamo prestamoActual = listaPrestamo.get(i);
    if (prestamoActual.equals(codigoSolicitado)){
        return "Prestamo encontrardo;" +prestamoActual.toString();
      }
   }
    return mensaje;
}

//Metodo que muestra la cantidad de préstamos realizados por cada empleado

    public String cantidadPrestamosBibliotecariosl(){
        StringBuilder mensaje = new StringBuilder();
        if (listaBibliotecario.isEmpty()){
            return "No hay biblotecarios";
        }

        for(Bibliotecario bibliotecario : listaBibliotecario){
            if(bibliotecario != null){
                int cantidadPrestamos = bibliotecario.getListaPrestamos().size();
                mensaje.append(bibliotecario.getNombre()).append(" ").append(cantidadPrestamos).append("Prestamos\n");

            }
        }
        return mensaje.toString();
    }

//Metodo que devuelve el estudiante con mayor cantidad de prestamos

public String estudianteMayorCantidadPrestamos(){
    Estudiante estuadianteMayorCantidad = null;
    int maxLibros = 0;

    for(Estudiante estudiante: listaEstudiante){
        if(estudiante != null){
            int libroPrestados = estudiante.getListaDetallesPrestamo().size();

            if(libroPrestados > maxLibros){
                maxLibros = libroPrestados;
                estuadianteMayorCantidad = estudiante;
            }
        }  
    }
    return estuadianteMayorCantidad.toString();
}

//Metodo que calcula todo el dinero generado

public String totalDinero(ArrayList<Prestamo> Listaprestamos){
    double totalEmpresa = 0;
    String mensaje = "";
    for(Prestamo prestamo : listaPrestamo){
        if(prestamo.getTotal() != 0){
            totalEmpresa += prestamo.getTotal();
        }
    }
    mensaje = "El total de la empresa es " +totalEmpresa;
    return mensaje;
}  

//Metodo que calcula el sueldo de cada bibliotecario

public double sueldoBibliotecarios(Bibliotecario listaBibliotecarios){
    double totalApagar = 0;

    for(Bibliotecario bibliotecario : listaBibliotecario){
        double comisiones = 0;
        int añosAntiguedad = bibliotecario.getAños();

        for(Prestamo prestamo : bibliotecario.getListaPrestamos()){
            comisiones += prestamo.getTotal() * 0.20;
        }

        double bonificacion = comisiones * (0.02 *añosAntiguedad);

        double totalBibliotecario = comisiones + bonificacion;
        totalApagar += totalBibliotecario;
    }
    return totalApagar;
}

}




    

  
    

