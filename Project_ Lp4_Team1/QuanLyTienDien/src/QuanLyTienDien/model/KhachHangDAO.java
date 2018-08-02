package QuanLyTienDien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyTienDien.model.entity.BienLai;
import QuanLyTienDien.model.entity.CongToDien;
import QuanLyTienDien.model.entity.KhachHang;
import QuanLyTienDien.model.entity.Phuong;
import QuanLyTienDien.model.entity.Quan;

/**
 * KHACH HANG DAO
 * 
 * @author SonVD and HungHK
 *
 */
public class KhachHangDAO {
	Connection conn;

	/**
	 * Lấy giá trị Quận từ database
	 * 
	 * @return list
	 */
	public ArrayList<Quan> getAllQuan() {
		String sql = "SELECT tenQuan FROM quan";
		conn = DatabaseUltil.getConnection();
		ArrayList<Quan> list = new ArrayList<Quan>();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Quan quan = new Quan();
				quan.setNameQuan(resultSet.getString("tenQuan"));

				list.add(quan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Lấy giá trị Phường từ database theo Tên Quận
	 * 
	 * @param tenQuan
	 * @return list
	 */
	public ArrayList<Phuong> getAllPhuong(String tenQuan) {
		String sql = "SELECT phuong.tenPhuong FROM `phuong` INNER JOIN quan ON phuong.maQuan = quan.maQuan WHERE quan.tenQuan = ?";
		conn = DatabaseUltil.getConnection();
		ArrayList<Phuong> list = new ArrayList<Phuong>();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tenQuan);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Phuong phuong = new Phuong();
				phuong.setNamePhuong(resultSet.getString("tenPhuong"));

				list.add(phuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Lấy danh sách khách hàng từ database
	 * 
	 * @return list
	 */
	public ArrayList<KhachHang> getAllKhachHang() {
		String sql = "SELECT khachhang.MaKH, khachhang.TenKH,khachhang.diaChi,phuong.tenPhuong as Phuong, District.tenQuan as Quan,khachhang.dienThoai,khachhang.email, CongToDien.maCongToDien AS MaCongTo FROM khachhang INNER JOIN phuong ON khachhang.maPhuong = phuong.maPhuong INNER JOIN quan as District ON khachhang.maQuan = District.maQuan INNER JOIN cong_to_dien as CongToDien ON khachhang.maCongToDien = CongToDien.maCongToDien";
		conn = DatabaseUltil.getConnection();
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			KhachHang khachHang;
			CongToDien congToDien;
			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKhachHang(resultSet.getString("MaKH"));
				khachHang.setNameKhachHang(resultSet.getString("TenKH"));
				khachHang.setAddress(resultSet.getString("diaChi"));
				khachHang.setPhone(resultSet.getString("dienThoai"));
				khachHang.setEmail(resultSet.getString("email"));

				khachHang.setTenQuan(resultSet.getString("Quan"));

				khachHang.setTenPhuong(resultSet.getString("Phuong"));

				congToDien = new CongToDien();
				congToDien.setMaCongTo(resultSet.getString("MaCongTo"));
				khachHang.setMaCongTo(congToDien);

				list.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Thêm khách hàng vào database
	 * 
	 * @param khachHang
	 * @return statusExecute
	 */
	public boolean addKhachHang(KhachHang khachHang) {
		boolean statusExecute = false;
		int[] ma = layMaPhuongVaMaQuan(khachHang.getTenPhuong());
		String sql = "INSERT INTO `khachhang` (`MaKH`, `TenKH`, `diaChi`, `maPhuong`, `maQuan`, `dienThoai`, `email`, `maCongToDien`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		conn = DatabaseUltil.getConnection();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getMaKhachHang());
			preparedStatement.setString(2, khachHang.getNameKhachHang());
			preparedStatement.setString(3, khachHang.getAddress());
			preparedStatement.setInt(4, ma[0]);
			preparedStatement.setInt(5, ma[1]);
			preparedStatement.setString(6, khachHang.getPhone());
			preparedStatement.setString(7, khachHang.getEmail());
			preparedStatement.setString(8, khachHang.getMaCongTo().getMaCongTo());

			if (preparedStatement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return statusExecute;
	}

	/**
	 * Tìm kiếm khách hàng theo tên Khách Hàng
	 * 
	 * @param khachHang
	 * @return list
	 */
	public ArrayList<KhachHang> searchMaKH(KhachHang khachHang) {
		String sql = "SELECT khachhang.MaKH, khachhang.TenKH,khachhang.diaChi,phuong.tenPhuong as Phuong, District.tenQuan as Quan,khachhang.dienThoai,khachhang.email, CongToDien.maCongToDien AS MaCongTo FROM khachhang INNER JOIN phuong ON khachhang.maPhuong = phuong.maPhuong INNER JOIN quan as District ON khachhang.maQuan = District.maQuan INNER JOIN cong_to_dien as CongToDien ON khachhang.maCongToDien = CongToDien.maCongToDien WHERE khachhang.TenKH LIKE ?";
		conn = DatabaseUltil.getConnection();
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + khachHang.getNameKhachHang() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			KhachHang khachHang1;
			CongToDien congToDien;
			while (resultSet.next()) {
				khachHang1 = new KhachHang();
				khachHang1.setMaKhachHang(resultSet.getString("MaKH"));
				khachHang1.setNameKhachHang(resultSet.getString("TenKH"));
				khachHang1.setAddress(resultSet.getString("diaChi"));
				khachHang1.setPhone(resultSet.getString("dienThoai"));
				khachHang1.setEmail(resultSet.getString("email"));

				khachHang1.setTenQuan(resultSet.getString("Quan"));

				khachHang1.setTenPhuong(resultSet.getString("Phuong"));

				congToDien = new CongToDien();
				congToDien.setMaCongTo(resultSet.getString("MaCongTo"));
				khachHang1.setMaCongTo(congToDien);

				list.add(khachHang1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Sửa thông tin khách hàng
	 * 
	 * @param khachHang
	 * @return statusExecute
	 */
	public boolean updateKhachHang(KhachHang khachHang) {
		boolean statusExecute = false;
		int[] ma = layMaPhuongVaMaQuan(khachHang.getTenPhuong());
		String sql = "UPDATE `khachhang` SET `TenKH`=?,`DiaChi`=?,`maPhuong`=?,`maQuan`=?,`DienThoai`=?,`Email`=?,`maCongToDien`=? WHERE MaKH =?";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getNameKhachHang());
			preparedStatement.setString(2, khachHang.getAddress());
			preparedStatement.setInt(3, ma[0]);
			preparedStatement.setInt(4, ma[1]);
			preparedStatement.setString(5, khachHang.getPhone());
			preparedStatement.setString(6, khachHang.getEmail());
			preparedStatement.setString(7, khachHang.getMaCongTo().getMaCongTo());
			preparedStatement.setString(8, khachHang.getMaKhachHang());

			if (preparedStatement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusExecute;
	}

	/**
	 * Xóa khách hàng theo tên
	 * 
	 * @param name
	 * @return statusExucute
	 */
	public boolean deleteKhachHang(String name) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		String sql = "DELETE FROM `khachhang` WHERE `TenKH` = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);

			if (preparedStatement.executeUpdate() > 0) {
				statusExucute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return statusExucute;
	}

	/**
	 * Lấy mã phường và quận
	 * 
	 * @param tenPhuong
	 * @return ma
	 */
	public int[] layMaPhuongVaMaQuan(String tenPhuong) {
		int[] ma = new int[2];
		String sql = "SELECT * FROM phuong INNER JOIN quan ON phuong.maQuan= quan.maQuan WHERE tenPhuong = ?";
		conn = DatabaseUltil.getConnection();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tenPhuong);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ma[0] = resultSet.getInt("phuong.maPhuong");
				ma[1] = resultSet.getInt("quan.maQuan");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return ma;
	}
}
