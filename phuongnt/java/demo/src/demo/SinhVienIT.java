package demo;

public class SinhVienIT extends SinhVienFPT {
	private double diemJava;
	private double diemCss;
	private double diemHtml;

	public SinhVienIT(String hoTen, String nganh, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, nganh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}

	public double getDiemJava() {
		return diemJava;
	}

	public void setDiemJava(double diemJava) {
		this.diemJava = diemJava;
	}

	public double getDiemCss() {
		return diemCss;
	}

	public void setDiemCss(double diemCss) {
		this.diemCss = diemCss;
	}

	public double getDiemHtml() {
		return diemHtml;
	}

	public void setDiemHtml(double diemHtml) {
		this.diemHtml = diemHtml;
	}

	@Override
	public double getDiem() {

		return 0;
	}

}
