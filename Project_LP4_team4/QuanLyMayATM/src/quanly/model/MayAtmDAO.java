package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly.entity.MayATM;

public class MayAtmDAO {
	Connection conn;
	PhuongQuanDAO phuongQuanDAO;
	/**
	 * Thêm máy ATM
	 * 
	 * @param mayATM
	 * @return
	 */
	public boolean addMayATM(MayATM mayATM) {
		boolean kiemTra = false;
		String sql = "INSERT INTO may_atm VALUES (?,?,?,?)";
		phuongQuanDAO = new PhuongQuanDAO();
		int maPhuong = phuongQuanDAO.layThongTinMaPhuong(mayATM.getPhuong());
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, mayATM.getMaMay());
			statement.setString(2, mayATM.getViTri());
			statement.setInt(3, maPhuong);
			statement.setString(4, mayATM.getTongTien());
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
	 * Update thông tin tiền trong máy ATM
	 * @param mayATM
	 * @param soTien
	 * @return
	 */
	public boolean updateMayATMThemTien(MayATM mayATM,String soTien) {
		boolean kiemTra = false;
		String sql = "UPDATE may_atm SET tongTien=? WHERE maMayATM = ?";
		Integer allTien = Integer.parseInt(mayATM.getTongTien()) + Integer.parseInt(soTien);
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, (String.valueOf(allTien)));
			statement.setString(2, mayATM.getMaMay());
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
	 * Lấy ra thông tin máy ATM theo mã máy
	 * 
	 * @param maMay
	 * @return
	 */
	public MayATM showMayATMMaMay(String maMay) {
		PreparedStatement statement = null;
		MayATM mayATM = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM may_atm JOIN phuong ON may_atm.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan WHERE maMayATM  = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maMay);
			ResultSet resultSet = statement.executeQuery();

			mayATM = new MayATM();
			while (resultSet.next()) {
				mayATM.setMaMay(resultSet.getString("may_atm.maMayATM"));
				mayATM.setViTri(resultSet.getString("may_atm.viTri"));
				mayATM.setPhuong(resultSet.getString("phuong.tenPhuong"));
				mayATM.setQuan(resultSet.getString("quan.tenQuan"));
				mayATM.setTongTien(resultSet.getString("may_atm.tongTien"));
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
		return mayATM;
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
	 * Lấy ra all thông tin máy ATM
	 * @return
	 */
	public ArrayList<MayATM> showAllMayATM() {
		ArrayList<MayATM> myList = new ArrayList<>();
		PreparedStatement statement = null;
		MayATM mayATM;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM may_atm JOIN phuong ON may_atm.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan ORDER BY maMayATM ASC";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				mayATM = new MayATM();
				mayATM.setMaMay(resultSet.getString("may_atm.maMayATM"));
				mayATM.setViTri(resultSet.getString("may_atm.viTri"));
				mayATM.setPhuong(resultSet.getString("phuong.tenPhuong"));
				mayATM.setQuan(resultSet.getString("quan.tenQuan"));
				mayATM.setTongTien(resultSet.getString("may_atm.tongTien"));
				myList.add(mayATM);
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
	 * Lấy ra thông tin máy ATM theo địa chỉ
	 * 
	 * @param phuong
	 * @return
	 */
	public ArrayList<MayATM> showMayATMTheoDiaChi(String phuong) {
		ArrayList<MayATM> myList = new ArrayList<>();
		PreparedStatement statement = null;
		MayATM mayATM;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM may_atm JOIN phuong ON may_atm.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan WHERE phuong.tenPhuong = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, phuong);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				mayATM = new MayATM();
				mayATM.setMaMay(resultSet.getString("may_atm.maMayATM"));
				mayATM.setViTri(resultSet.getString("may_atm.viTri"));
				mayATM.setPhuong(resultSet.getString("phuong.tenPhuong"));
				mayATM.setQuan(resultSet.getString("quan.tenQuan"));
				mayATM.setTongTien(resultSet.getString("may_atm.tongTien"));
				myList.add(mayATM);
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
	 * Update thông tin tiền trong máy ATM khi rút tiền
	 * @param mayATM
	 * @param soTien
	 * @return
	 */
	public boolean updateMayAtmRutTien(MayATM mayATM,String soTien) {
		boolean kiemTra = false;
		String sql = "UPDATE may_atm SET tongTien=? WHERE maMayATM = ?";
		Integer allTien = Integer.parseInt(mayATM.getTongTien()) - Integer.parseInt(soTien);
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, (String.valueOf(allTien)));
			statement.setString(2, mayATM.getMaMay());
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
}
