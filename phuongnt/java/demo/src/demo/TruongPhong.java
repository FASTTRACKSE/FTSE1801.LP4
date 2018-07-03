package demo;

public class TruongPhong extends NhanVien {
	private double tienTrachNhiem;

	public double getTienTrachNhiem() {
		return tienTrachNhiem;
	}

	public void setTienTrachNhiem(double tienTrachNhiem) {
		this.tienTrachNhiem = tienTrachNhiem;
	}

	public double getThuNhap() {
		return super.getThuNhap() + tienTrachNhiem;
	}
}
