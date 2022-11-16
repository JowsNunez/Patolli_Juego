package mx.patolli.cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClienteHiloIn implements Runnable{

    private Cliente cliente;
    private DataInputStream in;

    public ClienteHiloIn(Cliente cliente){
        this.cliente=cliente;
    }

    @Override
    public void run() {

        try {
            this.in = new DataInputStream(this.cliente.getSocket().getInputStream());
            while (true) {
                this.in.readUTF();

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
