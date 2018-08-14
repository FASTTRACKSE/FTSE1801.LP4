package quanly_thuvien.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import quanly_thuvien.model.entity.Phuong;
import quanly_thuvien.model.entity.Quan;
import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.ThanhPho;





/*
 * lấy dữ liệu từ thành phố
 */
public class thuvienDao {
	Connection conn;
	public ArrayList<ThanhPho> getCiTy() {
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
	
	/*
	 * lấy dữ liệu từ Quận.
	 */
	public ArrayList<Quan> getQuan(String tenThanhPho) {
		String sql = "SELECT quan_huyen.tenQuanHuyen FROM quan_huyen INNER JOIN tinh_thanhpho ON quan_huyen.maThanhPho = tinh_thanhpho.maThanhPho WHERE tinh_thanhpho.tenThanhPho = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<Quan> list = new ArrayList<Quan>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenThanhPho);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Quan quan = new Quan();
				quan.setTenQuanHuyen(result.getString("tenQuanHuyen"));
				list.add(quan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	/**
	 * lấy dữ liệu từ phường
	 * @param tenQuanHuyen
	 * @return
	 */
	public ArrayList<Phuong> getPhuong(String tenQuanHuyen) {
		String sql = "SELECT phuong_xa.tenPhuongXa FROM phuong_xa INNER JOIN quan_huyen ON phuong_xa.maQuanHuyen = quan_huyen.maQuanHuyen WHERE quan_huyen.tenQuanHuyen = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<Phuong> list = new ArrayList<Phuong>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenQuanHuyen);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Phuong phuong = new Phuong();
				phuong.setTenPhuongXa(result.getString("tenPhuongXa"));
				list.add(phuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	
	/**
	 * in danh sách bạn đọc
	 * @return
	 */
	public ArrayList<QuanLy_BanDoc> getAllBanDoc() {
		String sql = "SELECT thanh_vien.MaThanhVien, thanh_vien.tenThanhVien,thanh_vien.SoNha,thanhpho.tenThanhPho AS thanhpho, District.tenQuanHuyen as Quan,phuong_xa.tenPhuongXa as Phuong,thanh_vien.SĐT,thanh_vien.Email FROM thanh_vien INNER JOIN phuong_xa ON thanh_vien.maPhuongXa = phuong_xa.maPhuongXa INNER JOIN quan_huyen as District ON thanh_vien.maQuanHuyen = District.maQuanHuyen INNER JOIN tinh_thanhpho as  thanhpho ON thanh_vien.maThanhPho = thanhpho.maThanhPho";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuanLy_BanDoc> list = new ArrayList<QuanLy_BanDoc>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			QuanLy_BanDoc quanLyBanDoc;
			
			while (result.next()) {
				quanLyBanDoc = new QuanLy_BanDoc();
				quanLyBanDoc.setMaThanhVien(""+result.getInt("MaThanhVien"));
				quanLyBanDoc.setTenThanhVien(result.getString("tenThanhVien"));
				quanLyBanDoc.setSoNha(result.getString("SoNha"));
				quanLyBanDoc.setSDT(result.getString("SĐT"));
				quanLyBanDoc.setEmail(result.getString("Email"));
				
				
				
				quanLyBanDoc.setMaThanhPho(result.getString("thanhpho"));
				
				
				quanLyBanDoc.setMaQuanHuyen(result.getString("Quan"));
				
				
				quanLyBanDoc.setMaPhuongXa(result.getString("Phuong"));
				list.add(quanLyBanDoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	
	/*
	 * thêm vào danh sách bạn đọc
	 */
	public boolean addBanDoc(QuanLy_BanDoc quanLyBanDoc) {
		boolean statusExecute = false;
		int[] ma = layMaThanhQuanPhuong(quanLyBanDoc.getMaPhuongXa());
		String sql = "INSERT INTO `thanh_vien`( `tenThanhVien`, `SoNha`, `maPhuongXa`, `maQuanHuyen`, `maThanhPho`, `SĐT`, `Email`) VALUES (?,?,?,?,?,?,?)";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, quanLyBanDoc.getTenThanhVien());
			statement.setString(2, quanLyBanDoc.getSoNha());
			statement.setInt(3, ma[0]);
			statement.setInt(4, ma[1]);
			statement.setInt(5, ma[2]);
			statement.setString(6, quanLyBanDoc.getSDT());
			statement.setString(7, quanLyBanDoc.getEmail());

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	public int[] layMaThanhQuanPhuong(String tenPhuongXa) {
		int[] ma = new int[3];
		String sql = "SELECT * FROM phuong_xa INNER JOIN quan_huyen ON phuong_xa.maQuanHuyen= quan_huyen.maQuanHuyen INNER JOIN tinh_thanhpho ON quan_huyen.maThanhPho = tinh_thanhpho.maThanhPho WHERE tenPhuongXa = ?";
		conn = DatabaseUtil.getConnect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenPhuongXa);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				ma[0] = result.getInt("phuong_xa.maPhuongXa");
				ma[1] = result.getInt("quan_huyen.maQuanHuyen");
				ma[2] = result.getInt("tinh_thanhpho.maThanhPho");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return ma;
	}
	public boolean UpdateBanDoc(QuanLy_BanDoc quanLyBanDoc) {
		boolean statusExecute = false;
		int[] ma = layMaThanhQuanPhuong(quanLyBanDoc.getMaPhuongXa());
		String sql = "UPDATE `thanh_vien` SET tenThanhVien =?,`SoNha`=?,`maPhuongXa`=?,`maQuanHuyen`=?,`maThanhPho`=?,`SĐT`=?,`Email`=? WHERE MaThanhVien = ?";
		conn = DatabaseUtil.getConnect();
		int maTV = Integer.parseInt(quanLyBanDoc.getMaThanhVien());
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
		
			statement.setString(1, quanLyBanDoc.getTenThanhVien());
			statement.setString(2, quanLyBanDoc.getSoNha());
			statement.setInt(3, ma[0]);
			statement.setInt(4, ma[1]);
			statement.setInt(5, ma[2]);
			statement.setString(6, quanLyBanDoc.getSDT());
			statement.setString(7, quanLyBanDoc.getEmail());
			statement.setInt(8, maTV);
			if (statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,"Thay đổi thông tin thành công");
				statusExecute = true;
			}else {
				JOptionPane.showMessageDialog(null,"Mã thành viên không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	public boolean DeleteBanDoc(QuanLy_BanDoc quanLyBanDoc) {
		boolean statusExecute = false;
		
		String sql = "DELETE FROM `thanh_vien` WHERE MaThanhVien = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(quanLyBanDoc.getMaThanhVien()));
			
			if (statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,"Xóa thành công.");
				statusExecute = true;
			}else {
				JOptionPane.showMessageDialog(null,"Mã thành viên không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	/**
	 * Tìm kiếm bạn đọc
	 * @param quanLyBanDoc
	 * @return
	 */
	public ArrayList<QuanLy_BanDoc> SeachBanDoc(QuanLy_BanDoc quanLyBanDoc) {
		boolean statusExecute = false;
		String sql = "SELECT thanh_vien.MaThanhVien, thanh_vien.tenThanhVien,thanh_vien.SoNha,thanhpho.tenThanhPho AS thanhpho, District.tenQuanHuyen as Quan,phuong_xa.tenPhuongXa as Phuong,thanh_vien.SĐT,thanh_vien.Email FROM thanh_vien INNER JOIN phuong_xa ON thanh_vien.maPhuongXa = phuong_xa.maPhuongXa INNER JOIN quan_huyen as District ON thanh_vien.maQuanHuyen = District.maQuanHuyen INNER JOIN tinh_thanhpho as  thanhpho ON thanh_vien.maThanhPho = thanhpho.maThanhPho WhERE thanh_vien.tenThanhVien LIKE ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuanLy_BanDoc> list = new ArrayList<QuanLy_BanDoc>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+quanLyBanDoc.getTenThanhVien()+"%");
			ResultSet result = statement.executeQuery();
			
			QuanLy_BanDoc quanLyBanDoc1;
			while (result.next()) {
				quanLyBanDoc1 = new QuanLy_BanDoc();
				quanLyBanDoc1.setMaThanhVien(""+result.getInt("MaThanhVien"));
				quanLyBanDoc1.setTenThanhVien(result.getString("tenThanhVien"));
				quanLyBanDoc1.setSoNha(result.getString("SoNha"));
				quanLyBanDoc1.setSDT(result.getString("SĐT"));
				quanLyBanDoc1.setEmail(result.getString("Email"));
				quanLyBanDoc1.setMaThanhPho(result.getString("thanhpho"));
				quanLyBanDoc1.setMaQuanHuyen(result.getString("Quan"));
				quanLyBanDoc1.setMaPhuongXa(result.getString("Phuong"));
				list.add(quanLyBanDoc1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;
		
	}
	/**
	 * Kiểm tra Thành viên
	 */
	public boolean kiemTra(String tenTV) {
		boolean kiem = false;
		String sql = "SELECT * FROM `thanh_vien`";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				if (tenTV.equals(result.getString("tenThanhVien"))) {
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
