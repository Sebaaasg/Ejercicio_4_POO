// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Item mejora el ataque.

public class ItemMejoraAtaque extends Item {
    // ATRIBUTOS
    private int aumentoAtaque;
    
    // CONSTRUCTOR
    public ItemMejoraAtaque() {
        super("Elixir de Furia");
        this.aumentoAtaque = 10;
    }

    @Override
    public String usar(Combatiente objetivo) {
        objetivo.setPoderDeAtaque(objetivo.getPoderDeAtaque() + aumentoAtaque);
        return objetivo.getNombre() + " aumenta su poder de ataque en " + aumentoAtaque;
    }
}
