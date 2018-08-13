package java_tuan2_day11;

public  class ChuNhat extends Hinh {
	private double dai;
	private double rong;
	
	public ChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	public double getDai() {
		return dai;
	}
	public void setDai(double dai) {
		this.dai = dai;
	}
	public double getRong() {
		return rong;
	}
	public void setRong(double rong) {
		this.rong = rong;
	}
	public double getDienTich() {
		return dai*rong;
	}
	public double getChuVi() {
		return (dai+rong)*2;
	}
	void xuat() {
		
		System.out.println("- Chiều dài hinh hcn:" + dai);
		System.out.println("- Chiều rộng hinh hcn:" + rong);
		System.out.println("- Dien tích hinh hcn:" + getDienTich());
		System.out.println("- Chu vi hinh hcn:" + getChuVi());
		
	}
	
	public double chuVi() {
		
		return (dai+rong)*2;
	}
	
	public double dienTich() {
		
		return dai*rong;
	}
	public static void main(String[] args) {
		ChuNhat cn = new ChuNhat(4,2);
		cn.xuat();
//		System.out.println("- Chu vi hình chữ nhật là:" + cn.chuVi());
//		System.out.println("- Diện tích hình chữ nhật là:" + cn.dienTich());
		HinhTron ht=new HinhTron(4);
		System.out.println("- Chu vi hình tròn là:" + ht.chuVi());
		System.out.println("- Diện tích hình tròn là:" + ht.dienTich());
		HinhVuong hv = new HinhVuong(4);
		hv.xuat();
		HinhTamGiac tg = new HinhTamGiac(2,5,4,3);
		tg.xuat();
	}
	
	
}
