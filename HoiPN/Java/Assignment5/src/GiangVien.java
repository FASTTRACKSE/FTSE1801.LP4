import java.util.Scanner;

/**
 * 
 * @author Phạm Ngọc Hợi
 *
 */
public class GiangVien extends CanBo {
	public void addGiangVien(Scanner sc,GiangVien giangVien){
		sc.nextLine();
		System.out.println("Nhập họ tên: ");
		String ten = sc.nextLine();
		System.out.println("Nhập khoa: ");
		String khoa = sc.nextLine();
		System.out.println("Lựa chọn trình độ: 1-Cử nhân | 2-Thạc sĩ | 3-Tiến sĩ.");
		int trinhDo = sc.nextInt();
		switch(trinhDo) {
		case 1:
			giangVien.setCapBac("Cử nhân");
			giangVien.setPhuCap(300);
			break;
		case 2:
			giangVien.setCapBac("Thạc sĩ");
			giangVien.setPhuCap(500);
			break;
		case 3:
			giangVien.setCapBac("Tiến sĩ");
			giangVien.setPhuCap(1000);
			break;
		}
		System.out.println("Số tiết dạy trong tháng: ");
		int soTiet = sc.nextInt();
		System.out.println("Hệ số lương: ");
		double heSoLuong = sc.nextDouble();
		
		giangVien.setHoTen(ten);
		giangVien.setDonVi(khoa);
		giangVien.setThoiGianLamViec(soTiet);
		giangVien.setHeSoLuong(heSoLuong);
		giangVien.setLuong(heSoLuong*730 + giangVien.getPhuCap() + soTiet*45);
		
		
	}
}
