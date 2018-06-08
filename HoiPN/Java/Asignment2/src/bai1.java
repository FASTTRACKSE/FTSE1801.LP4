import java.util.Scanner;
/**
 * 
 * @author Hieu
 *
 */
public class bai1 {
	public static void main(String[] args) {
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhập n: ");
		n = sc.nextInt();
		System.out.print("n được đọc là: ");
		//Đọc số hàng nghìn
		int nghin =(n/1000)%10;
		switch(nghin){
			case 1:
				System.out.print("Một nghìn ");
				break;
			case 2:
				System.out.print("Hai nghìn ");
				break;
			case 3:
				System.out.print("Ba nghìn ");
				break;
			case 4:
				System.out.print("Bốn nghìn ");
				break;
			case 5:
				System.out.print("Năm nghìn ");
				break;
			case 6:
				System.out.print("Sáu nghìn ");
				break;
			case 7:
				System.out.print("Bảy nghìn ");
				break;
			case 8:
				System.out.print("Tám nghìn ");
				break;
			case 9:
				System.out.print("Chín nghìn ");
				break;
		}
		//Đọc số hàng Trăm .
		int tram =(n/100)%10;
		switch(tram){
			case 0:
				System.out.print("không Trăm ");
				break;
			case 1:
				System.out.print("Một Trăm ");
				break;
			case 2:
				System.out.print("Hai Trăm ");
				break;
			case 3:
				System.out.print("Ba Trăm ");
				break;
			case 4:
				System.out.print("Bốn Trăm ");
				break;
			case 5:
				System.out.print("Năm Trăm ");
				break;
			case 6:
				System.out.print("Sáu Trăm ");
				break;
			case 7:
				System.out.print("Bảy Trăm ");
				break;
			case 8:
				System.out.print("Tám Trăm ");
				break;
			case 9:
				System.out.print("Chín Trăm ");
				break;
		}
		
		//Đọc hàng chục
		int chuc =(n/10)%10;
		switch(chuc){
			case 0:
				System.out.print("linh ");
				break;
			case 1:
				System.out.print("mười ");
				break;
			case 2:
				System.out.print("Hai mươi ");
				break;
			case 3:
				System.out.print("Ba mươi ");
				break;
			case 4:
				System.out.print("Bốn mươi ");
				break;
			case 5:
				System.out.print("Năm mươi ");
				break;
			case 6:
				System.out.print("Sáu mươi ");
				break;
			case 7:
				System.out.print("Bảy mươi ");
				break;
			case 8:
				System.out.print("Tám mươi ");
				break;
			case 9:
				System.out.print("Chín mươi ");
				break;
		}
		// Đọc hàng đơn vị
		int donvi =n%10;
		switch(donvi){
			case 0:
				System.out.print(" ");
				break;
			case 1:
				System.out.print("một");
				break;
			case 2:
				System.out.print("Hai");
				break;
			case 3:
				System.out.print("Ba");
				break;
			case 4:
				System.out.print("Bốn");
				break;
			case 5:
				System.out.print("Năm");
				break;
			case 6:
				System.out.print("Sáu");
				break;
			case 7:
				System.out.print("Bảy");
				break;
			case 8:
				System.out.print("Tám");
				break;
			case 9:
				System.out.print("Chín");
				break;
		}
	}
}



