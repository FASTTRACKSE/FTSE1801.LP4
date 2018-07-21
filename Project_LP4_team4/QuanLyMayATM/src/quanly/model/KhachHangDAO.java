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
			System.out.println("loi");
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
	 * Update khách hàng theo mã khách hàng
	 * 
	 * @param khachHang
	 * @return
	 */
	public boolean updateKhachHang(KhachHang khachHang) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET tenKhachHang = ?, diaChi = ?, maPhuong = ?, soDienThoai = ?, email = ?,soTheATM = ?, soTienTrongTK = ? WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getTenKH());
			statement.setString(2, khachHang.getDiaChi());
			statement.setInt(3, layThongTinMaPhuong(khachHang.getPhuong()));
			statement.setString(4, khachHang.getSoDT());
			statement.setString(5, khachHang.getEmail());
			statement.setString(6, khachHang.getSoTheATM());
			statement.setString(7, khachHang.getSoTienTrongTK());
			statement.setString(8, khachHang.getMaKH());
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
	 * Xóa khách hàng theo tên
	 * 
	 * @param maKH
	 * @return
	 */
	public boolean deleteKhachHang(String maKH) {
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
	 * Lấy ra all thông tin khách hàng
	 * 
	 * @param soTK
	 * @return
	 */
	public ArrayList<KhachHang> showAllKhachHang() {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
				khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
				khachHang.setPhuong(resultSet.getString("danh_sach_phuong.tenPhuong"));
				khachHang.setQuan(resultSet.getString("danh_sach_quan.tenQuan"));
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
	 * Tìm kiếm thông tin khách hàng
	 * 
	 * @param khachHang1
	 * @return
	 */
	public ArrayList<KhachHang> timKiemThongTin(KhachHang khachHang1) {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		if (!khachHang1.getTenKH().equals("") && khachHang1.getSoDT().equals("")) {
			KhachHang khachHang;
			conn = DatabaseUntil.getConnect();
			String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE tenKhachHang = ?";
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, khachHang1.getTenKH());
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					khachHang = new KhachHang();
					khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
					khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
					khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
					khachHang.setPhuong(resultSet.getString("danh_sach_phuong.tenPhuong"));
					khachHang.setQuan(resultSet.getString("danh_sach_quan.tenQuan"));
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
		}

		if (!khachHang1.getTenKH().equals("") && !khachHang1.getSoDT().equals("")) {
			KhachHang khachHang;
			conn = DatabaseUntil.getConnect();
			String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE tenKhachHang = ? AND soDienThoai = ?";
			try {
				statement = conn.prepareStatement(sql);
				statement.setString(1, khachHang1.getTenKH());
				statement.setString(2, khachHang1.getSoDT());
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					khachHang = new KhachHang();
					khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
					khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
					khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
					khachHang.setPhuong(resultSet.getString("danh_sach_phuong.tenPhuong"));
					khachHang.setQuan(resultSet.getString("danh_sach_quan.tenQuan"));
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
		}
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
