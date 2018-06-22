package opp_nangcao;

public class nhan_vien {
     private String ten;
     private int tuoi;
     private String diachi;
     private String gioitinh;
     private double luong;
     
     public nhan_vien() {
    	ten = "hợi";
    	tuoi = 23;
    	diachi = "nghe an";
     }
     
     public nhan_vien(String ten, int tuoi, String diachi) {
    	 this.ten = ten;
 		this.tuoi = tuoi;
 		this.diachi = diachi;
     }
	public nhan_vien(String ten, int tuoi, String diachi, String gioitinh, double luong) {
		
	    this(ten, tuoi, diachi);
		this.gioitinh = gioitinh;
		this.luong = luong;
	}
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
     
     
     
     public static void main(String[] args) {
		nhan_vien nv1 = new nhan_vien("anh", 25, "Đà nẵng", "nam", 6000000);
		nhan_vien nv2 = new nhan_vien();
	    System.out.println(nv1.ten);
	    System.out.println(nv1.tuoi);
	    System.out.println(nv1.diachi);
	    System.out.println(nv1.gioitinh);
	    System.out.println(nv1.luong);
	    
	    
	    ///
	    System.out.println(nv2.ten);
	    System.out.println(nv2.tuoi);
	    System.out.println(nv2.diachi);
	    System.out.println(nv2.gioitinh);
	    System.out.println(nv2.luong);
	}
     
}
