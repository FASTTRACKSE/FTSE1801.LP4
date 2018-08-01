package quanly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quanly.entity.MayATM;

public class DangNhapDAO {
	Connection conn;
	
	/**
	 * Đăng nhập
	 * 
	 * @param soTK
	 * @param pass
	 * @return
	 */
	public boolean dangNhap(String soTK, String pass) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM the_atm JOIN khach_hang ON the_atm.soTheATM = khach_hang.soTheATM WHERE the_atm.soTK = ? AND the_atm.pass = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, soTK);
			statement.setString(2, pass);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
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
	 * Kiểm tra máy ATM có đủ tiền để rút không
	 * @param mayATM
	 * @param soTien
	 * @return
	 */
	public boolean kiemTraTienMayATM(MayATM mayATM, String soTien) {
		boolean kiemTra = false;
		if (Integer.parseInt(mayATM.getTongTien())>Integer.parseInt(soTien)) {
			kiemTra = true;
		}
		return kiemTra;
	}
}
