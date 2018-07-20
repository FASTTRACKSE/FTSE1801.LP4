import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class SinhVien {
	Connection conn = null;

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?characterEncoding=UTF-8";
		Properties properties = new Properties();
		properties.put("user", strUser);
		properties.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = driver.connect(strConnect, properties);
			System.out.println("Kết nối MYSQL thành công");
		} catch (SQLException ex) {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void menu() {
		String masv = null;
		String ten = null;
		String pass = null;
		String monhoc = null;
		int diem = 0;
		boolean check = false;
		QuanLy ql = new QuanLy();
		while (true) {
			System.out.println("1. Thêm sinh viên mới.");
			System.out.println("2. Sửa điểm sinh viên.");
			System.out.println("3. Sưả thông tin sinh viên theo mã sinh viên.");
			System.out.println("4. Xóa sinh viên theo mã.");
			System.out.println("5. Sửa hoặc xóa điểm sinh viên theo mã môn học.");
			System.out.println("6. Hiển thi tất cả sinh viên.");
			System.out.println("7. Hiển thị sinh viên theo tên.");
			System.out.println("0. Kết thúc chương trình.");

			Scanner sc = new Scanner(System.in);
			System.out.println("Lựa chọn của bạn: ");
			int choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1:
				System.out.println("Nhập mã sinh viên: ");
				masv = sc.nextLine();
				System.out.println("Nhập tên sinh viên: ");
				ten = sc.nextLine();
				System.out.println("Nhập password: ");
				pass = sc.nextLine();
				ql.addSinhVien(conn, masv, ten, pass);
				break;
			case 2:
				System.out.println("Nhập mã sinh viên cần sửa điểm: ");
				masv = sc.nextLine();
				System.out.println("Nhập môn học: ");
				monhoc = sc.nextLine();
				do {
					check = false;
					try {
						System.out.println("Nhập điểm: ");
						String strDiem = sc.nextLine();
						diem = Integer.parseInt(strDiem);
					} catch (Exception e) {
						check = true;
						System.out.println("Điểm phải là số mời bạn nhập lại.");
					}
				} while (check);
				ql.addDiem(conn, masv, monhoc, diem);
				break;
			case 3:
				System.out.println("Nhập mã sinh viên cần sửa: ");
				masv = sc.nextLine();
				System.out.println("Nhập mới tên sinh viên: ");
				ten = sc.nextLine();
				System.out.println("Nhập mới password: ");
				pass = sc.nextLine();
				ql.updateSinhVien(conn, masv, ten, pass);
				break;
			case 4:
				System.out.println("Nhập mã sinh viên cần xóa: ");
				masv = sc.nextLine();
				ql.deleteSinhVien(conn, masv);
				break;
			case 5:
				System.out.println("Nhập mã sinh viên cần xóa: ");
				masv = sc.nextLine();
				ql.deleteDiem(conn, masv);
				break;
			case 6:
				System.out.println("Danh sách sinh viên: ");
				ql.showSinhVien(conn, masv, ten, monhoc, diem);
				break;
			case 7:
				System.out.println("Nhập tên sinh viên muốn hiển thị: ");
				ten = sc.nextLine();
				ql.displaySinhVien(conn, ten);
				break;
			case 0:
				System.out.println("Kết thúc chương trình!!!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Chọn sai, mời chọn lại: ");
				break;
			}
		}
	}

	public void disConnect() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Đóng MYSQL thành công");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		QuanLy ql = new QuanLy();
		sv.getConnect("localhost", "diem_sinhvien", "root", "");
		sv.menu();
		sv.disConnect();
	}
}
