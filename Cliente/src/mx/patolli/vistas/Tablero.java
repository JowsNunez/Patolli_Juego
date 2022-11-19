/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.patolli.vistas;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author el_fr
 */
public class Tablero extends Canvas implements MouseListener {

    private final List<String> str = new ArrayList<>();
    private List<Puntos> puntos;

    private BufferedImage imagen;
    private int a = 1;
    private int b = 10;
    private int c = 19;
    private int d = 28;

    private boolean init = true;

    private int turno = 1;

    public Tablero() {
        this.puntos = new ArrayList<>();
        this.addMouseListener(this);
        this.cargar();
        this.getTablero();

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(imagen, 0, 0, this);
        
        g2d.setStroke(new BasicStroke(1));
        pintarPunto(g2d);

    }

    public void getTablero() {
        try {
            // A modo de ejemplo, puse la imagen en el C:, sin embargo podrías agregarla a tu proyecto, o buscarla en otro directorio
            this.imagen = ImageIO.read(new File("C:\\Users\\el_fr\\Documents\\ITSON\\Arquitectura de Software\\Pryecto_Patolli\\Cliente\\src\\mx\\patolli\\imagenes\\Tablero_8.png"));

            System.out.println(this.imagen);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            // Controlar la excepcion si la imagen no se encuentra o no se pudo cargar
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //   a++;
         //this.str.add(a + " * " + this.getMousePosition().x + " " + this.getMousePosition().y);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("******");
        str.forEach(System.out::println);
    }

    private void cambiarTurno() {
        switch (this.turno) {
            case 1:
                this.turno = 2;
                break;
            case 2:
                this.turno = 3;
                break;
            case 3:
                this.turno = 4;
                break;
            default:
                turno = 1;
                break;
        }
    }

    public void cargar() {
        puntos.add(new Puntos(390, 340));
        puntos.add(new Puntos(460, 276));
        puntos.add(new Puntos(530, 211));
        puntos.add(new Puntos(589, 162));
        puntos.add(new Puntos(631, 102));
        puntos.add(new Puntos(584, 50));
        puntos.add(new Puntos(510, 82));
        puntos.add(new Puntos(471, 141));
        puntos.add(new Puntos(404, 214));
        puntos.add(new Puntos(341, 271));
        puntos.add(new Puntos(282, 207));
        puntos.add(new Puntos(211, 146));
        puntos.add(new Puntos(159, 77));
        puntos.add(new Puntos(101, 42));
        puntos.add(new Puntos(52, 99));
        puntos.add(new Puntos(84, 160));
        puntos.add(new Puntos(145, 202));
        puntos.add(new Puntos(212, 269));
        puntos.add(new Puntos(272, 326));
        puntos.add(new Puntos(210, 393));
        puntos.add(new Puntos(148, 463));
        puntos.add(new Puntos(86, 513));
        puntos.add(new Puntos(42, 569));
        puntos.add(new Puntos(95, 628));
        puntos.add(new Puntos(162, 596));
        puntos.add(new Puntos(205, 528));
        puntos.add(new Puntos(271, 461));
        puntos.add(new Puntos(330, 397));
        puntos.add(new Puntos(396, 464));
        puntos.add(new Puntos(466, 518));
        puntos.add(new Puntos(509, 587));
        puntos.add(new Puntos(570, 618));
        puntos.add(new Puntos(625, 572));
        puntos.add(new Puntos(583, 510));
        puntos.add(new Puntos(518, 464));
        puntos.add(new Puntos(462, 394));
    }

    public void pintarPunto(Graphics2D g2d) {
        if (!init) {

//            if (a < puntos.size()) {
//                if (turno == 1) {
//                    int dado = dado();
//                    a += dado;
//                    if(a>=35){
//                          System.out.println("Gano jugador 1");
//                         return;
//                    }
//                }
//                if (turno == 2) {
//                    int dado = dado();
//                    b += dado;
//                    if (b >= 28) {
//                        System.out.println("Gano jugador 2");
//                         return;
//                    }
//
//                }
//                if (turno == 3) {
//                    int dado = dado();
//                    c += dado;
//                    
//                    if (c == 35) {
//                        c = 0;
//                    }
//                    if (c > 35) {
//                        c -= dado();
//                    }
//
//                    if (c >= 10) {
//                        System.out.println("Gano jugador 3");
//                        return;
//                    }
//
//                }
//                if (turno == 4) {
//                    int dado = dado();
//                    d += dado;
//                    if (d > 35) {
//                        d = 8;
//                        d += dado();
//                    }
//                    if (d == 35) {
//                        d = 0;
//                    }
//                    if (d >= 27) {
//                        System.out.println("Gano jugador 4");
//                         return;
//                    }
//
//                }

                g2d.setColor(Color.BLUE);
                Ellipse2D r = new Ellipse2D.Double(puntos.get(a).getX(), puntos.get(a).getY(), 40, 40);
                g2d.fill(r);
                g2d.draw(r);
                g2d.setColor(Color.YELLOW);
                Ellipse2D r2 = new Ellipse2D.Double(puntos.get(b+8).getX(), puntos.get(b+8).getY(), 40, 40);
                g2d.fill(r2);
                g2d.draw(r2);
                g2d.setColor(Color.BLACK);
                Ellipse2D r3 = new Ellipse2D.Double(puntos.get(c).getX(), puntos.get(c).getY(), 40, 40);
                g2d.fill(r3);
                g2d.draw(r3);
                g2d.setColor(Color.CYAN);
                Ellipse2D r4 = new Ellipse2D.Double(puntos.get(d).getX(), puntos.get(d).getY(), 40, 40);
                g2d.fill(r4);
                g2d.draw(r4);
                
                a++;
                c++;
                b++;
                d++;

            
            this.cambiarTurno();
        } else {
          
            this.init = false;
        }
        
        System.out.println(a +" "+ b +" "+ c +" "+ d);

    }

    private int dado() {
        return (int) Math.floor(Math.random() * 5);
    }

    class Puntos {

        private int x;
        private int y;

        public Puntos() {

        }

        public Puntos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }
}
