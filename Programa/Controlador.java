// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Se encarga de conectar el Modelo con la Vista, se encarga del flujo del juego, seleccion de rol, uso de items y el fin de la batalla.

import java.util.ArrayList;
import java.util.Arrays;

public class Controlador {
    // ATRIBUTOS
    private Batalla batalla;
    private Vista vista;

    // CONSTRUCTOR
    public Controlador(Batalla batalla, Vista vista) {
        this.batalla = batalla;
        this.vista = vista;
    }

    public static void main(String[] args) {
        Vista vista = new Vista();
        vista.mostrarMensaje("Bienvenido a la Batalla RPG");
        
        // Configuración Inicial
        int rol = vista.elegirRol();
        Jugador jugador;
        if (rol == 1) {
            jugador = new Guerrero("Guerrero");
        } else {
            jugador = new Explorador("Explorador");
        }
        
        // Añadir ítems iniciales al jugador
        jugador.agregarItem(new ItemCuracion());
        jugador.agregarItem(new ItemCuracion());
        jugador.agregarItem(new ItemMejoraAtaque());

        ArrayList<Combatiente> equipoJugador = new ArrayList<>(Arrays.asList(jugador));
        
        Batalla batalla = new Batalla(equipoJugador);
        Controlador controlador = new Controlador(batalla, vista);
        
        controlador.iniciarBatalla();
    }

    public void iniciarBatalla() {
        vista.mostrarMensaje("\nLA PELEA EMPIEZA");

        while (!batalla.verificarFinDeBatalla()) {
            vista.mostrarEstadoBatalla(batalla.getEquipoJugador(), batalla.getEquipoEnemigo());
            vista.mostrarLog(batalla.getLogDeAcciones());

            Combatiente combatienteActual = batalla.getCombatienteActual();
            String resultadoAccion = "";
            
            // El instanceof se utiliza para verificar si un objeto es una instancia de una clase o subclase, retorna un boolean
            if (combatienteActual.isEstaVivo()) {
                // Se hace downcasting, que es para lo que sirve instaceof generalmente
                if (combatienteActual instanceof Jugador) { 
                    resultadoAccion = gestionarTurnoJugador((Jugador) combatienteActual);
                } else if (combatienteActual instanceof Enemigo) {
                    resultadoAccion = combatienteActual.tomarTurno(batalla.getEquipoEnemigo(), batalla.getEquipoJugador());
                }
                batalla.ejecutarAccion(resultadoAccion);
            }
            batalla.avanzarTurno();
        }
        
        vista.mostrarMensaje("\nLA PELEA HA ACABADO");
        // Lógica para determinar al ganador
        boolean jugadoresVivos = false;
        for (Combatiente c : batalla.getEquipoJugador()) {
            if (c.isEstaVivo()) jugadoresVivos = true;
        }

        if (jugadoresVivos) {
            vista.mostrarMensaje("HAS GANADO PERRO");
        } else {
            vista.mostrarMensaje("PERDISTE, SUERTE A LA SIGUIENTE");
        }
    }
    
    private String gestionarTurnoJugador(Jugador jugador) {
        int opcion = vista.mostrarMenuTurno(jugador.getNombre());
        String resultado = "";
        
        try {
            switch (opcion) {
                case 1: // Atacar
                    ArrayList<Combatiente> enemigosVivos = new ArrayList<>();
                    for(Combatiente c : batalla.getEquipoEnemigo()) if(c.isEstaVivo()) enemigosVivos.add(c);
                    
                    if(enemigosVivos.isEmpty()) throw new AccionInvalidaException("No quedan enemigos a quien atacar");

                    Combatiente objetivoAtaque = vista.elegirObjetivo(enemigosVivos);
                    resultado = jugador.atacar(objetivoAtaque);
                    break;
                case 2: // Habilidad/Ítem
                    Item itemElegido = vista.elegirItem(jugador.inventario);
                    if (itemElegido == null) throw new AccionInvalidaException("Selección de ítem inválida o inventario vacío");
                    
                    // Decidir objetivo del ítem
                    Combatiente objetivoItem;
                    if (itemElegido instanceof ItemCuracion || itemElegido instanceof ItemMejoraAtaque) {
                        objetivoItem = vista.elegirObjetivo(batalla.getEquipoJugador());
                    } else { // Para ítems de daño
                        objetivoItem = vista.elegirObjetivo(batalla.getEquipoEnemigo());
                    }
                    
                    resultado = itemElegido.usar(objetivoItem);
                    jugador.inventario.remove(itemElegido); // El ítem se consume
                    break;
                case 3: // Pasar
                    resultado = jugador.getNombre() + " pasa el turno.";
                    break;
                default:
                    resultado = "Opción inválida, " + jugador.getNombre() + " pierde el turno";
            }
        } catch (AccionInvalidaException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
            resultado = jugador.getNombre() + " falló su acción";
        }
        return resultado;
    }
}
