package Assignment7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Tạo file text để ghi và đọc
 * 
 * @author SonVD
 *
 */
public class canBoDAO {
	/**
	 * Tạo file canbo.txt
	 * 
	 * @param listCanBo
	 * @throws IOException
	 */
	public void write(List<CanBo> listCanBo) throws IOException {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("canbo.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(listCanBo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			objectOutputStream.close();
			fileOutputStream.close();
		}
	}

	/**
	 * Đọc file canbo.txt
	 * 
	 * @return listCanbo
	 * @throws IOException
	 */
	public List<CanBo> read() throws IOException {
		List<CanBo> listCanBo = new ArrayList<>();
		CanBo canbo = new CanBo();
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream("canbo.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			listCanBo = (List<CanBo>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			objectInputStream.close();
			fileInputStream.close();
		}
		return listCanBo;
	}
}