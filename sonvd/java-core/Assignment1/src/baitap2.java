import java.util.Scanner;

public class baitap2 {
	public static void main(String[] args) {
		double a, b, c;
		
		Scanner input = new Scanner (System.in);
		System.out.println("Nhập a: ");
		a = input.nextDouble();
		System.out.println("Nhập b: ");
		b = input.nextDouble();
		System.out.println("Nhập c: ");
		c = input.nextDouble();
		input.close();
		
		//Giá trị lớn nhất, nhỏ nhất
		double x1 = Math.min(a, Math.min(c, b));
		double x2 = Math.max(a, Math.max(c, b));
		System.out.println("Giá trị lớn nhất " +x2+"\n"+"Giá trị nhỏ nhất" +x1);
		//Tính lũy thừa n
		double x3 = Math.pow(a, 2);
		System.out.println("Tính lũy thừa 2 của "+a+" là: "+x3);
		//Tính căn bậc 2
		double x4 = Math.sqrt(a);
		System.out.println("Căn bậc 2 của "+a+" là "+ x4);
		//Giá trị tuyệt đối
		double x5 = Math.abs(a);
		System.out.println("Giá trị tuyệt đối của "+a+" là: "+x5);
		//Lấy số nguyên trên của a
		double x6 = Math.ceil(a);
		System.out.println("Số nguyên trên của "+a+" là: "+x6);
		//Lấy số nguyên dưới của a
		double x7 = Math.floor(a);
		System.out.println("Số nguyên dưới của "+a+" là: "+x7);
		//Làm tròn số của a
		double x8 = Math.round(a);
		System.out.println("Làm tròn số "+a+" là: "+x8);
		//Sinh số ngẫu nhiên từ 0 đến 1
		double x9 = Math.random();
		System.out.println("Sinh số ngẫu nhiên từ 0 đến 1 "+x9);
	}
}
