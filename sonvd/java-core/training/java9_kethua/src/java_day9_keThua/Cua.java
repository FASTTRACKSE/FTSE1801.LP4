package java_day9_keThua;

public class Cua extends DongVat{
	private int soCang;

	public int getSoCang() {
		return soCang;
	}

	public void setSoCang(int soCang) {
		this.soCang = soCang;
	}
	void in() {
		super.in();
		System.out.println("Số càng: " + getSoCang());
	}
}
