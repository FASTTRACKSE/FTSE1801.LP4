package Assignment4;

import java.util.Scanner;

public class BienLai {
	private KhachHang khachHang;
	private int chiSoCu;
	private int chiSoMoi;
	private double soTienPhaiTra;

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public double getSoTienPhaiTra() {
		return soTienPhaiTra;
	}

	public void setSoTienPhaiTra(double soTienPhaiTra) {
		this.soTienPhaiTra = soTienPhaiTra;
	}
	
	public void nhapBienLai() {
		Scanner input = new Scanner(System.in);
		khachHang = new KhachHang();
		khachHang.nhapKhachHang();
		System.out.println("Nhập chỉ số củ: ");
		chiSoCu = input.nextInt();
		System.out.println("Nhập chỉ số mới: ");
		chiSoMoi = input.nextInt();
		soTienPhaiTra = (chiSoMoi - chiSoCu)*750;
		input.close();
	}
	
	public void hienThiBienLai() {
		khachHang.hienthiKhachHang();
		System.out.println("Chỉ số củ: "+chiSoCu+"\nChỉ số mới: "+chiSoMoi+"\nSố tiền phải trả: "+soTienPhaiTra);
	}
}
