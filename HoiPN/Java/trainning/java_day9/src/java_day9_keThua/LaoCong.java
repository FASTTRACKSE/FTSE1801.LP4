package java_day9_keThua;

public class LaoCong extends nhanvien{
	private int tienLamThem;

	public int getTienLamThem() {
		return tienLamThem;
	}

	public void setTienLamThem(int tienLamThem) {
		this.tienLamThem = tienLamThem;
	}
	public int getThuNhap() {
		return super.getThuNhap() + tienLamThem;
	}
}
