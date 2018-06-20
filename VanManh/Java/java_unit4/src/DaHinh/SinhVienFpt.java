package DaHinh;

abstract public class SinhVienFpt {
	private String hoTen;
	private String nganh;

	public SinhVienFpt(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	abstract public double getDiem();

	public String getHocLuc(double diemTB) {
		String xepLoai;
		if (diemTB < 5) {
			xepLoai = "Yếu";
		} else if (diemTB < 6.5) {
			xepLoai = "Trung bình";
		} else if (diemTB < 7.5) {
			xepLoai = "Khá";
		} else if (diemTB < 9) {
			xepLoai = "Giỏi";
		} else {
			xepLoai = "Xuất sắc";
		}
		return xepLoai;
	}

	public void xuat() {
		System.out.println("Họ và tên : " + hoTen);
		System.out.println("Ngành  : " + nganh);
	}
}
