package mx.patolli.utils.mensajes;

import java.io.Serializable;

public class Mensaje implements Serializable {

    public String remitente;
    public String mensaje;
    public String destinatario;

    public Mensaje(String remitente,String mensaje,String destinatario){
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    public String createMensaje(String separador){
        IColorString color = new ColorStringBuilder();

        ColorString msg =color
                .messageColor(Color.BLUE,this.remitente)
                .messageColor(Color.GREEN,separador + this.mensaje)
                .messageColor(Color.MAGENTA, separador +this.destinatario)
                .messageColor(Color.NONE,"").
                build();

        return msg.toString();
    }

    public String createErrorMensaje(String separador){
        IColorString color = new ColorStringBuilder();

        ColorString msg =color
                .messageColor(Color.BLUE,this.remitente)
                .messageColor(Color.RED,separador + this.mensaje)
                .messageColor(Color.MAGENTA, separador +this.destinatario)
                .messageColor(Color.NONE,"").
                build();

        return msg.toString();
    }
    public String createAdvertenciaMensaje(String separador){
        IColorString color = new ColorStringBuilder();

        ColorString msg =color
                .messageColor(Color.BLUE,this.remitente)
                .messageColor(Color.YELLOW,separador + this.mensaje)
                .messageColor(Color.MAGENTA, separador +this.destinatario)
                .messageColor(Color.NONE,"").
                build();

        return msg.toString();
    }


}
