package mx.patolli.servidor;

import mx.patolli.utils.mensajes.Mensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import mx.patolli.utils.ProtocoloMensaje;

public class Servidor implements Runnable {

    private static Servidor servidor;
    private ServerSocket servidorSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Cliente cliente;
    private Set<Sala> listaSalas;

    private Servidor() throws IOException {
        this.iniciarServidor();
        this.listaSalas = new HashSet<>();

    }

    public static Servidor getInstance() throws IOException {
        if (servidor == null) {
            servidor = new Servidor();
            return servidor;
        }
        return servidor;
    }

    @Override
    public void run() {
        try{


        while(true){
                Socket nSocket = this.servidorSocket.accept();
                this.in = new ObjectInputStream(nSocket.getInputStream());
               this.out = new ObjectOutputStream(nSocket.getOutputStream());
               Thread.sleep(5000); 
            System.out.println(new Mensaje("Servidor","Cliente Conectado","").createAdvertenciaMensaje(" > "));
                out.flush();
                ProtocoloMensaje str = (ProtocoloMensaje)  this.in.readObject();
                
                System.out.println(str);
                cliente = new Cliente();
                cliente.setNombre(str.getObj().toString());
                cliente.setCliente(nSocket);
                cliente.setIdCliente(crearIdCliente());  Thread.sleep(5000);       
            System.out.println(new Mensaje("Servidor","Nuevo Cliente: " + cliente,"").createAdvertenciaMensaje(" > "));
            
            Thread thread =  new Thread(new ClienteHilo(cliente));
                thread.start();

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void iniciarServidor() {
        try {
            servidorSocket = new ServerSocket(5000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private String crearIdCliente() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            int indice = (int) Math.floor(Math.random() * chars.length());
            String caracter = String.valueOf(chars.charAt(indice));
            id.append(caracter);
        }

        return id.toString();

    }

    public void agregarSala(Sala sala) {
        if (listaSalas != null) {
            if (!listaSalas.contains(sala)) {
                String idSala = this.crearIdCliente();
                sala.setIdSala(idSala);
                this.listaSalas.add(sala);

            }
        }

    }

    public boolean eliminarSala(Sala sala) {
        if (!listaSalas.contains(sala)) {
            this.listaSalas.remove(sala);
            return true;
        }
        return false;
    }

    public Sala buscarSala(String idSala) {
        if (listaSalas != null) {
            return this.listaSalas.stream()
                    .filter(e -> idSala.equals(e.getIdSala()))
                    .toList()
                    .get(0);
        }
        return null;
    }

    public void mostrarSala(Sala sala) {
        System.out.println("idSala" + sala.getIdSala());
        System.out.println(sala);
    }

    public void mostarTodo() {
        this.listaSalas.forEach(System.out::println);
    }

    public void enviarMsgSala(String idsala, String msg) throws IOException {
        Sala sala = this.buscarSala(idsala);
        sala.getAdministrador().getOut().writeUTF(msg);
        sala.getClientes().forEach(s -> {
            try {
                if (s != null) {
                    s.getOut().writeUTF(msg);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public Object recibirObj(Cliente cliente)   {
        System.out.println(cliente);
        try (ObjectInputStream o = new ObjectInputStream(cliente.getIn())) {
            return o.readObject();
            

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
