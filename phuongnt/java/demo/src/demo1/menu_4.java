package demo1;
import java.util.Scanner;

public class menu_4 {
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		myMenu();
	}
	public static void myMenu() {
		while (true) {
			System.out.println("+------------------------+");
			System.out.println("1. Giải phương trình bậc 1");
			System.out.println("2. Giải phương trình bậc 2");
			System.out.println("3. Tính tiền điện");
			System.out.println("4. Kết thúc");
			System.out.println("+------------------------+");
			System.out.println("Lựa chọn chức năng bạn muốn: ");
			
			int myOption = myScanner.nextInt();
			
			if (myOption == 1) {
				giaiPTB1();
			} else if (myOption == 2) {
				giaiPTB2();
			} else if (myOption == 3) {
				tinhtiendien();
			} else if (myOption == 4) {
				ketthuc();
			}
		}
	}
	
	public static void giaiPTB1() {
		double a, b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập giá trị a: ");
		a= sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b= sc.nextDouble();
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm");
			}
		}else {
			double x=-b/a;
			System.out.println("Phương trình có nghiệm x="+x);
		}
	}
	
	public static void giaiPTB2() {
int a,b,c;
double delta;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a= sc.nextInt();
		
		System.out.println("Nhập giá trị b: ");
		b= sc.nextInt();
		System.out.println("Nhập giá trị c: ");
		c= sc.nextInt();
		
		if(a==0) {
			if(b==0) {
				if(c==0) {
				System.out.println("- Phương trình có vô số nghiệm.");
				}
				else {
				System.out.println("- Phương trình vô nghiệm.");
				}
			}else {
			double x1= -b/a;
			System.out.println("- Phương trình có nghiệm là x: " + x1);
			}
		}else {
			delta = Math.pow(b,2)-4*a*c;
			if(delta<0) {
				System.out.println("- Phương trình vô nghiệm.");
			}
			else if(delta==0) {
				double x2=-b/(2*a);
				System.out.println("- Phương trình có nghiệm kép x= " + x2);
			}
			else {
			double	x3= (-b + Math.sqrt(delta))/(2*a);
			double	x4= (-b - Math.sqrt(delta))/(2*a);
			System.out.println("Phương trình có 2 nghiệm phân biệt x1 ="  + x3 + " và x2 = " + x4);
			}
		}
	}
	
	public static void tinhtiendien() {
		Scanner sc= new Scanner(System.in);
		double sodien;
		System.out.print("Số điện= ");
		sodien= sc.nextDouble();
		if(sodien>=50) {
			System.out.println("Số tiền= "+ ((50*1000 +(sodien-50)*1200)));
		}else {
			System.out.println("Số tiền= "+(sodien*1000));
		}
	}
	
	public static void ketthuc() {
		System.out.println("Chương trình kết thúc!!!");
	}
}
    