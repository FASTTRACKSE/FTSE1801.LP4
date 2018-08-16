package quanlytruonghoc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.MonHoc;
import quanlytruonghoc.entity.Phuong;
import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.DatabasaUltil;

/**
 * SinhVienDao Class
 * 
 * @author Phạm Ngọc Hợi
 *
 */
public class SinhVienDao {

	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;

	
	/**
	 * Them moi 1 sinh vien
	 * 
	 * @param sinhvien
	 * @return
	 */
	
	public boolean addNewSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO `sinhvien`(`idsv`, `hoten`, `idlop`, `email`, `sdt`, `xaid`, `diachi`) VALUES (?,?,?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getIdSinhVien());
			statement.setString(2, sinhvien.getHoTen());
			statement.setString(3, sinhvien.getIdLop());
			statement.setString(4, sinhvien.getEmail());
			statement.setString(5, sinhvien.getSdt());
			statement.setString(6, sinhvien.getPhuong().getIdPhuong());
			statement.setString(7, sinhvien.getDiaChi());
			
			int count = statement.executeUpdate();
			
			if (count > 0) {
				System.out.println("Thêm thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;

	}

	/**
	 * Update 1 sinh vien theo MaSV
	 * 
	 * @param sinhvien
	 * @return
	 */
	public boolean updateSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE sinhvien SET hoten=?,idlop=?,email=?, sdt=?,xaid=?, diachi=?  WHERE idsv=?";
		try {
			statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getHoTen());
			statement.setString(2, sinhvien.getIdLop());
			statement.setString(3, sinhvien.getEmail());
			statement.setString(4, sinhvien.getSdt());
			statement.setString(5, sinhvien.getPhuong().getIdPhuong());
			statement.setString(6, sinhvien.getDiaChi());
			statement.setString(7, sinhvien.getIdSinhVien());
			
			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Cập nhập thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			System.out.println("Cập nhập thất bại!!");
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}

