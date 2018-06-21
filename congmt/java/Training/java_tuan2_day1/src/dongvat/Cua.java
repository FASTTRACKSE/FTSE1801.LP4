package dongvat;

public class Cua extends DongVat{
	private int soCang;

	public Cua(String ten,int soCang, int soChan, int soMat, String tiengKeu) {
		super(ten, soChan, soMat, tiengKeu);
		this.soCang = soCang;
	}
	
	public int getSoCang() {
		return soCang;
	}

	public void setSoCang(int soCang) {
		this.soCang = soCang;
	}

	public void in() {
		System.out.println("- Đây là động vật:");
		 System.out.println("- Có tên là:" + getTen());
		 System.out.println("- Có số càng là:" + getSoCang());
		 System.out.println("- Có số chân là:" + getSoChan());
		 System.out.println("- Có số mắt là:" + getSoMat());
		 System.out.println("- Có tiếng kêu là:" + getTiengKeu());
	}

}
