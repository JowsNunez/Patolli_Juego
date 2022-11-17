package mx.patolli.servidor;



import mx.patolli.utils.Opciones;
import mx.patolli.utils.mensajes.Mensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class ClienteHilo implements Runnable{
    private Cliente cliente;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean aEntrado;


    public ClienteHilo(Cliente cliente){
        this.cliente = cliente;
        this.aEntrado = true;
    }


    @Override
    public void run() {
        try{

                this.in = new DataInputStream(this.cliente.getCliente().getInputStream());
                this.out = new DataOutputStream(this.cliente.getCliente().getOutputStream());
                while (true) {

                    String str = null;

                    if (this.aEntrado) {
                        System.out.println("A entrado");
                        out.writeUTF("a entrado");
                        out.flush();
                        this.aEntrado = false;
                    }

                    out.flush();
                    Opciones opcion = Opciones.valueOf(this.in.readUTF());


                    switch (opcion) {
                        case CREAR:
                                System.out.println(new Mensaje(cliente.getIdCliente() + " " +cliente.getNombre(), " Selecciono CREAR PARTIDA", "Servidor").createMensaje(" > "));
                                break;
                        case UNIRSE:
                            System.out.println(new Mensaje(cliente.getIdCliente() + " " +cliente.getNombre(), " Selecciono UNIRSE PARTIDA", "Servidor").createMensaje(" > "));

                            break;
                        case CONFIGURARJUEGO:
                            System.out.println(new Mensaje(cliente.getIdCliente() + " " +cliente.getNombre() , " Selecciono CONFIGURAR JUEGO", "Servidor").createMensaje(" > "));

                        case CONFIGURARJUGADOR:
                            System.out.println(new Mensaje(cliente.getIdCliente() + " " +cliente.getNombre() , " Selecciono CONFIGURAR JUGADOR", "Servidor").createMensaje(" > "));

                            break;
                        default:
                            System.out.println(new Mensaje(cliente.getIdCliente() , " Error de Seleccion ", "Servidor").createErrorMensaje(" > "));

                            break;

                    }

                    out.flush();
                }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
