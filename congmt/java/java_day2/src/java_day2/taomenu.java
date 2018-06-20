package java_day2;
import java.util.Scanner;


public class taomenu {
	public static Scanner myScanner=new Scanner(System.in);
	private static Scanner sc;
	private static Scanner sc2;
	private static Scanner sc3;
	private static Scanner sc4;
	public static void main(String args[]){
		
		myMenu(args);
		}
	public static void myMenu(String args[]){
		//quanly ql = new quanly();
		while(true) {
			
				System.out.println("+-----------------------------------------+");
				System.out.println("+--------------------MENU-----------------+");
				System.out.println("+----1. Giải phương trình bậc nhất:-------+");
				System.out.println("+----2. Giải phương trình bậc hai:--------+");
				System.out.println("+----3. Tính tiền điện:-------------------+");
				System.out.println("+----4. Kết thúc!!------------------------+");
				System.out.println("+-----------------------------------------+");
				int input=myScanner.nextInt();
				if (input==1){
					quanly.giaiPtbac1();
				}
				else if(input==2) {
					quanly.phuongtrinhbac2();
				}
				else if(input==3) {
					quanly.tinhtiendien();
				}
				else {
					quanly.ketthuc();
				}
		}
	}
	//			public static void giaiPtbac1() {
//				double a,b;
//				
//				sc = new Scanner(System.in);
//				System.out.println("Nhập giá trị a: ");
//				a= sc.nextDouble();
//				System.out.println("Nhập giá trị b: ");
//				b= sc.nextDouble();
//				if(a==0) {
//					if(b==0) {
//						System.out.println("- Phương trình có vô số nghiệm.");
//					}
//					else {
//						System.out.println("- Phương trình vô nghiệm.");
//					}
//				}else {
//					double x= -b/a;
//					System.out.println("- Phương trình có nghiệm là x: " + x);
//				}
//			}
//			public static void phuongtrinhbac2 (String[] args) {
//				double a,b,c, delta;
//				
//				sc2 = new Scanner(System.in);
//				System.out.println("Nhập giá trị a: ");
//				a= sc2.nextDouble();
//				System.out.println("Nhập giá trị b: ");
//				b= sc2.nextDouble();
//				System.out.println("Nhập giá trị c: ");
//				c= sc2.nextDouble();
//				
//				if(a==0) {
//					if(b==0) {
//						if(c==0) {
//						System.out.println("- Phương trình có vô số nghiệm.");
//						}
//						else {
//						System.out.println("- Phương trình vô nghiệm.");
//						}
//					}else {
//					double x1= -b/a;
//					System.out.println("- Phương trình có nghiệm là x: " + x1);
//					}
//				}else {
//					delta = Math.pow(b,2)-4*a*c;
//					if(delta<0) {
//						System.out.println("- Phương trình vô nghiệm.");
//					}
//					else if(delta==0) {
//						double x2=-b/(2*a);
//						System.out.println("- Phương trình có nghiệm kép x= " + x2);
//					}
//					else {
//					double	x3= (-b + Math.sqrt(delta))/(2*a);
//					double	x4= (-b - Math.sqrt(delta))/(2*a);
//					System.out.println("Phương trình có 2 nghiệm phân biệt x1 ="  + x3 + " và x2 = " + x4);
//					}
//					
//				}
//			}
//			public static void tinhtiendien(String args[]){
//				int chu, tien;
//				sc3 = new Scanner(System.in);
//				System.out.print("- Số chữ điện dùng trong tháng là:");
//				chu=sc3.nextInt();
//				if(chu<50) {
//					 tien=chu*1000;
//				}
//				else {
//					 tien=50*1000 + (chu - 50)*1200;
//				}
//				System.out.println("- Số tiền phải trả trong tháng là: " + tien + "đồng.");
//				System.out.println("");
//				
//			}
//			public static void ketthuc(String args[]) {
//				sc4 = new Scanner(System.in);
//				System.out.println("- Chương trình kết thúc!!");
//			
//	
//	}
	private static void quanly() {
		// TODO Auto-generated method stub
		
	}
}
