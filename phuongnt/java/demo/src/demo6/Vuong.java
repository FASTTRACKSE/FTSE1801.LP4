package demo6;

public class Vuong extends ChuNhat {
	public Vuong() {
		System.out.println("Vuong");
	}

	public Vuong(double canh1, double canh2) {
		
	}

	public Vuong(double canh) {
		this();
	}

	public void xuat() {
		System.out.println("Đây là hình vuông");

	}

	public static void main(String[] args) {
		Vuong v = new Vuong(1, 1);
	}
}
