package LapUnit4;

public class Ca extends DongVat{
	private int soVay;

	public int getSoVay() {
		return soVay;
	}

	public void setSoVay(int soVay) {
		this.soVay = soVay;
	}
	
	public void in() {
		super.in();
		System.out.println("Có số vây là :" + getSoVay());
	}
}
