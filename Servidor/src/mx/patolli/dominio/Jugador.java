package mx.patolli.dominio;

import java.io.Serial;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin Rios
 */
public class Jugador implements Serializable {

    
    private static final long serialVersionUID = -912157098380179388L;
    private String nombre;
    private int fichas;
    private int puntos;
    private String fondo;
    private String color;
    private boolean listo;
    private IEstado estado;
    private int turno;
    private int[] ruta;

    public Jugador() {
    }

    public Jugador(String nombre, int fichas, int puntos, String fondo, String color) {
        this.nombre = nombre;
        this.fichas = fichas;
        this.puntos = puntos;
        this.fondo = fondo;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int[] getRuta() {
        return ruta;
    }

    public void setRuta(int[] ruta) {
        this.ruta = ruta;
    }

     public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }
    
   public void enEspera(){
       this.estado.enEspera();
       this.estado.setJugador(this);
   }
   
   public void perdedor(){
       this.estado.perdedor();
       this.estado.setJugador(this);
   }
    
   public void enTurno(){
       this.estado.enTurno();
       this.estado.setJugador(this);
   }
   
   public void ganador(){
        this.estado.ganador();
        this.estado.setJugador(this);
   }
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", fichas=" + fichas + ", puntos=" + puntos + ", fondo=" + fondo + ", color=" + color + ", listo=" + listo + '}';
    }

}
