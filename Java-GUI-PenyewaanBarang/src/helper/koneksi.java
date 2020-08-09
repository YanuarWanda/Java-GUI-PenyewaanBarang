package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/db10118228PenyewaanBarang";
    private static final String user = "root";
    private static final String pass = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
        }
        
        return conn;
    }
    
    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
