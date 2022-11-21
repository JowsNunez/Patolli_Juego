package mx.patolli.cliente;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
      private String nombre;
      private Socket socket;
      private static Cliente socketCliente;
      private static final String HOST="";
      private static final int PORT=5000;

      private Cliente(){

            this.iniciarSocket();
      }

      private void iniciarSocket(){
          try {
               this.socket = new Socket(HOST, PORT);
          }catch (IOException e){
              System.out.println(e.getMessage());
          }

      }

      public static Cliente getInstance(){
          if(socketCliente==null){
              socketCliente= new Cliente();
          }
          return socketCliente;
      }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
