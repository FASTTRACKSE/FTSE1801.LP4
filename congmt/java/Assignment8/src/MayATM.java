import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class MayATM implements Serializable {
	String maSoTaiKhoan;

	private static final long serialVersionUID = 1L;

	public void dangNhap() throws IOException {

		System.out.println("+---------------------------------------------------+");
		System.out.println("+------* Chào mừng đến với máy rút vàng *-----------+");
		System.out.println("|1.Đăng nhập tài khoản                              |");
		System.out.println("|2.Đăng xuất tài khoản                              |");
		System.out.println("|0.Kết thúc chương trình                            |");
		System.out.println("+---------------------------------------------------+");
		System.out.println("Mời Bạn Chọn Chức Năng");

		Scanner sc = new Scanner(System.in);
		boolean kiemTra;
		String maTaiKhoan = null;
		String maPin = null;
		String patternTaiKhoan = "[0-9]{14}";
		String patternmaPin = "[0-9]{6}";
		MayATM mayatm = new MayATM();
		int choose;
		choose = sc.nextInt();
		switch (choose) {
		case 1:

			do {

				kiemTra = false;
				try {
					sc.nextLine();
					System.out.println("Nhap tai khoan:");
					maTaiKhoan = sc.nextLine();
					if (!maTaiKhoan.matches(patternTaiKhoan)) {
						throw new Exception("Ban nhap sai ten tai khoan!");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = true;
				}
			} while (kiemTra);
			do {

				kiemTra = false;
				try {
					System.out.println("Nhap ma pin:");
					maPin = sc.nextLine();
					if (!maPin.matches(patternmaPin)) {
						throw new Exception("Ban nhap sai ten tai khoan!");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = true;
				}
			} while (kiemTra);
			
			FileReader fileReader=null;
			BufferedReader bufferedReader=null;
			try {
			 fileReader = new FileReader("TheTu.dat");
			 bufferedReader = new BufferedReader(fileReader);
			String doc;
			while ((doc = bufferedReader.readLine()) != null) {
				System.out.println(doc);
				String[] mang2 = doc.split("/");
				if (doc.matches(maTaiKhoan +"/"+ maPin)) {
					File file=new File(mang2[0]+ ".dat");
					maSoTaiKhoan=mang2[0]+ ".dat";
					System.out.println("Đăng nhập thành công.");
					mayatm.menu();
					break;}
			}
			}catch(FileNotFoundException e) {
				System.out.println("Khong tim thay file");
			}catch(IOException e) {
				System.out.println("Doc bi loi");
			}finally {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Dong bi file");
				}
			}

			break;
		case 2:
			System.out.println("See you again!!!");
			sc.close();
			System.exit(0);
			break;

		case 0:
			sc.close();
			System.out.println("Kết thúc chương trình!!! ");
			System.exit(0);
			break;

		default:
			System.out.println("Chọn sai chức năng, mời bạn chọn lại.");
			break;
		}
	}

	public void menu() throws IOException {
		String choose;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("+---------------------------------------------------+");
			System.out.println("+------* Chào mừng đến với máy rút vàng *-----------+");
			System.out.println("|----------------1. Rút tiền.-----------------------|");
			System.out.println("|--------------2. Đổi mật khẩu.---------------------|");
			System.out.println("|------------3. Kiểm tra tài khoản.-----------------|");
			System.out.println("|------------0. Thoát chương trình.-----------------|");
			System.out.println("+---------------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				rutTien(sc);
				break;
			case "2":

				break;
			case "3":

				break;
			case "0":
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

	public void rutTien(Scanner sc) throws IOException {

		File file = new File(maSoTaiKhoan + ".dat");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		if (file.exists()) {
			String tenKhachHang = bufferedReader.readLine();
			String soTienTrongTaiKhoan = bufferedReader.readLine();
			String loaiTien = bufferedReader.readLine();
			String trangThai = bufferedReader.readLine();

			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			System.out.println("So tien trong tai khoan la:" + soTienTrongTaiKhoan + " " + loaiTien);
			double soTienDangCo = Double.parseDouble(soTienTrongTaiKhoan);
			System.out.println(" So tien muon rut:");
			String soTienMuonRut = sc.nextLine();
			double soTienMuonLay = Double.parseDouble(soTienMuonRut);
			if (soTienMuonLay > soTienDangCo) {
				System.out.println("So tien trong tai khoan khong du. Ban khong the lay!");
			} else {
				String soTienConLai = String.valueOf(soTienDangCo - soTienMuonLay);
				System.out.println("So tien con lai la:" + soTienConLai);
				bufferedWriter.write(tenKhachHang + "\n" + soTienConLai + "\n" + loaiTien);
			}
			bufferedWriter.close();
			fileWriter.close();
		} else {
			System.out.println("Khong co tai khoan nay!!");
		}
		bufferedReader.close();
		fileReader.close();

	}

	public static void main(String[] args) throws IOException {
		MayATM atm = new MayATM();
		atm.dangNhap();
	}
}
