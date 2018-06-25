
import java.util.Scanner;

public class SanPham {
	private String tenSp;
	private double donGia;
	private double giamGia;
	public double getThueNhapKhau() {
		return donGia*10/100;
	}
	public void nhap(Scanner scanner) {
		System.out.print("Nhập tên sp: ");
		tenSp = scanner.nextLine();
		System.out.print("Nhập đơn giá: ");
		donGia = scanner.nextDouble();
		System.out.print("Nhập giảm giá: ");
		giamGia = scanner.nextDouble();
		
		
	}
	public void xuat() {
		System.out.println("Tên sản phẩm: " +tenSp);
		System.out.println("Đơn giá: " +donGia);
		System.out.println("Giảm giá " +giamGia);
		System.out.println("Thuế nhập khẩu:" +getThueNhapKhau());
	}
	public SanPham() {
		
	}
	public SanPham(String tenSp, double donGia, double giamGia) {
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}
	public SanPham(String tenSp, double donGia) {
		this(tenSp, donGia, 0);
	}
	
	public String getTenSp() {
		return this.tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	
	public double getDonGia() {
		return this.donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public double getGiamGia() {
		return this.giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SanPham sp1 = new SanPham();
		sp1.nhap(scanner);
		sp1.xuat();
//		SanPham sp2 = new SanPham();
//		sp2.nhap(scanner);
//		sp2.xuat();
		
//		SanPham sp1 = new SanPham("tivi", 10);
//		sp1.xuat();
		
		
	}
}
