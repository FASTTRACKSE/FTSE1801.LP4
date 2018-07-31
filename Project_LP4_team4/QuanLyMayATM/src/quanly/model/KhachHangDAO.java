package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanly.entity.KhachHang;

public class KhachHangDAO {
	Connection conn;

	/**
	 * Thêm khách hàng
	 * 
	 * @param khachHang
	 * @return
	 */
	public boolean addKhachHang(KhachHang khachHang, int maPhuong) {
		boolean kiemTra = false;
		String sql = "INSERT INTO khach_hang VALUES (?,?,?,?,?,?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKH());
			statement.setString(2, khachHang.getTenKH());
			statement.setString(3, khachHang.getDiaChi());
			statement.setInt(4, maPhuong);
			statement.setString(5, khachHang.getSoDT());
			statement.setString(6, khachHang.getEmail());
			statement.setString(7, khachHang.getSoTheATM());
			statement.setString(8, khachHang.getSoTienTrongTK());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Đóng lỗi");
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Thêm thẻ khách hàng
	 * 
	 * @param khachHang
	 * @param soTheATM
	 * @return
	 */
	public boolean themTheATMChoKhachHang(KhachHang khachHang, ArrayList<KhachHang> myList, int maPhuong) {
		int viTri = 0;
		boolean check = false;
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getMaKH().equals(khachHang.getMaKH())) {
				viTri = i;
				check = true;
				break;
			}
		}
		boolean kiemTra = false;
		String sql = "INSERT INTO khach_hang VALUES (?,?,?,?,?,?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		if (check) {
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, myList.get(viTri).getMaKH());
				statement.setString(2, myList.get(viTri).getTenKH());
				statement.setString(3, myList.get(viTri).getDiaChi());
				statement.setInt(4, maPhuong);
				statement.setString(5, myList.get(viTri).getSoDT());
				statement.setString(6, myList.get(viTri).getEmail());
				statement.setString(7, khachHang.getSoTheATM());
				statement.setString(8, khachHang.getSoTienTrongTK());
				if (statement.executeUpdate() > 0) {
					kiemTra = true;
				}
			} catch (SQLException e) {
				return kiemTra;
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
					}
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Update thông tin khách hàng theo mã khách hàng
	 * 
	 * @param khachHang
	 * @return
	 */
	public boolean updateKhachHang(KhachHang khachHang, int maPhuong) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET tenKhachHang = ?, diaChi = ?, maPhuong = ?, soDienThoai = ?, email = ? WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getTenKH());
			statement.setString(2, khachHang.getDiaChi());
			statement.setInt(3,maPhuong);
			statement.setString(4, khachHang.getSoDT());
			statement.setString(5, khachHang.getEmail());
			statement.setString(6, khachHang.getMaKH());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Update tông số tiền khách hàng theo mã khách hàng và số thẻ ATM
	 * 
	 * @param khachHang
	 * @return
	 */
	public boolean updateSoTien(String maKH, String maSoThe, String soTien) {
		boolean kiemTra = false;
		Integer allTien = Integer.parseInt(layThongTinSoTien(maSoThe)) + Integer.parseInt(soTien);
		String sql = "UPDATE khach_hang SET soTienTrongTK=? WHERE soTheATM = ? AND maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, ("" + allTien));
			statement.setString(2, maSoThe);
			statement.setString(3, maKH);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Xóa khách hàng theo maKH
	 * 
	 * @param maKH
	 * @return
	 */
	public boolean deleteKhachHangTheoMaKH(String maKH) {
		boolean kiemTra = false;
		String sql = "DELETE FROM khach_hang WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maKH);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Xóa khách hàng theo số thẻ ATM
	 * 
	 * @param maKH
	 * @return
	 */
	public boolean deleteKhachHangTheoSoThe(String soThe) {
		boolean kiemTra = false;
		String sql = "DELETE FROM khach_hang WHERE soTheATM = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soThe);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Lấy ra all thông tin khách hàng
	 * 
	 * @param soTK
	 * @return
	 */
	public ArrayList<KhachHang> showAllKhachHang() {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		boolean kiemTra = false;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM ORDER BY maKhachHang ASC";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				for (int i = 0; i < myList.size(); i++) {
					if (myList.get(i).getMaKH().equals(resultSet.getString("khach_hang.maKhachHang"))) {
						kiemTra = true;
					} else {
						kiemTra = false;
					}
				}
				if (kiemTra) {
					khachHang = new KhachHang();
					khachHang.setMaKH("");
					khachHang.setTenKH("");
					khachHang.setDiaChi("");
					khachHang.setPhuong("");
					khachHang.setQuan("");
					khachHang.setSoDT("");
					khachHang.setEmail("");
					khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
					khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
					khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
				} else {
					khachHang = new KhachHang();
					khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
					khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
					khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
					khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
					khachHang.setQuan(resultSet.getString("quan.tenQuan"));
					khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
					khachHang.setEmail(resultSet.getString("khach_hang.email"));
					khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
					khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
					khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
				}
				myList.add(khachHang);
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
	}

	/**
	 * Tìm kiếm thông tin khách hàng theo tên
	 * 
	 * @param khachHangInput
	 * @return
	 */
	public ArrayList<KhachHang> timKiem(KhachHang khachHangInPut) {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		String SelectQuery= "SELECT * ";
		String FromQuery= "FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE " ;
		if(!khachHangInPut.getPhuong().equals("")) {
		       FromQuery= FromQuery + "phuong.tenPhuong ='" + khachHangInPut.getPhuong()+"'";
		}
		if(!khachHangInPut.getMaKH().equals("")) {
		      FromQuery=FromQuery  + " AND " + "khach_hang.maKhachHang LIKE '%" + khachHangInPut.getMaKH()+"'";
		}
		if(!khachHangInPut.getTenKH().equals("")) {
		       FromQuery= FromQuery + " AND " + "khach_hang.tenKhachHang LIKE '%" + khachHangInPut.getTenKH()+"'";
		}
		if(!khachHangInPut.getDiaChi().equals("")) {
		       FromQuery= FromQuery + " AND " + "khach_hang.diaChi LIKE '%" + khachHangInPut.getDiaChi()+"'";
		}
		if(!khachHangInPut.getSoDT().equals("")) {
		       FromQuery= FromQuery + " AND " + "khach_hang.soDienThoai LIKE '%" + khachHangInPut.getSoDT()+"'";
		}
		if(!khachHangInPut.getEmail().equals("")) {
		       FromQuery= FromQuery + " AND " + "khach_hang.email LIKE '%" + khachHangInPut.getEmail()+"'";
		}
		if(!khachHangInPut.getSoTheATM().equals("")) {
		       FromQuery= FromQuery + " AND " + "khach_hang.soTheATM LIKE '%" + khachHangInPut.getSoTheATM()+"'";
		}
		String Query=SelectQuery+FromQuery;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		try {
			statement = conn.prepareStatement(Query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
				khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
				khachHang.setQuan(resultSet.getString("quan.tenQuan"));
				khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
				khachHang.setEmail(resultSet.getString("khach_hang.email"));
				khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
				khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("soTienTrongTK"));
				myList.add(khachHang);
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
	}

	/**
	 * Lấy thông tin tiền trong tài khoản theo số thẻ ATM
	 * 
	 * @param maSoThe
	 * @return
	 */
	public String layThongTinSoTien(String maSoThe) {
		String soTien = null;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT soTienTrongTK FROM khach_hang WHERE soTheATM = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSoThe);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				soTien = resultSet.getString("soTienTrongTK");
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return soTien;
	}
	
	/**
	 * Lấy ra thông tin khách hàng theo số tài khoản
	 * 
	 * @param soTK
	 * @return
	 */
	public KhachHang showKhachHangTheoMaKH(String soThe) {
		PreparedStatement statement = null;
		KhachHang khachHang = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE the_atm.soTK= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soThe);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
				khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
				khachHang.setQuan(resultSet.getString("quan.tenQuan"));
				khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
				khachHang.setEmail(resultSet.getString("khach_hang.email"));
				khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
				khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return khachHang;
	}
	
	/**
	 * Rút tiền
	 * 
	 * @param myList
	 * @param soTienRut
	 * @return
	 */
	public boolean rutTien(KhachHang khachHang, String soTienRut) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET soTienTrongTK=? WHERE soTheATM= ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		if (Integer.parseInt(khachHang.getSoTienTrongTK()) > Integer.parseInt(soTienRut)) {
			Integer soTienConLai = Integer.parseInt(khachHang.getSoTienTrongTK()) - Integer.parseInt(soTienRut);
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, ("" + soTienConLai));
				statement.setString(2, khachHang.getSoTheATM());
				if (statement.executeUpdate() > 0) {
					kiemTra = true;
				}
			} catch (SQLException e) {
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
					}
				}
			}
		} else {
			kiemTra = false;
		}

		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	/**
	 * Lấy ra maKH khách hàng theo số thẻ
	 * 
	 * @param soTK
	 * @return
	 */
	public String layMaKH(String soTheATM) {
		PreparedStatement statement = null;
		String maKH = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang WHERE soTheATM= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTheATM);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				maKH = resultSet.getString("maKhachHang");
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return maKH;
	}
	
	/**
	 * Kiểm tra trùng mã khách hàng
	 * 
	 * @param myList
	 * @param maKH
	 * @return
	 */
	public boolean kiemTraMaKhachHang(ArrayList<KhachHang> myList, String maKH) {
		boolean kiemTra = true;
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getMaKH().equals(maKH)) {
				kiemTra = false;
			}
		}
		return kiemTra;
	}
	
	/**
	 * Lấy ra thông tin khách hàng theo phường và quận
	 * 
	 * @param soTK
	 * @return
	 */
	public ArrayList<KhachHang> showKhachHangTheoPhuongVaQuan(String phuong, String quan) {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		boolean kiemTra = false;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM  WHERE phuong.tenPhuong = ? AND quan.tenQuan = ? ORDER BY khach_hang.maKhachHang ASC";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, phuong);
			statement.setString(2, quan);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				for (int i = 0; i < myList.size(); i++) {
					if (myList.get(i).getMaKH().equals(resultSet.getString("khach_hang.maKhachHang"))) {
						kiemTra = true;
					} else {
						kiemTra = false;
					}
				}
				if (kiemTra) {
					khachHang = new KhachHang();
					khachHang.setMaKH("");
					khachHang.setTenKH("");
					khachHang.setDiaChi("");
					khachHang.setPhuong("");
					khachHang.setQuan("");
					khachHang.setSoDT("");
					khachHang.setEmail("");
					khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
					khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
				} else {
					khachHang = new KhachHang();
					khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
					khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
					khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
					khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
					khachHang.setQuan(resultSet.getString("quan.tenQuan"));
					khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
					khachHang.setEmail(resultSet.getString("khach_hang.email"));
					khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
					khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
				}
				myList.add(khachHang);
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
	}
	
	/**
	 * Kiểm tra khách hàng có sở hữu thẻ ATM không
	 * @param soTheATM
	 * @param soTK
	 * @return
	 */
	public boolean kiemTraKhachHangCoSoHuuThe(String soTheATM, String soTK) {
		boolean kiemTra = false;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `khach_hang` LEFT JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE the_atm.soTheATM = ? OR the_atm.soTK =?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTheATM);
			statement.setString(2, soTK);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
}