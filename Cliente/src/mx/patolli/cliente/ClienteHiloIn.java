package mx.patolli.cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.patolli.control.ControlCliente;
import mx.patolli.dominio.Partida;

import mx.patolli.utils.ProtocoloMensaje;
import mx.patolli.vistas.GuiTablero;

public class ClienteHiloIn implements Runnable {

    private Cliente cliente;
    private ObjectInputStream in;
    private Partida partida;
    private boolean response;
    private ControlCliente control;

    public ClienteHiloIn(Cliente cliente) {
        this.cliente = cliente;
        this.partida = new Partida();
        this.response = false;
    }

    public ControlCliente getControl() {
        return control;
    }

    public void setControl(ControlCliente control) {
        this.control = control;
    }

    @Override
    public void run() {

        try {
            this.in = new ObjectInputStream(this.cliente.getSocket().getInputStream());
            while (true) {
                this.response = false;
                ProtocoloMensaje str = (ProtocoloMensaje) this.in.readObject();
                if (str.getComando().equals("CONFIGURACION JUGADOR")) {
                    Partida aux = (Partida) str.getObj();
                    this.partida.setApuesta(aux.getApuesta());
                    this.partida.setNumAspas(aux.getNumAspas());
                    this.partida.setNumJugadores(aux.getNumJugadores());
                    this.partida.setNumFichas(aux.getNumFichas());
                    this.partida.setJugadores(aux.getJugadores());
                    System.out.println(aux.getJugadores());
                    this.response = true;

                    this.partida.notificarObervadores();

                }
                if (str.getComando().equals("VOTAR")) {
                    Partida aux = (Partida) str.getObj();
                    this.partida.setJugadores(aux.getJugadores());
                    this.response = true;
                    this.partida.notificarObervadores();

                }

                if (str.getComando().equals("UNIRSEPARTIDA")) {
                    Partida aux = (Partida) str.getObj();
                    this.partida.setJugadores(aux.getJugadores());
                }

                if (str.getComando().equals("INICIARPARTIDA")) {
                    this.partida.notificarObervadores();
                    new GuiTablero(this.control).setVisible(true);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteHiloIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Partida getPartida() {
        return this.partida;
    }

    public boolean isResponse() {
        return this.response;
    }
}
