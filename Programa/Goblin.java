// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Representa un tipo de enemigo.

import java.util.ArrayList;

public class Goblin extends Enemigo {
    
    public Goblin(){
        super("Goblin", 60, 12); // vida y ataque medio
    }

    // HABILIDAD: el goblin hace un ataque rápido con daño medio
    @Override
    public String usarHabilidadEspecial(ArrayList<Combatiente> objetivos){
        if (!objetivos.isEmpty() && objetivos.get(0).isEstaVivo()) {
            Combatiente objetivo = objetivos.get(0);
            int daño = 15; // un poco más que su ataque base
            objetivo.recibirDaño(daño);
            return this.nombre + " usa 'Apuñalada goblin' contra " + objetivo.getNombre() + " y le causa " + daño + " de daño";
        }
        return this.nombre + "intenta usar su habilidad pero falla";
    }
}