	/**
	 * Xoa 1 sinh vien theo idSinhVien
	 * 
	 * @param MASV
	 * @param MonHoc
	 * @return
	 */
	public boolean deletelSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		
		String sql = "DELETE FROM diem WHERE idsv=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getIdSinhVien());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa thanh cong");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql1 = "DELETE FROM sinhvien WHERE idsv=?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql1);
			statement.setString(1, sinhvien.getIdSinhVien());

			int count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Xóa thành công!!");
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;
	}
	
	public ArrayList<SinhVien> timSvTheoTen(SinhVien sinhvien) {
		conn = DatabasaUltil.getConnect();
		String sql = "SELECT sinhvien.*, xaphuongthitran.name, quanhuyen.name, tinhthanhpho.name FROM `sinhvien` INNER JOIN xaphuongthitran ON sinhvien.xaid=xaphuongthitran.xaid INNER JOIN quanhuyen ON xaphuongthitran.maqh=quanhuyen.maqh INNER JOIN tinhthanhpho ON quanhuyen.matp=tinhthanhpho.matp ";
		
		if(!sinhvien.getThanhpho().equals("")) {
			sql = sql + " WHERE tinhthanhpho.name = " + "'" + sinhvien.getThanhpho() + "'";
		}
		if(!sinhvien.getQuan().equals("")) {
			sql = sql + " AND quanhuyen.name = " + "'" + sinhvien.getQuan() + "'";
		}
		if(!sinhvien.getIdLop().equals("")) {
			sql = sql + " AND sinhvien.idlop = " + "'" + sinhvien.getIdLop() + "'";
		}
		
		if(!sinhvien.getHoTen().equals("")) {
			sql = sql + " AND sinhvien.hoten LIKE " + "'" + "%"  + sinhvien.getHoTen() + "%" + "'";
		}
		
		
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien1;
			Phuong phuong;
			while (result.next()) {
				sinhvien1 = new SinhVien();
				sinhvien1.setIdSinhVien(result.getString("idsv"));
				sinhvien1.setHoTen(result.getString("hoten"));
				sinhvien1.setIdLop(result.getString("idlop"));
				sinhvien1.setDiaChi(result.getString("diachi"));
				sinhvien1.setSdt(result.getString("sdt"));
				phuong = new Phuong();
				phuong.setNamePhuong(result.getString("xaphuongthitran.name"));
				sinhvien1.setPhuong(phuong);
				sinhvien1.setQuan(result.getString("quanhuyen.name"));
				sinhvien1.setThanhpho(result.getString("tinhthanhpho.name"));
				sinhvien1.setEmail(result.getString("email"));
				
				listSinhVien.add(sinhvien1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listSinhVien;
	}
	/**
	 * Hien thi danh sach tat ca sinh vien
	 * 
	 * @return
	 */
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT sinhvien.*, xaphuongthitran.name, quanhuyen.name, tinhthanhpho.name\r\n" + 
				"FROM `sinhvien`\r\n" + 
				"INNER JOIN xaphuongthitran\r\n" + 
				"ON sinhvien.xaid=xaphuongthitran.xaid\r\n" + 
				"INNER JOIN quanhuyen\r\n" + 
				"ON xaphuongthitran.maqh=quanhuyen.maqh\r\n" + 
				"INNER JOIN tinhthanhpho\r\n" + 
				"ON quanhuyen.matp=tinhthanhpho.matp\r\n";
		conn = DatabasaUltil.getConnect();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;
			Phuong phuong;
			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setIdSinhVien(result.getString("idsv"));
				sinhvien.setHoTen(result.getString("hoten"));
				sinhvien.setIdLop(result.getString("idlop"));
				sinhvien.setDiaChi(result.getString("diachi"));
				sinhvien.setSdt(result.getString("sdt"));
				phuong = new Phuong();
				phuong.setNamePhuong(result.getString("xaphuongthitran.name"));
				sinhvien.setPhuong(phuong);
				sinhvien.setQuan(result.getString("quanhuyen.name"));
				sinhvien.setThanhpho(result.getString("tinhthanhpho.name"));
				sinhvien.setEmail(result.getString("email"));
				
				listSinhVien.add(sinhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listSinhVien;
	}
	
	/**
	 * Hiển thị tất cả tên sinh viên
	 * @param monHoc
	 * @return
	 */
	public ArrayList<SinhVien> showTableSinhVien(SinhVien sinhVien) {
		conn = DatabasaUltil.getConnect();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		String sql = "SELECT * FROM `sinhvien` WHERE idsv=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getIdSinhVien());
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;
			Phuong phuong;
			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setIdSinhVien(result.getString("idsv"));
				sinhvien.setHoTen(result.getString("hoten"));
				sinhvien.setIdLop(result.getString("idlop"));
				sinhvien.setDiaChi(result.getString("diachi"));
				sinhvien.setSdt(result.getString("sdt"));
				phuong = new Phuong();
				phuong.setNamePhuong(result.getString("xaphuongthitran.name"));
				sinhvien.setPhuong(phuong);
				sinhvien.setQuan(result.getString("quanhuyen.name"));
				sinhvien.setThanhpho(result.getString("tinhthanhpho.name"));
				sinhvien.setEmail(result.getString("email"));
				
				listSinhVien.add(sinhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listSinhVien;

	}
	/**
	 * Hiển thị tên thành phố trong bảng thành phố
	 * @return
	 */
	public ArrayList<String> getAllThanhPho() {
		String sql = "SELECT `name` FROM `tinhthanhpho`";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listTp = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listTp.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listTp;
	}
	/**
	 * Hiển thị tên quận từ liên kết giữa bảng quận và thành phố trong database
	 * @param tenTp
	 * @return
	 */
	public ArrayList<String> getAllQuanHuyen(String tenTp) {
		String sql = "SELECT quanhuyen.name FROM quanhuyen INNER JOIN tinhthanhpho ON quanhuyen.matp=tinhthanhpho.matp WHERE tinhthanhpho.name=?";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listQuan = new ArrayList<String>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenTp);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				
				listQuan.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listQuan;
	}
	/**
	 * Hiển thị tên phường từ liên kết giữa bảng phường và bảng quận trong database
	 * @param tenQuan
	 * @return
	 */
	public ArrayList<String> getAllXaPhuong(String tenQuan) {
		String sql = "SELECT xaphuongthitran.name FROM xaphuongthitran INNER JOIN quanhuyen ON quanhuyen.maqh=xaphuongthitran.maqh WHERE quanhuyen.name=?";
		conn = DatabasaUltil.getConnect();
		ArrayList<String> listXaPhuong = new ArrayList<String>();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenQuan);
			result = statement.executeQuery();
			while (result.next()) {
				listXaPhuong.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listXaPhuong;
	}
	
	
	public String getXaId(String tenXa) {
		String sql = "SELECT `xaid` FROM `xaphuongthitran` WHERE `name` = ?";
		conn = DatabasaUltil.getConnect();
		String xaid = new String();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenXa);
			result = statement.executeQuery();
			while (result.next()) {
				xaid = result.getString("xaid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return xaid;
	}
	
	
}
