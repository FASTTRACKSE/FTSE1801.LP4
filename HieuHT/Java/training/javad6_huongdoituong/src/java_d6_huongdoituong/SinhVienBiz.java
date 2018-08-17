package java_d6_huongdoituong;

public class SinhVienBiz extends sinhvienFPT {
	private double marketing;
	private double sales;

	public SinhVienBiz(String hoTen, String nganh, double marketing, double sales) {
		super(hoTen, nganh);
		this.marketing = marketing;
		this.sales = sales;
	}

	public double getMarketing() {
		return marketing;
	}

	public void setMarketing(double marketing) {
		this.marketing = marketing;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	double getDiem() {

		return (marketing * 2 + sales) / 3;
	}

}
