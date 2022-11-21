package mx.patolli.servidor;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mx.patolli.dominio.Partida;

public class Sala implements Serializable {

    private String idSala;
    private Set<Cliente> clientes;
    private int numClientes;
    private Partida partida;
    private Cliente administrador;


    public Sala(){
        this.clientes= new HashSet<>();
    }

    public Sala(int numClientes){
        this.numClientes=numClientes;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    public Cliente getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Cliente administrador) {
        this.administrador = administrador;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    

    @Override
    public String toString() {
        return  " idSala: " + idSala + " clientes: " + clientes +" numClientes: " + numClientes + "administrador: " + administrador;
    }
}
