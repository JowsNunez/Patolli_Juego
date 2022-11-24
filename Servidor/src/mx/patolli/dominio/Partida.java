package mx.patolli.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Rios
 */
public class Partida implements Serializable {
    @Serial
    private static final long serialVersionUID = -912157098380179388L;

    private int numJugadores;
    private int numAspas;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private int numFichas;
    private int apuesta;

    public Partida() {
                this.jugadores=new ArrayList<>();

    }

    public Partida(int numJugadores, int numAspas, Tablero tablero, int numFichas, int apuesta) {
        this.numJugadores = numJugadores;
        this.numAspas = numAspas;
        this.tablero = tablero;
        this.numFichas = numFichas;
        this.apuesta = apuesta;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getNumAspas() {
        return numAspas;
    }

    public void setNumAspas(int numAspas) {
        this.numAspas = numAspas;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public void setNumFichas(int numFichas) {
        this.numFichas = numFichas;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    @Override
    public String toString() {
        return "Partida{" + "numJugadores=" + numJugadores + ", numAspas=" + numAspas + ", jugadores=" + jugadores + ", tablero=" + tablero + ", numFichas=" + numFichas + ", apuesta=" + apuesta + '}';
    }

}
