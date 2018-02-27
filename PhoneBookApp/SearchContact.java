package presentation;

import business.*;
import dataaccess.*;
import java.util.HashMap;
import java.util.Iterator;

public class SearchContact extends javax.swing.JFrame {

    ContactInfoDataFile contactInfoData;
    HashMap<String, ContactInfo> contactInfos;
    ContactInfo currentContact=null;

    public SearchContact() {
        initComponents();
        contactInfoData = new ContactInfoDataFile();
        contactInfos = contactInfoData.getContactInfos();        //read values from file and return into hashmap.
    }

    public String getSearchName() {
        return txtSearchName.getText();
    }

    public ContactInfo FirstRecord() {
        Iterator it = contactInfos.entrySet().iterator();
        ContactInfo c = null;
        while (it.hasNext()) {
            HashMap.Entry pairs = (HashMap.Entry) it.next();
            pairs.getKey();
            c = (ContactInfo) pairs.getValue();
            if (c != null) {
                txtSName.setText(c.getName());
                txtSAddress.setText(c.getAddress());
                txtSPhno.setText(c.getPh_no());
            }
            break;
        }
        currentContact=c;
        return currentContact;
        
    }

    public ContactInfo LastRecord() {
        Iterator it = contactInfos.entrySet().iterator();
        ContactInfo c = null;
        HashMap.Entry pairs1 = null;
        while (it.hasNext()) {
            HashMap.Entry pairs = (HashMap.Entry) it.next();
            pairs1 = pairs;
        }
        c = (ContactInfo) pairs1.getValue();
        if (c != null) {
            txtSName.setText(c.getName());
            txtSAddress.setText(c.getAddress());
            txtSPhno.setText(c.getPh_no());
        }
        currentContact=c;
        return currentContact;
    }

    public ContactInfo nextRecord(String name) {
        Iterator it = contactInfos.entrySet().iterator();
        ContactInfo c = null;
        HashMap.Entry pairs1 = null;
        while (it.hasNext()) {
            HashMap.Entry pairs = (HashMap.Entry) it.next();
            pairs1 = pairs;
            if (name.equals(pairs.getKey())) {
                break;
            }
        }
        if (it.hasNext()) {
            HashMap.Entry pairs = (HashMap.Entry) it.next();
            c = (ContactInfo) pairs.getValue();
            if (c != null) {
                txtSName.setText(c.getName());
                txtSAddress.setText(c.getAddress());
                txtSPhno.setText(c.getPh_no());
            }
        }
        if(c==null)
        {
            DataValidation dv=new DataValidation();
            dv.showMessage(null,"This is last record..No more records.");
        }
       currentContact=c;
       return currentContact;

    }

    public ContactInfo previousRecord(String name) {
        Iterator it = contactInfos.entrySet().iterator();
        ContactInfo c = null;
        HashMap.Entry prev = null;
        while (it.hasNext()) {
            HashMap.Entry pairs = (HashMap.Entry) it.next();
            if (name.equals(pairs.getKey())) {
                break;
            }
            prev = pairs;
        }
        if(prev!=null)
        {
        c = (ContactInfo) prev.getValue();
        if (c != null) {
            txtSName.setText(c.getName());
            txtSAddress.setText(c.getAddress());
            txtSPhno.setText(c.getPh_no());
        }  
        }
        if(prev==null)
        {
           DataValidation dv=new DataValidation();
           dv.showMessage(null,"This is First Record..No more Records");
        }
         currentContact=c;
        return currentContact;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearchName = new javax.swing.JLabel();
        txtSearchName = new javax.swing.JTextField();
        lblSName = new javax.swing.JLabel();
        txtSName = new javax.swing.JTextField();
        lblSAddress = new javax.swing.JLabel();
        txtSAddress = new javax.swing.JTextField();
        lblSPhno = new javax.swing.JLabel();
        txtSPhno = new javax.swing.JTextField();
        btnFirstRecord = new javax.swing.JButton();
        btnLastRecord = new javax.swing.JButton();
        btnPreviousRecord = new javax.swing.JButton();
        btnNextRecord = new javax.swing.JButton();
        btnSBack = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSearchName.setText("Enter Name");

        lblSName.setText("Name");

        lblSAddress.setText("Address");

        lblSPhno.setText("Ph_no");

        btnFirstRecord.setText("FirstRecord");
        btnFirstRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstRecordActionPerformed(evt);
            }
        });

        btnLastRecord.setText("LastRecord");
        btnLastRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastRecordActionPerformed(evt);
            }
        });

        btnPreviousRecord.setText("PreviousRecord");
        btnPreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousRecordActionPerformed(evt);
            }
        });

        btnNextRecord.setText("NextRecord");
        btnNextRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextRecordActionPerformed(evt);
            }
        });

        btnSBack.setText("Back");
        btnSBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSBackActionPerformed(evt);
            }
        });

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblSearchName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSPhno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFirstRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNextRecord, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSPhno, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLastRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreviousRecord))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnSBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFirstRecord, btnLastRecord, btnNextRecord, btnPreviousRecord, btnSBack});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSName))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSAddress))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSPhno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSPhno))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirstRecord)
                    .addComponent(btnLastRecord))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextRecord)
                    .addComponent(btnPreviousRecord))
                .addGap(26, 26, 26)
                .addComponent(btnSBack)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblSAddress, lblSName, lblSPhno, lblSearchName});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtSAddress, txtSName, txtSPhno, txtSearchName});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSBackActionPerformed
        MainContactForm mf = new MainContactForm(currentContact);
        SearchContact.this.setVisible(false);
        mf.setVisible(true);
    }//GEN-LAST:event_btnSBackActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        String tmp = this.getSearchName();
        ContactInfo value = contactInfos.get(tmp);
        if (value != null) {
            txtSName.setText(value.getName());
            txtSAddress.setText(value.getAddress());
            txtSPhno.setText(value.getPh_no());
        }
        else
        {
            DataValidation dv=new DataValidation();
           dv.showMessage(null,"Record Not Found.");
        }
        currentContact = value;

    }//GEN-LAST:event_btnOkActionPerformed

    private void btnFirstRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstRecordActionPerformed
        this.FirstRecord();
    }//GEN-LAST:event_btnFirstRecordActionPerformed

    private void btnLastRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastRecordActionPerformed
        this.LastRecord();
    }//GEN-LAST:event_btnLastRecordActionPerformed

    private void btnNextRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextRecordActionPerformed
        this.nextRecord(txtSName.getText());
    }//GEN-LAST:event_btnNextRecordActionPerformed

    private void btnPreviousRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousRecordActionPerformed
        this.previousRecord(txtSName.getText());
    }//GEN-LAST:event_btnPreviousRecordActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchContact().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirstRecord;
    private javax.swing.JButton btnLastRecord;
    private javax.swing.JButton btnNextRecord;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPreviousRecord;
    private javax.swing.JButton btnSBack;
    private javax.swing.JLabel lblSAddress;
    private javax.swing.JLabel lblSName;
    private javax.swing.JLabel lblSPhno;
    private javax.swing.JLabel lblSearchName;
    private javax.swing.JTextField txtSAddress;
    private javax.swing.JTextField txtSName;
    private javax.swing.JTextField txtSPhno;
    private javax.swing.JTextField txtSearchName;
    // End of variables declaration//GEN-END:variables
}
