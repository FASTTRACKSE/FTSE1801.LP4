package quanlytruonghoc.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytruonghoc.entity.Diem;


/**
 * DiemDao Class
 * 
 * @author CongMT
 *
 */
public class DiemDao {
	private Connection conn;
	private PreparedStatement statement;
	

	/**
	 * Them diem theo idsv va idmonhoc
	 * 
	 * @param diem
	 * @param idsv
	 * @param idmon
	 */
	public boolean addDiem(Diem diem) {
		boolean test = false;
		// Thuc thi Insert Them moi diem
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO `diem`(`idmon`, `idsv`, `diemthi`) VALUES (?,?,?) ";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, diem.getIdMonHoc());
			statement.setString(2, diem.getIdSinhVien());
			statement.setDouble(3, diem.getDiemThi());
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Luu thanh cong");
				test = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return test;

	}

	/**
	 * Sua diem 1 sinh vien theo MaSv va Mon Hoc
	 * 
	 * @param sinhvien
	 * @return
	 */
	public boolean updateDiemSinhVien(Diem diem) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE diem SET diemthi=? WHERE idsv=? AND idmon=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, (int) diem.getDiemThi());
			statement.setString(2, diem.getIdSinhVien());
			statement.setString(3, diem.getIdMonHoc());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cap nhap thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			System.out.println("Cap nhap that bai!!");
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Xoa diem 1 sv theo idsv va idmonhoc
	 * 
	 * @param diem
	 * @return
	 */
	public boolean deletelDiemSinhVien(String idSv) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "DELETE FROM diem WHERE idsv=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idSv);

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa thanh cong!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			System.out.println("Xoa that bai!!");
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}
	
	/**
	 * Hiển thị danh sách tất cả điểm các môn
	 * 
	 * @return
	 */

	/**
	 * Hiển thị tất cả mã sinh viên trong bảng lớp trong database
	 * @return
	 */
	public ArrayList<String> getAllMaSv() {
		String sql = "SELECT `idsv` FROM `sinhvien`";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listMaSv = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listMaSv.add(result.getString("idsv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listMaSv;
	}
	/**
	 *  Hiển thị tất cả các điểm trong bảng quản lý điểm
	 * @return
	 */
	
	public ArrayList<Diem> getDiem() {
		String sql = "SELECT * FROM `diem`";
		conn = DatabasaUltil.getConnect();
		ArrayList<Diem> listDiemForSV = new ArrayList<Diem>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Diem diem = new Diem();
				diem.setIdSinhVien(result.getString("idsv"));
				diem.setIdMonHoc(result.getString("idmon"));
				diem.setDiemThi(result.getFloat("diemthi"));
				listDiemForSV.add(diem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listDiemForSV;
	}
	/**
	 * Tìm kiếm điểm môn học theo mã sinh viên
	 * 
	 * @param monHoc
	 * @return
	 */
	public ArrayList<Diem> showTableDiemTimKiem(String idsv) {
		conn = DatabasaUltil.getConnect();
		ArrayList<Diem> listDiem = new ArrayList<Diem>();
		String sql = "SELECT * FROM `diem` WHERE idsv=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1,idsv);

			ResultSet result = statement.executeQuery();
			Diem diem1;
			while (result.next()) {
				diem1 = new Diem();
			
				diem1.setIdMonHoc(result.getString("idmon"));
				diem1.setDiemThi(result.getFloat("diemthi"));
				diem1.setIdSinhVien(result.getString("idsv"));
				listDiem.add(diem1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		DatabasaUltil.closeConnection(conn);
		return listDiem;

	}

}
