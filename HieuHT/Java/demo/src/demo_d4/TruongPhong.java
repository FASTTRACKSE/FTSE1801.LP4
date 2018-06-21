package demo_d4;

public class TruongPhong extends NhanVien {
	private double TienTrachNhiem;

	public double getTienTrachNhiem() {
		return TienTrachNhiem;
	}

	public void setTienTrachNhiem(double d) {
		this.TienTrachNhiem = d;
	}

	public double getThuNhap() {
		return (luong*12) + TienTrachNhiem;
	}
}