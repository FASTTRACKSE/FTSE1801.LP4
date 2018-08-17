package quanly_thuvien.model.entity;

public class Quan {
	private int maQuanHhuyen;
	private String tenQuanHuyen;
	private ThanhPho maThanhPho;

	public Quan(int maQuanHhuyen, String tenQuanHuyen, ThanhPho maThanhPho) {
		super();
		this.maQuanHhuyen = maQuanHhuyen;
		this.tenQuanHuyen = tenQuanHuyen;
		this.maThanhPho = maThanhPho;
	}

	public Quan() {

	}

	public int getMaQuanHhuyen() {
		return maQuanHhuyen;
	}

	public void setMaQuanHhuyen(int maQuanHhuyen) {
		this.maQuanHhuyen = maQuanHhuyen;
	}

	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}

	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
	}

	public ThanhPho getMaThanhPho() {
		return maThanhPho;
	}

	public void setMaThanhPho(ThanhPho maThanhPho) {
		this.maThanhPho = maThanhPho;
	}

	public String toString() {
		return tenQuanHuyen;
	}
}
