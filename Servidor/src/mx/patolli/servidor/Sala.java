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
    private int turnoActual;
    private int turno;

    public Sala() {
        this.clientes = new HashSet<>();
        turnoActual=1;
        turno = 1;
    }

    public Sala(int numClientes) {
        this.numClientes = numClientes;
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

    public int getTurnos() {
        return turno;
    }

    public void setTurnos(int turnos) {
        this.turno = turnos;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public void cambiarTurno() {
        if (turnoActual == numClientes) {
            turnoActual = 1;
        } else {
            turnoActual++;
        }
    }

    @Override
    public String toString() {

        return "Sala{" + "idSala=" + idSala + ", clientes=" + clientes + ", numClientes=" + numClientes + ", partida=" + partida + ", administrador=" + administrador + '}';

    }
}
