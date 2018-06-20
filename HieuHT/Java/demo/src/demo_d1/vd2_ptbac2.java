package demo_d1;
import java.util.Scanner;
import java.util.function.LongToIntFunction;
public class vd2_ptbac2 {
	public static void main(String[] args) {
		double a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextDouble();
		System.out.println("Nhập giá trị c: ");
		c = sc.nextDouble();
		if(a==0) {
			if((b==0)&&(c==0)) {
				System.out.println("Phương trình có vô số nghiệm");
			}else if((b==0)&&(c!=0)) {
				System.out.println("Phương trình vô nghiệm");
			}else {
				double z = -c/b;
				System.out.println("Phương trình có nghiệm= " + z);
			}
		}else {
			double dt=b*b-4*a*c;
			double x =(-b + Math.sqrt(dt))/(2*a);
			double y =(-b - Math.sqrt(dt))/(2*a);
			if (dt < 0) {
				System.out.println("Phương trình vô nghiệm");
			}else if (dt == 0) {
				System.out.println("Phương trình có nghiệm kép= " + -b/(2*a));
			}else if(dt > 0){
				System.out.println("Có hai nghiệm phân biệt" + x+" " + y);
			}
		}
	}
}
