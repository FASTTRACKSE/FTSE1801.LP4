package quanlytruonghoc.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.SinhVien;

/**
 * ThongKeDao Class
 * 
 * @author CongMT
 *
 */
public class ThongKeDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;

	public double getDiemThiJava(String idsv) {
		String sql = "SELECT diemthi FROM diem WHERE idsv = ? AND idmon = 'MH001'";
		conn = DatabasaUltil.getConnect();
		double diemJava = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemJava = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemJava;
	}
	
	public double getDiemThiHTML(String idsv) {
		String sql = "SELECT diemthi FROM diem WHERE idsv = ? AND idmon = 'MH002'";
		conn = DatabasaUltil.getConnect();
		double diemHTML = 0;;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemHTML = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemHTML;
	}
	
	public double getDiemThiCSS(String idsv) {
		String sql = "SELECT diemthi FROM diem WHERE idsv = ? AND idmon = 'MH003'";
		conn = DatabasaUltil.getConnect();
		double diemCSS = 0;;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemCSS = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemCSS;
	}
	
	public double getDiemThiEnligh(String idsv) {
		String sql = "SELECT diemthi FROM diem WHERE idsv = ? AND idmon = 'MH004'";
		conn = DatabasaUltil.getConnect();
		double diemEnligh = 0;;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemEnligh = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemEnligh;
	}
	// Hiển thị danh sách lớp theo năm học
	
	public  ArrayList<Lop> getAllLopTheoNam(String namHoc){
		String sql = "SELECT * FROM `lop` WHERE `namhoc` = ?";
		conn = DatabasaUltil.getConnect();
		ArrayList<Lop> listDsLop = new ArrayList<Lop>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, namHoc);
			ResultSet result = statement.executeQuery();
			Lop lop;
			while (result.next()) {
				lop = new Lop();

				lop.setIdLop(result.getString("idlop"));
				lop.setTenLop(result.getString("tenlop"));
				lop.setNamHoc(result.getString("namhoc"));

				listDsLop.add(lop);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listDsLop;
	}
	
	public int getAllSinhVienTheoLop(String idLop) {
		String sql = "SELECT lop.*, sinhvien.idsv FROM `lop` INNER JOIN sinhvien ON lop.idlop=sinhvien.idlop WHERE lop.idlop=?";
		conn = DatabasaUltil.getConnect();
		ArrayList<Lop> listLop = new ArrayList<Lop>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idLop);
			
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;
			Lop lop;
			while (result.next()) {
				
				lop = new Lop();
				lop.setIdLop(result.getString("idlop"));
				lop.setTenLop(result.getString("tenlop"));
				lop.setNamHoc(result.getString("namhoc"));
				sinhvien = new SinhVien();
				sinhvien.setIdSinhVien(result.getString("idsv"));
				lop.setSinhVien(sinhvien);
				listLop.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listLop.size();
	}
	/**
	 * Lấy idlop trong bảng lớp với điều kiện từ tên lop
	 * @param tenLop
	 * @return
	 */
	public String getLopId(String tenLop) {
		String sql = "SELECT idlop FROM lop WHERE tenlop = ?";
		conn = DatabasaUltil.getConnect();
		String idLop = new String();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenLop);
			result = statement.executeQuery();
			while (result.next()) {
				idLop = result.getString("idlop");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return idLop;
	}
	
	public ArrayList<SinhVien> getAllTenSinhVien(String idlop) {
		String sql = "SELECT idsv,`hoten` FROM sinhvien WHERE idlop = ?";
		conn = DatabasaUltil.getConnect();
		ArrayList<SinhVien> listDSSV = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idlop);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				sinhVien= new SinhVien();
				sinhVien.setIdSinhVien(result.getString("idsv"));
				sinhVien.setHoTen(result.getString("hoten"));
				listDSSV.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listDSSV;
	}
	
}
