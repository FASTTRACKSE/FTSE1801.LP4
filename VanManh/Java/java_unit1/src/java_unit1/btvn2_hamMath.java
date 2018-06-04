package java_unit1;

public class btvn2_hamMath {
	public static void main(String[] args) {
		double a ,b ,c;
		a=9;
		b=1.5;
		c=-8;
		
		//lấy số nhỏ nhất của a và b và c;
		double x = Math.min(a, Math.min(c, b));
		//Lấy số lớn nhất của a,b,c
		double x1 = Math.max(a, Math.max(c, b));
		//Tính a mũ 3
		double x2 = Math.pow(a,3);
		//Tính căn bậc 2 của a
		double x3 = Math.sqrt(a);
		//lấy giá trị tuyệt đối của c
		double x4 = Math.abs(c);
		//Lấy số nguyên trên của b
		double x5 = Math.ceil(b);
		//Lấy số nguyên phần dưới của b	
		double x6 = Math.floor(b);
		//Làm tròn số của b
		double x7 = Math.round(b);
		//Sinh số ngẫu nhiên từ 0 đến 1
		double x8 = Math.random();
		//Chuyển đổi một góc được đo bằng độ thành một góc tương đương xấp xỉ tính theo radian.
		double x9 = Math.toRadians(b);
		//Chuyển đổi một góc được đo bằng radian thành một góc xấp xỉ tương đương được đo bằng độ.
		double x10 = Math.toDegrees(b);
		//Trả về căn bậc 2 ( a^2  + b^2 ) mà không có tràn hoặc tràn trung gian.
		double x11 = Math.hypot(a,b);
		//Trả về logarit tự nhiên (cơ số e ) của một double giá trị.
		double x12 = Math.log(a);
		//Trả về logarit cơ số 10 của một doublegiá trị.
		double x13 = Math.log10(a);
		//Trả về doublegiá trị gần nhất về giá trị cho đối số và bằng một số nguyên toán học.
		double x14 = Math.rint(b);
		//Trả về hàm signum của đối số; không nếu đối số bằng 0,1 nếu đối số lớn hơn 0, -1.0 nếu đối số nhỏ hơn 0.
		double x15 = Math.signum(a);
		//Trả về sin lượng giác của một góc.
		double x16 = Math.sin(a);
		//Trả về sin hyperbol của một doublegiá trị.
		double x17 = Math.sinh(a);
		//Trả về tang lượng giác của một góc.
		double x18 = Math.tan(a);
		//Trả về tang hyperbol của một doublegiá trị.
		double x19 = Math.tanh(a);
		//Trả về giá trị dấu phẩy động liền kề dtheo hướng của vô cực dương.
		double x20 = Math.nextUp(b);
	}
}
