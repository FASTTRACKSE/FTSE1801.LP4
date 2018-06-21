package assignment3;

public class Meo extends DongVat {
	private int soRau;

	public Meo(String ten, int soChan, int soMat, String tiengKeu, int soRau) {
		super(ten, soChan, soMat, tiengKeu);
		this.soRau = soRau;
	
	}

	public int getSoRau() {
		return soRau;
	}

	public void in() {
		System.out.println("Đây là mèo");
		super.in();
		System.out.println("Số râu: " + getSoRau());
	}
}
