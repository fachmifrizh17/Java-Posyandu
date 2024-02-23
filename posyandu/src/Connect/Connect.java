package Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Connect {
    
    public static Connection getConnection(){
        Connection connect = null;
        try {
            String url = "jdbc:mysql://localhost/posyandu";
            String name = "root";
            String password = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, name, password);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, Periksa Sambungan"+e.getMessage());
        }
        return connect;
    }
    
        
}
