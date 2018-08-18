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
import quanly_thuvien.model.entity.TheLoaiSach;


/**
 * Lấy dữ liệu nhà xuất bản
 * @author TGDD
 *
 */
public class SachDao {
	Connection conn;
	public ArrayList<NhaXuatBan> getNhaXuatBan(){
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
	
	/**
	 * lấy dữ liệu thể loại sách
	 * @param NhaXuatBan
	 * @return
	 */
	public ArrayList<TheLoaiSach> getTheLoaiSach(String NhaXuatBan){
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
	
	
	public ArrayList<QuanLySach> getAllSach(){
		String sql = "SELECT sach.MaSach,sach.TenSach,sach.TacGia,nhaxuatban.NhaXuatBan,theloaisach.TheLoaiSach,sach.NamXuatBan,sach.soLuong,sach.soLuongConLai FROM `sach` INNER JOIN theloaisach ON sach.TheLoaiSach = theloaisach.TheLoaiSach INNER JOIN nhaxuatban ON sach.NhaXuatBan = nhaxuatban.NhaXuatBan";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuanLySach> list = new ArrayList<QuanLySach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			QuanLySach quanlySach; 
			
			while (result.next()) {
				quanlySach = new QuanLySach();
				quanlySach.setMaSach("" + result.getInt("MaSach"));
				quanlySach.setTenSach(result.getString("TenSach"));
				quanlySach.setTacGia(result.getString("TacGia"));
				quanlySach.setNhaXuatBan(result.getString("NhaXuatBan"));
				quanlySach.setTheLoaiSach(result.getString("TheLoaiSach"));
				quanlySach.setNamXuatBan(result.getString("NamXuatBan"));
				quanlySach.setSoLuong(result.getString("soLuong"));
				quanlySach.setSoLuongTonKho(result.getString("soLuongConLai"));
				list.add(quanlySach);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	/**
	 * Thêm sách vào hệ thống
	 * @param quanlySach
	 * @return
	 */
	public boolean addSach(QuanLySach quanlySach) {
		boolean statusExecute = false;
		
		String sql = "INSERT INTO `sach`(`TenSach`, `TacGia`, `NhaXuatBan`, `TheLoaiSach`, `NamXuatBan`,`soLuong`,soLuongConLai) VALUES (?,?,?,?,?,?,?)";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, quanlySach.getTenSach());
			statement.setString(2, quanlySach.getTacGia());
			statement.setString(3, quanlySach.getNhaXuatBan());
			statement.setString(4, quanlySach.getTheLoaiSach());;
			statement.setString(5, quanlySach.getNamXuatBan());
			statement.setString(6, quanlySach.getSoLuong());
			statement.setString(7, quanlySach.getSoLuong());

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
	 * Sửa sách từ hệ thống
	 * @param quanlySach
	 * @return
	 */
	public boolean UpdateSach(QuanLySach quanlySach) {
		boolean statusExecute = false;
		
		String sql = "UPDATE `sach` SET `TenSach`=?,`TacGia`=?,`NhaXuatBan`=?,`TheLoaiSach`=?,`NamXuatBan`=?,`soLuong`=? WHERE MaSach = ?";
		conn = DatabaseUtil.getConnect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, quanlySach.getTenSach());
			statement.setString(2, quanlySach.getTacGia());
			statement.setString(3, quanlySach.getNhaXuatBan());
			statement.setString(4, quanlySach.getTheLoaiSach());;
			statement.setString(5, quanlySach.getNamXuatBan());
			statement.setString(6, quanlySach.getSoLuong());
			statement.setInt(7, Integer.parseInt(quanlySach.getMaSach()));
			
			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}else {
				JOptionPane.showMessageDialog(null, "Mã sách không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	
	
	
	/**
	 * Xóa sách trong hệ thống
	 * @param quanlySach
	 * @return
	 */
	public boolean DeleteSach(QuanLySach quanlySach) {
		boolean statusExecute = false;
		
		String sql = "DELETE FROM `sach` WHERE MaSach = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(quanlySach.getMaSach()));
			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}else {
				JOptionPane.showMessageDialog(null, "Mã sách không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	/**
	 * Tìm kiếm Sách
	 * @param quanlySach
	 * @return
	 */
	public ArrayList<QuanLySach> SeachSach(QuanLySach quanlySach){
		String sql = "SELECT sach.MaSach, sach.TenSach,sach.TacGia,xuatban.NhaXuatBan AS nxb,tls.TheLoaiSach AS book ,sach.NamXuatBan,sach.soLuong FROM sach INNER JOIN theloaisach ON sach.TheLoaiSach = theloaisach.TheLoaiSach  INNER JOIN nhaxuatban as xuatban ON sach.NhaXuatBan = xuatban.NhaXuatBan INNER JOIN theloaisach AS tls ON sach.TheLoaiSach = tls.TheLoaiSach WHERE sach.TenSach LIKE ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuanLySach> list = new ArrayList<QuanLySach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+quanlySach.getTenSach()+"%");
			
			ResultSet result = statement.executeQuery();
			
			QuanLySach quanlySach1; 
			
			while (result.next()) {
				 quanlySach1 = new QuanLySach();
				 quanlySach1.setMaSach("" + result.getInt("MaSach"));
				 quanlySach1.setTenSach(result.getString("TenSach"));
				 quanlySach1.setTacGia(result.getString("TacGia"));
				 quanlySach1.setNhaXuatBan(result.getString("nxb"));
				 quanlySach1.setTheLoaiSach(result.getString("book"));
				 quanlySach1.setNamXuatBan(result.getString("NamXuatBan"));
				 quanlySach1.setSoLuong(result.getString("soLuong"));
				
				list.add( quanlySach1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;
	}
	/**
	 * Kiểm tra tên sách
	 */
	public boolean kiemTraSach(String tenSach) {
		boolean kiem = false;
		String sql = "SELECT * FROM `sach`";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (tenSach.equals(result.getString("TenSach"))) {
					kiem = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);

		return kiem;
	}
}
