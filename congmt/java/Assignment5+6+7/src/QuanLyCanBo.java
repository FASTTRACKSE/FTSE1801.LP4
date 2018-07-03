import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyCanBo {

	private ArrayList<CanBo> dsCanBo;
	long tongLuong = 0;
	long luong;

	public QuanLyCanBo() {
		dsCanBo = new ArrayList<CanBo>();
	}
	/**
	 * Ham menu
	 */
	public static void menu() {
		System.out.println("+---------------------------------------------------+");
		System.out.println("+------------------------MENU-----------------------+");
		System.out.println("|1.Nhập Thông Tin Cán Bộ                            |");
		System.out.println("|2.Xuất thông tin Giảng Viên hoặc Nhân Viên         |");
		System.out.println("|3.Tổng số lương phải trả cho cán bộ                |");
		System.out.println("|4.Sắp xếp Cán bộ                                   |");
		System.out.println("|5.Ghi file cán bộ                                  |");
		System.out.println("|6.Đọc file cán bộ                                  |");
		System.out.println("|5.Thoát chương trình                               |");
		System.out.println("+---------------------------------------------------+");
		System.out.println("Mời Bạn Chọn Chức Năng");
	}
	/**
	 * Ham Main
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		NhanVien nhanVien = new NhanVien();
		QuanLyCanBo quanlycanbo = new QuanLyCanBo();
		int choose;
		menu();
		while (true) {
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				quanlycanbo.NhapThongTinCb(sc);
				break;

			case 2:
				quanlycanbo.XuatThongTinCb(sc);
				break;
			case 3:
				quanlycanbo.TongSoLuong();
				break;
			case 4:
				quanlycanbo.SapXepNV();
				break;
			case 5:
				quanlycanbo.GhiFile();
				break;
			case 6:
				quanlycanbo.DocFile();
				break;
			case 7:
				sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
				break;
			}

		}
	}
	/**
	 * Nhap thong tin can bo
	 * @param sc
	 */
	public void NhapThongTinCb(Scanner sc) {
		CanBo canbo;
		System.out.println("    Nhập thông tin");
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");

		int n = sc.nextInt();
		if (n == 1) {
			canbo = new GiangVien();
			((GiangVien) canbo).NhapThongTinGiangVien(sc);
			dsCanBo.add(canbo);

			// Nhập Nhân viên
		} else if (n == 2) {
			canbo = new NhanVien();
			((NhanVien) canbo).NhapThongTinNhanVien(sc);
			dsCanBo.add(canbo);
		}

	}
	/**
	 * Ghi file 
	 * @return
	 * @throws IOException
	 */
	public boolean GhiFile() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("Danhsach.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dsCanBo);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}
	/**
	 * Docfile du lieu
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void DocFile() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("Danhsach.txt");
		ObjectInputStream object = new ObjectInputStream(fileInputStream);

		ArrayList<CanBo> dsNhanVien = (ArrayList) object.readObject();
		System.out.println(" Doc tu file");
		CanBo canbo;
		for (int i=0;i<dsNhanVien.size();i++) {
			canbo =dsNhanVien.get(i);
			if( canbo.getNganh().equals("GiangVien")) {
				((GiangVien)canbo).XuatThongTinGiangVien();
				
			}else {
				((NhanVien)canbo).XuatThongTinNhanVien();
			}
			
		}
		// Dong luong du lieu
		object.close();
		fileInputStream.close();
	}
	/**
	 * Xuat thong tin can bo
	 * @param sc
	 */
	public void XuatThongTinCb(Scanner sc) {
		CanBo giangvien = new GiangVien();
		System.out.println("    Xuất Thông Tin");
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");
		int n = sc.nextInt();
		sc.nextLine();
		CanBo canbo;
		for (int i = 0; i < dsCanBo.size(); i++) {
			canbo = dsCanBo.get(i);
			if (n==1) {
				System.out.println("Mời bạn nhập khoa của giảng viên: ");
				String khoa = sc.nextLine();
				if(((GiangVien) canbo).getKhoa().equals(khoa)){
				((GiangVien) canbo).XuatThongTinGiangVien();
			
				}
			} else if(n==2) {
				System.out.println("Mời bạn nhập khoa của giảng viên: ");
				String phongBan = sc.nextLine();
				if(((NhanVien) canbo).getPhongBan().equals(phongBan)){
				((NhanVien) canbo).XuatThongTinNhanVien();}

			}
		}
	}

	/**
	 * Tinh  tong so luong  phai tra cho can bo
	 */
	public void TongSoLuong() {
		for (CanBo x : dsCanBo) {
			luong = x.tinhLuong();
			tongLuong = luong;
		}
		System.out.println("Tổng lương phải trả cho cán bộ = " + tongLuong);
	}
	/**
	 * Sap xep Can bo theo ten, neu khong thi theo so luong
	 */
	public void SapXepNV() {
		Collections.sort(dsCanBo, NvComparator.CanBoLuongASComparator);
		for (CanBo x : dsCanBo) {
			if (x instanceof GiangVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
				System.out.println(
						"|   Tên GV     |     Trình độ      |Hệ số lương|   Phụ cấp   | Khoa |  Số tiết  |   Tiền lương   |");
				System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", x.getHoTen(),
						((GiangVien) x).getTrinhDo(), x.getHeSoLuong(), x.getPhuCap(), ((GiangVien) x).getKhoa(),
						((GiangVien) x).getSoTietDay(), ((GiangVien) x).tinhLuong());
			} else if (x instanceof NhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ HÀNH CHÍNH--------------------------------------+");
				System.out.println(
						"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |");
				System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoTen(), ((NhanVien) x).getPhongBan(),
						x.getHeSoLuong(), x.getPhuCap(), ((NhanVien) x).getChucVu(), ((NhanVien) x).getSoNgayCong());
			}
		}
	}
	/**
	 * Ket thuc chuong tinh
	 */
	public static void KetThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
		System.exit(0);
	}
}