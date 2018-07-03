package demo;

public class Ca extends DongVat {
	private int soVay;

	public Ca(String ten, int soChan, int soMat, String tiengKeu, int soVay) {
		super(ten, soChan, soMat, tiengKeu);
		this.soVay = soVay;
		
	}

	public int getSoVay() {
		return soVay;
	}

	public void in() {
		System.out.println("Đây là cá");
		super.in();
		System.out.println("Số vay" + getSoVay());
	}
}
