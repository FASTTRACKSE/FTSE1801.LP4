package lap7;

import java.io.Serializable;

public class nhanvien implements Serializable{
    private String name, email, number, CNMD;
     
    

	public nhanvien(String name, String email, String number, String cNMD) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		CNMD = cNMD;
	}
    public void xuat() {
    	System.out.print(name + email + number + CNMD);
    }
}
