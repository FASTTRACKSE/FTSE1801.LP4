package dongvat;

public class Ca extends DongVat {
private int soVay;

public Ca(String ten,int soVay, int soChan, int soMat, String tiengKeu) {
	super(ten,soMat, soChan, tiengKeu);
	this.soVay=soVay;
	// TODO Auto-generated constructor stub
}

public int getSoVay() {
	return soVay;
}

public void setSoVay(int soVay) {
	this.soVay = soVay;
}

public void in() {
	System.out.println("- Đây là động vật:");
	 System.out.println("- Có tên là:" + getTen());
	 System.out.println("- Có số vẫy là:" + getSoVay() );
	 System.out.println("- Có số chân là:" + getSoChan());
	 System.out.println("- Có số mắt là:" + getSoMat());
	 System.out.println("- Có tiếng kêu là:" + getTiengKeu());
}

}
