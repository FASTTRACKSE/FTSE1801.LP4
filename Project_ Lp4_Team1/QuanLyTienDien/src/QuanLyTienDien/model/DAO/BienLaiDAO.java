package quanlytiendien.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytiendien.model.entity.BienLai;
import quanlytiendien.model.entity.CongToDien;

/**
 * Biên Lai DAO
 * 
 * @author SonVD and HungHK
 *
 */
public class BienLaiDAO {
	Connection conn;

	/**
	 * Lấy danh sách biên lai từ database
	 * 
	 * @return list
	 */
	public ArrayList<BienLai> getAllBienLai() {
		String sql = "SELECT bienlai.maBienLai, cong_to_dien.maCongToDien, bienlai.ngayNhap, bienlai.chuKyNhap, bienlai.chiSoCongTo FROM bienlai INNER JOIN cong_to_dien ON  bienlai.maCongToDien = cong_to_dien.maCongToDien ORDER BY bienlai.maBienLai ASC";
		conn = DatabaseUltil.getConnection();
		ArrayList<BienLai> list = new ArrayList<BienLai>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			CongToDien congToDien;
			BienLai bienLai;
			while (resultSet.next()) {
				bienLai = new BienLai();
				congToDien = new CongToDien();
				bienLai.setMaBienLai(resultSet.getString("maBienLai"));
				congToDien.setMaCongTo(resultSet.getString("maCongToDien"));
				bienLai.setNgayNhap(resultSet.getDate("bienlai.ngayNhap"));
				bienLai.setChuKyNhap(resultSet.getString("chuKyNhap"));
				bienLai.setChiSoCongTo(resultSet.getString("chiSoCongTo"));
				bienLai.setMaCongTo(congToDien);

				list.add(bienLai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Thêm biên lai vào database
	 * 
	 * @param bienLai
	 * @param congToDien
	 * @return statusExecute
	 */
	public boolean addBienLai(BienLai bienLai, CongToDien congToDien) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `bienlai`( `maCongToDien`, `ngayNhap`, `chuKyNhap`, `chiSoCongTo`) VALUES (?,?,?,?)";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, congToDien.getMaCongTo());
			preparedStatement.setDate(2, bienLai.getNgayNhap());
			preparedStatement.setString(3, bienLai.getChuKyNhap());
			preparedStatement.setInt(4, Integer.parseInt(bienLai.getChiSoCongTo()));

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
	 * Sửa thông tin biên lai
	 * 
	 * @param bienLai
	 * @return statusExecute
	 */
	public boolean updateBienLai(BienLai bienLai) {
		boolean statusExecute = false;
		String sql = "UPDATE bienlai SET bienlai.ngayNhap=?,bienlai.chuKyNhap=?,bienlai.chiSoCongTo=? WHERE bienlai.`maBienLai`= ? ";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setDate(1, bienLai.getNgayNhap());
			preparedStatement.setString(2, bienLai.getChuKyNhap());
			preparedStatement.setString(3, bienLai.getChiSoCongTo());
			preparedStatement.setString(4, bienLai.getMaBienLai());

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
	 * Xóa thông tin biên lai
	 * 
	 * @param bienLai
	 * @return statusExecute
	 */
	public boolean deleteBienLai(BienLai bienLai) {
		boolean statusExecute = false;
		String sql = "DELETE FROM `bienlai` WHERE maBienLai = ? ";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bienLai.getMaBienLai());

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
	 * Tìm kiếm thông tin biên lai theo mã công tơ
	 * 
	 * @param bienLai
	 * @return list
	 */
	public ArrayList<BienLai> searchBienLai(BienLai bienLai) {
		String sql = "SELECT bienlai.maBienLai, cong_to_dien.maCongToDien, bienlai.ngayNhap, bienlai.chuKyNhap, bienlai.chiSoCongTo FROM bienlai INNER JOIN cong_to_dien ON bienlai.maCongToDien = cong_to_dien.maCongToDien WHERE bienlai.maCongToDien LIKE ? OR bienlai.maBienLai LIKE ?";
		conn = DatabaseUltil.getConnection();
		ArrayList<BienLai> list = new ArrayList<BienLai>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + bienLai.getMaCongTo().getMaCongTo() + "%");
			preparedStatement.setString(2, "%" + bienLai.getMaBienLai() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			BienLai bienLai1;
			CongToDien congToDien;
			while (resultSet.next()) {

				bienLai1 = new BienLai();
				bienLai1.setMaBienLai(resultSet.getString("maBienLai"));
				bienLai1.setNgayNhap(resultSet.getDate("ngayNhap"));
				bienLai1.setChuKyNhap(resultSet.getString("chuKyNhap"));
				bienLai1.setChiSoCongTo(resultSet.getString("chiSoCongTo"));
				congToDien = new CongToDien();
				congToDien.setMaCongTo(resultSet.getString("maCongToDien"));
				bienLai1.setMaCongTo(congToDien);

				list.add(bienLai1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}
}
