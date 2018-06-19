package menu;

//import java.util.Scanner;

public class giai_PT1 {
	public static String giai_PTbac1(double a, double b){
//		double a,b;
		//Nhập giá trị từ bàn phím
//		Scanner input = new Scanner(System.in);
//		
//		System.out.print("Nhập giá trị a:");
//		a = input.nextDouble();
//		
//		System.out.print("Nhập giá trị b:");
//		b = input.nextDouble();
//		input.close();
		if(a==0) {
			if(b==0) {
				return "Phương trình vô số nghiệm";
			}else {
				return "Phương trình vô nghiệm";
			}
		}else {
			double x = -b/a;
			String s = String.valueOf(x);
			return s;
		}
	}
	
}
