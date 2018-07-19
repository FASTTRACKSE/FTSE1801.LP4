package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Diem;
import entity.SinhVien;

/**
 * Phạm Ngọc Hợi
 * @author Admin
 *
 */

public class SinhVienDAO {
	Connection conn;
	
	/**
	 * Tạo mảng sinh viên.
	 * @return
	 */
	
	public ArrayList<SinhVien> getAllSinhVien(){
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.masv = diem.masv";
		conn = DatabaseUntil.getConnect();
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			SinhVien sinhVien = null;
			Diem diem;
			
			while(result.next()) {
				sinhVien = new SinhVien();
				
				sinhVien.setMaSinhVien(result.getString("masv"));
				sinhVien.setTenSinhVien(result.getString("ten"));
				sinhVien.setPassword(result.getString("pass"));
				
				diem = new Diem();
				diem.setDiem(result.getInt("diem"));
				diem.setMonHoc("monhoc");
				sinhVien.setDiem(diem);
				
				listSV.add(sinhVien);
				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return listSV;
	}
}
