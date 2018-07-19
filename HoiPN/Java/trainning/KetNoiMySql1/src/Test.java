import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Test {
	private static Connection conn = null;

	// Kết nối database
	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?characterEncoding=UTF-8";
		Properties properties = new Properties();
		properties.put("user", strUser);
		properties.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = driver.connect(strConnect, properties);
			System.out.println("Kết nối MYSQL thành công");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Truy vấn database

	public void selectdb() {
		try {
			String sql = "select * from sinhvien where lop_id=2";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("sv_name") + " " + result.getString("sv_description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectdbCach2(String sv_name,String sv_description) {
		String sql = "select * from sinhvien where sv_name = ? AND sv_description = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sv_name);
			statement.setString(2, sv_description);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("sv_name") + " " + result.getString("sv_description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// insert

//	public void insertDataBase(int sv_id,String sv_name,String sv_description,int lop_id) {
//		try {
//			String sql = "insert into sinhvien values(?,?,?,?)";
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setInt(1,sv_id);
//			statement.setString(2, sv_name);
//			statement.setString(3, sv_description);
//			statement.setInt(4,lop_id);
//			int x = statement.executeUpdate();
//			if (x > 0) {
//				System.out.println("Lưu OK");
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
	
//	//Delete
//	
//	public void deleteDataBase(int sv_id) {
//		String sql = "DELETE FROM `sinhvien` WHERE `sv_id`=?";
//		PreparedStatement statement;
//		try {
//			statement = conn.prepareStatement(sql);
//			statement.setInt(1,sv_id);
//			int x= statement.executeUpdate();
//			if(x<0) {
//				System.out.println("Xóa OK");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public void update(String sv_name,String sv_description,int lop_id) {
		try {
			String sql = "UPDATE `sinhvien` SET `sv_name`=?,`sv_description`=?,`lop_id`=? WHERE `sv_id` = 1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sv_name);
			statement.setString(2, sv_description);
			statement.setInt(3,lop_id);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Update OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// Đóng database
	public void disConnect() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("dong thanh cong");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void chechConnect() {
		
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.getConnect("localhost", "qlsv", "root", "");
		test.selectdb();
		test.selectdbCach2("Mr Cuong", "Nguyen Van Cuong");
//		test.insertDataBase(8,"Mr Hợi","Phạm Ngọc Hợi",3);
//		test.deleteDataBase(7);
		test.update("Mr OK","Ô Con Kê",2);
		test.disConnect();
	}
}
