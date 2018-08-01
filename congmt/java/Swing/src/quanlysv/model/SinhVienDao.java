package quanlysv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

import quanlysv.entity.Diem;
import quanlysv.entity.SinhVien;

/**
 * SinhVienDao Class
 * 
 * @author CongMT
 *
 */
public class SinhVienDao {
	Connection conn;

	/**
	 * Them moi 1 sinh vien
	 * 
	 * @param sinhvien
	 * @return
	 */
	public boolean addNewSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO sinh_vien(MASV,TEN,Pass) VALUE(?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getMaSinhVien());
			statement.setString(2, sinhvien.getTenSinhVien());
			statement.setString(3, sinhvien.getPassSinhVien());
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Luu thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;

	}

	/**
	 * Them diem cho 1 sinh vien theo maSV
	 * 
	 * @param sinhvien
	 * @return
	 */
	public boolean addDiemSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO diem(MASV,MonHoc,Diem) VALUE(?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getMaSinhVien());
			statement.setString(2, sinhvien.getDiem().getMonHoc());
			statement.setInt(3, (int) sinhvien.getDiem().getDiem());
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Luu thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;

	}

	/**
	 * Update 1 sinh vien theo MaSV
	 * 
	 * @param sinhvien
	 * @return
	 */
	public boolean updateSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE sinh_vien SET TEN=?, Pass=? WHERE MASV=?	";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getTenSinhVien());
			statement.setString(2, sinhvien.getPassSinhVien());
			statement.setString(3, sinhvien.getMaSinhVien());
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cap nhap thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Xoa 1 sinh vien theo MaSv
	 * 
	 * @param MASV
	 * @param MonHoc
	 * @return
	 */
	public boolean deletelSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "DELETE FROM diem WHERE MASV=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getMaSinhVien());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql1 = "DELETE FROM sinh_vien WHERE MASV=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql1);
			statement.setString(1, sinhvien.getMaSinhVien());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Sua diem 1 sinh vien theo MaSv va Mon Hoc
	 * 
	 * @param sinhvien
	 * @return
	 */
	public boolean updateDiemSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE diem SET DIEM=? WHERE MASV=? AND MonHoc=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, (int) sinhvien.getDiem().getDiem());
			statement.setString(2, sinhvien.getMaSinhVien());
			statement.setString(3, sinhvien.getDiem().getMonHoc());
			
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cap nhap thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	public boolean deletelDiemSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "DELETE FROM diem WHERE MASV=? AND MonHoc=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getMaSinhVien());
			statement.setString(2, sinhvien.getDiem().getMonHoc());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Hien thi danh sach tat ca sinh vien
	 * 
	 * @return
	 */
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.masv= diem.masv";
		conn = DatabasaUltil.getConnect();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;
			Diem diem;
			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setMaSinhVien(result.getString("MASV"));
				sinhvien.setTenSinhVien(result.getString("TEN"));
				sinhvien.setPassSinhVien(result.getString("Pass"));

				diem = new Diem();
				diem.setDiem(result.getInt("DIEM"));
				diem.setMonHoc(result.getString("MonHoc"));
				sinhvien.setDiem(diem);
				listSinhVien.add(sinhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listSinhVien;
	}

	/**
	 * Hiển thị tất cả sinh viên theo Tên
	 * 
	 * @return
	 */
	public ArrayList<SinhVien> getAllSinhVienTheoTen(SinhVien sinhvien1) {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.masv= diem.masv WHERE TEN=?";
		conn = DatabasaUltil.getConnect();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		try {
			SinhVien sinhvien;
			Diem diem;
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien1.getTenSinhVien());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setMaSinhVien(result.getString("MASV"));
				sinhvien.setTenSinhVien(result.getString("TEN"));
				sinhvien.setPassSinhVien(result.getString("Pass"));

				diem = new Diem();
				diem.setDiem(result.getInt("DIEM"));
				diem.setMonHoc(result.getString("MonHoc"));
				sinhvien.setDiem(diem);
				listSinhVien.add(sinhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listSinhVien;
	}

}
