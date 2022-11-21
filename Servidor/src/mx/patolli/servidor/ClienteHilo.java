package mx.patolli.servidor;

import mx.patolli.utils.Opciones;
import mx.patolli.utils.mensajes.Mensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class ClienteHilo implements Runnable {

    private Cliente cliente;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean aEntrado;
    private Sala sala;

    public ClienteHilo(Cliente cliente) {
        this.cliente = cliente;
        this.aEntrado = true;
    }

    @Override
    public void run() {
        try {

            this.in = new DataInputStream(this.cliente.getCliente().getInputStream());
            this.out = new DataOutputStream(this.cliente.getCliente().getOutputStream());
            while (true) {

                String str = null;

                if (this.aEntrado) {
                    this.aEntrado = false;
                }

                out.flush();
                Opciones opcion = Opciones.valueOf(this.in.readUTF());

                switch (opcion) {
                    case CREAR:
                        Sala sala = new Sala();
                        sala.setAdministrador(this.cliente);
                        str = this.in.readUTF();
                        sala.setNumClientes(Integer.parseInt(str));

                        Servidor.getInstance().agregarSala(sala);
                        System.out.println(new Mensaje(cliente.getIdCliente() + " " + cliente.getNombre(), " Selecciono CREAR PARTIDA", "Servidor").createMensaje(" > "));
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
                        }else{
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
