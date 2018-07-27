package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import quanly.entity.GiaoDich;
import quanly.entity.KhachHang;
import quanly.entity.MayATM;

public class GiaoDichDAO {
	Connection conn;

	/**
	 * Thêm thông tin giao dịch
	 * 
	 * @param soTienRut
	 * @param myList
	 * @param mayATM
	 * @return
	 */
	public boolean addThongTinGiaoDich(String soTienRut, String soTheATM, String mayATM, String maKH) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO giao_dich(soTheATM,thoiGian,soTien,maMayATM,maKhachHang) VALUES (?,?,?,?,?)";
		PreparedStatement statement = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTheATM);
			statement.setString(2, dateFormat.format(date));
			statement.setString(3, soTienRut);
			statement.setString(4, mayATM);
			statement.setString(5, maKH);
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
	 * 
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

	/**
	 * Lấy All thông tin giao dịch
	 * 
	 * @return
	 */
	public ArrayList<GiaoDich> showAllThongTinGiaoDich() {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich ORDER BY maKhachHang ASC";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			GiaoDich giaoDich;
			KhachHang khachHang;
			MayATM mayATM;
			while (resultSet.next()) {
				giaoDich = new GiaoDich();
				khachHang = new KhachHang();
				mayATM = new MayATM();

				giaoDich.setMaGiaoDich(resultSet.getInt("maGiaoDich"));
				khachHang.setSoTheATM(resultSet.getString("soTheATM"));
				giaoDich.setThoiGian(resultSet.getString("thoiGian"));
				giaoDich.setSoTien(resultSet.getString("soTien"));
				mayATM.setMaMay(resultSet.getString("maMayATM"));
				khachHang.setMaKH(resultSet.getString("maKhachHang"));

				giaoDich.setKhachHang(khachHang);
				giaoDich.setMayATM(mayATM);
				myList.add(giaoDich);

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
	 * Kiểm tra khách hàng đã giao dịch chưa
	 * @param maKH
	 * @return
	 */
	public boolean kiemTraMaKHDaGiaoDichChua(String maKH) {
		boolean kiemTra = false;
		String sql = "SELECT * FROM giao_dich";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				if (maKH.equals(resultSet.getString("maKhachHang"))) {
					kiemTra = true;
				}
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
	 * báo cáo giao dịch khách hàng theo mã khách hàng va date
	 * 
	 * @param maKH
	 * @param ngayBatDau
	 * @param ngayKetThuc
	 * @return
	 */
	public ArrayList<GiaoDich> showGiaoDichTheoMaKHAnDate(String maKH, String ngayBatDau, String ngayKetThuc) {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich WHERE maKhachHang = ? AND DATE(thoiGian) BETWEEN ? AND ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maKH);
			statement.setString(2, ngayBatDau);
			statement.setString(3, ngayKetThuc);
			ResultSet resultSet = statement.executeQuery();
			GiaoDich giaoDich;
			KhachHang khachHang;
			MayATM mayATM;
			while (resultSet.next()) {
				giaoDich = new GiaoDich();
				khachHang = new KhachHang();
				mayATM = new MayATM();

				khachHang.setSoTheATM(resultSet.getString("soTheATM"));
				giaoDich.setThoiGian(resultSet.getString("thoiGian"));
				giaoDich.setSoTien(resultSet.getString("soTien"));
				mayATM.setMaMay(resultSet.getString("maMayATM"));

				giaoDich.setKhachHang(khachHang);
				giaoDich.setMayATM(mayATM);
				myList.add(giaoDich);

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
