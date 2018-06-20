package ThuaKe;

import java.util.Scanner;

public class MyClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Nhập tên trưởng phòng : ");
		String nameTp = input.nextLine();
		System.out.print("Nhập lương : ");
		double moneyTp = input.nextDouble();
		System.out.print("Nhập tiền trách nhiệm : ");
		double tienTN = input.nextDouble();

		TruongPhong truongPhong = new TruongPhong();
		truongPhong.setHoTen(nameTp);
		truongPhong.setLuong(moneyTp);
		truongPhong.setTienTrachNhiem(tienTN);

		System.out
				.println(truongPhong.getHoTen() + "--" + truongPhong.getLuong() + "--" + truongPhong.getTienTrachNhiem() + "--" + truongPhong.getThuNhap());
		System.out.println();

		input.nextLine();
		System.out.print("Nhập tên lao công : ");
		String nameLc = input.nextLine();
		System.out.print("Nhập lương : ");
		double moneyLc = input.nextDouble();
		System.out.print("Nhập tiền làm thêm : ");
		double tienLt = input.nextDouble();

		LaoCong laoCong = new LaoCong();
		laoCong.setHoTen(nameLc);
		laoCong.setLuong(moneyLc);
		laoCong.setTienLamThem(tienLt);

		System.out.println(laoCong.getHoTen() + "--" + laoCong.getLuong() + "--" + laoCong.getTienLamThem() + "--" + laoCong.getThuNhap());
		System.out.println();

		input.nextLine();
		System.out.print("Nhập tên Nhân viên : ");
		String nameNv = input.nextLine();
		System.out.print("Nhập lương : ");
		double moneyNv = input.nextDouble();

		NhanVien nhanVien = new NhanVien();
		nhanVien.setHoTen(nameNv);
		nhanVien.setLuong(moneyNv);

		System.out.println(nhanVien.getHoTen() + "--" + nhanVien.getLuong() + "--" + nhanVien.getThuNhap());

		input.close();
	}
}
