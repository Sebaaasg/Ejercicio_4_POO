// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Se encarga de lo que ve el usuario y con lo que puede interactuar.

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;
    public Vista(){
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrarEstadoBatalla(ArrayList<Combatiente> jugadores, ArrayList<Combatiente> enemigos) {
        System.out.println("\n----------- ESTADO DE LA BATALLA -----------");

        System.out.println("===== JUGADORES =====");
        for (Combatiente j : jugadores){
            System.out.println(j.toString());
        }

        System.out.println("\n===== ENEMIGOS =====");
        for (Combatiente e : enemigos){
            System.out.println(e.toString());
        }
        System.out.println("------------------------------------------");
    }

    public void mostrarLog(ArrayList<String> log) {
        if (log.isEmpty()) return;
        System.out.println("\n--- Últimas Acciones ---");
        for (String accion : log){
            System.out.println("- " + accion);
        }
    }

    public int mostrarMenuTurno(String nombreJugador){
        System.out.println("\nTurno de: " + nombreJugador);
        System.out.println("1. Atacar");
        System.out.println("2. Usar Habilidad/Ítem");
        System.out.println("3. Pasar Turno");
        System.out.print("Elige una acción: ");
        return scanner.nextInt();
    }

    public Combatiente elegirObjetivo(ArrayList<Combatiente> posiblesObjetivos){
        System.out.println("Elige un objetivo:");
        for (int i = 0; i < posiblesObjetivos.size(); i++) {
            if (posiblesObjetivos.get(i).isEstaVivo()) {
                System.out.println((i + 1) + ". " + posiblesObjetivos.get(i).getNombre());
            }
        }
        System.out.print("Selección: ");
        int eleccion = scanner.nextInt() - 1;
        return posiblesObjetivos.get(eleccion);
    }
    
    public int elegirRol() {
        System.out.println("Elige tu rol:");
        System.out.println("1. Guerrero (Mucha vida y ataque, pocos ítems)");
        System.out.println("2. Explorador (Stats balanceados, muchos ítems)");
        System.out.print("Selección: ");
        return scanner.nextInt();
    }
    
    // Mostrar items y permitir escoger un ítem
    public Item elegirItem(ArrayList<Item> inventario) {
        System.out.println("Elige un ítem para usar:");
        if (inventario.isEmpty()) {
            System.out.println("¡Inventario vacío!");
            return null;
        }

        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i).toString());
        }
        
        System.out.print("Selección: ");
        int eleccion = scanner.nextInt() - 1;
        
        if (eleccion >= 0 && eleccion < inventario.size()) {
            return inventario.get(eleccion);
        }
        return null;
    }
}
