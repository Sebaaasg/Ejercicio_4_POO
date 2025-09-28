// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Item que restaura puntos de vida.

public class ItemCuracion extends Item {
    // ATRIBUTOS
    private int puntosCuracion;

    // CONSTRUCTOR
    public ItemCuracion(){
        super("Pocion de vida");
        this.puntosCuracion = 50;
    }

    @Override
    public String usar(Combatiente objetivo){
        objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() + puntosCuracion);
        return objetivo.getNombre() + " se cura " + puntosCuracion + " puntos de vida";
    }
}
