package mx.patolli.cliente;

import java.io.*;
import java.util.Scanner;

public class ClienteHiloOut implements Runnable{

    private Cliente cliente;
    private DataOutputStream out;

    public ClienteHiloOut(Cliente cliente){
        this.cliente=cliente;
        iniciarDataOut();

    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String str = scanner.nextLine();
                this.out.writeUTF(str);

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void enviar(String str) throws IOException {
        this.out.writeUTF(str);

    }

    private void iniciarDataOut(){
        try {
            this.out = new DataOutputStream(this.cliente.getSocket().getOutputStream());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
