package quanlytiendien.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

/**
 * Kết nối với database
 * 
 * @author SonVD and HungHK
 *
 */
public class DatabaseUltil {
	private static final String URL = "jdbc:mysql://localhost/quan_ly_tien_dien";
	private static final String USER = "root";
	private static final String PASS = "";

	/**
	 * Kết nối với database
	 * 
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties properties = new Properties();
			properties.setProperty("user", USER);
			properties.setProperty("pass", PASS);
			properties.setProperty("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, properties);
			System.out.println("Kết nối MYSQL thành công.");
		} catch (SQLException e) {
			System.out.println("Kết nối MYSQL thất bại.");
		}
		return conn;
	}

	/**
	 * Đóng kết nối với database
	 * 
	 * @param conn
	 */
	public static void disConnection(Connection conn) {
		try {
			conn.close();
			System.out.println("Đóng kết nối MYSQL thành công.");
		} catch (SQLException e) {
			System.out.println("Lỗi đóng MYSQL.");
		}
	}
}
