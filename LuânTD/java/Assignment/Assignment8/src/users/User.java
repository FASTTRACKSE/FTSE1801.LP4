package users;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	TheTu theTu;
	private String ID;
	private String accountName;
	private String accountBalance;
	private String typeMoney;
	private String accountStatus;
	int j = 0;

	public User() {

	}

	public User(String ID, String accountName, String accountBalance, String typeMoney, String accountStatus) {
		this.ID = ID;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.typeMoney = typeMoney;
		this.accountStatus = accountStatus;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getTypeMoney() {
		return typeMoney;
	}

	public void setTypeMoney(String typeMoney) {
		this.typeMoney = typeMoney;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public void addUser() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("TheTu.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		TheTu[] theTu = (TheTu[]) objectInputStream.readObject();
		
		User user1 = new User(theTu[0].getAccountCode(), "Tran Duy Luan", "500000", "VND", "Unlook");

		User user2 = new User(theTu[1].getAccountCode(), "Vu Van Manh", "600000", "VND", "Unlook");

		User user3 = new User(theTu[2].getAccountCode(), "Mai Thanh Cong", "700000", "VND", "Unlook");

		objectInputStream.close();
		fileInputStream.close();
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		fos = new FileOutputStream("ID1.dat");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(user1);
		oos.close();
		fos.close();

		fos = new FileOutputStream("ID2.dat");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(user2);
		oos.close();
		fos.close();

		fos = new FileOutputStream("ID3.dat");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(user3);
		oos.close();
		fos.close();

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		User user = new User();
		user.addUser();
	}

}
