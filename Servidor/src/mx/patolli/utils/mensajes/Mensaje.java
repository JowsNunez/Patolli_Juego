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

    public String createMensaje(String separador,Color cRemitente, Color cMensaje,Color cDestinatario){
        IColorString color = new ColorStringBuilder();

        ColorString msg =color.messageColor(cRemitente,this.remitente)
                .messageColor(cMensaje,separador + this.mensaje)
                .messageColor(cDestinatario, separador +this.destinatario)
                .messageColor(Color.NONE,"").
                build();

        return msg.toString();
    }



}
