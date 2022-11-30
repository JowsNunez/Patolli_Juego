package mx.patolli.servidor;

import java.util.ArrayList;
import java.util.List;
import mx.patolli.dominio.*;

public class SalaHilo {

    static final int[] turno1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
    static final int[] turno2 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 0, 1};
    static final int[] turno3 = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static final int[] turno4 = {28, 29, 30, 31, 32, 33, 34, 35, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

    public void crearPartida(Sala sala) {

    }

    public void crearFichas(Sala sala) {

    }

    public void crearCasillas8(Sala sala) {
        List<Casilla> casillas = sala.getPartida().getTablero().getCasillas();
        casillas.add(new CasillaCentral(382, 325));
        casillas.add(new CasillaInOut(448, 259));
        casillas.add(new CasillaNormal(515, 191));
        casillas.add(new CasillaTriangular(579, 149));
        casillas.add(new CasillaNormal(622, 84));
        casillas.add(new CasillaNormal(561, 26));
        casillas.add(new CasillaTriangular(493, 63));
        casillas.add(new CasillaNormal(448, 126));
        casillas.add(new CasillaNormal(384, 198));
        casillas.add(new CasillaCentral(320, 263));
        casillas.add(new CasillaInOut(263, 193));
        casillas.add(new CasillaNormal(192, 139));
        casillas.add(new CasillaTriangular(150, 67));
        casillas.add(new CasillaNormal(80, 30));
        casillas.add(new CasillaNormal(22, 77));
        casillas.add(new CasillaTriangular(66, 151));
        casillas.add(new CasillaNormal(143, 197));
        casillas.add(new CasillaNormal(197, 265));
        casillas.add(new CasillaCentral(258, 311));
        casillas.add(new CasillaInOut(204, 383));
        casillas.add(new CasillaNormal(147, 441));
        casillas.add(new CasillaTriangular(64, 496));
        casillas.add(new CasillaNormal(28, 553));
        casillas.add(new CasillaNormal(80, 625));
        casillas.add(new CasillaTriangular(150, 582));
        casillas.add(new CasillaNormal(195, 515));
        casillas.add(new CasillaNormal(254, 447));
        casillas.add(new CasillaCentral(318, 385));
        casillas.add(new CasillaInOut(383, 441));
        casillas.add(new CasillaNormal(444, 511));
        casillas.add(new CasillaNormal(492, 577));
        casillas.add(new CasillaTriangular(560, 614));
        casillas.add(new CasillaNormal(619, 559));
        casillas.add(new CasillaNormal(577, 496));
        casillas.add(new CasillaTriangular(506, 452));
        casillas.add(new CasillaNormal(442, 390));

        sala.getPartida().getTablero().setCasillas(casillas);
    }
    
    public static void main(String args[])
    {
        SalaHilo s = new SalaHilo();
        Sala sala = new Sala(3);
        sala.setPartida(new Partida());
        sala.getPartida().setTablero(new Tablero());
        
        
        s.crearCasillas8(sala);
       sala.getPartida().getTablero().getCasillas().forEach(System.out::println);
        System.out.println("aa");
        
    }
    
}
