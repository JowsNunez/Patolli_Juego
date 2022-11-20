/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.patolli.vistas;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author el_fr
 */
public abstract class Gui extends JFrame {

    public Gui() {
         
        super();
        this.setLookAndFeel();
    }

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
