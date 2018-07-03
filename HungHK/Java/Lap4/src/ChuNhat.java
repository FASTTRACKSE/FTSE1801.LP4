

public class ChuNhat {
	private double dai;
	private double rong;
	public ChuNhat(double dai, double rong) {
		this.dai = dai;
		this.rong = rong;
	}
	
	public double getChuVi() {
		return (dai+rong)*2;
	}
	public double getDienTich() {
		return dai*rong;
	}
	public void xuat() {
//		System.out.format("Hình chữ nhật có chiều dài %d và chiều rộng %d", dai, rong);
		System.out.println("Chu vi hình chữ nhật: " + getChuVi());
		System.out.println("Diện tích hình chữ nhật: " + getDienTich());
	}
}
