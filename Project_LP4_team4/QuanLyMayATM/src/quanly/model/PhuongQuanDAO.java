package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhuongQuanDAO {
	Connection conn;
	
	/**
	 * lấy ra all danh sách quận
	 * @return
	 */
	public ArrayList<String> showAllDanhSachQuan() {
		ArrayList<String> myList = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM quan";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				myList.add(resultSet.getString("tenQuan"));
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return myList;
	}

	/**
	 * Lấy ra all danh sách phường theo quận
	 * @param tenQuan
	 * @return
	 */
	public ArrayList<String> showDanhSachPhuong(String tenQuan) {
		ArrayList<String> myList = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM phuong JOIN quan ON phuong.maQuan = quan.maQuan WHERE quan.tenQuan = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenQuan);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				myList.add(resultSet.getString("tenPhuong"));
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return myList;
	}
	
	/**
	 * Lấy mã phường
	 * @param tenPhuong
	 * @return
	 */
	public int layThongTinMaPhuong(String tenPhuong) {
		int maPhuong = 0;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT maPhuong FROM phuong WHERE tenPhuong = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenPhuong);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				maPhuong = resultSet.getInt("maPhuong");
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return maPhuong;
	}
}

