package demo_d4;

public class HinhVuong extends ChuNhat{
	public HinhVuong(double canh) {
		super (canh, canh);
	}
	
	public void xuat() {
		System.out.println("H�nh vu�ng: ");
		super.xuat();
	}
}
