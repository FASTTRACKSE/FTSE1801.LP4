package LapUnit4;

public class Cua extends DongVat{
	private int soCang;

	public int getSoCang() {
		return soCang;
	}

	public void setSoCang(int soCang) {
		this.soCang = soCang;
	}
	
	public void in() {
		super.in();
		System.out.println("Có số càng là :" + getSoCang());
	}
	
}
