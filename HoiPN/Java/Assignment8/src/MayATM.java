import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MayATM {
	String maTk;
	String maPin;
	String tenTk;
	String soTienTrongThe;
	String trangThai;
	String soTienConLai;
	String[] khachHang = {tenTk,soTienTrongThe,trangThai};
	
	public void login() throws IOException {
		System.out.println("Chào mừng quý khách đến với ngân hàng Phạm Ngọc Hợi.");
		System.out.println("1. Đăng nhập tài khoản.");
		System.out.println("2. Thoát.");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Lựa chọn của bạn: ");
		String choose = sc.nextLine();
		boolean check = false;
		
		switch(choose) {
		case "1":
			while(true){
				System.out.println("Nhập mã tài khoản: ");
				maTk = sc.nextLine();
				System.out.println("Nhập mật khẩu: ");
				maPin = sc.nextLine();
				
				FileReader fr = new FileReader("TheTu.dat");
				BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null) {
					String[] mang =  line.split(",");
						if((mang[0].equals(maTk))&&(mang[1].equals(maPin))) {
							System.out.println("Đăng nhập thành công.");
							menu();
						}
				}
				fr.close();
				br.close();
				
			}
		
		case "2":
			System.out.println("See you again!!!");
			sc.close();
			System.exit(0);	
			break;
		}
	}
	
	public void menu() throws IOException {
		String choose;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Rút tiền.");
			System.out.println("2. Đổi mật khẩu.");
			System.out.println("3. Kiểm tra tài khoản.");
			System.out.println("4. Chuyển tiền vào tài khoản.");
			System.out.println("5. Thoát.");
			
			choose = sc.nextLine();
			switch(choose) {
			case "1":
				rutTien();
				break;
			case "2":
				doiMatKhau();
				break;
			case "3":
				kiemTra();
				break;
			case "4":
				chuyenTien();
				break;
			case "5":
				System.out.println("See you again!!!");
				sc.close();
				System.exit(0);	
				break;
			}
		}
	}
	
	public void doiMatKhau() throws IOException {
		String mkMoi;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mật khẩu mới: ");
		mkMoi = sc.nextLine();
		FileOutputStream fos =new FileOutputStream("TheTu.dat");
		ObjectOutputStream oos =new ObjectOutputStream(fos);

		String[] theTu = {maTk,mkMoi};
		
		oos.writeObject(theTu);
		oos.close();
		fos.close();
		
	}
	
	public void chuyenTien() {
		
		
	}
	
	public void kiemTra() throws IOException {
		FileReader fr = new FileReader(maTk + ".dat");
		BufferedReader br = new BufferedReader(fr);
		String line;
		
		while((line = br.readLine()) != null) {
			String[] khachHang =  line.split(",");
				System.out.println("Họ tên khách hàng: " + khachHang[0]);
				System.out.println("Số dư tài khoản: " + khachHang[1]);
		}
		fr.close();
		br.close();
		
	}
	

	public void rutTien() throws IOException {
		Scanner sc = new Scanner(System.in);
		String choose = sc.nextLine();
		
		System.out.println("Nhập số tiền bạn muốn rút: ");
		String soTienRut = sc.nextLine();
		int soTienRut1 = 0;
		int soTienTrongThe1=0;
		int soTienConLai1;
		
		FileReader fr = new FileReader(maTk + ".dat");
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		
		String[] khacHang =  line.split(",");
			soTienRut1 = Integer.parseInt(soTienRut);
			maTk = khacHang[0];
			soTienTrongThe = khacHang[1];
			trangThai = khacHang[2]; 
			soTienTrongThe1 = Integer.parseInt(soTienTrongThe);
			
			soTienConLai1= soTienTrongThe1-soTienRut1;
			
			if((soTienRut1<soTienTrongThe1)&&(khacHang[2].equals("unlock"))){
				System.out.println("Giao dịch thành công.");
				System.out.println("Số tiền còn lại của quý khách là: " + soTienConLai1);
			}else if((soTienRut1>soTienTrongThe1)||(khacHang[2].equals("lock"))) {
				System.out.println("Giao dịch thành công.");
			}
		
		fr.close();
		br.close();
		
//		FileOutputStream fos =new FileOutputStream(maTk+".dat");
//		ObjectOutputStream oos =new ObjectOutputStream(fos);
//		soTienConLai = String.valueOf(soTienConLai1);
//		String[] khachHang = {maTk,soTienConLai,trangThai};
//		oos.writeObject(khacHang);
//		oos.close();
//		fos.close();
		
//		FileWriter fw = new FileWriter(maTk+".dat");
//		String soTienConLai;
//		soTienConLai = String.valueOf(soTienConLai1);
//		fw.write(maTk+"\n");
//		fw.write(soTienConLai+"\n");
//		fw.write(trangThai+"\n");
//		fw.flush();
//		fw.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		MayATM atm =new MayATM();
		atm.login();
	}
}
