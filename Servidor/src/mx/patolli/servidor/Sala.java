package mx.patolli.servidor;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Sala implements Serializable {

    private Long idSala;
    private Set<Cliente> clientes;
    private int numClientes;
    private Cliente administrador;


    public Sala(){

    }

    public Sala(int numClientes){
        this.numClientes=numClientes;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
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

    @Override
    public String toString() {
        return  " idSala: " + idSala + " clientes: " + clientes +" numClientes: " + numClientes + "administrador: " + administrador;
    }
}
