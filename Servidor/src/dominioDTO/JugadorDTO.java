package dominioDTO;

import java.io.Serializable;
import mx.patolli.dominio.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Rios
 */
public class JugadorDTO  implements Serializable{
    private static final long serialVersionUID = -912157098380179388L;
    private String nombre;
    private int fichas;
    private int puntos;
    private int fondo;
    private String color;
    private JugadorDTO instance;
    private boolean listo;

    public JugadorDTO() {
    }

    public JugadorDTO(String nombre, int fichas, int puntos, int fondo, String color) {
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

    public JugadorDTO getInstance() {
        return instance;
    }

    public void setInstance(JugadorDTO instance) {
        this.instance = instance;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }
    
    
}
