/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.patolli.vistas;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.patolli.control.ControlCliente;
import mx.patolli.dominio.Jugador;
import mx.patolli.utils.ProtocoloMensaje;
import java.util.List;

/**
 *
 * @author Kevin Rios
 */
public class GuiConfigurarJugador extends Gui {

    private ControlCliente control;

    /**
     * Creates new form GuiConfigurarJugador
     */
    public GuiConfigurarJugador(ControlCliente control) {
        initComponents();
        this.control = control;
        verificarColores();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesColores = new javax.swing.ButtonGroup();
        botonesAvatar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnColorAmarillo = new javax.swing.JRadioButton();
        btnColorAzul = new javax.swing.JRadioButton();
        btnColorRojo = new javax.swing.JRadioButton();
        btnColorVerde = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAvatar04 = new javax.swing.JRadioButton();
        btnAvatar01 = new javax.swing.JRadioButton();
        btnAvatar02 = new javax.swing.JRadioButton();
        btnAvatar03 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configurar Jugador");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAvatar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblAvatar.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatar.setText("Avatar:");
        jPanel1.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 178, 37));

        lblColor.setBackground(new java.awt.Color(0, 0, 0));
        lblColor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblColor.setForeground(new java.awt.Color(255, 255, 255));
        lblColor.setText("Color:");
        jPanel1.add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 178, 37));

        btnContinuar.setBackground(new java.awt.Color(102, 102, 102));
        btnContinuar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 329, 39));
        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 604, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/fichaAmarilla.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/fichaAzul.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/fichaVerde.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/fichaRoja.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        btnColorAmarillo.setBackground(new java.awt.Color(102, 102, 102));
        botonesColores.add(btnColorAmarillo);
        jPanel1.add(btnColorAmarillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        btnColorAzul.setBackground(new java.awt.Color(102, 102, 102));
        botonesColores.add(btnColorAzul);
        jPanel1.add(btnColorAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        btnColorRojo.setBackground(new java.awt.Color(102, 102, 102));
        botonesColores.add(btnColorRojo);
        jPanel1.add(btnColorRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 20, 20));

        btnColorVerde.setBackground(new java.awt.Color(102, 102, 102));
        botonesColores.add(btnColorVerde);
        jPanel1.add(btnColorVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, 20));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/avatar02.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/avatar03.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/avatar04.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/avatar01.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        botonesAvatar.add(btnAvatar04);
        jPanel2.add(btnAvatar04, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        botonesAvatar.add(btnAvatar01);
        jPanel2.add(btnAvatar01, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        botonesAvatar.add(btnAvatar02);
        jPanel2.add(btnAvatar02, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        botonesAvatar.add(btnAvatar03);
        jPanel2.add(btnAvatar03, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 440, 120));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 440, 100));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/patolli/imagenes/tituloPatolli.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 360, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed

        Jugador j = new Jugador();

        if (this.btnColorAmarillo.isSelected()) {
            j.setColor("YELLOW");
        } else if (this.btnColorRojo.isSelected()) {
            j.setColor("RED");
        } else if (this.btnColorVerde.isSelected()) {
            j.setColor("GREEN");
        } else if (this.btnColorAzul.isSelected()) {
            j.setColor("BLUE");
        }
        System.out.println("  ");
        if (this.btnAvatar01.isSelected()) {
            j.setFondo("avatar01");
        } else if (this.btnAvatar02.isSelected()) {
            j.setFondo("avatar02");
        } else if (this.btnAvatar03.isSelected()) {
            j.setFondo("avatar03");
        } else if (this.btnAvatar04.isSelected()) {
            j.setFondo("avatar04");
        }

        this.control.enviar(new ProtocoloMensaje("CONFIGURARJUGADOR", j));

        GuiSala sala = new GuiSala(control);
        sala.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnContinuarActionPerformed

    public void verificarColores() {

        List<Jugador> jugadores = this.control.getPartida().getJugadores();
        if (!jugadores.isEmpty()) {
            jugadores.forEach(e -> {
                if (e.getColor().equals("YELLOW")) {
                    this.btnColorAmarillo.setVisible(false);
                }
                if (e.getColor().equals("BLUE")) {
                    this.btnColorAzul.setVisible(false);
                }
                if (e.getColor().equals("RED")) {
                    this.btnColorRojo.setVisible(false);
                }
                if (e.getColor().equals("GREEN")) {
                    this.btnColorVerde.setVisible(false);
                }
            });

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup botonesAvatar;
    private javax.swing.ButtonGroup botonesColores;
    private javax.swing.JRadioButton btnAvatar01;
    private javax.swing.JRadioButton btnAvatar02;
    private javax.swing.JRadioButton btnAvatar03;
    private javax.swing.JRadioButton btnAvatar04;
    private javax.swing.JRadioButton btnColorAmarillo;
    private javax.swing.JRadioButton btnColorAzul;
    private javax.swing.JRadioButton btnColorRojo;
    private javax.swing.JRadioButton btnColorVerde;
    private javax.swing.JButton btnContinuar;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblColor;
    // End of variables declaration//GEN-END:variables
}
