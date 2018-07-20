package quanlysv.moi.model;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUltil {
	private static final String URL = "jdbc:mysql://localhost/sinhvien";
	private static final String USER = "root";
	private static final String PASS = "";

	public static Connection getConnect() {
		Connection conn = null;
		try {
			Properties info = new Properties();
			info.setProperty("user", USER);
			info.setProperty("password", PASS);
			info.setProperty("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, info);

		} catch (Exception e) {
			System.out.println("loi ket noi database");
			e.printStackTrace();
		}
		return conn;

	}

	public static void closeConnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("loi dong ket noi database");
		}
	}
}
