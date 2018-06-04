import java.util.Scanner;

public class Lap1 {
	public static void main(String[]args) {
		String  hoTen;
		double  LP1, LP2, Lp3, diemTB;
		
		
		Scanner myInput = new Scanner(System.in);
		System.out.print("Họ và tên: "); 
		hoTen = myInput.nextLine();
		System.out.println("- Nhập Lp1 : ");
		LP1= myInput.nextInt();
		System.out.println("- Nhập Lp2 : ");
		LP2= myInput.nextInt();
		System.out.println("- Nhập Lp3 : ");
		Lp3= myInput.nextInt();
		diemTB= (LP1 + LP2 + Lp3)/3;
		//System.out.print("Điểm TB: "+);
		//diemTB = myInput.nextDouble();
		System.out.println("<< " + hoTen + ">>");	
		System.out.println("" + diemTB);

	}
	

}
