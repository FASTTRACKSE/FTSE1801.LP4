package dongvat;

import java.util.Scanner;

public class mainDongVat {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Nhen nhen=new Nhen();
	System.out.println("- Nhâp tên động vật:");
	System.out.println("- Có ten là:");
	String ten=sc.nextLine();
	nhen.setTen(ten);
	
//	nhen.setTen("M�o");
//	nhen.setSoChan(5);
//	nhen.setSoMat(10);
//	nhen.setTiengKeu("meo meo");
	nhen.in();
	Ca ca=new Ca("Cá", 4, 2, 0, "Bộp bộp");
	ca.in();
	Cua cua=new Cua("Cua", 2, 6, 2, "cua cua");
	cua.in();
	Meo meo=new Meo("Mèo", 8, 4, "Gao gao", 2);
	meo.in();
}
}
