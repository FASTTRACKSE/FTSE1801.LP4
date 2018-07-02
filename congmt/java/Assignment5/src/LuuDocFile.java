
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Doc luu file class
 * @author CongMT
 *
 */
public class LuuDocFile {
	// Luu file
	public static boolean luuFile(ArrayList<CanBo> dsNhanVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dsNhanVien);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	// Doc file
	@SuppressWarnings("unchecked")
	public static ArrayList<CanBo>docFile(String path){
		ArrayList<CanBo>dsNhanVien = new ArrayList<CanBo>();
		try {
			
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			dsNhanVien= (ArrayList<CanBo>) data;
			ois.close();
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

}