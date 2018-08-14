package demotruutuong;

public class HinhVuong extends HinhChuNhat{
	double canh;
	
	public HinhVuong(double canh) {
		super(canh, canh);
	}
	
	void xuat() {
		System.out.println("Hình vuông");
		super.xuat();
		
	}
	
	public static void main(String[] args) {
		HinhVuong v = new HinhVuong(2);
		v.xuat();
		Tron t = new Tron(2);
		t.xuat();
	}
}
