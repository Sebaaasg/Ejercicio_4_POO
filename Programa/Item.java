// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Clase abstracta para la creación de todos los items del juego.

public abstract class Item {
    // ATRIBUTOS
    protected String nombre;

    // CONSTRUCTOR
    public Item(String nombre){
        this.nombre = nombre;
    }

    // MÉTODO: método abstracto para que se defina cómo utilizarán el ítem las subclases
    public abstract String usar(Combatiente objetivo);

    // "GETTER"
    @Override
    public String toString(){
        return nombre;
    }

}
