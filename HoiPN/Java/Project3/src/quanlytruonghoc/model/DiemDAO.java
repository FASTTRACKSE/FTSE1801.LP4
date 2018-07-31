package quanlytruonghoc.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * DiemDao Class
 * 
 * @author CongMT
 *
 */
public class DiemDAO {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;

	public ArrayList<Double> getAllDiemThi(String idsv) {
		String sql = "SELECT `diemthi` FROM `diem` WHERE `idsv` = ?";
		conn = DatabasaUltil.getConnect();
		ArrayList<Double> listDiem = new ArrayList<Double>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				listDiem.add(Double.parseDouble(result.getString("diemthi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return listDiem;
	}
	
}
