package SinhVien;

abstract public class SinhVienFpt {
	private String hoTen;
	private String nganh;

	public SinhVienFpt(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	abstract public double getDiem();

	public String getHocLuc(double diem) {
		String xl;
		if (diem < 5) {
			xl = "Yếu";
		} else if (diem < 6.5) {
			xl = "Trung Binh";
			;
		} else if (diem < 7.5) {
			xl = "Kha";
		} else if (diem < 9) {
			xl = "Gioi";
		} else {
			xl = "Xuat Sac";
		}
		return xl;
	}

	public void xuat() {

		System.out.println("Ten sinh vien: " + hoTen);
		System.out.println("Nganh: " + nganh);

	}

}
