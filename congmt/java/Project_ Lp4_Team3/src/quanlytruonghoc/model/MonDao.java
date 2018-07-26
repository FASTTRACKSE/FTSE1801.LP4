package quanlytruonghoc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytruonghoc.entity.MonHoc;
import quanlytruonghoc.entity.SinhVien;

/**
 * MonDao Class
 * @author CongMT
 *
 */
public class MonDao {
	private Connection conn;
	private PreparedStatement statement;

	/**
	 * Them moi mon hoc
	 * @param mon
	 * @return
	 */
	public boolean addMoṇ(MonHoc monHoc){
		boolean test = false;
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO monhoc (idmon, monhoc, tinchi, thoiluong) VALUES (?, ?, ?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getIdMonHoc());
			statement.setString(2, monHoc.getTenMonHoc());
			statement.setString(3, monHoc.getTinChi());
			statement.setString(4, monHoc.getThoiLuongHoc());
			
			int cont = statement.executeUpdate();
			if(cont>0) {
				System.out.println(" Them thanh cong!!");
				test=true;
			}
		} catch (Exception e2) {
			System.out.println(" Them that bai!!");
		}
		DatabasaUltil.closeConnection(conn);
		return test;
	}
	/**
	 * Sua ten mon hoc theo  idmonhoc
	 * 
	 * @param monhoc
	 * @return
	 */
	public boolean updateMonHoc(MonHoc monHoc) {
		boolean test = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE monhoc SET monhoc=?, tinchi=?, thoiluong=? WHERE idmon=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getTenMonHoc());
			statement.setString(2, monHoc.getTinChi());
			statement.setString(3, monHoc.getThoiLuongHoc());
			statement.setString(4, monHoc.getIdMonHoc());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cap nhap thanh cong");
				test = true;
			}
		} catch (Exception e) {
			System.out.println("Cap nhap that bai!!");
		}
		DatabasaUltil.closeConnection(conn);
		return test;
	}

	/**
	 * Xoa 1 mon hoc theo  idmonhoc
	 * 
	 * @param monhoc
	 * @return
	 */
	public boolean deletelMonHoc(MonHoc monHoc) {
		boolean test = false;
		conn = DatabasaUltil.getConnect();
		String sql = "DELETE FROM monhoc WHERE idmon=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getIdMonHoc());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa thanh cong!!");
				test = true;
			}
		} catch (Exception e) {
			System.out.println("Xoa that bai!!");
		}
		DatabasaUltil.closeConnection(conn);
		return test;
	}
	public ArrayList<MonHoc> showTableMonTimKiem(MonHoc monHoc) {
		conn = DatabasaUltil.getConnect();
		ArrayList<MonHoc> listMonHoc = new ArrayList<MonHoc>();
		String sql = "SELECT * FROM `monhoc` WHERE monhoc=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getTenMonHoc());

			ResultSet result = statement.executeQuery();
			MonHoc monHoc1; 
			while (result.next()) {
				monHoc1 = new MonHoc();
				monHoc1.setIdMonHoc(result.getString("idmon"));
				monHoc1.setTenMonHoc(result.getString("monhoc"));
				monHoc1.setTinChi(result.getString("tinchi"));
				monHoc1.setThoiLuongHoc(result.getString("thoiluong"));
				listMonHoc.add(monHoc1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
		DatabasaUltil.closeConnection(conn);
		return listMonHoc;
		
	}
	
	/**
	 * Hien thi danh sach tat ca sinh vien
	 * 
	 * @return
	 */
	public ArrayList<MonHoc> getAllMonHoc() {
		String sql = "SELECT * FROM monhoc";
		conn = DatabasaUltil.getConnect();
		ArrayList<MonHoc> listMonHoc = new ArrayList<MonHoc>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			MonHoc monHoc;
			while (result.next()) {
				monHoc = new MonHoc();
				monHoc.setIdMonHoc(result.getString("idmon"));
				monHoc.setTenMonHoc(result.getString("monhoc"));
				monHoc.setTinChi(result.getString("tinchi"));
				monHoc.setThoiLuongHoc(result.getString("thoiluong"));
			
				
				listMonHoc.add(monHoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listMonHoc;
	}
	

}
