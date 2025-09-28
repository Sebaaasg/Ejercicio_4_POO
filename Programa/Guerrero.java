// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Representa un rol concreto que puede tener un jugador.

public class Guerrero extends Jugador {
    public Guerrero(String nombre){
        // stats: vida elevada, ataque elevado, poca capacidad de inventario
        super(nombre, 150, 25, 2);
    }
}
