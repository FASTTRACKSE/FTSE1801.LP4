package mayATM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

public class ProgramATM {

	public ProgramATM() {
	}

	public void login(String id, String pin) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader("TheTu.dat");
			bufferedReader = new BufferedReader(fileReader);
			String line;
			boolean flagSuccess = false;
			while ((line = bufferedReader.readLine()) != null) {
				if (id.equals(line.split(",")[0]) && pin.equals(line.split(",")[1])) {
					File file = new File(line.split(",")[0] + ".dat");
					if (file.exists()) {
						System.out.println("Dang nhap thanh cong");
						flagSuccess = true;

						break;
					} else {
						break;

					}

				}

			}
			if (flagSuccess) {
				System.out.println("Sai ma Pin");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		} catch (Exception e) {

		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (Exception e) {
				System.out.println("loi roi");
			}

		}

	}

	public void withDrama(String id, double moneyDrama) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		FileWriter fileWriter = null;
		try {
			fileReader = new FileReader(id + ".dat");
			bufferedReader = new BufferedReader(fileReader);
			String name = bufferedReader.readLine();
			double money = Double.parseDouble(bufferedReader.readLine());
			String typeMoney = bufferedReader.readLine();
			String status = bufferedReader.readLine();

			if (money <= 0) {
				System.out.println("Khong co tien trong tai khoan");
			} else if (moneyDrama > money) {
				System.out.println("Tien trong tai khoan khong du thuc hien giao dich");
			} else {
				money = money - moneyDrama;
				System.out.println("Rut tien thanh cong");
			}

			fileWriter = new FileWriter(new File(id + ".dat"));
			fileWriter.write(name + "\n");
			fileWriter.write(money + "\n");
			fileWriter.write(typeMoney + "\n");
			fileWriter.write(status + "\n");
			System.out.println("ten tai khoan: " + name);
			System.out.println("so tien trong tai khoan: " + money);
			System.out.println("loai tien: " + typeMoney);

		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		} catch (Exception e) {
			System.out.println("loi roi");
		} finally {
			try {
				fileWriter.close();
				bufferedReader.close();
				fileReader.close();
			} catch (Exception e) {
				System.out.println("loi roi");
			}

		}

	}

	public void logtranssaction(String id, Date date) {

	}

	public static void main(String[] args) {

	}

}
