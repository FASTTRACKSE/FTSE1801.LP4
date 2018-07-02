import java.util.Scanner;

/**
 * 
 * @author Phạm Ngọc Hợi
 *
 */
public class NhanVien extends CanBo {
	public void addNhanVien(Scanner sc,NhanVien nhanVien){
		sc.nextLine();
		System.out.println("Nhập họ tên: ");
		String ten = sc.nextLine();
		System.out.println("Nhập phòng ban: ");
		String ban = sc.nextLine();
		System.out.println("Lựa chọn chức vụ: 1-Trưởng phòng | 2-Phó phòng | 3-Nhân viên.");
		int trinhDo = sc.nextInt();
		switch(trinhDo) {
		case 1:
			nhanVien.setCapBac("Trưởng phòng");
			nhanVien.setPhuCap(2000);
			break;
		case 2:
			nhanVien.setCapBac("Phó phòng");
			nhanVien.setPhuCap(1000);
			break;
		case 3:
			nhanVien.setCapBac("Nhân viên");
			nhanVien.setPhuCap(500);
			break;
		}
		System.out.println("Số ngày công trong tháng: ");
		int soNgayCong = sc.nextInt();
		System.out.println("Hệ số lương: ");
		double heSoLuong = sc.nextDouble();
		
		nhanVien.setHoTen(ten);
		nhanVien.setDonVi(ban);
		nhanVien.setThoiGianLamViec(soNgayCong);
		nhanVien.setHeSoLuong(heSoLuong);
		nhanVien.setLuong(heSoLuong*730 + nhanVien.getPhuCap() + soNgayCong*30);
		
		
	}
}
