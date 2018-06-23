package SinhVien;

public class SinhVienBiz extends SinhVienFpt {
	private double diemMarketing;
	private double diemSales;

	public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
		super(hoTen, nganh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	public double getDiem() {
		return (2 * diemMarketing + diemSales) / 3;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Diem trung binh: " + getDiem());
		System.out.println("Xep loai: " + super.getHocLuc(getDiem()));

	}

}
