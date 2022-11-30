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
public class EnTurno implements IEstado,Serializable{
    private Jugador jugador;
    private static final long serialVersionUID = -912157098380179388L;
    @Override
    public void enEspera() {
        jugador.setEstado(new EnEspera());
    }

    @Override
    public void enTurno() {
        throw new UnsupportedOperationException("El estado no puede cambiar", new Throwable("El estado no es válido"));
    }

    @Override
    public void ganador() {
        if (jugador.getEstado() instanceof Perdedor) {
            throw new UnsupportedOperationException("El estado no puede cambiar", new Throwable("El estado no es válido"));
        }
        jugador.setEstado(new Ganador());
    }

    @Override
    public void perdedor() {
        if (jugador.getEstado() instanceof Ganador) {
            throw new UnsupportedOperationException("El estado no puede cambiar", new Throwable("El estado no es válido"));
        }
        jugador.setEstado(new Perdedor());
    }

    @Override
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
     @Override
    public String toString() {
        return "{En Turno }";
    }
    
    
}
