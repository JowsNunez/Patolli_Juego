package mx.patolli.servidor;



import mx.patolli.utils.Opciones;
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
            while (true) {
                this.in = new DataInputStream(this.cliente.getCliente().getInputStream());
                this.out = new DataOutputStream(this.cliente.getCliente().getOutputStream());
                while (true) {

                    String str = null;

                    if (this.aEntrado) {
                        out.writeUTF("a entrado");
                        out.flush();
                        this.aEntrado = false;
                    }


                    out.flush();
                    Opciones opcion = Opciones.valueOf(this.in.readUTF());


                    switch (opcion) {
                        case CREAR:
                                System.out.println("");
                        case UNIRSE:
                                System.out.println("");
                        case CONFIGURARJUEGO:
                                System.out.println("");
                        case CONFIGURARJUGADOR:
                                System.out.println("");
                        default:
                                System.out.println("");

                    }

                    out.flush();
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
