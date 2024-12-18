/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentation;

import dao.BookDAO;
import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import fabricas.FacadeFactory;
import facade.UpdateBookFCD;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skevi
 */
public class FrmUpdateBook extends javax.swing.JFrame {

    /**
     * 
     */
    IBookDAO bookDAO;
 
    /**
     * 
     */
    UpdateBookFCD updateBook;
    
    /**
     * 
     */
    Book book;
    
    /**
     * Creates new form FrmUpdateBook
     */
    public FrmUpdateBook() {
        initComponents();
        initialConfig();
        loadTable();
    }
    
    /**
     * 
     */
    private void initialConfig(){
        this.setLocationRelativeTo(this);
        this.bookDAO = new BookDAO();
        this.updateBook = FacadeFactory.fabricateUpdateBookFCD();
    }

    /**
     * 
     */
    private void loadTable(){
        String[] columns = {"ISBN", "Titulo", "Autor", "Estado", "Valorado"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        try{
            List<Book> books = bookDAO.getBooks();
            
            for (Book book : books) {
                Object[] object = {
                    book.getIsbn(),
                    book.getTitulo(),
                    book.getAutor(),
                    (book.isPrestado() == false) ? "Disponible" : "Prestado",
                    (book.getValoration() == null) ? "NO" : "SI"  
                };
                tableModel.addRow(object);
            }
            
            this.tblBooks.setModel(tableModel);
            
        }catch(DAOException de){
            JOptionPane.showMessageDialog(this, 
                    "Error al cargar los libros: " + 
                    de.getMessage(),
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * 
     */
    private Book getSelectedBook() throws Exception{
        try{
        int selectedRow = tblBooks.getSelectedRow();
        
        if (selectedRow == -1) {
            throw new Exception("Debe seleccionar almenos una columna antes "
                    + "de continuar");
        }
        
        String isbn = (String)this.tblBooks.getValueAt(selectedRow, 0);
        
        Book book = bookDAO.searchByISBN(isbn);
        
        this.book = book;
        
        return book;
        
        }catch(DAOException de){
            JOptionPane.showMessageDialog(this,  
                    de.getMessage(),
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    /**
     * Cleans the input fields of the frame
     */
    private void cleanFields(){
        this.txfTitle.setText("");
        this.txfAuthor.setText("");
    }
    
    /**
     * 
     * @return      
     */
    public Book getUpdatedBookData(){
        String isbn = this.book.getIsbn();
            
        String title = this.txfTitle.getText();

        String author = this.txfAuthor.getText();

        Boolean prestado = this.book.isPrestado();

        Book book = new Book(isbn, title, author, prestado);
        
        return book;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        txfAuthor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txfTitle = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBooks);

        txfAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder("Autor"));
        txfAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfAuthorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setText("Actualizar libro");

        txfTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfTitle.setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo"));
        txfTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTitleActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Selecciona un libro");

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txfAuthor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(146, 146, 146))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65)
                        .addComponent(txfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txfAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfAuthorActionPerformed

    private void txfTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTitleActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try{
            
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer eliminar el libro?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                //get the updated data from the fields
                Book book = getUpdatedBookData();
            
                //send the book to the facade for update
                this.updateBook.UpdateBook(book);

                //loads the table again to show the updated data.
                loadTable();
                
                //shows a succes message
                JOptionPane.showMessageDialog(null, "Exito al actualizar "
                        + "el libro");
            }
 
        }
        catch(FacadeException fe){
            
            loadTable();
            
            JOptionPane.showMessageDialog(this,  
                    fe.getMessage(),
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBooksMouseClicked
        try{
            Book book = getSelectedBook();
            this.txfTitle.setText(book.getTitulo());
            this.txfAuthor.setText(book.getAutor());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this,  
                    ex.getMessage(),
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblBooksMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txfAuthor;
    private javax.swing.JTextField txfTitle;
    // End of variables declaration//GEN-END:variables
}
