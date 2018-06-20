package assignment3;

abstract public class SinhVienFPT {
	private String hoTen;
	private String nganh;

	public SinhVienFPT(String hoTen, String nganh) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	abstract public double getDiem();

	public String getHocLuc() {

		if (getDiem() < 5) {
			return " Yếu";

		} else if (getDiem() < 7) {
			return "Trung bình";
		} else if (getDiem() < 7.5) {
			return "Khá";
		} else if (getDiem() < 9) {
			return "Giỏi";
		} else {
			return "Xuất sắc";
		}
	}

	public void xuat() {
		System.out.println("Tên sinh viên: " + hoTen);
		System.out.println("Tên ngành: " + nganh);
		System.out.println("Điểm: " + getDiem());
		System.out.println("Học lực: " + getHocLuc());
	}
}
