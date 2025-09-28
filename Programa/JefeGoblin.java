// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Representa un goblin pero version jefe.

import java.util.ArrayList;
import java.util.Random;

public class JefeGoblin extends Goblin {
    
    public JefeGoblin() {
        super(); // Llama al constructor de Goblin
        // Mejora las estadísticas para la versión Jefe
        this.nombre = "Rey Goblin";
        this.puntosDeVida = 120;
        this.poderDeAtaque = 20;
    }

    // El jefe tiene un 50% de probabilidad de utilizar su habilidad especial en lugar de atacar normal
    @Override
    public String tomarTurno(ArrayList<Combatiente> aliados, ArrayList<Combatiente> enemigos) {
        Random rand = new Random();
        if (rand.nextDouble() < 0.5) {
            // Elegir objetivo vivo al azar
            ArrayList<Combatiente> objetivosVivos = new ArrayList<>();
            for(Combatiente c : enemigos) {
                if (c.isEstaVivo()) objetivosVivos.add(c);
            }
            if (!objetivosVivos.isEmpty()) {
                Combatiente objetivo = objetivosVivos.get(rand.nextInt(objetivosVivos.size()));
                return usarHabilidadEspecial(new ArrayList<>(java.util.List.of(objetivo)));
            }
        }
        // Si no usa la habilidad, realiza un ataque normal
        return super.tomarTurno(aliados, enemigos);
    }
}
