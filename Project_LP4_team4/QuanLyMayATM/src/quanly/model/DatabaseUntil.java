package quanly.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUntil {
	private static final String URL = "jdbc:mysql://localhost/quan_ly_may_atm";
	private static final String USER = "root";
	private static final String PASS = "manh100997";

	/**
	 * 
	 * Kết nối Database
	 * @return
	 */
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Properties pro = new Properties();
			pro.setProperty("user", USER);
			pro.setProperty("password", PASS);
			pro.setProperty("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, pro);
		} catch (SQLException ex) {
			System.out.println("Ket noi that bai!");
		}
		return conn;
	}

	/**
	 * Đóng kết nối Databases
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("loi dong ket loi");
		}
	}
}
