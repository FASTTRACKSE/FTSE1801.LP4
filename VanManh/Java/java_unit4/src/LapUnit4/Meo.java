package LapUnit4;

public class Meo extends DongVat{
	private int soRau;

	public int getSoRau() {
		return soRau;
	}

	public void setSoRau(int soRau) {
		this.soRau = soRau;
	}
	
	public void in() {
		super.in();
		System.out.println("Có số vây là :" + getSoRau());
	}
}
