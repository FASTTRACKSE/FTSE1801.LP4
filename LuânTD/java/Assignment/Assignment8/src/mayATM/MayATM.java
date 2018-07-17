package mayATM;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

import users.TheTu;

public class MayATM implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		boolean kiemTra;
		String soTaiKhoan = null;
		String maPin = null;

		FileInputStream fileInputStream = new FileInputStream("TheTu.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		TheTu[] theTu = (TheTu[]) objectInputStream.readObject();

		do {
			kiemTra = false;
			try {
				System.out.print("Nhap the: ");
				soTaiKhoan = sc.nextLine();
				for (int i = 0; i < theTu.length; i++) {
					if (theTu[i].getAccountCode().equals(soTaiKhoan)) {
						throw new Exception();
					}
				}
				System.out.println("Khong nhan the.Moi doi the khac");
				System.out.println();
				kiemTra = true;
			} catch (Exception e) {
				do {
					try {
						System.out.print("Nhap ma Pin: ");
						maPin = sc.nextLine();
						for (int i = 0; i < theTu.length; i++) {
							if (theTu[i].getPinCode().equals(maPin)) {
								throw new Exception();
							}
						}
						kiemTra = true;
					} catch (Exception e1) {
						System.out.println("Chao mung ban den voi LuanBank");
						break;
					}
				} while (kiemTra);
				break;
			}
		} while (kiemTra);

		sc.close();
		fileInputStream.close();
		objectInputStream.close();

	}
}
