// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Representa un Larry pero version jefe.

import java.util.ArrayList;
import java.util.Random;

public class JefeLarry extends Larry {
    public JefeLarry() {
        super(); // Llama al constructor de Larry
        // Mejorar stats
        this.nombre = "Larry el Inmortal";
        this.puntosDeVida = 200;
        this.poderDeAtaque = 12;
    }

    // El jefe tiene un 50% de probabilidad de curarse si su vida está por debajo de la mitad.
    @Override
    public String tomarTurno(ArrayList<Combatiente> aliados, ArrayList<Combatiente> enemigos) {
        Random rand = new Random();
        // si tiene menos de la mitad de la vida, hay probabilidad de que se cure.
        if (this.puntosDeVida < 100 && rand.nextDouble() < 0.5) {
            return usarHabilidadEspecial(null);
        }
        // Si no, ataca normal
        return super.tomarTurno(aliados, enemigos);
    }
}
