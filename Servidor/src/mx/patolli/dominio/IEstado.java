package mx.patolli.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Rios
 */
public interface IEstado {
    
    public void enEspera();
    public void enTurno();
    public void ganador();
    public void perdedor();
    public void setJugador(Jugador jugador);
    
}
