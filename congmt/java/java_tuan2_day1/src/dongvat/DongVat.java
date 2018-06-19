package dongvat;

public class DongVat {
 private String ten;
 private int soChan;
 private int soMat;

private String tiengKeu;
public DongVat(String ten, int soChan,int soMat, String tiengKeu) {
	super();
	this.ten = ten;
	this.soChan = soChan;
	this.soMat=soMat;
	this.tiengKeu = tiengKeu;
}
public int getSoMat() {
	return soMat;
}
public void setSoMat(int soMat) {
	this.soMat = soMat;
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
public String getTiengKeu() {
	return tiengKeu;
}
public void setTiengKeu(String tiengKeu) {
	this.tiengKeu = tiengKeu;
}
 public void in() {
	 System.out.println("- Đây là động vật:");
	 System.out.println("- Có tên là:" + getTen());
	 System.out.println("- Có số chân là:" + getSoChan());
	 System.out.println("- Có số mắt là:" + getSoMat());
	 System.out.println("- Có tiếng kêu là:" + getTiengKeu());
	 
 }
}
