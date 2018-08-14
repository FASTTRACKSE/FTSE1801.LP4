package ketNoiMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class QuanLySV {
	static Connection conn = null;

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://127.0.0.1/" + strDatabase + "?characterEncoding=UTF-8";
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

	public void addNewSinhVien( String MASV, String TEN, String PASS) {
		String sql = "INSERT INTO sinh_vien(MASV, TEN, PASS) VALUES (?, ?, ?) "	;

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, MASV);
			statement.setString(2, TEN);
			statement.setString(3, PASS);

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Thêm vào thành công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewDiemSV( String MASV, String MONHOC, int DIEM) {
		String sql = "INSERT INTO diem(MASV, MONHOC, DIEM) VALUES (?, ?, ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, MASV);
			statement.setString(2, MONHOC);
			statement.setInt(3, DIEM);

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Thêm vào thành công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		conn = getConnect("localhost", "diem_sinhvien_1", "root", "");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		QuanLySV quanLySV = new QuanLySV();
//		quanLySV.addNewSinhVien("1", "Ho Tan Hieu", "ftse1801");
//		quanLySV.addNewSinhVien("2","Nguyen Tuan Phuong", "ftse1801");
//		quanLySV.addNewSinhVien("3", "Huynh Khanh Hung", "ftse1801");
		quanLySV.addNewSinhVien("4", "Nguyễn Đình Khải", "ftse1801");
		
//		quanLySV.addNewDiemSV("1", "LP3", 8);
//		quanLySV.addNewDiemSV("2", "LP3", 7);
//		quanLySV.addNewDiemSV("3", "LP3", 9);
	}
}