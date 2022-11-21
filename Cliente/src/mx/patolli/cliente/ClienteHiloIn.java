package mx.patolli.cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import mx.patolli.utils.ProtocoloMensaje;

public class ClienteHiloIn implements Runnable{

    private Cliente cliente;
    private ObjectInputStream in;

    public ClienteHiloIn(Cliente cliente){
        this.cliente=cliente;
    }

    @Override
    public void run() {

        try {
            this.in = new ObjectInputStream(this.cliente.getSocket().getInputStream());
            while (true) {
                ProtocoloMensaje str =  (ProtocoloMensaje)this.in.readObject();
                System.out.println(str.getComando());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteHiloIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
