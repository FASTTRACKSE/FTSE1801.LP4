package LapUnit4;

public class ChuNhat {
	private double chieuDai;
	private double chieuRong;

	public ChuNhat(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	public double getChieuDai() {
		return chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public double getChuVi() {
		return (chieuDai + chieuRong) * 2;
	}

	public double getDienTich() {
		return chieuDai * chieuRong;
	}

	public void xuat() {
		System.out.print("Chiều dài hình chữ nhật là : ");
		System.out.println(getChieuDai());
		System.out.print("Chiều rồng hình chữ nhật là : ");
		System.out.println(getChieuRong());
		System.out.print("Chu vi hình chữ nhật là : ");
		System.out.println(getChuVi());
		System.out.print("Diện tích hình chữ nhật là : ");
		System.out.println(getDienTich());
	}

}
