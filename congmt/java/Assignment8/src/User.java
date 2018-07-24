import java.util.ArrayList;
import java.util.Scanner;

public class User {

private String tenTaiKhoan;
private double soDuTaiKhoan;
private String loaiTien;
private String trangThaiTK;
public User() {
	
}
public User(String tenTaiKhoan, double soDuTaiKhoan, String loaiTien, String trangThaiTK) {
	this.tenTaiKhoan = tenTaiKhoan;
	this.soDuTaiKhoan = soDuTaiKhoan;
	this.loaiTien = loaiTien;
	this.trangThaiTK = trangThaiTK;
	
}

public String getTenTaiKhoan() {
	return tenTaiKhoan;
}
public void setTenTaiKhoan(String tenTaiKhoan) {
	this.tenTaiKhoan = tenTaiKhoan;
}
public double getSoDuTaiKhoan() {
	return soDuTaiKhoan;
}
public void setSoDuTaiKhoan(double soDuTaiKhoan) {
	this.soDuTaiKhoan = soDuTaiKhoan;
}
public String getLoaiTien( Scanner sc) {
	System.out.print("Nhấp chọn loại tiền: 1. VND  2.USD  3. ERO  ");
	int choose = sc.nextInt();
	switch (choose) {
	case 1:
		System.out.println("VND");
		break;
	case 2:
		System.out.println("USD");
		break;
	case 3:
		System.out.println("ERO");
		break;

	default:
		System.out.println("Khong co loai tien nay!");
		break;
	}
	return loaiTien;
}
public void setLoaiTien(String loaiTien) {
	this.loaiTien = loaiTien;
}
public String getTrangThaiTK() {
	return trangThaiTK;
}
public void setTrangThaiTK(String trangThaiTK) {
	this.trangThaiTK = trangThaiTK;
}


}
