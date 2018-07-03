package demo;

public class Cua extends DongVat {
	private int soCang;

	public Cua(String ten, int soChan, int soMat, String tiengKeu, int soCang) {
		super(ten, soChan, soMat, tiengKeu);
		this.soCang = soCang;

	}

	public int getSoCang() {
		return soCang;
	}

	public void in() {
		System.out.println("Đây là cua");
		super.in();
		System.out.println("Số càng: " + getSoCang());
	}
}
