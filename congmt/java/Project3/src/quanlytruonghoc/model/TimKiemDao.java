package quanlytruonghoc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.Diem;
import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.MonHoc;
import quanlytruonghoc.entity.SinhVien;

public class TimKiemDao {
	private Connection conn;
	private PreparedStatement statement;
	

	public boolean showTableSinhVienTimKiem(SinhVien sinhvien) {
		conn = DatabasaUltil.getConnect();
		boolean statusExecute = false;
		String sql = "SELECT * FROM sinhvien WHERE hoten=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getHoTen());
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien1;
			while (result.next()) {
				sinhvien1 = new SinhVien();
				sinhvien1.setIdSinhVien(result.getString("idsv"));
				sinhvien1.setHoTen(result.getString("hoten"));
				sinhvien1.setEmail(result.getString("email"));
				sinhvien1.setSdt(result.getString("sdt"));
				sinhvien1.setThanhpho(result.getString(""));
				
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	public boolean showTableMonTimKiem(MonHoc monHoc) {
		conn = DatabasaUltil.getConnect();
		boolean statusExecute = false;
		String sql = "SELECT * FROM monhoc WHERE monhoc=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getTenMonHoc());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Tìm thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	public boolean showTableLopTimKiem(Lop lop) {
		conn = DatabasaUltil.getConnect();
		boolean statusExecute = false;
		String sql = "SELECT * FROM lop WHERE tenlop=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getTenLop());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Tìm thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}
}
