package quanly_nhatro;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args)

	{

		Scanner sc = new Scanner(System.in);

		ArrayList<KhachSan> ds;

		int n;

		System.out.print("Nhap so luong khach tro: ");

		n = sc.nextInt();
		sc.nextLine();

		ds = new ArrayList<KhachSan>(n);

		KhachSan b;

		for (int i = 0; i < n; i++)

		{

			b = new KhachSan();

			b.nhapThongTin(sc);

			ds.add(b);

		}

		System.out.println("Danh sach khach tro: ");

		for (int i = 0; i < ds.size(); i++)

			ds.get(i).hienThongTin();

		String tim;

		System.out.print("Nhap so chung minh nhan dan cua khach hang can thanh toan: ");

		tim = sc.nextLine();

		for (int i = 0; i < ds.size(); i++)

			if (ds.get(i).getKhach().getSCMND().equalsIgnoreCase(tim))

				System.out.println("Tien phai thanh toan: " + ds.get(i).thanhTien());

	}
}
