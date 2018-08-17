package quanly_thuvien.model.entity;

public class ThanhPho {
	private int maThanhPho;
	private String tenThanhPho;

	public ThanhPho(int maThanhPho, String tenThanhPho) {
		super();
		this.maThanhPho = maThanhPho;
		this.tenThanhPho = tenThanhPho;
	}

	public ThanhPho() {

	}

	public int getMaThanhPho() {
		return maThanhPho;
	}

	public void setMaThanhPho(int maThanhPho) {
		this.maThanhPho = maThanhPho;
	}

	public String getTenThanhPho() {
		return tenThanhPho;
	}

	public void setTenThanhPho(String tenThanhPho) {
		this.tenThanhPho = tenThanhPho;
	}

	public String toString() {
		return tenThanhPho;
	}
}
