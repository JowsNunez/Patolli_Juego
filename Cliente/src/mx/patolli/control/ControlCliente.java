package mx.patolli.control;

import mx.patolli.cliente.Cliente;
import mx.patolli.cliente.ClienteHiloIn;
import mx.patolli.cliente.ClienteHiloOut;

import java.io.IOException;
import mx.patolli.dominio.Partida;
import mx.patolli.utils.ProtocoloMensaje;
import mx.patolli.vistas.Gui;
import mx.patolli.vistas.GuiBuscarPartida;
import mx.patolli.vistas.GuiSala;
import mx.patolli.vistas.GuiTablero;

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
            this.clienteIn.setControl(this);
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
    
    public Partida getPartida(){
        return this.clienteIn.getPartida();
    }
    
    public boolean isRespones(){
        return this.clienteIn.isResponse();
    }



}
