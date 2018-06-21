import java.util.Scanner;


public class Assignment1_b2 {


	public static void main(String[] args) {
		int a,b,x,y;
		Scanner sc=new Scanner(System.in);
		System.out.println("- Nháº­p sá»‘ a: ");
		a= sc.nextInt();
		System.out.println("- Nháº­p sá»‘ b: ");
		b= sc.nextInt();
		x=Math.min(a, b);
		y=Math.max(a, b);
		double x1= Math.pow(a,3);
		double x2=Math.sqrt(a);
		int x3=Math.abs(a);
		double x4=Math.ceil(a);
		double x5=Math.floor(a);
		int x6=Math.round(a);
		double x7=Math.random();
		double x8 = Math.toRadians(a);
	    double x9 = Math.toRadians(b);
		

	     
		
		System.out.println("- Sá»‘ nhá»� nháº¥t trong 2 sá»‘ lÃ : " + x);
		System.out.println("- Sá»‘ lá»›n nháº¥t trong 2 sá»‘ lÃ : " + y);
		System.out.println("- LÅ©y thá»«a cá»§a sá»‘ a lÃ : " + x1);
		System.out.println("- CÄƒn báº­c 2 cá»§a a lÃ : " + x2);
		System.out.println("- GiÃ¡ trá»‹ tuyá»‡t Ä‘á»‘i cá»§a a lÃ : " + x3);
		System.out.println("- Sá»‘ nguyÃªn tuyá»‡t Ä‘á»‘i trÃªn a lÃ : " + x4);
		System.out.println("- Sá»‘ nguyÃªn tuyá»‡t Ä‘á»‘i dÆ°á»›i a lÃ : " + x5);
		System.out.println("- LÃ m trÃ²n sá»‘ a lÃ : " + x6);
		System.out.println("- Sinh sá»‘ ngáº«u nhiÃªn tá»« a Ä‘áº¿n blÃ : " + x7);
		System.out.println("- Math.cbrt(" + a + ")=" + Math.cbrt(a));
	    System.out.println("- Math.cbrt(" + b + ")=" + Math.cbrt(b));
	    System.out.println("- Math.abs(" + a + ")=" + Math.abs(a));
	    System.out.println("- Math.abs(" + b + ")=" + Math.abs(b));
	    System.out.println("- Math.log(" + a + ")=" + Math.log(a));
	    System.out.println("- Math.log(" + b + ")=" + Math.log(b));
	    System.out.println("- Math.log10(" + a + ")=" + Math.log10(a));
	    System.out.println("- Math.log1p(" + a + ")=" + Math.log1p(a));
	    System.out.println("- Math.max(" + a + "," + b + ")=" + Math.max(a, b));
	    System.out.println("- Math.hypot(" + a + "," + b + ")=" + Math.hypot(a, b));
	    System.out.println("- Math.cosh(" + a + ")=" + Math.cosh(a));
	    System.out.println("- Math.cosh(" + b + ")=" + Math.cosh(b));
	    System.out.println("- Math.cos(" + x8 + ")=" + Math.cos(x8));
	    System.out.println("- Math.cos(" + x9 + ")=" + Math.cos(x9));
	    System.out.println("- Math.exp(" + a + ")=" + Math.exp(a));
	    System.out.println("- Math.exp(" + b + ")=" + Math.exp(b));
	    System.out.println("- Math.min(" + a + "," + b + ")=" + Math.min(a, b));
	}
}

