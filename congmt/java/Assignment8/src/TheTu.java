import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class TheTu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String maTaiKhoan;
	private String maPin;

	private ArrayList<TheTu> listThe;

	public TheTu() {
		listThe = new ArrayList<TheTu>();
	}

	public TheTu(String maTaiKhoan, String maPin) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.maPin = maPin;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getMaPin() {
		return maPin;
	}

	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}

	
}
