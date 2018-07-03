package java_day10_TruuTuong;

abstract public class SinhVienFpt {
	String hoTen;
	String nganh;
	public SinhVienFpt(String hoTen, String nganh) {
		
		this.hoTen = hoTen;
		this.nganh = nganh;
	}
	abstract double getDiem();
	public String getHocLuc() {
		if(getDiem() >8) {
			return "Giỏi";
		}else if(getDiem()>6.5) {
			return "Khá";
		}else if(getDiem()>5) {
			return "Trung bình";
		}else {
			return "Yếu";
		}
	}
	void xuat(){
		System.out.println("Tên sinh viên: " +hoTen);
		System.out.println("Tên ngành: " +nganh);
		System.out.println("Điểm: " + getDiem());
		System.out.println("Học Lực: " +getHocLuc());
	}
}
