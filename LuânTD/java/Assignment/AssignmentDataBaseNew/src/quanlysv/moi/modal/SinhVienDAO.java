package quanlysv.moi.modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import quanlysv.moi.entity.Diem;
import quanlysv.moi.entity.SinhVien;

public class SinhVienDAO {
	Connection conn;

	/**
	 * Hien thi tat ca sinh vien
	 * 
	 * @return
	 */
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = " select * from sinh_vien 	LEFT JOIN diem ON sinh_vien.maSV = diem.maSV";
		conn = DatabaseUntil.getConnection();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		PreparedStatement statement = null;
		boolean kiemtra = false;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;
			Diem diem;
			while (result.next()) {
				sinhvien = new SinhVien();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getMaSV().equals(result.getString("diem.maSV"))) {
						kiemtra = true;
						break;
					} else {
						kiemtra = false;
					}
				}

				if (kiemtra) {
					sinhvien.setMaSV("");
					sinhvien.setTenSv("");
					sinhvien.setPass("");
					diem = new Diem();
					diem.setMonHoc(result.getString("monHoc"));
					diem.setDiem(result.getDouble("diem"));
					sinhvien.setDiem(diem);
				} else {
					
					sinhvien.setMaSV(result.getString("maSV"));
					sinhvien.setTenSv(result.getString("tenSv"));
					sinhvien.setPass(result.getString("pass"));
					diem = new Diem();
					diem.setMonHoc(result.getString("monHoc"));
					diem.setDiem(result.getDouble("diem"));
					sinhvien.setDiem(diem);

				}

				list.add(sinhvien);

			}
		} catch (Exception e) {
			System.out.println("loi");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return list;

	}

	/**
	 * Hien thi sinh vien theo ten
	 * 
	 * @param sinhVien
	 * @return
	 */
	public ArrayList<SinhVien> getSinhVienByName(SinhVien sinhVien) {
		String sql = " select * from sinh_vien 	LEFT JOIN diem ON sinh_vien.maSV = diem.maSV where tenSV = ?";
		conn = DatabaseUntil.getConnection();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		PreparedStatement statement = null;
		boolean kiemtra = false;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getTenSv());
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;
			Diem diem;
			
			while (result.next()) {
				sinhvien = new SinhVien();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getMaSV().equals(result.getString("diem.maSV"))) {
						kiemtra = true;
						break;
					} else {
						kiemtra = false;
					}
				}

				if (kiemtra) {
					sinhvien.setMaSV("");
					sinhvien.setTenSv("");
					sinhvien.setPass("");
					diem = new Diem();
					diem.setMonHoc(result.getString("monHoc"));
					diem.setDiem(result.getDouble("diem"));
					sinhvien.setDiem(diem);
				} else {
					sinhvien.setMaSV(result.getString("maSV"));
					sinhvien.setTenSv(result.getString("tenSv"));
					sinhvien.setPass(result.getString("pass"));
					diem = new Diem();
					diem.setMonHoc(result.getString("monHoc"));
					diem.setDiem(result.getDouble("diem"));
					sinhvien.setDiem(diem);

				}
				list.add(sinhvien);
			}
		} catch (Exception e) {
			System.out.println("loi");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return list;

	}

	public boolean addSinhVien() {
		boolean kiemtra = false;
		SinhVien sinhVien = new SinhVien();
		String sql = "Insert into sinhvien(maSV,tenSV,pass) values(?,?,?)";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSV());
			statement.setString(2, sinhVien.getTenSv());
			statement.setString(3, sinhVien.getPass());
			int count = statement.executeUpdate();
			if (count > 0) {
				kiemtra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemtra;
	}

	/**
	 * them sinh vien
	 * 
	 * @param sinhVien
	 * @return
	 */
	public boolean addSinhVien(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "insert into sinh_vien values(?,?,?)";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSV());
			statement.setString(2, sinhVien.getTenSv());
			statement.setString(3, sinhVien.getPass());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Them diem sinh vien
	 * 
	 * @param sinhVien
	 * @return
	 */
	public boolean addDiemSV(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "insert into diem values(?,?,?)";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSV());
			statement.setString(2, sinhVien.getDiem().getMonHoc());
			statement.setDouble(3, sinhVien.getDiem().getDiem());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;

	}

	public boolean updateDiem(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "update diem set diem = ? where maSV =? and monHoc = ?";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setDouble(1, sinhVien.getDiem().getDiem());
			statement.setString(2, sinhVien.getMaSV());
			statement.setString(3, sinhVien.getDiem().getMonHoc());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	public boolean updateSV(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "update sinh_vien set tenSV = ?, pass = ? where maSV =?";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getTenSv());
			statement.setString(2, sinhVien.getPass());
			statement.setString(3, sinhVien.getMaSV());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	public boolean deleteDiemSV(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "delete from diem where maSV =?";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSV());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	public boolean deleteSV(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "delete from sinh_vien where maSV =?";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSV());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	public boolean updateSVByMaSVAndMonHoc(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "update diem set diem = ?  where maSV =? and monHoc = ?";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setDouble(1, sinhVien.getDiem().getDiem());
			statement.setString(2, sinhVien.getMaSV());
			statement.setString(3, sinhVien.getDiem().getMonHoc());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	public boolean deleteDiemByMaSVAndMonHoc(SinhVien sinhVien) {
		boolean kiemTra = false;
		String sql = "delete from diem where maSV =? and monHoc = ?";
		conn = DatabaseUntil.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSV());
			statement.setString(2, sinhVien.getDiem().getMonHoc());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

}
