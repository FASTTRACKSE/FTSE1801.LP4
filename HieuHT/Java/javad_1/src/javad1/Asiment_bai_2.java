package javad1;

import java.util.Scanner;


public class Asiment_bai_2 {
	public static void main(String[]args) {
		//khai báo biến
		double a, b, x;
		//nhập giá trị từ bàn phím
		Scanner sc = new Scanner(System.in);
		System.out.print("nhâp giá trị a : ");
		a = sc.nextDouble();
		System.out.print("nhâp giá trị b : ");
		b = sc.nextDouble();
		//phần gắn giá trị
		//giá trị nhỏ nhất
	    x = Math.min(a, b);
	    System.out.println("giá trị nhỏ nhất : "+x);
	    //giá trị lớn nhất
	    x = Math.max(a, b);
	    System.out.println("giá trị lớn nhất : "+x);
	    //Tính lũy thừa
	    x = Math.pow(a, b);
	    System.out.println("a lũy thừa mủ b : "+x);
	    //tính căn bậc 2
	    x = Math.sqrt(a);
	    System.out.println("Căn bậc 2 của a : "+x);
	    //giá trị tuyệt đối
	    x = Math.abs(a);
	    System.out.println("giá trị tuyệt đối của a : "+x);
	    //lấy số nguyên trên của a
	    x = Math.ceil(a);
	    System.out.println("giá trị nguyên trên của a : "+x);
	    //lấy số nguyên dưới của a
	    x = Math.floor(a);
	    System.out.println("Giá trị nguyên dưới của a : "+x);
	    //làm tròn số của a
	    x = Math.round(a);
	    System.out.println("làm tròn số a  : "+x);
	    //Sinh số ngẫu nhiên từ 0 đến 1
	    x = Math.random();
	    System.out.println("Sinh số ngẫu nhiên : "+x);
	    //tích cos của b;
	    x = Math.cos(b);
	    System.out.println("giá trị cos của b : "+x);
	    //tính sin của b
	    x = Math.sin(b);
	    System.out.println("giá trị cos của b : "+x);
	    //tính căn bậc 3 của a
	    x = Math.cbrt(a);
	    System.out.println("giá trị căn bậc 3 của a : "+x);
	    //tính cơ số 10 của a
	    x = Math.log(a);
	    System.out.println("giá trị cơ số 10 của a : "+x);
	    //
	    // khai biến
	    int c, d, y;
	    //găn giá trị
	    System.out.print("nhập giá trị c : ");
	    c = sc.nextInt();
	    System.out.print("nhập giá trị d : ");
	    d = sc.nextInt();
	    // tính tích 2 số c và d
	    y = Math.multiplyExact(c, d);
	    System.out.println("tích 2 số c và d : "+y);
	    //tính hiệu 2 số c và d
	    y = Math.subtractExact(c, d);
	    System.out.println("Hiệu 2 số c và d : "+y);
	    //trả về c + 1
	    y = Math.incrementExact(c);
	    System.out.println("trả về giá trị c + 1 : "+y);
	    // trả về giá trị c-1
	    y = Math.decrementExact(c);
	    System.out.println("trả về giá trị c - 1 : "+y);
	    
	    
	    
	    
	    
	}

}
