package QuanLyTienDien.model.entity;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import QuanLyTienDien.model.BaoCaoDAO;

/**
 * Tính tiền điện lấy dữ liệu từ database
 * 
 * @author SOnVD and HungHK
 *
 */
public class TienDien {
	BaoCaoDAO baoCaoDAO;

	/**
	 * Hiển thị danh sách khách hàng và tính tiền điện
	 * 
	 * @return listdsbc
	 */
	
	public ArrayList<KhachHang> tienDien() {
		baoCaoDAO = new BaoCaoDAO();
		ArrayList<KhachHang> listdsbc = baoCaoDAO.DSKhachHang();

		for (int i = 0; i < listdsbc.size(); i++) {
			Integer soTien = 0;
			if (i == 0) {
				Integer a = Integer.parseInt(listdsbc.get(i).getBienLai().getChiSoCongTo());
				ArrayList<Integer> mang = baoCaoDAO.laySoTien();

				if (0 <= a && a <= 50) {
					soTien = mang.get(0) * a;
				} else if (51 <= a && a <= 100) {
					soTien = 50 * mang.get(0) + (a - 50) * mang.get(1);
				} else if (101 <= a && a <= 200) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + (a - 100) * mang.get(2);
				} else if (201 <= a && a <= 300) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + (a - 200) * mang.get(3);
				} else if (301 <= a && a <= 400) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
							+ (a - 300) * mang.get(4);
				} else if (401 <= a) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
							+ 100 * mang.get(4) + (a - 400) * mang.get(5);
				}
			} else if (i == listdsbc.size()) {
				Integer a = Integer.parseInt(listdsbc.get(i).getBienLai().getChiSoCongTo())
						- Integer.parseInt(listdsbc.get(i - 1).getBienLai().getChiSoCongTo());
				ArrayList<Integer> mang = baoCaoDAO.laySoTien();

				if (0 <= a && a <= 50) {
					soTien = mang.get(0) * a;
				} else if (51 <= a && a <= 100) {
					soTien = 50 * mang.get(0) + (a - 50) * mang.get(1);
				} else if (101 <= a && a <= 200) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + (a - 100) * mang.get(2);
				} else if (201 <= a && a <= 300) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + (a - 200) * mang.get(3);
				} else if (301 <= a && a <= 400) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
							+ (a - 300) * mang.get(4);
				} else if (401 <= a) {
					soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
							+ 100 * mang.get(4) + (a - 400) * mang.get(5);
				}
			} else {
				if (listdsbc.get(i).getMaCongTo().getMaCongTo()
						.equals(listdsbc.get(i - 1).getMaCongTo().getMaCongTo())) {
					Integer a = Integer.parseInt(listdsbc.get(i).getBienLai().getChiSoCongTo())
							- Integer.parseInt(listdsbc.get(i - 1).getBienLai().getChiSoCongTo());
					ArrayList<Integer> mang = baoCaoDAO.laySoTien();

					if (0 <= a && a <= 50) {
						soTien = mang.get(0) * a;
					} else if (51 <= a && a <= 100) {
						soTien = 50 * mang.get(0) + (a - 50) * mang.get(1);
					} else if (101 <= a && a <= 200) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + (a - 100) * mang.get(2);
					} else if (201 <= a && a <= 300) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + (a - 200) * mang.get(3);
					} else if (301 <= a && a <= 400) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
								+ (a - 300) * mang.get(4);
					} else if (401 <= a) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
								+ 100 * mang.get(4) + (a - 400) * mang.get(5);
					}
				} else {
					Integer a = Integer.parseInt(listdsbc.get(i).getBienLai().getChiSoCongTo());
					ArrayList<Integer> mang = baoCaoDAO.laySoTien();

					if (0 <= a && a <= 50) {
						soTien = mang.get(0) * a;
					} else if (51 <= a && a <= 100) {
						soTien = 50 * mang.get(0) + (a - 50) * mang.get(1);
					} else if (101 <= a && a <= 200) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + (a - 100) * mang.get(2);
					} else if (201 <= a && a <= 300) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + (a - 200) * mang.get(3);
					} else if (301 <= a && a <= 400) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
								+ (a - 300) * mang.get(4);
					} else if (401 <= a) {
						soTien = 50 * mang.get(0) + 50 * mang.get(1) + 100 * mang.get(2) + 100 * mang.get(3)
								+ 100 * mang.get(4) + (a - 400) * mang.get(5);
					}
				}
			}
			listdsbc.get(i).setTienDien("" + soTien);
		}
		return listdsbc;
	}
}
