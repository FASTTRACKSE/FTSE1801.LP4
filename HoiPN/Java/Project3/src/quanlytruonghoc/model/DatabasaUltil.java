package quanlytruonghoc.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;
/**
 * DatabasaUltil Class
 * @author CôngMT
 *
 */
public class DatabasaUltil {
	private static final String URL = "jdbc:mysql://localhost/qltruonghoc";
	private static final String USER = "root";
	private static final String PASS = "";
	/**
	 * Kết nối với Database
	 * @return
	 */
	public static Connection getConnect() {
		Connection conn = null;

		try {
			Properties pro = new Properties();
			pro.setProperty("user", USER);
			pro.setProperty("password", PASS);
			pro.put("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, pro);
			System.out.println(" Bạn đăng nhập thành công!!");
		} catch (SQLException ex) {
			System.out.println("Đăng nhập bị lỗi!!");
		}
		return conn;
	}
	/**
	 *  Đóng kết nối với database
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				System.out.println(" Đóng thành công Database.");
			}
		} catch (SQLException ex) {
			System.out.println("Lỗi đóng kết nối!!!");
		}
	}

}
