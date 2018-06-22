package java_day9_keThua;

public class Meo extends DongVat{
	private int soRau;

	public int getSoRau() {
		return soRau;
	}

	public void setSoRau(int soRau) {
		this.soRau = soRau;
	}
	void in() {
		super.in();
		System.out.println("Số râu: " + getSoRau());
	}
}
