
package Menu;
import java.sql.*;
import Connect.Connect;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Penimbangan extends javax.swing.JFrame {
private DefaultTableModel data;
Connection conn;
Statement stm;
ResultSet rs;

    public Penimbangan() {
        initComponents();
        tabel();     
        block();
        Selectbalita();
        kegiatan();
        timbangan();
    }
    
    public void timbangan() {
        try {
        
            String sql = "SELECT * FROM tb_penimbangan ORDER by kode_penimbangan desc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("kode_penimbangan").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

               timbangan.setText("T" + Nol + AN);
            } else {
                timbangan.setText("T0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
    
    private void aktif(boolean x){
    timbangan.setEditable(x);
   }
    
    protected void kosong(){
        timbangan();
        kode.setSelectedIndex(0);
        kodek.setSelectedIndex(0);
        nakeg.setText("");
        nama.setText("");
        bulan.setText("");
        badan.setText("");
        tinggi.setText("");
    }
protected void block(){
    nama.setEnabled(false);
    timbangan.setEnabled(false);
    nakeg.setEnabled(false);
    }

private void Selectbalita(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tb_balita");
            
           kode.addItem("KODE REGIS");
            while(rs.next()){
                kode.addItem(rs.getString("no_registrasi"));
                nama.setText(rs.getString("nama_balita"));
            }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

private void kegiatan(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tb_kegiatan");
            
           kodek.addItem("KODE KEGITANAN");
            while(rs.next()){
                kodek.addItem(rs.getString("kode_kegiatan"));
                nakeg.setText(rs.getString("nama_ibu"));
            }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_refresh = new javax.swing.JButton();
        Keluar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label6 = new java.awt.Label();
        timbangan = new java.awt.TextField();
        bulan = new java.awt.TextField();
        tinggi = new java.awt.TextField();
        badan = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        kode = new javax.swing.JComboBox<>();
        nama = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label8 = new java.awt.Label();
        kodek = new javax.swing.JComboBox<>();
        nakeg = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        label7 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Penimbangan");
        setBackground(new java.awt.Color(153, 255, 255));
        setMinimumSize(new java.awt.Dimension(975, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconView_1.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 30));

        Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit_2.png"))); // NOI18N
        Keluar.setText("Keluar");
        Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarMouseClicked(evt);
            }
        });
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });
        getContentPane().add(Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, 30));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        jPanel1.setToolTipText("");
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setBackground(new java.awt.Color(204, 204, 255));
        label1.setText("Kode Penimbangan");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label2.setBackground(new java.awt.Color(204, 204, 255));
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label2.setText("Bulan");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 47, -1));

        label6.setBackground(new java.awt.Color(204, 204, 255));
        label6.setText("Tinggi Badan");
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, -1));
        jPanel1.add(timbangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 148, -1));
        jPanel1.add(bulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 148, -1));

        tinggi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinggiActionPerformed(evt);
            }
        });
        jPanel1.add(tinggi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 148, -1));

        badan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badanActionPerformed(evt);
            }
        });
        jPanel1.add(badan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 148, -1));

        label3.setBackground(new java.awt.Color(204, 204, 255));
        label3.setText("Berat Badan");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 80, -1));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconSave.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 100, -1));

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconEdit_1.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 100, -1));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconFile_1.png"))); // NOI18N
        btnReset.setText("Batal");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 100, -1));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconDelete_1.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 100, -1));

        kode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kodeItemStateChanged(evt);
            }
        });
        jPanel1.add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 148, -1));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 148, -1));

        label4.setBackground(new java.awt.Color(204, 204, 255));
        label4.setText("Kode Regis");
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        label5.setBackground(new java.awt.Color(204, 204, 255));
        label5.setText("Kode Kegiatan");
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        label8.setBackground(new java.awt.Color(204, 204, 255));
        label8.setText("Nama Balita");
        jPanel1.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        kodek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kodekItemStateChanged(evt);
            }
        });
        jPanel1.add(kodek, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 50, -1));
        jPanel1.add(nakeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 325, 330));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        jPanel2.setOpaque(false);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Penimbangan", "Bulan", "Berat Badan", "Tinggi Badan"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        label7.setBackground(new java.awt.Color(204, 204, 255));
        label7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label7.setText("TABEL PENIMBANGAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 600, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMinimumSize(new java.awt.Dimension(975, 350));
        jLabel1.setPreferredSize(new java.awt.Dimension(975, 350));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
 int bar = tabel.getSelectedRow();
        String a = tabel.getValueAt(bar, 0).toString ();
        String b = tabel.getValueAt(bar, 1).toString ();
        String c = tabel.getValueAt(bar, 2).toString ();
        String d = tabel.getValueAt(bar, 3).toString ();
        String e = tabel.getValueAt(bar, 4).toString ();
          String f = tabel.getValueAt(bar, 5).toString ();
          String g = tabel.getValueAt(bar, 6).toString ();
          String h = tabel.getValueAt(bar, 7).toString ();
          
        timbangan.setText(a);
        kode.setSelectedItem(b);
        kodek.setSelectedItem(c);
        nakeg.setText(d);
        nama.setText(e);
        bulan.setText(f);
        badan.setText(g);
        tinggi.setText(h);
    }//GEN-LAST:event_tabelMouseClicked

    private void badanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badanActionPerformed

    }//GEN-LAST:event_badanActionPerformed

    private void tinggiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinggiActionPerformed
 
    }//GEN-LAST:event_tinggiActionPerformed

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked

    }//GEN-LAST:event_KeluarMouseClicked

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        this.setVisible(false);
        new FormUtama().setVisible(true);
    }//GEN-LAST:event_KeluarActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed

    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
