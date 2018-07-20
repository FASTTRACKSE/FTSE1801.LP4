package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly.entity.MayATM;

public class MayAtmDAO {
	Connection conn;
	
	/**
	 * Thêm máy ATM
	 * 
	 * @param mayATM
	 * @return
	 */
	public boolean addMayATM(MayATM mayATM) {
		boolean kiemTra = false;
		String sql = "INSERT INTO the_atm VALUES (?,?,?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, mayATM.getMaMay());
			statement.setString(2, mayATM.getViTri());
			statement.setString(3, mayATM.getPhuong());
			statement.setString(4, mayATM.getQuan());
			statement.setString(5, mayATM.getTongTien());
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
	 * Lấy ra thông tin máy ATM theo mã máy
	 * 
	 * @param maMay
	 * @return
	 */
	public ArrayList<MayATM> showMayATMMaMay(String maMay) {
		ArrayList<MayATM> myList = new ArrayList<>();
		PreparedStatement statement = null;
		MayATM mayATM;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM may_atm WHERE maMayATM  = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maMay);
			ResultSet resultSet = statement.executeQuery();

			mayATM = new MayATM();
			while (resultSet.next()) {
				mayATM.setMaMay(resultSet.getString("maMayATM"));
				mayATM.setViTri(resultSet.getString("viTri"));
				mayATM.setPhuong(resultSet.getString("phuong"));
				mayATM.setQuan(resultSet.getString("quan"));
				mayATM.setTongTien(resultSet.getString("tongTien"));
				myList.add(mayATM);
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
	 * Update thông tin tiền trong máy ATM
	 * 
	 * @param myList, soTien
	 * @return
	 */
	public boolean updateMayATM(ArrayList<MayATM> myList,String soTien) {
		boolean kiemTra = false;
		String sql = "UPDATE may_atm SET tongTien=? WHERE maMayATM = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		Double allTien = Double.parseDouble(myList.get(0).getTongTien()) - Double.parseDouble(soTien);
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, (""+allTien));
			statement.setString(2, myList.get(0).getMaMay());
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
	 * Xóa máy ATM theo mã máy
	 * 
	 * @param maMay
	 * @return
	 */
	public boolean deleteMayATM(String maMay) {
		boolean kiemTra = false;
		String sql = "DELETE FROM may_atm WHERE maMayATM= ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maMay);
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
	 * Lấy ra all thông tin máy ATM
	 * 
	 * @param soTK
	 * @return
	 */
	public ArrayList<MayATM> showAllMayATM() {
		ArrayList<MayATM> myList = new ArrayList<>();
		PreparedStatement statement = null;
		MayATM mayATM;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM may_atm";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				mayATM = new MayATM();
				mayATM.setMaMay(resultSet.getString("maMayATM"));
				mayATM.setViTri(resultSet.getString("viTri"));
				mayATM.setPhuong(resultSet.getString("phuong"));
				mayATM.setQuan(resultSet.getString("quan"));
				mayATM.setTongTien(resultSet.getString("tongTien"));
				myList.add(mayATM);
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
	 * Lấy ra thông tin máy ATM theo địa chỉ
	 * 
	 * @param maMay
	 * @return
	 */
	public ArrayList<MayATM> showMayATMTheoDiaChi(String diaChi, String phuong, String quan) {
		ArrayList<MayATM> myList = new ArrayList<>();
		PreparedStatement statement = null;
		MayATM mayATM;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM may_atm WHERE viTri= ? AND phuong = ? AND quan = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, diaChi);
			statement.setString(2, phuong);
			statement.setString(3, quan);
			ResultSet resultSet = statement.executeQuery();

			mayATM = new MayATM();
			while (resultSet.next()) {
				mayATM.setMaMay(resultSet.getString("maMayATM"));
				mayATM.setViTri(resultSet.getString("viTri"));
				mayATM.setPhuong(resultSet.getString("phuong"));
				mayATM.setQuan(resultSet.getString("quan"));
				mayATM.setTongTien(resultSet.getString("tongTien"));
				myList.add(mayATM);
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
}
