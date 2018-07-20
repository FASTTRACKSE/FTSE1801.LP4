package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly.entity.KhachHang;

public class KhachHangDAO {
	Connection conn;

	/**
	 * Thêm khách hàng
	 * 
	 * @param khachHang
	 * @return
	 */
	public boolean addKhachHang(KhachHang khachHang) {
		boolean kiemTra = false;
		String sql = "INSERT INTO khach_hang VALUES (?,?,?,?,?,?,?,?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKH());
			statement.setString(2, khachHang.getTenKH());
			statement.setString(3, khachHang.getDiaChi());
			statement.setString(4, khachHang.getPhuong());
			statement.setString(5, khachHang.getQuan());
			statement.setString(6, khachHang.getSoDT());
			statement.setString(7, khachHang.getEmail());
			statement.setString(8, khachHang.getSoTheATM());
			statement.setString(9, khachHang.getSoTK());
			statement.setString(10, khachHang.getSoTienTrongTK());
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
	 * Update khách hàng theo mã khách hàng
	 * 
	 * @param khachHang
	 * @return
	 */
	public boolean updateKhachHang(KhachHang khachHang) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET tenKhachHang = ?, diaChi = ?, phuong = ?, quan = ?, soDienThoai = ?, email = ?, soTheATM = ?, soTK = ? WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getTenKH());
			statement.setString(2, khachHang.getDiaChi());
			statement.setString(3, khachHang.getPhuong());
			statement.setString(4, khachHang.getQuan());
			statement.setString(5, khachHang.getSoDT());
			statement.setString(6, khachHang.getEmail());
			statement.setString(7, khachHang.getSoTheATM());
			statement.setString(8, khachHang.getSoTK());
			statement.setString(9, khachHang.getMaKH());
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
	 * Xóa khách hàng theo tên
	 * 
	 * @param tenKH
	 * @return
	 */
	public boolean deleteKhachHang(String tenKH) {
		boolean kiemTra = false;
		String sql = "DELETE FROM khach_hang WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenKH);
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
	 * Lấy ra thông tin khách hàng theo số tài khoản
	 * 
	 * @param soTK
	 * @return
	 */
	public ArrayList<KhachHang> showKhachHangTheoMaKH(String soTK) {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM khach_hang WHERE soTK = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			ResultSet resultSet = statement.executeQuery();

			khachHang = new KhachHang();
			while (resultSet.next()) {
				khachHang.setMaKH(resultSet.getString("maKhachHang"));
				khachHang.setTenKH(resultSet.getString("tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong"));
				khachHang.setQuan(resultSet.getString("quan"));
				khachHang.setSoDT(resultSet.getString("soDienThoai"));
				khachHang.setEmail(resultSet.getString("email"));
				khachHang.setSoTheATM(resultSet.getString("soTheATM"));
				khachHang.setSoTK(resultSet.getString("soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("soTienTrongTK"));
				myList.add(khachHang);
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
	 * Lấy ra all thông tin khách hàng
	 * 
	 * @param soTK
	 * @return
	 */
	public ArrayList<KhachHang> showAllKhachHang() {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM khach_hang";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("maKhachHang"));
				khachHang.setTenKH(resultSet.getString("tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong"));
				khachHang.setQuan(resultSet.getString("quan"));
				khachHang.setSoDT(resultSet.getString("soDienThoai"));
				khachHang.setEmail(resultSet.getString("email"));
				khachHang.setSoTheATM(resultSet.getString("soTheATM"));
				khachHang.setSoTK(resultSet.getString("soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("soTienTrongTK"));
				myList.add(khachHang);
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
	 * Đăng nhập
	 * 
	 * @param soTK
	 * @param pass
	 * @return
	 */
	public boolean dangNhap(String soTK, String pass) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm WHERE soTK = ? AND passWord = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			statement.setString(2, pass);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
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
	 * Rút tiền
	 * 
	 * @param myList
	 * @param soTienRut
	 * @return
	 */
	public boolean rutTien(ArrayList<KhachHang> myList, String soTienRut) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET soTienTrongTK=? WHERE soTK= ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		if (Double.parseDouble(myList.get(0).getSoTienTrongTK()) > Double.parseDouble(soTienRut)) {
			Double soTienConLai = Double.parseDouble(myList.get(0).getSoTienTrongTK()) - Double.parseDouble(soTienRut);
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, ("" + soTienConLai));
				statement.setString(2, myList.get(0).getSoTK());
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
		} else {
			kiemTra = false;
		}

		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
}
