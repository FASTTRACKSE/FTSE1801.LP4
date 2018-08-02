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
 * Báo Cáo DAO
 * 
 * @author SonVD and HungHK
 *
 */
public class BaoCaoDAO {
	Connection conn;

	/**
	 * Báo cáo danh sách khách hàng theo quận
	 * 
	 * @param tenQuan
	 * @return list
	 */
	public ArrayList<KhachHang> reportDSKHQuan(String tenQuan) {
		String sql = "SELECT khachhang.MaKH, khachhang.TenKH,phuong.tenPhuong as Phuong, District.tenQuan as Quan FROM khachhang INNER JOIN phuong ON khachhang.maPhuong = phuong.maPhuong INNER JOIN quan as District ON khachhang.maQuan = District.maQuan WHERE District.tenQuan = ?";
		conn = DatabaseUltil.getConnection();
		KhachHang khachHang;
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tenQuan);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKhachHang(resultSet.getString("MaKH"));
				khachHang.setNameKhachHang(resultSet.getString("TenKH"));
				khachHang.setTenQuan(resultSet.getString("Quan"));
				khachHang.setTenPhuong(resultSet.getString("Phuong"));

				list.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Lấy danh sách phường
	 * 
	 * @return list
	 */
	public ArrayList<Phuong> getAllPhuong() {
		String sql = "SELECT  `tenPhuong` FROM `phuong`";
		conn = DatabaseUltil.getConnection();
		ArrayList<Phuong> list = new ArrayList<Phuong>();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
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
	 * Báo cáo danh sách khách hàng theo phường
	 * 
	 * @param tenPhuong
	 * @return list
	 */
	public ArrayList<KhachHang> reportDSKHPhuong(String tenPhuong) {
		String sql = "SELECT khachhang.MaKH, khachhang.TenKH,phuong.tenPhuong as Phuong, District.tenQuan as Quan FROM khachhang INNER JOIN phuong ON khachhang.maPhuong = phuong.maPhuong INNER JOIN quan as District ON khachhang.maQuan = District.maQuan WHERE Phuong.tenPhuong = ?";
		conn = DatabaseUltil.getConnection();
		KhachHang khachHang;
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tenPhuong);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKhachHang(resultSet.getString("MaKH"));
				khachHang.setNameKhachHang(resultSet.getString("TenKH"));
				khachHang.setTenQuan(resultSet.getString("Quan"));
				khachHang.setTenPhuong(resultSet.getString("Phuong"));

				list.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Lấy giá tiền từ database
	 * 
	 * @return list
	 */
	public ArrayList<Integer> laySoTien() {
		String sql = "SELECT * FROM giabanledien";
		conn = DatabaseUltil.getConnection();
		ArrayList<Integer> list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(resultSet.getInt("giaThanh"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

	/**
	 * Danh sách khách hàng tăng dần theo mã công tơ và chỉ số công tơ
	 * 
	 * @return list
	 */
	public ArrayList<KhachHang> DSKhachHang() {
		String sql = "SELECT khachhang.MaKH, khachhang.TenKH,khachhang.diaChi,phuong.tenPhuong, District.tenQuan, cong_to_dien.maCongToDien,bienlai.chuKyNhap ,bienlai.chiSoCongTo FROM khachhang LEFT JOIN phuong ON khachhang.maPhuong = phuong.maPhuong LEFT JOIN quan as District ON khachhang.maQuan = District.maQuan LEFT JOIN bienlai as BienLai ON khachhang.maCongToDien = BienLai.maCongToDien LEFT JOIN cong_to_dien ON khachhang.maCongToDien = cong_to_dien.maCongToDien  ORDER BY cong_to_dien.maCongToDien, bienlai.chiSoCongTo ASC";
		conn = DatabaseUltil.getConnection();
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			KhachHang khachHang;
			CongToDien congToDien;
			BienLai bienLai;
			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKhachHang(resultSet.getString("khachhang.MaKH"));
				khachHang.setNameKhachHang(resultSet.getString("khachhang.TenKH"));
				khachHang.setAddress(resultSet.getString("khachhang.diaChi"));

				congToDien = new CongToDien();
				congToDien.setMaCongTo(resultSet.getString("cong_to_dien.maCongToDien"));
				khachHang.setTenPhuong(resultSet.getString("phuong.tenPhuong"));
				khachHang.setTenQuan(resultSet.getString("District.tenQuan"));
				bienLai = new BienLai();
				bienLai.setChuKyNhap(resultSet.getString("bienlai.chuKyNhap"));
				bienLai.setChiSoCongTo(resultSet.getString("bienlai.chiSoCongTo"));
				khachHang.setMaCongTo(congToDien);
				khachHang.setBienLai(bienLai);

				list.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return list;
	}

}
