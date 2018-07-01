import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3 {
	public static void main(String[] args) throws IOException {
		
//	
//	String a = "Mai Thành Công";
//	System.out.println(new String(a.toUpperCase()).toLowerCase());
//	System.out.println(a.length());
//	System.out.println(a.trim().length());
//	System.out.println(a.length());
//	System.out.println(a);
//	String b ="1234567890";
//	System.out.println(b.substring(2));
//	System.out.println(b.substring(2, 7));
//	System.out.println(b.charAt(3));
//	System.out.println(b.replaceAll("2", "cong"));
//	String c=" Mai Thanh Cong";
//	String[] a1= c.split(" ");
//	String[] a2= c.split("Cong");
//	for(String x :a1) {
//		System.out.println(x);
//	}
//	System.out.println("---------");
//	for(String x :a2) {
//		System.out.println(x);
//	}
//	String d="Trần   Đai   Hải";
//	System.out.println(d.replaceAll("   ", " "));
//	String d1="trần đại hải";
//	System.out.println(new String(d1.toUpperCase()));
	
	FileOutputStream fileOutputStream= new FileOutputStream("abc.dat");
	DataOutputStream doc= new DataOutputStream(fileOutputStream);
	int number=5;
	doc.writeInt(number);
	for(int i=0;i<=number;i++) {
		doc.writeInt(i);
	}
	doc.writeUTF("Hello Cong");
	doc.writeDouble(123.32);
	// dong luong
	doc.close();
	fileOutputStream.close();
//	String text= "Xin chao Mai Thanh Cong\n Cong khong chao lai";
//	byte[] text1=text.getBytes();
//	fileOutputStream.write(text1);
//	fileOutputStream.close();
//	
	FileInputStream fileOutputStream1= new FileInputStream("abc.dat");
	DataInputStream read= new DataInputStream(fileOutputStream1);
	int number1= read.readInt();
	System.out.println(number);
	for(int i=0; i<=number1;i++) {
		System.out.println(read.readInt());
	}
	System.out.println(read.readUTF());
	System.out.println(read.readDouble());
	read.close();
//	int d;
//	while((d= fileOutputStream1.read()) !=-1) {
//		System.out.print((char) d);
//	}
//	fileOutputStream1.close();
	
//	for(String x :d1) {
//		
//	}
//		System.out.println(x);
//	Scanner sc=new Scanner(System.in);
//	while(true) {
//		System.out.println("moi nhap so:");
//		String nuberPhone= sc.nextLine();
//		String pattern= "0[0-9]{9,10}";
////		String pattern= "0\\9{9,10}";
//		if(nuberPhone.matches(pattern)) {
//			System.out.println(nuberPhone + ": So dien thoai nay co the dung.");
//			}
//			else {
//				System.out.println("Sai cm no so roi!");
//				sc.close();
//			}
//		System.out.println("moi nhap bien so xe:");
//		String bienso= sc.nextLine();
//		String bienSo="43-[A-Z]\\d-((\\d{4})|(\\d{3}\\.\\d{2}))";
//		if(bienso.matches(bienSo)) {
//			System.out.println("Bien so xe da nang la:" + bienso);
//			}
//			else {
//				System.out.println("Sai cm no so roi roi!");
//				sc.close();
//			}
//		
//	}
	}
}
