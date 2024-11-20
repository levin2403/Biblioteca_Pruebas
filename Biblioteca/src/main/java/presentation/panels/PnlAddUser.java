/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentation.panels;

import entityes.User;
import exceptions.FacadeException;
import facade.AddUserFCD;
import facadeInterfaces.IAddUserFCD;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class PnlAddUser extends javax.swing.JPanel {

    /**
     * Object for the facade of add user
     */
    private IAddUserFCD addUserFCD;
    
    /**
     * Creates new form PnlAddUser
     */
    public PnlAddUser() {
        initComponents();
        initialConfig();
    }
    
    /**
     * Initialices the instances of the class;
     */
    private void initialConfig(){
        this.addUserFCD = new AddUserFCD();
    }
    
    /**
     * Cleans the input fields of the frame
     */
    private void cleanFields(){
        this.txfName.setText("");
        this.txfMail.setText("");
        this.psfPassword.setText("");
    }
    
    private User getUser(){
        // Collect the user data from the frame.
        String name = this.txfName.getText();

        String mail = this.txfMail.getText();

        // We collect the password data
        char[] passwordChars = psfPassword.getPassword();
        String password = new String(passwordChars);       

        // Finally we make an instance of the user with the collected data.
        User user = new User(name, mail, password);
        
        return user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        cbxPassword = new javax.swing.JCheckBox();
        psfPassword = new javax.swing.JPasswordField();
        txfName = new javax.swing.JTextField();
        txfMail = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Usuario");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cbxPassword.setText("Ver");
        cbxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPasswordActionPerformed(evt);
            }
        });

        psfPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        psfPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

        txfName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));

        txfMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfMail.setBorder(javax.swing.BorderFactory.createTitledBorder("Correo"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(266, 266, 266))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(psfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(txfName)
                    .addComponent(txfMail))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxPassword)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPassword))
                .addGap(72, 72, 72))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try{    
            // Finally we make an instance of the user with the collected data.
            User user = getUser();
            
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer registrar al usuario?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                // Call the the add method from the facade and put the user 
                // object in the parameter.
                this.addUserFCD.addUser(user);

                // After adding the user succesfuly clean the fileds 
                cleanFields();
                
                //show succes message
                JOptionPane.showMessageDialog(null, "Usuario agregado con "
                        + "exito");
            }
  
        }catch(FacadeException fe){
            JOptionPane.showMessageDialog(this, fe.getMessage(), 
                    "Error al agregar el usuario", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPasswordActionPerformed
        if (cbxPassword.isSelected()) {
            // Mostrar la contraseña en texto plano
            psfPassword.setEchoChar((char) 0);
        } else {
            // Ocultar la contraseña con un carácter de máscara
            psfPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cbxPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JCheckBox cbxPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField psfPassword;
    private javax.swing.JTextField txfMail;
    private javax.swing.JTextField txfName;
    // End of variables declaration//GEN-END:variables
}
