package demo.hinhhoc;

public class Vuong extends ChuNhat {

	public Vuong() {
		System.out.println("Vuong");
	}
	public Vuong(double canh1, double canh2) {
	}
	public Vuong(double Vuong) {
		this();
	}
	public void xuat() {
		System.out.println("Day la hinh vuong ....");
	}

	public static void main(String[] args) {
		Vuong v = new Vuong(1, 1);
	}
}
