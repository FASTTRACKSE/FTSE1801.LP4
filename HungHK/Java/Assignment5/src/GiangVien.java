import java.util.Scanner;

public class GiangVien extends CanBo {
	private String khoa;
	private String trinhDo;
	private int soTiet;
	
	public GiangVien() {
	}
	public GiangVien(String khoa, String trinhDo, int soTiet) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTiet = soTiet;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	
	public void nhapGiangVien(Scanner sc) {
		super.nhapCanBo(sc);
		sc.nextLine();
		
		System.out.print("Nhập khoa: ");
		String khoa = sc.nextLine();
		setKhoa(khoa);
		
		int choose;
		do {
			System.out.println("Nhập trình độ, chọn: \n1. Cử nhân \n2. Thạc sĩ \n3. Tiến sĩ");
			choose = sc.nextInt();
			switch (choose) {
				case 1:
					trinhDo = "Cử nhân";
					this.setPhuCap(300);
					break;
				case 2:
					trinhDo = "Thạc sĩ";
					this.setPhuCap(500);
					break;
				case 3:
					trinhDo = "Tiến sĩ";
					this.setPhuCap(1000);
					break;
				default:
					System.out.println("Chọn sai");
					break;
			}
		} while (choose <1 || choose >3);
		setTrinhDo(trinhDo);
		
		System.out.print("Nhập số tiết: ");
		int soTiet = sc.nextInt();
		setSoTiet(soTiet);
	}
	
	public double tinhLuong() {
		double luong = getHeSoLuong()*730 + getPhuCap() + getSoTiet()*45;
		return luong;
	}
	
	public void xuatGiangVien() {
		super.xuatCanBo();
		System.out.println("Khoa: " + getKhoa());
		System.out.println("Trình độ: " + getTrinhDo());
		System.out.println("Số tiết: " + getSoTiet());
		System.out.println("Tổng lương: " + tinhLuong());
	}
}
