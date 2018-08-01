package users;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TheTu implements Serializable {

	private static final long serialVersionUID = 1L;
	private String accountCode;
	private String pinCode;

	public TheTu() {
	}

	public String getAccountCode() {
		return accountCode;
	}

	public String getPinCode() {
		return pinCode;
	}

	public TheTu(String accountCode, String pinCode) {
		this.accountCode = accountCode;
		this.pinCode = pinCode;
	}

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("TheTu.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TheTu[] theTu = { new TheTu("12345678901011", "123456"), new TheTu("12345678901012", "234561"),
				new TheTu("12345678901013", "345612") };
		oos.writeObject(theTu);

		oos.close();
		fos.close();

	}

}
