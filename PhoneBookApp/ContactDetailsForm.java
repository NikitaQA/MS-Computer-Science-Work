package presentation;
import javax.swing.JTextField;
import java.util.HashMap;
import business.ContactInfo;
import dataaccess.*;


public class ContactDetailsForm extends javax.swing.JFrame {
    
    ContactInfoDataFile contactInfoData;
    HashMap<String,ContactInfo>contactInfos;
    ContactInfo newContactInfo = null;
    boolean filling = false;
    ContactInfo currentContact=null;
    

    public ContactDetailsForm() {
        initComponents();
        contactInfoData = new ContactInfoDataFile();
        contactInfos = contactInfoData.getContactInfos();
        newContactInfo = new ContactInfo();
        
    }
    
    public ContactInfo getContactInfo() {
        ContactInfo cf = new ContactInfo();
        cf.setName(txtName.getText());
        cf.setAddress(txtAddress.getText());
        cf.setPh_no(txtPhno.getText());
        return cf;
    }
    
    public void showContactInfo(ContactInfo cf) {
        txtName.setText(cf.getName());
        txtAddress.setText(cf.getAddress());
        txtPhno.setText(cf.getPh_no());
    }
    
        
    
    private boolean isValidData() {
        DataValidation dv = new DataValidation();
        if (newContactInfo != null)
            return 
                dv.isPresent(this.txtName, "Name") && 
                dv.isPresent(this.txtAddress, "Address") && 
                dv.isPresent(this.txtPhno, "Ph_No") ;
                    
        else
            return 
                dv.isPresent(this.txtAddress, "Address") && 
                dv.isPresent(this.txtPhno, "Ph_No") && 
                dv.isPresent(this.txtPhno, "Ph_No");
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhno = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhno = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setText("NAME");

        lblAddress.setText("ADDRESS");

        lblPhno.setText("PH_NO.");

        btnAccept.setText("ACCEPT");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPhno)
                        .addComponent(lblAddress)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtAddress)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(txtPhno))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAddress, lblName, lblPhno});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhno)
                    .addComponent(txtPhno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept)
                    .addComponent(btnBack))
                .addGap(19, 19, 19))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblAddress, lblName, lblPhno});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed

    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        MainContactForm mf = new MainContactForm();
        ContactDetailsForm.this.setVisible(false);
        mf.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed


    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        MainContactForm mf;
        if (isValidData()) {
            if (newContactInfo != null) {
                newContactInfo = this.getContactInfo();
                contactInfoData.addContactInfo(newContactInfo);
                contactInfos.put(newContactInfo.getName(),newContactInfo);
                DataValidation dv=new DataValidation();
                dv.showMessage(null,"Record Added..");
                currentContact=newContactInfo;
                mf=new MainContactForm(currentContact);
                mf.fillListBox(contactInfos);
                mf.selectContactInfo(newContactInfo);
                newContactInfo = null;
            } else {
                mf=new MainContactForm();
                ContactInfo cff = mf.getCurrentContactInfo();
                ContactInfo cf = this.getContactInfo();
                cff.setAddress(cf.getAddress());
                cff.setPh_no(cf.getPh_no());
                mf.fillListBox(contactInfos);
                mf.selectContactInfo(cff);
                this.showContactInfo(mf.getCurrentContactInfo());
            }
        }else{
             mf=new MainContactForm();
        }
        this.setVisible(false);
        mf.setVisible(true);

    }//GEN-LAST:event_btnAcceptActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactDetailsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhno;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhno;
    // End of variables declaration//GEN-END:variables
}
