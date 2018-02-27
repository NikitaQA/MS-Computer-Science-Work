package presentation;

import business.*;
import dataaccess.*;
import java.util.HashMap;

public class MainContactForm extends javax.swing.JFrame {
    
    ContactInfoDataFile contactInfoData;
    HashMap<String,ContactInfo>contactInfos;
    ContactInfo newContactInfo = null;
    boolean filling = false;
    ContactInfo currentContact=null;
    
    

    public MainContactForm() {
        initComponents();
        contactInfoData = new ContactInfoDataFile();
        contactInfos = contactInfoData.getContactInfos();
        fillListBox(contactInfos);
    }
    
    public MainContactForm(ContactInfo current) 
    {
        initComponents();
        contactInfoData = new ContactInfoDataFile();
        contactInfos = contactInfoData.getContactInfos();
        
        currentContact=current;
        fillListBox(contactInfos);
    }
    
    public void fillListBox(HashMap<String,ContactInfo> a) {
        filling = true;
        listContactInfo.removeAll(); 
        if(currentContact != null) {
        String listdata[]={currentContact.getName(),currentContact.getAddress(),currentContact.getPh_no()};
        listContactInfo = new javax.swing.JList(listdata); 
        jScrollPane1.setViewportView(listContactInfo);
        }
        else
        {
           String listdata1[]={null};
           listContactInfo = new javax.swing.JList(listdata1); 
          jScrollPane1.setViewportView(listContactInfo);
        }
        /*
        for (HashMap.Entry<String,ContactInfo>entry:a.entrySet())
            
            listContactInfo.add(entry.getKey(),this);
         */   
        filling = false;
    }    

    public void selectContactInfo(ContactInfo cf) {
        listContactInfo.setSelectedValue(cf, filling);
    }
    
    public ContactInfo getCurrentContactInfo() {
        return (ContactInfo) listContactInfo.getSelectedValue();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblSelectName = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listContactInfo = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblSelectName.setText("Current Contact Record");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        listContactInfo.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listContactInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                            .addComponent(lblSelectName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnSearch});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelectName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSearch)
                    .addComponent(btnDelete))
                .addGap(53, 53, 53)
                .addComponent(btnExit)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        ContactDetailsForm cf = new ContactDetailsForm();
        MainContactForm.this.setVisible(false);
        cf.setVisible(true);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        ContactDetailsForm cf = new ContactDetailsForm();
        if(currentContact==null)
        {
            DataValidation dv=new DataValidation();
            dv.showMessage(null,"No Entry Found");
        }else
        {
        contactInfoData.deleteContactInfo(currentContact);                 //for file.
        contactInfos.remove(currentContact.getName());                     //for hashmap.
        DataValidation dv=new DataValidation();
        dv.showMessage(null,"Record Deleted..");
        currentContact=null;
        }
        this.fillListBox(contactInfos);
        this.listContactInfo.requestFocusInWindow();
        
        
       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SearchContact sc = new SearchContact();
        MainContactForm.this.setVisible(false);
        sc.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainContactForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelectName;
    private javax.swing.JList listContactInfo;
    // End of variables declaration//GEN-END:variables
}
