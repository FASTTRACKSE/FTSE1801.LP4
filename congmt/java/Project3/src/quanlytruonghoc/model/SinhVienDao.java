package quanlytruonghoc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlytruonghoc.entity.Diem;
import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.Phuong;
import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.DatabasaUltil;

/**
 * SinhVienDao Class
 * 
 * @author CongMT
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
		String sql = "INSERT INTO `sinhvien`(`idsv`, `hoten`, `idlop`, `email`, `sdt`, `xaid`, `diachi`) VALUES (?,?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getIdSinhVien());
			statement.setString(2, sinhvien.getHoTen());
			statement.setString(3, sinhvien.getEmail());
			statement.setString(4, sinhvien.getSdt());
			statement.setString(5, sinhvien.getPhuong().getIdPhuong());
			statement.setString(6, sinhvien.getDiaChi());

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
		String sql = "UPDATE sinhvien SET hoten=?,email=?, sdt=?,tp=?,quan=?,phuong=?, diachi=?  WHERE idsv=?";
		try {
			statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getHoTen());
			statement.setString(2, sinhvien.getEmail());
			statement.setString(3, sinhvien.getSdt());
			statement.setString(4, sinhvien.getThanhpho());
			statement.setString(5, sinhvien.getQuan());
			statement.setString(6, sinhvien.getPhuong().getIdPhuong());
			statement.setString(7, sinhvien.getDiaChi());
			statement.setString(8, sinhvien.getIdSinhVien());
			
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
	/**
	 * Hien thi danh sach tat ca sinh vien theo nam hoc va ten lop
	 * 
	 * @return
	 */
//	public ArrayList<Lop> getAllSinhVienTheoNam(SinhVien sinhVien) {
//		String sql = "SELECT  lop.*, sinhvien.idsv, sinhvien.hoten FROM lop  INNER JOIN sinhvien ON sinhvien.idlop=lop.idlop WHERE namhoc=? AND tenlop=?";
//		conn = DatabasaUltil.getConnect();
//		ArrayList<Lop> listLop = new ArrayList<Lop>();
//		try {
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, sinhVien.getLop().getNamHoc());
//			statement.setString(2, sinhVien.getLop().getTenLop());
//			ResultSet result = statement.executeQuery();
//			Diem diem;
//			MonHoc monHoc;
//			SinhVien sinhvien;
//			while (result.next()) {
//				lop = new Lop();
//				
//				lop.setIdLop(result.getString("idlop"));
//				lop.setTenLop(result.getString("tenlop"));
//				lop.setNamHoc(result.getString("namhoc"));
//				
//				sinhvien = new SinhVien();
//				sinhvien.setIdSinhVien(result.getString("idsv"));
//				sinhvien.setHoTen(result.getString("hoten"));
//				lop.setSinhVien(sinhvien);
//				
//				
//				
//				listLop.add(lop);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DatabasaUltil.closeConnection(conn);
//		return listLop;
//	}
}
