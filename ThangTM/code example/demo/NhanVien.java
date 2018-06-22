package demo;

public class NhanVien {

	// thuoc tinh (properties)
	private String ten;
	private int tuoi;
	private String diaChi;
	private String gioiTinh;
	private double luong;
	public NhanVien() {
		ten = "Thang";
		tuoi = 29;
		diaChi = "Da Nang";
	}

	public NhanVien(String ten, int tuoi, String diaChi) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
	}
	
	
	public NhanVien(String ten, int tuoi, String diaChi, String gioiTinh, double luong) {
		this(ten, tuoi, diaChi);
		this.gioiTinh = gioiTinh;
		this.luong = luong;
	}

	// phuong thuc (method)
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public static void main(String[] args) {

		/*NhanVien nv1 = new NhanVien();
		System.out.println("" + nv1.getTen() + " - " + nv1.getTuoi());
		NhanVien nv2 = new NhanVien();
		System.out.println("" + nv2.getTen() + " - " + nv2.getTuoi());
		NhanVien nv3 = new NhanVien("Buon", 13);
		System.out.println("" + nv3.getTen() + " - " + nv3.getTuoi());*/
		
		NhanVien nv1 = new NhanVien("Vui", 12, "193 Nguyen Luong Bang", "Nam", 122100);
		NhanVien nv2 = new NhanVien();
		NhanVien nv3 = new NhanVien();
		System.out.println();
	}
}
