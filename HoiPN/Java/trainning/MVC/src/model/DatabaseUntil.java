package model;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

	/**
	 * Phạm Ngọc Hợi
	 * @author Admin
	 *
	 */

public class DatabaseUntil {
	private static final String URL = "jdbc:mysql://localhost/diem_sinhvien";
	private static final String USER = "root";
	private static final String PASS = "";
	
	/**
	 * Truy cập database.
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
			conn = driver.connect(URL,pro);
			
		} catch (Exception e) {
			System.out.println("Loi ket noi database.");
		}
		return conn;
	}
	
	/**
	 * Đóng kết nối database.
	 * @param conn
	 */
	
	public static void disConnect(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("Loi dong ket noi database.");
		}
	}
}
