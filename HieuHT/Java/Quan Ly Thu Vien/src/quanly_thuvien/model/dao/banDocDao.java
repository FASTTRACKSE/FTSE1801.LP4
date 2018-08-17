package quanly_thuvien.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly_thuvien.model.entity.NhaXuatBan;
import quanly_thuvien.model.entity.QuanLySach;
import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.ThanhPho;
import quanly_thuvien.model.entity.TheLoaiSach;
import quanly_thuvien.model.entity.muon_TraSach;

public class banDocDao {
	Connection conn;

	/**
	 * Lấy dữ liệu từ thành phố
	 * 
	 * @return
	 */
	public ArrayList<ThanhPho> getCiTy1() {
		String sql = "SELECT `tenThanhPho` FROM `tinh_thanhpho`";
		conn = DatabaseUtil.getConnect();
		ArrayList<ThanhPho> list = new ArrayList<ThanhPho>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ThanhPho thanhPho = new ThanhPho();
				thanhPho.setTenThanhPho(result.getString("tenThanhPho"));
				list.add(thanhPho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}

	public ArrayList<muon_TraSach> getAllBaoCaoBanDoc() {
		String sql = "SELECT * FROM muon_tra_sach LEFT JOIN thanh_vien ON thanh_vien.MaThanhVien = muon_tra_sach.MaThanhVien LEFT JOIN quan_huyen ON thanh_vien.maQuanHuyen = quan_huyen.maQuanHuyen LEFT JOIN tinh_thanhpho ON thanh_vien.maThanhPho = tinh_thanhpho.maThanhPho LEFT JOIN phuong_xa ON thanh_vien.maPhuongXa = phuong_xa.maPhuongXa LEFT JOIN sach ON sach.MaSach = muon_tra_sach.MaSach";
		conn = DatabaseUtil.getConnect();
		ArrayList<muon_TraSach> list = new ArrayList<muon_TraSach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			QuanLy_BanDoc quanLyBanDoc2;
			QuanLySach quanLySach2;
			muon_TraSach muontra;
			while (result.next()) {
				quanLyBanDoc2 = new QuanLy_BanDoc();
				quanLySach2 = new QuanLySach();
				muontra = new muon_TraSach();
				quanLyBanDoc2.setMaThanhVien("" + result.getInt("MaThanhVien"));
				quanLyBanDoc2.setTenThanhVien(result.getString("tenThanhVien"));
				quanLyBanDoc2.setMaThanhPho(result.getString("tenThanhPho"));
				quanLyBanDoc2.setMaQuanHuyen(result.getString("tenQuanHuyen"));
				quanLyBanDoc2.setMaPhuongXa(result.getString("tenPhuongXa"));
				quanLySach2.setTenSach(result.getString("TenSach"));
				muontra.setTinhTrang(result.getString("muon_tra_sach.tinhTrang"));
				muontra.setMaThanhVien(quanLyBanDoc2);
				muontra.setMaSach(quanLySach2);

				list.add(muontra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}

	/**
	 * Danh sách bạn đọc theo thành phố.
	 * 
	 * @param tenThanhPho
	 * @return
	 */
	public ArrayList<muon_TraSach> getBaoCaoBanDoc(String tenThanhPho) {
		String sql = "SELECT * FROM muon_tra_sach LEFT JOIN thanh_vien ON thanh_vien.MaThanhVien = muon_tra_sach.MaThanhVien LEFT JOIN quan_huyen ON thanh_vien.maQuanHuyen = quan_huyen.maQuanHuyen LEFT JOIN tinh_thanhpho ON thanh_vien.maThanhPho = tinh_thanhpho.maThanhPho LEFT JOIN phuong_xa ON thanh_vien.maPhuongXa = phuong_xa.maPhuongXa LEFT JOIN sach ON sach.MaSach = muon_tra_sach.MaSach WHERE tinh_thanhpho.tenThanhPho = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<muon_TraSach> list = new ArrayList<muon_TraSach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenThanhPho);
			ResultSet result = statement.executeQuery();

			QuanLy_BanDoc quanLyBanDoc2;
			QuanLySach quanLySach2;
			muon_TraSach muontra;
			while (result.next()) {
				quanLyBanDoc2 = new QuanLy_BanDoc();
				quanLySach2 = new QuanLySach();
				muontra = new muon_TraSach();
				quanLyBanDoc2.setMaThanhVien("" + result.getInt("MaThanhVien"));
				quanLyBanDoc2.setTenThanhVien(result.getString("tenThanhVien"));
				quanLyBanDoc2.setMaThanhPho(result.getString("tenThanhPho"));
				quanLyBanDoc2.setMaQuanHuyen(result.getString("tenQuanHuyen"));
				quanLyBanDoc2.setMaPhuongXa(result.getString("tenPhuongXa"));
				quanLySach2.setTenSach(result.getString("TenSach"));
				muontra.setTinhTrang(result.getString("muon_tra_sach.tinhTrang"));
				muontra.setMaThanhVien(quanLyBanDoc2);
				muontra.setMaSach(quanLySach2);

				list.add(muontra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}

	/**
	 * Danh sách bạn đọc theo mã thành viên
	 * 
	 * @param muontra1
	 * @return
	 */
	public ArrayList<muon_TraSach> getBaoCaoBanDocByMa(muon_TraSach muontra1) {
		String sql = "SELECT * FROM muon_tra_sach LEFT JOIN thanh_vien ON thanh_vien.MaThanhVien = muon_tra_sach.MaThanhVien LEFT JOIN quan_huyen  ON thanh_vien.maQuanHuyen = quan_huyen.maQuanHuyen LEFT JOIN tinh_thanhpho ON thanh_vien.maThanhPho = tinh_thanhpho.maThanhPho LEFT JOIN phuong_xa ON thanh_vien.maPhuongXa = phuong_xa.maPhuongXa LEFT JOIN sach ON sach.MaSach = muon_tra_sach.MaSach WHERE thanh_vien.MaThanhVien = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<muon_TraSach> list = new ArrayList<muon_TraSach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(muontra1.getMaThanhVien().getMaThanhVien()));
			ResultSet result = statement.executeQuery();

			QuanLy_BanDoc quanLyBanDoc2;
			QuanLySach quanLySach2;
			muon_TraSach muontra;
			while (result.next()) {
				quanLyBanDoc2 = new QuanLy_BanDoc();
				quanLySach2 = new QuanLySach();
				muontra = new muon_TraSach();
				quanLyBanDoc2.setMaThanhVien("" + result.getInt("MaThanhVien"));
				quanLyBanDoc2.setTenThanhVien(result.getString("tenThanhVien"));
				quanLyBanDoc2.setMaThanhPho(result.getString("tenThanhPho"));
				quanLyBanDoc2.setMaQuanHuyen(result.getString("tenQuanHuyen"));
				quanLyBanDoc2.setMaPhuongXa(result.getString("tenPhuongXa"));
				quanLySach2.setTenSach(result.getString("TenSach"));
				muontra.setTinhTrang(result.getString("muon_tra_sach.tinhTrang"));
				muontra.setMaThanhVien(quanLyBanDoc2);
				muontra.setMaSach(quanLySach2);

				list.add(muontra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}

	/**
	 * Danh sách đầu sách theo nhà xuất bản
	 * 
	 */
	public ArrayList<NhaXuatBan> getBaoCaoNhaXuatBan() {
		String sql = "SELECT `NhaXuatBan` FROM `nhaxuatban`";
		conn = DatabaseUtil.getConnect();
		ArrayList<NhaXuatBan> list = new ArrayList<NhaXuatBan>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				NhaXuatBan nhaXuatBan = new NhaXuatBan();
				nhaXuatBan.setNhaXuatBan(result.getString("nhaXuatBan"));
				list.add(nhaXuatBan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;
	}

	public ArrayList<TheLoaiSach> getBaoCaoTheLoaiSach(String NhaXuatBan) {
		String sql = "SELECT theloaisach.TheLoaiSach FROM nhaxuatban_theloaisach INNER JOIN theloaisach ON theloaisach.maTheLoaiSach = nhaxuatban_theloaisach.maTheLoaiSach INNER JOIN nhaxuatban ON nhaxuatban.maNhaXuatBan = nhaxuatban_theloaisach.maNhaXuatBan WHERE nhaxuatban.NhaXuatBan = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<TheLoaiSach> list = new ArrayList<TheLoaiSach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, NhaXuatBan);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				TheLoaiSach theLoaiSach = new TheLoaiSach();
				theLoaiSach.setTheLoaiSach(result.getString("TheLoaiSach"));
				list.add(theLoaiSach);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;
	}

}
