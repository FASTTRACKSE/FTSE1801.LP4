package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly.entity.TheATM;

public class TheAtmDAO {
	Connection conn;

	/**
	 * Lấy thông tin thẻ ATM để auto thêm thẻ atm
	 * 
	 * @return
	 */
	public TheATM layThongTinTheATM() {
		TheATM theATM = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `the_atm` ORDER BY `the_atm`.`soTheATM` DESC LIMIT 1";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				theATM = new TheATM();
				theATM.setSoTheATM(resultSet.getString("soTheATM"));
				theATM.setSoTK(resultSet.getString("soTK"));
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
		DatabaseUntil.closeConnection(conn);
		return theATM;
	}

	/**
	 * Thêm thẻ atm
	 * 
	 * @param soThe
	 * @param soTK
	 */
	public void addTheATM(String soThe, String soTK) {
		String soTheATM = "";
		String soTaiKhoan = "";
		
		String soThe1 = soThe.substring(0, 7);
		String soThe2 = soThe.substring(7,16);
		if (soThe2.equals("999999999")) {
			soThe1 = "" + (Integer.parseInt(soThe1) +1);
			soThe2 = "000000000";
		}else {
			soThe2 = "" + (Integer.parseInt(soThe2) +1);
		}
		soTheATM = soThe1 + soThe2;
		
		String soTK1 = soTK.substring(0, 4);
		String soTK2 = soTK.substring(4,13);
		if (soTK2.equals("999999999")) {
			soTK1 = "" + (Integer.parseInt(soTK1) +1);
			soTK2 = "000000000";
		}else {
			soTK2 = "" + (Integer.parseInt(soTK2) +1);
		}
		soTaiKhoan = soTK1 + soTK2;
		
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO the_atm VALUES (?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTaiKhoan);
			statement.setString(2, "000000");
			statement.setString(3, soTheATM);
			statement.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.getConnect();
	}

	/**
	 * Lấy mã thẻ theo số tài khoản
	 * 
	 * @param soTK
	 * @return
	 */
	public String layThongTinMaThe(String soTK) {
		String maThe = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm WHERE soTK = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				maThe = resultSet.getString("soTheATM");
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
		DatabaseUntil.getConnect();
		return maThe;
	}

	/**
	 * Lấy thông tin số tài khoản
	 * 
	 * @param maSoThe
	 * @return
	 */
	public String layThongTinMaTK(String maSoThe) {
		String soTK = null;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT soTK FROM the_atm WHERE soTheATM = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSoThe);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				soTK = resultSet.getString("soTK");
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
		return soTK;
	}

	/**
	 * Lấy số thẻ ATM chưa sử dụng
	 * 
	 * @return
	 */
	public ArrayList<String> laySoTheATM() {
		PreparedStatement statement = null;
		ArrayList<String> listSoThe = new ArrayList<>();
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm LEFT JOIN khach_hang ON khach_hang.soTheATM = the_atm.soTheATM WHERE khach_hang.maKhachHang IS NULL";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listSoThe.add(resultSet.getString("soTheATM"));
			}
		} catch (Exception e) {
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
		DatabaseUntil.closeConnection(conn);
		return listSoThe;

	}

}
