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
	 * Thêm thẻ ATM
	 * @param soThe
	 * @param soTK
	 * @return
	 */
	public boolean addTheATM(String soThe, String soTK) {
		boolean kiemTra = false;
		String sql = "INSERT INTO the_atm VALUES (?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			statement.setString(2, "000000");
			statement.setString(3, soThe);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
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
		return kiemTra;
	}
	
	/**
	 * Xóa thẻ ATM theo mã số thẻ
	 * @param maSoThe
	 * @return
	 */
	public boolean deleteTheATMTheoSoThe(String maSoThe) {
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
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	/**
	 * Xóa thẻ ATM theo số tài khoản
	 * @param soTK
	 * @return
	 */
	public boolean deleteTheATMTheoSoTK(String soTK) {
		boolean kiemTra = false;
		String sql = "DELETE FROM the_atm WHERE soTK = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
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
		return kiemTra;
	}
	
	/**
	 * Lấy ra all thông tin thẻ ATM
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
				theATM.setPass(resultSet.getString("pass"));
				myList.add(theATM);
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
	 * Lấy tất cả thông tin theo số tài khoản
	 * @param soTK
	 * @return
	 */
	public ArrayList<TheATM> layThongTinTheoSoTK(String soTK) {
		ArrayList<TheATM> listTheATM = new ArrayList<>();
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm WHERE soTK LIKE '"+"%"+soTK+"'";
		PreparedStatement statement = null;
		try {
			TheATM theATM;
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				theATM = new TheATM();
				theATM.setSoTheATM(resultSet.getString("soTheATM"));
				theATM.setSoTK(resultSet.getString("soTK"));
				theATM.setPass(resultSet.getString("pass"));
				listTheATM.add(theATM);
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
		return listTheATM;
	}
	
	/**
	 * Lấy tất cả thông tin theo số thẻ
	 * @param soTheATM
	 * @return
	 */
	public ArrayList<TheATM> layThongTinTheoSoTheATM(String soTheATM) {
		ArrayList<TheATM> listTheATM = new ArrayList<>();
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm WHERE soTheATM LIKE '"+"%"+soTheATM+"'";
		PreparedStatement statement = null;
		try {
			TheATM theATM;
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				theATM = new TheATM();
				theATM.setSoTheATM(resultSet.getString("soTheATM"));
				theATM.setSoTK(resultSet.getString("soTK"));
				theATM.setPass(resultSet.getString("pass"));
				listTheATM.add(theATM);
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
		return listTheATM;
	}
	
	/**
	 * Lấy tất cả thông tin theo số tài khoản và số thẻ
	 * @param soTK, soTheATM
	 * @return
	 */
	public ArrayList<TheATM> layThongTinTheoSoTKVaSoThe(String soTK, String soTheATM) {
		ArrayList<TheATM> listTheATM = new ArrayList<>();
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm WHERE soTK LIKE '"+"%"+soTK+"' AND soTheATM LIKE '"+"%"+soTheATM+"'";
		PreparedStatement statement = null;
		try {
			TheATM theATM;
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				theATM = new TheATM();
				theATM.setSoTheATM(resultSet.getString("soTheATM"));
				theATM.setSoTK(resultSet.getString("soTK"));
				theATM.setPass(resultSet.getString("pass"));
				listTheATM.add(theATM);
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
		return listTheATM;
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
}
