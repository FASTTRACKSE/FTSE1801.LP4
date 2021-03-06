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
	 * @param soTienRut
	 * @param soTK
	 * @param mayATM
	 * @param maKH
	 * @return
	 */
	public void addThongTinGiaoDich(String soTienRut, String soTK, String mayATM, String maKH) {
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO giao_dich(soTK,thoiGian,soTienThem,soTienRut,maMayATM,maKH) VALUES (?,?,?,?,?,?)";
		PreparedStatement statement = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			statement.setString(2, dateFormat.format(date));
			statement.setString(3, "0");
			statement.setString(4, soTienRut);
			statement.setString(5, mayATM);
			statement.setString(6, maKH);
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
	 * Thêm thông tin giao dịch khi thêm tiền tại ngân hàng
	 * @param soTienThem
	 * @param soTK
	 * @param maKH
	 * @return
	 */
	public void addThongTinGiaoDichKhiThemTienTaiNganHang(String soTienThem, String soTK, String maKH) {
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO giao_dich(soTK,thoiGian,soTienThem,soTienRut,maMayATM,maKH) VALUES (?,?,?,?,?,?)";
		PreparedStatement statement = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			statement.setString(2, dateFormat.format(date));
			statement.setString(3, soTienThem);
			statement.setString(4, "0");
			statement.setString(5, "Tại ngân hàng");
			statement.setString(6, maKH);
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
	 * Thêm thông tin giao dịch khi thêm tiền rút tiền tại ngân hàng
	 * @param soTienRut
	 * @param soTK
	 * @param maKH
	 * @return
	 */
	public void addThongTinGiaoDichKhiRutTienTaiNganHang(String soTienRut, String soTK, String maKH) {
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO giao_dich(soTK,thoiGian,soTienThem,soTienRut,maMayATM,maKH) VALUES (?,?,?,?,?,?)";
		PreparedStatement statement = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			statement.setString(2, dateFormat.format(date));
			statement.setString(3, "0");
			statement.setString(4, soTienRut);
			statement.setString(5, "Tại ngân hàng");
			statement.setString(6, maKH);
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

	/**
	 * Lấy mã giao dịch
	 * 
	 * @return
	 */
	public GiaoDich layMaGiaoDich() {
		GiaoDich giaoDich = null;
		KhachHang khachHang = null;
		MayATM mayATM = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `giao_dich` ORDER BY `giao_dich`.`thoiGian` DESC LIMIT 1";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				giaoDich = new GiaoDich();
				khachHang = new KhachHang();
				mayATM = new MayATM();
				
				khachHang.setSoTK(resultSet.getString("soTK"));
				mayATM.setMaMay(resultSet.getString("maMayATM"));
				giaoDich.setMaGiaoDich(resultSet.getInt("maGiaoDich"));
				giaoDich.setThoiGian(resultSet.getString("thoiGian"));
				giaoDich.setSoTienRut(resultSet.getString("soTienRut"));
				giaoDich.setSoTienThem(resultSet.getString("soTienThem"));
				giaoDich.setKhachHang(khachHang);
				giaoDich.setMayATM(mayATM);
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
		return giaoDich;
	}

	/**
	 * Lấy All thông tin giao dịch
	 * 
	 * @return
	 */
	public ArrayList<GiaoDich> showAllThongTinGiaoDich() {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich ORDER BY maKH ASC";
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
				khachHang.setMaKH(""+resultSet.getString("maKH"));
				giaoDich.setThoiGian(resultSet.getString("thoiGian"));
				giaoDich.setSoTienRut(resultSet.getString("soTienRut"));
				giaoDich.setSoTienThem(resultSet.getString("soTienThem"));
				mayATM.setMaMay(resultSet.getString("maMayATM"));

				giaoDich.setKhachHang(khachHang);
				giaoDich.setMayATM(mayATM);
				myList.add(giaoDich);

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
				if (maKH.equals(resultSet.getString("maKH"))) {
					kiemTra = true;
				}
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
	 * báo cáo giao dịch khách hàng theo mã khách hàng và ngày giao dịch
	 * 
	 * @param maKH
	 * @param ngayBatDau
	 * @param ngayKetThuc
	 * @return
	 */
	public ArrayList<GiaoDich> showGiaoDichTheoMaKHAnDate(String maKH, String ngayBatDau, String ngayKetThuc) {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich WHERE maKH = ? AND DATE(thoiGian) BETWEEN ? AND ?";
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

				khachHang.setSoTK(resultSet.getString("soTK"));
				giaoDich.setThoiGian(resultSet.getString("thoiGian"));
				giaoDich.setSoTienRut(resultSet.getString("soTienRut"));
				giaoDich.setSoTienThem(resultSet.getString("soTienThem"));
				mayATM.setMaMay(resultSet.getString("maMayATM"));

				giaoDich.setKhachHang(khachHang);
				giaoDich.setMayATM(mayATM);
				myList.add(giaoDich);

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
	 * báo cáo giao dịch khách hàng theo địa chỉ và ngày giao dịch
	 * 
	 * @param tenPhuong
	 * @param ngayBatDau
	 * @param ngayKetThuc
	 * @return
	 */
	public ArrayList<GiaoDich> showGiaoDichTheoDiaChiAndDate(String tenPuong,String ngayBatDau, String ngayKetThuc) {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich LEFT JOIN may_atm ON giao_dich.maMayATM = may_atm.maMayATM LEFT JOIN phuong ON may_atm.maPhuong = phuong.maPhuong LEFT JOIN quan ON phuong.maQuan = quan.maQuan LEFT JOIN the_atm ON giao_dich.soTK = the_atm.soTK WHERE phuong.tenPhuong = ? AND giao_dich.maMayATM != 'Tại ngân hàng' AND DATE(thoiGian) BETWEEN ? AND ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenPuong);
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
				
				giaoDich.setMaGiaoDich(resultSet.getInt("giao_dich.maGiaoDich"));
				khachHang.setSoTheATM(resultSet.getString("the_atm.soTheATM"));
				khachHang.setMaKH(""+resultSet.getInt("giao_dich.maKH"));
				giaoDich.setKhachHang(khachHang);
				giaoDich.setThoiGian(resultSet.getString("giao_dich.thoiGian"));
				giaoDich.setSoTienRut(resultSet.getString("giao_dich.soTienRut"));
				mayATM.setMaMay(resultSet.getString("giao_dich.maMayATM"));
				giaoDich.setMayATM(mayATM);
				
				myList.add(giaoDich);

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
	 * lấy toàn bộ thông tin giao dịch của máy ATM
	 * 
	 * @return
	 */
	public ArrayList<GiaoDich> showAllGiaoDichTheoCuaMayATM() {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich LEFT JOIN may_atm ON giao_dich.maMayATM = may_atm.maMayATM LEFT JOIN phuong ON may_atm.maPhuong = phuong.maPhuong LEFT JOIN quan ON phuong.maQuan = quan.maQuan LEFT JOIN the_atm ON giao_dich.soTK = the_atm.soTK WHERE giao_dich.maMayATM != 'Tại ngân hàng'";
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
				
				giaoDich.setMaGiaoDich(resultSet.getInt("giao_dich.maGiaoDich"));
				khachHang.setSoTheATM(resultSet.getString("the_atm.soTheATM"));
				khachHang.setMaKH(""+resultSet.getInt("giao_dich.maKH"));
				giaoDich.setKhachHang(khachHang);
				giaoDich.setThoiGian(resultSet.getString("giao_dich.thoiGian"));
				giaoDich.setSoTienRut(resultSet.getString("giao_dich.soTienRut"));
				mayATM.setMaMay(resultSet.getString("giao_dich.maMayATM"));
				giaoDich.setMayATM(mayATM);
				
				myList.add(giaoDich);

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
	 * báo cáo giao dịch khách hàng theo mã máy và ngày giao dịch
	 * 
	 * @param maMay
	 * @param ngayBatDau
	 * @param ngayKetThuc
	 * @return
	 */
	public ArrayList<GiaoDich> showGiaoDichTheoMaMayAndDate(String maMay, String ngayBatDau, String ngayKetThuc) {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		String sql = "SELECT * FROM giao_dich LEFT JOIN may_atm ON giao_dich.maMayATM = may_atm.maMayATM LEFT JOIN phuong ON may_atm.maPhuong = phuong.maPhuong LEFT JOIN quan ON phuong.maQuan = quan.maQuan LEFT JOIN the_atm ON giao_dich.soTK = the_atm.soTK  WHERE giao_dich.maMayATM = ? AND DATE(thoiGian) BETWEEN ? AND ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maMay);
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
				
				giaoDich.setMaGiaoDich(resultSet.getInt("giao_dich.maGiaoDich"));
				khachHang.setSoTheATM(resultSet.getString("the_atm.soTheATM"));
				khachHang.setMaKH(""+resultSet.getInt("giao_dich.maKH"));
				giaoDich.setKhachHang(khachHang);
				giaoDich.setThoiGian(resultSet.getString("giao_dich.thoiGian"));
				giaoDich.setSoTienRut(resultSet.getString("giao_dich.soTienRut"));
				mayATM.setMaMay(resultSet.getString("giao_dich.maMayATM"));
				giaoDich.setMayATM(mayATM);
				
				myList.add(giaoDich);
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
	 * Xóa thông tin giao dịch theo mã máy ATM
	 * @param maMay
	 */
	public void xoaThongTinGDTheoMaMay(String maMay) {
		String sql = "DELETE FROM giao_dich WHERE maMayATM = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maMay);
			if (statement.executeUpdate() > 0) {
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
	}
	

	/**
	 * Xóa thông tin giao dịch theo maKH
	 * @param maKH
	 */
	public void xoaThongTinGDTheoMaKH(String maKH) {
		String sql = "DELETE FROM giao_dich WHERE MaKH = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maKH);
			if (statement.executeUpdate() > 0) {
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
	}
}
