import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ATM {
	String maSoTK = null;

	/**
	 * Dang nhap
	 * 
	 * @throws IOException
	 */
	public void login() throws IOException {
		String pantterMaTK = "[0-9]{14}";
		String pantterMaPIN = "[0-9]{6}";

		boolean kiemTra;
		int chooseMenu = 0;
		String chooseMenuStr = null;
		String maPIN = null;
		String maTK = null;

		Scanner input = new Scanner(System.in);
		System.out.println("Chào mừng bạn đến với ngân hàng VanManhBank\n");

		System.out.println("/****************************************/");
		System.out.println("1. Đăng nhập tài khoản");
		System.out.println("2. Thoát");
		System.out.println("/****************************************/");

		do {
			kiemTra = false;
			System.out.println("Chọn chức năng : ");
			chooseMenuStr = input.nextLine();
			try {
				chooseMenu = Integer.parseInt(chooseMenuStr);
				if (chooseMenu != 1 && chooseMenu != 2) {
					throw new Exception("Chi duoc chon 1 hoac 2");
				}
			} catch (NumberFormatException e) {
				System.out.println("Khong duoc nhap gia tri ngoai so va de trong");
				kiemTra = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				kiemTra = true;
			}
		} while (kiemTra);

		switch (chooseMenu) {
		case 1:
			do {
				kiemTra = false;
				// Nhap ma so tk
				do {
					kiemTra = false;
					try {
						System.out.println("Nhap ma so tai khoan : ");
						maTK = input.nextLine();
						if (!maTK.matches(pantterMaTK)) {
							throw new Exception("Nhap sai ma so tai khoan");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						kiemTra = true;
					}
				} while (kiemTra);

				// Nhap ma PIN
				do {
					kiemTra = false;
					try {
						System.out.println("Nhap ma PIN : ");
						maPIN = input.nextLine();
						if (!maPIN.matches(pantterMaPIN)) {
							throw new Exception("Nhap sai ma PIN");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						kiemTra = true;
					}
				} while (kiemTra);

				FileReader fileReader = new FileReader("TheTu.dat");
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				// Kiem tra dang nhap
				String line = bufferedReader.readLine();
				while (line != null) {
					String[] mang1 = line.split(",");
					line = bufferedReader.readLine();
					if (mang1[0].equals(maTK) && mang1[1].equals(maPIN)) {
						System.out.println("Đăng nhập thành công.");
						maSoTK = mang1[0];
						kiemTra = false;
						menu();
						break;
					} else if (line == null) {
						System.out.println("Sai tk hoặc mã PIN");
						kiemTra = true;
					}
				}

				bufferedReader.close();
				fileReader.close();
			} while (kiemTra);

			break;
		case 2:
			input.close();
			System.out.println("Chương trình kết thúc.");
			System.exit(0);
			break;
		default:
			System.out.println("Chọn sai chức năng.");
		}
	}

	/**
	 * Kiem tra tai khoan
	 * 
	 * @throws IOException
	 */
	public void kiemTraTaiKhoan() throws IOException {
		File file = new File(maSoTK + ".dat");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		if (file.exists()) {
			System.out.println("Ten                             : " + bufferedReader.readLine());
			System.out.println(
					"So tien hien co trong tai khoan : " + bufferedReader.readLine() + " " + bufferedReader.readLine());
			System.out.println("Trang thai                      : " + bufferedReader.readLine());
		} else {
			System.out.println("file khong ton tai!!");
		}
		bufferedReader.close();
		fileReader.close();
	}

	/**
	 * Doi mat khau
	 * 
	 * @param input
	 * @throws IOException
	 */
	public void doiMatKhau(Scanner input) {
		String maPINCu = null;
		String maPINMoi = null;
		boolean kiemTra = false;
		String pantterMaPIN = "[0-9]{6}";
		String contantFile = "";
		String line;
		File file = new File("TheTu.dat");

		BufferedReader bufferedReader = null;
		FileWriter fileWriter = null;
		try {
			// Nhap ma PIN
			do {
				kiemTra = false;
				try {
					System.out.println("Nhap ma PIN cu : ");
					maPINCu = input.nextLine();
					if (!maPINCu.matches(pantterMaPIN)) {
						throw new Exception("Nhap sai ma PIN");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = true;
				}
			} while (kiemTra);
			bufferedReader = new BufferedReader(new FileReader(file));

			while ((line = bufferedReader.readLine()) != null) {
				if (line.matches(maSoTK + "," + maPINCu)) {
					System.out.println("Nhap ma pin moi : ");
					maPINMoi = input.nextLine();
					line = line.split(",")[0] + "," + line.split(",")[1].replaceAll(maPINCu, maPINMoi);
					kiemTra = true;
				}
				contantFile = contantFile + line + "\n";
			}

			fileWriter = new FileWriter(file);
			fileWriter.write(contantFile);

			if (kiemTra) {
				System.out.println("Doi ma Pin thanh cong");
			} else {
				System.out.println("Doi ma Pin that bai, nhap sai ma pin");
			}
		} catch (FileNotFoundException e) {
			System.out.println("data khong ton tai");
		} catch (IOException e) {
			System.out.println("Co loi!!");
		} finally {
			try {
				bufferedReader.close();
				fileWriter.close();
			} catch (IOException e) {

			}
		}

	}

	/**
	 * Rut tien trong tai khoan
	 * 
	 * @param input
	 * @throws IOException
	 */
	public void rutTien(Scanner input) throws IOException {

		File file = new File(maSoTK + ".dat");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		if (file.exists()) {
			String ten = bufferedReader.readLine();
			String soTien = bufferedReader.readLine();
			String donViTienTe = bufferedReader.readLine();
			String trangThai = bufferedReader.readLine();

			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			System.out.println("So tien hien co trong tai khoan : " + soTien + " " + donViTienTe);
			Double soTienTrongTK = Double.parseDouble(soTien);
			System.out.print("Nhap so tien can rut : ");
			String moneyStr = input.nextLine();
			double money = Double.parseDouble(moneyStr);
			if (money > soTienTrongTK) {
				System.out.println("So tien trong tai khoan qua it, ban khong the rut");
			} else {
				soTien = String.valueOf(((soTienTrongTK) - money));
				System.out.println("So tien con lai la : " + soTien);

			}
			bufferedWriter.write(ten + "\n" + soTien + " \n" + donViTienTe + "\n" + trangThai);
			bufferedWriter.close();
			fileWriter.close();
		} else {
			System.out.println("file khong ton tai!!");
		}
		bufferedReader.close();
		fileReader.close();

	}

	public void menu() throws IOException {
		String choose;
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("+---------------------------------------------------+");
			System.out.println("+-----------* Chào mừng đến VanManhBank *-----------+");
			System.out.println("|----------------1. Rút tiền.-----------------------|");
			System.out.println("|--------------2. Đổi mật khẩu.---------------------|");
			System.out.println("|------------3. Kiểm tra tài khoản.-----------------|");
			System.out.println("+---------------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			choose = input.nextLine();

			switch (choose) {
			case "1":
				rutTien(input);
				break;
			case "2":
				doiMatKhau(input);
				break;
			case "3":
				kiemTraTaiKhoan();
				break;

			default:
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		MayATM mayATM = new MayATM();
		mayATM.login();
	}
}
