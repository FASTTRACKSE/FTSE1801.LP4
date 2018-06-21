package lab5;

public class NhanVien {
	private String ten;
	private int tuoi;
	private String diaChi;
	private String gioiTinh;
	private double luong;
	public NhanVien() {
		ten = "Phuong";
		tuoi = 23;
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
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		tuoi = tuoi;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		gioiTinh = gioiTinh;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		luong = luong;
	}
	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("Phuong", 23, "Da Nang", "Nam", 50000);
		NhanVien nv2 = new NhanVien();
		NhanVien nv3 = new NhanVien();
		System.out.printf("%20s | %5s | %10s | %10s | %10s \n","Ho va ten", "Tuoi", "Dia chi", "Gioi tinh", "Luong");
		System.out.printf("%20s | %5s | %10s | %10s | %10s \n",nv1.getTen(), nv1.getTuoi(), nv1.getDiaChi(), nv1.getGioiTinh(), nv1.getLuong());
		
	}


}
