package quanlysv.moi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlysv.moi.model.entity.Diem;
import quanlysv.moi.model.entity.SinhVien;

public class SinhVienDAO {
	Connection conn;
	
	public boolean addSinhVien(SinhVien sinhVien) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `sinh_vien`(`MASV`, `TEN`,  `TUOI`) VALUES(?, ?, ?)";
		conn = DatabaseUntil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getTenSinhVien());
			statement.setInt(3, sinhVien.getTuoi());
			
			if(statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUntil.closeConnect(conn);
		return statusExecute;
	}

	/*
	 * Hiển thị sinh viên
	 */
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT MASV,TEN,TUOI FROM sinh_vien";
		conn = DatabaseUntil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			SinhVien sinhVien;
			Diem diem;
			while (result.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSinhVien(result.getString("MASV"));
				sinhVien.setTenSinhVien(result.getString("TEN"));
				sinhVien.setTuoi(result.getInt("TUOI"));

//				diem = new Diem();
//				diem.setDiem(result.getInt("DIEM"));
//				diem.setMonhoc(result.getString("MONHOC"));
//				sinhVien.setDiem(diem);
				
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUntil.closeConnect(conn);
		return list;
	}

	/*
	 * Thêm điểm cho sinh viên
	 */
	public boolean addDiemSinhVien(SinhVien sinhVien) {
		boolean statusExecute = false;
		String sql = "INSERT INTO diem(MASV, MONHOC, DIEM) VALUES (?,?,?)";
		conn = DatabaseUntil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getDiem().getMonhoc());
			statement.setInt(3, sinhVien.getDiem().getDiem());
			
			if(statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUntil.closeConnect(conn);
		return statusExecute;
	}
	
	/*
	 * Cập nhật sinh viên theo MASV
	 */
	public boolean updateSV(SinhVien sinhVien) {
		boolean statusExecute = false;
		String sql = "UPDATE `sinh_vien` SET TEN = ?,TUOI=? WHERE MASV = ?";
		conn = DatabaseUntil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getTenSinhVien());
			statement.setString(3, sinhVien.getMaSinhVien());
			statement.setInt(2, sinhVien.getTuoi());
			
			if(statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUntil.closeConnect(conn);
		return statusExecute;
	}
	
	/*
	 * Xóa sinh viên theo MASV
	 */
	public boolean deleteSV(SinhVien sinhVien) {
		boolean statusExecute = false;
		String sql = "DELETE FROM sinh_vien WHERE MASV = ?";
		conn = DatabaseUntil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
		
			
			if(statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUntil.closeConnect(conn);
		return statusExecute;
	}
	
	/*
	 * Sửa điểm sinh viên theo MASV và MONHOC
	 */
	public boolean update2SV(SinhVien sinhVien) {
		boolean statusExecute = false;
		String sql = "UPDATE diem SET diem = ? WHERE MASV = ? AND MONHOC = ?";
		conn = DatabaseUntil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, sinhVien.getMaSinhVien());
			statement.setString(3, sinhVien.getDiem().getMonhoc());
			statement.setInt(1, sinhVien.getDiem().getDiem());
			
			if(statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUntil.closeConnect(conn);
		return statusExecute;
	}
}