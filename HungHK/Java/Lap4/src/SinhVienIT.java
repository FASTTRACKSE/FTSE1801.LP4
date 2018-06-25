

public class SinhVienIT extends SinhVienFpt {
	public double diemJava;
	public double diemCss;
	public double diemHtml;
	
	public SinhVienIT(String hoTen, String nghanh, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, nghanh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (diemJava*2 + diemCss + diemHtml)/4;
	}
	
	
}
