package quanLyATM;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class TheTu implements Serializable {

	private static final long serialVersionUID = 1L;
	private String maSoTK;
	private String maPIN;
	ArrayList<TheTu> listTheTu;

	public TheTu() {
		listTheTu = new ArrayList<TheTu>();
	}

	public String getMaSoTK() {
		return maSoTK;
	}

	public void setMaSoTK(String maSoTK) {
		this.maSoTK = maSoTK;
	}

	public String getMaPIN() {
		return maPIN;
	}

	public void setMaPIN(String maPIN) {
		this.maPIN = maPIN;
	}

	public void themThe(Scanner input) throws IOException {
		boolean kiemTra;
		String maSoTK = null;
		String maPIN = null;
		int tiepTuc = 0;
		String pantterMaTK = "[0-9]{14}";
		String pantterMaPIN = "[0-9]{6}";
		TheTu theTu = new TheTu();

		// Nhap ma so tk
		do {
			do {
				kiemTra = false;
				try {
					System.out.println("Nhap ma so tai khoan : ");
					maSoTK = input.nextLine();
					if (!maSoTK.matches(pantterMaTK)) {
						throw new Exception("Nhap sai ma so tai khoan");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = true;
				}
			} while (kiemTra);

			// Nhap ma PIN
			do {
				kiemTra = false;
				try {
					System.out.println("Nhap ma PIN : ");
					maPIN = input.nextLine();
					if (!maPIN.matches(pantterMaPIN)) {
						throw new Exception("Nhap sai ma PIN");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					kiemTra = true;
				}
			} while (kiemTra);

			//Them the tu vao listTheTu
			theTu.setMaSoTK(maSoTK);
			theTu.setMaPIN(maPIN);
			listTheTu.add(theTu);

			System.out.println("Ban co muon them tiep (1:co | conLai: khong)");
			String tiepTucStr = input.nextLine();
			try {
				tiepTuc = Integer.parseInt(tiepTucStr);
			} catch (NumberFormatException e) {
			}
		} while (tiepTuc == 1);

		FileOutputStream fileOutputStream = new FileOutputStream("TheTu.dat");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(listTheTu);
		
		objectOutputStream.close();
		fileOutputStream.close();
	}
}
