package baiHoc;

public class LaoCong extends NhanVien {

	private int lamthem;

	public int getLamthem() {
		return lamthem;
	}

	public void setLamthem(int lamthem) {
		this.lamthem = lamthem;
	}

	public double thueThuNhap() {
		return super.thueThuNhap() + lamthem;
	}

}
