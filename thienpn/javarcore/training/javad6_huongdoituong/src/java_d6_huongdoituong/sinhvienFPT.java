package java_d6_huongdoituong;

public abstract class sinhvienFPT {
	private String HoTen;
	private String Nganh;

	public sinhvienFPT(String hoTen, String nganh) {
		
		HoTen = hoTen;
		Nganh = nganh;
	}

	abstract double getDiem();

	String getHocLuc() {
		if (getDiem() < 5) {
			return "yếu";
		} else if (getDiem() < 6.5) {
			return "trung bình";
		} else if (getDiem() < 7.5) {
			return "Khá";
		} else if (getDiem() < 9) {
			return "Giỏi";
		} else {
			return "Xuất Sắc";
		}

	}

	public void xuat() {
		System.out.println("Họ Tên SV: " + HoTen);
		System.out.println("Ngành SV: " + Nganh);
		System.out.println("Điểm SV: " + getDiem());
		System.out.println("Xếp loại SV: " + getHocLuc());
	}
}
