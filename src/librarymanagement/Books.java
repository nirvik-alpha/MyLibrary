/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lenovo
 */
public class Books extends javax.swing.JFrame {

    /**
     * Creates new form Books
     */
    public Books() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        show_user();
    }

     public ArrayList<User>userList(){
        ArrayList<User>usersList = new ArrayList<>();
        
         try{
            String url = "jdbc:sqlserver://RAFANPC\\SQLEXPR:1433;databaseName=Project";

            String user = "sa";
            String password = "123456789";
            
            Connection connection = DriverManager.getConnection(url,user,password);

    String sql1 =  "SELECT * FROM ADDBOOKS";
    Statement st = connection.createStatement();
    ResultSet rs = st.executeQuery(sql1);
    
    User users;
    
    while(rs.next())
    {
       users= new User(rs.getInt("BookId"),rs.getString("BookName"),rs.getString("Category"),rs.getString("Author"),rs.getString("Publisher"),rs.getString("Contents"),rs.getString("Pages"),rs.getString("Edition"));
       usersList.add(users);
    }
    
  //  JOptionPane.showMessageDialog(null ,"Inserted Successfully");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
        
         return usersList;
        
    }   
     public void show_user()
    {
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)booktable.getModel();
        Object[] row = new Object[8];
        
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBookId();
            row[1] =list.get(i).getBookName();
            row[2]=list.get(i).getCategory();
            row[3]=list.get(i).getAuthor();
            row[4]=list.get(i).getPublisher();
            row[5] =list.get(i).getContents();
            row[6]=list.get(i).getPages();
            row[7]=list.get(i).getEdition();
             model.addRow(row);
        }
    }
     
      public void show_user1()
    {
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)booktable.getModel();
        Object[] row = new Object[8];
        
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBookId();
            row[1] =list.get(i).getBookName();
            row[2]=list.get(i).getCategory();
            row[3]=list.get(i).getAuthor();
            row[4]=list.get(i).getPublisher();
            row[5] =list.get(i).getContents();
            row[6]=list.get(i).getPages();
            row[7]=list.get(i).getEdition();
             
        }
        
        model.addRow(row);
    }
    
    public class CategoryItem
    {
        int id;
        String name;
        
        public CategoryItem(int id ,String name)
        {
            this.id = id;
            this.name= name;
        }
        
        public String toString()
        {
            return name;
        }
    }
    
     public class AuthorItem
    {
        int id;
        String name;
        
        public AuthorItem(int id ,String name)
        {
            this.id = id;
            this.name= name;
        }
        
        public String toString()
        {
            return name;
        }
    }

     
      public class PublisherItem
    {
        int id;
        String name;
        
        public PublisherItem(int id ,String name)
        {
            this.id = id;
            this.name= name;
        }
        
        public String toString()
        {
            return name;
        }
    }

    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {
          try{
            String url = "jdbc:sqlserver://RAFANPC\\SQLEXPR:1433;databaseName=Project";

            String user = "sa";
            String password = "123456789";
            
            con = DriverManager.getConnection(url,user,password);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
    }
    
    
    public void Category()
    {
        try {
            pst = con.prepareStatement("SELECT * FROM CATEGORY");
             rs = pst.executeQuery();
             bookcategory.removeAllItems();
             
             while(rs.next())
             {
                 bookcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     public void Author()
    {
        try {
            pst = con.prepareStatement("SELECT * FROM AUTHOR");
             rs = pst.executeQuery();
             bookauthor.removeAllItems();
             
             while(rs.next())
             {
                 bookauthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)));
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     
      public void Publisher()
    {
        try {
            pst = con.prepareStatement("SELECT * FROM PUBLISHER");
             rs = pst.executeQuery();
             bookpublisher.removeAllItems();
             
             while(rs.next())
             {
                 bookpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookname = new javax.swing.JTextField();
        bookedition = new javax.swing.JTextField();
        bookcategory = new javax.swing.JComboBox();
        bookauthor = new javax.swing.JComboBox();
        bookpublisher = new javax.swing.JComboBox();
        bookcontents = new javax.swing.JTextField();
        bookpages = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        booktable = new javax.swing.JTable();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Books");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Category");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Author");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Publisher");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Contents");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Pages");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Edition");

        bookname.setBackground(new java.awt.Color(0, 51, 102));
        bookname.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookname.setForeground(new java.awt.Color(255, 255, 255));

        bookedition.setBackground(new java.awt.Color(0, 51, 102));
        bookedition.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookedition.setForeground(new java.awt.Color(255, 255, 255));

        bookcategory.setBackground(new java.awt.Color(0, 51, 102));
        bookcategory.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookcategory.setForeground(new java.awt.Color(255, 255, 255));

        bookauthor.setBackground(new java.awt.Color(0, 51, 102));
        bookauthor.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookauthor.setForeground(new java.awt.Color(255, 255, 255));

        bookpublisher.setBackground(new java.awt.Color(0, 51, 102));
        bookpublisher.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookpublisher.setForeground(new java.awt.Color(255, 255, 255));

        bookcontents.setBackground(new java.awt.Color(0, 51, 102));
        bookcontents.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookcontents.setForeground(new java.awt.Color(255, 255, 255));

        bookpages.setBackground(new java.awt.Color(0, 51, 102));
        bookpages.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookpages.setForeground(new java.awt.Color(255, 255, 255));

        booktable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        booktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "BookName", "Category", "Author", "Publisher", "Contents", "Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        booktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booktableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(booktable);

        add.setBackground(new java.awt.Color(0, 0, 51));
        add.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 0, 51));
        update.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookpages, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bookcontents, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bookpublisher, 0, 246, Short.MAX_VALUE)
                                    .addComponent(bookedition)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(90, 90, 90))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(51, 51, 51)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bookcategory, 0, 246, Short.MAX_VALUE)
                                    .addComponent(bookname)))
                            .addComponent(bookauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(bookcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bookname, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bookauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(bookpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(bookcontents, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(bookpages, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bookedition, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
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

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        
             try{
            String url = "jdbc:sqlserver://RAFANPC\\SQLEXPR:1433;databaseName=Project";

            String user = "sa";
            String password = "123456789";
            
            Connection connection = DriverManager.getConnection(url,user,password);

    String sql =  "insert into ADDBOOKS(BookName ,Category,Author,Publisher,Contents,Pages,Edition)values(?,?,?,?,?,?,?)";
    
    PreparedStatement pst = connection.prepareStatement(sql);
    
     pst.setString(1,bookname.getText());
     
      String x = bookcategory.getSelectedItem().toString();
          pst.setString(2,x);
          
          String y = bookauthor.getSelectedItem().toString();
          pst.setString(3,y);
          
          String z = bookpublisher.getSelectedItem().toString();
          pst.setString(4,z);
          
      pst.setString(5,bookcontents.getText());
       pst.setString(6,bookpages.getText());
        pst.setString(7,bookedition.getText());
        
     int k= pst.executeUpdate();
    
        
        if(k==1)
        {
             show_user1();
            JOptionPane.showMessageDialog(null ,"Inserted Successfully");
        }
        

    
    JOptionPane.showMessageDialog(null ,"Inserted Successfully");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
        
        
        
        
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        
        try{
            String url = "jdbc:sqlserver://RAFANPC\\SQLEXPR:1433;databaseName=Project";

            String user = "sa";
            String password = "123456789";
            
            Connection connection = DriverManager.getConnection(url,user,password);

           int row= booktable.getSelectedRow();
   
           String value= (booktable.getModel().getValueAt(row,0).toString());
           String query = "UPDATE ADDBOOKS SET BookName=? ,Category=?, Author=? ,Publisher=? ,Contents=?, Pages=? , Edition=? where BookId="+value;
    
     PreparedStatement pst = connection.prepareStatement(query);
    
     pst.setString(1,bookname.getText());
     
       String x= bookcategory.getSelectedItem().toString();
      pst.setString(2,x);
      
      String y= bookauthor.getSelectedItem().toString();
      pst.setString(3,y);
      
      String z= bookpublisher.getSelectedItem().toString();
      pst.setString(4,z);
     
      
      pst.setString(5,bookcontents.getText());
     pst.setString(6,bookpages.getText());
      pst.setString(7,bookedition.getText());

    
      
     
        pst.executeUpdate();
     
        DefaultTableModel model = (DefaultTableModel)booktable.getModel();
        model.setRowCount(0);
        
        show_user();
          JOptionPane.showMessageDialog(null ,"Updated Successfully");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
        

        
    }//GEN-LAST:event_updateActionPerformed

    private void booktableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booktableMouseClicked
        // TODO add your handling code here:
        
           int i= booktable.getSelectedRow();
        TableModel model = booktable.getModel();
        bookname.setText(model.getValueAt(i,1).toString());
         bookcontents.setText(model.getValueAt(i,5).toString());
          bookpages.setText(model.getValueAt(i,6).toString());
        bookedition.setText(model.getValueAt(i,7).toString());
        
        
    }//GEN-LAST:event_booktableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         try{
            String url = "jdbc:sqlserver://RAFANPC\\SQLEXPR:1433;databaseName=Project";

            String user = "sa";
            String password = "123456789";
            
            Connection connection = DriverManager.getConnection(url,user,password);

           int row= booktable.getSelectedRow();
   
           String value= (booktable.getModel().getValueAt(row,0).toString());
           String query = "DELETE FROM ADDBOOKS where BookId="+value;
           
            PreparedStatement pst = connection.prepareStatement(query);
              pst.executeUpdate();
     
        DefaultTableModel model = (DefaultTableModel)booktable.getModel();
        model.setRowCount(0);
        
        show_user();
        JOptionPane.showMessageDialog(null ,"Deleted Successfully");
            
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         Home obj = new Home();
                obj.setVisible(true);
                dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox bookauthor;
    private javax.swing.JComboBox bookcategory;
    private javax.swing.JTextField bookcontents;
    private javax.swing.JTextField bookedition;
    private javax.swing.JTextField bookname;
    private javax.swing.JTextField bookpages;
    private javax.swing.JComboBox bookpublisher;
    private javax.swing.JTable booktable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
