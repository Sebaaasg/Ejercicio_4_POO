// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Clase base para representar a los enemigos.

import java.util.ArrayList;
import java.util.Random;

public class Enemigo extends Combatiente{
    
    public Enemigo(String nombre, int vida, int ataque){
        super(nombre, vida, ataque);
    }

    // El enemigo siempre ataca a un jugador vivo al azar
    @Override
    public String tomarTurno(ArrayList<Combatiente> aliados, ArrayList<Combatiente> enemigos){
        ArrayList<Combatiente> objetivosVivos = new ArrayList<>();
        for(Combatiente c : enemigos){
            if (c.isEstaVivo()) {
                objetivosVivos.add(c);
            }
        }

        if (!objetivosVivos.isEmpty()) {
            Random random = new Random();
            Combatiente objetivo = objetivosVivos.get(random.nextInt(objetivosVivos.size()));
            return this.atacar(objetivo);
        }
        return this.nombre + " no tiene a quien atacar";
    }

    @Override
    public String usarHabilidadEspecial(ArrayList<Combatiente> objetivos){
        // para enemigos normales
        return this.nombre + " no tiene una habilidad especial compleja";
    }
}   