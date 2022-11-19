/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.patolli.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Rios
 */
public class Partida {

    private int numJugadores;
    private Jugador jugadorEnTurno;
    private int id;
    private int numeroAspas;
    private Jugador[] jugadores;
    private Tablero tablero;

    public Partida() {
    }

    public Partida(int numJugadores, Jugador jugadorEnTurno, int id, Jugador[] jugadores, int numeroAspas) {
        this.numJugadores = numJugadores;
        this.jugadorEnTurno = jugadorEnTurno;
        this.id = id;
        this.jugadores = jugadores;
        this.numeroAspas = numeroAspas;
    }

    public void crearTablero() {
        if (this.numeroAspas == 8) {
            String direccion = System.getProperty("user.dir");
            direccion += "\\src\\mx\\patolli\\imagenes\\Tablero_8.png";
            List<Casilla> casillas = this.crearCasillas(this.numeroAspas);
            this.tablero = new Tablero(direccion,casillas);
     
        }
    }

    public void comprobarJugadorEnTurno() {

    }

    public void darTurnoSiguienteJugador() {

    }

    public void jugadorAbandono() {

    }

    public void terminarPartida() {

    }

    public void asignarId() {

    }

    public void asignarJugadores() {

    }

    public void agregarJugador() {

    }

    public void crearPartida() {

    }

    public List<Casilla> crearCasillas(int numeroAspas) {
        List<Casilla> casillas = new ArrayList<>();
        if (numeroAspas == 8) {
            casillas.add(new CasillaCentral(390, 340));
            casillas.add(new CasillaInOut(460, 276));
            casillas.add(new CasillaNormal(530, 211));
            casillas.add(new CasillaTriangular(589, 162));
            casillas.add(new CasillaNormal(631, 102));
            casillas.add(new CasillaNormal(584, 50));
            casillas.add(new CasillaTriangular(510, 82));
            casillas.add(new CasillaNormal(471, 141));
            casillas.add(new CasillaNormal(404, 214));
            casillas.add(new CasillaCentral(341, 271));
            casillas.add(new CasillaInOut(282, 207));
            casillas.add(new CasillaNormal(211, 146));
            casillas.add(new CasillaTriangular(159, 77));
            casillas.add(new CasillaNormal(101, 42));
            casillas.add(new CasillaNormal(52, 99));
            casillas.add(new CasillaTriangular(84, 160));
            casillas.add(new CasillaNormal(145, 202));
            casillas.add(new CasillaNormal(212, 269));
            casillas.add(new CasillaCentral(272, 326));
            casillas.add(new CasillaInOut(210, 393));
            casillas.add(new CasillaNormal(148, 463));
            casillas.add(new CasillaTriangular(86, 513));
            casillas.add(new CasillaNormal(42, 569));
            casillas.add(new CasillaNormal(95, 628));
            casillas.add(new CasillaTriangular(162, 596));
            casillas.add(new CasillaNormal(205, 528));
            casillas.add(new CasillaCentral(271, 461));
            casillas.add(new CasillaInOut(330, 397));
            casillas.add(new CasillaNormal(396, 464));
            casillas.add(new CasillaTriangular(466, 518));
            casillas.add(new CasillaNormal(509, 587));
            casillas.add(new CasillaNormal(570, 618));
            casillas.add(new CasillaTriangular(625, 572));
            casillas.add(new CasillaNormal(583, 510));
            casillas.add(new CasillaNormal(518, 464));
            casillas.add(new CasillaCentral(462, 394));
        }
        
        return casillas;
    }
    
}
