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
public class DiemDAO {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;

	/**
	 * Them diem theo idsv va idmonhoc
	 * 
	 * @param diem
	 * @param idsv
	 * @param idmon
	 */
	public boolean addDiem(Diem diem, String idsv, String idmon) {
		boolean test = false;
		// Check idsv va idmon voi database - Neu da co thi ID da ton tai - Neu chua co
		// thi thuc thi cau lenh Insert them moi diem
		String sqlID = "SELECT * FROM project.diem";
		try {
			statement = conn.prepareStatement(sqlID);
			result = statement.executeQuery();
			while (result.next()) {
				String plus = result.getString("idsv") + result.getString("idmon");
				if (plus.equals(idsv + idmon)) {
					test = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Thuc thi Insert Them moi diem
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO project.diem (idlop, monhoc, idmon, idsv, diemthi ,xeploai) VALUES (?,?,?,?, ?,?, ?,?, ?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, diem.getIdLop());
			statement.setString(2, diem.getMonHoc());
			statement.setString(3, diem.getIdMonHoc());
			statement.setString(4, diem.getIdSinhVien());
			statement.setInt(5, (int) diem.getDiemThi());
			statement.setString(3, diem.getIdMonHoc());
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
	public boolean deletelDiemSinhVien(Diem diem) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "DELETE FROM diem WHERE idsv=? AND idmon=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, diem.getIdSinhVien());
			statement.setString(2, diem.getIdMonHoc());

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
	
	public ArrayList<String> getAllDiemThi(String idsv) {
		String sql = "SELECT `diemthi` FROM `diem` WHERE `idsv` = ?";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listDiem = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "idsv");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listDiem.add(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listDiem;
	}
	
}
