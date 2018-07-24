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
	public boolean addKhachHang(KhachHang khachHang) {
		boolean kiemTra = false;
		String sql = "INSERT INTO khach_hang VALUES (?,?,?,?,?,?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKH());
			statement.setString(2, khachHang.getTenKH());
			statement.setString(3, khachHang.getDiaChi());
			statement.setInt(4, layThongTinMaPhuong(khachHang.getPhuong()));
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
	public boolean themTheATMChoKhachHang(KhachHang khachHang, ArrayList<KhachHang> myList) {
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
				statement.setInt(4, layThongTinMaPhuong(myList.get(viTri).getPhuong()));
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
						System.out.println("Đóng lỗi");
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
	public boolean updateKhachHang(KhachHang khachHang) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET tenKhachHang = ?, diaChi = ?, maPhuong = ?, soDienThoai = ?, email = ? WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getTenKH());
			statement.setString(2, khachHang.getDiaChi());
			statement.setInt(3, layThongTinMaPhuong(khachHang.getPhuong()));
			statement.setString(4, khachHang.getSoDT());
			statement.setString(5, khachHang.getEmail());
			statement.setString(6, khachHang.getMaKH());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
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
	 * Tìm kiếm thông tin khách hàng theo tên và mã KH
	 * 
	 * @param khachHang1
	 * @return
	 */
	public ArrayList<KhachHang> timKiemThongTinTheoTen(String tenKH, String maKH) {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE tenKhachHang = ? OR maKhachHang LIKE '%"+maKH+"'";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenKH);
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
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
	}

	/**
	 * Lấy mã phường
	 * 
	 * @param tenPhuong
	 * @return
	 */
	public int layThongTinMaPhuong(String tenPhuong) {
		int maPhuong = 0;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT maPhuong FROM phuong WHERE tenPhuong = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenPhuong);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				maPhuong = resultSet.getInt("maPhuong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return maPhuong;
	}

	/**
	 * Lấy thông tin số tài khoản
	 * 
	 * @param maSoThe
	 * @return
	 */
	public String layThongTinMaTK(String maSoThe) {
		String soTK = null;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT soTK FROM the_atm WHERE soTheATM = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSoThe);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				soTK = resultSet.getString("soTK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return soTK;
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
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return soTien;
	}

	/**
	 * lấy ra all danh sách quận
	 * 
	 * @return
	 */
	public ArrayList<String> showAllDanhSachQuan() {
		ArrayList<String> myList = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM quan";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				myList.add(resultSet.getString("tenQuan"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return myList;
	}

	/**
	 * lấy ra all danh sách phường theo quận
	 * 
	 * @return
	 */
	public ArrayList<String> showDanhSachPhuong(String tenQuan) {
		ArrayList<String> myList = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM phuong JOIN quan ON phuong.maQuan = quan.maQuan WHERE quan.tenQuan = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenQuan);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				myList.add(resultSet.getString("tenPhuong"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return myList;
	}
}