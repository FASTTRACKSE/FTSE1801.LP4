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
						giaoDich.setMaGiaoDich(resultSet.getString("maGiaoDich"));

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
					giaoDich.setMaGiaoDich(resultSet.getString("maGiaoDich"));

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

	public static void main(String[] args) {
		GiaoDichDAO dao = new GiaoDichDAO();

//		if (dao.addThongTinGiaoDich("100000", "2583691477896546", "May005")) {
//			System.out.println("add Thành công");
//		}else {
//			System.out.println("thất bại");
//		}
		 ArrayList<GiaoDich> myList = dao.showBaoCaoKhachHang("Hòa An", "Cẩm Lệ");

		 for (int i = 0; i < myList.size(); i++) {
		 System.out.println(myList.get(i).getKhachHang().getMaKH());
		 System.out.println(myList.get(i).getKhachHang().getTenKH());
		 System.out.println(myList.get(i).getKhachHang().getDiaChi());
		 System.out.println(myList.get(i).getKhachHang().getPhuong());
		 System.out.println(myList.get(i).getKhachHang().getQuan());
		 System.out.println(myList.get(i).getKhachHang().getSoDT());
		 System.out.println(myList.get(i).getKhachHang().getEmail());
		 System.out.println(myList.get(i).getKhachHang().getSoTheATM());
		 System.out.println(myList.get(i).getKhachHang().getSoTK());
		 System.out.println(myList.get(i).getSoTien());
		 System.out.println("");
		 }
	}
}
