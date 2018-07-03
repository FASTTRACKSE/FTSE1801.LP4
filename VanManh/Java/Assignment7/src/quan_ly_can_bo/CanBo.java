package quan_ly_can_bo;

import java.io.Serializable;

public abstract class CanBo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ten;
	private double heSoLuong;
	private double phuCap;
	private int thoiGianTinhLuong;
	private double luong;
	private String nganh;
	private String donVi;
	private String trinhDo;
	
	public String toString() {
		
		return ten + " " + nganh + " " + donVi + " " + heSoLuong + " " + trinhDo + " " + phuCap + " " + thoiGianTinhLuong + " " + luong +" ";
	}

	public CanBo() {
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public int getThoiGianTinhLuong() {
		return thoiGianTinhLuong;
	}

	public void setThoiGianTinhLuong(int thoiGianTinhLuong) {
		this.thoiGianTinhLuong = thoiGianTinhLuong;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	
	

}
