package TruuTuong;

public class ClassHinh {
	public static void main(String[] args) {
		HinhTron hinhTron = new HinhTron(4);
		System.out.println("Chu vi hình tròn là : " + hinhTron.chuVi());
		System.out.println("Diện tích hình tròn là : " + hinhTron.dienTich());
		System.out.println();

		HinhChuNhat hinhCHuNhat = new HinhChuNhat(5, 3);
		System.out.println("Chu vi hình chữ nhật là : " + hinhCHuNhat.chuVi());
		System.out.println("Diện tích hình chữ nhật là : " + hinhCHuNhat.dienTich());
		System.out.println();

		HinhVuong hinhVuong = new HinhVuong(6);
		System.out.println("Chu vi hình vuông là : " + hinhVuong.chuVi());
		System.out.println("Diện tích hình vuông là : " + hinhVuong.dienTich());
	}

}
