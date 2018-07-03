import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyCanBo {
	private ArrayList<CanBo> listCanBo;

	public QuanLyCanBo() {
		listCanBo = new ArrayList<CanBo>();
	}

	public void menu() throws ClassNotFoundException, IOException {
		int luaChon, tiepTuc;
		QuanLyCanBo qlcb = new QuanLyCanBo();

		while (true) {
			System.out.println("//**********************************");
			System.out.println("1. Nhập thông tin cán bộ.");
			System.out.println("2. Hiển thị danh sách cán bộ theo ban.");
			System.out.println("3. Kết thúc chương trình.");
			System.out.println("*********************************//");

			Scanner sc = new Scanner(System.in);
			luaChon = sc.nextInt();

			switch (luaChon) {
			case 1:
				do {
					System.out.println("Nhập thông tin cán bộ.");
					System.out.println("1 - Thêm giảng viên || 2 - Thêm nhân viên.");
					int chon = sc.nextInt();
					switch (chon) {
					case 1:
						addGiangVienToListCanBo(sc);
						break;
					case 2:
						addNhanVienToListCanBo(sc);
						break;
					default:
						System.out.println("Chọn sai.");
						break;
					}
					System.out.println("Bạn có muốn tiếp tục không : (0:không | 1:có)");
					tiepTuc = sc.nextInt();
				} while (tiepTuc == 1);
				break;
			case 2:
				readFile();
				break;
			case 3:
				System.out.println("Kết thúc chương trình!!!");
				sc.close();
				System.exit(0);
				break;
			}
		}
	}

	private void addGiangVienToListCanBo(Scanner sc) throws IOException {
		GiangVien giangVien = new GiangVien();
		giangVien.addGiangVien(sc, giangVien);
		listCanBo.add(giangVien);
		writeFile();

	}

	private void addNhanVienToListCanBo(Scanner sc) throws IOException {
		NhanVien nhanVien = new NhanVien();
		nhanVien.addNhanVien(sc, nhanVien);
		listCanBo.add(nhanVien);
		writeFile();
	}

	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("CanBo.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(listCanBo);
		oos.close();
		fos.close();
	}

	public void readFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("CanBo.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<CanBo> listCanBo = (ArrayList<CanBo>) ois.readObject();

		System.out.printf("%-20s %-25s %-25s %-10s %-30s %-20s %-10s \n", "Họ tên", "Khoa(phòng ban)",
				"Trình độ(chức vụ", "Phụ cấp", "Số tiết(ngày công)", "Hệ số lương", "Lương");
		for (int i = 0; i < listCanBo.size(); i++) {

			System.out.printf("%-20s %-25s %-25s %-10s %-30s %-20s %-10s \n", listCanBo.get(i).getHoTen(),
					listCanBo.get(i).getDonVi(), listCanBo.get(i).getCapBac(), listCanBo.get(i).getPhuCap(),
					listCanBo.get(i).getThoiGianLamViec(), listCanBo.get(i).getHeSoLuong(),
					listCanBo.get(i).getLuong());

		}
		System.out.println();
		ois.close();
		fis.close();
	}

	public static void main(String[] args) throws NullPointerException, IOException, ClassNotFoundException {
		QuanLyCanBo qlcb = new QuanLyCanBo();
		qlcb.menu();
	}
}
