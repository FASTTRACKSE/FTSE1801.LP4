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
	 * Hiển thị báo cáo khách hàng
	 * 
	 * @param phuong
	 * @param quan
	 * @return
	 */
	public ArrayList<GiaoDich> showBaoCaoKhachHang(String phuong, String quan) {
		ArrayList<GiaoDich> myList = new ArrayList<GiaoDich>();
		boolean kiemTra = false;
		double allTien = 0.0;
		String sql = "SELECT * FROM khach_hang LEFT JOIN giao_dich ON khach_hang.soTheATM = giao_dich.soTheATM WHERE phuong = ? AND quan = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, phuong);
			statement.setString(2, quan);
			ResultSet resultSet = statement.executeQuery();
			GiaoDich giaoDich;
			KhachHang khachHang;
			while (resultSet.next()) {
				giaoDich = new GiaoDich();

				for (int i = 0; i < myList.size(); i++) {
					if (myList.get(i).getKhachHang().getSoTheATM().equals(resultSet.getString("giao_dich.soTheATM"))) {
						allTien = Double.parseDouble(myList.get(i).getSoTien());
						allTien = allTien + Double.parseDouble(resultSet.getString("soTien"));
						kiemTra = true;
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

						giaoDich.setKhachHang(khachHang);
						giaoDich.setMaGiaoDich(resultSet.getInt("maGiaoDich"));

						giaoDich.setSoTien("" + allTien);

						myList.set(i, giaoDich);
						break;
					} else {
						kiemTra = false;
					}
				}

				if (!kiemTra) {

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

					giaoDich.setKhachHang(khachHang);
					giaoDich.setMaGiaoDich(resultSet.getInt("maGiaoDich"));

					giaoDich.setSoTien(resultSet.getString("soTien"));
					myList.add(giaoDich);
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
		return myList;
	}

	/**
	 * Thêm thông tin giao dịch
	 * @param soTienRut
	 * @param myList
	 * @param mayATM
	 * @return
	 */
	public boolean addThongTinGiaoDich(String soTienRut, String soTheATM, String mayATM) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO giao_dich(soTheATM,thoiGian,soTien,maMayATM) VALUES (?,?,?,?)";
		PreparedStatement statement = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTheATM);
			statement.setString(2, dateFormat.format(date));
			statement.setString(3, soTienRut);
			statement.setString(4, mayATM);
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
	 * Update thông tin tiền trong máy ATM khi rút tiền
	 * 
	 * @param myList, soTien
	 * @return
	 */
	public boolean updateMayATM(MayATM mayATM,String soTien) {
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
	 * Lấy mã giao dịch
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
}
