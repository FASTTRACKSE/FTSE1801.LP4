package baiHoc;

public class TruongPhong extends NhanVien {
	private int trachNhiem;

	public int getTrachNhiem() {
		return trachNhiem;
	}

	public void setTrachNhiem(int trachNhiem) {
		this.trachNhiem = trachNhiem;
	}

	public double thueThuNhap() {
		return super.thueThuNhap() + trachNhiem;
	}

}
