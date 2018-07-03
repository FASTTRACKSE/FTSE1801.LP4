package quanly_canbo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Ngọc Thiên
 *
 */
public class QuanLy {
	ArrayList<CanBo> listQuanLy;

	public QuanLy() {
		listQuanLy = new ArrayList<CanBo>();

	}

	/**
	 * tạo file
	 * 
	 * @throws IOException
	 */
	public void writeFile() throws IOException {
		FileOutputStream file = new FileOutputStream("file.txt");
		ObjectOutputStream out = new ObjectOutputStream(file);

		out.writeObject(listQuanLy);
		/**
		 * Đóng luồng
		 */
		out.close();
		file.close();
	}

	/**
	 * đọc file
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void ReadFile() throws IOException, ClassNotFoundException {
		FileInputStream File = null;
		ObjectInputStream Out = null;

		File = new FileInputStream("file.txt");
		Out = new ObjectInputStream(File);
		ArrayList<CanBo> listQuanLy = (ArrayList<CanBo>) Out.readObject();
		for (CanBo canbo : listQuanLy) {

		}

	}

	public void menu() throws IOException, ClassNotFoundException {
		int chooseMenu;
		int soCanBo;
		CanBo canBo;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("\n*************************************************\n");
			System.out.print("* số 1 : nhập thông tin cán bộ               *\n");
			System.out.print("* số 2 : xem thông tin                 *\n");
			System.out.print("* số 3 : Kết thúc chương trình*\n");
			System.out.print("*************************************************\n ");
			System.out.print("\n chọn chức năng bạn muốn : ");
			chooseMenu = sc.nextInt();
			switch (chooseMenu) {

			case 1:
				System.out.print("Nhập số lượng cán bộ trong trường: ");
				soCanBo = sc.nextInt();
				for (int i = 0; i < soCanBo; i++) {
					System.out.print("Nhập thong tin can bo thu " + (i + 1) + " \n");

					System.out.print("Nhập 1 chon giang vien, 2 chon nhan vien");
					int cb;
					cb = sc.nextInt();
					sc.nextLine();
					if (cb == 1) {
						canBo = new GiangVien();
						((GiangVien) canBo).nhapGiangVien(sc);
						listQuanLy.add(canBo);
						writeFile();
					} else if (cb == 2) {
						canBo = new NhanVien();
						((NhanVien) canBo).nhapNhanVien(sc);
						listQuanLy.add(canBo);
						writeFile();
					}

				}
				break;
			case 2:
				System.out.println("Hiển thị danh sách cán cán bộ trong trường: ");
				CanBo cb;
				for (int i = 0; i < listQuanLy.size(); i++) {
					cb = listQuanLy.get(i);
					if (cb instanceof NhanVien) {
						((NhanVien) cb).xuatNhanVien();
						ReadFile();
					} else {
						((GiangVien) cb).xuatGiangVien();
						ReadFile();
					}

				}
				break;

			case 3:
				sc.close();
				System.out.println("***Bye bye***");
				System.exit(0);
				break;

			default:
				System.out.println("\n\n\n\n********Menu not exist feature********");
				break;
			}

		} while (true);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		QuanLy ql = new QuanLy();
		ql.menu();

	}
}
