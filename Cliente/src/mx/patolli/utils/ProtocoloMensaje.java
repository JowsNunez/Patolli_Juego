/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.patolli.utils;
import java.io.Serial;
import java.io.Serializable;


/**
 *
 * @author el_fr
 */
public class ProtocoloMensaje implements Serializable{
    private static final long serialVersionUID = -912157098380179388L;
    private String comando;
    private Object obj;

    public ProtocoloMensaje(String comando, Object obj) {
        this.comando = comando;
        this.obj = obj;
    }
    

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ProtocoloMensaje{" + "comando=" + comando + ", obj=" + obj + '}';
    }
    
    
}
