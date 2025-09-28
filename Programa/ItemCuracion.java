// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Item que restaura puntos de vida.

public class ItemCuracion extends Item {
    // ATRIBUTOS
    private int puntosDeVidaCurados;

    // CONSTRUCTOR
    public ItemCuracion(String nombre, int cantidad, int puntosDeVidaCurados){
        super(nombre, cantidad);
        this.puntosDeVidaCurados = puntosDeVidaCurados;
    }

    @Override
    public String usar(Combatiente objetivo, Combatiente usuario){
    }
}
