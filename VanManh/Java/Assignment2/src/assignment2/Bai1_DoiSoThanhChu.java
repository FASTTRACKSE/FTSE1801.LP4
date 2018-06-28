package assignment2;

import java.util.Scanner;

public class Bai1_DoiSoThanhChu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập 1 số nhiều nhất có 4 chữ số: ");
		int n = input.nextInt();
		input.close();
		int ng = n / 1000;
		int tr = (n % 1000) / 100;
		int ch = ((n % 1000) % 100) / 10;
		int dv = n % 10;
		String s = String.valueOf(n);
		int l = s.length();
		if (l == 4) {
			switch (ng) {
			case 1:
				System.out.print("Một ngàn ");
				break;
			case 2:
				System.out.print("Hai ngàn ");
				break;
			case 3:
				System.out.print("Ba ngàn ");
				break;
			case 4:
				System.out.print("Bốn ngàn ");
				break;
			case 5:
				System.out.print("Năm ngàn ");
				break;
			case 6:
				System.out.print("Sáu ngàn ");
				break;
			case 7:
				System.out.print("Bảy ngàn ");
				break;
			case 8:
				System.out.print("Tám ngàn ");
				break;
			case 9:
				System.out.print("Chín ngàn ");
				break;
			}

			switch (tr) {
			case 0:
				System.out.print("không trăm ");
				break;
			case 1:
				System.out.print("một trăm ");
				break;
			case 2:
				System.out.print("hai trăm ");
				break;
			case 3:
				System.out.print("ba trăm ");
				break;
			case 4:
				System.out.print("bốn trăm ");
				break;
			case 5:
				System.out.print("năm trăm ");
				break;
			case 6:
				System.out.print("sáu trăm ");
				break;
			case 7:
				System.out.print("bảy trăm ");
				break;
			case 8:
				System.out.print("tám trăm ");
				break;
			case 9:
				System.out.print("chín trăm ");
				break;
			}

			if (ch == 1) {
				switch (ch) {
				case 1:
					System.out.print("mười ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("một.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("bốn.");
					break;
				case 5:
					System.out.print("lăm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			} else if (ch == 0) {
				switch (ch) {
				case 0:
					System.out.print("lẻ ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("một.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("bốn.");
					break;
				case 5:
					System.out.print("năm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			} else {
				switch (ch) {
				case 2:
					System.out.print("hai mươi ");
					break;
				case 3:
					System.out.print("ba mươi ");
					break;
				case 4:
					System.out.print("bốn mươi ");
					break;
				case 5:
					System.out.print("năm mươi ");
					break;
				case 6:
					System.out.print("sáu mươi ");
					break;
				case 7:
					System.out.print("bảy mươi ");
					break;
				case 8:
					System.out.print("tám mươi ");
					break;
				case 9:
					System.out.print("chín mươi ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("mốt.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("tư.");
					break;
				case 5:
					System.out.print("lăm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			}
		} else if (l == 3) {
			switch (tr) {
			case 1:
				System.out.print("Một trăm ");
				break;
			case 2:
				System.out.print("Hai trăm ");
				break;
			case 3:
				System.out.print("Ba trăm ");
				break;
			case 4:
				System.out.print("Bốn trăm ");
				break;
			case 5:
				System.out.print("Năm trăm ");
				break;
			case 6:
				System.out.print("Sáu trăm ");
				break;
			case 7:
				System.out.print("Bảy trăm ");
				break;
			case 8:
				System.out.print("Tám trăm ");
				break;
			case 9:
				System.out.print("Chín trăm ");
				break;
			}

			if (ch == 1) {
				switch (ch) {
				case 1:
					System.out.print("mười ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("một.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("bốn.");
					break;
				case 5:
					System.out.print("lăm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			} else if (ch == 0) {
				switch (ch) {
				case 0:
					System.out.print("lẻ ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("một.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("bốn.");
					break;
				case 5:
					System.out.print("năm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			} else {
				switch (ch) {
				case 2:
					System.out.print("hai mươi ");
					break;
				case 3:
					System.out.print("ba mươi ");
					break;
				case 4:
					System.out.print("bốn mươi ");
					break;
				case 5:
					System.out.print("năm mươi ");
					break;
				case 6:
					System.out.print("sáu mươi ");
					break;
				case 7:
					System.out.print("bảy mươi ");
					break;
				case 8:
					System.out.print("tám mươi ");
					break;
				case 9:
					System.out.print("chín mươi ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("mốt.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("tư.");
					break;
				case 5:
					System.out.print("lăm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			}
		} else if (l == 2) {
			if (ch == 1) {
				switch (ch) {
				case 1:
					System.out.print("Mười ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("một.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("bốn.");
					break;
				case 5:
					System.out.print("lăm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			} else {
				switch (ch) {
				case 2:
					System.out.print("Hai mươi ");
					break;
				case 3:
					System.out.print("Ba mươi ");
					break;
				case 4:
					System.out.print("Bốn mươi ");
					break;
				case 5:
					System.out.print("Năm mươi ");
					break;
				case 6:
					System.out.print("Sáu mươi ");
					break;
				case 7:
					System.out.print("Bảy mươi ");
					break;
				case 8:
					System.out.print("Tám mươi ");
					break;
				case 9:
					System.out.print("Chín mươi ");
					break;
				}
				switch (dv) {
				case 1:
					System.out.print("mốt.");
					break;
				case 2:
					System.out.print("hai.");
					break;
				case 3:
					System.out.print("ba.");
					break;
				case 4:
					System.out.print("tư.");
					break;
				case 5:
					System.out.print("lăm.");
					break;
				case 6:
					System.out.print("sáu.");
					break;
				case 7:
					System.out.print("bảy.");
					break;
				case 8:
					System.out.print("tám.");
					break;
				case 9:
					System.out.print("chín.");
					break;
				}
			}
		} else if (l == 1) {
			switch (dv) {
			case 0:
				System.out.println("Không");
				break;
			case 1:
				System.out.print("Một.");
				break;
			case 2:
				System.out.print("Hai.");
				break;
			case 3:
				System.out.print("Ba.");
				break;
			case 4:
				System.out.print("Bốn.");
				break;
			case 5:
				System.out.print("Năm.");
				break;
			case 6:
				System.out.print("Sáu.");
				break;
			case 7:
				System.out.print("Bảy.");
				break;
			case 8:
				System.out.print("Tám.");
				break;
			case 9:
				System.out.print("Chín.");
				break;
			}
		}
	}
}
