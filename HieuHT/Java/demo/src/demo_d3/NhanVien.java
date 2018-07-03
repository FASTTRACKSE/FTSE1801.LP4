package demo_d3;

import java.util.Scanner;

public class NhanVien {
	String ten;
	int tuoi;
	String diachi;
	String gioitinh;
	long luong;

	void setten(String ten) {
		this.ten = ten;
	}

	void settuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	void setdiachi(String diachi) {
		this.diachi = diachi;
	}

	void setgioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	void setluong(long luong) {
		this.luong = luong;
	}

	String getten() {
		return ten;
	}

	int gettuoi() {
		return tuoi;
	}

	String getdiachi() {
		return diachi;
	}

	String getgioitinh() {
		return gioitinh;
	}

	long getluong() {
		return luong;
	}

	public static void main(String args[]) {
		System.out.println("Thông tin nhân viên:");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		String ten = sc.nextLine();
		System.out.print("Nhập tuổi: ");
		int tuoi = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhập Địa chỉ: ");
		String diachi = sc.nextLine();
		System.out.print("Nhập giới tính: ");
		String gioitinh = sc.nextLine();
		System.out.print("Nhập lương: ");
		String luong = sc.nextLine();
		System.out.printf("%3s| %-30s| %4s| %10s| %10s| %8s|\n", "STT", "Họ Và Tên", "Tuổi", "Địa chỉ", "Giới tính",
				"Lương");
		System.out.printf("%3s| %-30s| %4s| %10s| %10s| %8s| \n", "1", ten, tuoi, diachi, gioitinh, luong);
	}
}