String sql = "insert into tb_penimbangan values (?,?,?,?,?,?,?,?)";
        String reportSource = null;
        String reportDest = null;
        HashMap parameter = new HashMap();
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, timbangan.getText());
            stat.setString(2, kode.getSelectedItem().toString());
            stat.setString(3, kodek.getSelectedItem().toString());
            stat.setString(4, nakeg.getText());
            stat.setString(5, nama.getText());
            stat.setString(6, bulan.getText());
            stat.setString(7, badan.getText());
            stat.setString(8, tinggi.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambah Data Kegiatan");

        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "DATA GAGAL DISIMPAN"+e);

        }
        tabel();
        kosong();
        timbangan.requestFocus();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
try {
            String sql = "UPDATE tb_penimbangan SET kode_penimbangan=?, bulan=?, brt_badan=?, tngg_badan=? WHERE no_regis ='" +kode.getSelectedItem() + "'";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, timbangan.getText());
            stat.setString(2, bulan.getText());
            stat.setString(3, badan.getText());
            stat.setString(4, tinggi.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah");
            tabel();
            kosong();
            timbangan.requestFocus();
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiUbah " + e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
kosong();
        tabel();
   
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
int ok = JOptionPane.showConfirmDialog(null,"Hapus data ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from tb_penimbangan where nama_bayi ='"+nama.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data akan di hapus dari sistem?");
                kosong();
                timbangan.requestFocus();

            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            tabel();
        } 
    }//GEN-LAST:event_btnHapusActionPerformed

    private void kodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kodeItemStateChanged
        String[] kode_ibu = kode.getSelectedItem().toString().split("//s+");
        String kodex = kode_ibu[0];
        if(!kodex.equals("KODE REGIS")){
            try {
                String ibu = "";
                String kobu = kode.getSelectedItem().toString();
                switch(kode.getSelectedIndex()){
                    case 1: ibu = "1"; break;
                    case 2: ibu = "2"; break;
                    case 3: ibu = "3"; break;
                    case 4: ibu = "4"; break;
                    case 5: ibu = "5"; break;
                    case 6: ibu = "6"; break;
                    case 7: ibu = "7"; break;
                    case 8: ibu = "8"; break;
                    case 9: ibu = "9"; break;
                    case 10: ibu = "10"; break;
                    case 11: ibu = "11"; break;
                    case 12: ibu = "12"; break;
                }
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tb_balita WHERE no_registrasi='"+kobu+"'");
                if(rs.next()){
                    nama.setText(rs.getString("nama_balita"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{
        }
    }//GEN-LAST:event_kodeItemStateChanged

    private void kodekItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kodekItemStateChanged
        // TODO add your handling code here:
        String[] kode_ibu = kodek.getSelectedItem().toString().split("//s+");
        String kodex = kode_ibu[0];
        if(!kodex.equals("KODE KEGIATAN")){
            try {
                String ibu = "";
                String kobu = kodek.getSelectedItem().toString();
                switch(kodek.getSelectedIndex()){
                    case 1: ibu = "1"; break;
                    case 2: ibu = "2"; break;
                    case 3: ibu = "3"; break;
                    case 4: ibu = "4"; break;
                    case 5: ibu = "5"; break;
                    case 6: ibu = "6"; break;
                    case 7: ibu = "7"; break;
                    case 8: ibu = "8"; break;
                    case 9: ibu = "9"; break;
                    case 10: ibu = "10"; break;
                    case 11: ibu = "11"; break;
                    case 12: ibu = "12"; break;
                }
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tb_kegiatan WHERE kode_kegiatan='"+kobu+"'");
                if(rs.next()){
                    nakeg.setText(rs.getString("nama_ibu"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{
        }
    }//GEN-LAST:event_kodekItemStateChanged

     public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/posyandu","root","");
            stm=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
    
    public void tabel(){
        Object header[]={"KODE PENIMBANGAN","NO REGIS","KODE KEGIATAN","NAMA IBU","NAMA BALITA","BULAN","BERAT BADAN","TINGGI BADAN"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabel.setModel(data);
        setKoneksi();
        String sql="select*from tb_penimbangan";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString("kode_penimbangan");
                String kolom2=rs.getString("kode_regis");
                String kolom3=rs.getString("kode_kegiatan");
                String kolom4=rs.getString("nama_ibu");
                String kolom5=rs.getString("nama_balita");  
                String kolom6=rs.getString("bulan");
                String kolom7=rs.getString("berat");
                String kolom8=rs.getString("tinggi");
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6,kolom7,kolom8};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penimbangan().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Keluar;
    private javax.swing.JTextField badan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btn_refresh;
    private java.awt.TextField bulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kode;
    private javax.swing.JComboBox<String> kodek;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private javax.swing.JTextField nakeg;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabel;
    private java.awt.TextField timbangan;
    private java.awt.TextField tinggi;
    // End of variables declaration//GEN-END:variables
}
