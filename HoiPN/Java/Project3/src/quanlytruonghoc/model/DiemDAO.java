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

	public double getDiemThiJava(String idsv) {
		String sql = "SELECT `diemthi` FROM `diem` WHERE `idsv` = ? AND idmon = 'MMH001'";
		conn = DatabasaUltil.getConnect();
		double diemJava = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemJava = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemJava;
	}
	
	public double getDiemThiHTML(String idsv) {
		String sql = "SELECT `diemthi` FROM `diem` WHERE `idsv` = ? AND idmon = 'MMH002'";
		conn = DatabasaUltil.getConnect();
		double diemHTML = 0;;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemHTML = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemHTML;
	}
	
	public double getDiemThiSQL(String idsv) {
		String sql = "SELECT `diemthi` FROM `diem` WHERE `idsv` = ? AND idmon = 'MMH003'";
		conn = DatabasaUltil.getConnect();
		double diemSQL = 0;;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemSQL = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemSQL;
	}
	
	public double getDiemThiEnligh(String idsv) {
		String sql = "SELECT `diemthi` FROM `diem` WHERE `idsv` = ? AND idmon = 'MMH004'";
		conn = DatabasaUltil.getConnect();
		double diemEnligh = 0;;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idsv);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				diemEnligh = Double.parseDouble(result.getString("diemthi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return diemEnligh;
	}
	
}
