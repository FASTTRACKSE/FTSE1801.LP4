package baitap_lap;

public class HinhVuong extends ChuNhat{
	public HinhVuong(double canh) {
		super (canh, canh);
	}
	
	public void xuat() {
		System.out.println("Hình vuông: ");
		super.xuat();
	}
}
