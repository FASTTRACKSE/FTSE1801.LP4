package demo.demo2;

public class TruongPhong extends NhanVien {
	private int tienTrachNhiem;

	public int getTienTrachNhiem() {
		return tienTrachNhiem;
	}

	public void setTienTrachNhiem(int tienTrachNhiem) {
		this.tienTrachNhiem = tienTrachNhiem;
	}

	public double getThuNhap() {
		return super.getThuNhap() + tienTrachNhiem;
	}

}
