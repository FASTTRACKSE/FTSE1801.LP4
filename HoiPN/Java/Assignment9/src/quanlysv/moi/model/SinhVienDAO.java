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
		boolean statusExcute = false;
		String sql = "INSERT INTO sinh_vien VALUES(?,?,?)";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getTenSinhVien());
			statement.setString(3, sinhVien.getPassword());

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
		String sql = "UPDATE sinh_vien SET ten = ?,pass = ? WHERE masv = ?";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(3, sinhVien.getMaSinhVien());
			statement.setString(1, sinhVien.getTenSinhVien());
			statement.setString(2, sinhVien.getPassword());

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
		String sql = "DELETE FROM diem WHERE masv=?";
		String sql1 = "DELETE FROM sinh_vien WHERE masv=?";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());

			if (statement.executeUpdate() > 0) {
				statusExcute = true;
			}
			
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
	
	public boolean deleteDiem(SinhVien sinhVien) {
		boolean statusExcute = false;
		String sql = "DELETE FROM diem WHERE masv=? AND monhoc = ?";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getDiem().getMonHoc());

			if (statement.executeUpdate() > 0) {
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
	
	public boolean addDiem(SinhVien sinhVien) {
		boolean statusExcute = false;
		String sql = "INSERT INTO diem VALUES(?,?,?)";
		conn = DatabaseUltil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getDiem().getMonHoc());
			statement.setInt(3, sinhVien.getDiem().getDiem());

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
	
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.masv = diem.masv";
		conn = DatabaseUltil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			SinhVien sinhVien = null;
			Diem diem;

			while (result.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSinhVien(result.getString("masv"));
				sinhVien.setTenSinhVien(result.getString("ten"));
				sinhVien.setPassword(result.getString("pass"));

				diem = new Diem();
				diem.setDiem(result.getInt("diem"));
				diem.setMonHoc(result.getString("monhoc"));
				sinhVien.setDiem(diem);

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
			Diem diem;

			while (result.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSinhVien(result.getString("masv"));
				sinhVien.setTenSinhVien(result.getString("ten"));
				sinhVien.setPassword(result.getString("pass"));

				diem = new Diem();
				diem.setDiem(result.getInt("diem"));
				diem.setMonHoc(result.getString("monhoc"));
				sinhVien.setDiem(diem);

				list.add(sinhVien);

			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DatabaseUltil.closeConnect(conn);
		}

		return list;
	}
	
	
}
