/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.patolli.dominio;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Kevin Rios
 */
public class EnEspera implements IEstado, Serializable{
    private Jugador jugador;
    @Serial
    private static final long serialVersionUID = -912157098380179388L;

    @Override
    public void enEspera() {
        this.jugador.setEstado(new EnEspera());
    }

    @Override
    public void enTurno() {
        this.jugador.setEstado(new EnTurno());
    }

    @Override
    public void ganador() {
        this.jugador.setEstado(new Ganador());
    }

    @Override
    public void perdedor() {
        this.jugador.setEstado(new Perdedor());
    }

    @Override
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "{En Espera }";
    }
    
    
    
}
