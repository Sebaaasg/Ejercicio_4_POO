// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Clase abstracta que representa un jugador, hereda de combatiente; contiene la lógica de
// poder manejar un inventario de ítems.

import java.util.ArrayList;

public abstract class Jugador extends Combatiente {
    protected ArrayList<Item> inventario;
    protected int capacidadInventario;

    public Jugador(String nombre, int puntosDeVida, int poderDeAtaque, int capacidadInventario){
        super(nombre, puntosDeVida, poderDeAtaque);
        this.capacidadInventario = capacidadInventario;
        this.inventario = new ArrayList<>();
    }

    public boolean agregarItem(Item item){
        if (inventario.size() < capacidadInventario) {
            inventario.add(item);
            return true;
        }
        return false;
    }

    // MÉTODO: El turno se maneja por el usuario, por lo que no se usa este método directamente
    @Override
    public String tomarTurno(ArrayList<Combatiente> aliados, ArrayList<Combatiente> enemigos){
        return "Es el turno de " + this.nombre + ". Elige una acción.";
    }

    // La habilidad especial de un jugador es poder utilizar un ítem
    @Override
    public String usarHabilidadEspecial(ArrayList<Combatiente> objetivos){
        // La lógica de elegir y usar el ítem lo maneja el controlador a través de la vista.
        return this.nombre + " se prepara para usar un item.";
    }
}
