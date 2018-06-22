package quanLyDien;

public class KhachHang {
	
	private String hoTen;
	private String soNha;
	private String maSoCongTo;
	private int oldNumber;
	private int newNumber;
	private int tienDien;
	
	
	
	public int getTienDien() {
		return tienDien;
	}

	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
	}

	public int getOldNumber() {
		return oldNumber;
	}

	public void setOldNumber(int oldNumber) {
		this.oldNumber = oldNumber;
	}

	public int getNewNumber() {
		return newNumber;
	}

	public void setNewNumber(int newNumber) {
		this.newNumber = newNumber;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoNha() {
		return soNha;
	}
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}
	public String getMaSoCongTo() {
		return maSoCongTo;
	}
	public void setMaSoCongTo(String maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

	
	public KhachHang(String hoTen, String soNha, String maSoCongTo,int oldNumber,int newNumber) {
		super();
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
		this.oldNumber=oldNumber;
		this.newNumber=newNumber;
	}
	
	public KhachHang() {}
	
	
}
