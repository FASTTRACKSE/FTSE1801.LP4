package quanlysv.moi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlysv.moi.model.entity.SinhVien;

public class SinhVienDAO {
	Connection conn;

	public boolean addSinhVien(SinhVien sinhVien) {
		boolean statusExcute = false;
		String sql = "INSERT INTO sinh_vien VALUES(?,?,?)";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getTenSinhVien());
			statement.setInt(3, sinhVien.getTuoi());

			if (statement.executeUpdate() > 0) {
				statusExcute = true;
			}
		} catch (SQLException e) {
			System.out.println("Them khong thanh cong");
			e.printStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return statusExcute;
	}
	
	public boolean updateSinhVien(SinhVien sinhVien) {
		boolean statusExcute = false;
		String sql = "UPDATE sinh_vien SET ten = ?,tuoi = ? WHERE masv = ?";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(3, sinhVien.getMaSinhVien());
			statement.setString(1, sinhVien.getTenSinhVien());
			statement.setInt(2, sinhVien.getTuoi());

			if (statement.executeUpdate() > 0) {
				statusExcute = true;
			}
		} catch (SQLException e) {
			System.out.println("Sua khong thanh cong");
			e.printStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return statusExcute;
	}
	
	public boolean deleteSinhVien(SinhVien sinhVien) {
		boolean statusExcute = false;
		String sql1 = "DELETE FROM sinh_vien WHERE masv=?";
		conn = DatabaseUltil.getConnect();
		try {

			PreparedStatement statement1 = conn.prepareStatement(sql1);
			statement1.setString(1, sinhVien.getMaSinhVien());

			if (statement1.executeUpdate() > 0) {
				statusExcute = true;
			}
		} catch (SQLException e) {
			System.out.println("xóa khong thanh cong");
			e.printStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return statusExcute;
	}
	
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinh_vien";
		conn = DatabaseUltil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			SinhVien sinhVien = null;

			while (result.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSinhVien(result.getString("masv"));
				sinhVien.setTenSinhVien(result.getString("ten"));
				sinhVien.setTuoi(result.getInt("tuoi"));

				list.add(sinhVien);

			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return list;
	}
	
	public ArrayList<SinhVien> getSinhVienTheoTen(String ten) {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.masv = diem.masv WHERE ten = ?";
		conn = DatabaseUltil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();


		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet result = statement.executeQuery();

			SinhVien sinhVien = null;

			while (result.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSinhVien(result.getString("masv"));
				sinhVien.setTenSinhVien(result.getString("ten"));
				sinhVien.setTuoi(result.getInt("tuoi"));

				list.add(sinhVien);

			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return list;
	}
	
	public ArrayList<String> getAllMaSinhVien() {
		String sql = "SELECT `masv` FROM `sinh_vien`";
		conn = DatabaseUltil.getConnect();
		ArrayList<String> listMSV = new ArrayList<String>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

//			String maSihVien = null;

			while (result.next()) {
//				maSihVien = new String();
//				maSinhVien = result.getString("masv");
				

				listMSV.add(result.getString("masv"));

			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return listMSV;
	}
}
