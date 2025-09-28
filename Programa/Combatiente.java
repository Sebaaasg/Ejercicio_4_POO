// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Clase abstracta para crear a todos los participantes de la batalla.

import java.util.ArrayList;

public abstract class Combatiente {
    
    // ATRIBUTOS
    protected String nombre;
    protected int puntosDeVida, poderDeAtaque;
    protected boolean estaVivo;

    // CONSTRUCTOR: todos los jugadores y enemigos tienen estas estadísticas
    public Combatiente(String nombre, int puntosDeVida, int poderDeAtaque){
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.poderDeAtaque = poderDeAtaque;
        this.estaVivo = true;
    }

    // MÉTODO: para hacer un ataque básico
    public String atacar(Combatiente objetivo){
        objetivo.recibirDaño(this.poderDeAtaque);
        return this.nombre + " ataca a " + objetivo.getNombre() + " y le hace " + this.poderDeAtaque + " de daño.";
    }
    
    public void recibirDaño(int cantidad){
        this.puntosDeVida -= cantidad;
        if (puntosDeVida <= 0) {
            this.puntosDeVida = 0;
            this.estaVivo = false;
        }
    }

    // MÉTODOS: métodos abstractos que obligan a las subclases a implementar
    public abstract String tomarTurno(ArrayList<Combatiente> aliados, ArrayList<Combatiente> enemigos);
    public abstract String usarHabilidadEspecial(ArrayList<Combatiente> objetivos);

    // GETTERS Y SETTERS
    public String getNombre(){
        return nombre;
    }
    public int getPuntosDeVida(){
        return puntosDeVida;
    }
    public int getPoderDeAtaque(){
        return poderDeAtaque;
    }
    public boolean isEstaVivo(){
        return estaVivo;
    }

    public void setPoderDeAtaque(int poderDeAtaque){
        this.poderDeAtaque = poderDeAtaque;
    }
    public void setPuntosDeVida(int puntosDeVida){
        this.puntosDeVida = puntosDeVida;
    }

    @Override
    public String toString(){
        return nombre + " (Vida: " + puntosDeVida + ", Ataque: " + poderDeAtaque + ")";
    }

}
