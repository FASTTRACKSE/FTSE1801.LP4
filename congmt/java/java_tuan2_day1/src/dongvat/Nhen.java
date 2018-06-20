package dongvat;

public class Nhen extends DongVat {
	public Nhen(String ten, int soChan, int soMat, String tiengKeu) {
		super(ten, soChan, soMat, tiengKeu);
		// TODO Auto-generated constructor stub
	}
	public void Nhen() {}
	public void in() {
		System.out.println("- Đây là động vật:");
		 System.out.println("- Có tên là:" + getTen());
		 System.out.println("- Có số chân là:" + getSoChan());
		 System.out.println("- Có số mắt là:" + getSoMat());
		 System.out.println("- Có tiếng kêu là:" + getTiengKeu());
	}

}