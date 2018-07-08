import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Demo {
	private static Connection conn = null;
	
	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect ="jdbc:mysql://" + strServer + "/" + strDatabase + "?characterEncoding=UTF-8";
		Properties properties = new Properties();
		properties.put("user", strUser);
		properties.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = driver.connect(strConnect, properties);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void login(String id,String pass) {
		String sql = "select * from user1 where id = ? AND pass = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, pass);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println("Dang nhap thanh cong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disConnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.getConnect("localhost", "test", "root", "");
		demo.login("Olala", "123456789");
		demo.disConnect();
	}
}