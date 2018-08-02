package quanlytruonghoc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.SinhVien;

/**
 * LopDao Class
 * 
 * @author CongMT
 *
 */
public class LopDao {

	private Connection conn;
	private PreparedStatement statement;

	/**
	 * Them moi 1 lop
	 * 
	 * @param lop
	 * @return
	 */
	public boolean addLop̣̣̣(Lop lop) {
		conn = DatabasaUltil.getConnect();
		boolean statusExecute = false;
		String sql = "INSERT INTO lop (idlop, tenlop, namhoc) VALUES (?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getIdLop());
			statement.setString(2, lop.getTenLop());
			statement.setString(3, lop.getNamHoc());
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Them thành công!!");
				statusExecute = true;
			}
		} catch (Exception e2) {
			System.out.println("Thêm thất bại!!");
		}
		return statusExecute;
	}

	/**
	 * Update 1 lop hoc theo idlop
	 * 
	 * @param lop
	 * @return
	 */
	public boolean updateLop(Lop lop) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE lop SET tenlop=?, namhoc=?  WHERE idlop=?";
		try {
			statement = conn.prepareStatement(sql);

			statement.setString(1, lop.getTenLop());
			statement.setString(2, lop.getNamHoc());
			statement.setString(3, lop.getIdLop());
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cập nhập thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			System.out.println("Cập nhập thất bại!!");
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Xoa 1 lop theo idlop
	 * 
	 * @param idlop
	 * @return
	 */
	public boolean deletelSinhVien(Lop lop) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "DELETE FROM lop WHERE idlop=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getIdLop());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xóa thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Tìm kiếm lớp theo tên lớp
	 * 
	 * @param lop
	 * @return
	 */

	public ArrayList<Lop> showTableLopTimKiem(Lop lop) {
		conn = DatabasaUltil.getConnect();
		String sql = "SELECT * FROM lop WHERE tenlop=?";
		ArrayList<Lop> listLop = new ArrayList<Lop>();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getTenLop());
			ResultSet result = statement.executeQuery();
			Lop lop1;
			while (result.next()) {
				lop1 = new Lop();
				lop1.setIdLop(result.getString("idlop"));
				lop1.setTenLop(result.getString("tenlop"));
				lop1.setNamHoc(result.getString("namhoc"));
				listLop.add(lop1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listLop;
	}

	/**
	 * Hiển thị danh sách tất cả các lớp
	 * 
	 * @return
	 */
	public ArrayList<Lop> getAllLop() {
		String sql = "SELECT * FROM lop";
		conn = DatabasaUltil.getConnect();
		ArrayList<Lop> listLop = new ArrayList<Lop>();
		try {
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			Lop lop;
			while (result.next()) {
				lop = new Lop();
				lop.setIdLop(result.getString("idlop"));
				lop.setTenLop(result.getString("tenlop"));
				lop.setNamHoc(result.getString("namhoc"));

				listLop.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listLop;
	}
	
	/**
	 * Hiển thị năm học trong bảng lớp(Lọc năm học)
	 * @return
	 */
	public ArrayList<String> getAllNamHoc() {
		String sql = "SELECT `namhoc` FROM `lop`";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listNamHoc = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listNamHoc.add(result.getString("namhoc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listNamHoc;
	}
	/**
	 * Hiển thị lớp từ năm học trong bảng lớp(Lọc theo tên lớp)
	 * @param namHoc
	 * @return
	 */
	public ArrayList<String> getAllTenLop(String namHoc) {
		String sql = "SELECT `tenlop` FROM `lop` WHERE namhoc=?";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listTenLop = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, namHoc);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				listTenLop.add(result.getString("tenlop"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listTenLop;
	}

	/**
	 * Hien thi danh sach tat ca sinh vien theo nam hoc va ten lop
	 * 
	 * @return
	 */
	public ArrayList<Lop> getAllSinhVienTheoNam(Lop lop1) {
		String sql = "SELECT  lop.idlop,lop.tenlop, sinhvien.idsv, sinhvien.hoten, lop.namhoc FROM lop  INNER JOIN sinhvien ON sinhvien.idlop=lop.idlop WHERE namhoc=? AND tenlop=?";
		conn = DatabasaUltil.getConnect();
		ArrayList<Lop> listLop = new ArrayList<Lop>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop1.getNamHoc());
			statement.setString(2, lop1.getTenLop());
			ResultSet result = statement.executeQuery();
			Lop lop;
			SinhVien sinhvien;
			while (result.next()) {
				lop = new Lop();

				lop.setIdLop(result.getString("idlop"));
				lop.setTenLop(result.getString("tenlop"));

				sinhvien = new SinhVien();
				sinhvien.setIdSinhVien(result.getString("idsv"));
				sinhvien.setHoTen(result.getString("hoten"));
				lop.setSinhVien(sinhvien);
				lop.setNamHoc(result.getString("namhoc"));

				listLop.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listLop;
	}
	/**
	 * Hiển thị tất cả mã lớp trong bảng lớp trong database
	 * @return
	 */
	public ArrayList<String> getAllMaLop() {
		String sql = "SELECT `idlop` FROM `lop`";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listMaLop = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listMaLop.add(result.getString("idlop"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listMaLop;
	}

	

}
