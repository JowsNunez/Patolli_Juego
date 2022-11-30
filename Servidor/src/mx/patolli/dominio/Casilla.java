/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.patolli.dominio;

import java.util.List;

/**
 *
 * @author Kevin Rios
 */
public interface Casilla {

    List<Ficha> getFichas();
    public int getPosicionX();
    public int getPosicionY();
}
