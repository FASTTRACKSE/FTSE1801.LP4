package quanly_thuvien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.ThanhPho;

public class banDocDao {
	Connection conn;

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

	public ArrayList<QuanLy_BanDoc> getBaoCaoBanDoc(String tenThanhPho) {
		String sql = "SELECT thanh_vien.MaThanhVien, thanh_vien.tenThanhVien,thanh_vien.SoNha,thanhpho.tenThanhPho AS thanhpho, District.tenQuanHuyen as Quan,phuong_xa.tenPhuongXa as Phuong,thanh_vien.SĐT,thanh_vien.Email FROM thanh_vien INNER JOIN phuong_xa ON thanh_vien.maPhuongXa = phuong_xa.maPhuongXa INNER JOIN quan_huyen as District ON thanh_vien.maQuanHuyen = District.maQuanHuyen INNER JOIN tinh_thanhpho as  thanhpho ON thanh_vien.maThanhPho = thanhpho.maThanhPho WhERE thanhpho.tenThanhPho = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuanLy_BanDoc> list = new ArrayList<QuanLy_BanDoc>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenThanhPho);
			ResultSet result = statement.executeQuery();

			QuanLy_BanDoc quanLyBanDoc2;
			while (result.next()) {
				quanLyBanDoc2 = new QuanLy_BanDoc();
				quanLyBanDoc2.setMaThanhVien("" + result.getInt("MaThanhVien"));
				quanLyBanDoc2.setTenThanhVien(result.getString("tenThanhVien"));
				quanLyBanDoc2.setSoNha(result.getString("SoNha"));
				quanLyBanDoc2.setSDT(result.getString("SĐT"));
				quanLyBanDoc2.setEmail(result.getString("Email"));
				quanLyBanDoc2.setMaThanhPho(result.getString("thanhpho"));
				quanLyBanDoc2.setMaQuanHuyen(result.getString("Quan"));
				quanLyBanDoc2.setMaPhuongXa(result.getString("Phuong"));
				list.add(quanLyBanDoc2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
}
