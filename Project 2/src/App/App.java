package App;

import Com.Config.KoneksiDatabase;
import Com.Config.MyConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class App extends javax.swing.JFrame {
    
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private DefaultTableModel model;

    public void clear(){
        tfNama.setText("");
        tfHarga.setText("");
        tfJumlah.setText("");
        tfNama.requestFocus();
    }
    
    public void insertData(){
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getRowCount();
        model.addRow(new Object[]{
            row += 1,
            tfNama.getText(),
            tfHarga.getText(),
            tfJumlah.getText()
        });
    }
    
    public double hitungTotal(){
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int rowCount = model.getRowCount();
        double total = 0.0;
  
        for(int i = 0; i < rowCount; i++){
            double harga = Double.parseDouble(model.getValueAt(i, 2).toString());
            int jumlah = Integer.parseInt(model.getValueAt(i, 3).toString());
            total += harga*jumlah;
        }
        return total;
    }
    
    public void Show(){
        MyConfig connect = new MyConfig();
        try{
            Con = connect.getConnect();
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM chizu_shop");
            int i = 1;
            while(Rs.next()){
                String[] row = {Integer.toString(i), Rs.getString(2), Rs.getString(3), Rs.getString(4)};
                model.addRow(row);
                i++;
            }
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    public App() {
        initComponents();
        String [] header = {"ID", "NAMA", "HARGA", "JUMLAH"};
        model = new DefaultTableModel (header,0);
        tabel.setModel(model);
        Show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelJumlah = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        tfJumlah = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelTotal = new javax.swing.JLabel();
        labelTunai = new javax.swing.JLabel();
        labelKembali = new javax.swing.JLabel();
        tfKembali = new javax.swing.JTextField();
        tfTunai = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(96, 150, 180));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chizu Store");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        labelNama.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelNama.setForeground(new java.awt.Color(14, 41, 84));
        labelNama.setText("Nama");

        labelHarga.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelHarga.setForeground(new java.awt.Color(14, 41, 84));
        labelHarga.setText("Harga");

        labelJumlah.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelJumlah.setForeground(new java.awt.Color(14, 41, 84));
        labelJumlah.setText("Jumlah");

        tfNama.setBackground(new java.awt.Color(96, 150, 180));
        tfNama.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tfNama.setForeground(new java.awt.Color(255, 255, 255));

        tfHarga.setBackground(new java.awt.Color(96, 150, 180));
        tfHarga.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tfHarga.setForeground(new java.awt.Color(255, 255, 255));

        tfJumlah.setBackground(new java.awt.Color(96, 150, 180));
        tfJumlah.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tfJumlah.setForeground(new java.awt.Color(255, 255, 255));
        tfJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJumlahActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(31, 110, 140));
        btnTambah.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.setBorderPainted(false);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(46, 138, 153));
        btnEdit.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(31, 110, 140));
        btnDelete.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(46, 138, 153));
        btnClear.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(194, 222, 220));

        labelTotal.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(14, 41, 84));
        labelTotal.setText("Total");

        labelTunai.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelTunai.setForeground(new java.awt.Color(14, 41, 84));
        labelTunai.setText("Tunai");

        labelKembali.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelKembali.setForeground(new java.awt.Color(14, 41, 84));
        labelKembali.setText("Kembali");

        tfKembali.setBackground(new java.awt.Color(96, 150, 180));
        tfKembali.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tfKembali.setForeground(new java.awt.Color(255, 255, 255));
        tfKembali.setText("Rp.");

        tfTunai.setBackground(new java.awt.Color(96, 150, 180));
        tfTunai.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tfTunai.setForeground(new java.awt.Color(255, 255, 255));

        tfTotal.setBackground(new java.awt.Color(96, 150, 180));
        tfTotal.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tfTotal.setForeground(new java.awt.Color(255, 255, 255));
        tfTotal.setText("Rp.");
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        btnHitung.setBackground(new java.awt.Color(46, 138, 153));
        btnHitung.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setText("Hitung");
        btnHitung.setBorderPainted(false);
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(31, 110, 140));
        btnBayar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar");
        btnBayar.setBorderPainted(false);
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(46, 138, 153));
        btnSimpan.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorderPainted(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelKembali)
                    .addComponent(labelTunai)
                    .addComponent(labelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTotal)
                    .addComponent(tfTunai)
                    .addComponent(tfKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnHitung)
                .addGap(18, 18, 18)
                .addComponent(btnBayar)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTunai)
                    .addComponent(tfTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKembali)
                    .addComponent(tfKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnBayar)
                    .addComponent(btnSimpan))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "HARGA", "JUMLAH"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(14, 41, 84));
        jLabel8.setText("TABEL BARANG");

        jPanel3.setBackground(new java.awt.Color(96, 150, 180));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNama, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelHarga, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(labelJumlah))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                .addComponent(tfNama))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel8)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHarga))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelJumlah)
                            .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete)
                            .addComponent(btnClear))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJumlahActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if(tfNama.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Barang Belum di Masukan");
        }else if(tfHarga.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Barang Belum di Masukan");
        }else if(tfJumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah Barang Belum di Masukan");
        }else{
            insertData();
            clear();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int rowSelect = tabel.getSelectedRow();
        
        if(btnEdit.getText()=="Edit"){
            btnTambah.setEnabled(false);
            btnDelete.setEnabled(false);
            btnEdit.setText("Update");
            tfNama.setText(model.getValueAt(rowSelect, 1).toString());
            tfHarga.setText(model.getValueAt(rowSelect, 2).toString());
            tfJumlah.setText(model.getValueAt(rowSelect, 3).toString());
        }else {
            btnTambah.setEnabled(true);
            btnDelete.setEnabled(true);
            btnEdit.setText("Edit");
            
            String namabarang = tfNama.getText();
            String hargabarang = tfHarga.getText();
            String jumlahbarang = tfJumlah.getText();
            
            model.setValueAt(namabarang, rowSelect, 1);
            model.setValueAt(hargabarang, rowSelect, 2);
            model.setValueAt(jumlahbarang, rowSelect, 3);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int rowSelect = tabel.getSelectedRow();
        
        if(rowSelect == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini?", 
                  "Konfirmasi Pengahapusan Data",JOptionPane.YES_NO_OPTION);
          if(confirm == JOptionPane.YES_OPTION){
              model.removeRow(rowSelect);
          }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        double total = hitungTotal();
        tfTotal.setText("Rp." + String.valueOf(total));
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        try {
            String totalText = tfTotal.getText().substring(3);
            double total = Double.parseDouble(totalText);
            double bayar = Double.parseDouble(tfTunai.getText());
            double kembali = bayar - total;
            tfKembali.setText("Rp." + String.valueOf(kembali));
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Input tidak Valid");
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
         try{
           Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt_produk","root","");
           
           int rowCount = tabel.getRowCount();
           for(int i = 0; i < rowCount; i++){
               String Column1 = tabel.getValueAt(i, 1).toString();
               String Column2 = tabel.getValueAt(i, 2).toString();
               String Column3 = tabel.getValueAt(i, 3).toString();
               
               String sql = "INSERT INTO chizu_shop (NAMA, HARGA, JUMLAH) VALUES (?,?,?)";
               PreparedStatement statement = Con.prepareStatement(sql);
               
               statement.setString(1, Column1);
               statement.setString(2, Column2);
               statement.setString(3, Column3);
               
               statement.executeUpdate();
           }   
           
           JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database.");
           Con.close();
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data ke database.");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelJumlah;
    private javax.swing.JLabel labelKembali;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTunai;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfKembali;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTunai;
    // End of variables declaration//GEN-END:variables
}
