package mx.patolli.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Servidor implements Runnable {

    private static Servidor servidor;
    private ServerSocket servidorSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Cliente cliente;



    private Servidor() throws IOException {
        this.iniciarServidor();

    }

    public static Servidor getInstance() throws IOException {
        if(servidor==null){
            servidor=new Servidor();
            return servidor;
        }
        return servidor;
    }

    @Override
    public void run() {
        try{


        while(true){
            Socket nSocket = this.servidorSocket.accept();
            this.in = new DataInputStream(nSocket.getInputStream());
            this.out = new DataOutputStream(nSocket.getOutputStream());

            out.flush();
            String str = this.in.readUTF();
            cliente = new Cliente();
            cliente.setNombre(str);
            cliente.setCliente(nSocket);
            Thread thread =  new Thread(new ClienteHilo(cliente));
            thread.start();

        }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private void iniciarServidor(){
        try{
            servidorSocket = new ServerSocket(5000);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}
