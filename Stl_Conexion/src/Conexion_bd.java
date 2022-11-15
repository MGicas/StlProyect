import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion_bd {
	
	/*public static String driver = "com.mysql.jdbc.driver";
	public static String user = "root";
	public static String pasword = "admin";
	public static String url ="jdbc:msql://localhost:3306/bd_conexionstl";
	
	static {
		try {
			Class.forName(driver);
			JOptionPane.showMessageDialog(null, "Driver conectado");
		}catch (ClassNotFoundException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Driver no conectado");
		}
	}
	
	Connection con = null;
	
	public Connection getConnection() {
		try {
			con= DriverManager.getConnection("jdbc:msql//localhost:3306/bd_stocktakingload", "root", "admin");
			JOptionPane.showMessageDialog(null, "Conexion a MySQL correcta");
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error conexion");
		}
		return con;
	}
	
	public Connection close() {
		try {
			con.close();
			JOptionPane.showMessageDialog(null, "Conexion cerrada");
		} catch (SQLException exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en cerrar conexion");
		}
		return con;
	}
	
	public static void main(String[] args) {
		Conexion_bd bd= new Conexion_bd();
		
	}
*/
}
