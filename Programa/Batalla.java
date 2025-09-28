// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Se encarga de la lógica de una batalla.

import java.util.ArrayList;
import java.util.Random;

public class Batalla {
    private ArrayList<Combatiente> equipoJugador;
    private ArrayList<Combatiente> equipoEnemigo;
    private ArrayList<String> logDeAcciones;
    private ArrayList<Combatiente> ordenDeTurnos;
    private int indiceTurnoActual = 0;

    // CONSTRUCTOR: genera un equipo de enemigos aleatorio
    public Batalla(ArrayList<Combatiente> equipoJugador) {
        this.equipoJugador = equipoJugador;
        this.equipoEnemigo = new ArrayList<>();
        generarEnemigosAleatorios(); 
        
        this.logDeAcciones = new ArrayList<>();
        prepararOrdenDeTurnos();
    }
    
    // MÉTODOS
    private void generarEnemigosAleatorios() {
        Random rand = new Random();
        int cantidadEnemigos = rand.nextInt(3) + 1;

        for (int i = 0; i < cantidadEnemigos; i++) {
            int tipoEnemigo = rand.nextInt(4); // 4 tipos de enemigos posibles
            switch (tipoEnemigo) {
                case 0:
                    equipoEnemigo.add(new Goblin());
                    break;
                case 1:
                    equipoEnemigo.add(new Larry());
                    break;
                case 2:
                    equipoEnemigo.add(new JefeGoblin());
                    break;
                case 3:
                    equipoEnemigo.add(new JefeLarry());
                    break;
            }
        }
    }

    private void prepararOrdenDeTurnos() {
        ordenDeTurnos = new ArrayList<>();
        ordenDeTurnos.addAll(equipoJugador);
        ordenDeTurnos.addAll(equipoEnemigo);
    }
    
    public Combatiente getCombatienteActual() {
        return ordenDeTurnos.get(indiceTurnoActual);
    }

    public void avanzarTurno() {
        // Bucle para saltar los turnos de combatientes ya derrotados
        int intentos = 0;
        do {
            indiceTurnoActual = (indiceTurnoActual + 1) % ordenDeTurnos.size();
            intentos++;
        } while(!getCombatienteActual().isEstaVivo() && intentos < ordenDeTurnos.size() * 2);
    }

    public void ejecutarAccion(String resultado) {
        logDeAcciones.add(resultado);
        if (logDeAcciones.size() > 3) {
            logDeAcciones.remove(0); // Mantiene solo las últimas 3 acciones
        }
    }

    public boolean verificarFinDeBatalla() {
        boolean jugadoresVivos = false;
        for (Combatiente c : equipoJugador) {
            if (c.isEstaVivo()) {
                jugadoresVivos = true;
                break;
            }
        }

        boolean enemigosVivos = false;
        for (Combatiente c : equipoEnemigo) {
            if (c.isEstaVivo()) {
                enemigosVivos = true;
                break;
            }
        }
        return !jugadoresVivos || !enemigosVivos;
    }

    // GETTERS
    public ArrayList<Combatiente> getEquipoJugador(){
        return equipoJugador;
    }
    public ArrayList<Combatiente> getEquipoEnemigo(){
        return equipoEnemigo;
    }
    public ArrayList<String> getLogDeAcciones(){
        return logDeAcciones;
    }
}
