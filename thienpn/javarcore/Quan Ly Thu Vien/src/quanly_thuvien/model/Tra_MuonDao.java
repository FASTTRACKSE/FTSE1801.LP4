package quanly_thuvien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import quanly_thuvien.model.entity.NhaXuatBan;
import quanly_thuvien.model.entity.QuanLySach;
import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.muon_TraSach;

public class Tra_MuonDao {
	Connection conn;

	public boolean MuonSach(String ngay, int maThanhVien, int maSach) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `muon_tra_sach`(`NgayMuon`, `MaThanhVien`, `MaSach`, `tinhTrang`) VALUES (?,?,?,\"Đang Mượn\")";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ngay);
			statement.setInt(2, maThanhVien);
			statement.setInt(3, maSach);

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	
	public boolean UpDateSoLuongSach(int maSach) {
		boolean statusExecute = false;
		String sql = "UPDATE `sach` SET `soLuongConLai` = soLuongConLai-1 WHERE sach.MaSach = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, maSach);
			

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	
	public boolean UpDateSoLuongSachTra(int maSach) {
		boolean statusExecute = false;
		String sql = "UPDATE `sach` SET `soLuongConLai` = soLuongConLai+1 WHERE sach.MaSach = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, maSach);
			

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	//trả sách
	public boolean TraSach(muon_TraSach muonTra) {
		boolean statusExecute = false;
		String sql = "UPDATE `muon_tra_sach` SET `NgayMuon`=?,`tinhTrang`=\"Đã Trả\" WHERE muon_tra_sach.MaThanhVien = ? AND muon_tra_sach.MaSach = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, muonTra.getNgayMuon());
			statement.setInt(2, Integer.parseInt(muonTra.getMaThanhVien().getMaThanhVien()));
			statement.setInt(3, Integer.parseInt(muonTra.getMaSach().getMaSach()));
			

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	/**
	 * Kiểm tra thành viên có tồn tại ko
	 * 
	 * @param tenTV
	 * @return
	 */
	public boolean kiemTra(String tenTV) {
		boolean kiem = false;
		String sql = "SELECT * FROM `thanh_vien`";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				if (tenTV.equals(result.getString("maThanhVien"))) {
					kiem = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);

		return kiem;
	}
	
	

	/**
	 * Kiểm tra sách có tồn tại ko
	 * 
	 * @param tenSach
	 * @return
	 */
	public boolean kiemTraSach(String tenSach) {
		boolean kiem = false;
		String sql = "SELECT * FROM `sach`";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (tenSach.equals(result.getString("MaSach"))) {
					kiem = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);

		return kiem;
	}
	
	

	/**
	 * Lấy mã thành viên
	 * 
	 * @param tenTV
	 * @return
	 */
	public int layMaThanhVien(String tenTV) {
		int maTV = 0;
		String sql = "SELECT * FROM `thanh_vien`";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (tenTV.equals(result.getString("tenThanhVien"))) {
					maTV = result.getInt("maThanhVien");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);

		return maTV;
	}

	/**
	 * Lấy mã Sách.
	 * 
	 * @param tenSach
	 * @return
	 */
	public int layMaSach(String tenSach) {
		int maSach = 0;
		String sql = "SELECT * FROM `sach`";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (tenSach.equals(result.getString("TenSach"))) {
				maSach = result.getInt("MaSach");
				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);

		return maSach;
	}
	

	/**
	 * List Mượn Trả Sách.
	 * 
	 */

	public ArrayList<muon_TraSach> getAllMuon_Tra() {
		String sql = "SELECT muon_tra_sach.MaGiaoDich, muon_tra_sach.NgayMuon, muon_tra_sach.tinhTrang, thanh_vien.tenThanhVien, sach.TenSach FROM `muon_tra_sach` INNER JOIN thanh_vien ON muon_tra_sach.MaThanhVien = thanh_vien.MaThanhVien INNER JOIN sach ON muon_tra_sach.MaSach = sach.MaSach";
		conn = DatabaseUtil.getConnect();
		ArrayList<muon_TraSach> listTraMuon = new ArrayList<muon_TraSach>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			muon_TraSach muonTra;
			QuanLy_BanDoc quanly;
			QuanLySach quanlySach;
			while (result.next()) {
				muonTra = new muon_TraSach();
				muonTra.setMaGiaoDich("" + result.getInt("MaGiaoDich"));
				muonTra.setNgayMuon(result.getString("NgayMuon"));
				quanly = new QuanLy_BanDoc();
				quanly.setTenThanhVien(result.getString("tenThanhVien"));
				muonTra.setMaThanhVien(quanly);
				quanlySach = new QuanLySach();
				quanlySach.setTenSach(result.getString("TenSach"));
				muonTra.setMaSach(quanlySach);
				muonTra.setTinhTrang(result.getString("tinhTrang"));
				listTraMuon.add(muonTra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return listTraMuon;

	}
	/*
	 * Kiểm tra số lượng
	 * trong kho
	 * 
	 * 
	 */
//	public boolean KiemTraSoluong() {
//		boolean kiemtra = false;
//		String sql = "";
//		conn = DatabaseUtil.getConnect();
//		try {
//			PreparedStatement statement = conn.prepareStatement(sql);
//			ResultSet result = statement.executeQuery();
//			while (result.next()) {
//				if () {
//					kiemtra = true;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DatabaseUtil.disConnect(conn);
//
//		return kiemtra;
//	}
}
