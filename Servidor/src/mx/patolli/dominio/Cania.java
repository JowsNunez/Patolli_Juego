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
public class Cania implements Serializable {

    @Serial
    private static final long serialVersionUID = -912157098380179388L;
    private int valor;

    public Cania cania(Cania cania) {
        return cania;
    }
}
