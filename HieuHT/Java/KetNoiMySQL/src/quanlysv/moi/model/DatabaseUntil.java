package quanlysv.moi.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUntil {
	private static final String URL = "jdbc:mysql://localhost/dssv";
	private static final String USER = "root";
	private static final String PASS = "";

	public static Connection getConnect() {
		Connection conn = null;
		try {
			Properties info = new Properties();
			info.setProperty("user", USER);
			info.setProperty("password", PASS);
			info.setProperty("characterEncoding", "UTF-8");

			Driver drive = new Driver();
			conn = drive.connect(URL, info);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Ket thuc");
			}
		} catch (SQLException e) {
			System.out.println("Ket noi that bai");
		}
	}
}