package quanlysv.moi.modal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;
/**
 * Data base until
 * @author Luan
 *
 */
public class DatabaseUntil {
	private static final String URL = "jdbc:mysql://localhost/sinhvien";
	private static final String USER = "root";
	private static final String PASS = "Luan12345!";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties info = new Properties();
			info.setProperty("user", USER);
			info.setProperty("password", PASS);
			info.put("characterEncoding", "UTF-8");

			Driver diver = new Driver();
			conn = diver.connect(URL, info);
			//System.out.println("ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {

		try {
			if (conn != null)
				conn.close();
			// System.out.println("dong ket noi thanh cong");

		} catch (Exception e) {
			// System.out.println("loi dong ket noi");
		}

	}
	
	
	
}
