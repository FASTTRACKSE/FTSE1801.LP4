package LapUnit4;

public class HinhVuong extends ChuNhat{
	
	public HinhVuong(double canh) {
		super(canh,canh);
	}
	
	public void xuat() {
		System.out.print("Cạnh hình vuông là : ");
		System.out.println(getChieuDai());
		System.out.print("Chu vi hình vuông là : ");
		System.out.println(getChuVi());
		System.out.print("Diện tích vuông là : ");
		System.out.println(getDienTich());
	}
}
