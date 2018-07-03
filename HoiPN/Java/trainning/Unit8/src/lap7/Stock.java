package lap7;

import java.io.Serializable;

public class Stock implements Serializable {
	private String name;
	private String mail;
	private int phone;
	private int cmnd;
	public Stock(String name, String mail, int phone, int cmnd) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.cmnd = cmnd;
	}
	
	public String toString() {
		return (name +" "+mail+" "+phone+" "+cmnd);
	}
	
}
