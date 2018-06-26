

abstract public class SinhVienFpt {
	public String hoTen;
	public String nghanh;
	
	public SinhVienFpt(String hoTen, String nghanh) {
		this.hoTen = hoTen;
		this.nghanh = nghanh;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNghanh() {
		return nghanh;
	}
	public void setNghanh(String nghanh) {
		this.nghanh = nghanh;
	}

	abstract public double getDiem();
	
	public String getHocLuc() {
		if(getDiem()<5) {
			return "Yếu";
		}
		else if(getDiem()<6.5) {
			return "Trung bình";
		}
		else if(getDiem()<7.5) {
			return "Khá";
		}
		else if(getDiem()<9) {
			return "Giỏi";
		}
		else {
			return "Xuất sắc";
		}
	}
	
	public void xuat() {
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Nghành: " + getNghanh());
		System.out.println("Điểm: " + getDiem());
		System.out.println("Học lực: " + getHocLuc());
	}
}
