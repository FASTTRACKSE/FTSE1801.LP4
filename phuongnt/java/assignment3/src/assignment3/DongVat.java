package assignment3;

public class DongVat {
	private String ten;
	private int soChan;
	private int soMat;
	private String tiengKeu;

	public DongVat(String ten, int soChan, int soMat, String tiengKeu) {
		
		this.ten = ten;
		this.soChan = soChan;
		this.soMat = soMat;
		this.tiengKeu = tiengKeu;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getSoChan() {
		return soChan;
	}

	public void setSoChan(int soChan) {
		this.soChan = soChan;
	}

	public int getSoMat() {
		return soMat;
	}

	public void setSoMat(int soMat) {
		this.soMat = soMat;
	}

	public String getTiengKeu() {
		return tiengKeu;
	}

	public void setTiengKeu(String tiengKeu) {
		this.tiengKeu = tiengKeu;
	}
	public void in() {
		System.out.println("Tên: "+getTen());
		System.out.println("Số Chân: "+getSoChan());
		System.out.println("Số mắt: "+getSoMat());
		System.out.println("Tiếng kêu: "+getTiengKeu());
	}
}
