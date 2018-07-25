package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import quanly.entity.GiaoDich;

public class GiaoDichDAO {
	Connection conn;

	/**
	 * Thêm thông tin giao dịch
	 * @param soTienRut
	 * @param myList
	 * @param mayATM
	 * @return
	 */
	public boolean addThongTinGiaoDich(String soTienRut, String soTheATM, String mayATM) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO giao_dich(soTheATM,thoiGian,soTien,maMayATM) VALUES (?,?,?,?)";
		PreparedStatement statement = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTheATM);
			statement.setString(2, dateFormat.format(date));
			statement.setString(3, soTienRut);
			statement.setString(4, mayATM);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		DatabaseUntil.getConnect();
		return kiemTra;
	}

	/**
	 * Lấy mã giao dịch
	 * @return
	 */
	public GiaoDich layMaGiaoDich() {
		GiaoDich giaoDich = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `giao_dich` ORDER BY `giao_dich`.`thoiGian` DESC LIMIT 1";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				giaoDich = new GiaoDich();
				giaoDich.setMaGiaoDich(resultSet.getInt("maGiaoDich"));
				giaoDich.setThoiGian(resultSet.getString("thoiGian"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		DatabaseUntil.getConnect();
		return giaoDich;
	}
}
