package mx.patolli.servidor;

import mx.patolli.utils.Opciones;
import mx.patolli.utils.mensajes.Mensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import mx.patolli.dominio.Partida;
import mx.patolli.utils.ProtocoloMensaje;

public class ClienteHilo implements Runnable {

    private Cliente cliente;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean aEntrado;
    private Sala sala;

    public ClienteHilo(Cliente cliente) {
        this.cliente = cliente;
        this.aEntrado = true;
    }

    @Override
    public void run() {
        try {
            ProtocoloMensaje msg;
            this.in = new ObjectInputStream(this.cliente.getCliente().getInputStream());
            this.out = new ObjectOutputStream(this.cliente.getCliente().getOutputStream());
            this.cliente.setIn(in);
            this.cliente.setOut(out);
            while (true) {

                String str = null;

                if (this.aEntrado) {
                    System.out.println("A entrado");
             //       out.writeObject(new ProtocoloMensaje("a entrado", "A entrado"));
               //     out.flush();
                    this.aEntrado = false;
                }

                out.flush();
                msg = (ProtocoloMensaje) Servidor.getInstance().recibirObj(this.cliente);
                Opciones opcion = Opciones.valueOf(msg.getComando());

                switch (opcion) {
                    case CREAR:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CREAR PARTIDA", "Servidor").createMensaje(" > "));
                        Sala sala = new Sala();
                        sala.setAdministrador(this.cliente);

                        msg = (ProtocoloMensaje) Servidor.getInstance().recibirObj(this.cliente);
                        Partida partida = (Partida) msg.getObj();
                        sala.setPartida(partida);
                        sala.setNumClientes(partida.getNumJugadores());
//                        
                        Servidor.getInstance().agregarSala(sala);
                        Servidor.getInstance().mostrarSala(sala);
                        Servidor.getInstance().mostarTodo();
                        break;
                    case UNIRSE:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono UNIRSE PARTIDA", "Servidor").createMensaje(" > "));
                        str = this.in.readUTF();
                        this.sala = Servidor.getInstance().buscarSala(str);
                        if (this.sala.getClientes().size() < this.sala.getNumClientes() - 1) {
                            this.sala.getClientes().add(this.cliente);
                            this.sala.getClientes().forEach(System.out::println);
                            Servidor.getInstance().mostarTodo();
                            Servidor.getInstance().enviarMsgSala(str, "Se unió: " + this.cliente.getNombre());

                        } else {
                            System.out.println("Error");
                        }

                        break;
                    case CONFIGURARJUEGO:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CONFIGURAR JUEGO", "Servidor").createMensaje(" > "));

                    case CONFIGURARJUGADOR:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CONFIGURAR JUGADOR", "Servidor").createMensaje(" > "));

                        break;
                    default:
                        System.out.println(new Mensaje(cliente.getIdCliente(), " Error de Seleccion ", "Servidor").createErrorMensaje(" > "));

                        break;

                }

                out.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
