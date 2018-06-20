package DaHinh;

public class QuanLySv {
	public static void main(String[] args) {

		SinhVienIT SvIT = new SinhVienIT("Mạnh", "IT", 5, 6, 6);
		SvIT.xuat();
		System.out.println();
		SinhVienBiz SvBiz = new SinhVienBiz("Nam", "Biz", 6, 7);
		SvBiz.xuat();
	}
}
