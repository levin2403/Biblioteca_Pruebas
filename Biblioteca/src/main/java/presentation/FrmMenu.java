/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.math.BigDecimal;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author skevi
 */
public class FrmMenu extends javax.swing.JFrame {
    
    public FrmMenu() {
        initComponents();
        loadIcons();
        loadPanel();
    }

    /**
     * 
     */
    private void loadPanel(){
 
    }
    
    
    /**
     * Load the icos on their respective labels 
     */
    private void loadIcons(){
//      this.lblComprar.setIcon(createImageIcon("cart", 30, 30, "png"));
//      this.lblVender.setIcon(createImageIcon("hand", 30, 30, "png"));
//      this.lblHistorial.setIcon(createImageIcon("history", 30, 30, "png"));
//      this.lblApartados.setIcon(createImageIcon("save", 30, 30, "png"));
//      this.lblWizardIcon.setIcon(createImageIcon("mobile-logo", 60, 60, "png"));
//      this.lblMoney.setIcon(createImageIcon("money-bag", 40, 40, "png"));
//      this.lblUser.setIcon(createImageIcon("user", 40, 40, "png"));
    }
    
    /**
     * 
     * @param path
     * @return 
     */
    private ImageIcon createImageIcon(String path, int x, int y, 
            String extension) {
        URL imgURL = FrmMenu.class.getResource("/icons/" + path + "." + 
                extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, 
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + 
                    path);
            return null;
        }
    }
    
    
    private void paintPanel(JPanel panel){
        panel.setSize(860,530);
        panel.setLocation(0,0);
        
        PnlWindow.removeAll();
        PnlWindow.add(panel, BorderLayout.CENTER);
        PnlWindow.revalidate();
        PnlWindow.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        PnlHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        PnlSideBar = new javax.swing.JPanel();
        lblComprar = new javax.swing.JLabel();
        lblVender = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();
        lblApartados = new javax.swing.JLabel();
        lblWizardIcon = new javax.swing.JLabel();
        PnlWindow = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlHeader.setBackground(new java.awt.Color(62, 160, 236));
        PnlHeader.setForeground(new java.awt.Color(62, 160, 236));

        lblTitle.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Biblioteca");
        lblTitle.setToolTipText("");

        javax.swing.GroupLayout PnlHeaderLayout = new javax.swing.GroupLayout(PnlHeader);
        PnlHeader.setLayout(PnlHeaderLayout);
        PnlHeaderLayout.setHorizontalGroup(
            PnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlHeaderLayout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(344, 344, 344))
        );
        PnlHeaderLayout.setVerticalGroup(
            PnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        background.add(PnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 860, 70));

        PnlSideBar.setBackground(new java.awt.Color(153, 153, 153));
        PnlSideBar.setForeground(new java.awt.Color(204, 204, 204));

        lblComprar.setBackground(new java.awt.Color(153, 153, 153));
        lblComprar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblComprar.setForeground(new java.awt.Color(0, 0, 0));
        lblComprar.setText("  Comprar");
        lblComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblComprar.setOpaque(true);
        lblComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblComprarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblComprarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblComprarMouseExited(evt);
            }
        });

        lblVender.setBackground(new java.awt.Color(153, 153, 153));
        lblVender.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblVender.setForeground(new java.awt.Color(0, 0, 0));
        lblVender.setText("  Vender");
        lblVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVender.setOpaque(true);
        lblVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVenderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVenderMouseExited(evt);
            }
        });

        lblHistorial.setBackground(new java.awt.Color(153, 153, 153));
        lblHistorial.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHistorial.setForeground(new java.awt.Color(0, 0, 0));
        lblHistorial.setText("  Historial");
        lblHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHistorial.setOpaque(true);
        lblHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHistorialMouseExited(evt);
            }
        });

        lblApartados.setBackground(new java.awt.Color(153, 153, 153));
        lblApartados.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblApartados.setForeground(new java.awt.Color(0, 0, 0));
        lblApartados.setText("  Apartados");
        lblApartados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblApartados.setOpaque(true);
        lblApartados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblApartadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblApartadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblApartadosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PnlSideBarLayout = new javax.swing.GroupLayout(PnlSideBar);
        PnlSideBar.setLayout(PnlSideBarLayout);
        PnlSideBarLayout.setHorizontalGroup(
            PnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblApartados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnlSideBarLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblWizardIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        PnlSideBarLayout.setVerticalGroup(
            PnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSideBarLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblWizardIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblVender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApartados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        background.add(PnlSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 600));

        PnlWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(PnlWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 860, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblComprarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprarMouseEntered
        this.lblComprar.setBackground(new Color(45, 44, 34));
        this.lblComprar.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblComprarMouseEntered

    private void lblComprarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprarMouseExited
        this.lblComprar.setBackground(new Color(153, 153, 153));
        this.lblComprar.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblComprarMouseExited

    private void lblVenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVenderMouseEntered
        this.lblVender.setBackground(new Color(45, 44, 34));
        this.lblVender.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblVenderMouseEntered

    private void lblVenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVenderMouseExited
        this.lblVender.setBackground(new Color(153, 153, 153));
        this.lblVender.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblVenderMouseExited

    private void lblHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistorialMouseEntered
        this.lblHistorial.setBackground(new Color(45, 44, 34));
        this.lblHistorial.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblHistorialMouseEntered

    private void lblHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistorialMouseExited
        this.lblHistorial.setBackground(new Color(153, 153, 153));
        this.lblHistorial.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblHistorialMouseExited

    private void lblApartadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApartadosMouseEntered
        this.lblApartados.setBackground(new Color(45, 44, 34));
        this.lblApartados.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblApartadosMouseEntered

    private void lblApartadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApartadosMouseExited
        this.lblApartados.setBackground(new Color(153, 153, 153));
        this.lblApartados.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblApartadosMouseExited

    private void lblComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprarMouseClicked
//        PnlBuy comprar = new PnlBuy();
//        
//        paintPanel(comprar); //paint the panel
    }//GEN-LAST:event_lblComprarMouseClicked

    private void lblVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVenderMouseClicked
//        PnlSelling vender = new PnlSelling();
//        
//        paintPanel(vender); //paint the panel
    }//GEN-LAST:event_lblVenderMouseClicked

    private void lblHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistorialMouseClicked
//        PnlRecords historial = new PnlRecords();
//        
//        paintPanel(historial); //paint the panel
    }//GEN-LAST:event_lblHistorialMouseClicked

    private void lblApartadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApartadosMouseClicked
//        PnlSavedSell saved = new PnlSavedSell();
//        
//        paintPanel(saved); 
    }//GEN-LAST:event_lblApartadosMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlHeader;
    private javax.swing.JPanel PnlSideBar;
    private javax.swing.JPanel PnlWindow;
    private javax.swing.JPanel background;
    private javax.swing.JLabel lblApartados;
    private javax.swing.JLabel lblComprar;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVender;
    private javax.swing.JLabel lblWizardIcon;
    // End of variables declaration//GEN-END:variables
}
