import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class readObject {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("nhanVien.bin");
			ois = new ObjectInputStream(fis);
			NhanVien[] nhanVien = (NhanVien[]) ois.readObject();
			System.out.println("Đọc từ file nhanVien.bin và in ra màn hình: \n");
			for (NhanVien nv : nhanVien) {
				System.out.println(nv);
			}
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Co loi: " + e);
		}
	}
}
