package dongvat;

public class Meo extends DongVat {
	private int soRau;

	public Meo(String ten, int soChan, int soMat, String tiengKeu, int soRau) {
		super(ten, soChan, soMat, tiengKeu);
		this.soRau = soRau;
	}

	public int getSoRau() {
		return soRau;
	}

	public void setSoRau(int soRau) {
		this.soRau = soRau;
	}

	public void in() {
		System.out.println("- Đây là động vật:");
		 System.out.println("- Có tên là:" + getTen());
		 System.out.println("- Có số râu là:" + getSoRau() );
		 System.out.println("- Có số chân là:" + getSoChan());
		 System.out.println("- Có số mắt là:" + getSoMat());
		 System.out.println("- Có tiếng kêu là:" + getTiengKeu());
	}

}
