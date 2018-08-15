package quan_ly_thu_vien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import quanlysv.moi.model.DatabaseUntil;

public class quan_ly_thanh_vien {
	Connection conn;

	ArrayList<quan_ly_thanh_vien> getAllquan_ly_thanh_vien() {
		String sql = "SELECT phuong_xa FROM quan_ly_thanh_vien";
		conn = DatabaseUntil.getConnect();
		ArrayList<quan_ly_thanh_vien> list = new ArrayList<quan_ly_thanh_vien>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			
			while (result.next()) {
				
//				list.add(result.getString("Phuong"));
				
			}
		} catch (SQLException e) {
		}
		return list;
	}
	
}