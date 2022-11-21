package mx.patolli.control;

import mx.patolli.cliente.Cliente;
import mx.patolli.cliente.ClienteHiloIn;
import mx.patolli.cliente.ClienteHiloOut;

import java.io.IOException;
import mx.patolli.utils.ProtocoloMensaje;

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

    
    public void enviar(ProtocoloMensaje o){
        try {
            this.clienteOut.enviarObj(o);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }



}
