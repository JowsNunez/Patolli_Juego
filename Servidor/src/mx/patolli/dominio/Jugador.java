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
public class Jugador {
    private String nombre;
    private int fichas;
    private int puntos;
    private int fondo;
    private String color;
    private Jugador instance;
    private boolean listo;

    public Jugador() {
    }

    public Jugador(String nombre, int fichas, int puntos, int fondo, String color) {
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

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Jugador getInstance() {
        return instance;
    }

    public void setInstance(Jugador instance) {
        this.instance = instance;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }
    
    
}
