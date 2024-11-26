/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentation;

import fabricas.LibrarianFactory;
import fabricas.BookFactory;
import fabricas.UserFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import presentation.panels.PnlBookSearch;
import presentation.panels.PnlBooks;
import presentation.panels.PnlLendBook;
import presentation.panels.PnlReturnBook;
import presentation.panels.PnlUser;

/**
 *
 * @author skevi
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     *
     */
    public FrmMenu() {
        initComponents();
        initConfig();
        loadFactories();
        loadPanel();
    }

    /**
     *
     */
    private void initConfig() {
        this.setLocationRelativeTo(this);
        this.PnlWindow.setLayout(new BorderLayout());
    }

    /**
     *
     */
    private void loadFactories() {
        LibrarianFactory fabrica1 = new LibrarianFactory();
        BookFactory fabrica2 = new BookFactory();
        UserFactory fabrica3 = new UserFactory();
        
        fabrica1.fabricateLibrarians();
        fabrica2.fabricateBooks();
        fabrica3.fabricateUsers();
    }

    /**
     *
     */
    private void loadPanel() {
        
    }

    /**
     *
     * @param path
     * @return
     */
    private ImageIcon createImageIcon(String path, int x, int y,
            String extension) {
        URL imgURL = FrmMenu.class.getResource("/icons/" + path + "."
                + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y,
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: "
                    + path);
            return null;
        }
    }

    /**
     *
     * @param panel
     */
    private void paintPanel(JPanel panel) {
        panel.setSize(730, 420);
        panel.setLocation(0, 0);
        
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
        lblGestionUsuarios = new javax.swing.JLabel();
        lblGestionLibros = new javax.swing.JLabel();
        lblPrestarLibro = new javax.swing.JLabel();
        lblBusquedas = new javax.swing.JLabel();
        lblDevolverLibro = new javax.swing.JLabel();
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
            .addGroup(PnlHeaderLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(lblTitle)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        PnlHeaderLayout.setVerticalGroup(
            PnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        background.add(PnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 730, 70));

        PnlSideBar.setBackground(new java.awt.Color(153, 153, 153));
        PnlSideBar.setForeground(new java.awt.Color(204, 204, 204));

        lblGestionUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        lblGestionUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblGestionUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        lblGestionUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionUsuarios.setText("Gestion usuarios");
        lblGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGestionUsuarios.setOpaque(true);
        lblGestionUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGestionUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGestionUsuariosMouseExited(evt);
            }
        });

        lblGestionLibros.setBackground(new java.awt.Color(153, 153, 153));
        lblGestionLibros.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblGestionLibros.setForeground(new java.awt.Color(0, 0, 0));
        lblGestionLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionLibros.setText("  Gestion libros");
        lblGestionLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGestionLibros.setOpaque(true);
        lblGestionLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionLibrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGestionLibrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGestionLibrosMouseExited(evt);
            }
        });

        lblPrestarLibro.setBackground(new java.awt.Color(153, 153, 153));
        lblPrestarLibro.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPrestarLibro.setForeground(new java.awt.Color(0, 0, 0));
        lblPrestarLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrestarLibro.setText("Prestar libro");
        lblPrestarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPrestarLibro.setOpaque(true);
        lblPrestarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrestarLibroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPrestarLibroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPrestarLibroMouseExited(evt);
            }
        });

        lblBusquedas.setBackground(new java.awt.Color(153, 153, 153));
        lblBusquedas.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblBusquedas.setForeground(new java.awt.Color(0, 0, 0));
        lblBusquedas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBusquedas.setText("Busquedas");
        lblBusquedas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBusquedas.setOpaque(true);
        lblBusquedas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBusquedasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBusquedasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBusquedasMouseExited(evt);
            }
        });

        lblDevolverLibro.setBackground(new java.awt.Color(153, 153, 153));
        lblDevolverLibro.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDevolverLibro.setForeground(new java.awt.Color(0, 0, 0));
        lblDevolverLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDevolverLibro.setText("Devolver libro");
        lblDevolverLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDevolverLibro.setOpaque(true);
        lblDevolverLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDevolverLibroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDevolverLibroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDevolverLibroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PnlSideBarLayout = new javax.swing.GroupLayout(PnlSideBar);
        PnlSideBar.setLayout(PnlSideBarLayout);
        PnlSideBarLayout.setHorizontalGroup(
            PnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPrestarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGestionLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDevolverLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBusquedas, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        PnlSideBarLayout.setVerticalGroup(
            PnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSideBarLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(lblGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGestionLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrestarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDevolverLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        background.add(PnlSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 490));

        PnlWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(PnlWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 730, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblGestionUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionUsuariosMouseEntered
        this.lblGestionUsuarios.setBackground(new Color(45, 44, 34));
        this.lblGestionUsuarios.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblGestionUsuariosMouseEntered

    private void lblGestionUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionUsuariosMouseExited
        this.lblGestionUsuarios.setBackground(new Color(153, 153, 153));
        this.lblGestionUsuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblGestionUsuariosMouseExited

    private void lblGestionLibrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionLibrosMouseEntered
        this.lblGestionLibros.setBackground(new Color(45, 44, 34));
        this.lblGestionLibros.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblGestionLibrosMouseEntered

    private void lblGestionLibrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionLibrosMouseExited
        this.lblGestionLibros.setBackground(new Color(153, 153, 153));
        this.lblGestionLibros.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblGestionLibrosMouseExited

    private void lblPrestarLibroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrestarLibroMouseEntered
        this.lblPrestarLibro.setBackground(new Color(45, 44, 34));
        this.lblPrestarLibro.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblPrestarLibroMouseEntered

    private void lblPrestarLibroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrestarLibroMouseExited
        this.lblPrestarLibro.setBackground(new Color(153, 153, 153));
        this.lblPrestarLibro.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblPrestarLibroMouseExited

    private void lblBusquedasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBusquedasMouseEntered
        this.lblBusquedas.setBackground(new Color(45, 44, 34));
        this.lblBusquedas.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblBusquedasMouseEntered

    private void lblBusquedasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBusquedasMouseExited
        this.lblBusquedas.setBackground(new Color(153, 153, 153));
        this.lblBusquedas.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblBusquedasMouseExited

    private void lblGestionUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionUsuariosMouseClicked
        PnlUser user = new PnlUser();
        
        paintPanel(user); //paint the panel
    }//GEN-LAST:event_lblGestionUsuariosMouseClicked

    private void lblGestionLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionLibrosMouseClicked
        PnlBooks books = new PnlBooks();
        
        paintPanel(books); //paint the panel
    }//GEN-LAST:event_lblGestionLibrosMouseClicked

    private void lblPrestarLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrestarLibroMouseClicked
        PnlLendBook lend = new PnlLendBook();
        
        paintPanel(lend); //paint the panel
    }//GEN-LAST:event_lblPrestarLibroMouseClicked

    private void lblBusquedasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBusquedasMouseClicked
        PnlBookSearch busqueda = new PnlBookSearch();
        
        paintPanel(busqueda);
    }//GEN-LAST:event_lblBusquedasMouseClicked

    private void lblDevolverLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDevolverLibroMouseClicked
        
        PnlReturnBook regresar = new PnlReturnBook();
        
        paintPanel(regresar);
        
    }//GEN-LAST:event_lblDevolverLibroMouseClicked

    private void lblDevolverLibroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDevolverLibroMouseEntered
        this.lblDevolverLibro.setBackground(new Color(45, 44, 34));
        this.lblDevolverLibro.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblDevolverLibroMouseEntered

    private void lblDevolverLibroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDevolverLibroMouseExited
        this.lblDevolverLibro.setBackground(new Color(153, 153, 153));
        this.lblDevolverLibro.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblDevolverLibroMouseExited
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlHeader;
    private javax.swing.JPanel PnlSideBar;
    private javax.swing.JPanel PnlWindow;
    private javax.swing.JPanel background;
    private javax.swing.JLabel lblBusquedas;
    private javax.swing.JLabel lblDevolverLibro;
    private javax.swing.JLabel lblGestionLibros;
    private javax.swing.JLabel lblGestionUsuarios;
    private javax.swing.JLabel lblPrestarLibro;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
