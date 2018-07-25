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
	 * Thêm thẻ atm
	 * 
	 * @param theATM
	 * @return
	 */
	public boolean addTheATM(TheATM theATM) {
		boolean kiemTra = false;
		String sql = "INSERT INTO the_atm VALUES (?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, theATM.getSoTK());
			statement.setString(2, theATM.getPass());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			System.out.println("loi");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Đóng lỗi");
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	/**
	 * Update thẻ ATM theo mã số thẻ
	 * 
	 * @param theATM
	 * @return
	 */
	public boolean updateTheATM(TheATM theATM) {
		boolean kiemTra = false;
		String sql = "UPDATE the_atm SET soTK=?, passWord = ? WHERE soTheATM = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, theATM.getSoTK());
			statement.setString(2, theATM.getPass());
			statement.setString(3, theATM.getSoTheATM());
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
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Xóa thẻ ATM theo mã số thẻ
	 * 
	 * @param maSoThe
	 * @return
	 */
	public boolean deleteTheATM(String maSoThe) {
		boolean kiemTra = false;
		String sql = "DELETE FROM the_atm WHERE soTheATM= ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSoThe);
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
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	/**
	 * Lấy ra all thông tin thẻ ATM
	 * 
	 * @return
	 */
	public ArrayList<TheATM> showAllTheATM() {
		ArrayList<TheATM> myList = new ArrayList<>();
		PreparedStatement statement = null;
		TheATM theATM;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				theATM = new TheATM();
				theATM.setSoTheATM(resultSet.getString("soTheATM"));
				theATM.setSoTK(resultSet.getString("soTK"));
				theATM.setPass(resultSet.getString("passWord"));
				myList.add(theATM);
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
		return myList;
	}
	
	/**
	 * Lấy mã thẻ theo số tài khoản
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
		return soTK;
	}
}
