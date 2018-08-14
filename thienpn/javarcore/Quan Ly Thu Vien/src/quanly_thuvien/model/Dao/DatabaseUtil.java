package quanly_thuvien.model.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;
 
/**
 * Phạm Ngọc Thiên 1801014
 * @author TGDD
 *
 */

public class DatabaseUtil {
	private static final String URL = "jdbc:mysql://localhost/baiduan";
	private static final String USER = "root";
	private static final String PASS = "";
    /**
     * Kết nối Database
     * @return
     */
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Properties info = new Properties();
			info.setProperty("user", USER);
			info.setProperty("password", PASS);
			info.put("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, info);
			System.out.println("kết nối MYSQL thành công");
		} catch (SQLException e) {
			System.out.println("kết nối SQL thất bại");
		}
		return conn;
	}

	public static void disConnect(Connection conn) {
		try {
			conn.close();
			System.out.println("Đóng kết nối MYSQL  thành công");

		} catch (SQLException e) {
			System.out.println("lỗi đóng kết nối MYSQL");
		}
	}
	
}
