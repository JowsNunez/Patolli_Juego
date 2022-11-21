
package mx.patolli.main;

import mx.patolli.servidor.Servidor;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {

        Thread hiloServidor = new Thread(Servidor.getInstance());
        hiloServidor.start();
    }
}