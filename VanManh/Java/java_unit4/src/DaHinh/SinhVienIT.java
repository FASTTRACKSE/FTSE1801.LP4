package DaHinh;

public class SinhVienIT extends SinhVienFpt {
	private double java;
	private double html;
	private double css;

	public SinhVienIT(String hoTen, String nganh, double java, double html, double css) {
		super(hoTen, nganh);
		this.java = java;
		this.html = html;
		this.css = css;
	}

	public double getDiem() {
		return (2 * java + html + css) / 4;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Điểm trung bình là : " + getDiem());
		System.out.println("Xếp loại : " + super.getHocLuc(getDiem()));
	}

}
