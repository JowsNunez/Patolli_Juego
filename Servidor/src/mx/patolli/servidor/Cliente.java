package mx.patolli.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import mx.patolli.dominio.Jugador;

public class Cliente implements Serializable {

    private String idCliente;
    private String nombre;
    private Socket cliente;
    private Jugador jugador;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public Cliente() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
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
        return " nombre:" + nombre + " id:" + idCliente + " cliente: " + cliente;
    }
}
