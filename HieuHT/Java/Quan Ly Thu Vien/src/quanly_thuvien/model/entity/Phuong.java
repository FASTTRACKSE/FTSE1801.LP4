package quanly_thuvien.model.entity;

public class Phuong {
	private int maPhuongXa;
	private String tenPhuongXa;
	private Quan maQuanHuyen;

	public Phuong(int maPhuongXa, String tenPhuongXa, Quan maQuanHuyen) {
		super();
		this.maPhuongXa = maPhuongXa;
		this.tenPhuongXa = tenPhuongXa;
		this.maQuanHuyen = maQuanHuyen;
	}

	public Phuong() {

	}

	public int getMaPhuongXa() {
		return maPhuongXa;
	}

	public void setMaPhuongXa(int maPhuongXa) {
		this.maPhuongXa = maPhuongXa;
	}

	public String getTenPhuongXa() {
		return tenPhuongXa;
	}

	public void setTenPhuongXa(String tenPhuongXa) {
		this.tenPhuongXa = tenPhuongXa;
	}

	public Quan getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(Quan maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}

	public String toString() {
		return tenPhuongXa;
	}
}
