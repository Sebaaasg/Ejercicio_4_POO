// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Clase abstracta para la creación de todos los items del juego.

public abstract class Item {
    // ATRIBUTOS
    protected String nombre;
    protected int cantidad;

    // CONSTRUCTOR
    public Item(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // MÉTODO: método abstracto para que se defina cómo utilizarán el ítem las subclases
    public abstract String usar(Combatiente objetivo, Combatiente usuario);

    // GETTERS Y SETTERS
    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String toString(){
        return nombre + " (x" + cantidad + ")";
    }

}
