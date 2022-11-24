/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.patolli.dominio;

/**
 *
 * @author el_fr
 */
public interface IObservable {
    void agregarObservador(IObserver e);
    void eliminarObservador(IObserver e);
    void notificarObervadores();
    void setCambios();
    
}
