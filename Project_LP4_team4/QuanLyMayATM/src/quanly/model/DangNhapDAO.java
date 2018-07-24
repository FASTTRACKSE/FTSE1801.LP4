package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quanly.entity.KhachHang;
import quanly.entity.MayATM;

public class DangNhapDAO {
	Connection conn;
	
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
		String sql = "SELECT * FROM the_atm JOIN khach_hang ON the_atm.soTheATM = khach_hang.soTheATM WHERE the_atm.soTK = ? AND the_atm.pass = ?";
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
	 * Lấy ra thông tin khách hàng theo số tài khoản
	 * 
	 * @param soTK
	 * @return
	 */
	public KhachHang showKhachHangTheoMaKH(String soThe) {
		PreparedStatement statement = null;
		KhachHang khachHang = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE the_atm.soTK= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soThe);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
				khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
				khachHang.setQuan(resultSet.getString("quan.tenQuan"));
				khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
				khachHang.setEmail(resultSet.getString("khach_hang.email"));
				khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
				khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
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
		return khachHang;
	}
	
	/**
	 * Rút tiền
	 * 
	 * @param myList
	 * @param soTienRut
	 * @return
	 */
	public boolean rutTien(KhachHang khachHang, String soTienRut) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET soTienTrongTK=? WHERE soTK= ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		if (Integer.parseInt(khachHang.getSoTienTrongTK()) > Integer.parseInt(soTienRut)) {
			Integer soTienConLai = Integer.parseInt(khachHang.getSoTienTrongTK()) - Integer.parseInt(soTienRut);
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, ("" + soTienConLai));
				statement.setString(2, khachHang.getSoTK());
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
	
	/**
	 * Kiểm tra máy ATM có đủ tiền để rút không
	 * @param mayATM
	 * @param soTien
	 * @return
	 */
	public boolean kiemTraTienMayATM(MayATM mayATM, String soTien) {
		boolean kiemTra = false;
		if (Integer.parseInt(mayATM.getTongTien())>Integer.parseInt(soTien)) {
			kiemTra = true;
		}
		return kiemTra;
	}
}
