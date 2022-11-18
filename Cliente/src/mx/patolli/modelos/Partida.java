/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.patolli.modelos;

/**
 *
 * @author Kevin Rios
 */
public class Partida {
    private int numJugadores;
    private Jugador jugadorEnTurno;
    private int id;
    private Jugador [] jugadores;

    public Partida() {
    }

    public Partida(int numJugadores, Jugador jugadorEnTurno, int id, Jugador[] jugadores) {
        this.numJugadores = numJugadores;
        this.jugadorEnTurno = jugadorEnTurno;
        this.id = id;
        this.jugadores = jugadores;
    }
    
    
    public void comprobarJugadorEnTurno(){
        
    }
    
    
    public void darTurnoSiguienteJugador(){
        
    }
    
    public void jugadorAbandono(){
        
    }
    
    public void terminarPartida(){
        
    }
    
    public void asignarId(){
        
    }
    
    public void asignarJugadores(){
        
    }
    
    public void agregarJugador(){
        
    }
    
    public void crearPartida(){
        
    }
}
