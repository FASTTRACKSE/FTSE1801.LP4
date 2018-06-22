package java_d6_huongdoituong;

public class SinhVienIT extends sinhvienFPT {
	private double java;
	private double html;
	private double css;

	public SinhVienIT(String hoTen, String nganh, double java, double html, double css) {
		super(hoTen, nganh);
		this.java = java;
		this.html = html;
		this.css = css;
	}

	public double getJava() {
		return java;
	}

	public void setJava(double java) {
		this.java = java;
	}

	public double getHtml() {
		return html;
	}

	public void setHtml(double html) {
		this.html = html;
	}

	public double getCss() {
		return css;
	}

	public void setCss(double css) {
		this.css = css;
	}

	double getDiem() {

		return (2 * java + html + css) / 4;
	}

}
