package quanlytiendien.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytiendien.model.entity.CongToDien;
import quanlytiendien.model.entity.KhachHang;
import quanlytiendien.model.entity.Quan;

/**
 * CÔNG TƠ ĐIỆN DAO
 * 
 * @author SơnVD and HưngHK
 *
 */
public class CongToDienDAO {
	Connection conn;

	public ArrayList<CongToDien> getAllCongToDien() {
		String sql = "SELECT * FROM cong_to_dien";
		conn = DatabaseUltil.getConnection();
		ArrayList<CongToDien> list = new ArrayList<CongToDien>();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CongToDien congToDien = new CongToDien();
				congToDien.setMaCongTo(resultSet.getString("maCongToDien"));
				congToDien.setLoaiCongTo(resultSet.getString("LoaiCongTo"));
				congToDien.setNhaSanXuat(resultSet.getString("nhaSanXuat"));
				congToDien.setNamSanXuat(resultSet.getString("namSanXuat"));

				list.add(congToDien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Thêm Công Tơ Điện
	 * 
	 * @param congToDien
	 * @return statusExecute
	 */
	public boolean addCongToDien(CongToDien congToDien) {
		boolean statusExecute = false;
		String sql = "INSERT INTO cong_to_dien(maCongToDien, LoaiCongTo, nhaSanXuat, namSanXuat) VALUES (?,?,?,?)";
		conn = DatabaseUltil.getConnection();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, congToDien.getMaCongTo());
			preparedStatement.setString(2, congToDien.getLoaiCongTo());
			preparedStatement.setString(3, congToDien.getNhaSanXuat());
			preparedStatement.setString(4, congToDien.getNamSanXuat());

			if (preparedStatement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return statusExecute;
	}

	/**
	 * Sửa thông tin công tơ điện
	 * 
	 * @param congToDien
	 * @return statusExecute
	 */
	public boolean updateCongToDien(CongToDien congToDien) {
		boolean statusExecute = false;
		String sql = "UPDATE `cong_to_dien` SET `LoaiCongTo`=?,`nhaSanXuat`=?,`namSanXuat`=? WHERE `maCongToDien`=?";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, congToDien.getLoaiCongTo());
			preparedStatement.setString(2, congToDien.getNhaSanXuat());
			preparedStatement.setString(3, congToDien.getNamSanXuat());
			preparedStatement.setString(4, congToDien.getMaCongTo());

			if (preparedStatement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusExecute;
	}

	/**
	 * Xóa thông tin công tơ điện
	 * 
	 * @param maCongTo
	 * @return statusExucute
	 */
	public boolean deleteCongToDien(String maCongTo) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		String sql = "DELETE FROM cong_to_dien WHERE maCongToDien = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maCongTo);

			if (preparedStatement.executeUpdate() > 0) {
				statusExucute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return statusExucute;
	}

	/**
	 * Tìm kiếm công tơ điện theo mã công tơ
	 * 
	 * @param congToDien
	 * @return list
	 */
	public ArrayList<CongToDien> searchCongToDien(CongToDien congToDien) {
		String sql = "SELECT * FROM cong_to_dien WHERE maCongToDien LIKE ? ";
		conn = DatabaseUltil.getConnection();
		ArrayList<CongToDien> list = new ArrayList<CongToDien>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + congToDien.getMaCongTo() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			CongToDien congToDien1;
			while (resultSet.next()) {
				congToDien1 = new CongToDien();
				congToDien1.setMaCongTo(resultSet.getString("maCongToDien"));
				congToDien1.setLoaiCongTo(resultSet.getString("LoaiCongTo"));
				congToDien1.setNhaSanXuat(resultSet.getString("nhaSanXuat"));
				congToDien1.setNamSanXuat(resultSet.getString("namSanXuat"));

				list.add(congToDien1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}
}
