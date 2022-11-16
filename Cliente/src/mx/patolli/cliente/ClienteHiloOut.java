package mx.patolli.cliente;

import java.io.*;

public class ClienteHiloOut implements Runnable{

    private Cliente cliente;
    private DataOutputStream out;

    public ClienteHiloOut(Cliente cliente){
        this.cliente=cliente;
    }

    @Override
    public void run() {

        try {
            this.out = new DataOutputStream(this.cliente.getSocket().getOutputStream());
            while (true) {
                this.out.writeUTF("");

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
