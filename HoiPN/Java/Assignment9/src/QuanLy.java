	import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class QuanLy {
	/**
	 * Thêm sinh viên
	 * 
	 * @param conn
	 * @param masv
	 * @param ten
	 * @param pass
	 */

	public void addSinhVien(Connection conn, String masv, String ten, String pass) {
		PreparedStatement statement= null;
		try {
			String sql = "INSERT INTO sinh_vien(masv,ten,pass) VALUES (?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, masv);
			statement.setString(2, ten);
			statement.setString(3, pass);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Thêm sinh viên thành công.");
			}
		} catch (Exception ex) {
			System.out.println("Thêm sinh viên thất bại.");
		} finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Thêm hoặc sửa điểm theo mã sinh viên.
	 * @param conn
	 * @param masv
	 * @param monhoc
	 * @param diem
	 */
	
	public void addDiem(Connection conn, String masv,String monhoc, int diem) {
		String sql = "SELECT * FROM sinh_vien WHERE masv =?";
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		PreparedStatement statement3 = null;
		boolean kiemTra = false;
		
		//Kiểm tra mã sinh viên trong bảng sinh_vien.
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, masv);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (result.getString("masv").equals(masv)) {
					kiemTra = true;
					break;
				}else {
					kiemTra = false;
				}
			}
			
			if (kiemTra) {
				// thực hiện cau lệnh sửa điểm sinh viên theo mã sinh viên
				statement2 = conn.prepareStatement("SELECT * FROM diem");
				ResultSet resultSet2 = statement2.executeQuery();
				while(resultSet2.next()) {
					if (resultSet2.getString("masv").equals(masv)&&resultSet2.getString("monhoc").equals(monhoc)) {
						statement2 = conn.prepareStatement("UPDATE diem SET diem = ? WHERE masv = ?");
						statement2.setInt(1, diem);
						statement2.setString(2, masv);
						int x = statement2.executeUpdate();
						if (x > 0) {
							System.out.println("Update thanh cong.");
						}
						kiemTra = false;
						break;
						
					}else {
						kiemTra = true;
					}
				}
			}else {
				System.out.println("Mã sinh viên không tồn tại.");
			}
			
			
			
			if (kiemTra) {
				// thực hiện câu lệnh thêm điểm sinh viên theo mã sinh viên
				statement3 = conn.prepareStatement("INSERT INTO diem(masv,monhoc,diem) VALUES (?,?,?)");
				statement3.setString(1, masv);
				statement3.setString(2, monhoc);
				statement3.setInt(3, diem);
				int x = statement3.executeUpdate();
				if (x > 0) {
					System.out.println("Them thanh cong.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement2!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement3!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Sửa thông tin sinh viên theo mã sinh viên.
	 * 
	 * @param conn
	 * @param masv
	 * @param ten
	 * @param pass
	 */

	public void updateSinhVien(Connection conn, String masv, String ten, String pass) {
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		boolean kiemTra = false;
		String sql = "SELECT * FROM sinh_vien WHERE masv =?";
		
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, masv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (result.getString("masv").equals(masv)) {
					kiemTra = true;
					statement2 = conn.prepareStatement("UPDATE sinh_vien SET ten = ?,pass = ? WHERE masv = ?");
					statement2.setString(1, ten);
					statement2.setString(2, pass);
					statement2.setString(3, masv);
					int x = statement2.executeUpdate();
					if (x > 0) {
						System.out.println("Update thanh cong.");
					}
					break;
				}else {
					kiemTra = false;
				}
			}
			System.out.println("Mã sinh viên không tồn tại.");

		} catch (Exception ex) {
			System.out.println("Truy cập thất bại.");
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement2!=null) {
				try {
					statement2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Xóa sinh viên theo mã sinh viên
	 * 
	 * @param conn
	 * @param masv
	 */

	public void deleteSinhVien(Connection conn, String masv) {
		String sql = "DELETE FROM `sinh_vien` WHERE `masv`=?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, masv);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Xóa thành công.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * Sửa điểm sinh viên theo mã sinh viên.
	 * 
	 * @param conn
	 * @param masv
	 * @param diem
	 */

	public void updateDiem(Connection conn, String masv, String diem) {
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		try {
			String sql = "SELECT * FROM diem WHERE masv =?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, masv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("masv") + " " + result.getString("diem"));
				if (result.getString("masv").equals(masv)) {
					System.out.println("mã đúng");
					String sql1 = "UPDATE diem SET diem=?";
					statement1 = conn.prepareStatement(sql1);

					statement1.setString(1, diem);
					int x = statement1.executeUpdate();
					if (x > 0) {
						System.out.println("Sửa điểm sinh viên thành công.");
					}
				} else {
					System.out.println("Mã sinh viên không tồn tại.");
				}
			}

		} catch (Exception ex) {
			System.out.println("Truy cập thất bại.");
		} finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement1!=null) {
				try {
					statement1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Xóa điểm sinh viên theo mã sinh viên.
	 * 
	 * @param conn
	 * @param diem
	 */

	public void deleteDiem(Connection conn, String masv) {
		String sql = "DELETE FROM `diem` WHERE `masv`=?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, masv);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Xóa thành công.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Hiển thị tất cả sinh viên
	 * 
	 * @param conn
	 * @param masv
	 * @param ten
	 * @param monhoc
	 * @param diem
	 */

	public void showSinhVien(Connection conn, String masv, String ten, String monhoc, int diem) {
		String sql = "SELECT sinh_vien.masv,sinh_vien.ten,diem.monhoc,diem.diem\r\n" + "FROM sinh_vien \r\n"
				+ "LEFT JOIN diem ON sinh_vien.masv = diem.masv;";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("masv") + " " + result.getString("ten") + " "
						+ result.getString("monhoc") + " " + result.getInt("diem"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiển thị sinh viên theo mã sinh viên.
	 * 
	 * @param conn
	 * @param masv
	 */

	public void displaySinhVien(Connection conn, String ten) {
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement("SELECT sinh_vien.masv,sinh_vien.ten,diem.monhoc,diem.diem\r\n" + "FROM sinh_vien \r\n"
					+ "LEFT JOIN diem ON sinh_vien.masv = diem.masv WHERE sinh_vien.ten = ?");
			statement.setString(1, ten);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (result.getString("sinh_vien.ten").equals(ten)) {
					System.out.println(result.getString("masv") + " " + result.getString("ten") + " "
							+ result.getString("monhoc") + " " + result.getString("diem"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
