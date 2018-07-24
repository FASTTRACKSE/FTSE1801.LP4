import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Demo1 {
	private Connection conn = null;

	public Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase+"?characterEncoding=UTF-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("passWord", strPwd);
		try {
			com.mysql.cj.jdbc.Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public void Connection1() {
		Connection conn = getConnect("localhost", "shopbancho", "root", "");
		if (conn != null) {
			System.out.println("Ket noi MySQL thanh cong");
		} else {
			System.out.println("Ket noi that bai!!");
		}
	}

	public void getInfoCustomer() {
		String sql = "SELECT * FROM sanpham WHERE Origin=? AND Name=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "Đức");
			statement.setString(2, "Chó Cỏ");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("Name") + " - " + result.getString("Origin") + " - " + result.getString("Price") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addNewCustomer(int Parent_id, String Name, String Origin, int Price,String Image, Date Created, int View) {
		String sql= "INSERT INTO sanpham() VALUE(?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Parent_id);
			statement.setString(2, Name);
			statement.setString(3, Origin);
			statement.setInt(4, Price);
			statement.setString(5, Image);
			statement.setDate(6, Created);
			statement.setInt(7,View);
			int count= statement.executeUpdate();
			if(count>0){
				System.out.println("Luu thanh cong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update( String Name, String Origin) {
		String sql= "UPDATE sanpham SET Name=?, Origin=? WHERE Parent_id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Name);
			statement.setString(2, Origin);
			statement.setInt(3, 1);
			int count= statement.executeUpdate();
			if(count>0){
				System.out.println("Cap nhap thanh cong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deletelCustumer(int Parent_id) {
		String sql= "DELETE FROM sanpham WHERE Parent_id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Parent_id);
			int count= statement.executeUpdate();
			if(count>0){
				System.out.println("Xoa thanh cong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println(" Da dong thanh cong");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		demo1.Connection1();
		demo1.getInfoCustomer();
//		demo1.addNewCustomer(8, "Chó ngu", "Việt Nam", 1000000,"",  new Date(0), 100);
		demo1.update("Ngáo", "Pháp");
		demo1.deletelCustumer(8);
		demo1.disConnection();
	}
}
