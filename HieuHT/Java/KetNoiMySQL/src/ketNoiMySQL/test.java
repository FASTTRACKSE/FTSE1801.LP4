
package ketNoiMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class test {
	static Connection conn = null;

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?characterEncoding=UTF-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public void getInfoCustomer() {
		String sql = "SELECT*FROM dangNhap WHERE sv_id = ? AND sv_name = ?";
		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(0, sql);
			statement.setString(0, sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + "---" + resultSet.getString("pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
// Thêm thông tin
	public void addNewCustomer(int sv_id, String sv_name, String sv_description, int lop_id) {
		String sql = "INSERT INTO sinhvien VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, sv_id);
			statement.setString(2, sv_name);
			statement.setString(3, sv_description);
			statement.setInt(4, lop_id);
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Thêm vào thành công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

// Cập nhật thông tin	
	public void updateSV(int sv_id, String sv_description) {
		String sql = "UPDATE dangNhap SET sv_description = ? WHERE sv_id = ? ";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sv_description);
			statement.setInt(2, sv_id);
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cập nhật thành công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Connection conn = getConnect("localhost", "test", "root", "");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		test test = new test();
		test.getInfoCustomer();
		 test.addNewCustomer(8, "Mr Phuong", "Nguyen Tuan Phuong", 3);
		test.updateSV(8, "Nguyen Tan Phuong");
	}
}