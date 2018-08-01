import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo3 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutput = new FileOutputStream("file.dat");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutput);
		String text = "Hello word";
		byte[] textByte = text.getBytes();
		fileOutput.write(textByte);
		
		FileInputStream fileInput = new FileInputStream("file.dat");
		int d;
		while((d = fileInput.read()) != -1) {
			System.out.print((char) d);
		}
		fileInput.close();
//		int number = 5;
//		dataOutputStream.writeInt(number);
//		for(int i = 0;i<number;i++) 
//			dataOutputStream.writeInt(i);
//		dataOutputStream.writeUTF("Vui hơn");
//		dataOutputStream.writeDouble(123.34);
//		
//		dataOutputStream.close();
//		fileOutput.close();
//		
//		FileInputStream fileInput = new FileInputStream("file.dat");
//		DataInputStream dataInputStream = new DataInputStream(fileInput);
//		
//		int rNumber = dataInputStream.readInt();
//		System.out.println(rNumber);
//		for(int i = 0;i<rNumber;i++) {
//			System.out.println(dataInputStream.readInt());
//		}
//		System.out.println(dataInputStream.readUTF());
//		System.out.println(dataInputStream.readDouble());
//		
//		dataInputStream.close();
//		dataInputStream.close();
//		
		
	}

}
