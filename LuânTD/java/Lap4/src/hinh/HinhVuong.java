package hinh;

public class HinhVuong extends HinhChuNhat {
	public HinhVuong(double canh) {
		super(canh,canh);
	}
	
	public void xuat() {
		System.out.println("Chieu dai canh: "+getDai());
		System.out.println("Chu vi hinh chu nhat: "+getChuVi());
		System.out.println("Dien tich hinh chu nhat: "+getDienTich());
	}
}
