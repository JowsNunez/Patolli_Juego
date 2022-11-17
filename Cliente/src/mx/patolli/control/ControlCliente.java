package mx.patolli.control;

import mx.patolli.cliente.Cliente;
import mx.patolli.cliente.ClienteHiloIn;
import mx.patolli.cliente.ClienteHiloOut;

import java.io.IOException;

public class ControlCliente implements IControl<Object>{

    private ClienteHiloIn clienteIn;
    private ClienteHiloOut clienteOut;

    @Override
    public Cliente getSocket() {
            return Cliente.getInstance();
    }

    public void iniciarHilos(){
        if(Cliente.getInstance().getSocket().isConnected()){
            clienteIn = new ClienteHiloIn(Cliente.getInstance());
            clienteOut = new ClienteHiloOut(Cliente.getInstance());
            Thread thread1 = new Thread(clienteIn);
            Thread thread2 = new Thread(clienteOut);
            thread1.start();
            thread2.start();

        }else{
            System.out.println("No conexion");
        }

    }

    public void enviarNombre(String str){
        try {
            this.clienteOut.enviar(str);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }



}
