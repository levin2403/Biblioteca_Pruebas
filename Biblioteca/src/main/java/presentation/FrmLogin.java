/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentation;

import exceptions.FacadeException;
import fabricas.FabricaBibliotecarios;
import fabricas.FabricaLibros;
import fabricas.FabricaUsuarios;
import facade.LoginFCD;
import java.awt.Color;
import javax.swing.JOptionPane;
import utilities.RoundedBorder;
import FacadeInterfaces.ILogginFCD;


/**
 *
 * @author skevi
 */
public class FrmLogin extends javax.swing.JFrame {
  
    private ILogginFCD librarianFacade;
    
    public FrmLogin() {
        initComponents();
        intialConfig();
        styles();
        loadFactories();
    }
    
    private void loadFactories(){
        FabricaBibliotecarios fabrica1 = new FabricaBibliotecarios();
        FabricaLibros fabrica2 = new FabricaLibros();
        FabricaUsuarios fabrica3 = new FabricaUsuarios();
        
        fabrica1.fabricarBibliotecarios();
        fabrica2.fabricarLibros();
        fabrica3.fabricarUsuarios();
      
    }
    
    private void intialConfig(){
        this.setLocationRelativeTo(this);
        this.librarianFacade = new LoginFCD();
    }
    
    private void styles(){
        
        RoundedBorder border = new RoundedBorder(30);
        RoundedBorder border2 = new RoundedBorder(30);
        
        //redondeamos los text fields
        this.txfCorreo.setOpaque(false);
        this.txfCorreo.setBorder(border);
        
        //redondeamos el campo para la contraseña
        this.psfContrasena.setOpaque(false);
        this.psfContrasena.setBorder(border);
        
        //redondeamos el boton para ingresar
        this.btnIngresar.setContentAreaFilled(false);
        this.btnIngresar.setBorder(border2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        psfContrasena = new javax.swing.JPasswordField();
        chbContrasena = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Inicio de sesion");

        txfCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txfCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCorreoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Correo:");

        psfContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        psfContrasena.setForeground(new java.awt.Color(0, 0, 0));
        psfContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psfContrasenaActionPerformed(evt);
            }
        });

        chbContrasena.setText("Ver");
        chbContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbContrasenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(psfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(chbContrasena)
                        .addGap(21, 21, 21))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try{
            System.out.println(this.txfCorreo.getText());
            
            String mail = this.txfCorreo.getText();
            
            char[] passwordChars = psfContrasena.getPassword();

            
            String password = new String(passwordChars);
            
            System.out.println(password);
            
            if(librarianFacade.loggin(mail, password)){
                FrmMenu menu = new FrmMenu();
                menu.setVisible(true);
                this.dispose();            }
                
        }
        catch(FacadeException fe){
            JOptionPane.showMessageDialog(this, fe.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        this.btnIngresar.setForeground( new Color(0, 178, 12));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        this.btnIngresar.setForeground( Color.BLACK);
    }//GEN-LAST:event_btnIngresarMouseExited

    private void chbContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbContrasenaActionPerformed
        if (chbContrasena.isSelected()) {
            // Mostrar la contraseña en texto plano
            psfContrasena.setEchoChar((char) 0);
        } else {
            // Ocultar la contraseña con un carácter de máscara
            psfContrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_chbContrasenaActionPerformed

    private void txfCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCorreoActionPerformed

    private void psfContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psfContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psfContrasenaActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JCheckBox chbContrasena;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField psfContrasena;
    private javax.swing.JTextField txfCorreo;
    // End of variables declaration//GEN-END:variables
}
