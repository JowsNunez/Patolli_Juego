/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.patolli.modelos;

import java.util.List;

/**
 *
 * @author el_fr
 */
public class CasillaNormal implements Casilla{
     private List<Ficha> fichas;
     private int posicionX;
    private int posicionY;

    public CasillaNormal() {
    }

    public CasillaNormal(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    

    @Override
    public List<Ficha> getFichas() {
        return this.fichas;
    }
    
    
    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
     @Override
    public String toString() {
        return "Casilla Normal";
    }
    

}
