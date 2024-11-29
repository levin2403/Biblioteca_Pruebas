package presentation.panels;

import dao.BookDAO;
import dao.LoanDAO;
import dao.UserDAO;
import daoInterfaces.IBookDAO;
import daoInterfaces.ILoanDAO;
import daoInterfaces.IUserDAO;
import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import facade.LendBookFCD;
import facadeInterfaces.ILendBookFCD;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class PnlLendBook extends javax.swing.JPanel {

    /**
     * Creates new form PnlLendBook
     */
    private static ILendBookFCD lendBookFCD;
    private static ILoanDAO loanDAO;
    private static IBookDAO bookDAO;
    private static IUserDAO userDAO;

    public PnlLendBook() {
        initComponents();

        loanDAO = new LoanDAO();
        bookDAO = new BookDAO();
        userDAO = new UserDAO();

        // Instanciamos la fachada
        lendBookFCD = new LendBookFCD(loanDAO, bookDAO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnPrestar = new javax.swing.JButton();
        txfISBN = new javax.swing.JTextField();
        txfMail = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Prestar Libro");

        btnPrestar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrestar.setText("Prestar");
        btnPrestar.setToolTipText("");
        btnPrestar.setAlignmentX(0.5F);
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        txfISBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfISBN.setText("000-0-000");
        txfISBN.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN"));
        txfISBN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfISBNFocusGained(evt);
            }
        });
        txfISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfISBNActionPerformed(evt);
            }
        });

        txfMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfMail.setText("Email");
        txfMail.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));
        txfMail.setName("Email"); // NOI18N
        txfMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfMailFocusGained(evt);
            }
        });
        txfMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPrestar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfMail, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(txfISBN, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(59, 59, 59)
                .addComponent(txfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnPrestar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        txfMail.getAccessibleContext().setAccessibleName("Email");
    }// </editor-fold>//GEN-END:initComponents

    private void crearPrestamo() throws FacadeException, DAOException {

        Book book = bookDAO.searchByISBN(txfISBN.getText());
        User user = userDAO.getByMail(txfMail.getText());

        bookDAO.addBook(book); // Añadimos el libro
        userDAO.addUser(user); // Añadimos el usuario

        System.out.println(book.toString() + user.toString());

        Loan loan = new Loan(user, book, LocalDate.now().plusDays(10));

        lendBookFCD.lendBook(loan);

    }

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed

        try {
            int option = JOptionPane.showConfirmDialog(
                    null,
                    "¿Esta seguro de querer prestar el libro?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {
                crearPrestamo();
                JOptionPane.showMessageDialog(null, "Libro prestado con exito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(btnPrestar, e, "Error", HEIGHT);

        }

        cleanFields();
    }//GEN-LAST:event_btnPrestarActionPerformed

    private void cleanFields() {
        this.txfISBN.setText("");
        this.txfMail.setText("");
    }
    
    private void txfISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfISBNActionPerformed

    private void txfMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMailActionPerformed

    private void txfISBNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfISBNFocusGained
       txfISBN.setText("");
    }//GEN-LAST:event_txfISBNFocusGained

    private void txfMailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfMailFocusGained
        txfMail.setText("");
    }//GEN-LAST:event_txfMailFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrestar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txfISBN;
    private javax.swing.JTextField txfMail;
    // End of variables declaration//GEN-END:variables
}
