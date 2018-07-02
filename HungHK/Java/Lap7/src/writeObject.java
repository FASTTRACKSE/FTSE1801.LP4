import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class writeObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("nhanVien.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		NhanVien[] nhanVien = {
				new NhanVien("Huynh Khanh Hung", "huynhkhanhhungdn@gmail.com", "0905817810", "201568599"),
				new NhanVien("Nguyen Tuan Phuong", "nguyentuanphuongdn@gmail.com", "01202581510", "201868479"),
				new NhanVien("Ho Tan Hieu", "hotanhieuqn@gmail.com", "0985783433", "201985890")
		};
		oos.writeObject(nhanVien);
		oos.close();
	}
}
