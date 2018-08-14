package quanly_thuvien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly_thuvien.model.entity.NhaXuatBan;
import quanly_thuvien.model.entity.QuanLySach;
import quanly_thuvien.model.entity.TheLoaiSach;

public class thongKeDao {
	Connection conn;

	public ArrayList<NhaXuatBan> getmaNhaXuatBan() {
		String sql = "SELECT `maNhaXuatBan` FROM `nhaxuatban`";
		conn = DatabaseUtil.getConnect();
		ArrayList<NhaXuatBan> list = new ArrayList<NhaXuatBan>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				NhaXuatBan manhaxuatban = new NhaXuatBan();
				manhaxuatban.setNhaXuatBan(result.getString("NhaXuatBan"));
				list.add(manhaxuatban);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}

	public ArrayList<TheLoaiSach> getTheLoaiSach() {
		String sql = "SELECT `maTheLoaiSach` FROM `theloaisach`";
		conn = DatabaseUtil.getConnect();
		ArrayList<TheLoaiSach> list = new ArrayList<TheLoaiSach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				TheLoaiSach matheloaisach = new TheLoaiSach();
				matheloaisach.setTheLoaiSach(result.getString("TheLoaiSach"));
				list.add(matheloaisach);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}

	public ArrayList<QuanLySach> getThongKeDauSach(String maNhaXuatBan, String maTheLoaiSach) {
		String sql = "SELECT sach.MaSach, sach.TenSach,sach.TacGia,nhaxuatban.maNhaXuatBan AS nhaxuatban, theloaisach.maTheLoaiSach AS theloaisach , sach.NamXuatBan, sach.soLuong FROM sach INNER JOIN nhaxuatban ON sach.NhaXuatBan = nhaxuatban.maNhaXuatBan INNER JOIN theloaisach ON sach.TheLoaiSach = theloaisach.maTheLoaiSach = ?,?";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuanLySach> list = new ArrayList<QuanLySach>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maNhaXuatBan);
			statement.setString(2, maTheLoaiSach);
			ResultSet result = statement.executeQuery();

			QuanLySach quanlySach;
			while (result.next()) {
				quanlySach = new QuanLySach();
				quanlySach.setMaSach("" + result.getInt("MaSach"));
				quanlySach.setTenSach(result.getString("TenSach"));
				quanlySach.setTacGia(result.getString("TacGia"));
				quanlySach.setMaNhaXuatBan(result.getString("maNhaXuatBan"));
				quanlySach.setMaTheLoaiSach(result.getString("maTheLoaiSach"));
				quanlySach.setNamXuatBan(result.getString("NamXuatBan"));
				quanlySach.setSoLuong(result.getString("soLuong"));
				list.add(quanlySach);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
}
