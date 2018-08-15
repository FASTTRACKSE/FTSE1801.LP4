package quanly_thuvien.model.dao;

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
     /**
      * Giao dịch mượn sách
      * @param ngay
      * @param maThanhVien
      * @param maSach
      * @param maGD
      * @return
      */
	public boolean MuonSach(String ngay, int maThanhVien, int maSach,int maGD) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `muon_tra_sach`(`MaGiaoDich`,`NgayMuon`, `MaThanhVien`, `MaSach`, `tinhTrang`) VALUES (?,?,?,?,\"Đang Mượn\")";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, maGD);
			statement.setString(2, ngay);
			statement.setInt(3, maThanhVien);
			statement.setInt(4, maSach);

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
	 * Thay đổi số lượng sách sau khi mượn
	 * @param maSach
	 * @return
	 */
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
	/**
	 * Thay đổi số lượng sách sau khi trả
	 * @param maSach
	 * @return
	 */
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
	/**
	 * Giao dịch trả sách
	 * @param muonTra
	 * @return
	 */
	public boolean TraSach(muon_TraSach muonTra) {
		boolean statusExecute = false;
		String sql = "UPDATE `muon_tra_sach` SET `NgayTra`=?,`tinhTrang`=\"Đã Trả\" WHERE muon_tra_sach.MaThanhVien = ? AND muon_tra_sach.MaSach = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, muonTra.getNgayTra());
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
				if (tenTV.equals(result.getString("MaThanhVien"))) {
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
		String sql = "SELECT muon_tra_sach.MaGiaoDich, muon_tra_sach.NgayMuon,muon_tra_sach.NgayTra, muon_tra_sach.tinhTrang,thanh_vien.MaThanhVien, thanh_vien.tenThanhVien,sach.MaSach, sach.TenSach FROM `muon_tra_sach` INNER JOIN thanh_vien ON muon_tra_sach.MaThanhVien = thanh_vien.MaThanhVien INNER JOIN sach ON muon_tra_sach.MaSach = sach.MaSach";
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
				muonTra.setNgayTra(result.getString("NgayTra"));
				quanly = new QuanLy_BanDoc();
				quanly.setMaThanhVien(""+result.getString("MaThanhVien"));
				quanly.setTenThanhVien(result.getString("tenThanhVien"));
				muonTra.setMaThanhVien(quanly);
				quanlySach = new QuanLySach();
				quanlySach.setMaSach(""+result.getString("MaSach"));
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
	public boolean kiemTraSoLuong(int MaSach) {
		boolean kiem = false;
		String sql = "SELECT * FROM `sach` WHERE sach.MaSach = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, MaSach);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (Integer.parseInt(result.getString("soLuongConLai"))>0) {
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
	 * Tìm Kiếm Danh Sách Theo Mã
	 */
	public ArrayList<muon_TraSach> getSeachByMaThanhVien(QuanLy_BanDoc quanlyBan) {
		String sql = "SELECT muon_tra_sach.MaGiaoDich, muon_tra_sach.NgayMuon,muon_tra_sach.NgayTra, muon_tra_sach.tinhTrang, thanh_vien.tenThanhVien, sach.TenSach FROM `muon_tra_sach` INNER JOIN thanh_vien ON muon_tra_sach.MaThanhVien = thanh_vien.MaThanhVien INNER JOIN sach ON muon_tra_sach.MaSach = sach.MaSach WHERE thanh_vien.MaThanhVien = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<muon_TraSach> listTraMuon = new ArrayList<muon_TraSach>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(quanlyBan.getMaThanhVien()));
			ResultSet result = statement.executeQuery();
			muon_TraSach muonTra;
			QuanLy_BanDoc quanly;
			QuanLySach quanlySach;
			while (result.next()) {
				muonTra = new muon_TraSach();
				muonTra.setMaGiaoDich("" + result.getInt("MaGiaoDich"));
				muonTra.setNgayMuon(result.getString("NgayMuon"));
				muonTra.setNgayTra(result.getString("NgayTra"));
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
	
	/**
	 * Lấy mã giao dịch
	 * 
	 * @return
	 */
	public int layMaGiaoDich() {
		int maGD = 0;
		String sql = "SELECT * FROM `muon_tra_sach` ORDER BY MaGiaoDich DESC LIMIT 1";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				maGD = result.getInt("MaGiaoDich");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);

		return maGD;
	}
	/**
	 * đối chiếu khi mượn sách.
	 * @param MaThanhVien
	 * @return
	 */
	public ArrayList<Integer> KiemTraTinhHinhMuon(int MaThanhVien) {
		String sql = "SELECT MaSach FROM `muon_tra_sach` WHERE MaThanhVien = ? AND tinhTrang = \"Đang Mượn\"";
		conn = DatabaseUtil.getConnect();
		ArrayList<Integer> listTraMuon = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, MaThanhVien);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				listTraMuon.add(result.getInt("MaSach"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return listTraMuon;

	}
	
}
