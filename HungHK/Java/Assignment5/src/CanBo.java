import java.util.Scanner;

public class CanBo {
	private String hoTen;
	private float heSoLuong;
	private int phuCap;
	private double luong;
	
	public CanBo() {
	}
	public CanBo(String hoTen, float heSoLuong, int phuCap, double luong) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
		this.luong = luong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public double tinhLuong() {
		return 0;
	}
	
	public void nhapCanBo(Scanner sc) {
		System.out.print("Nhập họ tên: ");
		String hoTen = sc.nextLine();
		setHoTen(hoTen);
		
		System.out.print("Nhập hệ số lương: ");
		float heSoLuong = sc.nextFloat();
		setHeSoLuong(heSoLuong);
	}
	
	public void xuatCanBo() {
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Hệ số lương: " + getHeSoLuong());
	}
}
