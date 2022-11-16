package mx.patolli.servidor;


import java.io.Serializable;
import java.net.Socket;


public class Cliente  implements Serializable {


    private Long idCliente;
    private String nombre;
    private Socket cliente;

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return " nombre:" + nombre + " id:" + idCliente +" cliente: " + cliente;
    }
}
