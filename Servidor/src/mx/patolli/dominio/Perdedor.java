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
public class Perdedor implements IEstado, Serializable {
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
        throw new UnsupportedOperationException("El estado no puede cambiar", new Throwable("El estado no es válido"));
    }

    @Override
    public void perdedor() {
        throw new UnsupportedOperationException("El estado no puede cambiar", new Throwable("El estado no es válido"));
    }

    @Override
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
     @Override
    public String toString() {
        return "{Perdedor}";
    }
    
}
