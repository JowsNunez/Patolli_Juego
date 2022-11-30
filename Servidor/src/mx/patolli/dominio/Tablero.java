package mx.patolli.dominio;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Rios
 */
public class Tablero implements Serializable {

    @Serial
    private static final long serialVersionUID = -912157098380179388L;
    private List<Casilla> casillas;
    private String urlImagen;

    public Tablero() {
        this.casillas= new ArrayList<>();
    }

    public Tablero(String urlImagen, List<Casilla> casillas) {
        this.urlImagen = urlImagen;
        this.casillas = casillas;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(List<Casilla> casillas) {
        this.casillas = casillas;
    }

}
