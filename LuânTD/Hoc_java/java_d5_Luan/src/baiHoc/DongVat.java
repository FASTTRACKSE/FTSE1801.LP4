package baiHoc;

public class DongVat {
	private String ten;
	private int soChan;
	private int soMat;
	private String tiengKeu;
	
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
		System.out.printf(ten+" | "+soChan+" | "+soMat+" | "+tiengKeu);
		System.out.println();
	}

}
