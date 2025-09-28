// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Representa un rol concreto que puede tener un jugador.

public class Explorador extends Jugador {
    public Explorador(String nombre){
        // stats: vida normal, ataque normal, alta   capacidad de inventario
        super(nombre,100, 15, 5);
    }
}
