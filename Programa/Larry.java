// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Representa un tipo de enemigo.

import java.util.ArrayList;

public class Larry extends Enemigo {
    
    public Larry() {
        super("Larry", 90, 8); // Vida alta y ataque bajo
    }
    
    // Habilidad especial de Larry: Se cura a sí mismo una pequeña cantidad.
    @Override
    public String usarHabilidadEspecial(ArrayList<Combatiente> objetivos) {
        int curacion = 20;
        this.puntosDeVida += curacion;
        return this.nombre + " usa 'Regeneración' y recupera " + curacion + " puntos de vida.";
    }
}
