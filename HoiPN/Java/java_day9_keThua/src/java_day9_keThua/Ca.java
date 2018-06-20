package java_day9_keThua;

public class Ca extends DongVat{
	private int soVay;


	public int getSoVay() {
		return soVay;
	}


	public void setSoVay(int soVay) {
		this.soVay = soVay;
	}


	void in() {
		super.in();
		System.out.println("Số vảy: " + soVay);
	}
}
