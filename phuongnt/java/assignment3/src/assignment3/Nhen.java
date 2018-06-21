package assignment3;

public class Nhen extends DongVat{
	
	public Nhen(String ten, int soChan, int soMat, String tiengKeu) {
		super(ten, soChan, soMat, tiengKeu);
	
	}

	public void in() {
		System.out.println("Đây là nhện");
		super.in();
	}
}
