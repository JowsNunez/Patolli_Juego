package mx.patolli.cliente;

import java.io.*;
import java.util.Scanner;
import mx.patolli.utils.ProtocoloMensaje;


public class ClienteHiloOut implements Runnable{

    private Cliente cliente;
    private ObjectOutputStream outObj;


    public ClienteHiloOut(Cliente cliente){
        this.cliente=cliente;
        iniciarDataOut();

    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
              
                
                this.outObj.writeObject(new ProtocoloMensaje("", ""));
                this.outObj.flush();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

  
     public void enviarObj(ProtocoloMensaje o) throws IOException {
         
        this.outObj.writeObject(o);
        

    }

    private void iniciarDataOut(){
        try {
            this.outObj = new ObjectOutputStream(this.cliente.getSocket().getOutputStream());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
