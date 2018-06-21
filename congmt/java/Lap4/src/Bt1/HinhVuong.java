package Bt1;
public class HinhVuong extends ChuNhat {
	
	public HinhVuong(double canh) {
		super(canh, canh);
	}
	public void xuat() {
		System.out.println("- Đâylà hình vuông:");
		System.out.println("- Cạnh của hình vuông:" + getDai());
		
		System.out.println("- Dien tích:" + getDienTich());
		System.out.println("- Chu vi:" + getChuVi());
	}
	
}
