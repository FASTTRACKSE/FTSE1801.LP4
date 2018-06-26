package java_day9_keThua;

public class TruongPhong extends nhanvien {
	private int trachNhiem;

	public int getTrachNhiem() {
		return trachNhiem;
	}

	public void setTrachNhiem(int trachNhiem) {
		this.trachNhiem = trachNhiem;
	}
	public int getThuNhap() {
		return super.getThuNhap()+trachNhiem;
	}

}
