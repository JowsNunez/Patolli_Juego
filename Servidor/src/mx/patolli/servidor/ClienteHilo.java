package mx.patolli.servidor;

import mx.patolli.dominio.EnEspera;
import mx.patolli.utils.Opciones;
import mx.patolli.utils.mensajes.Mensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.patolli.dominio.Jugador;
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
            this.in = this.cliente.getIn();
            this.out = this.cliente.getOut();
            Jugador  j;

            this.cliente.setIn(in);
            this.cliente.setOut(out);
            System.out.println("Todo bien");
            while (true) {
                this.out.reset();
                String str = null;

                if (this.aEntrado) {

                    //       out.writeObject(new ProtocoloMensaje("a entrado", "A entrado"));
                    //     out.flush();

                    this.aEntrado = false;
                }

                msg = (ProtocoloMensaje) this.in.readObject();
                Opciones opcion = Opciones.valueOf(msg.getComando());

                switch (opcion) {
                    case CREAR:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CREAR PARTIDA", "Servidor").createMensaje(" > "));
                        this.sala = new Sala();
                        sala.setAdministrador(this.cliente);
                        j=new Jugador();
                        j.setNombre(this.cliente.getNombre());
                        this.cliente.setJugador(j);
                        this.sala.getClientes().add(this.cliente);

                        
                        break;
                    case UNIRSE:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono UNIRSE PARTIDA", "Servidor").createMensaje(" > "));
                        msg = (ProtocoloMensaje) this.in.readObject();
                        String idSala = msg.getObj().toString();
                        j =new Jugador();
                        j.setNombre(this.cliente.getNombre());
                        this.cliente.setJugador(j);

                        this.sala = Servidor.getInstance().buscarSala(idSala);
                        this.out.writeObject(new ProtocoloMensaje("PARTIDA", this.sala.getPartida()));

                        if (this.sala.getClientes().size() <= this.sala.getNumClientes() ) {
                            this.sala.getClientes().add(this.cliente);
                            this.sala.getClientes().forEach(System.out::println);
                            Servidor.getInstance().mostarTodo();
                            Servidor.getInstance().enviarMsgSala(idSala, "Se unió: " + this.cliente.getNombre());

                        } else {
                            System.out.println("Error");
                        }

                        break;
                    case CONFIGURARJUEGO:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CONFIGURAR JUEGO", "Servidor").createMensaje(" > "));
                        
                        Partida partida = (Partida) msg.getObj();
                        this.sala.setPartida(partida);
                        this.sala.setNumClientes(partida.getNumJugadores());
//                     
                        Servidor.getInstance().agregarSala(sala);
                        Servidor.getInstance().mostrarSala(sala);
                        this.out.writeObject(new ProtocoloMensaje("PARTIDA", partida));
                        
                        break;
                    case CONFIGURARJUGADOR:
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CONFIGURAR JUGADOR", "Servidor").createMensaje(" > "));


                        Jugador aux = (Jugador)msg.getObj();
                        this.cliente.getJugador().setFondo(aux.getFondo());
                         this.cliente.getJugador().setColor(aux.getColor());
                         this.cliente.getJugador().setEstado(new EnEspera());
                        this.sala.getPartida().getJugadores().add(this.cliente.getJugador());


                         this.sala.getClientes().forEach(e -> {
                             try {
                                 e.getOut().reset();
                                 e.getOut().writeObject(new ProtocoloMensaje("CONFIGURACION JUGADOR",this.sala.getPartida()));
                                 e.getOut().flush();

                             } catch (IOException ex) {
                                 ex.printStackTrace();
                             }
                         });
                        break;
                    default:
                        System.out.println(new Mensaje(cliente.getIdCliente(), " Error de Seleccion ", "Servidor").createErrorMensaje(" > "));

                        break;

                }

                out.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
