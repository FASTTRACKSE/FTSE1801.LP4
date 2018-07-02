
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Bai4 {
	public static void main(String[] args) throws IOException {
		// Ghi mang doi tuong vao file nhanvien.bin
		FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.bin");
		ObjectOutputStream object = new ObjectOutputStream(fileOutputStream);
		Nhanvien[] stocks = { new Nhanvien("Mai Thanh Cong", 01203103324, "201654076", "mtc0993@gmail.com\n"),
				new Nhanvien("Mai Thanh Cong1", 01203103325, "201654077", "mtc09933@gmail.com\n"),
				new Nhanvien("Mai Thanh Cong2", 01203103326, "201654077", "mtc09934@gmail.com")

		};
		// Dong luong du lieu
		object.writeObject(stocks);
		object.close();

	}
}
