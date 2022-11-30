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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author el_fr
 */
public class Tablero extends JPanel implements MouseListener, MouseMotionListener {

    private final List<String> str = new ArrayList<>();
    private List<Puntos> puntos;
    private boolean primer = true;
    Graphics2D g2d;
    static int x;
    static int y;
    private BufferedImage imagen;
    private int a = 0;
    private int b = 10;
    private int c = 19;
    private int d = 28;

    private boolean init = true;

    private int turno = 1;

    public Tablero() {
        this.puntos = new ArrayList<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.getTablero();

    }

    @Override
    public void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setBackground(new Color(105, 105, 105));
        g2d.drawImage(imagen, 0, 0, this);
        if (!this.puntos.isEmpty()) {
            for (int i = 0; i < this.puntos.size(); i++) {
                if (i == 1 || i == 12 || i == 23 || i == 34) {
                    g2d.setColor(Color.YELLOW);
                } else if (i == 3 || i == 6 || i == 12 || i == 15 || i == 21 || i == 24 || i == 31 || i == 34) {
                    g2d.setColor(Color.red);
                } else if(i==0 || i==9||i==18||i==27) {
                    g2d.setColor(Color.pink);
                }else{
                    g2d.setColor(Color.green);
            }

                Ellipse2D r = new Ellipse2D.Double(this.puntos.get(i).getX(), this.puntos.get(i).getY(), 35, 35);
                g2d.fill(r);
                g2d.draw(r);
            }
        }
        g2d.setColor(Color.BLUE);
        Ellipse2D r = new Ellipse2D.Double(x, y, 35, 35);
        g2d.fill(r);
        g2d.draw(r);
//
        g2d.dispose();
//        Toolkit.getDefaultToolkit().sync();

    }

    public void getTablero() {
        try {
            // A modo de ejemplo, puse la imagen en el C:, sin embargo podrías agregarla a tu proyecto, o buscarla en otro directorio
            this.imagen = ImageIO.read(new File("C:\\Users\\el_fr\\Documents\\ITSON\\Arquitectura de Software\\Pryecto_Patolli\\Cliente\\src\\mx\\patolli\\imagenes\\Tablero_10.png"));

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

        this.puntos.add(new Puntos(a, this.getMousePosition().x, this.getMousePosition().y));
        if (a == 1 || a == 12 || a == 23 || a == 34) {
            System.out.println("casillas.add(new CasillaInOut(" + this.getMousePosition().x + "," + this.getMousePosition().y + "));");
        } else if (a == 3 || a == 6 || a == 12 || a == 15 || a == 21 || a == 24 || a == 31 || a == 34) {
            System.out.println("casillas.add(new CasillaTriangular(" + this.getMousePosition().x + "," + this.getMousePosition().y + "));");
        } else if(a==0 || a==9||a==18||a==27) {
            System.out.println("casillas.add(new CasillaCentral(" + this.getMousePosition().x + "," + this.getMousePosition().y + "));");
        }else{
                        System.out.println("casillas.add(new CasillaNormal(" + this.getMousePosition().x + "," + this.getMousePosition().y + "));");

        }

        // System.out.println(this.puntos);
        a++;
        repaint();
        // update(g2d);
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
        // System.out.println("******");
        puntos.forEach(System.out::println);
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

    public void pintarPunto(Graphics2D g2d) {
        for (int i = 0; i < this.puntos.size() - 1; i++) {
            g2d.setColor(Color.BLUE);
            Ellipse2D r = new Ellipse2D.Double(puntos.get(i).getX(), puntos.get(i).getY(), 40, 40);
            g2d.fill(r);
            g2d.draw(r);
        }
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
//                g2d.setColor(Color.YELLOW);
//                Ellipse2D r2 = new Ellipse2D.Double(puntos.get(b+8).getX(), puntos.get(b+8).getY(), 40, 40);
//                g2d.fill(r2);
//                g2d.draw(r2);
//                g2d.setColor(Color.BLACK);
//                Ellipse2D r3 = new Ellipse2D.Double(puntos.get(c).getX(), puntos.get(c).getY(), 40, 40);
//                g2d.fill(r3);
//                g2d.draw(r3);
//                g2d.setColor(Color.CYAN);
//                Ellipse2D r4 = new Ellipse2D.Double(puntos.get(d).getX(), puntos.get(d).getY(), 40, 40);
//                g2d.fill(r4);
//                g2d.draw(r4);
//                
            a++;
//                c++;
//                b++;
//                d++;

            this.cambiarTurno();
        } else {

            this.init = false;
        }

        System.out.println(a + " " + b + " " + c + " " + d);

    }

    private int dado() {
        return (int) Math.floor(Math.random() * 5);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = this.getMousePosition().x;
        y = this.getMousePosition().y;
        g2d.setColor(Color.BLUE);
        //  System.out.println(this.getMousePosition().x);

        repaint();
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    class Puntos {

        private int num;
        private int x;
        private int y;

        public Puntos() {

        }

        public Puntos(int num, int x, int y) {
            this.num = num;
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

        @Override
        public String toString() {
            return num + " Puntos(" + x + "," + y + ')';
        }

    }
}
