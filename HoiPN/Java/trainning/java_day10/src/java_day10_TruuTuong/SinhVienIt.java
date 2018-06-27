package java_day10_TruuTuong;

public class SinhVienIt extends SinhVienFpt {
	double diemJava;
	double diemCss;
	double diemHtml;	

	public SinhVienIt(String hoTen, String nganh, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, nganh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}
	@Override
	double getDiem() {
		// TODO Auto-generated method stub
		return (diemJava + diemCss + diemHtml)/3;
	}
	
}
