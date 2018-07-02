import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai2 {
public static void main(String[] args) throws IOException {
	FileOutputStream fileOutputStream= new FileOutputStream("nhanvien.txt");
	String text= "Ten: Mai Thanh Cong\n Sdt: 01023103324\n CMND: 201654076\n Email:mtc0993@gmail.com ";
	byte[] text1=text.getBytes();
	fileOutputStream.write(text1);
	fileOutputStream.close();

	
}
}
